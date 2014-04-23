package com.fan1tuan.client.user.business.impl;

import com.fan1tuan.business.support.StatusAwareResult;
import com.fan1tuan.business.support.enums.OrderStatus;
import com.fan1tuan.business.support.enums.ResultStatus;
import com.fan1tuan.client.user.business.OrderService;
import com.fan1tuan.pojos.Order;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Li He on 2014/4/22.
 * @author Li He
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {


    @Override
    public StatusAwareResult<Boolean> addOrder(Order... orders) {
        return null;
    }


    @Override
    public StatusAwareResult<Boolean> updateOrderStatus(String orderId, OrderStatus status) {
        return null;
    }


    @Override
    public StatusAwareResult<Order> fetchOrder(String orderId) {
        return null;
    }

    @Override
    public StatusAwareResult<List<Order>> fetchOrders(String userId, int pageNumber, int pageSize) {
        return null;
    }
}
