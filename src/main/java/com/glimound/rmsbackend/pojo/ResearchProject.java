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
    String projectId;
    String projectName;
    String projectContent;
    BigDecimal funding;
    LocalDate startDate;
    LocalDate completeDate;
    int superintendentId;
    String clientName;
    String qualityMonitorName;
}
