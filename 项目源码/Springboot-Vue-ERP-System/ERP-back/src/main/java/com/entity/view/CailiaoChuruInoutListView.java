package com.entity.view;

import com.entity.CailiaoChuruInoutListEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 出入库详情
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("cailiao_churu_inout_list")
public class CailiaoChuruInoutListView extends CailiaoChuruInoutListEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 cailiao
			/**
			* 材料编号
			*/
			private String cailiaoUuidUnmber;
			/**
			* 材料名称
			*/
			private String cailiaoName;
			/**
			* 材料类型
			*/
			private Integer cailiaoTypes;
				/**
				* 材料类型的值
				*/
				private String cailiaoValue;
			/**
			* 材料数量
			*/
			private Integer cailiaoKucunNumber;
			/**
			* 单位
			*/
			private String cailiaoDanwei;

		//级联表 cailiao_churu_inout
			/**
			* 出入库流水号
			*/
			private String cailiaoChuruInoutUuidNumber;
			/**
			* 出入库名称
			*/
			private String cailiaoChuruInoutName;
			/**
			* 出入库类型
			*/
			private Integer cailiaoChuruInoutTypes;
				/**
				* 出入库类型的值
				*/
				private String cailiaoChuruInoutValue;
			/**
			* 备注
			*/
			private String cailiaoChuruInoutContent;

	public CailiaoChuruInoutListView() {

	}

	public CailiaoChuruInoutListView(CailiaoChuruInoutListEntity cailiaoChuruInoutListEntity) {
		try {
			BeanUtils.copyProperties(this, cailiaoChuruInoutListEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}








				//级联表的get和set cailiao
					/**
					* 获取： 材料编号
					*/
					public String getCailiaoUuidUnmber() {
						return cailiaoUuidUnmber;
					}
					/**
					* 设置： 材料编号
					*/
					public void setCailiaoUuidUnmber(String cailiaoUuidUnmber) {
						this.cailiaoUuidUnmber = cailiaoUuidUnmber;
					}
					/**
					* 获取： 材料名称
					*/
					public String getCailiaoName() {
						return cailiaoName;
					}
					/**
					* 设置： 材料名称
					*/
					public void setCailiaoName(String cailiaoName) {
						this.cailiaoName = cailiaoName;
					}
					/**
					* 获取： 材料类型
					*/
					public Integer getCailiaoTypes() {
						return cailiaoTypes;
					}
					/**
					* 设置： 材料类型
					*/
					public void setCailiaoTypes(Integer cailiaoTypes) {
						this.cailiaoTypes = cailiaoTypes;
					}


						/**
						* 获取： 材料类型的值
						*/
						public String getCailiaoValue() {
							return cailiaoValue;
						}
						/**
						* 设置： 材料类型的值
						*/
						public void setCailiaoValue(String cailiaoValue) {
							this.cailiaoValue = cailiaoValue;
						}
					/**
					* 获取： 材料数量
					*/
					public Integer getCailiaoKucunNumber() {
						return cailiaoKucunNumber;
					}
					/**
					* 设置： 材料数量
					*/
					public void setCailiaoKucunNumber(Integer cailiaoKucunNumber) {
						this.cailiaoKucunNumber = cailiaoKucunNumber;
					}
					/**
					* 获取： 单位
					*/
					public String getCailiaoDanwei() {
						return cailiaoDanwei;
					}
					/**
					* 设置： 单位
					*/
					public void setCailiaoDanwei(String cailiaoDanwei) {
						this.cailiaoDanwei = cailiaoDanwei;
					}


				//级联表的get和set cailiao_churu_inout
					/**
					* 获取： 出入库流水号
					*/
					public String getCailiaoChuruInoutUuidNumber() {
						return cailiaoChuruInoutUuidNumber;
					}
					/**
					* 设置： 出入库流水号
					*/
					public void setCailiaoChuruInoutUuidNumber(String cailiaoChuruInoutUuidNumber) {
						this.cailiaoChuruInoutUuidNumber = cailiaoChuruInoutUuidNumber;
					}
					/**
					* 获取： 出入库名称
					*/
					public String getCailiaoChuruInoutName() {
						return cailiaoChuruInoutName;
					}
					/**
					* 设置： 出入库名称
					*/
					public void setCailiaoChuruInoutName(String cailiaoChuruInoutName) {
						this.cailiaoChuruInoutName = cailiaoChuruInoutName;
					}
					/**
					* 获取： 出入库类型
					*/
					public Integer getCailiaoChuruInoutTypes() {
						return cailiaoChuruInoutTypes;
					}
					/**
					* 设置： 出入库类型
					*/
					public void setCailiaoChuruInoutTypes(Integer cailiaoChuruInoutTypes) {
						this.cailiaoChuruInoutTypes = cailiaoChuruInoutTypes;
					}


						/**
						* 获取： 出入库类型的值
						*/
						public String getCailiaoChuruInoutValue() {
							return cailiaoChuruInoutValue;
						}
						/**
						* 设置： 出入库类型的值
						*/
						public void setCailiaoChuruInoutValue(String cailiaoChuruInoutValue) {
							this.cailiaoChuruInoutValue = cailiaoChuruInoutValue;
						}
					/**
					* 获取： 备注
					*/
					public String getCailiaoChuruInoutContent() {
						return cailiaoChuruInoutContent;
					}
					/**
					* 设置： 备注
					*/
					public void setCailiaoChuruInoutContent(String cailiaoChuruInoutContent) {
						this.cailiaoChuruInoutContent = cailiaoChuruInoutContent;
					}


































}
