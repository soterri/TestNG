package com.utils;

import com.pages.AddEmployeePageElements;
import com.pages.DashboardPageElements;
import com.pages.LoginPageElements;
import com.pages.PersonalDetailsPageElements;

public class PageInitializer extends BaseClass {

	public static LoginPageElements login;
	public static DashboardPageElements db;
	public static AddEmployeePageElements addEmp;
	public static PersonalDetailsPageElements pdetail;
	
	public static void initialize() {
		
		login = new LoginPageElements();
		db = new DashboardPageElements();
		addEmp = new AddEmployeePageElements();
		pdetail = new PersonalDetailsPageElements();
	}
	public void navigateToAddEmployee() {
		//jsClick(PIM);
		//jsClick(addEmp);
	}
}
