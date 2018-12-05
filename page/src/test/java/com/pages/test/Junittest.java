package com.pages.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Junittest {

	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(Juintsuite.class);
		for(Failure fail : result.getFailures()) {
			System.out.println(fail.toString());
		}
		
	     System.out.println("Sucessfull"   +      result.wasSuccessful());	
}
	}
