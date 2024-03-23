package com.java;

import com.SQLConnection.*;

public class Email {
	int result = 0;
	SQL sql = new SQL();
	public Email(String mail) {
		sql.connect();
		result = sql.EmailCheck(mail);
		sql.close();
	}
	
	public int status() {
		return result;
	}
}
