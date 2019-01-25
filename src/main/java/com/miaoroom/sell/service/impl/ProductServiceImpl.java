package com.miaoroom.sell.service.impl;

import com.miaoroom.sell.dataobject.ProductInfo;
import com.miaoroom.sell.dto.CartDTO;
import com.miaoroom.sell.enums.ProductStatusEnum;
import com.miaoroom.sell.enums.ResultEnum;
import com.miaoroom.sell.exception.SellException;
import com.miaoroom.sell.repository.ProductInfoRepository;
import com.miaoroom.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: TODO
 * @create: 2019/1/20 14:58
 * @author: znnnnn
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList) {
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).get();
            if (productInfo == null) {
                throw new SellException((ResultEnum.PRODECU_NOT_EXIST));
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO carDTO : cartDTOList) {
            ProductInfo productInfo = repository.findById(carDTO.getProductId()).get();
            if (productInfo == null) {
                throw new SellException((ResultEnum.PRODECU_NOT_EXIST));
            }
            Integer result = productInfo.getProductStock() - carDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }
}
