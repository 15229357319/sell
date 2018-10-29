package com.porsche.sell.controller;

import com.porsche.sell.dto.OrderDTO;
import com.porsche.sell.service.OrderService;
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
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map){
        PageRequest request = PageRequest.of(page - 1, size);
        Page<OrderDTO> list = orderService.findList(request);
        map.put("list", list);
        return new ModelAndView("order/list", map);
    }

}
