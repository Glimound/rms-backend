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
public class SubtopicDto {
    private String subtopicNum;
    private String subtopicContent;
    private BigDecimal availableFunding;
    private LocalDate completeDeadlineDate;
    private String technicalIndicator;
    private SuperintendentDto superintendent;
    private List<String> joinedResearcherIdList;
}