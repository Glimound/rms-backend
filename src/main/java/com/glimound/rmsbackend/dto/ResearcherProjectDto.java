package com.glimound.rmsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResearcherProjectDto {
    private String researcherId;
    private LocalDate joinDate;
    private Integer workHour;
    private BigDecimal availableFunding;
}