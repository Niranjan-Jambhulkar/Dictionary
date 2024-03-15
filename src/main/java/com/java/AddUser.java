package com.java;

import com.SQLConnection.SQL;

public class AddUser {
	static SQL sql = new SQL();
	
	public AddUser(String fname, String lname, String email, String user, String pass) {	
		sql.connect();
		sql.insert(fname, lname, email, user, pass);
		sql.close();
	}
}
