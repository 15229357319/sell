package com.porsche.sell.serviceimpl;

import com.porsche.sell.dto.OrderDTO;
import com.porsche.sell.entity.OrderDetail;
import com.porsche.sell.enums.OrderStatusEnum;
import com.porsche.sell.enums.PayStatusEnum;
import com.porsche.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 订单Service测试类
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/13
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    private static final String OPENID = "1012011nf22o3938ncbvsdbv";

    private static final String ORDERID = "1534175072601793189";

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("徐浩");
        orderDTO.setBuyerAddress("茶张新苑");
        orderDTO.setBuyerPhone("15229357319");
        orderDTO.setBuyerOpenid(OPENID);

        // 购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        OrderDetail o2 = new OrderDetail();
        o1.setProductId("00283820");
        o1.setProductQuantity(2);
        o2.setProductId("1798123791");
        o2.setProductQuantity(3);
        orderDetailList.add(o1);
        orderDetailList.add(o2);
        orderDTO.setOrderDetails(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】: result = {}" + result);
        Assert.assertNotNull(result);
    }

    @Test
    @Transactional
    public void findOne() {
        OrderDTO result = orderService.findOne(ORDERID);
        log.info("【查询单个订单】: result = {}" + result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findList() {
        PageRequest request = PageRequest.of(0, 10);
        Page<OrderDTO> orderDTOS = orderService.findList(OPENID, request);
        log.info("【查询订单列表】：result = {}" + orderDTOS);
        Assert.assertEquals(2, orderDTOS.getTotalElements());
    }

    @Test
    @Transactional
    public void cancel() {

        OrderDTO result = orderService.findOne(ORDERID);
        result = orderService.cancel(result);
        Assert.assertEquals(OrderStatusEnum.CANCELED.getCode(), result.getOrderStatus());

    }

    @Test
    @Transactional
    public void finish() {
        OrderDTO result = orderService.findOne(ORDERID);
        OrderDTO finish = orderService.finish(result);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), finish.getOrderStatus());
    }

    @Test
    @Transactional
    public void paid() {
        OrderDTO result = orderService.findOne(ORDERID);
        OrderDTO finish = orderService.paid(result);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), finish.getPayStatus());
    }
}