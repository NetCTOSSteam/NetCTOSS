package com.alibaba.NetCTOSS.beans.billBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *  有支付状态的 账务月账单
 * @author Administrator
 *
 */
@Entity
@Table(name="t_month_account")
public class MonthAndAccountBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7281210674315386310L;

		//id 字段      id
		@Id
		@Column(name="id")
		@GeneratedValue(generator="hibernate.id")
		@GenericGenerator(name="hibernate.id",strategy="identity")
		private Integer id;
		
		//账务账号 account_acc
		@Column(name="account_acc",length=20)
		private String account;
		
		//真实姓名 account_name
		@Column(name="account_name",length=20)
		private String name;
		
		//年 字段     year
		@Column(name="account_year")
		private Integer year;
		
		//月字段  moth
		@Column(name="account_month")
		private Integer month;
		
		//  费用
		@Column(name="account_money")
		private Double money;
		
		//支付方式
		@Column(name="account_type",length=10)
		private String type;
		
		//支付状态      0 未支付     1 已支付
		@Column(name="account_status")
		private Integer status;
		
		//身份证         account_IDcard
		@Column(name="account_IDcard",length=20)
		private String IDcard;
		
		public MonthAndAccountBean() {
			// TODO Auto-generated constructor stub
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getAccount() {
			return account;
		}

		public void setAccount(String account) {
			this.account = account;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getYear() {
			return year;
		}

		public void setYear(Integer year) {
			this.year = year;
		}

		public Integer getMonth() {
			return month;
		}

		public void setMonth(Integer month) {
			this.month = month;
		}

		public Double getMoney() {
			return money;
		}

		public void setMoney(Double money) {
			this.money = money;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public String getIDcard() {
			return IDcard;
		}

		public void setIDcard(String iDcard) {
			IDcard = iDcard;
		}

		@Override
		public String toString() {
			return "MonthAndAccountBean [id=" + id + ", account=" + account + ", name=" + name + ", year=" + year
					+ ", month=" + month + ", money=" + money + ", type=" + type + ", status=" + status + ", IDcard="
					+ IDcard + "]";
		}
		
}
