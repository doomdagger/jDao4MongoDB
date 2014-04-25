package com.fan1tuan.client.user.business;

import com.fan1tuan.business.support.Fan1TuanService;
import com.fan1tuan.business.support.StatusAwareResult;
import com.fan1tuan.business.support.enums.ResultStatus;
import com.fan1tuan.pojos.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.animation.Animation;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Created by Li He on 2014/4/21.
 * <p>实现业务功能包括：查看收藏过的餐厅，查看收藏过的美食，获取用户的地址，查看优惠劵，用户信息修改等操作</p>
 * @author Li He
 */
public interface UserService extends Fan1TuanService{

    //todo: Discussion needed for (?)-marked comments...

    StatusAwareResult<User> test();

    /**
     * 用户身份验证
     * @param username 用户名
     * @param password 用户密码
     * @return 返回Boolean代表用户是否存在
     */
    StatusAwareResult<Boolean> userExist(String username, String password);

    /**
     * 修改用户信息
     * <b>这个方法只能修改密码以外的用户信息</b>
     * @param user 用户模型
     * @return 返回Boolean代表修改是否成功
     */
    StatusAwareResult<Boolean> editUserInfo(User user);

    /**
     * 添加新的用户地址
     * @param userId 用户id
     * @param address 新的用户地址
     * @return 返回Boolean代表添加是否成功
     */
    StatusAwareResult<Boolean> addAddress(String userId, UserAddress address);

    /**
     * 删除用户地址
     * @param userId 用户id
     * @param address (?)用户地址(UserAddress)实体
     * @return 返回Boolean代表删除是否成功
     */
    StatusAwareResult<Boolean> delAddress(String userId, UserAddress address);

//    有待讨论。addressId: List<UserAddress>的下标
//    StatusAwareResult<Boolean> delAddressById(String userId, String addressId);

    /**
     * 为用户添加代金券
     * <b>此方法只给用户添加代金券，需要额外为餐厅添加存根</b>
     * @param userId 用户id
     * @param coupon 代金券(Coupon)实体
     * @return 返回Boolean代表添加是否成功
     */
    StatusAwareResult<Boolean> addCoupon(String userId, Coupon coupon);

    /**
     * 使用用户已有代金券
     * @param userId 用户id
     * @param couponCode 欲使用的代金券编号
     * @return 返回Boolean代表使用是否成功
     */
    StatusAwareResult<Boolean> useCoupon(String userId, String couponCode);

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
     * 添加美食至购物车
     * @param userId 用户id
     * @param shopItem 美食
     * @return 返回Boolean代表添加是否成功
     */
    StatusAwareResult<Boolean> addDishToShoppingCart(String userId, ShopItem shopItem);

    /**
     * 从购物车中移除美食
     * @param userId 用户id
     * @param shopItemId 移除的美食(ShopItem)id
     * @return 返回Boolean代表移除是否成功
     */
    StatusAwareResult<Boolean> delDishFromShoppingCart(String userId, String shopItemId);

    /**
     * 增加经验并计算用户等级
     * @param userId 用户id
     * @param exp 本次获得的经验值
     * @return 返回Boolean代表操作是否成功(或者返回当前等级和经验吗)
     */
    StatusAwareResult<Boolean> addExperience(String userId, int exp);
}
