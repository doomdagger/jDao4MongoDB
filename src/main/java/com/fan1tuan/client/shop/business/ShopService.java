package com.fan1tuan.client.shop.business;

import com.fan1tuan.business.support.Fan1TuanService;
import com.fan1tuan.business.support.StatusAwareResult;
import com.fan1tuan.business.support.enums.ShopRankAccord;
import com.fan1tuan.business.support.enums.ShopType;
import com.fan1tuan.pojos.Shop;

import java.util.List;

/**
 * Created by Li He on 2014/4/21.
 * @author Li He
 */
public interface ShopService extends Fan1TuanService{

    /**
     * 根据多种查询条件来获取在线订餐店铺，除了位置之外，其余均可以为空，均具备默认行为
     * @param location 必须给出，搜索周边服务范围可以覆盖到此的店铺
     * @param shopTastes 店铺的口味，string形式传参，默认为全部口味
     * @param shopTags 店铺的标签，string形式传参，默认为null，即不根据标签筛选店铺
     * @param shopType 店铺的类型，枚举，默认为null，即全部类型店铺
     * @param availableForOrder 店铺是否当前接受预定，默认为null，即全部店铺，无论是接受还是不接受
     * @param supportDelivery 店铺是否支持送餐，默认为null，即全部店铺，无论支不支持送餐
     * @param shopRankAccords 排行依据，可以为多个，在前面的优先，默认为null，不排序
     * @param pageNumber 分页支持，第几页
     * @param pageSize 分页支持，一页有多少项
     * @return Shop集合
     */
    StatusAwareResult<List<Shop>> fetchOnlineShopsConditionedInPage(double location[],
                                                        List<String> shopTastes,
                                                        List<String> shopTags,
                                                        ShopType shopType,
                                                        Boolean availableForOrder,
                                                        Boolean supportDelivery,
                                                        List<ShopRankAccord> shopRankAccords,
                                                        int pageNumber,
                                                        int pageSize);


    /**
     * 根据多种查询条件来获取电话订餐店铺，除了位置之外，其余均可以为空，均具备默认行为
     * @param location 必须给出，搜索周边服务范围可以覆盖到此的店铺
     * @param shopTastes 店铺的口味，string形式传参，默认为全部口味
     * @param shopType 店铺的类型，枚举，默认为null，即全部类型店铺
     * @param shopRankAccords 排行依据，可以为多个，在前面的优先，默认为null，不排序
     * @param pageNumber 分页支持，第几页
     * @param pageSize 分页支持，一页有多少项
     * @return Shop集合
     */
    StatusAwareResult<List<Shop>> fetchPhoneCallShopsConditionedInPage(double location[],
                                                                       List<String> shopTastes,
                                                                       ShopType shopType,
                                                                       List<ShopRankAccord> shopRankAccords,
                                                                       int pageNumber,
                                                                       int pageSize);

    /**
     * 搜索支持在线订餐的店铺，支持分页
     * @param location 必须给出，搜索周边服务范围可以覆盖到此的店铺
     * @param keywords 必须给出，关键字搜索，搜索店铺名称
     * @param pageNumber 分页支持，第几页
     * @param pageSize 分页支持，一页有多少项
     * @return Shop集合
     */
    StatusAwareResult<List<Shop>> searchOnlineShopsInPage(double location[],
                                                          String keywords,
                                                          int pageNumber,
                                                          int pageSize);

    /**
     * 搜索支持电话订餐的店铺，支持分页
     * @param location 必须给出，搜索周边服务范围可以覆盖到此的店铺
     * @param keywords 必须给出，关键字搜索，搜索店铺名称
     * @param pageNumber 分页支持，第几页
     * @param pageSize 分页支持，一页有多少项
     * @return Shop集合
     */
    StatusAwareResult<List<Shop>> searchPhoneCallShopsInPage(double location[],
                                                             String keywords,
                                                             int pageNumber,
                                                             int pageSize);

    /**
     * 根据店铺id，获取shop的全部信息，适用于进入店铺浏览功能
     * @param shopId shop的id，必须给出
     * @return 返回Shop实体
     */
    StatusAwareResult<Shop> fetchShop(String shopId);


}


