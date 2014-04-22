package com.fan1tuan.client.user.business;

import com.fan1tuan.business.support.Fan1TuanService;
import com.fan1tuan.business.support.StatusAwareResult;
import com.fan1tuan.business.support.enums.ResultStatus;
import com.fan1tuan.pojos.User;

/**
 * Created by Li He on 2014/4/21.
 * <p>实现业务功能包括：查看收藏过的餐厅，查看收藏过的美食，获取用户的地址，查看优惠劵，用户信息修改等操作</p>
 * @author Li He
 */
public interface UserService extends Fan1TuanService{

    StatusAwareResult<User> test();

}
