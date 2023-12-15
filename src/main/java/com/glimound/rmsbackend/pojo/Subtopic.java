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
    String projectId;
    String subtopicNum;
    String subtopicContent;
    BigDecimal availableFunding;
    LocalDate completeDeadlineDate;
    String technicalIndicator;
    int superintendentId;
}
