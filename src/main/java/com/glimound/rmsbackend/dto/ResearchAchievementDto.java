package com.glimound.rmsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResearchAchievementDto {
    private String achievementName;
    private LocalDate acquisitionDate;
    private Integer achievementType;
    private Integer patentType;
    private String projectId;
    private List<ResearcherAchievementDto> contributors;
}
