package com.ibm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;


public class Dynamicinsert {

	public static void main(String[] args) throws SQLException, IOException {
		
	
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/jdbc_examples";
	String username="root";
	String password="1234";
	Connection con=null;
	
	try {
		//registring the driver
		Class.forName(driver);
		//Creating the connection
		 con=DriverManager.getConnection(url,username,password);
		
		String insertquery="insert into emp(name,salary) value (?,?)";
		
		PreparedStatement pst=con.prepareStatement(insertquery);
		Scanner scan=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		

		
		
	
	
		
//		System.out.println("Enter name:");
//		String name =scan.nextLine();
//		
//		System.out.println("Enter salary:");
//		String salary=scan.nextLine();
//		
//		
//		pst.setString(1, name);
//		pst.setString(2, salary);
//		
//		pst.executeUpdate();
//		System.out.println("Inserted");
		
		//deletes the record
		
		PreparedStatement pst1=con.prepareStatement("delete from emp where id=?");
		pst1.setInt(1, 104);
		
		int i=pst1.executeUpdate();
		System.out.println(i+" records deleted");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		con.close();
	}
	

	}		
}
