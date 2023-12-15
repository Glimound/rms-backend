package com.glimound.rmsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResearchAchievement {
    long achievementId;
    String achievementName;
    LocalDate acquisitionDate;
    int achievementType;
    int patentType;
    String projectId;

}
