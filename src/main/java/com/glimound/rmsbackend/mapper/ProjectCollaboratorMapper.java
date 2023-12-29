package com.glimound.rmsbackend.mapper;

import com.glimound.rmsbackend.pojo.ProjectCollaborator;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ProjectCollaboratorMapper {

    @Insert("insert into project_collaborator (project_id, collaborator_name) values (#{projectId}, #{collaboratorName})")
    void insert(ProjectCollaborator projectCollaborator);

    @Delete("delete from project_collaborator where project_id = #{projectId} and collaborator_name = #{collaboratorName}")
    void delete(String projectId, String collaboratorName);

    @Update("update project_collaborator set project_id = #{pc.projectId}, collaborator_name = #{pc.collaboratorName} " +
            "where project_id = #{projectId} and collaborator_name = #{collaboratorName}")
    void update(String projectId, String collaboratorName, ProjectCollaborator pc);

    @Delete("delete from project_collaborator where project_id = #{projectId}")
    void clearById(String projectId);
}
