package com.ddb.test;

import java.net.URI;
import java.net.URISyntaxException;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
import software.amazon.awssdk.services.dynamodb.model.CreateTableResponse;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.GlobalSecondaryIndex;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.KeyType;
import software.amazon.awssdk.services.dynamodb.model.Projection;
import software.amazon.awssdk.services.dynamodb.model.ProjectionType;
import software.amazon.awssdk.services.dynamodb.model.ProvisionedThroughput;
import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType;

public class CreateTable {
	
	private DynamoDbClient ddb;
	
	public CreateTable(DynamoDbClient ddb) {
		this.ddb = ddb;
	}
	
	
	public void createTable() {
		
		CreateTableRequest request = CreateTableRequest.builder()
				.attributeDefinitions(AttributeDefinition.builder()
						.attributeName("searchId")
						.attributeType(ScalarAttributeType.S)
						.build(),
						AttributeDefinition.builder()
						.attributeName("reqTS")
						.attributeType(ScalarAttributeType.S)
						.build(),
						AttributeDefinition.builder()
						.attributeName("lastStatus")
						.attributeType(ScalarAttributeType.S)
						.build(),
						AttributeDefinition.builder()
						.attributeName("lastActyTS")
						.attributeType(ScalarAttributeType.S)
						.build())
				.keySchema(KeySchemaElement.builder()
						.attributeName("searchId")
						.keyType(KeyType.HASH)
						.build(),
						KeySchemaElement.builder()
						.attributeName("reqTS")
						.keyType(KeyType.RANGE)
						.build())				
				.globalSecondaryIndexes(GlobalSecondaryIndex.builder()
						.indexName("TwtrSearch_Activity_GSI")
						.keySchema(KeySchemaElement.builder()
								.attributeName("lastStatus")
								.keyType(KeyType.HASH).build(),
								KeySchemaElement.builder()
								.attributeName("lastActyTS")
								.keyType(KeyType.RANGE).build())
						.projection(Projection.builder()
								.nonKeyAttributes("searchId","searchKey","reqTS")
								.projectionType(ProjectionType.INCLUDE)								
								.build())
						.provisionedThroughput(ProvisionedThroughput.builder()
								.readCapacityUnits(new Long(2))
								.writeCapacityUnits(new Long(2))
								.build())
						.build())
				.provisionedThroughput(ProvisionedThroughput.builder()
						.readCapacityUnits(new Long(2))
						.writeCapacityUnits(new Long(2))
						.build())
				.tableName("TwtrSearchItems")
				.build();

		try {
			//DynamoDbClient ddb = DynamoDbClient.builder().endpointOverride(new URI("http://localhost:8000")).build();
		    CreateTableResponse response = ddb.createTable(request);
		    System.out.println(response.tableDescription().tableName());
		} catch (DynamoDbException e) {
		    System.err.println(e.getMessage());
		    System.exit(1);
		} 
		
	}

}
