
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
 * 出入库
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/cailiaoChuruInout")
public class CailiaoChuruInoutController {
    private static final Logger logger = LoggerFactory.getLogger(CailiaoChuruInoutController.class);

    @Autowired
    private CailiaoChuruInoutService cailiaoChuruInoutService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    // 列表详情的表级联service
    @Autowired
    private CailiaoChuruInoutListService cailiaoChuruInoutListService;
//    @Autowired
//    private YonghuService yonghuService;
    @Autowired
    private CailiaoService cailiaoService;
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
        PageUtils page = cailiaoChuruInoutService.queryPage(params);

        //字典表数据转换
        List<CailiaoChuruInoutView> list =(List<CailiaoChuruInoutView>)page.getList();
        for(CailiaoChuruInoutView c:list){
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
        CailiaoChuruInoutEntity cailiaoChuruInout = cailiaoChuruInoutService.selectById(id);
        if(cailiaoChuruInout !=null){
            //entity转view
            CailiaoChuruInoutView view = new CailiaoChuruInoutView();
            BeanUtils.copyProperties( cailiaoChuruInout , view );//把实体数据重构到view中

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
    public R save(@RequestBody CailiaoChuruInoutEntity cailiaoChuruInout, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,cailiaoChuruInout:{}",this.getClass().getName(),cailiaoChuruInout.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");

        Wrapper<CailiaoChuruInoutEntity> queryWrapper = new EntityWrapper<CailiaoChuruInoutEntity>()
            .eq("cailiao_churu_inout_uuid_number", cailiaoChuruInout.getCailiaoChuruInoutUuidNumber())
            .eq("cailiao_churu_inout_name", cailiaoChuruInout.getCailiaoChuruInoutName())
            .eq("cailiao_churu_inout_types", cailiaoChuruInout.getCailiaoChuruInoutTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CailiaoChuruInoutEntity cailiaoChuruInoutEntity = cailiaoChuruInoutService.selectOne(queryWrapper);
        if(cailiaoChuruInoutEntity==null){
            cailiaoChuruInout.setInsertTime(new Date());
            cailiaoChuruInout.setCreateTime(new Date());
            cailiaoChuruInoutService.insert(cailiaoChuruInout);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CailiaoChuruInoutEntity cailiaoChuruInout, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,cailiaoChuruInout:{}",this.getClass().getName(),cailiaoChuruInout.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<CailiaoChuruInoutEntity> queryWrapper = new EntityWrapper<CailiaoChuruInoutEntity>()
            .notIn("id",cailiaoChuruInout.getId())
            .andNew()
            .eq("cailiao_churu_inout_uuid_number", cailiaoChuruInout.getCailiaoChuruInoutUuidNumber())
            .eq("cailiao_churu_inout_name", cailiaoChuruInout.getCailiaoChuruInoutName())
            .eq("cailiao_churu_inout_types", cailiaoChuruInout.getCailiaoChuruInoutTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CailiaoChuruInoutEntity cailiaoChuruInoutEntity = cailiaoChuruInoutService.selectOne(queryWrapper);
        if(cailiaoChuruInoutEntity==null){
            cailiaoChuruInoutService.updateById(cailiaoChuruInout);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }
    /**
    * 出库
    */
    @RequestMapping("/outCailiaoChuruInoutList")
    public R outCailiaoChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("outCailiaoChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");

        //取出入库名称并判断是否存在
        String cailiaoChuruInoutName = String.valueOf(params.get("cailiaoChuruInoutName"));
        Wrapper<CailiaoChuruInoutEntity> queryWrapper = new EntityWrapper<CailiaoChuruInoutEntity>()
            .eq("cailiao_churu_inout_name", cailiaoChuruInoutName)
            ;
        CailiaoChuruInoutEntity cailiaoChuruInoutSelectOne = cailiaoChuruInoutService.selectOne(queryWrapper);
        if(cailiaoChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");


    //取当前表的级联表并判断是否前台传入

        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");


        Set<String> ids = map.keySet();

        List<CailiaoEntity> cailiaoList = cailiaoService.selectBatchIds(ids);
        if(cailiaoList == null || cailiaoList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(CailiaoEntity w:cailiaoList){
                Integer value = w.getCailiaoKucunNumber()-map.get(String.valueOf(w.getId()));
                if(value <0){
                    return R.error(511,"出库数量大于库存数量");
                }
                w.setCailiaoKucunNumber(value);
            }
        }

        //当前表
        CailiaoChuruInoutEntity cailiaoChuruInoutEntity = new CailiaoChuruInoutEntity<>();
            cailiaoChuruInoutEntity.setCailiaoChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            cailiaoChuruInoutEntity.setCailiaoChuruInoutName(cailiaoChuruInoutName);
            cailiaoChuruInoutEntity.setCailiaoChuruInoutTypes(1);
            cailiaoChuruInoutEntity.setCailiaoChuruInoutContent("");
            cailiaoChuruInoutEntity.setInsertTime(new Date());
            cailiaoChuruInoutEntity.setCreateTime(new Date());

        boolean insertCailiaoChuruInout = cailiaoChuruInoutService.insert(cailiaoChuruInoutEntity);
        if(insertCailiaoChuruInout){
            //级联表
            ArrayList<CailiaoChuruInoutListEntity> cailiaoChuruInoutLists = new ArrayList<>();
            for(String id:ids){
                CailiaoChuruInoutListEntity cailiaoChuruInoutListEntity = new CailiaoChuruInoutListEntity();
                    cailiaoChuruInoutListEntity.setCailiaoChuruInoutId(cailiaoChuruInoutEntity.getId());
                    cailiaoChuruInoutListEntity.setCailiaoId(Integer.valueOf(id));
                    cailiaoChuruInoutListEntity.setCailiaoChuruInoutListNumber(map.get(id));
                    cailiaoChuruInoutListEntity.setInsertTime(new Date());
                    cailiaoChuruInoutListEntity.setCreateTime(new Date());
                cailiaoChuruInoutLists.add(cailiaoChuruInoutListEntity);
                cailiaoService.updateBatchById(cailiaoList);
            }
            cailiaoChuruInoutListService.insertBatch(cailiaoChuruInoutLists);
        }
        return R.ok();
    }

    /**
    *入库
    */
    @RequestMapping("/inCailiaoChuruInoutList")
    public R inCailiaoChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("inCailiaoChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        //params:{"map":{"1":2,"2":3},"wuziOutinName":"订单1"}

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");

        //取当前表名称并判断
        String cailiaoChuruInoutName = String.valueOf(params.get("cailiaoChuruInoutName"));
        Wrapper<CailiaoChuruInoutEntity> queryWrapper = new EntityWrapper<CailiaoChuruInoutEntity>()
            .eq("cailiao_churu_inout_name", cailiaoChuruInoutName)
            ;
        CailiaoChuruInoutEntity cailiaoChuruInoutSelectOne = cailiaoChuruInoutService.selectOne(queryWrapper);
        if(cailiaoChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");


        //取当前表的级联表并判断是否前台传入

        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");

        Set<String> ids = map.keySet();

        List<CailiaoEntity> cailiaoList = cailiaoService.selectBatchIds(ids);
        if(cailiaoList == null || cailiaoList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(CailiaoEntity w:cailiaoList){
                w.setCailiaoKucunNumber(w.getCailiaoKucunNumber()+map.get(String.valueOf(w.getId())));
            }
        }

        //当前表
        CailiaoChuruInoutEntity cailiaoChuruInoutEntity = new CailiaoChuruInoutEntity<>();
            cailiaoChuruInoutEntity.setCailiaoChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            cailiaoChuruInoutEntity.setCailiaoChuruInoutName(cailiaoChuruInoutName);
            cailiaoChuruInoutEntity.setCailiaoChuruInoutTypes(2);
            cailiaoChuruInoutEntity.setCailiaoChuruInoutContent("");
            cailiaoChuruInoutEntity.setInsertTime(new Date());
            cailiaoChuruInoutEntity.setCreateTime(new Date());


        boolean insertCailiaoChuruInout = cailiaoChuruInoutService.insert(cailiaoChuruInoutEntity);
        if(insertCailiaoChuruInout){
            //级联表
            ArrayList<CailiaoChuruInoutListEntity> cailiaoChuruInoutLists = new ArrayList<>();
            for(String id:ids){
                CailiaoChuruInoutListEntity cailiaoChuruInoutListEntity = new CailiaoChuruInoutListEntity();
                cailiaoChuruInoutListEntity.setCailiaoChuruInoutId(cailiaoChuruInoutEntity.getId());
                cailiaoChuruInoutListEntity.setCailiaoId(Integer.valueOf(id));
                cailiaoChuruInoutListEntity.setCailiaoChuruInoutListNumber(map.get(id));
                cailiaoChuruInoutListEntity.setInsertTime(new Date());
                cailiaoChuruInoutListEntity.setCreateTime(new Date());
                cailiaoChuruInoutLists.add(cailiaoChuruInoutListEntity);
                cailiaoService.updateBatchById(cailiaoList);
            }
            cailiaoChuruInoutListService.insertBatch(cailiaoChuruInoutLists);
        }

        return R.ok();
    }
    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        cailiaoChuruInoutService.deleteBatchIds(Arrays.asList(ids));
        cailiaoChuruInoutListService.delete(new EntityWrapper<CailiaoChuruInoutListEntity>().in("cailiao_churu_inout_id",ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<CailiaoChuruInoutEntity> cailiaoChuruInoutList = new ArrayList<>();//上传的东西
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
                            CailiaoChuruInoutEntity cailiaoChuruInoutEntity = new CailiaoChuruInoutEntity();
//                            cailiaoChuruInoutEntity.setCailiaoChuruInoutUuidNumber(data.get(0));                    //出入库流水号 要改的
//                            cailiaoChuruInoutEntity.setCailiaoChuruInoutName(data.get(0));                    //出入库名称 要改的
//                            cailiaoChuruInoutEntity.setCailiaoChuruInoutTypes(Integer.valueOf(data.get(0)));   //出入库类型 要改的
//                            cailiaoChuruInoutEntity.setCailiaoChuruInoutContent("");//照片
//                            cailiaoChuruInoutEntity.setInsertTime(date);//时间
//                            cailiaoChuruInoutEntity.setCreateTime(date);//时间
                            cailiaoChuruInoutList.add(cailiaoChuruInoutEntity);


                            //把要查询是否重复的字段放入map中
                                //出入库流水号
                                if(seachFields.containsKey("cailiaoChuruInoutUuidNumber")){
                                    List<String> cailiaoChuruInoutUuidNumber = seachFields.get("cailiaoChuruInoutUuidNumber");
                                    cailiaoChuruInoutUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> cailiaoChuruInoutUuidNumber = new ArrayList<>();
                                    cailiaoChuruInoutUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("cailiaoChuruInoutUuidNumber",cailiaoChuruInoutUuidNumber);
                                }
                        }

                        //查询是否重复
                         //出入库流水号
                        List<CailiaoChuruInoutEntity> cailiaoChuruInoutEntities_cailiaoChuruInoutUuidNumber = cailiaoChuruInoutService.selectList(new EntityWrapper<CailiaoChuruInoutEntity>().in("cailiao_churu_inout_uuid_number", seachFields.get("cailiaoChuruInoutUuidNumber")));
                        if(cailiaoChuruInoutEntities_cailiaoChuruInoutUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CailiaoChuruInoutEntity s:cailiaoChuruInoutEntities_cailiaoChuruInoutUuidNumber){
                                repeatFields.add(s.getCailiaoChuruInoutUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [出入库流水号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        cailiaoChuruInoutService.insertBatch(cailiaoChuruInoutList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
