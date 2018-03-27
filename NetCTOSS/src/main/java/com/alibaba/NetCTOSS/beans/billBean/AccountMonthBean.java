package com.alibaba.NetCTOSS.beans.billBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 月账务账单
 * @author Administrator
 *
 */
@Entity
@javax.persistence.Table(name="t_account_month")
public class AccountMonthBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4547165184573338835L;

	@Id
	@Column(name="id")
	@GeneratedValue(generator="cid")//jpa定义  但是少 就要映射hibernate的
	@GenericGenerator(name="cid",strategy="identity")
	 /** @pdOid 46afca0e-2d71-438c-b327-85bc00c4c749  */
	   private int id;
	@Column(name="acc_year")
	   /** @pdOid f4b3f64b-0e9c-458c-8fde-8b3a4242f196 年份 */
	   private int year;
	@Column(name="acc_month")
	   /** @pdOid 2d96482e-3682-44dc-99a4-8bb01ba5fe13 月份*/
	   private int month;
	@Column(name="acc_acc",length=20)
	   /** @pdOid 5f5e3c5a-534d-4f96-aa93-d45e1b185ced 账务账号*/
	   private String account;
	@Column(name="acc_name",length=20)
	   /** @pdOid 3a3bfd74-958a-465a-8eba-8f2ea25e2cf6 真实名字 */
	   private String name;
	@Column(name="acc_server",length=15)
	   /** @pdOid 3497a8ef-16b4-49a6-9eda-be4951de26e1 服务器IP */
	   private String server;
	@Column(name="acc_os_account",length=20)
	   /** @pdOid 9ae7ba51-cfdc-408b-9c6b-f507df23a53b os账户*/
	   private String oSAccount;
	@Column(name="acc_all_time")
	   /** @pdOid e3e7d75b-e713-480a-989a-299002b2a7a8 总用时长*/
	   private int timeLong;
	   
	   public AccountMonthBean() {
		// TODO Auto-generated constructor stub
	}
	   
	   
	   @Override
	public String toString() {
		return "AccountMonthBean [id=" + id + ", year=" + year + ", month=" + month + ", account=" + account + ", name="
				+ name + ", server=" + server + ", oSAccount=" + oSAccount + ", timeLong=" + timeLong + "]";
	}


	/** @pdOid ee1fd458-e98a-4537-a8c5-80dd96c0323a */
	   public int getId() {
	      return id;
	   }
	   
	   /** @param newId
	    * @pdOid 5ed5c57c-f5ee-4ee5-88bf-5a7e3ec3ad5c */
	   public void setId(int newId) {
	      id = newId;
	   }
	   
	   /** @pdOid 8bf8ccbf-9628-4cb2-a451-681c2f153e12 */
	   public int getYear() {
	      return year;
	   }
	   
	   /** @param newYear
	    * @pdOid 0624a46c-c289-4e10-8f4a-64f3df5ba415 */
	   public void setYear(int newYear) {
	      year = newYear;
	   }
	   
	   /** @pdOid 85d5452f-954f-40ca-8a1f-d7d45b3f9098 */
	   public int getMonth() {
	      return month;
	   }
	   
	   /** @param newMonth
	    * @pdOid 2946f5ec-2d4b-4fd0-9592-59c806f44d12 */
	   public void setMonth(int newMonth) {
	      month = newMonth;
	   }
	   
	   /** @pdOid a99277e5-d7cd-4885-9ca2-0bc30cd18443 */
	   public String getAccount() {
	      return account;
	   }
	   
	   /** @param newAccount
	    * @pdOid 20ff0088-80b6-498b-82d3-43a96724041b */
	   public void setAccount(String newAccount) {
	      account = newAccount;
	   }
	   
	   /** @pdOid 25cfeb32-4c02-445e-a5e7-d876fa6243ea */
	   public String getName() {
	      return name;
	   }
	   
	   /** @param newName
	    * @pdOid 8fc1157a-4662-42fb-a4ab-9a7fbf6aef5e */
	   public void setName(String newName) {
	      name = newName;
	   }
	   
	   /** @pdOid 09d8a506-2e52-442c-a3e2-29827a02b89f */
	   public String getServer() {
	      return server;
	   }
	   
	   /** @param newServer
	    * @pdOid c176cd69-c41b-474a-8c59-4b1681032694 */
	   public void setServer(String newServer) {
	      server = newServer;
	   }
	   
	   /** @pdOid 17275881-49b8-4560-99ef-4a4f0bc6be00 */
	   public String getOSAccount() {
	      return oSAccount;
	   }
	   
	   /** @param newOSAccount
	    * @pdOid 94343342-9be9-4f8a-b8b2-381b7a36fb16 */
	   public void setOSAccount(String newOSAccount) {
	      oSAccount = newOSAccount;
	   }
	   
	   /** @pdOid 52f5c0da-a580-46a5-acb7-3e4ae5432429 */
	   public int getTimeLong() {
	      return timeLong;
	   }
	   
	   /** @param newTimeLong
	    * @pdOid 01ded96b-30e0-4bfa-865e-98a0817da352 */
	   public void setTimeLong(int newTimeLong) {
	      timeLong = newTimeLong;
	   }

}
