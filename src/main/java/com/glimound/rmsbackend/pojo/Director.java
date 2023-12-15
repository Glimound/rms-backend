package com.glimound.rmsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Director {
    String labName;
    String researcherId;
    LocalDate appointmentDate;
    LocalDate termDate;
}
