package com.dao;

import com.entity.CailiaoChuruInoutEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CailiaoChuruInoutView;

/**
 * 出入库 Dao 接口
 *
 * @author 
 */
public interface CailiaoChuruInoutDao extends BaseMapper<CailiaoChuruInoutEntity> {

   List<CailiaoChuruInoutView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
