package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.ResearcherProject;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ResearcherProjectMapper {

    @Insert("insert into researcher_project (project_id, researcher_id, join_date, work_hour, available_funding, subtopic_num) " +
            "values (#{projectId}, #{researcherId}, #{joinDate}, #{workHour}, #{availableFunding}, #{subtopicNum})")
    void insert(ResearcherProject researcherProject);

    @Delete("delete from researcher_project where project_id = #{projectId} and subtopic_num = #{subtopicNum}")
    void delete(String projectId, String subtopicNum);

    @Update("update researcher_project set project_id = #{p.projectId}, researcher_id = #{p.researcherId}, join_date = #{p.joinDate}, " +
            "work_hour = #{p.workHour}, available_funding = #{p.availableFunding}, subtopic_num = #{p.subtopicNum} " +
            "where project_id = #{oldProjectId} and subtopic_num = #{oldSubtopicNum}")
    void update(String oldProjectId, String oldSubtopicNum, ResearcherProject p);

    /**
     * 将特定科研人员的subtopicNum修改为指定的序号
     * @param subtopicNum 指定的序号
     * @param researcherIdList 需修改的科研人员的id
     */
    void updateResearchersSubtopicNum(String subtopicNum, List<String> researcherIdList);

    @Delete("delete from researcher_project where project_id = #{projectId}")
    void clearById(String projectId);
}
