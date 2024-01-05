package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.Collaborator;
import com.glimound.rmsbackend.vo.CollaboratorVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CollaboratorMapper {
    @Select("select collaborator_name, address, superintendent_id from collaborator")
    List<Collaborator> selectAll();

    /**
     * 查询单个合作方信息及其负责人、各联系人
     */
    CollaboratorVo selectByName(String collaboratorName);

    @Insert("insert into collaborator (collaborator_name, address, superintendent_id) values " +
            "(#{collaboratorName}, #{address}, #{superintendentId})")
    void insert(Collaborator collaborator);

    @Delete("delete from collaborator where collaborator_name = #{collaboratorName}")
    void delete(String collaboratorName);

    // 负责人创建之后，绑定的id就不可变动（直到删除）
    @Update("update collaborator set collaborator_name = #{c.collaboratorName}, address = #{c.address} " +
            "where collaborator_name = #{oldCollaboratorName}")
    void update(String oldCollaboratorName, Collaborator c);

    @Select("select superintendent_id from collaborator where collaborator_name = #{collaboratorName}")
    Integer selectSuperintendentIdByName(String collaboratorName);

    @Select("select collaborator_name, address, superintendent_id from collaborator where collaborator_name like concat('%',#{str},'%')")
    List<Collaborator> getCollaboratorMatched(String str);
}
