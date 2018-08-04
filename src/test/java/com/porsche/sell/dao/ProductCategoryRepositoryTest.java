package com.porsche.sell.dao;

import com.porsche.sell.entity.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
//    @Transactional
//    @Rollback(false)
    public void saveOne(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(10);
        productCategory.setCategoryName("优惠商品");
        productCategory.setCategoryType(3);
        ProductCategory productCategory1 = productCategoryRepository.save(productCategory);
        log.info(productCategory1.toString());
    }

}