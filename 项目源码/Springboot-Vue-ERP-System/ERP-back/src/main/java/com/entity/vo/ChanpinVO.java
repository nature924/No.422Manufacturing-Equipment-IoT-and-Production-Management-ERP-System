package com.entity.vo;

import com.entity.ChanpinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 产品信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chanpin")
public class ChanpinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 产品编号
     */

    @TableField(value = "chanpin_uuid_unmber")
    private String chanpinUuidUnmber;


    /**
     * 产品名称
     */

    @TableField(value = "chanpin_name")
    private String chanpinName;


    /**
     * 产品类型
     */

    @TableField(value = "chanpin_types")
    private Integer chanpinTypes;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 产品详情
     */

    @TableField(value = "chanpin_content")
    private String chanpinContent;


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
	 * 设置：产品编号
	 */
    public String getChanpinUuidUnmber() {
        return chanpinUuidUnmber;
    }


    /**
	 * 获取：产品编号
	 */

    public void setChanpinUuidUnmber(String chanpinUuidUnmber) {
        this.chanpinUuidUnmber = chanpinUuidUnmber;
    }
    /**
	 * 设置：产品名称
	 */
    public String getChanpinName() {
        return chanpinName;
    }


    /**
	 * 获取：产品名称
	 */

    public void setChanpinName(String chanpinName) {
        this.chanpinName = chanpinName;
    }
    /**
	 * 设置：产品类型
	 */
    public Integer getChanpinTypes() {
        return chanpinTypes;
    }


    /**
	 * 获取：产品类型
	 */

    public void setChanpinTypes(Integer chanpinTypes) {
        this.chanpinTypes = chanpinTypes;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：产品详情
	 */
    public String getChanpinContent() {
        return chanpinContent;
    }


    /**
	 * 获取：产品详情
	 */

    public void setChanpinContent(String chanpinContent) {
        this.chanpinContent = chanpinContent;
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
