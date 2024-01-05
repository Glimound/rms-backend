package com.glimound.rmsbackend.service;

import com.glimound.rmsbackend.dto.CollaboratorDto;
import com.glimound.rmsbackend.pojo.Collaborator;
import com.glimound.rmsbackend.vo.CollaboratorListVo;
import com.glimound.rmsbackend.vo.CollaboratorVo;

import java.util.List;

public interface CollaboratorService {
    /**
     * 分页查询所有合作方的信息
     */
    CollaboratorListVo listCollaborator(Integer page, Integer pageSize);

    /**
     * 查询合作方的信息及其负责人、联系人
     */
    CollaboratorVo getCollaboratorFullInfo(String collaboratorName);

    /**
     * 新增合作方信息及其负责人、联系人
     */
    void addCollaboratorFullInfo(CollaboratorDto collaboratorDto);

    /**
     * 更新合作方信息及其负责人、联系人
     */
    void updateCollaboratorFullInfo(String oldCollaboratorName, CollaboratorDto collaboratorDto);

    /**
     * 删除合作方信息及其负责人、联系人
     */
    void deleteCollaboratorFullInfo(String collaboratorName);

    /**
     * 关键字搜索：返回所有Collaborator
     */
    List<Collaborator> getCollaboratorMatched(String str);
}
