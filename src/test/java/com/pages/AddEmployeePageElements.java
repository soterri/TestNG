package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;
import com.utils.CommonnMethods;

public class AddEmployeePageElements extends CommonnMethods {

	@FindBy(id="firstName")
	public WebElement firstName;
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	@FindBy(id="employeeId")
	public WebElement employeeId;
	
	@FindBy(id="checkLogin")
	public WebElement checkboxLoginDetails;
	
	
	
	

	public AddEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
