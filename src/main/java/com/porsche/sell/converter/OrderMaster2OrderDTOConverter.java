package com.porsche.sell.converter;

import com.porsche.sell.dto.OrderDTO;
import com.porsche.sell.entity.OrderMaster;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderMaster2OrderDTO转换器
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/15
 */
public class OrderMaster2OrderDTOConverter {

    /**
     * orderMaster转换成OrderDTO
     *
     * @param orderMaster
     * @return
     */
    public static OrderDTO converter(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    /**
     * List<OrderMaster>转List<OrderDTO>
     *
     * @param orderMasters
     * @return
     */
    public static List<OrderDTO> converter(List<OrderMaster> orderMasters) {
        return orderMasters.stream().map(e ->
                converter(e)
        ).collect(Collectors.toList());
    }


}
