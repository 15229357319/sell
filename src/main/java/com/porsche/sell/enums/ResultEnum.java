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
     * 成功
     **/
    SUCCESS(1, "成功"),

    /**
     * 商品不存在
     */
    PRODUCT_NOT_EXIST(10, "商品不存在"),

    /**
     * 库存不足
     */
    STOCK_NOT_ENOUGH(11, "库存不足"),

    /**
     * 订单不存在
     */
    ORDER_NOT_EXIST(12, "订单不存在"),

    /**
     * 订单不存在
     */
    ORDER_DETAIL_NOT_EXIST(13, "订单详情不存在"),

    /**
     * 订单状态不正确
     */
    ORDER_STATUS_ERROR(14, "订单状态不正确"),

    /**
     * 订单更新失败
     */
    ORDER_UPDATE_FAIL(15, "订单更新失败"),

    /**
     * 订单详情为空
     */
    ORDER_DETAIL_EMPTY(16, "订单详情为空"),

    /**
     * 购物车为空
     */
    CART_EMPTY(17, "购物车为空"),

    /**
     * 订单取消成功
     **/
    ORDER_CANCEL_SUCCESS(18, "订单取消成功"),

    /**
     * 订单完结成功
     **/
    ORDER_FINISH_SUCCESS(19, "订单完结成功"),

    /**
     * 支付状态不正确
     */
    PAY_STATUS_ERROR(20, "支付状态不正确"),

    /**
     * 商品状态不正确
     */
    PRODUCT_STATUS_ERROR(21, "商品状态不正确"),

    /**
     * 商品上架成功
     */
    PRODUCT_ON_SALE_SUCCESS(22, "商品上架成功"),

    /**
     * 商品下架成功
     */
    PRODUCT_OFF_SALE_SUCCESS(23, "商品下架成功"),

    /**
     * 参数错误
     */
    PARAM_ERROR(30, "参数错误"),

    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
