package com.java;

import com.SQLConnection.*;

public class SearchClass {
	String meaning = null;
	SQL sql = new SQL();
	public SearchClass (String word) {
		sql.connect();
		meaning = sql.search(word);
		sql.close();
	}
	
	public String status() {
		return meaning;
	}
}
