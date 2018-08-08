package com.porsche.sell.service;

import com.porsche.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品Service
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/8
 */
public interface ProductService {

    /**
     * 通过商品ID查询商品
      * @param productId
     * @return
     */
    ProductInfo findOne(String productId);

    /**
     * 保存商品信息
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 查询上架商品列表
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 分页查询所有商品列表
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 加库存
     *
     */

    /**
     * 减库存
     *
     */






}
