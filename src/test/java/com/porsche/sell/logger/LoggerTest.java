package com.porsche.sell.logger;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 日志测试类
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/7/31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    @Test
    public void test1() {
        String name = "XuHao";
        String password = "123456";
        log.debug("===============debug=============");
        log.info("name: " + name + ", password: " + password);
        // 使用{}占位符写法
        log.info("name:{}, password:{}", name, password);
        log.error("===============error=============");
        log.warn("===============warn=============");
    }

}
