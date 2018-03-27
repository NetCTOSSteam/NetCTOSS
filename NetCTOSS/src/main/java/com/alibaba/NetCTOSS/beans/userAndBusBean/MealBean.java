package com.alibaba.NetCTOSS.beans.userAndBusBean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 资费类
 * @author Administrator
 *
 */
/**
 * @author asus
 *
 */
@Entity
@Table(name="t_meal")
public class MealBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 649155864463231223L;
	/**
	 * 资费id
	 */
	@Id
	@Column(name="mea_id")
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private int mealId;
	/**
	 * 资费名字
	 */
	@Column(name="mea_name",length=20)
	private String mealName;
	/**
	 * 资费类型
	 */
	@Column(name="mea_type")
	private int mealType;
    /**
     * 资费时长
     */
	@Column(name="mea_time")
	private int mealTime;
    /**
     * 基本费用
     */
	@Column(name="mea_basic_money")
	private double mealBasicMoney;
    /**
     * 单位费用
     */
	@Column(name="mea_money")
	private double mealMoney;
    /**
     * 资费说明
     */
	@Column(name="mea_describe")
	private String mealDescribe;
	/**
	 * 资费状态
	 */
	@Column(name="mea_status")
	private boolean mealStatus;
	/**
	 * 开通时间
	 */
	@Column(name="mea_start_time")
	private Date mealStartTime;
	
	public MealBean() {
		// TODO Auto-generated constructor stub
	}
	
	public int getMealId() {
		return mealId;
	}
	public void setMealId(int mealId) {
		this.mealId = mealId;
	}
	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	public int getMealType() {
		return mealType;
	}
	public void setMealType(int mealType) {
		this.mealType = mealType;
	}
	public int getMealTime() {
		return mealTime;
	}
	public void setMealTime(int mealTime) {
		this.mealTime = mealTime;
	}
	public double getMealBasicMoney() {
		return mealBasicMoney;
	}
	public void setMealBasicMoney(double mealBasicMoney) {
		this.mealBasicMoney = mealBasicMoney;
	}
	public double getMealMoney() {
		return mealMoney;
	}
	public void setMealMoney(double mealMoney) {
		this.mealMoney = mealMoney;
	}
	public String getMealDescribe() {
		return mealDescribe;
	}
	public void setMealDescribe(String mealDescribe) {
		this.mealDescribe = mealDescribe;
	}
	public boolean isMealStatus() {
		return mealStatus;
	}
	public void setMealStatus(boolean mealStatus) {
		this.mealStatus = mealStatus;
	}
	public Date getMealStartTime() {
		return mealStartTime;
	}
	public void setMealStartTime(Date mealStartTime) {
		this.mealStartTime = mealStartTime;
	}

	@Override
	public String toString() {
		return "MealBean [mealId=" + mealId + ", mealName=" + mealName + ", mealType=" + mealType + ", mealTime="
				+ mealTime + ", mealBasicMoney=" + mealBasicMoney + ", mealMoney=" + mealMoney + ", mealDescribe="
				+ mealDescribe + ", mealStatus=" + mealStatus + ", mealStartTime=" + mealStartTime + "]";
	}

}
