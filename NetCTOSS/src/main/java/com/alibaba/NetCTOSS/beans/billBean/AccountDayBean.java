package com.alibaba.NetCTOSS.beans.billBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 日账务账单
 * @author Administrator
 *
 */
@Entity
@javax.persistence.Table(name="t_account_day")
public class AccountDayBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7549050970354732825L;

	 /** @pdOid  类id */
	@Id
	@Column(name="id")
	@GeneratedValue(generator="cid")//jpa定义  但是少 就要映射hibernate的
	@GenericGenerator(name="cid",strategy="identity")
	   private int id;
	
	   /** @pdOid 年份 */
	@Column(name="acc_year")
	   private int year;
	
	@Column(name="acc_month")
	   /** @pdOid 1fa3582e-0d3f-4c98-9078-491ef024cb97 月份 */
	   private int month;
	
	@Column(name="acc_day")
	   /** @pdOid a5e9fa1b-c943-4a8a-8bad-3a455bc299cf 日 */
	   private int day;
	
	@Column(name="acc_acc",length=20)
	   /** @pdOid 21c125c8-a9b8-422d-814f-ca949a44c5e1 账务账号名 */
	   private String account;
	   
	   @Column(name="acc_name",length=20)
	   /** @pdOid ebaf44f4-09f8-4b31-911a-aa9fdd10ac83 真实姓名 */
	   private String name;
	   
	   @Column(name="acc_server",length=15)
	   /** @pdOid 5d1c4bcf-4746-4c81-a2f5-30c3b1d1ffba 服务器IP*/
	   private String server;
	   
	   @Column(name="acc_os_account",length=20)
	   /** @pdOid 56889872-0f65-4784-b3e2-bb308a8ca2a9 os账户名 */
	   private String OSAccount;
	   
	   @Column(name="acc_all_time")
	   /** @pdOid 063a5405-cf72-4175-b7c8-d2d756bd51e0 总用时 */
	   private int timeLong;
	   
	   public AccountDayBean() {
		// TODO Auto-generated constructor stub
	}
	   
	   @Override
	public String toString() {
		return "AccountDayBean [id=" + id + ", year=" + year + ", month=" + month + ", day=" + day + ", account="
				+ account + ", name=" + name + ", server=" + server + ", OSAccount=" + OSAccount + ", timeLong="
				+ timeLong + "]";
	}

	/** @pdOid c6d56b40-87cf-409d-8d2b-ebb6ce24f21b */
	   public int getId() {
	      return id;
	   }
	   
	   /** @param newId
	    * @pdOid e892ee0f-d182-4c7a-874b-716beced35db */
	   public void setId(int newId) {
	      id = newId;
	   }
	   
	   /** @pdOid 571c754f-c2ed-42bd-9814-f5f89029061f */
	   public int getYear() {
	      return year;
	   }
	   
	   /** @param newYear
	    * @pdOid 5ac6e43c-4a4c-4b1b-88ec-6fb87b9aa42f */
	   public void setYear(int newYear) {
	      year = newYear;
	   }
	   
	   /** @pdOid 7ccbc820-bc2a-4a6b-8a3f-d6c73241273f */
	   public int getMonth() {
	      return month;
	   }
	   
	   /** @param newMonth
	    * @pdOid eec9c515-132d-4776-b29f-c6b52fe7c595 */
	   public void setMonth(int newMonth) {
	      month = newMonth;
	   }
	   
	   /** @pdOid fd7c3773-aa79-42ea-8a9a-32686e020a27 */
	   public int getDay() {
	      return day;
	   }
	   
	   /** @param newDay
	    * @pdOid 3cab955d-6314-4e0d-b2b4-23388213d942 */
	   public void setDay(int newDay) {
	      day = newDay;
	   }
	   
	   /** @pdOid 3624faea-e5f3-42c6-99e7-6e3a398939d3 */
	   public String getAccount() {
	      return account;
	   }
	   
	   /** @param newAccount
	    * @pdOid d26922fe-3463-452d-b15b-959e2b64508c */
	   public void setAccount(String newAccount) {
	      account = newAccount;
	   }
	   
	   /** @pdOid b2b9aa21-b068-49a9-bbe4-41cc15072d57 */
	   public String getName() {
	      return name;
	   }
	   
	   /** @param newName
	    * @pdOid 7cbe769c-d993-43cb-b06b-eb72c2b8cc73 */
	   public void setName(String newName) {
	      name = newName;
	   }
	   
	   /** @pdOid 5a8f58d7-dd2c-4652-af3e-1c25d2d5d695 */
	   public String getServer() {
	      return server;
	   }
	   
	   /** @param newServer
	    * @pdOid 40a88ac6-3290-4ec6-9e65-17c734af0b21 */
	   public void setServer(String newServer) {
	      server = newServer;
	   }
	   
	   /** @pdOid 3f2943fd-e569-43a3-8baf-865e8c267459 */
	   public String getOSAccount() {
	      return OSAccount;
	   }
	   
	   /** @param newOSAccount
	    * @pdOid 4aafbd7a-3ad9-4bd9-8c2f-9d302bd3a39e */
	   public void setOSAccount(String newOSAccount) {
	      OSAccount = newOSAccount;
	   }
	   
	   /** @pdOid 1233f11a-21f4-4124-a974-26b42ba163db */
	   public int getTimeLong() {
	      return timeLong;
	   }
	   
	   /** @param newTimeLong
	    * @pdOid 660977a4-65c4-4faa-a384-b52f20f1207b */
	   public void setTimeLong(int newTimeLong) {
	      timeLong = newTimeLong;
	   }
}
