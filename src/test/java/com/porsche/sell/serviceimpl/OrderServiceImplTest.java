package com.porsche.sell.serviceimpl;

import com.porsche.sell.dto.OrderDTO;
import com.porsche.sell.entity.OrderDetail;
import com.porsche.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}