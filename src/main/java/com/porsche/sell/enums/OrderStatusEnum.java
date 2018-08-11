package com.porsche.sell.enums;

import lombok.Getter;

/**
 * 订单状态枚举
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/11
 */
@Getter
public enum OrderStatusEnum {

    /**
     * 新订单
     */
    NEW(0, "新订单"),

    /**
     * 订单完成
     */
    FINISHED(1, "订单完成"),

    /**
     * 取消订单
     */
    CANCELED(2, "取消订单"),;

    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
