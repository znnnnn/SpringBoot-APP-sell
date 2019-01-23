package com.miaoroom.sell.dto;

import lombok.Data;

/**
 * @Description: 购物车
 * @create: 2019/1/23 16:54
 * @author: znnnnn
 */
@Data
public class CartDTO {
    //商品Id
    private String productId;

    //数量
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
