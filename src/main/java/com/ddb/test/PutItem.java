package com.ddb.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.ddb.dao.ActivityItem;
import com.ddb.dao.TwtrSearchItem;


public class PutItem {
	
	private AmazonDynamoDB ddb;
	
	public PutItem(AmazonDynamoDB  ddb) {
		this.ddb = ddb;
	}
	
	
	public void putItem() {

		DynamoDBMapper mapper = new DynamoDBMapper(ddb);
		
		TwtrSearchItem item = new TwtrSearchItem();
		item.setReqTS(new Date());
		item.setSearchKey("key1");
		item.setReqUsr("user1");
		item.setSearchType("htg");
		item.setAvailable(false);
		item.setLastStatus("Initiated#Pending-Processing");
		item.setLastActyTS(new Date());
		item.setLastDesc("Search initiated");
		item.setLastPrcsName("Driver");
		
		ActivityItem actyItem = new ActivityItem();
		actyItem.setStatus("Initiated#Pending-Processing");
		actyItem.setActyTS(new Date());
		actyItem.setDesc("Search initiated");
		actyItem.setPrcsName("Driver");
		
		List<ActivityItem> actyList = new ArrayList<ActivityItem>();
		actyList.add(actyItem);
		
		//item.setActivity(actyList);
		
		mapper.save(item);
		
		System.out.println("Put item completed.");
		
	}
	
	
	
}
