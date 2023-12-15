package com.glimound.rmsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Superintendent {
    long superintendentId;
    String name;
    String officePhone;
    String mobilePhone;
    String email;
}