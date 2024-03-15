package com.SQLConnection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import oracle.jdbc.datasource.impl.OracleDataSource;

public class SQL {
	static Connection conn = null;
	static Statement s = null;
	static OracleDataSource ds = null;
	
	public void connect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			FileReader fr = new FileReader("E:\\Web Application\\src\\main\\java\\com\\SQLConnection\\ConnectionDetails.properties");
			Properties p = new Properties();
			p.load(fr);
			String user = p.getProperty("user");
			String pass = p.getProperty("password");
			String path = p.getProperty("path");
			
			// We will not use Driver Manager to connect
			// Using Data Source
			ds = new OracleDataSource();
			ds.setURL(path);
			ds.setUser(user);
			ds.setPassword(pass);
			
			conn = ds.getConnection();
			System.out.println("Connected to DataBase!");
			s = conn.createStatement();
		} 
		
		catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void close() {
		try {
			conn.close();
			System.out.println("Connection closed!");
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(String fname, String lname, String email, String user, String pass) {
		int num = 0;
		try {
			PreparedStatement ps  = conn.prepareStatement("insert into Audience values (?,?,?,?,?)");
			ps.setString(1,fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, user);
			ps.setString(5, pass);
			num = ps.executeUpdate();
			System.out.println(num + " Row Inserted!");
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
