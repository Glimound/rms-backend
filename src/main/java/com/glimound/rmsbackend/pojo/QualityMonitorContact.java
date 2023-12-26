package com.glimound.rmsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QualityMonitorContact {
    private Integer contactId;
    private String name;
    private String officePhone;
    private String mobilePhone;
    private String email;
    private String qualityMonitorName;
}
