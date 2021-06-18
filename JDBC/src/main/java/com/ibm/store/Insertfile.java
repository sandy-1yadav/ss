package com.ibm.store;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Insertfile {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/jdbc_examples";
		String username="root";
		String password="1234";
		Connection con=null;
		
		Class.forName(driver);
	    
		con=DriverManager.getConnection(url,username,password);
		
		PreparedStatement ps=con.prepareStatement("insert into filedb values(?,?)");
		
		File f=new File("D:\\sandeep\\notes\\Training\\eclipse-workspace2\\JDBC\\src\\main\\resources\\textfile.txt");
		
		FileReader fr=new FileReader(f);
	
		ps.setInt(1, 101);
		ps.setCharacterStream(2, fr,(int)f.length());
		
		int i=ps.executeUpdate();
		System.out.println(i+" records affected");
		//for retirving the file
		
		PreparedStatement pst=con.prepareStatement("select * from filedb");
		
		ResultSet rs=pst.executeQuery();
		rs.next();//now on 1st row
		
		
		Clob c=rs.getClob(2);
		Reader r=c.getCharacterStream();
		//just create a file where the content is to be stored
		FileWriter fw=new FileWriter("D:\\sandeep\\notes\\Training\\eclipse-workspace2\\JDBC\\src\\main\\resources\\retrive.txt");
		
		int j;
		
		while((j=r.read())!=-1) 
			fw.write((char)j);
		fw.close();
		
		
		System.out.println("Success");
		con.close();
	}
	
}
