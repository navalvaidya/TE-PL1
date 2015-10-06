package com.mit;
import com.mongodb.*;
public class TestMongoConnect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			MongoClient client = new MongoClient("localhost",27017);
			DB db=client.getDB("test");
			System.out.println("Connection to DB successful");
			DBCollection col = db.getCollection("student");
			System.out.println("Collection student selected successfully");
			BasicDBObject doc = new BasicDBObject("Name","Malay").
					append("Subject", "pl1").
					append("college", "MIT").
					append("Branch", "computer");
			BasicDBObject documentDetail = new BasicDBObject();
			documentDetail.put("user","user1" );
			documentDetail.put("message", "good");
			documentDetail.put("Datecreated","new Date(2011,1,20,2,15)");
			doc.append("comments",documentDetail );
			col.insert(doc);
			System.out.println("Document Inserted");
			
			DBCursor cursor = col.find();
			
			while(cursor.hasNext()){
				
				System.out.println(cursor.next());
				
			}
			
			
		}catch(MongoException e){
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
