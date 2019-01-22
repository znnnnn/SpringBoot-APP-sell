package com.miaoroom.sell.enums;

import lombok.Getter;

/**
 * @Description: TODO
 * @create: 2019/1/22 13:51
 * @author: znnnnn
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消");

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
