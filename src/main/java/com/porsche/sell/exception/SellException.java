package com.porsche.sell.exception;

import com.porsche.sell.enums.ResultEnum;

/**
 * 系统自定义异常类
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/13
 */
public class SellException extends RuntimeException {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
