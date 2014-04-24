package com.fan1tuan.client.user.business;

import com.fan1tuan.business.support.Fan1TuanService;
import com.fan1tuan.business.support.StatusAwareResult;
import com.fan1tuan.pojos.Post;

/**
 * Created by Li He on 2014/4/21.
 * <p></p>
 * @author Li He
 */
public interface PostService extends Fan1TuanService{


    /**
     * 发布一个或多个post信息
     * 根据用户设置决定：
     *     是否暴露用户名和用户信息
     *     位置信息是否可见
     * @param posts post信息
     * @return 返回Boolean代表操作是否成功
     */
    StatusAwareResult<Boolean> addPost(Post... posts);

    /**
     * 删除一个post信息
     * @param postId post信息的id值
     * @return 返回Boolean代表操作是否成功
     */
    StatusAwareResult<Boolean> delPost(String postId);

    //todo: Consider: Is there any other actions for posts?
}
