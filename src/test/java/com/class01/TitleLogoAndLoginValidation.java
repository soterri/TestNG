package com.class01;

import java.io.ObjectInputFilter.Config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonnMethods;
import com.utils.ConfigsReader;

public class TitleLogoAndLoginValidation extends CommonnMethods {

	@BeforeMethod
	public void openAndNavigate() throws InterruptedException {
		setUp();
		Thread.sleep(2000);

	}

	@AfterMethod
	public void tearDownn() {
		tearDown();
	}

	@Test
	public void titleValidation() {
		String expectedTitle = "HRMS";
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("titleValidation passed");
		} else {
			System.out.println("titleValidation failed");
		}
	}

	@Test
	public void logoValidation() {
		WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		// or
		// String logoPath = "";
		// WebElement logo = driver.findElement(By.xpath(logoPath));
		boolean isDisplayed = logo.isDisplayed();
		if (isDisplayed) {
			System.out.println("LogoValidation passed");
		} else {
			System.out.println(logo);

		}

	}

	@Test
	public void validLogin() {
		WebElement username = driver.findElement(By.id("txtUN"));
		sendText(username, ConfigsReader.getProperty("username"));
		// sendText(username, "Admin") instead of hardcoding use ConfigsReader.getProp
		// in case username gets changed you dont have to change throughout code

		WebElement pw = driver.findElement(By.id("password"));
		sendText(pw, ConfigsReader.getProperty("password"));
		
		click(driver.findElement(By.id("buttonLogin")));
		
	}

}
