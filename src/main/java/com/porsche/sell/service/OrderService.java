package com.porsche.sell.service;

import com.porsche.sell.dto.OrderDTO;
import com.porsche.sell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * OrderService
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/13
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询单个订单
     *
     * @param orderId
     * @return
     */
    OrderDTO findOne(String orderId);

    /**
     * 查询订单列表
     *
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**
     * 取消订单
     * @param orderDTO
     * @return
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单
     * @param orderDTO
     * @return
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单
     * @param orderDTO
     * @return
     */
    OrderDTO paid(OrderDTO orderDTO);


}
