package com.pages.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Fblogin {

	public static WebDriver driver;
	
	public Fblogin(WebDriver IDdriver) {
		// TODO Auto-generated constructor stub
		this.driver = IDdriver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "pass")
	private WebElement password;
	
	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

	@FindBy(name = "login")
	private WebElement login;
}
