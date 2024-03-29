package com.glimound.rmsbackend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.glimound.rmsbackend.dto.ScientificResearcherDto;
import com.glimound.rmsbackend.mapper.ScientificResearcherMapper;
import com.glimound.rmsbackend.pojo.ScientificResearcher;
import com.glimound.rmsbackend.service.ScientificResearcherService;
import com.glimound.rmsbackend.vo.ResearcherProjectVo;
import com.glimound.rmsbackend.vo.ScientificResearcherListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ScientificResearcherServiceImpl implements ScientificResearcherService {

    @Autowired
    private ScientificResearcherMapper scientificResearcherMapper;

    /**
     * 分页查询所有科研人员的信息
     */
    @Override
    public ScientificResearcherListVo listScientificResearcher(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<ScientificResearcher> scientificResearcherList = scientificResearcherMapper.selectAll();
        Page<ScientificResearcher> p = (Page<ScientificResearcher>) scientificResearcherList;
        return new ScientificResearcherListVo(p.getResult(), p.getTotal());
    }

    /**
     * 查询科研人员的信息及其所属的研究室
     */
    @Override
    public ScientificResearcher getScientificResearcherFullInfo(String researcherId) {
        return scientificResearcherMapper.selectById(researcherId);
    }

    /**
     * 新增科研人员信息及其所属的研究室
     */
    @Override
    public void addScientificResearcherFullInfo(ScientificResearcherDto scientificResearcherDto) {
        scientificResearcherMapper.insert(scientificResearcherDto.getScientificResearcher());
    }

    /**
     * 更新科研人员信息及其所属的研究室
     */
    @Override
    public void updateScientificResearcherFullInfo(String oldResearcherId, ScientificResearcherDto scientificResearcherDto) {
        scientificResearcherMapper.update(oldResearcherId, scientificResearcherDto.getScientificResearcher());
    }

    /**
     * 删除科研人员信息
     */
    @Override
    public void deleteScientificResearcherFullInfo(String researcherId) {
        scientificResearcherMapper.delete(researcherId);
    }

    /**
     * 关键字搜索：返回所有未属于任何一个研究室的ScientificResearcher
     */
    @Override
    public List<ScientificResearcher> getFreeResearcherMatched(String str) {
        return scientificResearcherMapper.getFreeResearcherMatched(str);
    }

    /**
     * 关键字搜索：返回研究室所属的ScientificResearcher
     */
    @Override
    public List<ScientificResearcher> getLabOwnResearcherMatched(String str, String labName) {
        return scientificResearcherMapper.getLabOwnResearcherMatched(str, labName);
    }

    /**
     * 关键字搜索：返回所有ScientificResearcher
     */
    @Override
    public List<ResearcherProjectVo> getScientificResearcherMatched(@PathVariable String str) {
        return scientificResearcherMapper.selectResearcherMatched(str);
    }
}
