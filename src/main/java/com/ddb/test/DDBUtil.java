package com.ddb.test;

import java.net.URI;
import java.net.URISyntaxException;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

/*
 * Compile with -- mvn -s H:\Data\.m2\settings.xml install
 * Run with -- mvn -s H:\Data\.m2\settings.xml exec:java -Dexec.args="get"
 * 
 * 
 */

public class DDBUtil {

	public static void main(String[] args) {
		
		
		if(args.length == 0) {
			System.err.println("No arguments passed. Will exit.");
		    System.exit(1);
		}
			
		String table = "TwtrSearchItems";
		String index1 = "TwtrSearch_Activity_GSI";
		
		try {
			DynamoDbClient newClient = DynamoDbClient.builder().endpointOverride(new URI("http://localhost:8000")).build();
			AmazonDynamoDB oldClient = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
					new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2")).build();
			
			
			
			if(args[0].equals("desc")) {
				new DescribeTable(newClient).describeTable(table);
			}else if(args[0].equals("put")) {
				new PutItem(oldClient).putItem();
			}else if(args[0].equals("get")) {
				new GetItem(oldClient).getItem();
			}
			
			
			
		} catch (DynamoDbException e) {
		    System.err.println(e.getMessage());
		    System.exit(1);
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Done!");

	}

}
