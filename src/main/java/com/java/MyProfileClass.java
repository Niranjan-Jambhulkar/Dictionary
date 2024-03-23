package com.java;

import com.SQLConnection.*;

public class MyProfileClass {
	SQL sql = new SQL();
	String firstName = null, lastName = null, eMail = null;
	
	public MyProfileClass(String user) {
		sql.connect();
		sql.myProfile(user);
		sql.close();
	}
	
	public MyProfileClass(String fname, String lname, String email) {
		firstName = fname;
		lastName = lname;
		eMail = email;
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
	
	public static void main(String[] args) {
		MyProfileClass mp = new MyProfileClass("Niru");
		String fname = mp.getfname();
		String lname = mp.getlname();
		String email = mp.getemail();
		System.out.println(fname + lname + email);
	}

}
