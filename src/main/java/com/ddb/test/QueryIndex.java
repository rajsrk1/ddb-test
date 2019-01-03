package com.ddb.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.ddb.dao.TwtrSearchActivityIndex;

public class QueryIndex {
	
private AmazonDynamoDB ddb;
	
	public QueryIndex(AmazonDynamoDB  ddb) {
		this.ddb = ddb;
	}
	
	public void queryIndex() {
		
		DynamoDBMapper mapper = new DynamoDBMapper(ddb);
		
		
		Map<String,AttributeValue> attrValues = new HashMap<String,AttributeValue>();
		attrValues.put(":v1", new AttributeValue().withS("Data-Collection"));
		
		/*DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
				.withIndexName("TwtrSearch_Activity_GSI")
				.withConsistentRead(false)
				.withFilterExpression("lastStatus = :v1")				
				.withExpressionAttributeValues(attrValues);*/
		
		DynamoDBQueryExpression<TwtrSearchActivityIndex> queryExpression = new DynamoDBQueryExpression<TwtrSearchActivityIndex>()
				.withIndexName("TwtrSearch_Activity_GSI")
				.withConsistentRead(false)
				.withKeyConditionExpression("lastStatus1 = :v1")				
				.withExpressionAttributeValues(attrValues);
		
		List<TwtrSearchActivityIndex> itemList = mapper.query(TwtrSearchActivityIndex.class, queryExpression);
		//List<TwtrSearchActivityIndex> itemList = mapper.scan(TwtrSearchActivityIndex.class, scanExpression);
		
		
		
		for (int i = 0; i < itemList.size(); i++) {
		    System.out.println(itemList.get(i).toString());	
		    Date reqTS = itemList.get(i).getLastActyTS();
		    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		    System.out.println(df.format(reqTS));
		}
		
	}
	
	
}
