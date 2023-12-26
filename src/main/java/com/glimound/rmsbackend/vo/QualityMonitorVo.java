package com.glimound.rmsbackend.vo;

import com.glimound.rmsbackend.pojo.QualityMonitorContact;
import com.glimound.rmsbackend.pojo.Superintendent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QualityMonitorVo {
    private String qualityMonitorName;
    private String address;
    private Superintendent superintendent;
    private List<QualityMonitorContact> qualityMonitorContactList;
}
