package com.SQLConnection;

import com.java.*;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			PreparedStatement ps  = conn.prepareStatement("insert into accounts values (?,?,?,?,?)");
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
	
	public int login(String user, String pass) {
		String u = null ,p = null;
		int a=0;
		try {
			PreparedStatement ps = conn.prepareStatement("select user_name, user_password from accounts where user_name = ? and user_password = ? ");
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = rs.getString(1);
				p = rs.getString(2);
			}
			if(user.equals(u) && pass.equals(p)) {
				a=1;
				System.out.println("Authorised");
			}
			else {
				a=0;
				System.out.println("Unauthorized");
			}
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public int insertWord(String word, String meaning) {
		int num =0;
		try {
			PreparedStatement ps = conn.prepareStatement("insert into mydictionary values(?,?)");
			ps.setString(1, word);
			ps.setString(2, meaning);
			num = ps.executeUpdate();
			System.out.println(num +" Row Inserted");
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public String search(String word) {
		String meaning = null;
		try {
			PreparedStatement ps =  conn.prepareStatement("select meaning from mydictionary where word=?");
			ps.setString(1, word);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				meaning = rs.getString(1);
			}
			if(meaning != null) {
				System.out.println("Word Found");
			}
			else {
				System.out.println("Word not Found");
				meaning = "Word not Found";
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return meaning;
	}
	
	public int EmailCheck(String mail) {
		int result = 0;
		String email = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select email from accounts where email=?");
			ps.setString(1, mail);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				email = rs.getString(1);
			}
			if(mail.equals(email)) {
				System.out.println("Account Found");
				result ++;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int PasswordReset(String mail, String pass) {
		int result =0;
		try {
			PreparedStatement ps = conn.prepareStatement("update accounts set user_password = ? where email = ?");
			ps.setString(1,pass);
			ps.setString(2, mail);
			result = ps.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void myProfile(String user) {
		String fname = null, lname = null, email = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select first_name, last_name, email from accounts where user_name = ?");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				fname = rs.getString(1);
				lname = rs.getString(2);
				email = rs.getString(3);
			}
			MyProfileClass mp = new MyProfileClass(fname,lname,email);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
