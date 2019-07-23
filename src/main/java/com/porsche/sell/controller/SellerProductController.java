package com.porsche.sell.controller;

import com.porsche.sell.entity.ProductInfo;
import com.porsche.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author Xu hao
 * @Description 卖家商品管理
 * @Version 1.0
 * Email 15229357319@sina.cn
 * create on 2019/7/22
 */
@Controller
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    private ProductService productService;

    /**
     * @Author Xu hao
     * @Description 商品管理列表
     * @Date 2019/7/23 22:41
     * @param page
     * @param size
     * @param map
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "3") Integer size,
                             Map<String, Object> map){
        PageRequest request = PageRequest.of(page - 1, size);
        Page<ProductInfo> list = productService.findAll(request);
        map.put("list", list);
        map.put("currentPage", page);
        map.put("currentSize", size);
        return new ModelAndView("product/list", map);
    }

}
