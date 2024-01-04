package com.glimound.rmsbackend.controller;

import com.glimound.rmsbackend.dto.ScientificResearcherDto;
import com.glimound.rmsbackend.pojo.ScientificResearcher;
import com.glimound.rmsbackend.service.ScientificResearcherService;
import com.glimound.rmsbackend.vo.ScientificResearcherListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scientific-researchers")
public class ScientificResearcherController {

    @Autowired
    private ScientificResearcherService scientificResearcherService;

    /**
     * 分页查询所有科研人员的信息
     */
    @GetMapping
    public CommonResult<ScientificResearcherListVo> listScientificResearcher(@RequestParam(defaultValue = "1") Integer page,
                                                                             @RequestParam(defaultValue = "10") Integer pageSize) {
        ScientificResearcherListVo scientificResearcherListVo = scientificResearcherService.listScientificResearcher(page, pageSize);
        return new CommonResult<>(scientificResearcherListVo);
    }

    /**
     * 查询科研人员的信息及其所属的研究室
     */
    @GetMapping("/{researcherId}")
    CommonResult<ScientificResearcher> getScientificResearcherFullInfo(@PathVariable String researcherId) {
        ScientificResearcher scientificResearcher = scientificResearcherService.getScientificResearcherFullInfo(researcherId);
        return new CommonResult<>(scientificResearcher);
    }

    /**
     * 新增科研人员信息及其所属的研究室
     */
    @PostMapping
    void addScientificResearcherFullInfo(@RequestBody ScientificResearcherDto scientificResearcherDto) {
        scientificResearcherService.addScientificResearcherFullInfo(scientificResearcherDto);
    }

    /**
     * 更新科研人员信息及其所属的研究室
     */
    @PutMapping("/{researcherId}")
    void updateScientificResearcherFullInfo(@PathVariable String researcherId, @RequestBody ScientificResearcherDto dto) {
        scientificResearcherService.updateScientificResearcherFullInfo(researcherId, dto);
    }

    /**
     * 删除科研人员信息
     */
    @DeleteMapping("/{researcherId}")
    void deleteScientificResearcherFullInfo(@PathVariable String researcherId) {
        scientificResearcherService.deleteScientificResearcherFullInfo(researcherId);
    }
}
