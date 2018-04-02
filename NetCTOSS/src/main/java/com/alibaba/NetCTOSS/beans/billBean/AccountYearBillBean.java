package com.alibaba.NetCTOSS.beans.billBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 年账务账单
 * @author Administrator
 *
 */
@Entity
@javax.persistence.Table(name="t_account_year")
public class AccountYearBillBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9115890623538400880L;

	@Id
	@Column(name="id")
	@GeneratedValue(generator="cid")//jpa定义  但是少 就要映射hibernate的
	@GenericGenerator(name="cid",strategy="identity")
	 /** @pdOid 4ae01613-3863-4cfb-8f14-a7e80deb35f0 */
	   private int id;
	@Column(name="acc_year")
	   /** @pdOid 020ad182-4673-4558-b602-8b379fd36791 年份*/
	   private int year;
	@Column(name="acc_acc",length=20)
	   /** @pdOid 631489d8-841e-4a7b-b062-1a1d85b0899b 账务账户*/
	   private String account;
	@Column(name="acc_name",length=20)
	   /** @pdOid 8bebfe93-d087-446f-9c5e-b7642e94f029 名字*/
	   private String name;
	@Column(name="acc_numbers")
	   /** @pdOid da954cc4-a718-4c7b-957f-c7e156e3250f 业务账户个数*/
	   private int busNum;
	@Column(name="acc_all_time")
	   /** @pdOid b7716cec-c5d2-43e5-b390-b3f5b0878e33 总用时*/
	   private int timeLong;
	   
	   /** @pdOid 6b41c847-c1dc-4ad8-8b1c-b4b3d10091bb */
	   public int getId() {
	      return id;
	   }
	   
	   /** @param newId
	    * @pdOid b566e3cc-70d7-4b3a-9c93-507cfdddc343 */
	   public void setId(int newId) {
	      id = newId;
	   }
	   
	   /** @pdOid 48cd8898-4cf4-4572-b022-1d8085970577 */
	   public int getYear() {
	      return year;
	   }
	   
	   /** @param newYear
	    * @pdOid 2c425a79-d04f-4891-ac70-140bcae89e7f */
	   public void setYear(int newYear) {
	      year = newYear;
	   }
	   
	   /** @pdOid 652271a2-5b13-48fe-985b-624f75ea78cf */
	   public String getAccount() {
	      return account;
	   }
	   
	   /** @param newAccount
	    * @pdOid 5625d5e3-845f-4093-9132-94b2574f0637 */
	   public void setAccount(String newAccount) {
	      account = newAccount;
	   }
	   
	   /** @pdOid c3802820-fd06-4226-9c32-455bc0f97651 */
	   public String getName() {
	      return name;
	   }
	   
	   /** @param newName
	    * @pdOid d67679cd-2f6e-48f2-b496-48defb9284b9 */
	   public void setName(String newName) {
	      name = newName;
	   }
	   
	   /** @pdOid a88cc7d0-5359-44cf-944f-3c94eb43940a */
	   public int getBusNum() {
	      return busNum;
	   }
	   
	   /** @param newBusNum
	    * @pdOid 1fb7f123-8ef7-4125-a8db-4133b5c9576b */
	   public void setBusNum(int newBusNum) {
	      busNum = newBusNum;
	   }
	   
	   /** @pdOid 789dadbf-5c9c-4f90-b352-6537cb81a6d1 */
	   public int getTimeLong() {
	      return timeLong;
	   }
	   
	   /** @param newTimeLong
	    * @pdOid f751123e-87e4-4649-a641-02d8e6bf9401 */
	   public void setTimeLong(int newTimeLong) {
	      timeLong = newTimeLong;
	   }

	@Override
	public String toString() {
		return "AccountYearBillBean [id=" + id + ", year=" + year + ", account=" + account + ", name=" + name
				+ ", busNum=" + busNum + ", timeLong=" + timeLong + "]";
	}
}
