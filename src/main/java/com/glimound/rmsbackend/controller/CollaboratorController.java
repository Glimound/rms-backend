package com.glimound.rmsbackend.controller;

import com.glimound.rmsbackend.dto.CollaboratorDto;
import com.glimound.rmsbackend.service.CollaboratorService;
import com.glimound.rmsbackend.vo.CollaboratorListVo;
import com.glimound.rmsbackend.vo.CollaboratorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/collaborators")
public class CollaboratorController {

    @Autowired
    private CollaboratorService collaboratorService;

    /**
     * 分页查询所有合作方的信息
     */
    @GetMapping
    public CommonResult<CollaboratorListVo> listCollaborator(@RequestParam(defaultValue = "1") Integer page,
                                                             @RequestParam(defaultValue = "10") Integer pageSize) {
        CollaboratorListVo collaboratorListVo = collaboratorService.listCollaborator(page, pageSize);
        return new CommonResult<>(collaboratorListVo);
    }

    /**
     * 查询合作方的信息及其负责人、联系人
     */
    @GetMapping("/{collaboratorName}")
    public CommonResult<CollaboratorVo> getCollaboratorFullInfo(@PathVariable String collaboratorName) {
        CollaboratorVo collaboratorVo = collaboratorService.getCollaboratorFullInfo(collaboratorName);
        return new CommonResult<>(collaboratorVo);
    }

    /**
     * 新增合作方信息及其负责人、联系人
     */
    @PostMapping
    public void addCollaboratorFullInfo(@RequestBody CollaboratorDto collaboratorDto) {
        collaboratorService.addCollaboratorFullInfo(collaboratorDto);
    }

    /**
     * 更新合作方信息及其负责人、联系人
     */
    @PutMapping("/{collaboratorName}")
    public void updateCollaboratorFullInfo(@PathVariable String collaboratorName, @RequestBody CollaboratorDto collaboratorDto) {
        collaboratorService.updateCollaboratorFullInfo(collaboratorName, collaboratorDto);
    }

    /**
     * 删除合作方信息及其负责人、联系人
     */
    @DeleteMapping("/{collaboratorName}")
    public void deleteCollaboratorFullInfo(@PathVariable String collaboratorName) {
        collaboratorService.deleteCollaboratorFullInfo(collaboratorName);
    }
}
