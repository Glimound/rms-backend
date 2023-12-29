package com.glimound.rmsbackend.vo;

import com.glimound.rmsbackend.pojo.ResearchProject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResearchProjectListVo {
    private List<ResearchProject> researchProjectList;
    private Long count;
}
