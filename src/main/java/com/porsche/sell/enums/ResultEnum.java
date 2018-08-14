package com.porsche.sell.enums;

import lombok.Getter;

/**
 * 系统接口结果常量枚举类
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/7/21
 */
@Getter
public enum ResultEnum {

    /**
     * 商品不存在
     */
    PRODUCT_NOT_EXIST(10, "商品不存在"),

    STOCK_NOT_ENOUGH(11, "库存不足"),

    ORDER_NOT_EXIST(12, "订单不存在"),

    ORDER_DETAIL_NOT_EXIST(13, "订单不存在"),

    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
