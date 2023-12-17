package com.glimound.rmsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Director {
    private String labName;
    private String researcherId;
    private LocalDate appointmentDate;
    private LocalDate termDate;
}
