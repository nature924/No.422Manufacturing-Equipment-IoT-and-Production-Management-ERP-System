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
 * 质量监控
 *
 * @author 
 * @email
 */
@TableName("zhiljiankong")
public class ZhiljiankongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhiljiankongEntity() {

	}

	public ZhiljiankongEntity(T t) {
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
     * 生产计划
     */
    @TableField(value = "shengcanjihua_id")

    private Integer shengcanjihuaId;


    /**
     * 不合格产品名称
     */
    @TableField(value = "zhiljiankong_name")

    private String zhiljiankongName;


    /**
     * 设备类型
     */
    @TableField(value = "shebei_types")

    private Integer shebeiTypes;


    /**
     * 员工
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 不合格产品数量
     */
    @TableField(value = "zhiljiankong_number")

    private Integer zhiljiankongNumber;


    /**
     * 时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 设置：生产计划
	 */
    public Integer getShengcanjihuaId() {
        return shengcanjihuaId;
    }


    /**
	 * 获取：生产计划
	 */

    public void setShengcanjihuaId(Integer shengcanjihuaId) {
        this.shengcanjihuaId = shengcanjihuaId;
    }
    /**
	 * 设置：不合格产品名称
	 */
    public String getZhiljiankongName() {
        return zhiljiankongName;
    }


    /**
	 * 获取：不合格产品名称
	 */

    public void setZhiljiankongName(String zhiljiankongName) {
        this.zhiljiankongName = zhiljiankongName;
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
	 * 设置：员工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：员工
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：不合格产品数量
	 */
    public Integer getZhiljiankongNumber() {
        return zhiljiankongNumber;
    }


    /**
	 * 获取：不合格产品数量
	 */

    public void setZhiljiankongNumber(Integer zhiljiankongNumber) {
        this.zhiljiankongNumber = zhiljiankongNumber;
    }
    /**
	 * 设置：时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Zhiljiankong{" +
            "id=" + id +
            ", shengcanjihuaId=" + shengcanjihuaId +
            ", zhiljiankongName=" + zhiljiankongName +
            ", shebeiTypes=" + shebeiTypes +
            ", yonghuId=" + yonghuId +
            ", zhiljiankongNumber=" + zhiljiankongNumber +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
