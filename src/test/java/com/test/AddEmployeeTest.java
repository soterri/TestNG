package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonnMethods;
import com.utils.ConfigsReader;

public class AddEmployeeTest extends CommonnMethods {

//	@BeforeMethod
//	public void openBrowser() {
//		setUp();
//		initialize();
//	}
//
//	@AfterMethod
//	public void closeBrowser() {
//		tearDown();
//	}

	@Test
	public void addEmployeePage() {
		// call login method from loginPageElements
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		// instead of all of this code below, use method login
		// login.username.sendKeys(ConfigsReader.getProperty("username"));
//		login.password.sendKeys(ConfigsReader.getProperty("password"));
//		login.buttonLogin.click();

		db.navigateToAddEmployee();
		//sendText(addEmp.empFirstName, ConfigsReader.getProperty("empFirstName"));
		
		//add assertion to verify that employee has been added successfully
		
	}

}
