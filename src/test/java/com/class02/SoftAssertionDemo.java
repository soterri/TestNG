package com.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.DashboardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonnMethods;
import com.utils.ConfigsReader;


public class SoftAssertionDemo extends CommonnMethods{
	/*open application
	 * verify logo is displayed
	 * enter valid credentials
	 * verify user successfully logged in, by verifyiing welcome message
	 */
	
	@BeforeMethod
	public void openBrowserAndNavigate() {
		setUp();
	}
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
	@Test
	public void logoAndWelomeValidation() {
		LoginPageElements login = new LoginPageElements();
	
		//logo assertion
		boolean logoDisplayed = login.logo.isDisplayed();
		
		//If I do a (hard) Assert, the code will not continue executing
		//Assert.assertTrue(logoDisplayed,"Logo is not displayed");
		
		//If I do a soft assert, the code will continue to execute
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(logoDisplayed, "logo is not displayed");
		//logging in
		Assert.assertTrue(logoDisplayed, "Logo is not displayed");
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.buttonLogin);
		
		
		//Welcome msg assertion
		DashboardPageElements db = new DashboardPageElements();
		boolean msgDisplayed = db.welcome.isDisplayed();
		
		//Assert.assertTrue(msgDisplayed);
		soft.assertTrue(msgDisplayed, "Welcome msg not displayed");
		
		//this will collect if all soft assertions and then decide if TC passed or failed
		soft.assertAll();
		
		//execution stops after assertAll
		//this statement will not be executed
		System.out.println("After assertAll");
		
		
		
		
	}
	

}
