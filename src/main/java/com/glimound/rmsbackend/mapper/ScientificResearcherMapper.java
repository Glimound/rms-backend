package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.ScientificResearcher;
import com.glimound.rmsbackend.vo.ResearcherProjectVo;
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

    /**
     * 将特定科研人员所属的研究室改为指定的研究室
     * @param labName 指定的研究室
     * @param researcherIdList 需修改的科研人员的id
     */
    void updateResearchersLab(String labName, List<String> researcherIdList);

    /**
     * 清除科研人员归属的特定研究室
     * @param labName 指定的研究室
     */
    @Update("update scientific_researcher set lab_name = null where lab_name = #{labName}")
    void clearResearchersLab(String labName);

    @Select("select researcher_id, name, gender, birth, title, research_direction, lab_name from scientific_researcher " +
            "where lab_name is null and researcher_id like concat('%',#{str},'%')")
    List<ScientificResearcher> getFreeResearcherMatched(String str);

    @Select("select researcher_id, name, gender, birth, title, research_direction, lab_name from scientific_researcher " +
            "where lab_name = #{labName} and researcher_id like concat('%',#{str},'%')")
    List<ScientificResearcher> getLabOwnResearcherMatched(String str, String labName);

    @Select("select researcher_id, name, gender, birth, title, research_direction, lab_name from scientific_researcher " +
            "where researcher_id like concat('%',#{str},'%')")
    List<ResearcherProjectVo> selectResearcherMatched(String str);

}
