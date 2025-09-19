package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;
import com.utils.CommonnMethods;

public class DashboardPageElements extends CommonnMethods {
	
	@FindBy(id="Welcome")
	public WebElement welcome;
	
	@FindBy(xpath="//div['logo']")
	public WebElement logo;
	
	@FindBy(xpath="//a@id=['menu_pim_addEmployee']")
	public WebElement addEmp;
	
	public DashboardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
		
	}
	public void navigateToAddEmployee() {
		jsClick(addEmp);
		//click(addEmp);
	}

}
