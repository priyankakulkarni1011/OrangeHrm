package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pomclass.LoginPagePOM;
import com.sample.BaseClass;

public class LoginPageTest extends BaseClass {

	
@BeforeClass
	
	public void setup() {
		
	}
	public void teardown() {
		driver.close();
	}
	
@Test
  public void pageUrl() {
	 
	  
	  String pageurl = getWebDriver().getCurrentUrl();
	  if(pageurl.equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")) {
		  
		  System.out.println("We are on correct page...Test Pass");
	  }
  }
@Test
public void loginTest() {
	LoginPagePOM loginpagepom = new LoginPagePOM();
	loginpagepom.login(loginpagepom.getUsername(),loginpagepom.getPassword());
}
@Test
public void unvalidLoginTest() {
	LoginPagePOM loginPagePom = new LoginPagePOM();
	loginPagePom.unvalidLogin(loginPagePom.getUnvalidUsername(),loginPagePom.getUnvalidPassword());
	
   String errorMessage = "Invalid credentials";
	
if(loginPagePom.getErrorMessage().equals(errorMessage)) {
	
	System.out.println("Test Case Pass");
	
}else{
	System.out.println("Test Case Fail");
  }
 }
}