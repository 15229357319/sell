package com.porsche.sell.dao;

import com.porsche.sell.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品dao
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/7
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * 查询上架商品
     *
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
