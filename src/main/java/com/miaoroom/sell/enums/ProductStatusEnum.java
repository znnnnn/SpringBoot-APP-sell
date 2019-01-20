package com.miaoroom.sell.enums;

import lombok.Getter;

import java.security.PrivateKey;

/**
 * @Description: 商品状态
 * @create: 2019/1/20 15:03
 * @author: znnnnn
 */
@Getter
public enum ProductStatusEnum {
    UP(0, "在架"),
    DOWN(1, "下架")
    ;
    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }}
