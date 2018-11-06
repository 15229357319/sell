package com.porsche.sell.dto;

import lombok.Data;

/**
 * 购物车
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/13
 */
@Data
public class CartDTO {

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
