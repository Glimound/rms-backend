package com.glimound.rmsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 没有achievementId的ResearcherAchievement dto对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResearcherAchievementDto {
    private String researcherId;
    private Integer rank;
}
