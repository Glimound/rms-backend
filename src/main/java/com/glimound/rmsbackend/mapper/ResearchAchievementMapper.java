package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.ResearchAchievement;
import com.glimound.rmsbackend.vo.ResearchAchievementVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ResearchAchievementMapper {
    @Select("select achievement_id, achievement_name, acquisition_date, achievement_type, patent_type, project_id from research_achievement")
    List<ResearchAchievement> selectAll();

    /**
     * 查询单个科研成果信息及其所属科研项目、贡献人信息
     */
    ResearchAchievementVo selectById(Integer achievementId);

    @Options(keyProperty = "achievementId", useGeneratedKeys = true)
    @Insert("insert into research_achievement (achievement_name, acquisition_date, achievement_type, patent_type, project_id) " +
            "values (#{achievementName}, #{acquisitionDate}, #{achievementType}, #{patentType}, #{projectId})")
    void insert(ResearchAchievement researchAchievement);

    @Delete("delete from research_achievement where achievement_id = #{achievementId}")
    void delete(Integer achievementId);

    /**
     * 不修改id
     */
    @Update("update research_achievement set achievement_name = #{ra.achievementName}, " +
            "acquisition_date = #{ra.acquisitionDate}, achievement_type = #{ra.achievementType}, patent_type = #{ra.patentType}, " +
            "project_id = #{ra.projectId} where achievement_id = #{achievementId}")
    void update(Integer achievementId, ResearchAchievement ra);
}
