package com.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPageElements;
import com.utils.CommonnMethods;

public class AssertionDemo extends CommonnMethods {

	// HARD ASSERTION
	@BeforeMethod
	public void openBrowserAndNavigate() {
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	//AssertionError is handled within TestNG 
	//Even if one test case fails, the other test cases will execute if they're not dependent on another TC
	
	@Test
	public void titleValidation() {
		String expectedTitle="HRMS";
		String actualTitle=driver.getTitle();
		
		//1st way giving a msg
		Assert.assertEquals(actualTitle, expectedTitle, "Title does not match");
		//2nd way
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("text after assertion");
		//if the hard assertion fails, this statement will not be executed
	}
	@Test (priority=2, dependsOnMethods = {"titleValidation"})
	public void logoValidation() {
		LoginPageElements login = new LoginPageElements(); //using page object model
		boolean isDisplayed = login.logo.isDisplayed();
		//1st way
		Assert.assertEquals(isDisplayed, true, "Logo is not displayed");
		//2nd way
		Assert.assertTrue(isDisplayed, "logo is not displayed");
		
	}

}
//iq in assertions video 2:26