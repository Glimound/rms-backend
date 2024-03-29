package com.glimound.rmsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScientificResearcher {
    private String researcherId;
    private String name;
    private Integer gender;
    private LocalDate birth;
    private String title;
    private String researchDirection;
    private String labName;
}
