package com.miaoroom.sell.exception;

import com.miaoroom.sell.enums.ResultEnum;

/**
 * @Description: TODO
 * @create: 2019/1/23 15:50
 * @author: znnnnn
 */
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }
}
