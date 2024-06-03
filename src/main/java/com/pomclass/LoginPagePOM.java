package com.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sample.BaseClass;

public class LoginPagePOM extends BaseClass{
	
	

	public LoginPagePOM() {
		
	WebDriver driver = super.getWebDriver();
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//p[text()='Username : Admin']")
     private WebElement usernameText;
	
	@FindBy(xpath="//div/p[text()='Password : admin123']")
     private WebElement passwordText;
	
	@FindBy(xpath="//div/input[@name='username']")
	 private WebElement usernameInputText;
	
	@FindBy(xpath="//div/input[@name='password']")
	 private WebElement passwordInputText;
	
	@FindBy(xpath="//button[@type='submit']")
	 private WebElement submitButton;
	
	@FindBy(xpath="//div[@class='orangehrm-login-forgot']//child::p")
	 private WebElement forgotpasswordLink;
	


}
