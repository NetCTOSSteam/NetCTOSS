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
 * 登录 退出 日志
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name="t_login_exit")
public class LoginExitBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -180379080196079371L;

	/**
	 * id字段
	 */
	@Id
	@Column(name="log_id")
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private int id;

	/**
	 * 登录人名字
	 */
	@Column(name="log_name",length=20)
	private String name;

	/**
	 * 登录人账号
	 */
	@Column(name="log_loginname",length=20)
	private String accNumber;

	/**
	 * 登录时间
	 */
	@Column(name="log_logintime")
	private Date loginTime;

	/**
	 * 登录地IP
	 */
	@Column(name="log_ip",length=20)
	private String IP;

	/**
	 * 退出时间
	 */
	@Column(name="log_quittime")
	private Date quitTime;

	public LoginExitBean() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public Date getQuitTime() {
		return quitTime;
	}

	public void setQuitTime(Date quitTime) {
		this.quitTime = quitTime;
	}

	@Override
	public String toString() {
		return "LoginExitBean [id=" + id + ", name=" + name + ", accNumber=" + accNumber + ", loginTime=" + loginTime
				+ ", IP=" + IP + ", quitTime=" + quitTime + "]";
	}

}
