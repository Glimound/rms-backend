package com.glimound.rmsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResearchAchievement {
    private Long achievementId;
    private String achievementName;
    private LocalDate acquisitionDate;
    private Integer achievementType;
    private Integer patentType;
    private String projectId;
}
