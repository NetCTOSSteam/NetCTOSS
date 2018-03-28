package com.alibaba.NetCTOSS.beans.billBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * 业务月账单
 * @author Administrator
 *
 */
@Entity
@Table(name="t_month_business")
public class MonthAndBusinessBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6949076759400528622L;

	
	//id 字段
	@Id
	@Column(name="id")
	@GeneratedValue(generator="hibernate.id")
	@GenericGenerator(name="hibernate.id",strategy="identity")
	private int id;
	
	//业务账号    business_account
	@Column(name="business_account")
	private String businessAccount;
	
	//年 字段   business_year
	@Column(name="business_year")
	private int year;
	
	//月 字段   business_month
	@Column(name="business_month")
	private int month;
	
	//总费用   business_all_money
	@Column(name="business_all_money")
	private double money;
	
	//资费套餐   business_tariff
	@Column(name="business_tariff")
	private double tariff;
	
	//服务器信息   business_server_information
	@Column(name="business_server_information")
	private double server;
	
	public MonthAndBusinessBean() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBusinessAccount() {
		return businessAccount;
	}

	public void setBusinessAccount(String businessAccount) {
		this.businessAccount = businessAccount;
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

	public double getTariff() {
		return tariff;
	}

	public void setTariff(double tariff) {
		this.tariff = tariff;
	}

	public double getServer() {
		return server;
	}

	public void setServer(double server) {
		this.server = server;
	}

	@Override
	public String toString() {
		return "MonthAndBusinessBean [id=" + id + ", businessAccount=" + businessAccount + ", year=" + year + ", month="
				+ month + ", money=" + money + ", tariff=" + tariff + ", server=" + server + "]";
	}
	
}
