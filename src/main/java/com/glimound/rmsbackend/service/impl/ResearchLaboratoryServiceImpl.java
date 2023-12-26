package com.glimound.rmsbackend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.glimound.rmsbackend.dto.ResearchLaboratoryDto;
import com.glimound.rmsbackend.mapper.DirectorMapper;
import com.glimound.rmsbackend.mapper.OfficeSpaceMapper;
import com.glimound.rmsbackend.mapper.ResearchLaboratoryMapper;
import com.glimound.rmsbackend.mapper.ScientificResearcherMapper;
import com.glimound.rmsbackend.pojo.*;
import com.glimound.rmsbackend.service.ResearchLaboratoryService;
import com.glimound.rmsbackend.vo.ResearchLaboratoryListVo;
import com.glimound.rmsbackend.vo.ResearchLaboratoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResearchLaboratoryServiceImpl implements ResearchLaboratoryService {

    @Autowired
    private ResearchLaboratoryMapper researchLaboratoryMapper;
    @Autowired
    private DirectorMapper directorMapper;
    @Autowired
    private ScientificResearcherMapper scientificResearcherMapper;
    @Autowired
    private OfficeSpaceMapper officeSpaceMapper;

    /**
     * 分页查询所有研究室的信息
     */
    @Override
    public ResearchLaboratoryListVo listResearchLaboratory(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<ResearchLaboratory> researchLaboratoryList = researchLaboratoryMapper.selectAll();
        Page<ResearchLaboratory> p = (Page<ResearchLaboratory>) researchLaboratoryList;
        return new ResearchLaboratoryListVo(p.getResult(), p.getTotal());
    }

    /**
     * 查询研究室的信息及其拥有的科研人员、办公场地、主任、秘书的信息
     */
    @Override
    public ResearchLaboratoryVo getResearchLaboratoryFullInfo(String labName) {
        return researchLaboratoryMapper.selectByName(labName);
    }

    /**
     * 新增研究室信息及其拥有的科研人员、办公场地、主任、秘书的信息
     */
    @Override
    @Transactional
    public void addResearchLaboratoryFullInfo(ResearchLaboratoryDto dto) {
        ResearchLaboratory researchLaboratory = dto.getResearchLaboratory();
        Director director = dto.getDirector();
        List<String> researcherIdList = dto.getResearcherIdList();
        List<String> siteIdList = dto.getSiteIdList();

        researchLaboratoryMapper.insert(researchLaboratory);
        // 添加主任
        if (director != null)
            directorMapper.insert(director);
        // 添加拥有的科研人员
        if (!researcherIdList.isEmpty())
            scientificResearcherMapper.updateResearchersLab(researchLaboratory.getLabName(), researcherIdList);
        // 添加拥有的办公场地
        if (!siteIdList.isEmpty())
            officeSpaceMapper.updateOfficeSpacesLab(researchLaboratory.getLabName(), siteIdList);
    }

    /**
     * 更新研究室信息及其拥有的科研人员、办公场地、主任、秘书的信息
     */
    @Override
    @Transactional
    public void updateResearchLaboratoryFullInfo(String oldLabName, ResearchLaboratoryDto dto) {
        ResearchLaboratory researchLaboratory = dto.getResearchLaboratory();
        Director director = dto.getDirector();
        List<String> researcherIdList = dto.getResearcherIdList();
        List<String> siteIdList = dto.getSiteIdList();

        researchLaboratoryMapper.update(oldLabName, researchLaboratory);

        directorMapper.delete(oldLabName);
        if (director != null)
            directorMapper.insert(director);

        scientificResearcherMapper.clearResearchersLab(researchLaboratory.getLabName());
        if (!researcherIdList.isEmpty())
            scientificResearcherMapper.updateResearchersLab(researchLaboratory.getLabName(), researcherIdList);

        officeSpaceMapper.clearOfficeSpacesLab(researchLaboratory.getLabName());
        if (!siteIdList.isEmpty())
            officeSpaceMapper.updateOfficeSpacesLab(researchLaboratory.getLabName(), siteIdList);
    }

    /**
     * 删除研究室信息及其拥有的科研人员、办公场地、主任、秘书的信息
     */
    @Override
    public void deleteResearchLaboratoryFullInfo(String labName) {
        researchLaboratoryMapper.delete(labName);
    }
}
