package com.porsche.sell.controller;

import com.porsche.sell.constant.Constant;
import com.porsche.sell.converter.OrderForm2OrderDTOConverter;
import com.porsche.sell.dto.OrderDTO;
import com.porsche.sell.entity.OrderDetail;
import com.porsche.sell.enums.ResultEnum;
import com.porsche.sell.exception.SellException;
import com.porsche.sell.form.OrderForm;
import com.porsche.sell.service.OrderService;
import com.porsche.sell.utils.ResultUtil;
import com.porsche.sell.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
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
     *
     * @return
     */
    @PostMapping("/create")
    public ResultVo<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建表单】参数不正确，orderForm = {}", orderForm.toString());
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        // 判断购物车为否为空
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetails())) {
            log.error("【创建表单】购物车为空，orderDetails = {}", orderDTO.getOrderDetails());
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        // 创建订单
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>(Constant.COLLECTION_DEFAULT_SIZE);
        map.put("orderId", createResult.getOrderId());
        return ResultUtil.success(map);

    }

    /**
     * 订单列表
     *
     * @return
     */
    @GetMapping(value = "/list")
    public ResultVo<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, pageRequest);
        return ResultUtil.success(orderDTOPage.getContent());
    }

    /**
     * 订单详情
     *
     * @return
     */
    @GetMapping("/detail")
    public ResultVo<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {

        // TODO 需要通过openid进行安全验证

        if (StringUtils.isEmpty(orderId)) {
            log.error("【订单详情】orderId为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO orderDTO = orderService.findOne(orderId);
        return ResultUtil.success(orderDTO);
    }

    /**
     * 取消订单
     *
     * @return
     */
    @PostMapping("/cancel")
    public ResultVo cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {

        // TODO   需要通过openid进行安全验证
        if (StringUtils.isEmpty(orderId)) {
            log.error("【取消订单】orderId为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO orderDTO = orderService.findOne(orderId);
        orderService.cancel(orderDTO);
        return ResultUtil.success();
    }
}
