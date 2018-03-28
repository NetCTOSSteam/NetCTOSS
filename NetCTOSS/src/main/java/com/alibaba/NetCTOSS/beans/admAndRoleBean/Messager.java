package com.alibaba.NetCTOSS.beans.admAndRoleBean;

public class Messager {

	private int status;
	private String information;
	public Messager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Messager(int status, String information) {
		super();
		this.status = status;
		this.information = information;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	@Override
	public String toString() {
		return "Messager [status=" + status + ", information=" + information + "]";
	}
}