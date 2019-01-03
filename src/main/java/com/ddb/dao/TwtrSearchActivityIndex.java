package com.ddb.dao;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="TwtrSearchItems")
public class TwtrSearchActivityIndex {
	
	private String lastStatus1;
	private String lastStatus2;
	private Date lastActyTS;
	private String searchId;
	private String searchKey;
	private Date reqTS;
	
	@DynamoDBHashKey
	public String getLastStatus1() {
		return lastStatus1;
	}
	public void setLastStatus1(String lastStatus1) {
		this.lastStatus1 = lastStatus1;
	}
	
	@DynamoDBRangeKey
	public String getLastStatus2() {
		return lastStatus2;
	}
	public void setLastStatus2(String lastStatus2) {
		this.lastStatus2 = lastStatus2;
	}
	
	public Date getLastActyTS() {
		return lastActyTS;
	}
	public void setLastActyTS(Date lastActyTS) {
		this.lastActyTS = lastActyTS;
	}
	public String getSearchId() {
		return searchId;
	}
	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public Date getReqTS() {
		return reqTS;
	}
	public void setReqTS(Date reqTS) {
		this.reqTS = reqTS;
	}
	
	@Override
	public String toString() {
		return "TwtrSearchActivityIndex [lastStatus1=" + lastStatus1 + ", lastStatus2=" + lastStatus2 + ", lastActyTS="
				+ lastActyTS + ", searchId=" + searchId + ", searchKey=" + searchKey + ", reqTS=" + reqTS + "]";
	}
	
	
	
	
	

}
