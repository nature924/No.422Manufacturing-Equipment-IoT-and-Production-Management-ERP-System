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
 * 维修员
 *
 * @author 
 * @email
 */
@TableName("weixiuyuan")
public class WeixiuyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WeixiuyuanEntity() {

	}

	public WeixiuyuanEntity(T t) {
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
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 维修员姓名
     */
    @TableField(value = "weixiuyuan_name")

    private String weixiuyuanName;


    /**
     * 头像
     */
    @TableField(value = "weixiuyuan_photo")

    private String weixiuyuanPhoto;


    /**
     * 维修员手机号
     */
    @TableField(value = "weixiuyuan_phone")

    private String weixiuyuanPhone;


    /**
     * 维修员身份证号
     */
    @TableField(value = "weixiuyuan_id_number")

    private String weixiuyuanIdNumber;


    /**
     * 邮箱
     */
    @TableField(value = "weixiuyuan_email")

    private String weixiuyuanEmail;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 假删
     */
    @TableField(value = "weixiuyuan_delete")

    private Integer weixiuyuanDelete;


    /**
     * 入职日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "weixiuyuan_time")

    private Date weixiuyuanTime;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：维修员姓名
	 */
    public String getWeixiuyuanName() {
        return weixiuyuanName;
    }


    /**
	 * 获取：维修员姓名
	 */

    public void setWeixiuyuanName(String weixiuyuanName) {
        this.weixiuyuanName = weixiuyuanName;
    }
    /**
	 * 设置：头像
	 */
    public String getWeixiuyuanPhoto() {
        return weixiuyuanPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setWeixiuyuanPhoto(String weixiuyuanPhoto) {
        this.weixiuyuanPhoto = weixiuyuanPhoto;
    }
    /**
	 * 设置：维修员手机号
	 */
    public String getWeixiuyuanPhone() {
        return weixiuyuanPhone;
    }


    /**
	 * 获取：维修员手机号
	 */

    public void setWeixiuyuanPhone(String weixiuyuanPhone) {
        this.weixiuyuanPhone = weixiuyuanPhone;
    }
    /**
	 * 设置：维修员身份证号
	 */
    public String getWeixiuyuanIdNumber() {
        return weixiuyuanIdNumber;
    }


    /**
	 * 获取：维修员身份证号
	 */

    public void setWeixiuyuanIdNumber(String weixiuyuanIdNumber) {
        this.weixiuyuanIdNumber = weixiuyuanIdNumber;
    }
    /**
	 * 设置：邮箱
	 */
    public String getWeixiuyuanEmail() {
        return weixiuyuanEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setWeixiuyuanEmail(String weixiuyuanEmail) {
        this.weixiuyuanEmail = weixiuyuanEmail;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：假删
	 */
    public Integer getWeixiuyuanDelete() {
        return weixiuyuanDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setWeixiuyuanDelete(Integer weixiuyuanDelete) {
        this.weixiuyuanDelete = weixiuyuanDelete;
    }
    /**
	 * 设置：入职日期
	 */
    public Date getWeixiuyuanTime() {
        return weixiuyuanTime;
    }


    /**
	 * 获取：入职日期
	 */

    public void setWeixiuyuanTime(Date weixiuyuanTime) {
        this.weixiuyuanTime = weixiuyuanTime;
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
        return "Weixiuyuan{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", weixiuyuanName=" + weixiuyuanName +
            ", weixiuyuanPhoto=" + weixiuyuanPhoto +
            ", weixiuyuanPhone=" + weixiuyuanPhone +
            ", weixiuyuanIdNumber=" + weixiuyuanIdNumber +
            ", weixiuyuanEmail=" + weixiuyuanEmail +
            ", sexTypes=" + sexTypes +
            ", weixiuyuanDelete=" + weixiuyuanDelete +
            ", weixiuyuanTime=" + weixiuyuanTime +
            ", createTime=" + createTime +
        "}";
    }
}
