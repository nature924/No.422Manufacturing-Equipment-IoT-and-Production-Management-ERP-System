package com.entity.model;

import com.entity.CailiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 材料信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CailiaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 材料编号
     */
    private String cailiaoUuidUnmber;


    /**
     * 材料名称
     */
    private String cailiaoName;


    /**
     * 材料类型
     */
    private Integer cailiaoTypes;


    /**
     * 材料数量
     */
    private Integer cailiaoKucunNumber;


    /**
     * 单位
     */
    private String cailiaoDanwei;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：材料编号
	 */
    public String getCailiaoUuidUnmber() {
        return cailiaoUuidUnmber;
    }


    /**
	 * 设置：材料编号
	 */
    public void setCailiaoUuidUnmber(String cailiaoUuidUnmber) {
        this.cailiaoUuidUnmber = cailiaoUuidUnmber;
    }
    /**
	 * 获取：材料名称
	 */
    public String getCailiaoName() {
        return cailiaoName;
    }


    /**
	 * 设置：材料名称
	 */
    public void setCailiaoName(String cailiaoName) {
        this.cailiaoName = cailiaoName;
    }
    /**
	 * 获取：材料类型
	 */
    public Integer getCailiaoTypes() {
        return cailiaoTypes;
    }


    /**
	 * 设置：材料类型
	 */
    public void setCailiaoTypes(Integer cailiaoTypes) {
        this.cailiaoTypes = cailiaoTypes;
    }
    /**
	 * 获取：材料数量
	 */
    public Integer getCailiaoKucunNumber() {
        return cailiaoKucunNumber;
    }


    /**
	 * 设置：材料数量
	 */
    public void setCailiaoKucunNumber(Integer cailiaoKucunNumber) {
        this.cailiaoKucunNumber = cailiaoKucunNumber;
    }
    /**
	 * 获取：单位
	 */
    public String getCailiaoDanwei() {
        return cailiaoDanwei;
    }


    /**
	 * 设置：单位
	 */
    public void setCailiaoDanwei(String cailiaoDanwei) {
        this.cailiaoDanwei = cailiaoDanwei;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
