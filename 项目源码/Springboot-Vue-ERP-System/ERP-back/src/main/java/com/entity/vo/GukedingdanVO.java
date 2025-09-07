package com.entity.vo;

import com.entity.GukedingdanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 顾客订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("gukedingdan")
public class GukedingdanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "gukedingdan_uuid_unmber")
    private String gukedingdanUuidUnmber;


    /**
     * 产品
     */

    @TableField(value = "chanpin_id")
    private Integer chanpinId;


    /**
     * 订购数量
     */

    @TableField(value = "gukedingdan_number")
    private Integer gukedingdanNumber;


    /**
     * 下订单日期 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 订单截止时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "gukedingdan_time")
    private Date gukedingdanTime;


    /**
     * 订单状态
     */

    @TableField(value = "gukedingdan_types")
    private Integer gukedingdanTypes;


    /**
     * 顾客订单内容
     */

    @TableField(value = "gukedingdan_text")
    private String gukedingdanText;


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
    public String getGukedingdanUuidUnmber() {
        return gukedingdanUuidUnmber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setGukedingdanUuidUnmber(String gukedingdanUuidUnmber) {
        this.gukedingdanUuidUnmber = gukedingdanUuidUnmber;
    }
    /**
	 * 设置：产品
	 */
    public Integer getChanpinId() {
        return chanpinId;
    }


    /**
	 * 获取：产品
	 */

    public void setChanpinId(Integer chanpinId) {
        this.chanpinId = chanpinId;
    }
    /**
	 * 设置：订购数量
	 */
    public Integer getGukedingdanNumber() {
        return gukedingdanNumber;
    }


    /**
	 * 获取：订购数量
	 */

    public void setGukedingdanNumber(Integer gukedingdanNumber) {
        this.gukedingdanNumber = gukedingdanNumber;
    }
    /**
	 * 设置：下订单日期 show1 show2 photoShow
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：下订单日期 show1 show2 photoShow
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：订单截止时间 show1 show2 photoShow
	 */
    public Date getGukedingdanTime() {
        return gukedingdanTime;
    }


    /**
	 * 获取：订单截止时间 show1 show2 photoShow
	 */

    public void setGukedingdanTime(Date gukedingdanTime) {
        this.gukedingdanTime = gukedingdanTime;
    }
    /**
	 * 设置：订单状态
	 */
    public Integer getGukedingdanTypes() {
        return gukedingdanTypes;
    }


    /**
	 * 获取：订单状态
	 */

    public void setGukedingdanTypes(Integer gukedingdanTypes) {
        this.gukedingdanTypes = gukedingdanTypes;
    }
    /**
	 * 设置：顾客订单内容
	 */
    public String getGukedingdanText() {
        return gukedingdanText;
    }


    /**
	 * 获取：顾客订单内容
	 */

    public void setGukedingdanText(String gukedingdanText) {
        this.gukedingdanText = gukedingdanText;
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
