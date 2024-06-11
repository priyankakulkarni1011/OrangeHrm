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
		
		@FindBy(xpath="//p[text()='Password : admin123']")
	     private WebElement passwordText;
		
		@FindBy(xpath="//input[@name='username']")
		 private WebElement usernameInput;
		
		@FindBy(xpath="//input[@name='password']")
		 private WebElement passwordInput;
		
		@FindBy(xpath="//button[@type='submit']")
		 private WebElement submitButton;
		
		@FindBy(xpath="//div[@class='orangehrm-login-forgot']//child::p")
		 private WebElement forgotpassword;
		
		@FindBy(xpath="//p[text()='Invalid credentials']")
		 private WebElement errorMessage;
		
		public String getUsername() {
		String username = usernameText.getText();
		 return username.split(":")[1].trim();
		 }
		public String getPassword() {
			String password =passwordText.getText();
			 return password.split(":")[1].trim();
		}
		public void login(String username,String password) {
			usernameInput.sendKeys(username);
			passwordInput.sendKeys(password);
			submitButton.click();
		}
		public String getUnvalidUsername() {
			String username = usernameText.getText();
			 return username.split(":")[0].trim();
		}
		public String getUnvalidPassword() {
			String password =passwordText.getText();
			 return password.split(":")[0].trim();
		}
		public void unvalidLogin(String username,String password) {
			usernameInput.sendKeys(username);
			passwordInput.sendKeys(password);
			submitButton.click();
		
		}
		public String getErrorMessage() {
		  return errorMessage.getText();
		}
	}