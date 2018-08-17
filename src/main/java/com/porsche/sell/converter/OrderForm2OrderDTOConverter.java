package com.porsche.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.porsche.sell.dto.OrderDTO;
import com.porsche.sell.entity.OrderDetail;
import com.porsche.sell.enums.ResultEnum;
import com.porsche.sell.exception.SellException;
import com.porsche.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * OrderForm2OrderDTO转换器
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/17
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm){

        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetails = new ArrayList<>();
        try {
            orderDetails = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e){
            log.error("【对象转换】错误，String = {}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetails(orderDetails);

        return orderDTO;
    }

}
