package com.glimound.rmsbackend.service;

import com.glimound.rmsbackend.dto.ScientificResearcherDto;
import com.glimound.rmsbackend.pojo.ScientificResearcher;
import com.glimound.rmsbackend.vo.ResearcherProjectVo;
import com.glimound.rmsbackend.vo.ScientificResearcherListVo;

import java.util.List;

public interface ScientificResearcherService {
    /**
     * 分页查询所有科研人员的信息
     */
    ScientificResearcherListVo listScientificResearcher(Integer page, Integer pageSize);

    /**
     * 查询科研人员的信息及其所属的研究室
     */
    ScientificResearcher getScientificResearcherFullInfo(String researcherId);

    /**
     * 新增科研人员信息及其所属的研究室
     */
    void addScientificResearcherFullInfo(ScientificResearcherDto scientificResearcherDto);

    /**
     * 更新科研人员信息及其所属的研究室
     */
    void updateScientificResearcherFullInfo(String oldResearcherId, ScientificResearcherDto scientificResearcherDto);

    /**
     * 删除科研人员信息
     */
    void deleteScientificResearcherFullInfo(String researcherId);

    /**
     * 关键字搜索：返回所有未属于任何一个研究室的ScientificResearcher
     */
    List<ScientificResearcher> getFreeResearcherMatched(String str);

    /**
     * 关键字搜索：返回研究室所属的ScientificResearcher
     */
    List<ScientificResearcher> getLabOwnResearcherMatched(String str, String labName);

    /**
     * 关键字搜索：返回所有ScientificResearcher
     */
    List<ResearcherProjectVo> getScientificResearcherMatched(String str);
}
