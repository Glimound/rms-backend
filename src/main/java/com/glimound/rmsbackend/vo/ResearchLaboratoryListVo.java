package com.glimound.rmsbackend.vo;

import com.glimound.rmsbackend.pojo.ResearchLaboratory;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResearchLaboratoryListVo {
    private List<ResearchLaboratory> researchLaboratoryList;
    private Long count;
}
