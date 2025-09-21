package Groups;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GroupsDemo {
	//alwaysRun attribute will make sure that this method will always execute
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("Before Class");
	}
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		System.out.println("After class");
	}
	@Test(groups="smoke")
	public void test1() {
		System.out.println("test 1");
		Assert.assertTrue(false);//if this test fails, test1 will be skipped
		
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(false);
		soft.assertAll();//this statement will collect all soft assert and decide if test passed or failed
		
	}
	@Test(groups= {"regression"})
	public void test2() {
		System.out.println("test 2");
	}
	@Test
	public void test3() {
		System.out.println("test 3");
	}
	@Test(groups= {"smoke", "regression"})
	public void test4() {
		System.out.println("test 4");
	}

}
