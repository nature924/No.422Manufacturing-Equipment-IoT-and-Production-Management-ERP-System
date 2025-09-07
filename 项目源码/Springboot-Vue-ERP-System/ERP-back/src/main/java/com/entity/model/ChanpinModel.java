package com.entity.model;

import com.entity.ChanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 产品信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChanpinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 产品编号
     */
    private String chanpinUuidUnmber;


    /**
     * 产品名称
     */
    private String chanpinName;


    /**
     * 产品类型
     */
    private Integer chanpinTypes;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 产品详情
     */
    private String chanpinContent;


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
	 * 获取：产品编号
	 */
    public String getChanpinUuidUnmber() {
        return chanpinUuidUnmber;
    }


    /**
	 * 设置：产品编号
	 */
    public void setChanpinUuidUnmber(String chanpinUuidUnmber) {
        this.chanpinUuidUnmber = chanpinUuidUnmber;
    }
    /**
	 * 获取：产品名称
	 */
    public String getChanpinName() {
        return chanpinName;
    }


    /**
	 * 设置：产品名称
	 */
    public void setChanpinName(String chanpinName) {
        this.chanpinName = chanpinName;
    }
    /**
	 * 获取：产品类型
	 */
    public Integer getChanpinTypes() {
        return chanpinTypes;
    }


    /**
	 * 设置：产品类型
	 */
    public void setChanpinTypes(Integer chanpinTypes) {
        this.chanpinTypes = chanpinTypes;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：产品详情
	 */
    public String getChanpinContent() {
        return chanpinContent;
    }


    /**
	 * 设置：产品详情
	 */
    public void setChanpinContent(String chanpinContent) {
        this.chanpinContent = chanpinContent;
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
