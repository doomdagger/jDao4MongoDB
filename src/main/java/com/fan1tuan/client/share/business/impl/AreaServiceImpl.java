package com.fan1tuan.client.share.business.impl;

import com.fan1tuan.business.support.StatusAwareResult;
import com.fan1tuan.client.share.business.AreaService;
import com.fan1tuan.dao.impl.AreaDao;
import com.fan1tuan.pojos.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Li He on 2014/5/4.
 * @author Li He
 */
@Service("areaService")
public class AreaServiceImpl implements AreaService {


    @Autowired
    private AreaDao areaDao;

    /**
     * 获取全部商圈
     *
     * @return List of Area entities
     */
    @Override
    public StatusAwareResult<List<Area>> fetchAreas() {
        return null;
    }

    /**
     * 根据商圈的id获取商圈实体
     *
     * @param areaId area id
     * @return 商圈实体
     */
    @Override
    public StatusAwareResult<Area> fetchArea(String areaId) {
        return null;
    }
}
