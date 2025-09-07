package com.entity.model;

import com.entity.ShengcanjihuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 生产计划
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShengcanjihuaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单编号
     */
    private Integer gukedingdanId;


    /**
     * 开始的时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shengcanjihukaishiTime;


    /**
     * 结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shengcanjihujieshuTime;


    /**
     * 计划状态
     */
    private Integer shengcanjihuaTypes;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单编号
	 */
    public Integer getGukedingdanId() {
        return gukedingdanId;
    }


    /**
	 * 设置：订单编号
	 */
    public void setGukedingdanId(Integer gukedingdanId) {
        this.gukedingdanId = gukedingdanId;
    }
    /**
	 * 获取：开始的时间
	 */
    public Date getShengcanjihukaishiTime() {
        return shengcanjihukaishiTime;
    }


    /**
	 * 设置：开始的时间
	 */
    public void setShengcanjihukaishiTime(Date shengcanjihukaishiTime) {
        this.shengcanjihukaishiTime = shengcanjihukaishiTime;
    }
    /**
	 * 获取：结束时间
	 */
    public Date getShengcanjihujieshuTime() {
        return shengcanjihujieshuTime;
    }


    /**
	 * 设置：结束时间
	 */
    public void setShengcanjihujieshuTime(Date shengcanjihujieshuTime) {
        this.shengcanjihujieshuTime = shengcanjihujieshuTime;
    }
    /**
	 * 获取：计划状态
	 */
    public Integer getShengcanjihuaTypes() {
        return shengcanjihuaTypes;
    }


    /**
	 * 设置：计划状态
	 */
    public void setShengcanjihuaTypes(Integer shengcanjihuaTypes) {
        this.shengcanjihuaTypes = shengcanjihuaTypes;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
