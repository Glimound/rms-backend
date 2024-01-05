package com.glimound.rmsbackend.service;

import com.glimound.rmsbackend.dto.SecretaryDto;
import com.glimound.rmsbackend.pojo.Secretary;
import com.glimound.rmsbackend.vo.SecretaryListVo;
import com.glimound.rmsbackend.vo.SecretaryVo;

import java.util.List;

public interface SecretaryService {
    /**
     * 分页查询所有秘书的信息
     */
    SecretaryListVo listSecretary(Integer page, Integer pageSize);

    /**
     * 查询秘书的信息及其任职的各研究室
     */
    SecretaryVo getSecretaryFullInfo(String secretaryId);

    /**
     * 新增秘书信息及其任职的各研究室
     */
    void addSecretaryFullInfo(SecretaryDto secretaryDto);

    /**
     * 更新秘书信息及其任职的各研究室
     */
    void updateSecretaryFullInfo(String oldSecretaryId, SecretaryDto secretaryDto);

    /**
     * 删除秘书信息及其任职的各研究室
     */
    void deleteSecretaryFullInfo(String secretaryId);

    /**
     * 关键字搜索：返回所有Secretary
     */
    List<Secretary> getSecretaryMatched(String str);

}
