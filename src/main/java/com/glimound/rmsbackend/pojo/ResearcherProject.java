package com.glimound.rmsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResearcherProject {
    private String projectId;
    private String researcherId;
    private LocalDate joinDate;
    private Integer workHour;
    private BigDecimal availableFunding;
    private String subtopicNum;
}
