package com.porsche.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品（包含类目）Vo
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/10
 * @JsonProperty 指定对象序列化的时候返回给前端的名字
 */
@Data
public class ProductVo {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVos;

}
