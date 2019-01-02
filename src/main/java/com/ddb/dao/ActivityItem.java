package com.ddb.dao;

import java.util.Date;

public class ActivityItem {
	
	private Date actyTS;
	private String desc;
	private String prcsName;
	private String status;
	
	public Date getActyTS() {
		return actyTS;
	}
	public void setActyTS(Date actyTS) {
		this.actyTS = actyTS;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getPrcsName() {
		return prcsName;
	}
	public void setPrcsName(String prcsName) {
		this.prcsName = prcsName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
