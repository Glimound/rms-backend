package com.glimound.rmsbackend.vo;

import com.glimound.rmsbackend.pojo.QualityMonitor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QualityMonitorListVo {
    private List<QualityMonitor> qualityMonitorList;
    private Long count;
}
