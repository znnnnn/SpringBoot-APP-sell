package com.miaoroom.sell.service.impl;

import com.miaoroom.sell.dataobject.OrderDetail;
import com.miaoroom.sell.dataobject.OrderMaster;
import com.miaoroom.sell.dataobject.ProductInfo;
import com.miaoroom.sell.dto.CartDTO;
import com.miaoroom.sell.dto.OrderDTO;
import com.miaoroom.sell.enums.ResultEnum;
import com.miaoroom.sell.exception.SellException;
import com.miaoroom.sell.repository.OrderDetailRepository;
import com.miaoroom.sell.repository.OrderMasterRepository;
import com.miaoroom.sell.service.OrderService;
import com.miaoroom.sell.service.ProductService;
import com.miaoroom.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: TODO
 * @create: 2019/1/23 15:37
 * @author: znnnnn
 */
@Service
public class OrderServiceImpl implements OrderService {

    // 查询商品
    @Autowired
    private ProductService productService;

    // 计算商品总价
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    // 写入数据库
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        //1. 查询商品（数量，价格）
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException((ResultEnum.PRODECU_NOT_EXIST));
            }
            //2. 计算订单总价
            orderAmount = orderDetail.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            //Spring拷贝属性
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailRepository.save(orderDetail);
        }
        //3. 写入订单数据库（orderMaster和orderDetail）
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        //Spring拷贝 属性
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMasterRepository.save(orderMaster);
        //4. 扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);

        return orderDTO;
    }

    @Override
    public OrderDTO findOnes(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
