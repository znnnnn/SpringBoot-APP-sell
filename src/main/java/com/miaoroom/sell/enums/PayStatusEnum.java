package com.miaoroom.sell.enums;

import lombok.Getter;

/**
 * @Description: TODO
 * @create: 2019/1/22 14:00
 * @author: znnnnn
 */

@Getter
public enum PayStatusEnum {

    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),

    ;


    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
