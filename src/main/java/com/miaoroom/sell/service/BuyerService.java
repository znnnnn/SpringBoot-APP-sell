package com.miaoroom.sell.service;

import com.miaoroom.sell.dto.OrderDTO;

/**
 * @Description: 买家
 * @create: 2019/1/26 15:37
 * @author: znnnnn
 */
public interface BuyerService {
    // 查询一个订单
    OrderDTO findOrderOne(String openId, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openId, String orderId);
}
