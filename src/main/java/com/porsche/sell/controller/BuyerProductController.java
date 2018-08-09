package com.porsche.sell.controller;

import com.porsche.sell.utils.ResultUtil;
import com.porsche.sell.entity.ProductCategory;
import com.porsche.sell.entity.ProductInfo;
import com.porsche.sell.service.CategoryService;
import com.porsche.sell.service.ProductService;
import com.porsche.sell.vo.ProductInfoVo;
import com.porsche.sell.vo.ProductVo;
import com.porsche.sell.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品Controllers
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/9
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/list")
    public ResultVo<ProductInfo> list(){
        // 1.查询所有上架商品
        List<ProductInfo> productInfos = productService.findUpAll();
        // 2.查询类目(一次性查询)
        // 精简方式(java8, lambda表达式)
        List<Integer> categoryTypes = productInfos.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(categoryTypes);
        // 3.数据封装
        List<ProductVo> productVos = new ArrayList<>();
        for (ProductCategory productCategory : productCategories){
            ProductVo productVo = new ProductVo();
            productVo.setCategoryType(productCategory.getCategoryType());
            productVo.setCategoryName(productCategory.getCategoryName());
            List<ProductInfoVo> productInfoVos = new ArrayList<>();
            for (ProductInfo productInfo : productInfos){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVos.add(productInfoVo);
                }
            }
            productVo.setProductInfoVos(productInfoVos);
            productVos.add(productVo);
        }
        return ResultUtil.success(productVos);
    }


}
