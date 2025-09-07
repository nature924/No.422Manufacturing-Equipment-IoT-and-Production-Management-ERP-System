package com.dao;

import com.entity.ShengcanjihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShengcanjihuaView;

/**
 * 生产计划 Dao 接口
 *
 * @author 
 */
public interface ShengcanjihuaDao extends BaseMapper<ShengcanjihuaEntity> {

   List<ShengcanjihuaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
