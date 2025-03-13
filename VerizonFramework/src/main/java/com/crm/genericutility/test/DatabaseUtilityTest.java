package com.crm.genericutility.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtilityTest {
	Connection conn;
	public void getConnection() {
		try {
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:mysql:/localhost:3306/projects", "root", "root");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void closeConnection() throws SQLException {
		conn.close();
	}
	// execute select query
	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result= null;
		try{
			Statement stat = conn.createStatement();
			 result = stat.executeQuery(query);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;  
	}
	// execute non select query
	public int executeNonSelectQuery(String query) {
		int result=0;
		try {
			Statement stat = conn.createStatement();
			result=stat.executeUpdate(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
		
	}

}
