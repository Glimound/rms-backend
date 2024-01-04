package com.glimound.rmsbackend.controller;

import com.glimound.rmsbackend.dto.ResearchProjectDto;
import com.glimound.rmsbackend.service.ResearchProjectService;
import com.glimound.rmsbackend.vo.ResearchProjectListVo;
import com.glimound.rmsbackend.vo.ResearchProjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/research-projects")
public class ResearchProjectController {

    @Autowired
    private ResearchProjectService researchProjectService;

    /**
     * 分页查询所有科研项目信息
     */
    @GetMapping
    public CommonResult<ResearchProjectListVo> listResearchProject(@RequestParam(defaultValue = "1") Integer page,
                                                                   @RequestParam(defaultValue = "10") Integer pageSize) {
        return new CommonResult<>(researchProjectService.listResearchProject(page, pageSize));
    }

    /**
     * 查询科研项目信息及子课题（及其负责人）、科研人员、科研成果、委托方、合作方、质量监测方、负责人信息
     */
    @GetMapping("/{projectId}")
    public CommonResult<ResearchProjectVo> getResearchProjectFullInfo(@PathVariable String projectId) {
        return new CommonResult<>(researchProjectService.getResearchProjectFullInfo(projectId));
    }

    /**
     * 新增科研项目信息及子课题（及其负责人）、科研人员、科研成果、委托方、合作方、质量监测方、负责人信息
     */
    @PostMapping
    public void addResearchProjectFullInfo(@RequestBody ResearchProjectDto researchProjectDto) {
        researchProjectService.addResearchProjectFullInfo(researchProjectDto);
    }

    /**
     * 更新科研项目信息及子课题（及其负责人）、科研人员、科研成果、委托方、合作方、质量监测方、负责人信息
     */
    @PutMapping("/{projectId}")
    public void updateResearchProjectFullInfo(@PathVariable String projectId, @RequestBody ResearchProjectDto researchProjectDto) {
        researchProjectService.updateResearchProjectFullInfo(projectId, researchProjectDto);
    }

    /**
     * 删除科研项目信息及子课题（及其负责人）、科研人员、科研成果、委托方、合作方、质量监测方、负责人信息
     */
    @DeleteMapping("/{projectId}")
    public void deleteResearchProjectFullInfo(@PathVariable String projectId) {
        researchProjectService.deleteResearchProjectFullInfo(projectId);
    }
}
