package com.porsche.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xu hao
 * @Description
 * @Version 1.0
 * Email 15229357319@sina.cn
 * create on 2018/9/1
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code){
        log.info(">>>>>>>>>>>进去auth<<<<<<<<<<");
        log.info("code={}", code);

    }

}
