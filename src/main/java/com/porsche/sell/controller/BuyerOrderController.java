package com.porsche.sell.controller;

import com.porsche.sell.constant.Constant;
import com.porsche.sell.converter.OrderForm2OrderDTOConverter;
import com.porsche.sell.dto.OrderDTO;
import com.porsche.sell.enums.ResultEnum;
import com.porsche.sell.exception.SellException;
import com.porsche.sell.form.OrderForm;
import com.porsche.sell.service.OrderService;
import com.porsche.sell.utils.ResultUtil;
import com.porsche.sell.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 买家订单Api
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/17
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * @return
     */
    @PostMapping("/create")
    public ResultVo<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建表单】参数不正确，orderForm = {}", orderForm.toString());
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        // 判断购物车为否为空
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetails())){
            log.error("【创建表单】购物车为空，orderDetails = {}", orderDTO.getOrderDetails());
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        // 创建订单
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>(Constant.COLLECTION_DEFAULT_SIZE);
        map.put("orderId", createResult.getOrderId());
        return ResultUtil.success(map);
    }

    // 订单列表

    // 订单详情

    // 取消订单


}
