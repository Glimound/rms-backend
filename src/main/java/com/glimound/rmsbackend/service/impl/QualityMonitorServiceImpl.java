package com.glimound.rmsbackend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.glimound.rmsbackend.dto.QualityMonitorDto;
import com.glimound.rmsbackend.dto.SuperintendentDto;
import com.glimound.rmsbackend.mapper.QualityMonitorContactMapper;
import com.glimound.rmsbackend.mapper.QualityMonitorMapper;
import com.glimound.rmsbackend.mapper.SuperintendentMapper;
import com.glimound.rmsbackend.pojo.QualityMonitor;
import com.glimound.rmsbackend.pojo.QualityMonitorContact;
import com.glimound.rmsbackend.pojo.Superintendent;
import com.glimound.rmsbackend.service.QualityMonitorService;
import com.glimound.rmsbackend.vo.QualityMonitorListVo;
import com.glimound.rmsbackend.vo.QualityMonitorVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QualityMonitorServiceImpl implements QualityMonitorService {

    @Autowired
    private QualityMonitorMapper qualityMonitorMapper;
    @Autowired
    private SuperintendentMapper superintendentMapper;
    @Autowired
    private QualityMonitorContactMapper qualityMonitorContactMapper;

    /**
     * 分页查询所有质量监测方的信息
     */
    @Override
    public QualityMonitorListVo listQualityMonitor(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<QualityMonitor> qualityMonitorList = qualityMonitorMapper.selectAll();
        Page<QualityMonitor> p = (Page<QualityMonitor>) qualityMonitorList;
        return new QualityMonitorListVo(p.getResult(), p.getTotal());
    }

    /**
     * 查询质量监测方的信息及其负责人、联系人
     */
    @Override
    public QualityMonitorVo getQualityMonitorFullInfo(String qualityMonitorName) {
        return qualityMonitorMapper.selectByName(qualityMonitorName);
    }

    /**
     * 新增质量监测方信息及其负责人、联系人
     */
    @Override
    @Transactional
    public void addQualityMonitorFullInfo(QualityMonitorDto qualityMonitorDto) {
        SuperintendentDto superintendentDto = qualityMonitorDto.getSuperintendent();
        List<QualityMonitorContact> qualityMonitorContactList = qualityMonitorDto.getQualityMonitorContactList();

        Superintendent superintendent = new Superintendent();
        BeanUtils.copyProperties(superintendentDto, superintendent);
        // 无需检查是否为null/list是否empty（完全参加）
        superintendentMapper.insert(superintendent);
        Integer superintendentId = superintendent.getSuperintendentId();

        QualityMonitor qualityMonitor = new QualityMonitor(qualityMonitorDto.getQualityMonitorName(), qualityMonitorDto.getAddress(), superintendentId);
        qualityMonitorMapper.insert(qualityMonitor);

        for (QualityMonitorContact c : qualityMonitorContactList) {
            qualityMonitorContactMapper.insert(c);
        }
    }

    /**
     * 更新质量监测方信息及其负责人、联系人
     */
    @Override
    @Transactional
    public void updateQualityMonitorFullInfo(String oldQualityMonitorName, QualityMonitorDto qualityMonitorDto) {
        SuperintendentDto superintendentDto = qualityMonitorDto.getSuperintendent();
        List<QualityMonitorContact> qualityMonitorContactList = qualityMonitorDto.getQualityMonitorContactList();

        Integer superintendentId = qualityMonitorMapper.selectSuperintendentIdByName(oldQualityMonitorName);
        Superintendent superintendent = new Superintendent();
        BeanUtils.copyProperties(superintendentDto, superintendent);
        superintendentMapper.update(superintendentId, superintendent);

        QualityMonitor qualityMonitor = new QualityMonitor();
        BeanUtils.copyProperties(qualityMonitorDto, qualityMonitor);
        qualityMonitor.setSuperintendentId(superintendentId);
        qualityMonitorMapper.update(oldQualityMonitorName, qualityMonitor);

        // 清空再添加
        qualityMonitorContactMapper.clearQualityMonitorContacts(oldQualityMonitorName);
        for (QualityMonitorContact c : qualityMonitorContactList) {
            qualityMonitorContactMapper.insert(c);
        }
    }

    /**
     * 删除质量监测方信息及其负责人、联系人
     */
    @Override
    @Transactional
    public void deleteQualityMonitorFullInfo(String qualityMonitorName) {
        Integer superintendentId = qualityMonitorMapper.selectSuperintendentIdByName(qualityMonitorName);
        superintendentMapper.delete(superintendentId);
        qualityMonitorMapper.delete(qualityMonitorName);
    }
}
