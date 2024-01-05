package com.glimound.rmsbackend.vo;

import com.glimound.rmsbackend.pojo.ScientificResearcher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScientificResearcherListVo {
    private List<ScientificResearcher> scientificResearcherList;
    private Long count;
}
