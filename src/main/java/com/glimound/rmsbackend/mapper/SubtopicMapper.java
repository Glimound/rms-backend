package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.Subtopic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SubtopicMapper {

    @Insert("insert into subtopic (project_id, subtopic_num, subtopic_content, available_funding, complete_deadline_date, " +
            "technical_indicator, superintendent_id) values (#{projectId}, #{subtopicNum}, #{subtopicContent}, " +
            "#{availableFunding}, #{completeDeadlineDate}, #{technicalIndicator}, #{superintendentId})")
    void insert(Subtopic subtopic);

    @Delete("delete from subtopic where project_id = #{projectId} and subtopic_num = #{subtopicNum}")
    void delete(String projectId, String subtopicNum);

    @Update("update subtopic set project_id = #{s.projectId}, subtopic_num = #{s.subtopicNum}, subtopic_content = #{s.subtopicContent}, " +
            "available_funding = #{s.availableFunding}, complete_deadline_date = #{s.completeDeadlineDate}, " +
            "technical_indicator = #{s.technicalIndicator}, superintendent_id = #{s.superintendentId} " +
            "where project_id = #{oldProjectId} and subtopic_num = #{oldSubtopicNum}")
    void update(String oldProjectId, String oldSubtopicNum, Subtopic s);

    @Delete("delete from subtopic where project_id = #{projectId}")
    void clearById(String projectId);

    /**
     * 删除该项目下所有子课题拥有的负责人
     */
    @Delete("delete from superintendent where superintendent_id in " +
            "(select s.superintendent_id from research_project r " +
            "left join subtopic s on r.project_id = s.project_id " +
            "where r.project_id = #{projectId})")
    void clearSubtopicSuperintendentById(String projectId);
}
