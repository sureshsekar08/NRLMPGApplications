package Flexicode.NewPGApplication;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.loginPage;
import resources.base;

public class loginpage extends base {
	
	
	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
		}
	
	@AfterTest
	public void quitbrowser() {
		driver.close();
	}

	@Test(dataProvider = "getData")
	public void basepagenavigation(String usernameUN, String PasswordPWD) throws IOException {

		
		
		loginPage UN = new loginPage(driver);
		UN.getusername().sendKeys(usernameUN);

		loginPage PWD = new loginPage(driver);
		PWD.getpassword().sendKeys(PasswordPWD);

	}
	
	@DataProvider
	public Object[][] getData() {
		
		//Row stands for how many different data types test should execute
		//column stands for how many values per each test
		Object[][] data = new Object[4][2];
		
		//0th Row - incorrect
		data[0][0]="Emp7788";
		data[0][1]="123@4567";
		
		//1st Row - incorrect
		data[1][0]="Emp10108";
		data[1][1]="1234567";
		
		//2nd Row - incorrect
		data[2][0]="Emp123444";
		data[2][1]="1235678";
		
		//3rd  Row - incorrect
		data[3][0]="Emp10108";
		data[3][1]="123@4567";
		
		return data;
		
		
	}
	
	
	

}
