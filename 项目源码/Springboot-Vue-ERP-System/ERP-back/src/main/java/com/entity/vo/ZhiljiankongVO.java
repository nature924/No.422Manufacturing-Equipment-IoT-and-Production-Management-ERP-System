package com.entity.vo;

import com.entity.ZhiljiankongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 质量监控
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhiljiankong")
public class ZhiljiankongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 生产计划
     */

    @TableField(value = "shengcanjihua_id")
    private Integer shengcanjihuaId;


    /**
     * 不合格产品名称
     */

    @TableField(value = "zhiljiankong_name")
    private String zhiljiankongName;


    /**
     * 设备类型
     */

    @TableField(value = "shebei_types")
    private Integer shebeiTypes;


    /**
     * 员工
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 不合格产品数量
     */

    @TableField(value = "zhiljiankong_number")
    private Integer zhiljiankongNumber;


    /**
     * 时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：生产计划
	 */
    public Integer getShengcanjihuaId() {
        return shengcanjihuaId;
    }


    /**
	 * 获取：生产计划
	 */

    public void setShengcanjihuaId(Integer shengcanjihuaId) {
        this.shengcanjihuaId = shengcanjihuaId;
    }
    /**
	 * 设置：不合格产品名称
	 */
    public String getZhiljiankongName() {
        return zhiljiankongName;
    }


    /**
	 * 获取：不合格产品名称
	 */

    public void setZhiljiankongName(String zhiljiankongName) {
        this.zhiljiankongName = zhiljiankongName;
    }
    /**
	 * 设置：设备类型
	 */
    public Integer getShebeiTypes() {
        return shebeiTypes;
    }


    /**
	 * 获取：设备类型
	 */

    public void setShebeiTypes(Integer shebeiTypes) {
        this.shebeiTypes = shebeiTypes;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：员工
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：不合格产品数量
	 */
    public Integer getZhiljiankongNumber() {
        return zhiljiankongNumber;
    }


    /**
	 * 获取：不合格产品数量
	 */

    public void setZhiljiankongNumber(Integer zhiljiankongNumber) {
        this.zhiljiankongNumber = zhiljiankongNumber;
    }
    /**
	 * 设置：时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
