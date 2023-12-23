package com.glimound.rmsbackend.vo;

import com.glimound.rmsbackend.pojo.Secretary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecretaryListVo {
    private List<Secretary> secretaryList;
    private Long count;
}
