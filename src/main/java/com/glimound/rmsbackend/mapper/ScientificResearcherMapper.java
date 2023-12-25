package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.ScientificResearcher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ScientificResearcherMapper {
    @Select("select researcher_id, name, gender, birth, title, research_direction, lab_name from scientific_researcher")
    List<ScientificResearcher> selectAll();

    /**
     * 查询单个科研人员信息及其所属的研究室
     */
    @Select("select researcher_id, name, gender, birth, title, research_direction, lab_name from scientific_researcher " +
            "where researcher_id = #{researcherId}")
    ScientificResearcher selectById(String researcherId);

    @Insert("insert into scientific_researcher (researcher_id, name, gender, birth, title, research_direction, lab_name) " +
            "values (#{researcherId}, #{name}, #{gender}, #{birth}, #{title}, #{researchDirection}, #{labName})")
    void insert(ScientificResearcher scientificResearcher);

    @Delete("delete from scientific_researcher where researcher_id = #{researcherId}")
    void delete(String researcherId);

    @Update("update scientific_researcher set researcher_id = #{sr.researcherId}, name = #{sr.name}, gender = #{sr.gender}, " +
            "birth = #{sr.birth}, title = #{sr.title}, research_direction = #{sr.researchDirection}, lab_name = #{sr.labName} " +
            "where researcher_id = #{oldResearcherId}")
    void update(String oldResearcherId, ScientificResearcher sr);
}
