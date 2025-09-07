package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 顾客订单
 *
 * @author 
 * @email
 */
@TableName("gukedingdan")
public class GukedingdanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GukedingdanEntity() {

	}

	public GukedingdanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
     * 下订单日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 订单截止时间
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
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：下订单日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：下订单日期
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：订单截止时间
	 */
    public Date getGukedingdanTime() {
        return gukedingdanTime;
    }


    /**
	 * 获取：订单截止时间
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
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Gukedingdan{" +
            "id=" + id +
            ", gukedingdanUuidUnmber=" + gukedingdanUuidUnmber +
            ", chanpinId=" + chanpinId +
            ", gukedingdanNumber=" + gukedingdanNumber +
            ", insertTime=" + insertTime +
            ", gukedingdanTime=" + gukedingdanTime +
            ", gukedingdanTypes=" + gukedingdanTypes +
            ", gukedingdanText=" + gukedingdanText +
            ", createTime=" + createTime +
        "}";
    }
}
