package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.ResearcherAchievement;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ResearcherAchievementMapper {
    @Insert("insert into researcher_achievement (achievement_id, researcher_id, rank) values " +
            "(#{achievementId}, #{researcherId}, #{rank})")
    void insert(ResearcherAchievement researcherAchievement);

    @Delete("delete from researcher_achievement where achievement_id = #{achievementId} and researcher_id = #{researcherId}")
    void delete(Integer achievementId, String researcherId);

    @Delete("delete from researcher_achievement where achievement_id = #{achievementId}")
    void clearAchievementContributors(Integer achievementId);
}
