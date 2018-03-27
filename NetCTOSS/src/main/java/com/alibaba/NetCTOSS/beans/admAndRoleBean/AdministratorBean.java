package com.alibaba.NetCTOSS.beans.admAndRoleBean;

import java.io.Serializable;

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
 * 管理员对象
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name="t_adm")
public class AdministratorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1254344458012886917L;
	
	@Id
	@Column(name="adm_id")
	@GeneratedValue(generator="hibernate.id")
	@GenericGenerator(name="hibernate.id",strategy="identity")
	private int id;
	
	@Column(name="adm_name")
	private String adminName;//管理员名字
	
	@Column(name="login_name")
	private String loginName;//管理员登录名
	
	@Column(name="pass_word")
	private String password;//登录密码
	
	@Column(name="adm_tel")
	private String telephone;//联系电话
	
	@Column(name="adm_eml")
	private String email;//联系邮箱
	
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade(value={CascadeType.ALL})
	@JoinColumn(name="adm_role_id")
	private RoleBean role;//所属角色
	
	@Column(name="adm_bo")
	private int status;//数据是否有效
	
	
	public AdministratorBean() {
		// TODO Auto-generated constructor stub
		status = 1 ;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public RoleBean getRole() {
		return role;
	}


	public void setRole(RoleBean role) {
		this.role = role;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "AdministratorBean [id=" + id + ", adminName=" + adminName + ", loginName=" + loginName + ", password="
				+ password + ", telephone=" + telephone + ", email=" + email + ", role=" + role + ", status=" + status
				+ "]";
	}
}
