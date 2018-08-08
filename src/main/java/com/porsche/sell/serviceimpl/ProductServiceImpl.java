package com.porsche.sell.serviceimpl;

import com.porsche.sell.dao.ProductInfoRepository;
import com.porsche.sell.entity.ProductInfo;
import com.porsche.sell.enums.ProductStatusEnum;
import com.porsche.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/** 商品ServiceImpl
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/8
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.getOne(productId);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.PRODUCT_UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
