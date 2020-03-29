package com.github.springcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author: ouyang
 * Date:2020/3/28 16:14
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T     data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
