package com.glimound.rmsbackend.dto;

import com.glimound.rmsbackend.pojo.Secretary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecretaryDto {
    private Secretary secretary;
    private List<String> labNameList;
}
