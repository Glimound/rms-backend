package com.glimound.rmsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Secretary {
    String secretaryId;
    String name;
    int gender;
    LocalDate birth;
    LocalDate employDate;
    String remit;
}
