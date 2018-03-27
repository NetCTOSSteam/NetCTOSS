package com.alibaba.NetCTOSS.beans.admAndRoleBean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 角色对象
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name="t_role")
public class RoleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -774922684459312987L;
	@Id
	@Column(name="role_id")
	@GeneratedValue(generator="hibernate.id")
	@GenericGenerator(name="hibernate.id",strategy="identity")
	private int id;
	
	@Column(name="role_name")
	private String roleName;//角色名字
	
	@Column(name="role_type")
	private String type;//角色类型
	
	@Column(name="role_bo")
	private boolean status;//角色状态

	@ManyToMany(fetch=FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	@JoinTable(name="t_role_power",
	joinColumns=@JoinColumn(name="rp_role_id"),
	inverseJoinColumns=@JoinColumn(name="rp_power_id"))
	private Set<PowerBean> powers;//一个角色对应多个权限
	public RoleBean() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Set<PowerBean> getPowers() {
		return powers;
	}

	public void setPowers(Set<PowerBean> powers) {
		this.powers = powers;
	}

	@Override
	public String toString() {
		return "RoleBean [id=" + id + ", roleName=" + roleName + ", type=" + type + ", status=" + status + ", powers="
				+ powers + "]";
	}
}
