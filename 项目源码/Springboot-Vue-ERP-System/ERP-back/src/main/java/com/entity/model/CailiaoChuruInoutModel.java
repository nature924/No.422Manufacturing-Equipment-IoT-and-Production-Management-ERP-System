package com.entity.model;

import com.entity.CailiaoChuruInoutEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 出入库
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CailiaoChuruInoutModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 出入库流水号
     */
    private String cailiaoChuruInoutUuidNumber;


    /**
     * 出入库名称
     */
    private String cailiaoChuruInoutName;


    /**
     * 出入库类型
     */
    private Integer cailiaoChuruInoutTypes;


    /**
     * 备注
     */
    private String cailiaoChuruInoutContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：出入库流水号
	 */
    public String getCailiaoChuruInoutUuidNumber() {
        return cailiaoChuruInoutUuidNumber;
    }


    /**
	 * 设置：出入库流水号
	 */
    public void setCailiaoChuruInoutUuidNumber(String cailiaoChuruInoutUuidNumber) {
        this.cailiaoChuruInoutUuidNumber = cailiaoChuruInoutUuidNumber;
    }
    /**
	 * 获取：出入库名称
	 */
    public String getCailiaoChuruInoutName() {
        return cailiaoChuruInoutName;
    }


    /**
	 * 设置：出入库名称
	 */
    public void setCailiaoChuruInoutName(String cailiaoChuruInoutName) {
        this.cailiaoChuruInoutName = cailiaoChuruInoutName;
    }
    /**
	 * 获取：出入库类型
	 */
    public Integer getCailiaoChuruInoutTypes() {
        return cailiaoChuruInoutTypes;
    }


    /**
	 * 设置：出入库类型
	 */
    public void setCailiaoChuruInoutTypes(Integer cailiaoChuruInoutTypes) {
        this.cailiaoChuruInoutTypes = cailiaoChuruInoutTypes;
    }
    /**
	 * 获取：备注
	 */
    public String getCailiaoChuruInoutContent() {
        return cailiaoChuruInoutContent;
    }


    /**
	 * 设置：备注
	 */
    public void setCailiaoChuruInoutContent(String cailiaoChuruInoutContent) {
        this.cailiaoChuruInoutContent = cailiaoChuruInoutContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
