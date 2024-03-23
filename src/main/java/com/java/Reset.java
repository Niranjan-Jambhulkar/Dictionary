package com.java;

import com.SQLConnection.*;

public class Reset {
	SQL sql = new SQL();
	int result = 0;
	public Reset(String mail, String pass) {
		sql.connect();
		result = sql.PasswordReset(mail, pass);
		sql.close();
	}
	
	public int status() {
		return result;
	}
}
