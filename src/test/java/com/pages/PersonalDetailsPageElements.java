package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;

public class PersonalDetailsPageElements {
	
	@FindBy(id="personal_cmbNation")
	public WebElement nationalityDD;
	
	@FindBy(name="personal[optGender]'")
	public List<WebElement> genderRadioGroup;
	
	@FindBy(xpath="//div[@id=pdMainContainer']")
	public WebElement lblPersonalDetails;
	
	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	
	

}
