package com.entity.view;

import com.entity.GukedingdanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 顾客订单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("gukedingdan")
public class GukedingdanView extends GukedingdanEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 订单状态的值
		*/
		private String gukedingdanValue;



		//级联表 chanpin
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
				* 产品类型的值
				*/
				private String chanpinValue;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 产品详情
			*/
			private String chanpinContent;

	public GukedingdanView() {

	}

	public GukedingdanView(GukedingdanEntity gukedingdanEntity) {
		try {
			BeanUtils.copyProperties(this, gukedingdanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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










				//级联表的get和set chanpin
					/**
					* 获取： 产品编号
					*/
					public String getChanpinUuidUnmber() {
						return chanpinUuidUnmber;
					}
					/**
					* 设置： 产品编号
					*/
					public void setChanpinUuidUnmber(String chanpinUuidUnmber) {
						this.chanpinUuidUnmber = chanpinUuidUnmber;
					}
					/**
					* 获取： 产品名称
					*/
					public String getChanpinName() {
						return chanpinName;
					}
					/**
					* 设置： 产品名称
					*/
					public void setChanpinName(String chanpinName) {
						this.chanpinName = chanpinName;
					}
					/**
					* 获取： 产品类型
					*/
					public Integer getChanpinTypes() {
						return chanpinTypes;
					}
					/**
					* 设置： 产品类型
					*/
					public void setChanpinTypes(Integer chanpinTypes) {
						this.chanpinTypes = chanpinTypes;
					}


						/**
						* 获取： 产品类型的值
						*/
						public String getChanpinValue() {
							return chanpinValue;
						}
						/**
						* 设置： 产品类型的值
						*/
						public void setChanpinValue(String chanpinValue) {
							this.chanpinValue = chanpinValue;
						}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}
					/**
					* 获取： 产品详情
					*/
					public String getChanpinContent() {
						return chanpinContent;
					}
					/**
					* 设置： 产品详情
					*/
					public void setChanpinContent(String chanpinContent) {
						this.chanpinContent = chanpinContent;
					}


















}
