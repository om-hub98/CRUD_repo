package com.omraj.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static Connection conn=null;
	public static Connection  getConnection() throws ClassNotFoundException, SQLException {
		try {
			 String url="jdbc:mysql://localhost:3306/studentmanagementdb";
			 String userName="root";
			 String password="omraj";
		 	 Class.forName("com.mysql.cj.jdbc.Driver");
			 conn=DriverManager.getConnection(url,userName,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		 return conn;
	}
		

}
