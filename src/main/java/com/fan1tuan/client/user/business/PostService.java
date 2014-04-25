package com.fan1tuan.client.user.business;

import com.fan1tuan.business.support.Fan1TuanService;
import com.fan1tuan.business.support.StatusAwareResult;
import com.fan1tuan.pojos.Post;
import com.fan1tuan.pojos.PostFavorItem;
import com.fan1tuan.pojos.Response;

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

    /**
     * 为已有Post添加图片
     * @param postId post信息id
     * @param imgPath 图片路径
     * @return 返回Boolean代表操作是否成功
     */
    StatusAwareResult<Boolean> addImageToPost(String postId, String imgPath);

    /**
     * 评论已发布的post
     * @param postId post信息id
     * @param responseUserId 评论者id
     * @param responseContent 评论内容
     * @param postSource 评论来自哪种平台
     * @return 返回Boolean代表操作是否成功
     */
    StatusAwareResult<Boolean> addResponse(String postId, String responseUserId, String responseContent, int postSource);

    /**
     * 点赞
     * @param postId post信息id
     * @param favoredUserId 点赞用户id
     * @param favoredUserName 点赞用户名
     * @return 返回Boolean代表操作是否成功
     */
    StatusAwareResult<Boolean> addPostFavor(String postId, String favoredUserId, String favoredUserName);

    /**
     * 取消赞
     * @param postId post信息id
     * @param userId 取消点赞的用户id
     * @return 返回Boolean代表操作是否成功
     */
    StatusAwareResult<Boolean> delPostFavorItem(String postId, String userId);

}
