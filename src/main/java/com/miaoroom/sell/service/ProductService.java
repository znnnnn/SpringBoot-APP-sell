package com.miaoroom.sell.service;

import com.miaoroom.sell.dataobject.ProductInfo;
import com.miaoroom.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description: TODO
 * @create: 2019/1/20 14:53
 * @author: znnnnn
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有上架的 商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    // 加库存
    void increaseStock(List<CartDTO> cartDTOList);

    // 减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
