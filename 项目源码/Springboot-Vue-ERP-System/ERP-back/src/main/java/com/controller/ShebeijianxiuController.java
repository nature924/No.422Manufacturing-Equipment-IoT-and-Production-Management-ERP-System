
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
 * 设备检修
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shebeijianxiu")
public class ShebeijianxiuController {
    private static final Logger logger = LoggerFactory.getLogger(ShebeijianxiuController.class);

    @Autowired
    private ShebeiService shebeiService;

    @Autowired
    private ShebeijianxiuService shebeijianxiuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private WeixiuyuanService weixiuyuanService;

    @Autowired
    private YonghuService yonghuService;


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
        PageUtils page = shebeijianxiuService.queryPage(params);

        //字典表数据转换
        List<ShebeijianxiuView> list =(List<ShebeijianxiuView>)page.getList();
        for(ShebeijianxiuView c:list){
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
        ShebeijianxiuEntity shebeijianxiu = shebeijianxiuService.selectById(id);
        if(shebeijianxiu !=null){
            //entity转view
            ShebeijianxiuView view = new ShebeijianxiuView();
            BeanUtils.copyProperties( shebeijianxiu , view );//把实体数据重构到view中

                //级联表
                ShebeiEntity shebei = shebeiService.selectById(shebeijianxiu.getShebeiId());
                if(shebei != null){
                    BeanUtils.copyProperties( shebei , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShebeiId(shebei.getId());
                }
                //级联表
                WeixiuyuanEntity weixiuyuan = weixiuyuanService.selectById(shebeijianxiu.getWeixiuyuanId());
                if(weixiuyuan != null){
                    BeanUtils.copyProperties( weixiuyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setWeixiuyuanId(weixiuyuan.getId());
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
    public R save(@RequestBody ShebeijianxiuEntity shebeijianxiu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shebeijianxiu:{}",this.getClass().getName(),shebeijianxiu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("维修员".equals(role))
            shebeijianxiu.setWeixiuyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShebeijianxiuEntity> queryWrapper = new EntityWrapper<ShebeijianxiuEntity>()
            .eq("shebei_id", shebeijianxiu.getShebeiId())
            .eq("weixiuyuan_id", shebeijianxiu.getWeixiuyuanId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShebeijianxiuEntity shebeijianxiuEntity = shebeijianxiuService.selectOne(queryWrapper);
        if(shebeijianxiuEntity==null){
            shebeijianxiu.setCreateTime(new Date());
            shebeijianxiuService.insert(shebeijianxiu);
            ShebeiEntity shebeiEntity = new ShebeiEntity();
            shebeiEntity.setShebeiTime(new Date());
            shebeiEntity.setStatusTypes(1);
            shebeiEntity.setId(shebeijianxiu.getShebeiId());
            boolean b = shebeiService.updateById(shebeiEntity);
            if(!b){
                return R.error();
            }
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShebeijianxiuEntity shebeijianxiu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shebeijianxiu:{}",this.getClass().getName(),shebeijianxiu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("维修员".equals(role))
//            shebeijianxiu.setWeixiuyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShebeijianxiuEntity> queryWrapper = new EntityWrapper<ShebeijianxiuEntity>()
            .notIn("id",shebeijianxiu.getId())
            .andNew()
            .eq("shebei_id", shebeijianxiu.getShebeiId())
            .eq("weixiuyuan_id", shebeijianxiu.getWeixiuyuanId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShebeijianxiuEntity shebeijianxiuEntity = shebeijianxiuService.selectOne(queryWrapper);
        if(shebeijianxiuEntity==null){
            shebeijianxiuService.updateById(shebeijianxiu);//根据id更新
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
        shebeijianxiuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ShebeijianxiuEntity> shebeijianxiuList = new ArrayList<>();//上传的东西
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
                            ShebeijianxiuEntity shebeijianxiuEntity = new ShebeijianxiuEntity();
//                            shebeijianxiuEntity.setShebeiId(Integer.valueOf(data.get(0)));   //设备 要改的
//                            shebeijianxiuEntity.setWeixiuyuanId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            shebeijianxiuEntity.setShebeijianxiuTime(new Date(data.get(0)));          //上次检修日期 要改的
//                            shebeijianxiuEntity.setCreateTime(date);//时间
                            shebeijianxiuList.add(shebeijianxiuEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        shebeijianxiuService.insertBatch(shebeijianxiuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
