package com.glimound.rmsbackend.vo;

import com.glimound.rmsbackend.pojo.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientListVo {
    private List<Client> clientList;
    private Long count;
}
