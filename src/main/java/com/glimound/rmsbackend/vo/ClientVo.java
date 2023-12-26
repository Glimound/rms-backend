package com.glimound.rmsbackend.vo;

import com.glimound.rmsbackend.pojo.ClientContact;
import com.glimound.rmsbackend.pojo.Superintendent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientVo {
    private String clientName;
    private String address;
    private Superintendent superintendent;
    private List<ClientContact> clientContactList;
}
