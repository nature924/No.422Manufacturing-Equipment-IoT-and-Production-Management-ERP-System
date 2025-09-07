package com.dao;

import com.entity.GukedingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GukedingdanView;

/**
 * 顾客订单 Dao 接口
 *
 * @author 
 */
public interface GukedingdanDao extends BaseMapper<GukedingdanEntity> {

   List<GukedingdanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
