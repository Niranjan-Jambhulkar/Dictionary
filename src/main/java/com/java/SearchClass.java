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
		if(meaning != null) {
			System.out.println("Word Found");
		}
		else {
			System.out.println("Word not Found");
		}
		return meaning;
	}
}
