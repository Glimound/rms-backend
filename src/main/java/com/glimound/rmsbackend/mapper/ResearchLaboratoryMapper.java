package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.ResearchLaboratory;
import com.glimound.rmsbackend.vo.ResearchLaboratoryVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ResearchLaboratoryMapper {

    List<ResearchLaboratory> selectAll();

    /**
     * 查询单个研究室信息及其秘书、主任、场地及科研人员
     */
    ResearchLaboratoryVo selectByName(String labName);

    @Insert("insert into research_laboratory (lab_name, research_direction, secretary_id) " +
            "values (#{labName},#{researchDirection},#{secretaryId})")
    void insert(ResearchLaboratory researchLaboratory);

    @Delete("delete from research_laboratory where lab_name = #{labName}")
    void delete(String labName);

    @Update("update research_laboratory set lab_name = #{rl.labName}, research_direction = #{rl.researchDirection}, " +
            "secretary_id = #{rl.secretaryId} where lab_name = #{oldLabName}")
    void update(String oldLabName, ResearchLaboratory rl);

    /**
     * 将特定labName对应研究室的秘书工号改为指定工号
     * @param secretaryId 指定的秘书工号
     * @param labNameList 需修改的研究室的名称
     */
    void updateLabsSecretary(String secretaryId, List<String> labNameList);

    /**
     * 将所有实验室指定的秘书工号置空
     * @param secretaryId 指定的秘书工号
     */
    void clearLabsSecretary(String secretaryId);
}