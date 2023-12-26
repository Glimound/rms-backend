package com.glimound.rmsbackend.vo;

import com.glimound.rmsbackend.pojo.CollaboratorContact;
import com.glimound.rmsbackend.pojo.Superintendent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollaboratorVo {
    private String collaboratorName;
    private String address;
    private Superintendent superintendent;
    private List<CollaboratorContact> collaboratorContactList;
}
