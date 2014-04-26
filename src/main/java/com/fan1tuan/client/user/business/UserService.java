package com.fan1tuan.client.user.business;

import com.fan1tuan.business.support.Fan1TuanService;
import com.fan1tuan.business.support.StatusAwareResult;
import com.fan1tuan.pojos.*;

import java.util.List;

/**
 * Created by Li He on 2014/4/21.
 * <p>实现业务功能包括：查看收藏过的餐厅，查看收藏过的美食，获取用户的地址，查看优惠劵，用户信息修改等操作</p>
 * @author Li He
 */
public interface UserService extends Fan1TuanService{

    StatusAwareResult<User> test();

    /**
     * 用户身份验证
     * @param username 用户名或用户手机号
     * @param password 用户密码
     * @return 返回Boolean代表用户是否存在
     */
    StatusAwareResult<Boolean> userExist(String username, String password);

    /**
     * 绑定手机号
     * @param userId 用户id
     * @param cellNumber 用户手机号
     * @return 返回Boolean代表绑定是否成功
     */
    StatusAwareResult<Boolean> cellNumberBind(String userId, String cellNumber);

    /**
     * 绑定电子邮箱
     * @param userId 用户id
     * @param email 用户电子邮箱
     * @return 返回Boolean代表绑定是否成功
     */
    StatusAwareResult<Boolean> emailBind(String userId, String email);

    /**
     * 获取用户信息
     * <b>只能获取密码以外的信息</b>
     * @param userId 用户id
     * @return 返回用户实体
     */
    StatusAwareResult<User> fetchUserInfo(String userId);

    /**
     * 修改用户信息
     * <b>这个方法只能修改密码以外的用户信息</b>
     * @param user 用户模型
     * @return 返回Boolean代表修改是否成功
     */
    StatusAwareResult<Boolean> editUserInfo(User user);

    /**
     * 修改用户设置
     * @param userId 用户id
     * @param userConfig 修改后的用户设置(UserConfig)实体
     * @return 返回Boolean代表修改是否成功
     */
    StatusAwareResult<Boolean> changeUserConfig(String userId, UserConfig userConfig);

    /**
     * 获取所有用户地址
     * @param userId 用户id
     * @return 返回用户地址(UserAddress)列表
     */
    StatusAwareResult<List<UserAddress>> fetchUserAddresses(String userId);
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
     * @param addressId 被删除的地址id
     * @return 返回Boolean代表删除是否成功
     */
    StatusAwareResult<Boolean> delAddress(String userId, String addressId);

    /**
     * 设置默认地址
     * @param userId 用户id
     * @param userAddressId 用户地址id
     * @return 返回Boolean代表删除是否成功
     */
    StatusAwareResult<Boolean> setDefaultAddress(String userId, String userAddressId);

    /**
     * 编辑用户地址
     * @param userId 用户id
     * @param userAddress 编辑过的用户地址(UserAddress)实体
     * @return 返回Boolean代表编辑是否成功
     */
    StatusAwareResult<Boolean> editAddress(String userId, UserAddress userAddress);

    /**
     * 使用用户已有代金券
     * 也要改shop的代金券存根
     * @param userId 用户id
     * @param couponCode 欲使用的代金券编号
     * @return 返回Boolean代表使用是否成功
     */
    StatusAwareResult<Boolean> useCoupon(String userId, String couponCode);

    /**
     * 通过兑换码兑换代金券
     * @param userId 用户id
     * @param exchangeCode 兑换码
     * @return 返回Boolean代表兑换是否成功
     */
    StatusAwareResult<Boolean> exchangeCoupon(String userId, String exchangeCode);

    /**
     * 获取可用代金券
     * @param userId 用户id
     * @return 返回代金券(Coupon)列表
     */
    StatusAwareResult<List<Coupon>> fetchValidCoupons(String userId);

    /**
     * 获取已使用的代金券
     * @param userId 用户id
     * @return 返回代金券(Coupon)列表
     */
    StatusAwareResult<List<Coupon>> fetchUsedCoupons(String userId);

    /**
     * 获取已过期的代金券
     * @param userId 用户id
     * @return 返回代金券(Coupon)列表
     */
    StatusAwareResult<List<Coupon>> fetchExpiredCoupons(String userId);

    /**
     * 获取收藏的餐厅
     * @param userId 用户id
     * @return 返回收藏餐厅列表
     */
    StatusAwareResult<List<ShopCollect>> fetchShopCollects(String userId);
    /**
     * 通过餐厅id添加收藏
     * @param userId 用户id
     * @param shopId 餐厅id
     * @return 返回Boolean代表添加是否成功
     */
    StatusAwareResult<Boolean> addShopCollect(String userId, String shopId);

    /**
     * 删除收藏餐厅
     * @param userId 用户id
     * @param shopId 餐厅收藏(ShopCollect)id
     * @return 返回Boolean代表删除收藏是否成功
     */
    StatusAwareResult<Boolean> delShopCollect(String userId, String shopId);

    /**
     * 获取已收藏的美食
     * @param userId 用户id
     * @return 返回美食收藏(DishCollect)实体列表
     */
    StatusAwareResult<List<DishCollect>> fetchDishCollects(String userId);

    /**
     * 通过美食和所属餐厅id添加美食收藏
     * @param userId 用户id
     * @param dishId 美食id
     * @param shopId 美食所属餐厅id
     * @return 返回Boolean代表添加收藏是否成功
     */
    StatusAwareResult<Boolean> addDishCollect(String userId, String dishId, String shopId);

    /**
     * 删除美食收藏
     * @param userId 用户id
     * @param dishId 美食id
     * @param shopId 美食所属餐厅id
     * @return 返回Boolean代表删除是否成功
     */
    StatusAwareResult<Boolean> delDishCollect(String userId, String dishId, String shopId);

    /**
     * 添加美食至购物车
     * @param userId 用户id
     * @param dishId 美食id
     * @param shopId 美食所属餐厅id
     * @return 返回Boolean代表添加是否成功
     */
    StatusAwareResult<Boolean> addDishToShoppingCart(String userId, String dishId, String shopId);

    /**
     * 从购物车中移除美食
     * @param userId 用户id
     * @param dishId 移除的美食(Dish)id
     * @param shopId 美食所属的餐厅(Shop)id
     * @return 返回Boolean代表移除是否成功
     */
    StatusAwareResult<Boolean> delDishFromShoppingCart(String userId, String dishId, String shopId);

    /**
     * 增加经验并计算用户等级
     * @param userId 用户id
     * @param exp 本次获得的经验值
     * @return 返回Boolean代表操作是否成功
     */
    StatusAwareResult<Boolean> addExperience(String userId, int exp);

    /**
     * 获取用户历史位置
     * @param userId 用户id
     * @return 返回用户历史位置(UserCacheArea)实体列表
     */
    StatusAwareResult<List<UserCacheArea>> fetchUserCacheArea(String userId);

    /**
     * 添加历史位置
     * @param userId 用户id
     * @param areaName 位置名称
     * @param location 位置经纬度
     * @return 返回Boolean代表操作是否成功
     */
    StatusAwareResult<Boolean> addUserCacheArea(String userId, String areaName, double[] location);

    /**
     * 删除历史位置
     * @param userId 用户id
     * @param cacheAreaId 历史位置id
     * @return 返回Boolean代表操作是否成功
     */
    StatusAwareResult<Boolean> delUserCacheArea(String userId, String cacheAreaId);

}
