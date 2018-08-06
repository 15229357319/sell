package com.porsche.sell.serviceimpl;

import com.porsche.sell.entity.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * CategoryServiceImpl测试类
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory result = categoryService.findOne(11);
        Assert.assertEquals(new Integer(11), result.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategories = categoryService.findAll();
//        Assert.assertEquals(new Integer(5), new Integer(productCategories.size()));
        Assert.assertNotEquals(0, productCategories.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> categoryTypes = Arrays.asList(2, 3, 7);
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(categoryTypes);
        Assert.assertEquals(3, productCategories.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("优惠购", 9);
        Assert.assertNotEquals(null, productCategory);

    }
}