
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
 * 顾客订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gukedingdan")
public class GukedingdanController {
    private static final Logger logger = LoggerFactory.getLogger(GukedingdanController.class);

    @Autowired
    private GukedingdanService gukedingdanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ChanpinService chanpinService;

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
        PageUtils page = gukedingdanService.queryPage(params);

        //字典表数据转换
        List<GukedingdanView> list =(List<GukedingdanView>)page.getList();
        for(GukedingdanView c:list){
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
        GukedingdanEntity gukedingdan = gukedingdanService.selectById(id);
        if(gukedingdan !=null){
            //entity转view
            GukedingdanView view = new GukedingdanView();
            BeanUtils.copyProperties( gukedingdan , view );//把实体数据重构到view中

                //级联表
                ChanpinEntity chanpin = chanpinService.selectById(gukedingdan.getChanpinId());
                if(chanpin != null){
                    BeanUtils.copyProperties( chanpin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setChanpinId(chanpin.getId());
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
    public R save(@RequestBody GukedingdanEntity gukedingdan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gukedingdan:{}",this.getClass().getName(),gukedingdan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");

        Wrapper<GukedingdanEntity> queryWrapper = new EntityWrapper<GukedingdanEntity>()
            .eq("gukedingdan_uuid_unmber", gukedingdan.getGukedingdanUuidUnmber())
            .eq("chanpin_id", gukedingdan.getChanpinId())
            .eq("gukedingdan_number", gukedingdan.getGukedingdanNumber())
            .eq("gukedingdan_types", gukedingdan.getGukedingdanTypes())
            .eq("gukedingdan_text", gukedingdan.getGukedingdanText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GukedingdanEntity gukedingdanEntity = gukedingdanService.selectOne(queryWrapper);
        if(gukedingdanEntity==null){
            gukedingdan.setInsertTime(new Date());
            gukedingdan.setCreateTime(new Date());
            gukedingdanService.insert(gukedingdan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GukedingdanEntity gukedingdan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,gukedingdan:{}",this.getClass().getName(),gukedingdan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<GukedingdanEntity> queryWrapper = new EntityWrapper<GukedingdanEntity>()
            .notIn("id",gukedingdan.getId())
            .andNew()
            .eq("gukedingdan_uuid_unmber", gukedingdan.getGukedingdanUuidUnmber())
            .eq("chanpin_id", gukedingdan.getChanpinId())
            .eq("gukedingdan_number", gukedingdan.getGukedingdanNumber())
            .eq("gukedingdan_types", gukedingdan.getGukedingdanTypes())
            .eq("gukedingdan_text", gukedingdan.getGukedingdanText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GukedingdanEntity gukedingdanEntity = gukedingdanService.selectOne(queryWrapper);
        if(gukedingdanEntity==null){
            gukedingdanService.updateById(gukedingdan);//根据id更新
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
        gukedingdanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<GukedingdanEntity> gukedingdanList = new ArrayList<>();//上传的东西
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
                            GukedingdanEntity gukedingdanEntity = new GukedingdanEntity();
//                            gukedingdanEntity.setGukedingdanUuidUnmber(data.get(0));                    //订单编号 要改的
//                            gukedingdanEntity.setChanpinId(Integer.valueOf(data.get(0)));   //产品 要改的
//                            gukedingdanEntity.setGukedingdanNumber(Integer.valueOf(data.get(0)));   //订购数量 要改的
//                            gukedingdanEntity.setInsertTime(date);//时间
//                            gukedingdanEntity.setGukedingdanTime(new Date(data.get(0)));          //订单截止时间 show1 show2 photoShow 要改的
//                            gukedingdanEntity.setGukedingdanTypes(Integer.valueOf(data.get(0)));   //订单状态 要改的
//                            gukedingdanEntity.setGukedingdanText(data.get(0));                    //顾客订单内容 要改的
//                            gukedingdanEntity.setCreateTime(date);//时间
                            gukedingdanList.add(gukedingdanEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        gukedingdanService.insertBatch(gukedingdanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
