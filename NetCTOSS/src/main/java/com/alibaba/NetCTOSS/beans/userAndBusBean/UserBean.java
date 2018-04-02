package com.alibaba.NetCTOSS.beans.userAndBusBean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 账务账户类
 * @author Administrator
 *
 */

@Entity
@Table(name="t_user",catalog="netctoss")
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2056072704313750420L;
	
	
	/**
	 *  id字段
	 */
	@Id
	@Column(name="u_id")
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private Integer id;
	
	/**
	 * u_name
	 * 账务名字
	 */
	@Column(name="u_name",length=20)
	private String userName;
	
	/**
	 * u_tel
	 * 电话
	 */
	@Column(name="u_tel",length=11)
	private String tel;
	
	/**
	 * id_card
	 * 身份证
	 */
	@Column(name="id_card",length=20)
	private String idCard;
	
	/**
	 * u_gender
	 * 性别
	 */
	@Column(name="u_gender")
	private Integer gender;
	
	/**
	 * u_address
	 * 通讯地址
	 */
	@Column(name="u_address",length=100)
	private String address;
	
	
	/**
	 * u_postcode
	 * 邮编
	 */
	@Column(name="u_postcode")
	private Integer postcode;
	/**
	 * u_qq
	 * QQ号码
	 */
	@Column(name="u_qq",length=15)
	private String qq;
	
	/**
	 * login_name
	 * 账户登陆名
	 */
	@Column(name="login_name",length=20)
	private String loginName;
	
	/**
	 * pass_word
	 * 登陆密码
	 */
	@Column(name="pass_word",length=32)
	private String password;
	
	/**
	 * u_bo
	 * 数据是否有效
	 */
	@Column(name="u_bo")
	private int bo;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="userBean")
	@Cascade(value= {CascadeType.ALL})
	private Set<BusinessBean> BusinessBeans;
	

	public UserBean() {
		// TODO Auto-generated constructor stub
		bo = 1; 
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPostcode() {
		return postcode;
	}

	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
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

	
	public int getBo() {
		return bo;
	}

	public void setBo(int bo) {
		this.bo = bo;
	}
	
	public Set<BusinessBean> getBusinessBeans() {
		return BusinessBeans;
	}

	public void setBusinessBeans(Set<BusinessBean> businessBeans) {
		BusinessBeans = businessBeans;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", userName=" + userName + ", tel=" + tel + ", idCard=" + idCard + ", gender="
				+ gender + ", address=" + address + ", postcode=" + postcode + ", qq=" + qq + ", loginName=" + loginName
				+ ", password=" + password + ", bo=" + bo + ", BusinessBeans=" + BusinessBeans + "]";
	}


}
