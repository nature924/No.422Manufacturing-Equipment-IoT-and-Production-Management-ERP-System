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
 * 设备信息
 *
 * @author 
 * @email
 */
@TableName("shebei")
public class ShebeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShebeiEntity() {

	}

	public ShebeiEntity(T t) {
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
     * 设备编号
     */
    @TableField(value = "shebei_uuid_unmber")

    private String shebeiUuidUnmber;


    /**
     * 设备名称
     */
    @TableField(value = "shebei_name")

    private String shebeiName;


    /**
     * 设备类型
     */
    @TableField(value = "shebei_types")

    private Integer shebeiTypes;


    /**
     * 上次检修日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "shebei_time")

    private Date shebeiTime;


    /**
     * 设备状态
     */
    @TableField(value = "status_types")

    private Integer statusTypes;


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
	 * 设置：设备编号
	 */
    public String getShebeiUuidUnmber() {
        return shebeiUuidUnmber;
    }


    /**
	 * 获取：设备编号
	 */

    public void setShebeiUuidUnmber(String shebeiUuidUnmber) {
        this.shebeiUuidUnmber = shebeiUuidUnmber;
    }
    /**
	 * 设置：设备名称
	 */
    public String getShebeiName() {
        return shebeiName;
    }


    /**
	 * 获取：设备名称
	 */

    public void setShebeiName(String shebeiName) {
        this.shebeiName = shebeiName;
    }
    /**
	 * 设置：设备类型
	 */
    public Integer getShebeiTypes() {
        return shebeiTypes;
    }


    /**
	 * 获取：设备类型
	 */

    public void setShebeiTypes(Integer shebeiTypes) {
        this.shebeiTypes = shebeiTypes;
    }
    /**
	 * 设置：上次检修日期
	 */
    public Date getShebeiTime() {
        return shebeiTime;
    }


    /**
	 * 获取：上次检修日期
	 */

    public void setShebeiTime(Date shebeiTime) {
        this.shebeiTime = shebeiTime;
    }
    /**
	 * 设置：设备状态
	 */
    public Integer getStatusTypes() {
        return statusTypes;
    }


    /**
	 * 获取：设备状态
	 */

    public void setStatusTypes(Integer statusTypes) {
        this.statusTypes = statusTypes;
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
        return "Shebei{" +
            "id=" + id +
            ", shebeiUuidUnmber=" + shebeiUuidUnmber +
            ", shebeiName=" + shebeiName +
            ", shebeiTypes=" + shebeiTypes +
            ", shebeiTime=" + shebeiTime +
            ", statusTypes=" + statusTypes +
            ", createTime=" + createTime +
        "}";
    }
}
