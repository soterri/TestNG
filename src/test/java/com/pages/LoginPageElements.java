package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;
import com.utils.CommonnMethods;

public class LoginPageElements extends CommonnMethods{
	//not using pageFactory, you would have to extends CommonnMethods or baseClass
	//public WebElement username2 = driver.findElement(By.id("username"));
	
	//Using PageFactory and @FindBy annotation
	//simply locating elements, supports all 8 locators
	@FindBy(id="txtUsername")
	public WebElement username;
	
	@FindBy(id="txtPassword")
	public WebElement password;
	
	@FindBy(css="input#btnLogin")
	public WebElement buttonLogin;
	
	@FindBy(xpath="//div[@id='divLogo']/img")
	public WebElement logo;

	@FindBy(id="spanMessage")
	public WebElement errorMsg;
	
	//creating a constructor of this page
	public LoginPageElements() {
		PageFactory.initElements(BaseClass.driver, this);//this refers to current class and object
		
	}
	//if we kept elements as private, then we will need to create
	//public getters and setters
	//so we can access page elements from test classes
	//setter
	public void sendUsername(String uid) {
		sendText(username, uid);
		//THIS METHOD IS IF THE ACCESS MODIFIER FOR WEBELEMENT USERNAME IS PRIVATE
	}
	//getter
	public WebElement getUsername() {
		return username;
	}
	public void login(String uid, String pwd) {
		sendText(username, uid);
		sendText(password, pwd);
		click(buttonLogin);
		
	}

}

//@FindBy we just locating elements, once we locate elements we initialize all these elements at once 
//instead of saying driver.findelement this and that, we use 
//pagefactory methods initElements, these methods initialize all objects of the current page
/*
 * page factory eliminates the driver.findelements/element we are initaliing all elements of THIS page locating elements using @Findby annotation
*/