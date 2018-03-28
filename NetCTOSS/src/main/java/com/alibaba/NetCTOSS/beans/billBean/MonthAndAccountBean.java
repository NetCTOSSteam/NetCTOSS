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
		private int id;
		
		//账务账号 account_acc
		@Column(name="account_acc",length=20)
		private String account;
		
		//真实姓名 account_name
		@Column(name="account_name",length=20)
		private String name;
		
		//年 字段     year
		@Column(name="account_year")
		private int year;
		
		//月字段  moth
		@Column(name="account_month")
		private int month;
		
		//  费用
		@Column(name="account_money")
		private double money;
		
		//支付方式
		@Column(name="account_type",length=10)
		private String type;
		
		//支付状态      0 未支付     1 已支付
		@Column(name="account_status")
		private int status;
		
		public MonthAndAccountBean() {
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
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

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public int getMonth() {
			return month;
		}

		public void setMonth(int month) {
			this.month = month;
		}

		public double getMoney() {
			return money;
		}

		public void setMoney(double money) {
			this.money = money;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "MonthAndBusinessBean [id=" + id + ", account=" + account + ", name=" + name + ", year=" + year
					+ ", month=" + month + ", money=" + money + ", type=" + type + ", status=" + status + "]";
		}
}
