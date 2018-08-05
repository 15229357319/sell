package com.porsche.sell.dao;

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

/** dao测试类
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    @Transactional
    public void findOne(){
        ProductCategory productCategory = productCategoryRepository.getOne(1);
        log.info(productCategory.toString());
    }

    @Test
    @Transactional
    @Rollback(false)
    public void saveOne(){
        ProductCategory productCategory = new ProductCategory("夏日凉饮", 6);
        ProductCategory result = productCategoryRepository.save(productCategory);
        // 使用断言判断结果的正确性
        Assert.assertNotNull(result);
//        Assert.assertNotEquals(null, result);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> categorys = Arrays.asList(2, 3, 6);
        List<ProductCategory> productCategories = productCategoryRepository.findByCategoryTypeIn(categorys);
        Assert.assertNotEquals(0, productCategories.size());
    }

}