package com.omraj.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	public static boolean passwordIsValid(String password) {
		  String regex="^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{3,8}$";
		  
		  Pattern p=Pattern.compile(regex);
		  
		  if(password==null || password.length()>8) {
			  return false;
		  }
		  Matcher m=p.matcher(password);
		  
		  return m.matches();
		
	}
}
