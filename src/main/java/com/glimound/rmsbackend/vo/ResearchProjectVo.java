package com.glimound.rmsbackend.vo;

import com.glimound.rmsbackend.pojo.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResearchProjectVo {
    // 项目基础信息
    private String projectId;
    private String projectName;
    private String projectContent;
    private BigDecimal funding;
    private LocalDate startDate;
    private LocalDate completeDate;
    // 其余信息
    private Superintendent superintendent;
    private Client client;
    private QualityMonitor qualityMonitor;
    private List<Collaborator> collaboratorList;
    private List<ResearcherProjectVo> researcherList;
    private List<SubtopicVo> subtopicList;
    private List<ResearchAchievementVo> researchAchievementList;
}
