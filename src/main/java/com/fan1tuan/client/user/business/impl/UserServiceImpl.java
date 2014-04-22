package com.fan1tuan.client.user.business.impl;

import com.fan1tuan.business.support.StatusAwareResult;
import com.fan1tuan.business.support.enums.ResultStatus;
import com.fan1tuan.client.user.business.UserService;
import com.fan1tuan.dao.support.common.UUIDGenerator;
import com.fan1tuan.pojos.User;
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
        ret.setStatus(ResultStatus.SUCCESS);
        ret.setRet(user);

        throw new AssertionError("I make this exception, nice!", new RuntimeException());

//        return ret;
    }

}
