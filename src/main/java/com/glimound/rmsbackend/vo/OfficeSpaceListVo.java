package com.glimound.rmsbackend.vo;

import com.glimound.rmsbackend.pojo.OfficeSpace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeSpaceListVo {
    private List<OfficeSpace> officeSpaceList;
    private Long count;
}
