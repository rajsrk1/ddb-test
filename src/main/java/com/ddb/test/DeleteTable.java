package com.ddb.test;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.DeleteTableRequest;
import software.amazon.awssdk.services.dynamodb.model.DeleteTableResponse;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.ListTablesRequest;
import software.amazon.awssdk.services.dynamodb.model.ListTablesResponse;

public class DeleteTable {
	
	private DynamoDbClient ddb;
	
	public DeleteTable(DynamoDbClient ddb) {
		this.ddb = ddb;
	}
	
	
	public void deleteTable() {
		
		DeleteTableRequest request = DeleteTableRequest.builder()
				.tableName("TwtrSearchItems")
				.build();
		
		try {
			//DynamoDbClient ddb = DynamoDbClient.builder().endpointOverride(new URI("http://localhost:8000")).build();
		    DeleteTableResponse response = ddb.deleteTable(request);
		    System.out.println(response.toString());
		    
		    System.out.println("Listing tables after delete");
		    System.out.println (ddb.listTables().toString()); 
		    
		    
		    
		} catch (DynamoDbException e) {
		    System.err.println(e.getMessage());
		    System.exit(1);
		} 
		
	}
	
}
