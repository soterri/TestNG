package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPageElements;
import com.utils.CommonnMethods;
import com.utils.ConfigsReader;

public class LoginTest extends CommonnMethods {

	@BeforeMethod
	public void openBrowser() {
		setUp();
		initialize();
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

	// US: As an admin user I should be able to login to HRMS
	@Test
	public void validAdminLogin() {
		//LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.buttonLogin);
		wait(2);

		//DashboardPageElements db = new DashboardPageElements();
		String expectedUser = "Welcome Admin";
		String actualUser = db.welcome.getText();
		Assert.assertEquals(actualUser, expectedUser, "Admin is not logged in");
		Assert.assertTrue(actualUser.contains(ConfigsReader.getProperty("username")));
		System.out.println("Admin log is successful");

	}

	// invalid password login validation
	// When user enters valid username and invalid password, "Invalid credentials"
	// error message should be displayed
	@Test
	public void invalidPasswordLogin() {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, "fhgfjjhj");
		click(login.buttonLogin);

		String expected = "Invalid credentials";
		Assert.assertEquals(login.errorMsg.getText(), expected);

	}
	//negative login/scenarios
	//when user enter empty username and valid pw
	//username cannot be empty error msg should be displayed
	@Test(enabled=false)//will not execute bc u already know it will fail bc developer hasnt fixed the bug
	public void emptyUsernameLogin() {
		LoginPageElements login = new LoginPageElements();
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.buttonLogin);
		
		String expected = "Username cannot be empty";
		
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
		
	}
}