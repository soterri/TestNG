package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonnMethods;
import com.utils.ConfigsReader;

public class TaskNewTest extends CommonnMethods {

	@BeforeMethod
	public void openBrowserAndNavigate() {
		setUp();
		
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	@Test
	public void validLogin() {
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys(ConfigsReader.getProperty("username"));
		//2nd way
		sendText(username, ConfigsReader.getProperty("username"));
	}

}
