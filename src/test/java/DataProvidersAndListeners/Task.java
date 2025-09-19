package DataProvidersAndListeners;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.DashboardPageElements;
import com.utils.CommonnMethods;
import com.utils.ConfigsReader;

public class Task extends CommonnMethods{

	@Test(dataProvider = "userData")
	public void test(String firstName, String lastName, String username, String password) {
		
		//login into HRMS
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));

		//navigate to Add Employee page
		db.navigateToAddEmployee();
		wait(1);
		
		//add employee info
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.lastName, lastName);
		
		//get employee id
		String expectedEmpId = addEmp.employeeId.getText(); //or getAttribute("value");
		System.out.println(expectedEmpId);
		click(addEmp.checkboxLoginDetails);
		
	}
	
	@DataProvider(name="userData")
	public Object[][] getData() {
		Object[][] data = {
		{"Terri", "dfdgfgfg"},
		{"Syntax", "rgfhgh"}
		
		};
		return data;
	}
}
