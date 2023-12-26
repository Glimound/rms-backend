package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.Superintendent;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SuperintendentMapper {

    // TODO: 待测试是否可以直接忽略自增id
    @Insert("insert into superintendent (name, office_phone, mobile_phone, email) values " +
            "(#{name}, #{officePhone}, #{mobilePhone}, #{email})")
    void insert(Superintendent superintendent);

    @Delete("delete from superintendent where superintendent_id = #{superintendentId}")
    void delete(String superintendentId);

    @Update("update superintendent set superintendent_id = #{s.superintendentId}, name = #{s.name}, office_phone = #{s.officePhone}, " +
            "mobile_phone = #{s.mobilePhone}, email = #{s.email} where superintendent_id = #{oldSuperintendentId}")
    void update(String oldSuperintendentId, Superintendent s);
}
