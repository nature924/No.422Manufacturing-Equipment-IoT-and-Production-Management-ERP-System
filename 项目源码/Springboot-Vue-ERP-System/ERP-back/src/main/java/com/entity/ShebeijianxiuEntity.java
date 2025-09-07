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
 * 设备检修
 *
 * @author 
 * @email
 */
@TableName("shebeijianxiu")
public class ShebeijianxiuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShebeijianxiuEntity() {

	}

	public ShebeijianxiuEntity(T t) {
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
     * 设备
     */
    @TableField(value = "shebei_id")

    private Integer shebeiId;


    /**
     * 员工
     */
    @TableField(value = "weixiuyuan_id")

    private Integer weixiuyuanId;


    /**
     * 上次检修日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "shebeijianxiu_time")

    private Date shebeijianxiuTime;


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
	 * 设置：设备
	 */
    public Integer getShebeiId() {
        return shebeiId;
    }


    /**
	 * 获取：设备
	 */

    public void setShebeiId(Integer shebeiId) {
        this.shebeiId = shebeiId;
    }
    /**
	 * 设置：员工
	 */
    public Integer getWeixiuyuanId() {
        return weixiuyuanId;
    }


    /**
	 * 获取：员工
	 */

    public void setWeixiuyuanId(Integer weixiuyuanId) {
        this.weixiuyuanId = weixiuyuanId;
    }
    /**
	 * 设置：上次检修日期
	 */
    public Date getShebeijianxiuTime() {
        return shebeijianxiuTime;
    }


    /**
	 * 获取：上次检修日期
	 */

    public void setShebeijianxiuTime(Date shebeijianxiuTime) {
        this.shebeijianxiuTime = shebeijianxiuTime;
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
        return "Shebeijianxiu{" +
            "id=" + id +
            ", shebeiId=" + shebeiId +
            ", weixiuyuanId=" + weixiuyuanId +
            ", shebeijianxiuTime=" + shebeijianxiuTime +
            ", createTime=" + createTime +
        "}";
    }
}
