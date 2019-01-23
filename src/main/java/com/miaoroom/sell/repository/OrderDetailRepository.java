package com.miaoroom.sell.repository;

import com.miaoroom.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description: TODO
 * @create: 2019/1/22 14:31
 * @author: znnnnn
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    List<OrderDetail> findByOrderId(String orderId);
}