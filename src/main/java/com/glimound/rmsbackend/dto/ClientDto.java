package com.glimound.rmsbackend.dto;

import com.glimound.rmsbackend.pojo.ClientContact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private String clientName;
    private String address;
    private SuperintendentDto superintendent;
    private List<ClientContact> clientContactList;
}
