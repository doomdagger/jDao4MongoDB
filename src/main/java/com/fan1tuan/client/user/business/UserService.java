package com.fan1tuan.client.user.business;

import com.fan1tuan.business.support.Fan1TuanService;
import com.fan1tuan.business.support.StatusAwareResult;
import com.fan1tuan.business.support.enums.ResultStatus;
import com.fan1tuan.pojos.*;
import javafx.animation.Animation;

import java.util.List;

/**
 * Created by Li He on 2014/4/21.
 * <p>实现业务功能包括：查看收藏过的餐厅，查看收藏过的美食，获取用户的地址，查看优惠劵，用户信息修改等操作</p>
 * @author Li He
 */
public interface UserService extends Fan1TuanService{

    //todo: Add comments for methods

    StatusAwareResult<User> test();

    /**
     * 获取用户地址
     * @param userId 用户id
     * @return 返回用户地址(UserAddress)列表
     */
    StatusAwareResult<List<UserAddress>> fetchAddress(String userId);

    /**
     * 添加新的用户地址
     * @param userId 用户id
     * @param address 新的用户地址
     * @return 返回Boolean代表添加是否成功
     */
    StatusAwareResult<Boolean> addAddress(String userId, UserAddress address);

    /**
     * 获取用户已有的代金券
     * @param userId 用户id
     * @return 返回代金券(Coupon)列表
     */
    StatusAwareResult<List<Coupon>> fetchCoupons(String userId);

    /**
     * 获取餐厅收藏
     * @param userId 用户id
     * @return 餐厅收藏(ShopCollect)列表
     */
    StatusAwareResult<List<ShopCollect>> fetchShopCollects(String userId);

    /**
     * 添加餐厅收藏
     * @param userId 用户id
     * @param shopId 收藏的餐厅id
     * @return 返回Boolean代表添加是否成功
     */
    StatusAwareResult<Boolean> addShopCollect(String userId, String shopId);

    /**
     * 删除收藏餐厅
     * @param userId 用户id
     * @param shopCollectId 餐厅收藏(ShopCollect)id
     * @return 返回Boolean代表删除收藏是否成功
     */
    StatusAwareResult<Boolean> delShopCollect(String userId, String shopCollectId);

    /**
     * 获取美食收藏
     * @param userId 用户id
     * @return 返回美食收藏(DishCollect)列表
     */
    StatusAwareResult<List<DishCollect>> fetchDishCollects(String userId);

    /**
     * 添加美食收藏
     * @param userId 用户id
     * @param shopItemId 收藏的美食id
     * @param shopId 美食所属餐厅id
     * @return 返回Boolean代表添加收藏是否成功
     */
    StatusAwareResult<Boolean> addDishCollect(String userId, String shopItemId, String shopId);

    /**
     * 删除美食收藏
     * @param userId 用户id
     * @param dishCollectId 删除的美食收藏(DishCollect)id
     * @return 返回Boolean代表删除是否成功
     */
    StatusAwareResult<Boolean> delDishCollect(String userId, String dishCollectId);

    /**
     * 修改用户信息
     * <p>这个方法只能修改密码以外的用户信息</p>
     * @param user 用户模型
     * @return 返回Boolean代表修改是否成功
     */
    StatusAwareResult<Boolean> editUserInfo(User user);

    /**
     * 修改用户密码
     * @param userId 用户id
     * @param currentUserPassword 用户当前密码
     * @param newUserPassword 新密码
     * @return 返回Boolean代表修改是否成功
     */
    StatusAwareResult<Boolean> editUserPassword(String userId, String currentUserPassword, String newUserPassword);
}
