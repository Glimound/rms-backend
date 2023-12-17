package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.Secretary;
import com.glimound.rmsbackend.vo.SecretaryVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SecretaryMapper {

    List<Secretary> selectAll();

    /**
     * 查询单个秘书信息及其所任职的各实验室
     */
    SecretaryVo selectById(String secretaryId);

    @Select("select count(*) from secretary")
    int count();

    @Insert("insert into secretary (secretary_id, name, gender, birth, employ_date, remit) values " +
            "(#{secretaryId}, #{name}, #{gender}, #{birth}, #{employDate}, #{remit})")
    void insert(Secretary secretary);

    @Delete("delete from secretary where secretary_id = #{secretaryId}")
    void delete(String secretaryId);

    @Update("update secretary set secretary_id = #{secretary.secretaryId}, name = #{secretary.name}, gender = #{secretary.gender}, " +
            "birth = #{secretary.birth}, employ_date = #{secretary.employDate}, remit = #{secretary.remit} where secretary_id = #{oldSecretaryId}")
    void update(String oldSecretaryId, Secretary secretary);
}
