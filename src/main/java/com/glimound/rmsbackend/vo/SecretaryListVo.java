package com.glimound.rmsbackend.vo;

import com.glimound.rmsbackend.pojo.Secretary;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SecretaryListVo {
    private List<Secretary> secretaryList;
    private Long count;
}
