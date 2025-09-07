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
 * 材料信息
 *
 * @author 
 * @email
 */
@TableName("cailiao")
public class CailiaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CailiaoEntity() {

	}

	public CailiaoEntity(T t) {
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
     * 材料编号
     */
    @TableField(value = "cailiao_uuid_unmber")

    private String cailiaoUuidUnmber;


    /**
     * 材料名称
     */
    @TableField(value = "cailiao_name")

    private String cailiaoName;


    /**
     * 材料类型
     */
    @TableField(value = "cailiao_types")

    private Integer cailiaoTypes;


    /**
     * 材料数量
     */
    @TableField(value = "cailiao_kucun_number")

    private Integer cailiaoKucunNumber;


    /**
     * 单位
     */
    @TableField(value = "cailiao_danwei")

    private String cailiaoDanwei;


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
	 * 设置：材料编号
	 */
    public String getCailiaoUuidUnmber() {
        return cailiaoUuidUnmber;
    }


    /**
	 * 获取：材料编号
	 */

    public void setCailiaoUuidUnmber(String cailiaoUuidUnmber) {
        this.cailiaoUuidUnmber = cailiaoUuidUnmber;
    }
    /**
	 * 设置：材料名称
	 */
    public String getCailiaoName() {
        return cailiaoName;
    }


    /**
	 * 获取：材料名称
	 */

    public void setCailiaoName(String cailiaoName) {
        this.cailiaoName = cailiaoName;
    }
    /**
	 * 设置：材料类型
	 */
    public Integer getCailiaoTypes() {
        return cailiaoTypes;
    }


    /**
	 * 获取：材料类型
	 */

    public void setCailiaoTypes(Integer cailiaoTypes) {
        this.cailiaoTypes = cailiaoTypes;
    }
    /**
	 * 设置：材料数量
	 */
    public Integer getCailiaoKucunNumber() {
        return cailiaoKucunNumber;
    }


    /**
	 * 获取：材料数量
	 */

    public void setCailiaoKucunNumber(Integer cailiaoKucunNumber) {
        this.cailiaoKucunNumber = cailiaoKucunNumber;
    }
    /**
	 * 设置：单位
	 */
    public String getCailiaoDanwei() {
        return cailiaoDanwei;
    }


    /**
	 * 获取：单位
	 */

    public void setCailiaoDanwei(String cailiaoDanwei) {
        this.cailiaoDanwei = cailiaoDanwei;
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
        return "Cailiao{" +
            "id=" + id +
            ", cailiaoUuidUnmber=" + cailiaoUuidUnmber +
            ", cailiaoName=" + cailiaoName +
            ", cailiaoTypes=" + cailiaoTypes +
            ", cailiaoKucunNumber=" + cailiaoKucunNumber +
            ", cailiaoDanwei=" + cailiaoDanwei +
            ", createTime=" + createTime +
        "}";
    }
}
