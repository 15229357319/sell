package com.porsche.sell.service;

import com.porsche.sell.dto.CartDTO;
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
     *
     * @param productId
     * @return
     */
    ProductInfo findOne(String productId);

    /**
     * 保存商品信息
     *
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
     *
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 加库存
     *
     * @param cartDTOList
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 库减存
     *
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * @Author Xu hao
     * @Description 上架
     * @Date 2019/7/25 22:28
     * @param productId
     * @return com.porsche.sell.entity.ProductInfo
     **/
    ProductInfo onSale(String productId);

    /**
     * @Author Xu hao
     * @Description 下架
     * @Date 2019/7/25 22:29
     * @param productId
     * @return com.porsche.sell.entity.ProductInfo
     **/
    ProductInfo offSale(String productId);


}
