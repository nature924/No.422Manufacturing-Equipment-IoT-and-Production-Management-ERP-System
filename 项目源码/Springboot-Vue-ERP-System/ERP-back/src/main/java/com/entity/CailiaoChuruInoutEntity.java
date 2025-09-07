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
 * 出入库
 *
 * @author 
 * @email
 */
@TableName("cailiao_churu_inout")
public class CailiaoChuruInoutEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CailiaoChuruInoutEntity() {

	}

	public CailiaoChuruInoutEntity(T t) {
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
     * 出入库流水号
     */
    @TableField(value = "cailiao_churu_inout_uuid_number")

    private String cailiaoChuruInoutUuidNumber;


    /**
     * 出入库名称
     */
    @TableField(value = "cailiao_churu_inout_name")

    private String cailiaoChuruInoutName;


    /**
     * 出入库类型
     */
    @TableField(value = "cailiao_churu_inout_types")

    private Integer cailiaoChuruInoutTypes;


    /**
     * 备注
     */
    @TableField(value = "cailiao_churu_inout_content")

    private String cailiaoChuruInoutContent;


    /**
     * 添加时间
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
	 * 设置：出入库流水号
	 */
    public String getCailiaoChuruInoutUuidNumber() {
        return cailiaoChuruInoutUuidNumber;
    }


    /**
	 * 获取：出入库流水号
	 */

    public void setCailiaoChuruInoutUuidNumber(String cailiaoChuruInoutUuidNumber) {
        this.cailiaoChuruInoutUuidNumber = cailiaoChuruInoutUuidNumber;
    }
    /**
	 * 设置：出入库名称
	 */
    public String getCailiaoChuruInoutName() {
        return cailiaoChuruInoutName;
    }


    /**
	 * 获取：出入库名称
	 */

    public void setCailiaoChuruInoutName(String cailiaoChuruInoutName) {
        this.cailiaoChuruInoutName = cailiaoChuruInoutName;
    }
    /**
	 * 设置：出入库类型
	 */
    public Integer getCailiaoChuruInoutTypes() {
        return cailiaoChuruInoutTypes;
    }


    /**
	 * 获取：出入库类型
	 */

    public void setCailiaoChuruInoutTypes(Integer cailiaoChuruInoutTypes) {
        this.cailiaoChuruInoutTypes = cailiaoChuruInoutTypes;
    }
    /**
	 * 设置：备注
	 */
    public String getCailiaoChuruInoutContent() {
        return cailiaoChuruInoutContent;
    }


    /**
	 * 获取：备注
	 */

    public void setCailiaoChuruInoutContent(String cailiaoChuruInoutContent) {
        this.cailiaoChuruInoutContent = cailiaoChuruInoutContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
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
        return "CailiaoChuruInout{" +
            "id=" + id +
            ", cailiaoChuruInoutUuidNumber=" + cailiaoChuruInoutUuidNumber +
            ", cailiaoChuruInoutName=" + cailiaoChuruInoutName +
            ", cailiaoChuruInoutTypes=" + cailiaoChuruInoutTypes +
            ", cailiaoChuruInoutContent=" + cailiaoChuruInoutContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
