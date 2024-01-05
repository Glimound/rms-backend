package com.glimound.rmsbackend.service;

import com.glimound.rmsbackend.dto.QualityMonitorDto;
import com.glimound.rmsbackend.pojo.QualityMonitor;
import com.glimound.rmsbackend.vo.QualityMonitorListVo;
import com.glimound.rmsbackend.vo.QualityMonitorVo;

import java.util.List;

public interface QualityMonitorService {
    /**
     * 分页查询所有质量监测方的信息
     */
    QualityMonitorListVo listQualityMonitor(Integer page, Integer pageSize);

    /**
     * 查询质量监测方的信息及其负责人、联系人
     */
    QualityMonitorVo getQualityMonitorFullInfo(String qualityMonitorName);

    /**
     * 新增质量监测方信息及其负责人、联系人
     */
    void addQualityMonitorFullInfo(QualityMonitorDto qualityMonitorDto);

    /**
     * 更新质量监测方信息及其负责人、联系人
     */
    void updateQualityMonitorFullInfo(String oldQualityMonitorName, QualityMonitorDto qualityMonitorDto);

    /**
     * 删除质量监测方信息及其负责人、联系人
     */
    void deleteQualityMonitorFullInfo(String qualityMonitorName);

    /**
     * 关键字搜索：返回所有QualityMonitor
     */
    List<QualityMonitor> getQualityMonitorMatched(String str);
}
