package com.glimound.rmsbackend.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecretaryVo {
    private String secretaryId;
    private String name;
    private Integer gender;
    private LocalDate birth;
    private LocalDate employDate;
    private String remit;
    private List<String> labNameList;
}
