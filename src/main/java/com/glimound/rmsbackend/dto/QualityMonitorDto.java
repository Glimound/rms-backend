package com.glimound.rmsbackend.dto;

import com.glimound.rmsbackend.pojo.QualityMonitorContact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QualityMonitorDto {
    private String qualityMonitorName;
    private String address;
    private SuperintendentDto superintendent;
    private List<QualityMonitorContact> qualityMonitorContactList;
}
