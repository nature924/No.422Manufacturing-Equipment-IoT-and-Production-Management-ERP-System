package com.entity.view;

import com.entity.ShengcanjihuaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 生产计划
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shengcanjihua")
public class ShengcanjihuaView extends ShengcanjihuaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 计划状态的值
		*/
		private String shengcanjihuaValue;



		//级联表 gukedingdan
			/**
			* 订单编号
			*/
			private String gukedingdanUuidUnmber;
			/**
			* 订购数量
			*/
			private Integer gukedingdanNumber;
			/**
			* 订单截止时间 show1 show2 photoShow
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date gukedingdanTime;
			/**
			* 订单状态
			*/
			private Integer gukedingdanTypes;
				/**
				* 订单状态的值
				*/
				private String gukedingdanValue;
			/**
			* 顾客订单内容
			*/
			private String gukedingdanText;

	public ShengcanjihuaView() {

	}

	public ShengcanjihuaView(ShengcanjihuaEntity shengcanjihuaEntity) {
		try {
			BeanUtils.copyProperties(this, shengcanjihuaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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














				//级联表的get和set gukedingdan
					/**
					* 获取： 订单编号
					*/
					public String getGukedingdanUuidUnmber() {
						return gukedingdanUuidUnmber;
					}
					/**
					* 设置： 订单编号
					*/
					public void setGukedingdanUuidUnmber(String gukedingdanUuidUnmber) {
						this.gukedingdanUuidUnmber = gukedingdanUuidUnmber;
					}

					/**
					* 获取： 订购数量
					*/
					public Integer getGukedingdanNumber() {
						return gukedingdanNumber;
					}
					/**
					* 设置： 订购数量
					*/
					public void setGukedingdanNumber(Integer gukedingdanNumber) {
						this.gukedingdanNumber = gukedingdanNumber;
					}
					/**
					* 获取： 订单截止时间 show1 show2 photoShow
					*/
					public Date getGukedingdanTime() {
						return gukedingdanTime;
					}
					/**
					* 设置： 订单截止时间 show1 show2 photoShow
					*/
					public void setGukedingdanTime(Date gukedingdanTime) {
						this.gukedingdanTime = gukedingdanTime;
					}
					/**
					* 获取： 订单状态
					*/
					public Integer getGukedingdanTypes() {
						return gukedingdanTypes;
					}
					/**
					* 设置： 订单状态
					*/
					public void setGukedingdanTypes(Integer gukedingdanTypes) {
						this.gukedingdanTypes = gukedingdanTypes;
					}


						/**
						* 获取： 订单状态的值
						*/
						public String getGukedingdanValue() {
							return gukedingdanValue;
						}
						/**
						* 设置： 订单状态的值
						*/
						public void setGukedingdanValue(String gukedingdanValue) {
							this.gukedingdanValue = gukedingdanValue;
						}
					/**
					* 获取： 顾客订单内容
					*/
					public String getGukedingdanText() {
						return gukedingdanText;
					}
					/**
					* 设置： 顾客订单内容
					*/
					public void setGukedingdanText(String gukedingdanText) {
						this.gukedingdanText = gukedingdanText;
					}














}
