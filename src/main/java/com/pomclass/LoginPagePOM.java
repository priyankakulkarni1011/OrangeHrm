package com.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sample.BaseClass;
import com.utility.Utility;

public class LoginPagePOM extends BaseClass{
	
	

	public LoginPagePOM() {
		WebDriver driver = super.getWebDriver();
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath="//p[text()='Username : Admin']")
	     private WebElement usernameText;
		
		@FindBy(xpath="//p[text()='Password : admin123']")
	     private WebElement passwordText;
		
		@FindBy(xpath="//div/input[@name='username']")
		 private WebElement usernameInput;
		
		@FindBy(xpath="//div/input[@name='password']")
		 private WebElement passwordInput;
		
		@FindBy(xpath="//button[@type='submit']")
		 private WebElement submitButton;
		
		@FindBy(xpath="//div[@class='orangehrm-login-forgot']//child::p")
		 private WebElement forgotpassword;
		
		@FindBy(xpath="//input[@name='username']")
		private WebElement resetPasswordusernameInput;
		
		@FindBy(xpath="//p[text()='Invalid credentials']")
		 private WebElement errorMessage;
		
		@FindBy(xpath="//button[@type='submit']")
		private WebElement resetPasswordsubmitButton;
		
		@FindBy(xpath="//h6[text()='Reset Password link sent successfully']")
		private WebElement resetPasswordText;
		
		public String getUsername() {
		String username = Utility.getWebElementText(usernameText);
		 return username.split(":")[1].trim();
		 }
		public String getPassword() {
			String password = Utility.getWebElementText(passwordText);
			 return password.split(":")[1].trim();
		}
		
		public void login(String username,String password) {
			
			Utility.setText(usernameInput, username);
			Utility.setText(passwordInput, password);
			
			Utility.webelementClick(submitButton);
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
			Utility.setText(usernameInput, username);
			Utility.setText(passwordInput, password);
			Utility.webelementClick(submitButton);
			Utility.webelementClick(forgotpassword);
		
		}
		public String getErrorMessage() {
		  return errorMessage.getText();
		}
		public String forgotPassword(String username,String password) {
			Utility.webelementClick(forgotpassword);
			Utility.setText(resetPasswordusernameInput,username );
			Utility.webelementClick(resetPasswordsubmitButton);
			String resetText = Utility.getWebElementText(resetPasswordText);
			return resetText;
		}
	}}