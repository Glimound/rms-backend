package com.glimound.rmsbackend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.glimound.rmsbackend.dto.*;
import com.glimound.rmsbackend.mapper.*;
import com.glimound.rmsbackend.pojo.*;
import com.glimound.rmsbackend.service.ResearchProjectService;
import com.glimound.rmsbackend.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResearchProjectServiceImpl implements ResearchProjectService {

    @Autowired
    private ResearchProjectMapper researchProjectMapper;
    @Autowired
    private ResearcherProjectMapper joinedResearcherMapper;
    @Autowired
    private SuperintendentMapper superintendentMapper;
    @Autowired
    private ProjectCollaboratorMapper projectCollaboratorMapper;
    @Autowired
    private SubtopicMapper subtopicMapper;
    @Autowired
    private ResearchAchievementMapper researchAchievementMapper;
    @Autowired
    private ResearcherAchievementMapper contributorMapper;

    /**
     * 分页查询所有科研项目信息
     */
    @Override
    public ResearchProjectListVo listResearchProject(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<ResearchProject> researchProjectList = researchProjectMapper.selectAll();
        Page<ResearchProject> p = (Page<ResearchProject>) researchProjectList;
        return new ResearchProjectListVo(p.getResult(), p.getTotal());
    }

    /**
     * 查询科研项目信息及子课题（及其负责人）、科研人员、科研成果、委托方、合作方、质量监测方、负责人信息
     */
    @Override
    @Transactional
    public ResearchProjectVo getResearchProjectFullInfo(String projectId) {
        ResearchProjectVo projectInfo = researchProjectMapper.selectProjectInfoById(projectId);
        List<ResearcherProjectVo> researcherList = researchProjectMapper.selectResearcherById(projectId);
        List<SubtopicVo> subtopicList = researchProjectMapper.selectSubtopicById(projectId);
//        List<ResearchAchievementVo> researchAchievementList = researchProjectMapper.selectAchievementById(projectId);
        projectInfo.setResearcherList(researcherList);
        projectInfo.setSubtopicList(subtopicList);
//        projectInfo.setResearchAchievementList(researchAchievementList);
        return projectInfo;
    }

    /**
     * 新增科研项目信息及子课题（及其负责人）、科研人员、科研成果、委托方、合作方、质量监测方、负责人信息
     */
    @Override
    @Transactional
    public void addResearchProjectFullInfo(ResearchProjectDto researchProjectDto) {
        List<ResearcherProjectDto> researcherList = researchProjectDto.getResearcherList();
        SuperintendentDto superintendentDto = researchProjectDto.getSuperintendent();
        List<String> collaboratorNameList = researchProjectDto.getCollaboratorNameList();
        List<SubtopicDto> subtopicDtoList = researchProjectDto.getSubtopicList();
//        List<ResearchAchievementDto> researchAchievementDtoList = researchProjectDto.getResearchAchievementList();

        // 添加项目的负责人
        Superintendent superintendent = new Superintendent();
        BeanUtils.copyProperties(superintendentDto, superintendent);
        superintendentMapper.insert(superintendent);

        // 添加项目基础信息、委托方、质量监测方
        ResearchProject researchProject = new ResearchProject();
        BeanUtils.copyProperties(researchProjectDto, researchProject);
        researchProject.setSuperintendentId(superintendent.getSuperintendentId());
        researchProjectMapper.insert(researchProject);

        // 添加项目拥有的科研人员
        ResearcherProject researcherProject = new ResearcherProject();
        researcherProject.setProjectId(researchProjectDto.getProjectId());
        // 此处不设置researcher的subtopicNum，在操作subtopicMapper时再添加
        for (ResearcherProjectDto dto : researcherList) {
            BeanUtils.copyProperties(dto, researcherProject);
            joinedResearcherMapper.insert(researcherProject);
        }

        // 添加项目的合作方
        if (!collaboratorNameList.isEmpty()) {
            for (String collaboratorName : collaboratorNameList) {
                projectCollaboratorMapper.insert(new ProjectCollaborator(researchProjectDto.getProjectId(), collaboratorName));
            }
        }

        // 添加项目的子课题
        if (!subtopicDtoList.isEmpty()) {
            Subtopic subtopic = new Subtopic();
            subtopic.setProjectId(researchProjectDto.getProjectId());
            for (SubtopicDto dto : subtopicDtoList) {
                BeanUtils.copyProperties(dto, subtopic);
                // 添加子课题的负责人
                Superintendent subtopicSuperintendent = new Superintendent();
                BeanUtils.copyProperties(dto.getSuperintendent(), subtopicSuperintendent);
                superintendentMapper.insert(subtopicSuperintendent);
                // 主键返回
                subtopic.setSuperintendentId(subtopicSuperintendent.getSuperintendentId());
                subtopicMapper.insert(subtopic);
                // 设置参与子课题的科研人员的subtopicNum
                joinedResearcherMapper.updateResearchersSubtopicNum(dto.getSubtopicNum(), dto.getJoinedResearcherIdList());
            }
        }

//        // 添加项目的科研成果
//        if (!researchAchievementDtoList.isEmpty()) {
//            ResearchAchievement researchAchievement = new ResearchAchievement();
//            for (ResearchAchievementDto dto : researchAchievementDtoList) {
//                BeanUtils.copyProperties(dto, researchAchievement);
//                researchAchievementMapper.insert(researchAchievement);
//                // 添加科研成果的贡献人
//                ResearcherAchievement contributor = new ResearcherAchievement();
//                contributor.setAchievementId(researchAchievement.getAchievementId());
//                for (ResearcherAchievementDto c_dto : dto.getContributors()) {
//                    BeanUtils.copyProperties(c_dto, contributor);
//                    contributorMapper.insert(contributor);
//                }
//            }
//        }
    }

    /**
     * 更新科研项目信息及子课题（及其负责人）、科研人员、科研成果、委托方、合作方、质量监测方、负责人信息
     */
    @Override
    @Transactional
    public void updateResearchProjectFullInfo(String oldProjectId, ResearchProjectDto researchProjectDto) {
        List<ResearcherProjectDto> researcherList = researchProjectDto.getResearcherList();
        SuperintendentDto superintendentDto = researchProjectDto.getSuperintendent();
        List<SubtopicDto> subtopicDtoList = researchProjectDto.getSubtopicList();
        List<String> collaboratorNameList = researchProjectDto.getCollaboratorNameList();
//        List<ResearchAchievementDto> researchAchievementDtoList = researchProjectDto.getResearchAchievementList();

        // 查询项目的负责人id
        Integer superintendentId = researchProjectMapper.selectProjectSuperintendentId(oldProjectId);
        // 修改项目的负责人
        Superintendent superintendent = new Superintendent();
        BeanUtils.copyProperties(superintendentDto, superintendent);
        superintendentMapper.update(superintendentId, superintendent);

        // 修改项目拥有的科研人员
        // 清空所有归属的科研人员
        joinedResearcherMapper.clearById(oldProjectId);
        ResearcherProject researcherProject = new ResearcherProject();
        // TODO: 测试此处应该使用老id还是新id？
        researcherProject.setProjectId(researchProjectDto.getProjectId());
        // 依次添加科研人员
        for (ResearcherProjectDto dto : researcherList) {
            BeanUtils.copyProperties(dto, researcherProject);
            joinedResearcherMapper.insert(researcherProject);
        }

        // 修改项目的合作方
        // 清空
        projectCollaboratorMapper.clearById(oldProjectId);
        // 添加
        if (!collaboratorNameList.isEmpty()) {
            for (String collaboratorName : collaboratorNameList) {
                projectCollaboratorMapper.insert(new ProjectCollaborator(researchProjectDto.getProjectId(), collaboratorName));
            }
        }

        // 修改项目的子课题
        // 删除子课题的负责人
        subtopicMapper.clearSubtopicSuperintendentById(oldProjectId);
        // 删除子课题
        subtopicMapper.clearById(oldProjectId);
        // 添加
        if (!subtopicDtoList.isEmpty()) {
            Subtopic subtopic = new Subtopic();
            subtopic.setProjectId(researchProjectDto.getProjectId());
            for (SubtopicDto dto : subtopicDtoList) {
                BeanUtils.copyProperties(dto, subtopic);
                // 添加子课题的负责人
                Superintendent subtopicSuperintendent = new Superintendent();
                BeanUtils.copyProperties(dto.getSuperintendent(), subtopicSuperintendent);
                superintendentMapper.insert(subtopicSuperintendent);
                // 主键返回
                subtopic.setSuperintendentId(subtopicSuperintendent.getSuperintendentId());
                subtopicMapper.insert(subtopic);
                // 设置参与子课题的科研人员的subtopicNum
                joinedResearcherMapper.updateResearchersSubtopicNum(dto.getSubtopicNum(), dto.getJoinedResearcherIdList());
            }
        }

//        // 修改项目的科研成果
//        // 删除
//        researchAchievementMapper.clearById(oldProjectId);
//        // 添加
//        if (!researchAchievementDtoList.isEmpty()) {
//            ResearchAchievement researchAchievement = new ResearchAchievement();
//            for (ResearchAchievementDto dto : researchAchievementDtoList) {
//                BeanUtils.copyProperties(dto, researchAchievement);
//                researchAchievementMapper.insert(researchAchievement);
//                // 添加科研成果的贡献人
//                ResearcherAchievement contributor = new ResearcherAchievement();
//                contributor.setAchievementId(researchAchievement.getAchievementId());
//                for (ResearcherAchievementDto c_dto : dto.getContributors()) {
//                    BeanUtils.copyProperties(c_dto, contributor);
//                    contributorMapper.insert(contributor);
//                }
//            }
//        }

        // 修改项目基础信息、委托方、质量监测方
        ResearchProject researchProject = new ResearchProject();
        BeanUtils.copyProperties(researchProjectDto, researchProject);
        researchProject.setSuperintendentId(superintendentId);
        researchProjectMapper.update(oldProjectId, researchProject);
    }

    /**
     * 删除科研项目信息及子课题（及其负责人）、科研人员、科研成果、委托方、合作方、质量监测方、负责人信息
     */
    @Override
    @Transactional
    public void deleteResearchProjectFullInfo(String projectId) {
        subtopicMapper.clearSubtopicSuperintendentById(projectId);
        joinedResearcherMapper.clearById(projectId);
        superintendentMapper.clearByProjectId(projectId);
        researchProjectMapper.delete(projectId);
    }

    /**
     * 关键字搜索：返回所有ProjectId与ProjectName
     */
    @Override
    public List<ProjectOptionVo> getIdAndNameMatched(String str) {
        return researchProjectMapper.selectIdAndNameMatched(str);
    }

    /**
     * 关键字搜索：返回属于当前project的科研人员
     */
    @Override
    public List<ResearcherOptionVo> getOwnResearcherMatched(String str, String projectId) {
        return researchProjectMapper.selectOwnResearcherMatched(str, projectId);
    }
}
