package com.miaoroom.sell.repository;

import com.miaoroom.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description: TODO
 * @create: 2019/1/19 23:15
 * @author: znnnnn
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

}
