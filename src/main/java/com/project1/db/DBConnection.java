package com.project1.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection con;
	  
	public static Connection getConnection() {
		
		try {
			if(con==null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1?useSSL=false","root","arunava");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}

}
