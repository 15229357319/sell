package com.porsche.sell.serviceimpl;

import com.porsche.sell.dao.OrderDetailRepository;
import com.porsche.sell.dao.OrderMasterRepository;
import com.porsche.sell.dto.CartDTO;
import com.porsche.sell.dto.OrderDTO;
import com.porsche.sell.entity.OrderDetail;
import com.porsche.sell.entity.OrderMaster;
import com.porsche.sell.entity.ProductInfo;
import com.porsche.sell.enums.OrderStatusEnum;
import com.porsche.sell.enums.PayStatusEnum;
import com.porsche.sell.enums.ResultEnum;
import com.porsche.sell.exception.SellException;
import com.porsche.sell.service.OrderService;
import com.porsche.sell.service.ProductService;
import com.porsche.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单ServiceImpl
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/13
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository detailRepository;

    @Autowired
    private  OrderMasterRepository masterRepository;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.getUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        // 1.查询商品(数量、价格)
        for (OrderDetail orderDetail : orderDTO.getOrderDetails()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (null == productInfo) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIXT);
            }
            // 2.计算总价
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
            // 订单详情入库
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);
            detailRepository.save(orderDetail);
        }
        // 3.写入订单数据库(orderMaster orderDetail)
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        masterRepository.save(orderMaster);
        // 4.扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetails().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
