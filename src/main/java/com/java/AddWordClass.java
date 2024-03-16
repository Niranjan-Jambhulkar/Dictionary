package com.java;

import com.SQLConnection.*;

public class AddWordClass {
	SQL sql = new SQL();
	int num=0;
	
	public AddWordClass(String word, String meaning) {
		sql.connect();
		num = sql.insertWord(word, meaning);
		sql.close();
	}
	
	public int status() {
		return num;
	}
}
