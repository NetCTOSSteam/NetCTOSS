package com.alibaba.NetCTOSS.beans.admAndRoleBean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 权限对象
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name="t_power")
public class PowerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2861220059193128114L;
	
	@Id
	@Column(name="power_id")
	@GeneratedValue(generator="hibernate.id")
	@GenericGenerator(name="hibernate.id",strategy="identity")
	private int id;
	
	@Column(name="power_name")
	private String powerName;//权限名称
	
	@Column(name="power_describe")
	private String describe;//权限描述
	
	@Column(name="power_bo")
	private int status;//状态是否可用
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="powers")
	@Cascade(CascadeType.ALL)
	private List<RoleBean> roles;//一种权限对应多种角色
	
	public PowerBean() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPowerName() {
		return powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<RoleBean> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleBean> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "PowerBean [id=" + id + ", powerName=" + powerName + ", describe=" + describe + ", status=" + status+ "]";
	}
}
