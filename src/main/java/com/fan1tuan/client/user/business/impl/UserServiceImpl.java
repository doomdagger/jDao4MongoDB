package com.fan1tuan.client.user.business.impl;

import com.fan1tuan.business.support.StatusAwareResult;
import com.fan1tuan.business.support.enums.ResultStatus;
import com.fan1tuan.client.user.business.UserService;
import com.fan1tuan.dao.support.common.UUIDGenerator;
import com.fan1tuan.pojos.Dish;
import com.fan1tuan.pojos.Shop;
import com.fan1tuan.pojos.User;
import com.fan1tuan.pojos.UserAddress;
import org.springframework.stereotype.Service;

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
    public StatusAwareResult<Boolean> editUserInfo(User user) {
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
    public StatusAwareResult<Boolean> useCoupon(String userId, String couponCode) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> addShopCollect(String userId, Shop shop) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> addShopCollectById(String userId, String shopId) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> delShopCollect(String userId, String shopCollectId) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> addDishCollect(String userId, Dish dish) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> addDishCollectById(String userId, String dishId, String shopId) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> delDishCollect(String userId, String dishCollectId) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> delDishCollectById(String userId, String dishId, String shopId) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> addDishToShoppingCart(String userId, Dish dish) {
        return null;
    }

    @Override
    public StatusAwareResult<Boolean> addDishToShoppingCartById(String userId, String dishId, String shopId) {
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
    public StatusAwareResult<Boolean> addUserCacheArea(String userId, String areaName, double[] location) {
        return null;
    }

}
