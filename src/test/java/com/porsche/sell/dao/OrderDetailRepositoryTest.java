package com.porsche.sell.dao;

import com.porsche.sell.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("345678");
        orderDetail.setOrderId("123456");
        orderDetail.setProductId("667788");
        orderDetail.setProductName("表带");
        orderDetail.setProductPrice(new BigDecimal(00.00));
        orderDetail.setProductQuantity(1);
        orderDetail.setProductIcon("D:/234.png");
        repository.save(orderDetail);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> detailList = repository.findByOrderId("123456");
//        Assert.assertNotNull(detailList);
        Assert.assertEquals(2,detailList.size());
    }
}