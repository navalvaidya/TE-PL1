package org.mit;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MenuOperations {
	public static void main(String[] args) throws Exception{
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","naval.2402");
		int choice;
		Scanner s = new Scanner(System.in);
		do{
		System.out.println("1.Insert Entry\n2.Update Entry\n3.Delete Entry\n4.Display\n5.Search\n6.Exit");
	    choice=s.nextInt();
		switch(choice){
		case 1:
			System.out.println("Enter employee id");
			int id=s.nextInt();
			System.out.println("Enter Employee Name");
			String name = s.next();
			PreparedStatement stat1 = con.prepareStatement("INSERT INTO employee VALUES(?,?)");
			stat1.setInt(1, id);
			stat1.setString(2, name);
			stat1.executeUpdate();
			System.out.println("Entry Inserted");
			break;
		case 2:
			System.out.println("Enter employee id");
			int uid=s.nextInt();
			System.out.println("Enter the Updated Name");
			String uname=s.next();
			PreparedStatement stat3 = con.prepareStatement("UPDATE employee SET name=? WHERE id=?");
			stat3.setString(1,uname);
			stat3.setInt(2, uid);
			stat3.executeUpdate();
			System.out.println("Entry Updated");
			break;
		case 3:
			System.out.println("Enter employee id Whose entry is to be deleted");
			int did=s.nextInt();
			PreparedStatement stat4 = con.prepareStatement("DELETE FROM employee WHERE id=?");
			stat4.setInt(1, did);
			stat4.executeUpdate();
			System.out.println("Entry Deleted");
			break;
		case 4:
			Statement stat2 = con.createStatement();
			ResultSet result = stat2.executeQuery("SELECT * FROM employee");
			while(result.next()){
				System.out.print(result.getInt("id"));
				System.out.print("\t");
				System.out.println(result.getString("name"));
			}
			result.close();
			break;
		case 5:
			System.out.println("Enter EmployeeId to Search");
			int SearchId=s.nextInt();
			String sql="{call getEmpName(?,?)}";
			CallableStatement callst= con.prepareCall(sql);
			callst.setInt(1, SearchId);
			callst.registerOutParameter(2, java.sql.Types.VARCHAR);	
			callst.execute();
			String Name=callst.getString(2);
			System.out.println("ID: "+SearchId+" Name: "+Name);	
			break;

		
		}
		}while(choice!=6);
		s.close();
	}
}
