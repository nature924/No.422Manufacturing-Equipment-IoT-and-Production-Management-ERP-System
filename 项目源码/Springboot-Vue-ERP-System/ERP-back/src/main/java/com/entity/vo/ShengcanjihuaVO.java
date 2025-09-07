package com.entity.vo;

import com.entity.ShengcanjihuaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 生产计划
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shengcanjihua")
public class ShengcanjihuaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "gukedingdan_id")
    private Integer gukedingdanId;


    /**
     * 开始的时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shengcanjihukaishi_time")
    private Date shengcanjihukaishiTime;


    /**
     * 结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shengcanjihujieshu_time")
    private Date shengcanjihujieshuTime;


    /**
     * 计划状态
     */

    @TableField(value = "shengcanjihua_types")
    private Integer shengcanjihuaTypes;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单编号
	 */
    public Integer getGukedingdanId() {
        return gukedingdanId;
    }


    /**
	 * 获取：订单编号
	 */

    public void setGukedingdanId(Integer gukedingdanId) {
        this.gukedingdanId = gukedingdanId;
    }
    /**
	 * 设置：开始的时间
	 */
    public Date getShengcanjihukaishiTime() {
        return shengcanjihukaishiTime;
    }


    /**
	 * 获取：开始的时间
	 */

    public void setShengcanjihukaishiTime(Date shengcanjihukaishiTime) {
        this.shengcanjihukaishiTime = shengcanjihukaishiTime;
    }
    /**
	 * 设置：结束时间
	 */
    public Date getShengcanjihujieshuTime() {
        return shengcanjihujieshuTime;
    }


    /**
	 * 获取：结束时间
	 */

    public void setShengcanjihujieshuTime(Date shengcanjihujieshuTime) {
        this.shengcanjihujieshuTime = shengcanjihujieshuTime;
    }
    /**
	 * 设置：计划状态
	 */
    public Integer getShengcanjihuaTypes() {
        return shengcanjihuaTypes;
    }


    /**
	 * 获取：计划状态
	 */

    public void setShengcanjihuaTypes(Integer shengcanjihuaTypes) {
        this.shengcanjihuaTypes = shengcanjihuaTypes;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
