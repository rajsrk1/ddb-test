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
		item.setSearchKey("key3");
		item.setReqUsr("user3");
		item.setSearchType("htg");
		item.setAvailable(false);
		item.setLastStatus1("Data-Collection");
		item.setLastStatus2("Failed");
		item.setLastActyTS(new Date());
		item.setLastDesc("API Timed Out");
		item.setLastPrcsName("Driver");
		
		ActivityItem actyItem = new ActivityItem();
		actyItem.setStatus1("Data-Collection");
		actyItem.setStatus2("Failed");
		actyItem.setActyTS(new Date());
		actyItem.setDesc("API Timed Out");
		actyItem.setPrcsName("Driver");
		
		List<ActivityItem> actyList = new ArrayList<ActivityItem>();
		actyList.add(actyItem);
		
		item.setActivity(actyList);
		
		mapper.save(item);
		
		System.out.println("Put item completed.");
		
	}
	
	
	
}
