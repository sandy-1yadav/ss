package com.ibm;

import java.sql.*;

public class JDBC_demo {
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/world";
	String username="root";
	String password="1234";
	Connection con=null;
	
	public static void main(String[] args) throws SQLException {
		JDBC_demo jd=new JDBC_demo();
		jd.getCityInformation();
		
	}
	
	private void getCityInformation() throws SQLException {
		
		Statement stm=null;
		
		try {
			Class.forName(driver);
			
			System.out.println("Connecting to the database");
			con=DriverManager.getConnection(url,username,password);
			
			stm=con.createStatement();
			
			String sql="select ID,Name,CountryCode,District,Population from city where ID<21";
			
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next()) {
				
				int id=rs.getInt("ID");
				String name=rs.getString("Name");
				String countrycode=rs.getString("CountryCode");
				String district=rs.getString("District");
				int population=rs.getInt("Population");
				
				System.out.print(" ID: "+id);
				System.out.print(" Name: "+name);
				System.out.print(" CountryCode: "+countrycode);
				System.out.print(" District: "+district);
				System.out.println(" Population: "+population);
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			con.close();
		}
		
	}

}
