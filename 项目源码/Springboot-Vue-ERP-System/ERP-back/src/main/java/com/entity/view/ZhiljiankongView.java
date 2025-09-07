package com.entity.view;

import com.entity.ZhiljiankongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 质量监控
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zhiljiankong")
public class ZhiljiankongView extends ZhiljiankongEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 设备类型的值
		*/
		private String shebeiValue;



		//级联表 shengcanjihua
			/**
			* 开始的时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date shengcanjihukaishiTime;
			/**
			* 结束时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date shengcanjihujieshuTime;
			/**
			* 计划状态
			*/
			private Integer shengcanjihuaTypes;
				/**
				* 计划状态的值
				*/
				private String shengcanjihuaValue;

		//级联表 yonghu
			/**
			* 员工姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 员工手机号
			*/
			private String yonghuPhone;
			/**
			* 员工身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 职能
			*/
			private String yonghuZhineng;
			/**
			* 部门
			*/
			private Integer bumenTypes;
				/**
				* 部门的值
				*/
				private String bumenValue;
			/**
			* 假删
			*/
			private Integer yonghuDelete;
			/**
			* 入职日期
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date yonghuTime;

	public ZhiljiankongView() {

	}

	public ZhiljiankongView(ZhiljiankongEntity zhiljiankongEntity) {
		try {
			BeanUtils.copyProperties(this, zhiljiankongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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




























				//级联表的get和set shengcanjihua

					/**
					* 获取： 开始的时间
					*/
					public Date getShengcanjihukaishiTime() {
						return shengcanjihukaishiTime;
					}
					/**
					* 设置： 开始的时间
					*/
					public void setShengcanjihukaishiTime(Date shengcanjihukaishiTime) {
						this.shengcanjihukaishiTime = shengcanjihukaishiTime;
					}
					/**
					* 获取： 结束时间
					*/
					public Date getShengcanjihujieshuTime() {
						return shengcanjihujieshuTime;
					}
					/**
					* 设置： 结束时间
					*/
					public void setShengcanjihujieshuTime(Date shengcanjihujieshuTime) {
						this.shengcanjihujieshuTime = shengcanjihujieshuTime;
					}
					/**
					* 获取： 计划状态
					*/
					public Integer getShengcanjihuaTypes() {
						return shengcanjihuaTypes;
					}
					/**
					* 设置： 计划状态
					*/
					public void setShengcanjihuaTypes(Integer shengcanjihuaTypes) {
						this.shengcanjihuaTypes = shengcanjihuaTypes;
					}


						/**
						* 获取： 计划状态的值
						*/
						public String getShengcanjihuaValue() {
							return shengcanjihuaValue;
						}
						/**
						* 设置： 计划状态的值
						*/
						public void setShengcanjihuaValue(String shengcanjihuaValue) {
							this.shengcanjihuaValue = shengcanjihuaValue;
						}







				//级联表的get和set yonghu
					/**
					* 获取： 员工姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 员工姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 员工手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 员工手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 员工身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 员工身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 职能
					*/
					public String getYonghuZhineng() {
						return yonghuZhineng;
					}
					/**
					* 设置： 职能
					*/
					public void setYonghuZhineng(String yonghuZhineng) {
						this.yonghuZhineng = yonghuZhineng;
					}
					/**
					* 获取： 部门
					*/
					public Integer getBumenTypes() {
						return bumenTypes;
					}
					/**
					* 设置： 部门
					*/
					public void setBumenTypes(Integer bumenTypes) {
						this.bumenTypes = bumenTypes;
					}


						/**
						* 获取： 部门的值
						*/
						public String getBumenValue() {
							return bumenValue;
						}
						/**
						* 设置： 部门的值
						*/
						public void setBumenValue(String bumenValue) {
							this.bumenValue = bumenValue;
						}
					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}
					/**
					* 获取： 入职日期
					*/
					public Date getYonghuTime() {
						return yonghuTime;
					}
					/**
					* 设置： 入职日期
					*/
					public void setYonghuTime(Date yonghuTime) {
						this.yonghuTime = yonghuTime;
					}






}
