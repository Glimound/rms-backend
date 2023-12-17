package com.glimound.rmsbackend.service.impl;

import com.glimound.rmsbackend.dto.ResearchLaboratoryDto;
import com.glimound.rmsbackend.mapper.ResearchLaboratoryMapper;
import com.glimound.rmsbackend.pojo.*;
import com.glimound.rmsbackend.service.ResearchLaboratoryService;
import com.glimound.rmsbackend.vo.ResearchLaboratoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResearchLaboratoryServiceImpl implements ResearchLaboratoryService {

    @Autowired
    private ResearchLaboratoryMapper researchLaboratoryMapper;

    /**
     * 查询所有研究室的信息
     */
    @Override
    public List<ResearchLaboratory> listResearchLaboratory(Integer limit, Integer offset) {
        return researchLaboratoryMapper.selectAll(limit, offset);
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
        List<ScientificResearcher> scientificResearcherList = dto.getScientificResearcherList();
        List<OfficeSpace> officeSpaceList = dto.getOfficeSpaceList();

        researchLaboratoryMapper.insert(researchLaboratory);
        // TODO: 加主任；加科研人员；加办公场地
    }

    /**
     * 更新研究室信息及其拥有的科研人员、办公场地、主任、秘书的信息
     */
    @Override
    @Transactional
    public void updateResearchLaboratoryFullInfo(String oldLabName, ResearchLaboratoryDto dto) {
        ResearchLaboratory researchLaboratory = dto.getResearchLaboratory();
        Director director = dto.getDirector();
        List<ScientificResearcher> scientificResearcherList = dto.getScientificResearcherList();
        List<OfficeSpace> officeSpaceList = dto.getOfficeSpaceList();

        // TODO: 判断是否空，置0，加主任；判断是否空，置0，加科研人员；（已断定非空）置0，加办公场地
    }

    /**
     * 删除研究室信息及其拥有的科研人员、办公场地、主任、秘书的信息
     */
    @Override
    public void deleteResearchLaboratoryFullInfo(String labName) {
        researchLaboratoryMapper.delete(labName);
    }
}
