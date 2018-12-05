package com.pages.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Gmail {

    public static WebDriver driver;
    
    public Gmail(WebDriver Idriver) {
		// TODO Auto-generated constructor stub
    	this.driver=Idriver;
     PageFactory.initElements(driver, this);	
    }
    
    @FindBy(xpath="//input[@id='identifierId']")
    private WebElement email;
    

	@FindBy(xpath="//span[text()='Next']")
    private WebElement next;
    
    @FindBy(xpath="//input[@name='password']")
    private WebElement password;
    
    @FindBy(xpath="(//span[@class='RveJvd snByac'])[1]")
    private WebElement next1;

	public WebElement getEmail() {
		return email;
	}

	public WebElement getNext() {
		return next;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getNext1() {
		return next1;
	}
    
    
    
}