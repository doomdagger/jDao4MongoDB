package com.fan1tuan.client.user.business;

import com.fan1tuan.business.support.Fan1TuanService;
import com.fan1tuan.business.support.StatusAwareResult;
import com.fan1tuan.business.support.enums.OrderStatus;
import com.fan1tuan.business.support.enums.ResultStatus;
import com.fan1tuan.pojos.Order;

import java.util.List;

/**
 * Created by Li He on 2014/4/21.
 * <p>实现业务功能包括：添加订单（一个或多个），修改订单状态（确认收货等），获取单个订单信息，根据条件查询订单。</p>
 * @author Li He
 */
public interface OrderService extends Fan1TuanService{

    StatusAwareResult<Boolean> addOrder(Order... orders);

    StatusAwareResult<Boolean> updateOrderStatus(String orderId, OrderStatus status);

    StatusAwareResult<Order> fetchOrder(String orderId);

    StatusAwareResult<List<Order>> fetchOrders(String userId, int pageNumber, int pageSize);

//    List<Order> fetchOrdersConditioned(String userId, int pageNumber, int pageSize);

//    List<Order> searchOrders(String userId, int pageNumber, int pageSize);


}
