package com.porsche.sell.vo;

import lombok.Data;

/**
 * 封装结果集类
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/9
 */
@Data
public class ResultVo<T> {

    /**
     *  错误码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

}
