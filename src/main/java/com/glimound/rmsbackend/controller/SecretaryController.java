package com.glimound.rmsbackend.controller;

import com.glimound.rmsbackend.dto.SecretaryDto;
import com.glimound.rmsbackend.pojo.Secretary;
import com.glimound.rmsbackend.service.SecretaryService;
import com.glimound.rmsbackend.vo.SecretaryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secretaries")
@Slf4j
public class SecretaryController {

    @Autowired
    private SecretaryService secretaryService;

    /**
     * 查询所有秘书的信息
     */
    @GetMapping
    public CommonResult<List<Secretary>> listSecretary(Integer limit, Integer offset) {
        List<Secretary> secretaryList = secretaryService.listSecretary(limit, offset);
        return new CommonResult<>(secretaryList);
    }

    /**
     * 查询秘书的信息及其任职的各研究室
     */
    @GetMapping("/{secretaryId}")
    public CommonResult<SecretaryVo> getSecretaryFullInfo(@PathVariable String secretaryId) {
        SecretaryVo secretaryVo = secretaryService.getSecretaryFullInfo(secretaryId);
        return new CommonResult<>(secretaryVo);
    }

    /**
     * 新增秘书信息及其任职的各研究室
     */
    @PostMapping
    public void addSecretaryFullInfo(@RequestBody SecretaryDto secretaryDto) {
        secretaryService.addSecretaryFullInfo(secretaryDto);
    }

    /**
     * 更新秘书信息及其任职的各研究室
     */
    @PutMapping("/{secretaryId}")
    public void updateSecretaryFullInfo(@PathVariable String secretaryId, @RequestBody SecretaryDto secretaryDto) {
        secretaryService.updateSecretaryFullInfo(secretaryId, secretaryDto);
    }

    /**
     * 删除秘书信息及其任职的各研究室
     */
    @DeleteMapping("/{secretaryId}")
    public void deleteSecretaryFullInfo(@PathVariable String secretaryId) {
        secretaryService.deleteSecretaryFullInfo(secretaryId);
    }
}
