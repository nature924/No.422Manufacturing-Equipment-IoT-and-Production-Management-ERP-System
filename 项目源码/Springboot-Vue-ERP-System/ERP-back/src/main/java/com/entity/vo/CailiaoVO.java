package com.entity.vo;

import com.entity.CailiaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 材料信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("cailiao")
public class CailiaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 材料编号
     */

    @TableField(value = "cailiao_uuid_unmber")
    private String cailiaoUuidUnmber;


    /**
     * 材料名称
     */

    @TableField(value = "cailiao_name")
    private String cailiaoName;


    /**
     * 材料类型
     */

    @TableField(value = "cailiao_types")
    private Integer cailiaoTypes;


    /**
     * 材料数量
     */

    @TableField(value = "cailiao_kucun_number")
    private Integer cailiaoKucunNumber;


    /**
     * 单位
     */

    @TableField(value = "cailiao_danwei")
    private String cailiaoDanwei;


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
	 * 设置：材料编号
	 */
    public String getCailiaoUuidUnmber() {
        return cailiaoUuidUnmber;
    }


    /**
	 * 获取：材料编号
	 */

    public void setCailiaoUuidUnmber(String cailiaoUuidUnmber) {
        this.cailiaoUuidUnmber = cailiaoUuidUnmber;
    }
    /**
	 * 设置：材料名称
	 */
    public String getCailiaoName() {
        return cailiaoName;
    }


    /**
	 * 获取：材料名称
	 */

    public void setCailiaoName(String cailiaoName) {
        this.cailiaoName = cailiaoName;
    }
    /**
	 * 设置：材料类型
	 */
    public Integer getCailiaoTypes() {
        return cailiaoTypes;
    }


    /**
	 * 获取：材料类型
	 */

    public void setCailiaoTypes(Integer cailiaoTypes) {
        this.cailiaoTypes = cailiaoTypes;
    }
    /**
	 * 设置：材料数量
	 */
    public Integer getCailiaoKucunNumber() {
        return cailiaoKucunNumber;
    }


    /**
	 * 获取：材料数量
	 */

    public void setCailiaoKucunNumber(Integer cailiaoKucunNumber) {
        this.cailiaoKucunNumber = cailiaoKucunNumber;
    }
    /**
	 * 设置：单位
	 */
    public String getCailiaoDanwei() {
        return cailiaoDanwei;
    }


    /**
	 * 获取：单位
	 */

    public void setCailiaoDanwei(String cailiaoDanwei) {
        this.cailiaoDanwei = cailiaoDanwei;
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
