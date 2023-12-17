package com.glimound.rmsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QualityMonitor {
    private String qualityMonitorName;
    private String address;
    private Integer superintendentId;
}
