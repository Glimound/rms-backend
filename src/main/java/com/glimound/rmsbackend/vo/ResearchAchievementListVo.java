package com.glimound.rmsbackend.vo;

import com.glimound.rmsbackend.pojo.ResearchAchievement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResearchAchievementListVo {
    private List<ResearchAchievement> researchAchievementList;
    private Long count;
}
