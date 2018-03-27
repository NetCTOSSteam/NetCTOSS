package com.alibaba.NetCTOSS.beans.userAndBusBean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 业务 账户 类
 * @author Administrator
 *
 */
@Entity
@Table(name="t_business",catalog="netctoss")
public class BusinessBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2673540182928695962L;

	/**
	 * bus_id
	 * id字段
	 */
	@Id
	@Column(name="bus_id")
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private Integer id;
	
	/**
	 * bus_name
	 * 业务账户名
	 */
	@Column(name="bus_name",length=20)
	private String busName;
	
	/**
	 * bus_ip
	 * 实验室服务器IP
	 */
	@Column(name="bus_ip",length=20)
	private String serverIP;
	
	
	/**
	 * bus_password
	 * 密码
	 */
	@Column(name="bus_password",length=32)
	private String password;
	
	/**
	 * bus_mea_id
	 * 资费外键
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.ALL})
	@JoinColumn(name="bus_mea_id")
	private MealBean mealBean;
	
	/**
	 * bus_u_id
	 * 账务账户外键
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.ALL})
	@JoinColumn(name="bus_u_id")
	private UserBean userBean;
	
	/**
	 * bus_state
	 * 业务状态
	 */
	@Column(name="bus_state")
	private String state;
	
	/**
	 * bus_next_mea_id
	 * 下月资费外键
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.ALL})
	@JoinColumn(name="bus_next_mea_id")
	private MealBean nextMealBean;
	
	/**
	 * bus_time
	 * 开通时间
	 */
	@Column(name="bus_time")
	private Date startTime;
	
	/**
	 * bus_bo
	 * 数据是否有效
	 */
	@Column(name="bus_bo")
	private int bo;
	
	
	
	public BusinessBean() {
		// TODO Auto-generated constructor stub
		bo = 1; 
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getBusName() {
		return busName;
	}


	public void setBusName(String busName) {
		this.busName = busName;
	}


	public String getServerIP() {
		return serverIP;
	}


	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public MealBean getMealBean() {
		return mealBean;
	}


	public void setMealBean(MealBean mealBean) {
		nextMealBean=mealBean;//默认下月资费为当月资费
		this.mealBean = mealBean;
	}


	public UserBean getUserBean() {
		return userBean;
	}


	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}


	public String isState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public MealBean getNextMealBean() {
		return nextMealBean;
	}


	public void setNextMealBean(MealBean nextMealBean) {
		this.nextMealBean = nextMealBean;
	}


	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public void setBo(int bo) {
		this.bo = bo;
	}
	
	

	public int getBo() {
		return bo;
	}


	@Override
	public String toString() {
		return "BusinessBean [id=" + id + ", busName=" + busName + ", serverIP=" + serverIP + ", password=" + password
				+ ", mealBean=" + mealBean + ", userBean=" + userBean + ", state=" + state + ", nextMealBean="
				+ nextMealBean + ", startTime=" + startTime + "]";
	}


	
}
