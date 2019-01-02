package com.ddb.test;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.DescribeTableRequest;
import software.amazon.awssdk.services.dynamodb.model.DescribeTableResponse;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

public class DescribeTable {
	
	private DynamoDbClient ddb;
	
	public DescribeTable(DynamoDbClient ddb) {
		this.ddb = ddb;
	}
	
	public void describeTable(String tableName) {
		
		DescribeTableRequest request = DescribeTableRequest.builder()
				.tableName(tableName)
				.build();
		
		try {
			//DynamoDbClient ddb = DynamoDbClient.builder().endpointOverride(new URI("http://localhost:8000")).build();
		    //CreateTableResponse response = ddb.createTable(request);
			DescribeTableResponse response = ddb.describeTable(request);			
		    System.out.println(response.table());
		} catch (DynamoDbException e) {
		    System.err.println(e.getMessage());
		    System.exit(1);
		} 
		
	}

}
