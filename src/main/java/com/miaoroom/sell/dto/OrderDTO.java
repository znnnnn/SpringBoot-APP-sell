package com.miaoroom.sell.dto;

import com.miaoroom.sell.dataobject.OrderDetail;
import com.miaoroom.sell.enums.OrderStatusEnum;
import com.miaoroom.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @create: 2019/1/23 15:33
 * @author: znnnnn
 */
@Data
public class OrderDTO {

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 买家名字
     */
    private String buyerName;

    /**
     * 买家手机号
     */
    private String buyerPhone;

    /**
     * 卖家地址
     */
    private String buyerOpenid;

    /**
     * 买家Openid.
     */
    private String buyerAddress;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 支付状态，默认为0未支付
     */
    private Integer payStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    List<OrderDetail> orderDetailList;
}
