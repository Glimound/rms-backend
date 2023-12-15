package com.glimound.rmsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScientificResearcher {
    String researcherId;
    String name;
    int gender;
    LocalDate birth;
    String title;
    String researchDirection;
    String labName;
}
