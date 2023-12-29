package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.ResearchAchievement;
import com.glimound.rmsbackend.pojo.ResearchProject;
import com.glimound.rmsbackend.vo.ResearchAchievementVo;
import com.glimound.rmsbackend.vo.ResearchProjectVo;
import com.glimound.rmsbackend.vo.ResearcherProjectVo;
import com.glimound.rmsbackend.vo.SubtopicVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ResearchProjectMapper {

    @Select("select project_id, project_name, project_content, funding, start_date, complete_date, " +
            "superintendent_id, client_name, quality_monitor_name from research_project")
    List<ResearchProject> selectAll();

    /**
     * 查询科研项目信息及委托方、合作方、质量监测方、负责人信息
     */
    ResearchProjectVo selectProjectInfoById(String projectId);

    /**
     * 查询该科研项目的子课题（及其负责人）信息
     */
    List<SubtopicVo> selectSubtopicById(String projectId);

    /**
     * 查询参与该科研项目的科研人员信息
     */
    List<ResearcherProjectVo> selectResearcherById(String projectId);

    /**
     * 查询该科研项目的科研成果信息
     */
    List<ResearchAchievementVo> selectAchievementById(String projectId);

    @Insert("insert into research_project (project_id, project_name, project_content, funding, start_date, " +
            "complete_date, superintendent_id, client_name, quality_monitor_name) values " +
            "(#{projectId}, #{projectName}, #{projectContent}, #{funding}, #{startDate}, #{completeDate}, " +
            "#{superintendentId}, #{clientName}, #{qualityMonitorName})")
    void insert(ResearchProject researchProject);

    @Delete("delete from research_project where project_id = #{projectId}")
    void delete(String projectId);

    @Update("update research_project set project_id = #{rp.projectId}, project_name = #{rp.projectName}, project_content = #{rp.projectContent}, " +
            "funding = #{rp.funding}, start_date = #{rp.startDate}, complete_date = #{rp.completeDate}, superintendent_id = #{rp.superintendentId}, " +
            "client_name = #{rp.clientName}, quality_monitor_name = #{rp.qualityMonitorName} where project_id = #{oldProjectId}")
    void update(String oldProjectId, ResearchProject rp);

    /**
     * 选取该项目的负责人id
     */
    @Select("select superintendent_id from research_project where project_id = #{projectId}")
    Integer selectProjectSuperintendentId(String projectId);
}
