package org.mit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FirstJdbc {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
	Scanner s = new Scanner(System.in);
	System.out.println("Enter employee id");
	int id=s.nextInt();
	System.out.println("Enter Employee Name");
	String name = s.next();
	Connection con =DriverManager.getConnection("jdbc:mysql://172.20.35.20:3306/test1","myuser","mypass");
	PreparedStatement stat1 = con.prepareStatement("INSERT INTO employee VALUES(?,?)");
	stat1.setInt(1, id);
	stat1.setString(2, name);
	stat1.executeUpdate();
	Statement stat2 = con.createStatement();
	ResultSet result = stat2.executeQuery("SELECT * FROM employee");
	while(result.next()){
		System.out.print(result.getInt("id"));
		System.out.print("\t");
		System.out.println(result.getString("name"));
	}
	result.close();
	con.close();
	System.out.println("Database Updated");
	s.close();
	}

}
