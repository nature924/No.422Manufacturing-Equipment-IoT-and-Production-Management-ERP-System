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
 * 出入库详情
 *
 * @author 
 * @email
 */
@TableName("cailiao_churu_inout_list")
public class CailiaoChuruInoutListEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CailiaoChuruInoutListEntity() {

	}

	public CailiaoChuruInoutListEntity(T t) {
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
     * 出入库
     */
    @TableField(value = "cailiao_churu_inout_id")

    private Integer cailiaoChuruInoutId;


    /**
     * 材料
     */
    @TableField(value = "cailiao_id")

    private Integer cailiaoId;


    /**
     * 操作数量
     */
    @TableField(value = "cailiao_churu_inout_list_number")

    private Integer cailiaoChuruInoutListNumber;


    /**
     * 操作时间
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
	 * 设置：出入库
	 */
    public Integer getCailiaoChuruInoutId() {
        return cailiaoChuruInoutId;
    }


    /**
	 * 获取：出入库
	 */

    public void setCailiaoChuruInoutId(Integer cailiaoChuruInoutId) {
        this.cailiaoChuruInoutId = cailiaoChuruInoutId;
    }
    /**
	 * 设置：材料
	 */
    public Integer getCailiaoId() {
        return cailiaoId;
    }


    /**
	 * 获取：材料
	 */

    public void setCailiaoId(Integer cailiaoId) {
        this.cailiaoId = cailiaoId;
    }
    /**
	 * 设置：操作数量
	 */
    public Integer getCailiaoChuruInoutListNumber() {
        return cailiaoChuruInoutListNumber;
    }


    /**
	 * 获取：操作数量
	 */

    public void setCailiaoChuruInoutListNumber(Integer cailiaoChuruInoutListNumber) {
        this.cailiaoChuruInoutListNumber = cailiaoChuruInoutListNumber;
    }
    /**
	 * 设置：操作时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：操作时间
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
        return "CailiaoChuruInoutList{" +
            "id=" + id +
            ", cailiaoChuruInoutId=" + cailiaoChuruInoutId +
            ", cailiaoId=" + cailiaoId +
            ", cailiaoChuruInoutListNumber=" + cailiaoChuruInoutListNumber +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
