package com.ibm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatePrepared {

	public static void main(String[] args) throws SQLException {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/jdbc_examples";
		String username="root";
		String password="1234";
		
		try {
			Class.forName(driver);
			
			Connection con=DriverManager.getConnection(url,username,password);
			
			PreparedStatement pst=con.prepareStatement("update emp set name=? where id=?");
			
			pst.setString(1, "Suraj");
			pst.setInt(2, 102);
			
			int i=pst.executeUpdate();
			System.out.println(i+"records updated");
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
