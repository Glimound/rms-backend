package com.glimound.rmsbackend.controller;

import com.glimound.rmsbackend.dto.OfficeSpaceDto;
import com.glimound.rmsbackend.pojo.OfficeSpace;
import com.glimound.rmsbackend.service.OfficeSpaceService;
import com.glimound.rmsbackend.vo.OfficeSpaceListVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/office-spaces")
@Slf4j
public class OfficeSpaceController {

    @Autowired
    private OfficeSpaceService officeSpaceService;

    /**
     * 分页查询所有办公场地的信息
     */
    @GetMapping
    public CommonResult<OfficeSpaceListVo> listOfficeSpace(@RequestParam(defaultValue = "1") Integer page,
                                                           @RequestParam(defaultValue = "10") Integer pageSize) {
        OfficeSpaceListVo officeSpaceListVo = officeSpaceService.listOfficeSpace(page, pageSize);
        return new CommonResult<>(officeSpaceListVo);
    }

    /**
     * 查询办公场地的信息及其所属的研究室
     */
    @GetMapping("/{siteId}")
    CommonResult<OfficeSpace> getOfficeSpaceFullInfo(@PathVariable String siteId) {
        OfficeSpace officeSpace = officeSpaceService.getOfficeSpaceFullInfo(siteId);
        return new CommonResult<>(officeSpace);
    }

    /**
     * 新增办公场地信息及其所属的研究室
     */
    @PostMapping
    void addOfficeSpaceFullInfo(@RequestBody OfficeSpaceDto officeSpaceDto) {
        officeSpaceService.addOfficeSpaceFullInfo(officeSpaceDto);
    }

    /**
     * 更新办公场地信息及其所属的研究室
     */
    @PutMapping("/{siteId}")
    void updateOfficeSpaceFullInfo(@PathVariable String siteId, @RequestBody OfficeSpaceDto officeSpaceDto) {
        officeSpaceService.updateOfficeSpaceFullInfo(siteId, officeSpaceDto);
    }

    /**
     * 删除办公场地信息
     */
    @DeleteMapping("/{siteId}")
    void deleteOfficeSpaceFullInfo(@PathVariable String siteId) {
        officeSpaceService.deleteOfficeSpaceFullInfo(siteId);
    }

}
