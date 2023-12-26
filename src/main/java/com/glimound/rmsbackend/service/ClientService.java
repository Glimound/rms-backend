package com.glimound.rmsbackend.service;

import com.glimound.rmsbackend.dto.ClientDto;
import com.glimound.rmsbackend.vo.ClientListVo;
import com.glimound.rmsbackend.vo.ClientVo;

public interface ClientService {
    /**
     * 分页查询所有委托方的信息
     */
    ClientListVo listClient(Integer page, Integer pageSize);

    /**
     * 查询委托方的信息及其负责人、联系人
     */
    ClientVo getClientFullInfo(String clientName);

    /**
     * 新增委托方信息及其负责人、联系人
     */
    void addClientFullInfo(ClientDto clientDto);

    /**
     * 更新委托方信息及其负责人、联系人
     */
    void updateClientFullInfo(String oldClientName, ClientDto clientDto);

    /**
     * 删除委托方信息及其负责人、联系人
     */
    void deleteClientFullInfo(String clientName);
}
