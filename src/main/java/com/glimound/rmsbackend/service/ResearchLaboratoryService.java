package com.glimound.rmsbackend.service;

import com.glimound.rmsbackend.dto.ResearchLaboratoryDto;
import com.glimound.rmsbackend.vo.ResearchLaboratoryListVo;
import com.glimound.rmsbackend.vo.ResearchLaboratoryVo;

public interface ResearchLaboratoryService {
    /**
     * 查询所有研究室的信息
     */
    ResearchLaboratoryListVo listResearchLaboratory(Integer page, Integer pageSize);

    /**
     * 查询研究室的信息及其拥有的科研人员、办公场地、主任、秘书的信息
     */
    ResearchLaboratoryVo getResearchLaboratoryFullInfo(String labName);

    /**
     * 新增研究室信息及其拥有的科研人员、办公场地、主任、秘书的信息
     */
    void addResearchLaboratoryFullInfo(ResearchLaboratoryDto researchLaboratoryDto);

    /**
     * 更新研究室信息及其拥有的科研人员、办公场地、主任、秘书的信息
     */
    void updateResearchLaboratoryFullInfo(String oldLabName, ResearchLaboratoryDto researchLaboratoryDto);

    /**
     * 删除研究室信息及其拥有的科研人员、办公场地、主任、秘书的信息
     */
    void deleteResearchLaboratoryFullInfo(String labName);
}
