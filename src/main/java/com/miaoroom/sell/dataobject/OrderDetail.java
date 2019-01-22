package com.miaoroom.sell.dataobject;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Description: 订单详情表
 * @create: 2019/1/22 14:13
 * @author: znnnnn
 */
@Entity
public class OrderDetail {

    @Id
    private String detailId;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品单价
     */
    private BigDecimal productPrice;

    /**
     * 商品数量
     */

    private Integer productQuantity;

    /**
     * 商品小图
     */
    private String productIcon;

}
