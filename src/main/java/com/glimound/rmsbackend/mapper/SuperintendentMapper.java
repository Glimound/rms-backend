package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.Superintendent;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SuperintendentMapper {

    @Options(keyProperty = "superintendentId", useGeneratedKeys = true)
    @Insert("insert into superintendent (name, office_phone, mobile_phone, email) values " +
            "(#{name}, #{officePhone}, #{mobilePhone}, #{email})")
    void insert(Superintendent superintendent);

    @Delete("delete from superintendent where superintendent_id = #{superintendentId}")
    void delete(Integer superintendentId);

    /**
     * 不会修改id
     */
    @Update("update superintendent set name = #{s.name}, office_phone = #{s.officePhone}, " +
            "mobile_phone = #{s.mobilePhone}, email = #{s.email} where superintendent_id = #{superintendentId}")
    void update(Integer superintendentId, Superintendent s);

    @Delete("delete from superintendent where superintendent_id = " +
            "(select superintendent_id from research_project where project_id = #{projectId})")
    void clearByProjectId(String projectId);
}
