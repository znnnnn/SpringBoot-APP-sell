package com.miaoroom.sell.enums;

import lombok.Getter;

/**
 * @Description: TODO
 * @create: 2019/1/23 15:51
 * @author: znnnnn
 */
@Getter
public enum ResultEnum {
    PRODECU_NOT_EXIST(10, "商品不存在"),

    PRODUCT_STOCK_ERROR(11, "商品库存不正确")
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
