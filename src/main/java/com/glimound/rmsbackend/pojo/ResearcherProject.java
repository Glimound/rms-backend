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
    String projectId;
    String researcherId;
    LocalDate joinDate;
    int workHour;
    BigDecimal availableFunding;
    String subtopicNum;
}
