package Flexicode.NewPGApplication;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.loginPage;
import resources.base;

public class loginpage extends base {

	@Test
	public void basepagenavigation() throws IOException {

		driver = initializeDriver();
		driver.get("http://169.38.77.181:8082/NRLM_DEVWeb/#/auth");

		loginPage UN = new loginPage(driver);
		UN.getusername().sendKeys("Emp10108");

		loginPage PWD = new loginPage(driver);
		PWD.getpassword().sendKeys("123@4567");

	}
	
//	@DataProvider
//	public void getData() {
//		
//		//Row stands for how many different data types test should execute
//		//column stands for how many values per each test
//		Object[][] data = new Object[1][2];
//		
//	}
	
	
	

}
