package com.porsche.sell.serviceimpl;

import com.porsche.sell.entity.ProductInfo;
import com.porsche.sell.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
/**
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo result = productService.findOne("1798123791");
        Assert.assertNotNull(result);
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("00283820");
        productInfo.setProductName("南瓜粥");
        productInfo.setProductPrice(new BigDecimal(5));
        productInfo.setProductStock(99);
        productInfo.setProductDescription("很好喝的粥");
        productInfo.setProductIcon("D:/234.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(13);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> result = productService.findUpAll();
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void findAll() {
        PageRequest request = PageRequest.of(0, 10);
        Page<ProductInfo> result = productService.findAll(request);
        Assert.assertEquals(1, result.getTotalPages());
    }
}