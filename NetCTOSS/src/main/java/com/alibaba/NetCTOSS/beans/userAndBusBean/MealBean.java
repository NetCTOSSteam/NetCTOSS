package com.alibaba.NetCTOSS.beans.userAndBusBean;

import java.io.Serializable;
import java.util.Date;

/**
 * 资费类
 * @author Administrator
 *
 */
/**
 * @author asus
 *
 */
public class MealBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 649155864463231223L;
	/**
	 * 资费id
	 */
	int mealId;
	/**
	 * 资费名字
	 */
	String mealName;
	/**
	 * 资费类型
	 */
    int mealType;
    /**
     * 资费时长
     */
    int mealTime;
    /**
     * 基本费用
     */
    double mealBasicMoney;
    /**
     * 单位费用
     */
    double mealMoney;
    /**
     * 资费说明
     */
	String mealDescribe;
	/**
	 * 资费状态
	 */
	boolean mealStatus;
	/**
	 * 开通时间
	 */
	Date mealStartTime;
	
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
