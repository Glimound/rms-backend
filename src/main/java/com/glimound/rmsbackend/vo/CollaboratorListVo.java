package com.glimound.rmsbackend.vo;

import com.glimound.rmsbackend.pojo.Collaborator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollaboratorListVo {
    private List<Collaborator> collaboratorList;
    private Long count;
}
