package com.alibaba.NetCTOSS.beans.logBean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 操作 日志
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_do_log")
public class DoLogBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8425398786886050254L;

	/**
	 * id字段
	 */
	@Id
	@Column(name = "do_id")
	@GenericGenerator(name = "hibernate.id", strategy = "identity")
	@GeneratedValue(generator = "hibernate.id")
	private int id;

	/**
	 * 管理员名字
	 */
	@Column(name = "do_name", length = 20)
	private String admName;

	/**
	 * 管理员登录账号
	 */
	@Column(name = "do_loginname", length = 20)
	private String loginName;

	/**
	 * 操作的模块
	 */
	@Column(name = "do_place")
	private String place;

	/**
	 * 登陆地IP
	 */
	@Column(name = "do_ip", length = 20)
	private String IP;

	/**
	 * 操作了哪些数据
	 */
	@Column(name = "do_data")
	private String data;

	/**
	 * 操作的行为
	 */
	@Column(name = "do_action")
	private String action;
	/**
	 * 操作的时间
	 */
	@Column(name = "do_time")
	private Date time;

	public DoLogBean() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdmName() {
		return admName;
	}

	public void setAdmName(String admName) {
		this.admName = admName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "DoLogBean [id=" + id + ", admName=" + admName + ", loginName=" + loginName + ", place=" + place
				+ ", IP=" + IP + ", data=" + data + ", action=" + action + ", time=" + time + "]";
	}

}
