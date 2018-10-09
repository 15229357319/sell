package com.porsche.sell.dao;

import com.porsche.sell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 订单dao
 *
 * @author XuHao
 * Email 15229357319@sina.cn
 * create on 2018/8/11
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /**
     * 查询指定用户订单
     *
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);



}
