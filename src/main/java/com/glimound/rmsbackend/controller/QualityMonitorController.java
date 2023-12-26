package com.glimound.rmsbackend.controller;

import com.glimound.rmsbackend.dto.QualityMonitorDto;
import com.glimound.rmsbackend.service.QualityMonitorService;
import com.glimound.rmsbackend.vo.QualityMonitorListVo;
import com.glimound.rmsbackend.vo.QualityMonitorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qualityMonitors")
public class QualityMonitorController {

    @Autowired
    private QualityMonitorService qualityMonitorService;

    /**
     * 分页查询所有质量监测方的信息
     */
    @GetMapping
    public CommonResult<QualityMonitorListVo> listQualityMonitor(@RequestParam(defaultValue = "1") Integer page,
                                                                 @RequestParam(defaultValue = "10") Integer pageSize) {
        QualityMonitorListVo qualityMonitorListVo = qualityMonitorService.listQualityMonitor(page, pageSize);
        return new CommonResult<>(qualityMonitorListVo);
    }

    /**
     * 查询质量监测方的信息及其负责人、联系人
     */
    @GetMapping("/{qualityMonitorName}")
    public CommonResult<QualityMonitorVo> getQualityMonitorFullInfo(@PathVariable String qualityMonitorName) {
        QualityMonitorVo qualityMonitorVo = qualityMonitorService.getQualityMonitorFullInfo(qualityMonitorName);
        return new CommonResult<>(qualityMonitorVo);
    }

    /**
     * 新增质量监测方信息及其负责人、联系人
     */
    @PostMapping
    public void addQualityMonitorFullInfo(@RequestBody QualityMonitorDto qualityMonitorDto) {
        qualityMonitorService.addQualityMonitorFullInfo(qualityMonitorDto);
    }

    /**
     * 更新质量监测方信息及其负责人、联系人
     */
    @PutMapping("/{qualityMonitorName}")
    public void updateQualityMonitorFullInfo(@PathVariable String qualityMonitorName, @RequestBody QualityMonitorDto qualityMonitorDto) {
        qualityMonitorService.updateQualityMonitorFullInfo(qualityMonitorName, qualityMonitorDto);
    }

    /**
     * 删除质量监测方信息及其负责人、联系人
     */
    @DeleteMapping("/{qualityMonitorName}")
    public void deleteQualityMonitorFullInfo(@PathVariable String qualityMonitorName) {
        qualityMonitorService.deleteQualityMonitorFullInfo(qualityMonitorName);
    }
}
