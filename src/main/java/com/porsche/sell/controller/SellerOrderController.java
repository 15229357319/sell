package com.porsche.sell.controller;

import com.porsche.sell.dto.OrderDTO;
import com.porsche.sell.enums.ResultEnum;
import com.porsche.sell.exception.SellException;
import com.porsche.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author Xu hao
 * @Description 卖家端订单
 * @Version 1.0
 * Email 15229357319@sina.cn
 * create on 2018/10/29
 */
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * @Author Xu hao
     * @Description 订单列表
     * @Date 2018/10/29 22:06
     * @param page 第几页
     * @param size 每页多少条数据
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "3") Integer size,
                             Map<String, Object> map){
        PageRequest request = PageRequest.of(page - 1, size);
        Page<OrderDTO> list = orderService.findList(request);
        map.put("list", list);
        map.put("currentPage", page);
        map.put("currentSize", size);
        return new ModelAndView("order/list", map);
    }

    /**
     * @Author Xu hao
     * @Description 取消订单
     * @Date 2018/11/5 21:26
     * @param orderId
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
                               Map<String, Object> map){
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        } catch (Exception e){
            log.error("【卖家端取消订单】 取消订单发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMsg());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }

    /**
     * @Author Xu hao
     * @Description 订单详情
     * @Date 2018/11/6 20:24
     * @param orderId
     * @param map
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String, Object> map){
        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO = orderService.findOne(orderId);
        } catch (SellException e){
            log.error("【卖家端查询订单详情】查询订单详情发送异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("orderDTO", orderDTO);
        return new ModelAndView("order/detail", map);

    }

    /**
     * @Author Xu hao
     * @Description 完结订单
     * @Date 2018/11/7 23:11
     * @param orderId
     * @param map
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,
                               Map<String, Object> map){
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        } catch (SellException e){
            log.error("【卖家端完结订单】完结订单发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMsg());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }

}
