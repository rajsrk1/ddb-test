package com.ddb.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.ddb.dao.TwtrSearchItem;

public class GetItem {
	
	private AmazonDynamoDB ddb;
	
	public GetItem(AmazonDynamoDB  ddb) {
		this.ddb = ddb;
	}
	
	public void getItem() {
		
		DynamoDBMapper mapper = new DynamoDBMapper(ddb);
		
		Map<String,String> attrNames = new HashMap<String,String>();
		attrNames.put("#searchKey", "searchKey");
		
		Map<String,AttributeValue> attrValues = new HashMap<String,AttributeValue>();
		attrValues.put(":val", new AttributeValue().withS("key1"));
		
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
				.withFilterExpression("#searchKey = :val")
				.withExpressionAttributeNames(attrNames)
				.withExpressionAttributeValues(attrValues);
		
		List<TwtrSearchItem> itemList = mapper.scan(TwtrSearchItem.class, scanExpression);
		
		
		
		for (int i = 0; i < itemList.size(); i++) {
		    System.out.println(itemList.get(i).toString());		    
		}
		
	}
	
	
}
