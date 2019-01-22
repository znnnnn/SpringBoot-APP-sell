package com.miaoroom.sell.dataobject;

import com.miaoroom.sell.enums.OrderStatusEnum;
import com.miaoroom.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 订单主表
 * @create: 2019/1/22 13:48
 * @author: znnnnn
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    /**
     * 订单ID
     */
    @Id
    private String orderId;

    /**买家名字*/
    private String buyerNmae;

    /**买家手机号*/
    private String buyerPhone;

    /** 卖家地址 */
    private String buyerOpenid;

    /** 买家Openid. */
    private String buyerAddress;

    /** 订单总金额*/
    private BigDecimal orderAmount;

    /** 订单状态*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态，默认为0未支付*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /**创建时间*/
    private Date createTime;

    /**更新时间*/
    private Date updateTime;




}
