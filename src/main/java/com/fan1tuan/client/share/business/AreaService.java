package com.fan1tuan.client.share.business;

import com.fan1tuan.business.support.Fan1TuanService;
import com.fan1tuan.business.support.StatusAwareResult;
import com.fan1tuan.pojos.Area;

import java.util.List;

/**
 * Created by Li He on 2014/4/21.
 * @author Li He
 */
public interface AreaService extends Fan1TuanService{

//    /**
//     * Add a new area
//     * @param area area entity object
//     * @return Boolean value indicate whether the operation succeed or not.
//     */
//    StatusAwareResult<Boolean> addArea(Area area);


    /**
     * 获取全部商圈
     * @return List of Area entities
     */
    StatusAwareResult<List<Area>> fetchAreas();

    /**
     * 根据商圈的id获取商圈实体
     * @param areaId area id
     * @return 商圈实体
     */
    StatusAwareResult<Area> fetchArea(String areaId);

}
