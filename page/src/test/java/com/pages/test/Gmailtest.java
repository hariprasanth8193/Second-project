package com.pages.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.pages.main.Gmail;
import com.pages.resourses.Baseclass;

public class Gmailtest extends Baseclass{
	static WebDriver driver;
      static Gmail g;
      
      @BeforeClass
      
      public static void test1() {
		// TODO Auto-generated method stub
         driver = browsers("Chrome");
         geturl("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
    	  
	}
      
      @Test
      public void gmailtest() throws InterruptedException {
		// TODO Auto-generated method stub
    	  
     		// TODO Auto-generated method stub
       g=new Gmail(driver);
       Settext(g.getEmail(),"hariprasanth.ar@gmail.com");
       g.getNext().click();
       Thread.sleep(3000);
       Settext(g.getPassword(), "9698257");
       

	}
      @AfterClass
      public static void close() {
		// TODO Auto-generated method stub
      driver.close();
	}
}
