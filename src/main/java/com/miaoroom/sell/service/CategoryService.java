package com.miaoroom.sell.service;

import com.miaoroom.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @Description: TODO
 * @create: 2019/1/19 19:19
 * @author: znnnnn
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);
}
