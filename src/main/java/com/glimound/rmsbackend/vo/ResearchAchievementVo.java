package com.glimound.rmsbackend.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResearchAchievementVo {
    private Integer achievementId;
    private String achievementName;
    private LocalDate acquisitionDate;
    private Integer achievementType;
    private Integer patentType;
    private String projectId;
    private String projectName;
    private List<ResearcherAchievementVo> contributors;
}
