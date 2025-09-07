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
 * 产品信息
 *
 * @author 
 * @email
 */
@TableName("chanpin")
public class ChanpinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChanpinEntity() {

	}

	public ChanpinEntity(T t) {
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
     * 产品编号
     */
    @TableField(value = "chanpin_uuid_unmber")

    private String chanpinUuidUnmber;


    /**
     * 产品名称
     */
    @TableField(value = "chanpin_name")

    private String chanpinName;


    /**
     * 产品类型
     */
    @TableField(value = "chanpin_types")

    private Integer chanpinTypes;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 产品详情
     */
    @TableField(value = "chanpin_content")

    private String chanpinContent;


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
	 * 设置：产品编号
	 */
    public String getChanpinUuidUnmber() {
        return chanpinUuidUnmber;
    }


    /**
	 * 获取：产品编号
	 */

    public void setChanpinUuidUnmber(String chanpinUuidUnmber) {
        this.chanpinUuidUnmber = chanpinUuidUnmber;
    }
    /**
	 * 设置：产品名称
	 */
    public String getChanpinName() {
        return chanpinName;
    }


    /**
	 * 获取：产品名称
	 */

    public void setChanpinName(String chanpinName) {
        this.chanpinName = chanpinName;
    }
    /**
	 * 设置：产品类型
	 */
    public Integer getChanpinTypes() {
        return chanpinTypes;
    }


    /**
	 * 获取：产品类型
	 */

    public void setChanpinTypes(Integer chanpinTypes) {
        this.chanpinTypes = chanpinTypes;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：产品详情
	 */
    public String getChanpinContent() {
        return chanpinContent;
    }


    /**
	 * 获取：产品详情
	 */

    public void setChanpinContent(String chanpinContent) {
        this.chanpinContent = chanpinContent;
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
        return "Chanpin{" +
            "id=" + id +
            ", chanpinUuidUnmber=" + chanpinUuidUnmber +
            ", chanpinName=" + chanpinName +
            ", chanpinTypes=" + chanpinTypes +
            ", shangxiaTypes=" + shangxiaTypes +
            ", chanpinContent=" + chanpinContent +
            ", createTime=" + createTime +
        "}";
    }
}
