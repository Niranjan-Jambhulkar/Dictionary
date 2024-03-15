package com.java;
import com.SQLConnection.*;

public class LoginCheck {
	int a=0;
	SQL sql = new SQL();
	
	public LoginCheck(String user, String pass) {
		sql.connect();
		a = sql.login(user, pass);
		sql.close();
	}
	
	public int status() {
		if(a==1) {
			System.out.println("Login Successfully Done!");
		}
		else {
			System.out.println("Invalid User or Password!");
		}
		return a;
	}

}
