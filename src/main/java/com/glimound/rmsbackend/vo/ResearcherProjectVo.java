package com.glimound.rmsbackend.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResearcherProjectVo {
    private String researcherId;
    private String name;
    private String title;
    private String labName;
    private LocalDate joinDate;
    private Integer workHour;
    private BigDecimal availableFunding;
}
