package com.glimound.rmsbackend.vo;

import com.glimound.rmsbackend.pojo.Superintendent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubtopicVo {
    private String subtopicNum;
    private String subtopicContent;
    private BigDecimal availableFunding;
    private LocalDate completeDeadlineDate;
    private String technicalIndicator;
    private Superintendent superintendent;
    private List<String> joinedResearcherIdList;
}
