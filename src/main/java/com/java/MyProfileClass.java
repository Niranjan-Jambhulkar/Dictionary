package com.java;

import com.SQLConnection.*;

public class MyProfileClass {
	SQL sql = new SQL();
	static String firstName = null, lastName = null, eMail = null, pass = null;
	
	public MyProfileClass(String user) {
		sql.connect();
		sql.myProfile(user);
		sql.close();
	}
	
	public MyProfileClass(String fname, String lname, String email, String pass) {
		firstName = fname;
		lastName = lname;
		eMail = email;
		this.pass = pass;
	}
	
	public String getfname() {
		return firstName;
	}
	
	public String getlname() {
		return lastName;
	}
	
	public String getemail() {
		return eMail;
	}
	
	public String getpass() {
		return pass;
	}
	
	public static void main(String[] args) {
		MyProfileClass mp = new MyProfileClass("Niru");
		String fname = mp.getfname();
		String lname = mp.getlname();
		String email = mp.getemail();
		System.out.println(fname + lname + email);
	}

}
