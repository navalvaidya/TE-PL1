package com.mit;

import java.util.Scanner;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class MongoCRUD {
	public static void main(String[] args) {
		try{
			MongoClient client = new MongoClient("localhost",27017);
			DB db=client.getDB("test");
			System.out.println("Connection to DB successful");
			DBCollection col = db.getCollection("student");
			System.out.println("Collection student selected successfully");
			int ch = 0;
			Scanner s = new Scanner(System.in);
			while(ch!=5){
			System.out.println("1.Insert\n2.Display\n3.Update\n4.Delete\n5.Exit");
			System.out.println("Enter your choice");
				
			ch=s.nextInt();
			
				switch(ch){
				case 1:
					System.out.print("Enter name: ");
					String name = s.next();
					System.out.print("Enter Subject: ");
					String subject = s.next();
					System.out.print("Enter College: ");
					String college = s.next();
					System.out.print("Enter Branch: ");
					String branch = s.next();
					
			BasicDBObject doc = new BasicDBObject("Name",name).
					append("Subject", subject).
					append("college", college).
					append("Branch", branch);
			col.insert(doc);
			break;
				case 2:
					DBCursor cursor = col.find();
					
					while(cursor.hasNext()){
						
						System.out.println(cursor.next());
						
					}
					break;
				case 3:
					System.out.println("Enter the name Whose document is to be updated :");
					String uname = s.next();
					System.out.print("Enter Updated name: ");
					String nuname = s.next();
					System.out.print("Enter Updated Subject: ");
					String usubject = s.next();
					System.out.print("Enter Updated College: ");
					String ucollege = s.next();
					System.out.print("Enter Updated Branch: ");
					String ubranch = s.next();
					BasicDBObject olddoc = new BasicDBObject("Name",uname);
					BasicDBObject updateddoc = new BasicDBObject("Name",nuname).
							append("Subject", usubject).
							append("college", ucollege).
							append("Branch", ubranch);
					col.update(olddoc, updateddoc);
					break;
				case 4:
					System.out.println("Enter the name Whose document is to be deleted :");
					String dname = s.next();
					BasicDBObject doc1 = new BasicDBObject("Name",dname);
					col.remove(doc1);
					break;
				
				}
			}
			s.close();
			
		}catch(MongoException e){
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
		
	}

}
