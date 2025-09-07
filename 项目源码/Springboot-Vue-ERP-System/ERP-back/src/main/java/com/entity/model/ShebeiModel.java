package com.entity.model;

import com.entity.ShebeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 设备信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShebeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 设备编号
     */
    private String shebeiUuidUnmber;


    /**
     * 设备名称
     */
    private String shebeiName;


    /**
     * 设备类型
     */
    private Integer shebeiTypes;


    /**
     * 上次检修日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shebeiTime;


    /**
     * 设备状态
     */
    private Integer statusTypes;


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
	 * 获取：设备编号
	 */
    public String getShebeiUuidUnmber() {
        return shebeiUuidUnmber;
    }


    /**
	 * 设置：设备编号
	 */
    public void setShebeiUuidUnmber(String shebeiUuidUnmber) {
        this.shebeiUuidUnmber = shebeiUuidUnmber;
    }
    /**
	 * 获取：设备名称
	 */
    public String getShebeiName() {
        return shebeiName;
    }


    /**
	 * 设置：设备名称
	 */
    public void setShebeiName(String shebeiName) {
        this.shebeiName = shebeiName;
    }
    /**
	 * 获取：设备类型
	 */
    public Integer getShebeiTypes() {
        return shebeiTypes;
    }


    /**
	 * 设置：设备类型
	 */
    public void setShebeiTypes(Integer shebeiTypes) {
        this.shebeiTypes = shebeiTypes;
    }
    /**
	 * 获取：上次检修日期
	 */
    public Date getShebeiTime() {
        return shebeiTime;
    }


    /**
	 * 设置：上次检修日期
	 */
    public void setShebeiTime(Date shebeiTime) {
        this.shebeiTime = shebeiTime;
    }
    /**
	 * 获取：设备状态
	 */
    public Integer getStatusTypes() {
        return statusTypes;
    }


    /**
	 * 设置：设备状态
	 */
    public void setStatusTypes(Integer statusTypes) {
        this.statusTypes = statusTypes;
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
