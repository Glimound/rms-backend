package com.glimound.rmsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResearchProjectDto {
    // 项目基础信息
    private String projectId;
    private String projectName;
    private String projectContent;
    private BigDecimal funding;
    private LocalDate startDate;
    private LocalDate completeDate;
    private String clientName;
    private String qualityMonitorName;
    // 项目其它信息
    private SuperintendentDto superintendent;
    private List<String> collaboratorNameList;
    private List<ResearcherProjectDto> researcherList;
    private List<SubtopicDto> subtopicList;
    private List<ResearchAchievementDto> researchAchievementList;
}
