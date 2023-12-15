package com.glimound.rmsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QualityMonitor {
    String qualityMonitorName;
    String address;
    int superintendentId;
}
