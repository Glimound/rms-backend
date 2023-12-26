package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.Client;
import com.glimound.rmsbackend.vo.ClientVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClientMapper {
    @Select("select client_name, address, superintendent_id from client")
    List<Client> selectAll();

    /**
     * 查询单个委托方信息及其负责人、各联系人
     */
    ClientVo selectByName(String clientName);

    @Insert("insert into client (client_name, address, superintendent_id) values " +
            "(#{clientName}, #{address}, #{superintendentId})")
    void insert(Client client);

    @Delete("delete from client where client_name = #{clientName}")
    void delete(String clientName);

    // 负责人创建之后，绑定的id就不可变动（直到删除）
    @Update("update client set client_name = #{c.clientName}, address = #{c.address} where client_name = #{oldClientName}")
    void update(String oldClientName, Client c);

    @Select("select superintendent_id from client where client_name = #{clientName}")
    Integer selectSuperintendentIdByName(String clientName);
}
