package com.ddb.dao;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class ActivityItem {
	
	private Date actyTS;
	private String desc;
	private String prcsName;
	private String status1;
	private String status2;
	
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
	public String getStatus1() {
		return status1;
	}
	public void setStatus1(String status1) {
		this.status1 = status1;
	}
	public String getStatus2() {
		return status2;
	}
	public void setStatus2(String status2) {
		this.status2 = status2;
	}
	
	@Override
	public String toString() {
		return "ActivityItem [actyTS=" + actyTS + ", desc=" + desc + ", prcsName=" + prcsName + ", status1=" + status1
				+ ", status2=" + status2 + "]";
	}
	
	
	
	
	

}
