package com.java;

import com.SQLConnection.SQL;

public class Change {
	SQL sql = new SQL();
	public Change(String fname, String lname, String email, String password, String user) {
		sql.connect();
		sql.updateProfile(fname, lname, email, password, user);
		sql.close();
	}
}
