package com.ibm;

import java.sql.*;
// An demo of how to insert the values  into the table using java into mysql
public class FirstDemo {
	public static void main(String[] args) throws SQLException {
		
		String username="root";
		String password="1234";
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("Creating the connection");
			//creating the connection
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_examples",username,password);
			// creating an statement
			PreparedStatement pst=con.prepareStatement("insert into emp values(?,?,?)");
			
			//inserting the values
			pst.setInt(1, 102);
			pst.setString(2, "sSandeep");
			pst.setString(3, "120000");
			//executing the statement
			pst.executeUpdate();
			
			System.out.println("Inserted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			con.close();//closing the connection
		}
	}

}
