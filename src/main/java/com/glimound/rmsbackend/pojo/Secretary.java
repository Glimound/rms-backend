package com.glimound.rmsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Secretary {
    private String secretaryId;
    private String name;
    private Integer gender;
    private LocalDate birth;
    private LocalDate employDate;
    private String remit;
}
