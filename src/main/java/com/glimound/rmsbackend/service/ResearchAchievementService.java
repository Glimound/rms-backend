package com.glimound.rmsbackend.service;

import com.glimound.rmsbackend.dto.ResearchAchievementDto;
import com.glimound.rmsbackend.vo.ResearchAchievementListVo;
import com.glimound.rmsbackend.vo.ResearchAchievementVo;

public interface ResearchAchievementService {
    /**
     * 分页查询所有科研成果的信息
     */
    ResearchAchievementListVo listResearchAchievement(Integer page, Integer pageSize);

    /**
     * 查询科研成果的信息及对应项目名、贡献人
     */
    ResearchAchievementVo getResearchAchievementFullInfo(Integer achievementId);

    /**
     * 新增科研成果信息及贡献人
     */
    void addResearchAchievementFullInfo(ResearchAchievementDto researchAchievementDto);

    /**
     * 更新科研成果信息及贡献人
     */
    void updateResearchAchievementFullInfo(Integer achievementId, ResearchAchievementDto researchAchievementDto);

    /**
     * 删除科研成果信息
     */
    void deleteResearchAchievementFullInfo(Integer achievementId);
}
