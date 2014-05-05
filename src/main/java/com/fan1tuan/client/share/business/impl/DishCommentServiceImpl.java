package com.fan1tuan.client.share.business.impl;

import com.fan1tuan.business.support.StatusAwareResult;
import com.fan1tuan.client.share.business.DishCommentService;
import com.fan1tuan.dao.impl.DishCommentDao;
import com.fan1tuan.pojos.DishComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Li He on 2014/5/4.
 * @author LI HE
 */
@Service("dishCommentService")
public class DishCommentServiceImpl implements DishCommentService{

    @Autowired
    private DishCommentDao dishCommentDao;

    /**
     * 获取某个菜品的评价分布状况，返回的Map的key为一个整型变量，value为一个整型变量，key代表*星评价，value代表当前*评价下有多少有效评论
     *
     * @param dishId dish id
     * @param shopId shop id
     * @return Map contains the distribution of comment level
     */
    @Override
    public StatusAwareResult<Map<Integer, Integer>> fetchDishComments(String dishId, String shopId) {
        return null;
    }

    /**
     * 分页获取dish comments集合，包含了详细的评价信息
     *
     * @param dishId     dish id
     * @param shopId     shop id
     * @param pageNumber 当前的分页页数
     * @param pageSize   每页的条目数
     * @return List of dish comment object
     */
    @Override
    public StatusAwareResult<List<DishComment>> fetchDishComments(String dishId, String shopId, int pageNumber, int pageSize) {
        return null;
    }

    /**
     * 发布一个dish comment
     *
     * @param dishComment dish comment 对象
     * @return 返回Boolean代表是否发布成功
     */
    @Override
    public StatusAwareResult<Boolean> postDishComment(DishComment dishComment) {
        return null;
    }

    /**
     * 根据用户id获取用户给出的评价，用户无法控制，默认以评价日期的降序排列给出
     *
     * @param userId     user id
     * @param pageNumber 当前的分页页数
     * @param pageSize   每页的条目数
     * @return List DishComment
     */
    @Override
    public StatusAwareResult<List<DishComment>> fetchDishComments(String userId, int pageNumber, int pageSize) {
        return null;
    }
}
