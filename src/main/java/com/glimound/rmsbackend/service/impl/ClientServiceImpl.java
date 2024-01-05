package com.glimound.rmsbackend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.glimound.rmsbackend.dto.ClientDto;
import com.glimound.rmsbackend.dto.SuperintendentDto;
import com.glimound.rmsbackend.mapper.ClientContactMapper;
import com.glimound.rmsbackend.mapper.ClientMapper;
import com.glimound.rmsbackend.mapper.SuperintendentMapper;
import com.glimound.rmsbackend.pojo.Client;
import com.glimound.rmsbackend.pojo.ClientContact;
import com.glimound.rmsbackend.pojo.Superintendent;
import com.glimound.rmsbackend.service.ClientService;
import com.glimound.rmsbackend.vo.ClientListVo;
import com.glimound.rmsbackend.vo.ClientVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private SuperintendentMapper superintendentMapper;
    @Autowired
    private ClientContactMapper clientContactMapper;

    /**
     * 分页查询所有委托方的信息
     */
    @Override
    public ClientListVo listClient(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Client> clientList = clientMapper.selectAll();
        Page<Client> p = (Page<Client>) clientList;
        return new ClientListVo(p.getResult(), p.getTotal());
    }

    /**
     * 查询委托方的信息及其负责人、联系人
     */
    @Override
    public ClientVo getClientFullInfo(String clientName) {
        return clientMapper.selectByName(clientName);
    }

    /**
     * 新增委托方信息及其负责人、联系人
     */
    @Override
    @Transactional
    public void addClientFullInfo(ClientDto clientDto) {
        SuperintendentDto superintendentDto = clientDto.getSuperintendent();
        List<ClientContact> clientContactList = clientDto.getClientContactList();

        Superintendent superintendent = new Superintendent();
        BeanUtils.copyProperties(superintendentDto, superintendent);
        // 无需检查是否为null/list是否empty（完全参加）
        superintendentMapper.insert(superintendent);
        Integer superintendentId = superintendent.getSuperintendentId();

        Client client = new Client(clientDto.getClientName(), clientDto.getAddress(), superintendentId);
        clientMapper.insert(client);

        for (ClientContact c : clientContactList) {
            clientContactMapper.insert(c);
        }
    }

    /**
     * 更新委托方信息及其负责人、联系人
     */
    @Override
    @Transactional
    public void updateClientFullInfo(String oldClientName, ClientDto clientDto) {
        SuperintendentDto superintendentDto = clientDto.getSuperintendent();
        List<ClientContact> clientContactList = clientDto.getClientContactList();

        Integer superintendentId = clientMapper.selectSuperintendentIdByName(oldClientName);
        Superintendent superintendent = new Superintendent();
        BeanUtils.copyProperties(superintendentDto, superintendent);
        superintendentMapper.update(superintendentId, superintendent);

        Client client = new Client();
        BeanUtils.copyProperties(clientDto, client);
        client.setSuperintendentId(superintendentId);
        clientMapper.update(oldClientName, client);

        // 清空再添加
        clientContactMapper.clearClientContacts(oldClientName);
        for (ClientContact c : clientContactList) {
            clientContactMapper.insert(c);
        }
    }

    /**
     * 删除委托方信息及其负责人、联系人
     */
    @Override
    @Transactional
    public void deleteClientFullInfo(String clientName) {
        Integer superintendentId = clientMapper.selectSuperintendentIdByName(clientName);
        superintendentMapper.delete(superintendentId);
        clientMapper.delete(clientName);
    }

    /**
     * 关键字搜索：返回所有Client
     */
    @Override
    public List<Client> getClientMatched(String str) {
        return clientMapper.getClientMatched(str);
    }
}
