
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 质量监控
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhiljiankong")
public class ZhiljiankongController {
    private static final Logger logger = LoggerFactory.getLogger(ZhiljiankongController.class);

    @Autowired
    private ZhiljiankongService zhiljiankongService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ShengcanjihuaService shengcanjihuaService;
    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private WeixiuyuanService weixiuyuanService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("员工".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("维修员".equals(role))
            params.put("weixiuyuanId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = zhiljiankongService.queryPage(params);

        //字典表数据转换
        List<ZhiljiankongView> list =(List<ZhiljiankongView>)page.getList();
        for(ZhiljiankongView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhiljiankongEntity zhiljiankong = zhiljiankongService.selectById(id);
        if(zhiljiankong !=null){
            //entity转view
            ZhiljiankongView view = new ZhiljiankongView();
            BeanUtils.copyProperties( zhiljiankong , view );//把实体数据重构到view中

                //级联表
                ShengcanjihuaEntity shengcanjihua = shengcanjihuaService.selectById(zhiljiankong.getShengcanjihuaId());
                if(shengcanjihua != null){
                    BeanUtils.copyProperties( shengcanjihua , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShengcanjihuaId(shengcanjihua.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(zhiljiankong.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiljiankongEntity zhiljiankong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhiljiankong:{}",this.getClass().getName(),zhiljiankong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("员工".equals(role))
            zhiljiankong.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ZhiljiankongEntity> queryWrapper = new EntityWrapper<ZhiljiankongEntity>()
            .eq("shengcanjihua_id", zhiljiankong.getShengcanjihuaId())
            .eq("zhiljiankong_name", zhiljiankong.getZhiljiankongName())
            .eq("shebei_types", zhiljiankong.getShebeiTypes())
            .eq("yonghu_id", zhiljiankong.getYonghuId())
            .eq("zhiljiankong_number", zhiljiankong.getZhiljiankongNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhiljiankongEntity zhiljiankongEntity = zhiljiankongService.selectOne(queryWrapper);
        if(zhiljiankongEntity==null){
            zhiljiankong.setInsertTime(new Date());
            zhiljiankong.setCreateTime(new Date());
            zhiljiankongService.insert(zhiljiankong);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhiljiankongEntity zhiljiankong, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhiljiankong:{}",this.getClass().getName(),zhiljiankong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("员工".equals(role))
//            zhiljiankong.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ZhiljiankongEntity> queryWrapper = new EntityWrapper<ZhiljiankongEntity>()
            .notIn("id",zhiljiankong.getId())
            .andNew()
            .eq("shengcanjihua_id", zhiljiankong.getShengcanjihuaId())
            .eq("zhiljiankong_name", zhiljiankong.getZhiljiankongName())
            .eq("shebei_types", zhiljiankong.getShebeiTypes())
            .eq("yonghu_id", zhiljiankong.getYonghuId())
            .eq("zhiljiankong_number", zhiljiankong.getZhiljiankongNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhiljiankongEntity zhiljiankongEntity = zhiljiankongService.selectOne(queryWrapper);
        if(zhiljiankongEntity==null){
            zhiljiankongService.updateById(zhiljiankong);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        zhiljiankongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ZhiljiankongEntity> zhiljiankongList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZhiljiankongEntity zhiljiankongEntity = new ZhiljiankongEntity();
//                            zhiljiankongEntity.setShengcanjihuaId(Integer.valueOf(data.get(0)));   //生产计划 要改的
//                            zhiljiankongEntity.setZhiljiankongName(data.get(0));                    //不合格产品名称 要改的
//                            zhiljiankongEntity.setShebeiTypes(Integer.valueOf(data.get(0)));   //设备类型 要改的
//                            zhiljiankongEntity.setYonghuId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            zhiljiankongEntity.setZhiljiankongNumber(Integer.valueOf(data.get(0)));   //不合格产品数量 要改的
//                            zhiljiankongEntity.setInsertTime(date);//时间
//                            zhiljiankongEntity.setCreateTime(date);//时间
                            zhiljiankongList.add(zhiljiankongEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        zhiljiankongService.insertBatch(zhiljiankongList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
