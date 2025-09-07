package com.entity.vo;

import com.entity.ShebeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 设备信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shebei")
public class ShebeiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 设备编号
     */

    @TableField(value = "shebei_uuid_unmber")
    private String shebeiUuidUnmber;


    /**
     * 设备名称
     */

    @TableField(value = "shebei_name")
    private String shebeiName;


    /**
     * 设备类型
     */

    @TableField(value = "shebei_types")
    private Integer shebeiTypes;


    /**
     * 上次检修日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shebei_time")
    private Date shebeiTime;


    /**
     * 设备状态
     */

    @TableField(value = "status_types")
    private Integer statusTypes;


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
	 * 设置：设备编号
	 */
    public String getShebeiUuidUnmber() {
        return shebeiUuidUnmber;
    }


    /**
	 * 获取：设备编号
	 */

    public void setShebeiUuidUnmber(String shebeiUuidUnmber) {
        this.shebeiUuidUnmber = shebeiUuidUnmber;
    }
    /**
	 * 设置：设备名称
	 */
    public String getShebeiName() {
        return shebeiName;
    }


    /**
	 * 获取：设备名称
	 */

    public void setShebeiName(String shebeiName) {
        this.shebeiName = shebeiName;
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
	 * 设置：上次检修日期
	 */
    public Date getShebeiTime() {
        return shebeiTime;
    }


    /**
	 * 获取：上次检修日期
	 */

    public void setShebeiTime(Date shebeiTime) {
        this.shebeiTime = shebeiTime;
    }
    /**
	 * 设置：设备状态
	 */
    public Integer getStatusTypes() {
        return statusTypes;
    }


    /**
	 * 获取：设备状态
	 */

    public void setStatusTypes(Integer statusTypes) {
        this.statusTypes = statusTypes;
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
