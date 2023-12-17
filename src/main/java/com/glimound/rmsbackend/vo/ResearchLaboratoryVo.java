package com.glimound.rmsbackend.vo;

import com.glimound.rmsbackend.pojo.Director;
import com.glimound.rmsbackend.pojo.OfficeSpace;
import com.glimound.rmsbackend.pojo.ScientificResearcher;
import com.glimound.rmsbackend.pojo.Secretary;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResearchLaboratoryVo {
    private String labName;
    private String researchDirection;
    private Secretary secretary;
    private Director director;
    private List<OfficeSpace> officeSpaceList;
    private List<ScientificResearcher> scientificResearcherList;
}
