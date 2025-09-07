package com.entity.model;

import com.entity.ZhiljiankongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 质量监控
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhiljiankongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 生产计划
     */
    private Integer shengcanjihuaId;


    /**
     * 不合格产品名称
     */
    private String zhiljiankongName;


    /**
     * 设备类型
     */
    private Integer shebeiTypes;


    /**
     * 员工
     */
    private Integer yonghuId;


    /**
     * 不合格产品数量
     */
    private Integer zhiljiankongNumber;


    /**
     * 时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：生产计划
	 */
    public Integer getShengcanjihuaId() {
        return shengcanjihuaId;
    }


    /**
	 * 设置：生产计划
	 */
    public void setShengcanjihuaId(Integer shengcanjihuaId) {
        this.shengcanjihuaId = shengcanjihuaId;
    }
    /**
	 * 获取：不合格产品名称
	 */
    public String getZhiljiankongName() {
        return zhiljiankongName;
    }


    /**
	 * 设置：不合格产品名称
	 */
    public void setZhiljiankongName(String zhiljiankongName) {
        this.zhiljiankongName = zhiljiankongName;
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
	 * 获取：员工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：员工
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：不合格产品数量
	 */
    public Integer getZhiljiankongNumber() {
        return zhiljiankongNumber;
    }


    /**
	 * 设置：不合格产品数量
	 */
    public void setZhiljiankongNumber(Integer zhiljiankongNumber) {
        this.zhiljiankongNumber = zhiljiankongNumber;
    }
    /**
	 * 获取：时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
