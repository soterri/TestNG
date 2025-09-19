package Groups;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonnMethods;

public class DataProviderDemo extends CommonnMethods {

	@Test(dataProvider = "getData")
	public void login(String username, String password, int age) {
		System.out.println(age);
		sendText(login.username, username);
		sendText(login.password, password);
		click(login.buttonLogin);
		
		boolean isDisplayed = db.welcome.isDisplayed();
		Assert.assertTrue(isDisplayed, "Welxome msg is not displayed");
	}

	//methods that have the @dataprovider annotation should be a 2d array
	//providing parameters
	@DataProvider
	public Object[][] getData() {
		
		//The number of rows will decide how many times the test will run
		//The columns of each row are passed are parameter to Test case
		Object[][] data = {{"Admin", "hum23545@", 23},
				{"syntdg", "Fgfhfh", 50}
		};
		
		
		//2nd way
		Object[][] data2 = new Object[3][3];
		data2[0][0]="Admin";
		data2[0][1]="hum@123";
		
		return data;
//      thi is like doing the following three steps
//		login("Admin", "Hum@hrms123", 20);
//		login("Terri", "yeahfhfh", 36);
//		login("dgfgfg", "fgfgfdg", 50);
		
	}
}
