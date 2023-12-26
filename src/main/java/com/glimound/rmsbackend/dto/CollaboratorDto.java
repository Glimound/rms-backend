package com.glimound.rmsbackend.dto;

import com.glimound.rmsbackend.pojo.CollaboratorContact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollaboratorDto {
    private String collaboratorName;
    private String address;
    private SuperintendentDto superintendent;
    private List<CollaboratorContact> collaboratorContactList;
}
