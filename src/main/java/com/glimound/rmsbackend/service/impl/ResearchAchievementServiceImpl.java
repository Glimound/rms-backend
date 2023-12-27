package com.glimound.rmsbackend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.glimound.rmsbackend.dto.ResearchAchievementDto;
import com.glimound.rmsbackend.dto.ResearcherAchievementDto;
import com.glimound.rmsbackend.mapper.ResearchAchievementMapper;
import com.glimound.rmsbackend.mapper.ResearcherAchievementMapper;
import com.glimound.rmsbackend.pojo.ResearchAchievement;
import com.glimound.rmsbackend.pojo.ResearcherAchievement;
import com.glimound.rmsbackend.service.ResearchAchievementService;
import com.glimound.rmsbackend.vo.ResearchAchievementListVo;
import com.glimound.rmsbackend.vo.ResearchAchievementVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResearchAchievementServiceImpl implements ResearchAchievementService {

    @Autowired
    private ResearchAchievementMapper researchAchievementMapper;
    @Autowired
    private ResearcherAchievementMapper contributorMapper;

    /**
     * 分页查询所有科研成果的信息
     */
    @Override
    public ResearchAchievementListVo listResearchAchievement(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<ResearchAchievement> researchAchievementList = researchAchievementMapper.selectAll();
        Page<ResearchAchievement> p = (Page<ResearchAchievement>) researchAchievementList;
        return new ResearchAchievementListVo(p.getResult(), p.getTotal());
    }

    /**
     * 查询科研成果的信息及对应项目名、贡献人
     */
    @Override
    public ResearchAchievementVo getResearchAchievementFullInfo(Integer achievementId) {
        return researchAchievementMapper.selectById(achievementId);
    }

    /**
     * 新增科研成果信息及贡献人
     */
    @Override
    @Transactional
    public void addResearchAchievementFullInfo(ResearchAchievementDto researchAchievementDto) {
        ResearchAchievement researchAchievement = new ResearchAchievement();
        BeanUtils.copyProperties(researchAchievementDto, researchAchievement);
        researchAchievementMapper.insert(researchAchievement);

        Integer achievementId = researchAchievement.getAchievementId();
        List<ResearcherAchievementDto> researcherAchievementList = researchAchievementDto.getContributors();
        ResearcherAchievement contributor = new ResearcherAchievement();
        contributor.setAchievementId(achievementId);
        for (ResearcherAchievementDto dto : researcherAchievementList) {
            BeanUtils.copyProperties(dto, contributor);
            contributorMapper.insert(contributor);
        }
    }

    /**
     * 更新科研成果信息及贡献人
     */
    @Override
    @Transactional
    public void updateResearchAchievementFullInfo(Integer achievementId, ResearchAchievementDto researchAchievementDto) {
        ResearchAchievement researchAchievement = new ResearchAchievement();
        BeanUtils.copyProperties(researchAchievementDto, researchAchievement);
        researchAchievementMapper.update(achievementId, researchAchievement);

        contributorMapper.clearAchievementContributors(achievementId);
        List<ResearcherAchievementDto> researcherAchievementList = researchAchievementDto.getContributors();
        ResearcherAchievement contributor = new ResearcherAchievement();
        contributor.setAchievementId(achievementId);
        for (ResearcherAchievementDto dto : researcherAchievementList) {
            BeanUtils.copyProperties(dto, contributor);
            contributorMapper.insert(contributor);
        }
    }

    /**
     * 删除科研成果信息
     */
    @Override
    public void deleteResearchAchievementFullInfo(Integer achievementId) {
        researchAchievementMapper.delete(achievementId);
    }
}
