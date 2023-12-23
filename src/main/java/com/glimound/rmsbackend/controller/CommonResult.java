package com.glimound.rmsbackend.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用返回对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    /**
     * 数据封装
     */
    protected T data;
}

// TODO: 全局todo：检查controller接受的dto是否存在字段为空，报错