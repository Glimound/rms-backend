package com.glimound.rmsbackend.service.impl;

import com.glimound.rmsbackend.dto.SecretaryDto;
import com.glimound.rmsbackend.mapper.ResearchLaboratoryMapper;
import com.glimound.rmsbackend.mapper.SecretaryMapper;
import com.glimound.rmsbackend.pojo.Secretary;
import com.glimound.rmsbackend.service.SecretaryService;
import com.glimound.rmsbackend.vo.SecretaryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SecretaryServiceImpl implements SecretaryService {

    @Autowired
    private SecretaryMapper secretaryMapper;

    @Autowired
    private ResearchLaboratoryMapper researchLaboratoryMapper;

    /**
     * 查询所有秘书的信息
     */
    @Override
    public List<Secretary> listSecretary(Integer limit, Integer offset) {
        return secretaryMapper.selectAll(limit, offset);
    }

    /**
     * 查询秘书的信息及其任职的各研究室
     */
    @Override
    public SecretaryVo getSecretaryFullInfo(String secretaryId) {
        return secretaryMapper.selectById(secretaryId);
    }

    /**
     * 新增秘书信息及其任职的各研究室
     */
    @Override
    @Transactional
    public void addSecretaryFullInfo(SecretaryDto dto) {
        Secretary secretary = dto.getSecretary();
        List<String> labNameList = dto.getLabNameList();
        secretaryMapper.insert(secretary);
        // 将lab表中对应项的secretaryId进行修改
        if (!labNameList.isEmpty())
            researchLaboratoryMapper.updateLabsSecretary(secretary.getSecretaryId(), labNameList);
    }

    /**
     * 更新秘书信息及其任职的各研究室
     */
    @Override
    @Transactional
    public void updateSecretaryFullInfo(String oldSecretaryId, SecretaryDto dto) {
        Secretary secretary = dto.getSecretary();
        List<String> labNameList = dto.getLabNameList();
        secretaryMapper.update(oldSecretaryId, secretary);
        // 将lab表中对应项的secretaryId置空，再进行修改
        researchLaboratoryMapper.clearLabsSecretary(secretary.getSecretaryId());
        if (!labNameList.isEmpty())
            researchLaboratoryMapper.updateLabsSecretary(secretary.getSecretaryId(), labNameList);
    }

    /**
     * 删除秘书信息及其任职的各研究室
     */
    @Override
    public void deleteSecretaryFullInfo(String secretaryId) {
        secretaryMapper.delete(secretaryId);
        // 无需置空研究室表对应键（级联置空）
    }
}
