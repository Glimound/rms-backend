package com.glimound.rmsbackend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.glimound.rmsbackend.dto.CollaboratorDto;
import com.glimound.rmsbackend.dto.SuperintendentDto;
import com.glimound.rmsbackend.mapper.*;
import com.glimound.rmsbackend.pojo.*;
import com.glimound.rmsbackend.service.CollaboratorService;
import com.glimound.rmsbackend.vo.CollaboratorListVo;
import com.glimound.rmsbackend.vo.CollaboratorVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CollaboratorServiceImpl implements CollaboratorService {

    @Autowired
    private CollaboratorMapper collaboratorMapper;
    @Autowired
    private SuperintendentMapper superintendentMapper;
    @Autowired
    private CollaboratorContactMapper collaboratorContactMapper;

    /**
     * 分页查询所有合作方的信息
     */
    @Override
    public CollaboratorListVo listCollaborator(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Collaborator> collaboratorList = collaboratorMapper.selectAll();
        Page<Collaborator> p = (Page<Collaborator>) collaboratorList;
        return new CollaboratorListVo(p.getResult(), p.getTotal());
    }

    /**
     * 查询合作方的信息及其负责人、联系人
     */
    @Override
    public CollaboratorVo getCollaboratorFullInfo(String collaboratorName) {
        return collaboratorMapper.selectByName(collaboratorName);
    }

    /**
     * 新增合作方信息及其负责人、联系人
     */
    @Override
    @Transactional
    public void addCollaboratorFullInfo(CollaboratorDto collaboratorDto) {
        SuperintendentDto superintendentDto = collaboratorDto.getSuperintendent();
        List<CollaboratorContact> collaboratorContactList = collaboratorDto.getCollaboratorContactList();

        Superintendent superintendent = new Superintendent();
        BeanUtils.copyProperties(superintendentDto, superintendent);
        // 无需检查是否为null/list是否empty（完全参加）
        superintendentMapper.insert(superintendent);
        Integer superintendentId = superintendent.getSuperintendentId();

        Collaborator collaborator = new Collaborator(collaboratorDto.getCollaboratorName(), collaboratorDto.getAddress(), superintendentId);
        collaboratorMapper.insert(collaborator);

        for (CollaboratorContact c : collaboratorContactList) {
            collaboratorContactMapper.insert(c);
        }
    }

    /**
     * 更新合作方信息及其负责人、联系人
     */
    @Override
    @Transactional
    public void updateCollaboratorFullInfo(String oldCollaboratorName, CollaboratorDto collaboratorDto) {
        SuperintendentDto superintendentDto = collaboratorDto.getSuperintendent();
        List<CollaboratorContact> collaboratorContactList = collaboratorDto.getCollaboratorContactList();

        Integer superintendentId = collaboratorMapper.selectSuperintendentIdByName(oldCollaboratorName);
        Superintendent superintendent = new Superintendent();
        BeanUtils.copyProperties(superintendentDto, superintendent);
        superintendentMapper.update(superintendentId, superintendent);

        Collaborator collaborator = new Collaborator();
        BeanUtils.copyProperties(collaboratorDto, collaborator);
        collaborator.setSuperintendentId(superintendentId);
        collaboratorMapper.update(oldCollaboratorName, collaborator);

        // 清空再添加
        collaboratorContactMapper.clearCollaboratorContacts(oldCollaboratorName);
        for (CollaboratorContact c : collaboratorContactList) {
            collaboratorContactMapper.insert(c);
        }
    }

    /**
     * 删除合作方信息及其负责人、联系人
     */
    @Override
    @Transactional
    public void deleteCollaboratorFullInfo(String collaboratorName) {
        Integer superintendentId = collaboratorMapper.selectSuperintendentIdByName(collaboratorName);
        superintendentMapper.delete(superintendentId);
        collaboratorMapper.delete(collaboratorName);
    }

    /**
     * 关键字搜索：返回所有Collaborator
     */
    @Override
    public List<Collaborator> getCollaboratorMatched(String str) {
        return collaboratorMapper.getCollaboratorMatched(str);
    }
}
