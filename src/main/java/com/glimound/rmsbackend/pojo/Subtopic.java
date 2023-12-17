package com.glimound.rmsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subtopic {
    private String projectId;
    private String subtopicNum;
    private String subtopicContent;
    private BigDecimal availableFunding;
    private LocalDate completeDeadlineDate;
    private String technicalIndicator;
    private Integer superintendentId;
}