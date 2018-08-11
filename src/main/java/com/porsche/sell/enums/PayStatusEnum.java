package com.porsche.sell.enums;

import lombok.Getter;

/**
 * 支付状态枚举
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/11
 */
@Getter
public enum PayStatusEnum {

    /**
     * 等待支付
     */
    WAIT(0, "等待支付"),

    /**
     * 支付成功
     */
    SUCCESS(1, "支付成功"),;

    private Integer code;

    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
