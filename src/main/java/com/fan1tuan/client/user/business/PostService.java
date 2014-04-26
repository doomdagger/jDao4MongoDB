package com.fan1tuan.client.user.business;

import com.fan1tuan.business.support.Fan1TuanService;
import com.fan1tuan.business.support.StatusAwareResult;
import com.fan1tuan.pojos.Post;
import com.fan1tuan.pojos.PostFavorItem;
import com.fan1tuan.pojos.Response;
import javafx.animation.Animation;

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
     * 根据post信息的id删除
     * @param postId post信息的id值
     * @return 返回Boolean代表操作是否成功
     */
    StatusAwareResult<Boolean> delPost(String postId);

    /**
     * 评论已发布的post
     * @param postId post信息id
     * @param response 评论
     * @return 返回Boolean代表操作是否成功
     */
    StatusAwareResult<Boolean> addResponse(String postId, Response response);

    /**
     * 删除已有评论
     * @param postId post信息id
     * @param responseId 被删除的评论id
     * @return 返回Boolean代表操作是否成功
     */
    StatusAwareResult<Boolean> delResponse(String postId, String responseId);

    /**
     * 对已有post信息点赞
     * @param postId post信息id
     * @param favoredUserId 点赞用户id
     * @param favoredUserName 点赞用户名
     * @return 返回Boolean代表操作是否成功
     */
    StatusAwareResult<Boolean> addPostFavor(String postId, String favoredUserId, String favoredUserName);

    /**
     * 取消对已有post信息的赞
     * @param postId post信息id
     * @param favoredUserId 取消点赞的用户id
     * @return 返回Boolean代表操作是否成功
     */
    StatusAwareResult<Boolean> delPostFavorItem(String postId, String favoredUserId);

}
