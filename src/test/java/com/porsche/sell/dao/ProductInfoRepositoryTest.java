package com.porsche.sell.dao;

import com.porsche.sell.entity.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 商品dao测试类
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1798123791");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(6));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的粥");
        productInfo.setProductIcon("D:/123.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(11);
        ProductInfo result = productInfoRepository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfos = productInfoRepository.findByProductStatus(0);
        Assert.assertEquals(1, productInfos.size());
    }
}