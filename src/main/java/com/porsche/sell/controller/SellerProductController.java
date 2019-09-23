package com.porsche.sell.controller;

import com.porsche.sell.entity.ProductCategory;
import com.porsche.sell.entity.ProductInfo;
import com.porsche.sell.enums.ResultEnum;
import com.porsche.sell.service.CategoryService;
import com.porsche.sell.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
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
@Slf4j
public class SellerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

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

    /**
     * @Author Xu hao
     * @Description 商品上架
     * @Date 2019/7/25 23:17
     * @param productId
     * @param map
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @GetMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String, Object> map){
        try {
            productService.onSale(productId);
        } catch (Exception e){
            log.error("【商品上架】 商品上架发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.PRODUCT_ON_SALE_SUCCESS.getMsg());
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    /**
     * @Author Xu hao
     * @Description 商品下架
     * @Date 2019/7/25 23:17
     * @param productId
     * @param map
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @GetMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                               Map<String, Object> map){
        try {
            productService.offSale(productId);
        } catch (Exception e){
            log.error("【商品下架】 商品下架发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.PRODUCT_OFF_SALE_SUCCESS.getMsg());
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    /**
     * @Author Xu hao
     * @Description 修改商品信息
     * @Date 2019/9/23 22:15
     * @param productId
     * @param map
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                      Map<String, Object> map) {
        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo", productInfo);
        }
        // 查询所有的类目
        List<ProductCategory> categories = categoryService.findAll();
        map.put("categories", categories);

        return new ModelAndView("product/index", map);
    }

}
