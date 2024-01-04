package com.glimound.rmsbackend.controller;

import com.glimound.rmsbackend.dto.ClientDto;
import com.glimound.rmsbackend.service.ClientService;
import com.glimound.rmsbackend.vo.ClientListVo;
import com.glimound.rmsbackend.vo.ClientVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * 分页查询所有委托方的信息
     */
    @GetMapping
    public CommonResult<ClientListVo> listClient(@RequestParam(defaultValue = "1") Integer page,
                                                 @RequestParam(defaultValue = "10") Integer pageSize) {
        ClientListVo clientListVo = clientService.listClient(page, pageSize);
        return new CommonResult<>(clientListVo);
    }

    /**
     * 查询委托方的信息及其负责人、联系人
     */
    @GetMapping("/{clientName}")
    public CommonResult<ClientVo> getClientFullInfo(@PathVariable String clientName) {
        ClientVo clientVo = clientService.getClientFullInfo(clientName);
        return new CommonResult<>(clientVo);
    }

    /**
     * 新增委托方信息及其负责人、联系人
     */
    @PostMapping
    public void addClientFullInfo(@RequestBody ClientDto clientDto) {
        clientService.addClientFullInfo(clientDto);
    }

    /**
     * 更新委托方信息及其负责人、联系人
     */
    @PutMapping("/{clientName}")
    public void updateClientFullInfo(@PathVariable String clientName, @RequestBody ClientDto clientDto) {
        clientService.updateClientFullInfo(clientName, clientDto);
    }

    /**
     * 删除委托方信息及其负责人、联系人
     */
    @DeleteMapping("/{clientName}")
    public void deleteClientFullInfo(@PathVariable String clientName) {
       clientService.deleteClientFullInfo(clientName);
    }
}
