package com.walkerdigital.toolkit.money.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class CurrencyTestMain {

    public static void main(String[] args) {
    	
    	/*Running test cases programatically*/
        Result result = JUnitCore.runClasses(CurrencyTest.class);
	
        /*Checking for failures*/
        for (Failure failure : result.getFailures()) {
           System.out.println(failure.toString());
        }
  		
        System.out.println("\n result.wasSuccessful() : " + result.wasSuccessful());
     
    }
    	
}
