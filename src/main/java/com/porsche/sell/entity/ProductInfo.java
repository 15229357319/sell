package com.porsche.sell.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 商品信息
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/7
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     * 库存
     */
    private Integer productStock;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 商品小图
     */
    private String productIcon;

    /**
     * 状态：0-正常 1-下架
     */
    private Integer productStatus;

    /**
     * 类目编号
     */
    private Integer categoryType;

    public ProductInfo() {
    }

    public ProductInfo(String productId, String productName, BigDecimal productPrice, Integer productStock, String productDescription, String productIcon, Integer productStatus, Integer categoryType) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productIcon = productIcon;
        this.productStatus = productStatus;
        this.categoryType = categoryType;
    }
}
