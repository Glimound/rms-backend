package com.glimound.rmsbackend.dto;

import com.glimound.rmsbackend.pojo.Director;
import com.glimound.rmsbackend.pojo.OfficeSpace;
import com.glimound.rmsbackend.pojo.ResearchLaboratory;
import com.glimound.rmsbackend.pojo.ScientificResearcher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResearchLaboratoryDto {
    private ResearchLaboratory researchLaboratory;
    private Director director;
    private List<ScientificResearcher> scientificResearcherList;
    private List<OfficeSpace> officeSpaceList;
}
