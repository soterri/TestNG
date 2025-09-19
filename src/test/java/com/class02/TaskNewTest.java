package com.class02;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.DashboardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonnMethods;
import com.utils.ConfigsReader;
import com.utils.Constants;

public class TaskNewTest extends CommonnMethods {

	@BeforeMethod
	public void openBrowserAndNavigate() {
		setUp();

	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	@Test(priority=2, dependsOnMethods = "invalidLogin")
	public void validLogin() {
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys(ConfigsReader.getProperty("username"));
		// 2nd way
		sendText(username, ConfigsReader.getProperty("username"));

		// 3rd way using PageFactory and Page Object Model
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("pw"));

		// 1st way
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
		wait.until(ExpectedConditions.elementToBeClickable(login.buttonLogin));
		login.buttonLogin.click();

		// 2nd way
		waitForClickability(login.buttonLogin);
		login.buttonLogin.click();

		// 3rd way
		click(login.buttonLogin);

		DashboardPageElements db = new DashboardPageElements();

		boolean isDisplayed = db.logo.isDisplayed();
		if (isDisplayed) {
			System.out.println("logo is displayed");
		} else {
			System.out.println("not displayed");
		}
	}

	//@Test means Test case = scenario = Test Method
	//Case 1: If this test method is commented , it will not run
	//Depending method will throw an exception
	//@Test(priority=3, enabled=true)
	
	//Case 2: If this method is disabled, it will not run
	//Depending method will throw an exception
	//@Test(priority=3, enabled = true;
	@Test(priority = 0, enabled = false)
	public void invalidLogin() throws Exception {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		click(login.buttonLogin);

		String expectedText = "Password cannot be empty";
		String actualText = login.errorMsg.getText();

		boolean errorDisplayed = login.errorMsg.isDisplayed();

		if (errorDisplayed) {

			if (expectedText.equals(actualText)) {
				System.out.println("error msg is correct");
			} else {
				System.out.println("error msg is not correct");
			}
		} else {
			System.out.println("Error msg is not displayed");
		}
		
		//when an exception is thrown, the test fails
		throw new Exception();
	}

}
//GDF510PSD4SS
