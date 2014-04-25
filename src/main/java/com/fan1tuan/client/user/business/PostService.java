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
     * (?)为已有Post添加图片
     * @param postId post信息id
     * @param imgPath 图片路径
     * @return 返回Boolean代表操作是否成功
     */
    StatusAwareResult<Boolean> addImageToPost(String postId, String imgPath);

    /**
     * 评论已发布的post
     * @param postId post信息id
     * @param response 回复(Response)实体
     * @return 返回Boolean代表操作是否成功
     */
    StatusAwareResult<Boolean> addResponse(String postId, Response response);

    /**
     * 添加PostFavorItem
     * (？)是否可以添加多个
     * @param postId post信息id
     * @param postFavorItem PostFavorItem实体
     * @return 返回Boolean代表操作是否成功
     */
    StatusAwareResult<Boolean> addPostFavorItem(String postId, PostFavorItem postFavorItem);

    /**
     * 添加post查看人数
     * @param postId post信息id
     * @return 返回Boolean代表操作是否成功
     */
    StatusAwareResult<Boolean> addPostVisitorNumber(String postId);
}
