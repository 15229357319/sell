package com.porsche.sell.dao;

import com.porsche.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 类目dao
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/4
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
