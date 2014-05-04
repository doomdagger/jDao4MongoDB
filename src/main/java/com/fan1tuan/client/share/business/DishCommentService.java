package com.fan1tuan.client.share.business;

import com.fan1tuan.business.support.Fan1TuanService;
import com.fan1tuan.business.support.StatusAwareResult;
import com.fan1tuan.pojos.DishComment;
import javafx.animation.Animation;

import java.util.List;
import java.util.Map;

/**
 * Created by Li He on 2014/4/21.
 * @author Li He
 */
public interface DishCommentService extends Fan1TuanService{

    /**
     * 获取某个菜品的评价分布状况，返回的Map的key为一个整型变量，value为一个整型变量，key代表*星评价，value代表当前*评价下有多少有效评论
     * @param dishId dish id
     * @param shopId shop id
     * @return Map contains the distribution of comment level
     */
    StatusAwareResult<Map<Integer, Integer>> fetchDishComments(String dishId, String shopId);

    /**
     * 分页获取dish comments集合，包含了详细的评价信息
     * @param dishId dish id
     * @param shopId shop id
     * @param pageNumber 当前的分页页数
     * @param pageSize 每页的条目数
     * @return List of dish comment object
     */
    StatusAwareResult<List<DishComment>> fetchDishComments(String dishId, String shopId, int pageNumber, int pageSize);

    //TODO 为美食墙提供支持


    /**
     * 发布一个dish comment
     * @param dishComment dish comment 对象
     * @return 返回Boolean代表是否发布成功
     */
    StatusAwareResult<Boolean> postDishComment(DishComment dishComment);

    /**
     * 根据用户id获取用户给出的评价，用户无法控制，默认以评价日期的降序排列给出
     * @param userId user id
     * @param pageNumber 当前的分页页数
     * @param pageSize 每页的条目数
     * @return List DishComment
     */
    StatusAwareResult<List<DishComment>> fetchDishComments(String userId, int pageNumber, int pageSize);
}

