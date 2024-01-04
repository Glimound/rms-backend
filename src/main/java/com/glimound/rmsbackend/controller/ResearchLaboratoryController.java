package com.glimound.rmsbackend.controller;

import com.glimound.rmsbackend.dto.ResearchLaboratoryDto;
import com.glimound.rmsbackend.service.ResearchLaboratoryService;
import com.glimound.rmsbackend.vo.ResearchLaboratoryListVo;
import com.glimound.rmsbackend.vo.ResearchLaboratoryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/research-laboratories")
@Slf4j
public class ResearchLaboratoryController {

    @Autowired
    private ResearchLaboratoryService researchLaboratoryService;

    /**
     * 分页查询所有研究室的信息
     */
    @GetMapping
    public CommonResult<ResearchLaboratoryListVo> listSecretary(@RequestParam(defaultValue = "1") Integer page,
                                                                @RequestParam(defaultValue = "10") Integer pageSize) {
        ResearchLaboratoryListVo researchLaboratoryListVo = researchLaboratoryService.listResearchLaboratory(page, pageSize);
        return new CommonResult<>(researchLaboratoryListVo);
    }

    /**
     * 查询研究室的信息及其拥有的科研人员、办公场地、主任、秘书的信息
     */
    @GetMapping("/{labName}")
    public CommonResult<ResearchLaboratoryVo> getResearchLaboratoryFullInfo(@PathVariable String labName) {
        ResearchLaboratoryVo researchLaboratoryVo = researchLaboratoryService.getResearchLaboratoryFullInfo(labName);
        return new CommonResult<>(researchLaboratoryVo);
    }

    /**
     * 新增研究室信息及其拥有的科研人员、办公场地、主任、秘书的信息
     */
    @PostMapping
    public void addResearchLaboratoryFullInfo(@RequestBody ResearchLaboratoryDto researchLaboratoryDto) {
        researchLaboratoryService.addResearchLaboratoryFullInfo(researchLaboratoryDto);
    }

    /**
     * 更新研究室信息及其拥有的科研人员、办公场地、主任、秘书的信息
     */
    @PutMapping("/{labName}")
    public void updateResearchLaboratoryFullInfo(@PathVariable String labName, @RequestBody ResearchLaboratoryDto researchLaboratoryDto) {
        researchLaboratoryService.updateResearchLaboratoryFullInfo(labName, researchLaboratoryDto);
    }

    /**
     * 删除研究室信息及其拥有的科研人员、办公场地、主任、秘书的信息
     */
    @DeleteMapping("/{labName}")
    public void deleteResearchLaboratoryFullInfo(@PathVariable String labName) {
        researchLaboratoryService.deleteResearchLaboratoryFullInfo(labName);
    }
}
