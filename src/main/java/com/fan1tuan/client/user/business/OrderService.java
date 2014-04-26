package com.fan1tuan.client.user.business;

import com.fan1tuan.business.support.Fan1TuanService;
import com.fan1tuan.business.support.StatusAwareResult;
import com.fan1tuan.business.support.enums.DishStatus;
import com.fan1tuan.business.support.enums.OrderStatus;
import com.fan1tuan.business.support.enums.ResultStatus;
import com.fan1tuan.pojos.Order;

import java.util.Date;
import java.util.List;

/**
 * Created by Li He on 2014/4/21.
 * <p>实现业务功能包括：添加订单（一个或多个），修改订单状态（确认收货等），获取单个订单信息，根据条件查询订单。</p>
 * @author Li He
 */
public interface OrderService extends Fan1TuanService{

    /**
     * 添加一个订单或添加多个订单，用户确认订单时会执行
     * 此业务方法，一次性添加多个订单到数据库，此时订单
     * 应当存有用户ID以作关联。
     * @param orders 不定参，多个order实体
     * @return 返回Boolean，代表添加订单是否成功
     */
    StatusAwareResult<Boolean> addOrder(Order... orders);

    /**
     * 修改订单状态，用户能够在下单后修改的仅有订单状态，
     * 例如，在收到货物后确认订单，将订单中菜品全部评价完后，
     * 更新订单状态为已评价。
     * @param orderId 需要更新的订单ID
     * @param status  将订单更新至的状态
     * @return 返回Boolean，代表更新订单状态是否成功
     */
    StatusAwareResult<Boolean> updateOrderStatus(String orderId, OrderStatus status);

    /**
     * 获取一个订单对象，根据订单ID来获取
     * @param orderId 要获取的订单的ID
     * @return 返回订单对象
     */
    StatusAwareResult<Order> fetchOrder(String orderId);

    /**
     * 分页查询订单
     * @param userId 查询的用户id
     * @param pageNumber [分页]需要查询第几页
     * @param pageSize [分页]每页包含的订单数量
     * @return 返回多个订单对象的列表
     */
    StatusAwareResult<List<Order>> fetchOrders(String userId, int pageNumber, int pageSize);

//    List<Order> fetchOrdersConditioned(String userId, int pageNumber, int pageSize);

//    List<Order> searchOrders(String userId, int pageNumber, int pageSize);

    /**
     * 根据订单状态查询订单
     * @param userId 查询者的用户id
     * @param dishStatus [条件]需要查询的订单状态
     * @param pageNumber [分页]需要查询第几页
     * @param pageSize [分页]每页包含的订单数量
     * @return 返回多个订单对象的列表
     */
    StatusAwareResult<List<Order>> fetchOrdersConditioned(String userId, DishStatus dishStatus,
                                                          int pageNumber, int pageSize);

    /**
     * 根据餐厅名称查询订单
     * @param userId 查询者的用户id
     * @param shopName [条件]餐厅名称
     * @param pageNumber [分页]需要查询第几页
     * @param pageSize [分页]每页包含的订单数量
     * @return 返回多个订单对象的列表
     */
    StatusAwareResult<List<Order>> fetchOrdersConditioned(String userId, String shopName,
                                                          int pageNumber, int pageSize);

    /**
     * 根据订单日期查询订单
     * @param userId 查询者的用户id
     * @param dateBegin [条件]订单日期区间的起始日期
     * @param dateEnd [条件]订单日期区间的结束日期
     * @param pageNumber [分页]需要查询第几页
     * @param pageSize [分页]每页包含的订单数量
     * @return 返回多个订单对象的列表
     */
    StatusAwareResult<List<Order>> fetchOrdersConditioned(String userId, Date dateBegin, Date dateEnd,
                                                          int pageNumber, int pageSize);

    /**
     * 根据多种条件查询订单
     * @param userId 查询者的用户id
     * @param dishStatus [条件]需要查询的订单状态
     * @param shopName [条件]餐厅名称
     * @param dateBegin [条件]订单日期区间的起始日期
     * @param dateEnd [条件]订单日期区间的结束日期
     * @param pageNumber [分页]需要查询第几页
     * @param pageSize [分页]每页包含的订单数量
     * @return 返回多个订单对象的列表
     */
    StatusAwareResult<List<Order>> fetchOrdersConditioned(String userId, DishStatus dishStatus,
                                                          String shopName, Date dateBegin, Date dateEnd,
                                                          int pageNumber, int pageSize);

}
