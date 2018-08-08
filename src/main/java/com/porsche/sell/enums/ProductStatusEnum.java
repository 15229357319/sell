package com.porsche.sell.enums;

import lombok.Getter;

/**  商品状态枚举类
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/8
 */

@Getter
public enum ProductStatusEnum {

    /**
     * 上架
     */
    PRODUCT_UP(0, "上架"),

    /**
     * 下架
     */
    PRODUCT_DOWN(1, "下架"),

    ;

    private Integer code;

    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
