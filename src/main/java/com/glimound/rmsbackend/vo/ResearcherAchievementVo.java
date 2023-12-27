package com.glimound.rmsbackend.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResearcherAchievementVo {
    private Integer rank;
    private String researcherId;
    private String name;
}
