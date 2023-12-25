package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.Director;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DirectorMapper {
    @Insert("insert into director (lab_name, researcher_id, appointment_date, term_date) values " +
            "(#{labName}, #{researcherId}, #{appointmentDate}, #{termDate})")
    void insert(Director director);

    @Delete("delete from director where lab_name = #{labName}")
    void delete(String labName);

    @Update("update director set lab_name = #{d.labName}, researcher_id = #{d.researcherId}, " +
            "appointment_date = #{d.appointmentDate}, term_date = #{d.termDate} " +
            "where lab_name = #{oldLabName} and researcher_id = #{oldResearcherId}")
    void update(String oldLabName, String oldResearcherId, Director d);
}
