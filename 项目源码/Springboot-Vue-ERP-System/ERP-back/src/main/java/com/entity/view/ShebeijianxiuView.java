package com.entity.view;

import com.entity.ShebeijianxiuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 设备检修
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shebeijianxiu")
public class ShebeijianxiuView extends ShebeijianxiuEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 shebei
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
				* 设备类型的值
				*/
				private String shebeiValue;
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
				* 设备状态的值
				*/
				private String statusValue;

		//级联表 weixiuyuan
			/**
			* 维修员姓名
			*/
			private String weixiuyuanName;
			/**
			* 头像
			*/
			private String weixiuyuanPhoto;
			/**
			* 维修员手机号
			*/
			private String weixiuyuanPhone;
			/**
			* 维修员身份证号
			*/
			private String weixiuyuanIdNumber;
			/**
			* 邮箱
			*/
			private String weixiuyuanEmail;
			/**
			* 假删
			*/
			private Integer weixiuyuanDelete;
			/**
			* 入职日期
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date weixiuyuanTime;

	public ShebeijianxiuView() {

	}

	public ShebeijianxiuView(ShebeijianxiuEntity shebeijianxiuEntity) {
		try {
			BeanUtils.copyProperties(this, shebeijianxiuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

























				//级联表的get和set shebei
					/**
					* 获取： 设备编号
					*/
					public String getShebeiUuidUnmber() {
						return shebeiUuidUnmber;
					}
					/**
					* 设置： 设备编号
					*/
					public void setShebeiUuidUnmber(String shebeiUuidUnmber) {
						this.shebeiUuidUnmber = shebeiUuidUnmber;
					}
					/**
					* 获取： 设备名称
					*/
					public String getShebeiName() {
						return shebeiName;
					}
					/**
					* 设置： 设备名称
					*/
					public void setShebeiName(String shebeiName) {
						this.shebeiName = shebeiName;
					}
					/**
					* 获取： 设备类型
					*/
					public Integer getShebeiTypes() {
						return shebeiTypes;
					}
					/**
					* 设置： 设备类型
					*/
					public void setShebeiTypes(Integer shebeiTypes) {
						this.shebeiTypes = shebeiTypes;
					}


						/**
						* 获取： 设备类型的值
						*/
						public String getShebeiValue() {
							return shebeiValue;
						}
						/**
						* 设置： 设备类型的值
						*/
						public void setShebeiValue(String shebeiValue) {
							this.shebeiValue = shebeiValue;
						}
					/**
					* 获取： 上次检修日期
					*/
					public Date getShebeiTime() {
						return shebeiTime;
					}
					/**
					* 设置： 上次检修日期
					*/
					public void setShebeiTime(Date shebeiTime) {
						this.shebeiTime = shebeiTime;
					}
					/**
					* 获取： 设备状态
					*/
					public Integer getStatusTypes() {
						return statusTypes;
					}
					/**
					* 设置： 设备状态
					*/
					public void setStatusTypes(Integer statusTypes) {
						this.statusTypes = statusTypes;
					}


						/**
						* 获取： 设备状态的值
						*/
						public String getStatusValue() {
							return statusValue;
						}
						/**
						* 设置： 设备状态的值
						*/
						public void setStatusValue(String statusValue) {
							this.statusValue = statusValue;
						}










				//级联表的get和set weixiuyuan
					/**
					* 获取： 维修员姓名
					*/
					public String getWeixiuyuanName() {
						return weixiuyuanName;
					}
					/**
					* 设置： 维修员姓名
					*/
					public void setWeixiuyuanName(String weixiuyuanName) {
						this.weixiuyuanName = weixiuyuanName;
					}
					/**
					* 获取： 头像
					*/
					public String getWeixiuyuanPhoto() {
						return weixiuyuanPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setWeixiuyuanPhoto(String weixiuyuanPhoto) {
						this.weixiuyuanPhoto = weixiuyuanPhoto;
					}
					/**
					* 获取： 维修员手机号
					*/
					public String getWeixiuyuanPhone() {
						return weixiuyuanPhone;
					}
					/**
					* 设置： 维修员手机号
					*/
					public void setWeixiuyuanPhone(String weixiuyuanPhone) {
						this.weixiuyuanPhone = weixiuyuanPhone;
					}
					/**
					* 获取： 维修员身份证号
					*/
					public String getWeixiuyuanIdNumber() {
						return weixiuyuanIdNumber;
					}
					/**
					* 设置： 维修员身份证号
					*/
					public void setWeixiuyuanIdNumber(String weixiuyuanIdNumber) {
						this.weixiuyuanIdNumber = weixiuyuanIdNumber;
					}
					/**
					* 获取： 邮箱
					*/
					public String getWeixiuyuanEmail() {
						return weixiuyuanEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setWeixiuyuanEmail(String weixiuyuanEmail) {
						this.weixiuyuanEmail = weixiuyuanEmail;
					}
					/**
					* 获取： 假删
					*/
					public Integer getWeixiuyuanDelete() {
						return weixiuyuanDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setWeixiuyuanDelete(Integer weixiuyuanDelete) {
						this.weixiuyuanDelete = weixiuyuanDelete;
					}
					/**
					* 获取： 入职日期
					*/
					public Date getWeixiuyuanTime() {
						return weixiuyuanTime;
					}
					/**
					* 设置： 入职日期
					*/
					public void setWeixiuyuanTime(Date weixiuyuanTime) {
						this.weixiuyuanTime = weixiuyuanTime;
					}









}
