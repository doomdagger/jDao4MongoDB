package com.fan1tuan.client.user.business.impl;

import com.fan1tuan.business.support.StatusAwareResult;
import com.fan1tuan.business.support.enums.ResultStatus;
import com.fan1tuan.client.user.business.UserService;
import com.fan1tuan.dao.support.common.UUIDGenerator;
import com.fan1tuan.pojos.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Li He on 2014/4/22.
 * @author Li He
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Override
    public StatusAwareResult<User> test() {
        User user = new User();
        user.setId(UUIDGenerator.generateUUID());
        user.setUsername("lihe911119");

        StatusAwareResult<User> ret = new StatusAwareResult<>();
        ResultStatus failRet = ResultStatus.FAIL;

        failRet.rawMessage("你这样做不合法！！！");

        ret.setStatus(failRet);
        ret.setRet(new User());

//        throw new AssertionError("I make this exception, nice!", new RuntimeException());

        return ret;
    }

    @Override
    public StatusAwareResult<Boolean> userExist(String username, String password) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> cellNumberBind(String userId, String cellNumber) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> emailBind(String userId, String email) {
        return null;
    }

    @Override
    public StatusAwareResult<User> fetchUserInfo(String userId) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> editUserInfo(User user) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> changeUserConfig(String userId, UserConfig userConfig) {
        return null;
    }

    @Override
    public StatusAwareResult<List<UserAddress>> fetchUserAddresses(String userId) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> addAddress(String userId, UserAddress address) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> delAddress(String userId, String addressId) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> setDefaultAddress(String userId, String userAddressId) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> editAddress(String userId, UserAddress userAddress) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> useCoupon(String userId, String couponCode) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> exchangeCoupon(String userId, String exchangeCode) {
        return null;
    }

    @Override
    public StatusAwareResult<List<Coupon>> fetchValidCoupons(String userId) {
        return null;
    }

    @Override
    public StatusAwareResult<List<Coupon>> fetchUsedCoupons(String userId) {
        return null;
    }

    @Override
    public StatusAwareResult<List<Coupon>> fetchExpiredCoupons(String userId) {
        return null;
    }

    @Override
    public StatusAwareResult<List<ShopCollect>> fetchShopCollects(String userId) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> addShopCollect(String userId, String shopId) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> delShopCollect(String userId, String shopId) {
        return null;
    }

    @Override
    public StatusAwareResult<List<DishCollect>> fetchDishCollects(String userId) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> addDishCollect(String userId, String dishId, String shopId) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> delDishCollect(String userId, String dishId, String shopId) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> addDishToShoppingCart(String userId, String dishId, String shopId) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> delDishFromShoppingCart(String userId, String dishId, String shopId) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> addExperience(String userId, int exp) {
        return null;
    }

    @Override
    public StatusAwareResult<List<UserCacheArea>> fetchUserCacheArea(String userId) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> addUserCacheArea(String userId, String areaName, double[] location) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> delUserCacheArea(String userId, String cacheAreaId) {
        return null;
    }


}
