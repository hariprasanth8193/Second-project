package com.pages.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.main.Fblogin;
import com.pages.main.Gmail;
import com.pages.resourses.Baseclass;



/*@RunWith(Suite.class)
@SuiteClasses({})*/

public class Fb_test2 extends Baseclass {


	static WebDriver driver;
	static Fblogin f;
	//static Gmail g;
	
	@BeforeClass
	public static void test() {
		// TODO Auto-generated method stub

		driver=browsers("Chrome");
	
	
		
	}

	@Test
	public void login() throws InterruptedException {
		// TODO Auto-generated method stub
		geturl("https://en-gb.facebook.com/login/");
		f = new Fblogin(driver);
		
		Settext(f.getEmail(), "hariprasanth.ar@gmail.com");
		Assert.assertEquals("hariprasanth.ar@gmail.com", getattributet(f.getEmail(), "value"));
		Settext(f.getPassword(), "9698");
	Thread.sleep(3000);
	}
	
	
	
/*	@Test
     public void gmail() throws InterruptedException {
		geturl("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		// TODO Auto-generated method stub
     g=new Gmail(driver);
     Settext(g.getEmail(),"hariprasanth.ar@gmail.com");
     g.getNext().click();
     Thread.sleep(3000);
     Settext(g.getPassword(), "9698257");
     
		
	}
		*/
	
	@AfterClass
	 public static void quit() {
		// TODO Auto-generated method stub
		driver.quit();

	}
}
	
	
	//static WebDriver driver;
	//static Fblogin fb;
	/*public static void main(String[] args) {
		
	/*	driver= browsers("Chrome");
		
		geturl("https://en-gb.facebook.com/login/");
		
		
		fb = new Fblogin(driver);
		setText(fb.getEmail(), "hari");
		setText(fb.getPassword(), "hari");
		
		*/
		
	//}*/

