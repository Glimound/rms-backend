package com.glimound.rmsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 不显示serial id的Superintendent dto对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuperintendentDto {
    private String name;
    private String officePhone;
    private String mobilePhone;
    private String email;
}
