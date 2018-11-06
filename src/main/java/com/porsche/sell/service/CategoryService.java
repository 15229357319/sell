package com.porsche.sell.service;

import com.porsche.sell.entity.ProductCategory;

import java.util.List;

/**
 * 类目service
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/6
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
