package com.glimound.rmsbackend.service;

import com.glimound.rmsbackend.dto.ResearchProjectDto;
import com.glimound.rmsbackend.vo.ProjectOptionVo;
import com.glimound.rmsbackend.vo.ResearchProjectListVo;
import com.glimound.rmsbackend.vo.ResearchProjectVo;
import com.glimound.rmsbackend.vo.ResearcherOptionVo;

import java.util.List;

public interface ResearchProjectService {
    /**
     * 分页查询所有科研项目信息
     */
    ResearchProjectListVo listResearchProject(Integer page, Integer pageSize);

    /**
     * 分页查询科研项目信息及子课题（及其负责人）、科研人员、科研成果、委托方、合作方、质量监测方、负责人信息
     */
    ResearchProjectVo getResearchProjectFullInfo(String projectId);

    /**
     * 新增科研项目信息及子课题（及其负责人）、科研人员、科研成果、委托方、合作方、质量监测方、负责人信息
     */
    void addResearchProjectFullInfo(ResearchProjectDto researchProjectDto);

    /**
     * 更新科研项目信息及子课题（及其负责人）、科研人员、科研成果、委托方、合作方、质量监测方、负责人信息
     */
    void updateResearchProjectFullInfo(String oldProjectId, ResearchProjectDto researchProjectDto);

    /**
     * 删除科研项目信息及子课题（及其负责人）、科研人员、科研成果、委托方、合作方、质量监测方、负责人信息
     */
    void deleteResearchProjectFullInfo(String projectId);

    /**
     * 关键字搜索：返回所有ProjectId与ProjectName
     */
    List<ProjectOptionVo> getIdAndNameMatched(String str);

    /**
     * 关键字搜索：返回属于当前project的科研人员
     */
    List<ResearcherOptionVo> getOwnResearcherMatched(String str, String projectId);
}
