package com.porsche.sell.dao;

import com.porsche.sell.entity.OrderMaster;
import com.porsche.sell.enums.OrderStatusEnum;
import com.porsche.sell.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private static final String OPNEID = "whwe98f23b2330r2u03r";

    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("徐浩");
        orderMaster.setBuyerAddress("茶张新苑");
        orderMaster.setBuyerOpenid(OPNEID);
        orderMaster.setBuyerPhone("15229357319");
        orderMaster.setOrderAmount(new BigDecimal(100.00));
        orderMaster.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        orderMaster.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        repository.save(orderMaster);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest request = PageRequest.of(0, 10);
        Page<OrderMaster> orderMasters = repository.findByBuyerOpenid(OPNEID, request);
        Assert.assertEquals(1, orderMasters.getTotalElements());
    }
}