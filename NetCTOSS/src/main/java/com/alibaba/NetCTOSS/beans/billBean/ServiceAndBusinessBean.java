package com.alibaba.NetCTOSS.beans.billBean;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务器明细账单
 * @author Administrator
 *
 */
public class ServiceAndBusinessBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1299667285129539501L;

	//id 
	   private int id; 
	   //OS账户 
	   private String OSAccount; 
	   //服务器IP 
	   private String serverIP; 
	   //开始时间 
	   private Date startTime; 
	   //结束时间 
	   private Date endTime; 
	   //在线时间 
	   private long onlineTimr; 
	   //费用 
	   private double money; 
	   //资费   
	   private String tariff;
	   
	   
	   public ServiceAndBusinessBean() {
		// TODO Auto-generated constructor stub
	}
	   
	   @Override
	public String toString() {
		return "ServiceAndBusinessBean [id=" + id + ", OSAccount=" + OSAccount + ", serverIP=" + serverIP
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", onlineTimr=" + onlineTimr + ", money="
				+ money + ", tariff=" + tariff + "]";
	}

	public double getMoney() {
	      return money;
	   }
	   
	   /** @param newMoney */
	   public void setMoney(double newMoney) {
	      money = newMoney;
	   }
	   
	   public int getId() {
	      return id;
	   }
	   
	   /** @param newId */
	   public void setId(int newId) {
	      id = newId;
	   }
	   
	   public String getOSAccount() {
	      return OSAccount;
	   }
	   
	   /** @param newOSAccount */
	   public void setOSAccount(String newOSAccount) {
	      OSAccount = newOSAccount;
	   }
	   
	   public String getServerIP() {
	      return serverIP;
	   }
	   
	   /** @param newServerIP */
	   public void setServerIP(String newServerIP) {
	      serverIP = newServerIP;
	   }
	   
	   public Date getStartTime() {
	      return startTime;
	   }
	   
	   /** @param newStartTime */
	   public void setStartTime(Date newStartTime) {
	      startTime = newStartTime;
	   }
	   
	   public Date getEndTime() {
	      return endTime;
	   }
	   
	   /** @param newEndTime */
	   public void setEndTime(Date newEndTime) {
	      endTime = newEndTime;
	   }
	   
	   public long getOnlineTimr() {
	      return onlineTimr;
	   }
	   
	   /** @param newOnlineTimr */
	   public void setOnlineTimr(long newOnlineTimr) {
	      onlineTimr = newOnlineTimr;
	   }
	   
	   public String getTariff() {
	      return tariff;
	   }
	   
	   /** @param newTariff */
	   public void setTariff(String newTariff) {
	      tariff = newTariff;
	   }
}
