package com.glimound.rmsbackend.controller;

import com.glimound.rmsbackend.dto.ResearchAchievementDto;
import com.glimound.rmsbackend.service.ResearchAchievementService;
import com.glimound.rmsbackend.vo.ResearchAchievementListVo;
import com.glimound.rmsbackend.vo.ResearchAchievementVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/research-achievements")
public class ResearchAchievementController{

    @Autowired
    private ResearchAchievementService service;

    /**
     * 分页查询所有科研成果的信息
     */
    @GetMapping
    public CommonResult<ResearchAchievementListVo> listResearchAchievement(@RequestParam(defaultValue = "1") Integer page,
                                                                           @RequestParam(defaultValue = "10") Integer pageSize) {
        ResearchAchievementListVo researchAchievementListVo = service.listResearchAchievement(page, pageSize);
        return new CommonResult<>(researchAchievementListVo);
    }

    /**
     * 查询科研成果的信息及对应项目名、贡献人
     */
    @GetMapping("/{achievementId}")
    public CommonResult<ResearchAchievementVo> getResearchAchievementFullInfo(@PathVariable Integer achievementId) {
        ResearchAchievementVo researchAchievementVo = service.getResearchAchievementFullInfo(achievementId);
        return new CommonResult<>(researchAchievementVo);
    }

    /**
     * 新增科研成果信息及贡献人
     */
    @PostMapping
    public void addResearchAchievementFullInfo(@RequestBody ResearchAchievementDto researchAchievementDto) {
        service.addResearchAchievementFullInfo(researchAchievementDto);
    }

    /**
     * 更新科研成果信息及贡献人
     */
    @PutMapping("/{achievementId}")
    public void updateResearchAchievementFullInfo(@PathVariable Integer achievementId,@RequestBody ResearchAchievementDto dto) {
        service.updateResearchAchievementFullInfo(achievementId, dto);
    }

    /**
     * 删除科研成果信息
     */
    @DeleteMapping("/{achievementId}")
    public void deleteResearchAchievementFullInfo(@PathVariable Integer achievementId) {
        service.deleteResearchAchievementFullInfo(achievementId);
    }
}
