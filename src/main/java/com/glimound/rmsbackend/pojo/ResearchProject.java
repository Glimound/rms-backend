package com.glimound.rmsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResearchProject {
    private String projectId;
    private String projectName;
    private String projectContent;
    private BigDecimal funding;
    private LocalDate startDate;
    private LocalDate completeDate;
    private Integer superintendentId;
    private String clientName;
    private String qualityMonitorName;
}
