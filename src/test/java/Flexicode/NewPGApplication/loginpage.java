package Flexicode.NewPGApplication;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Testcomponents.base;
import pageObjects.loginPage;


public class loginpage extends base {
	
	
	
	
	
//	@BeforeTest
//	public void initialize() throws IOException {
//		
//		driver = initializeDriver();
//		driver.get(prop.getProperty("url"));
//		
//		}
	
//	@AfterTest
//	public void quitbrowser() {
//		driver.close();
//	}

	@Test(dataProvider = "getData")
	public void basepagenavigation(HashMap<String, String> input) throws IOException {
        
		//login credentials- method calling from Pageobject
		LOGINPAGE.loginApplication(input.get("usernameUN"), input.get("PasswordPWD"));
		

	}

	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("usernameUN", "Emp7788");
//		map.put("PasswordPWD", "123@4567");
//		
//		HashMap<Object, Object> map1 = new HashMap<Object, Object>();
//		map1.put("usernameUN", "Emp10108");
//		map1.put("PasswordPWD", "1234567");
//		
//		HashMap<Object, Object> map2 = new HashMap<Object, Object>();
//		map2.put("usernameUN", "Emp123444");
//		map2.put("PasswordPWD", "1235678");
//		
//		HashMap<Object, Object> map3 = new HashMap<Object, Object>();
//		map3.put("usernameUN", "Emp10108");
//		map3.put("PasswordPWD", "123@4567");
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Data\\logincrendentials.json");
		
		return new Object [][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)}};
			
		
	}
	
	
//	@DataProvider
//	public Object[][] getData() {
//		
//		return new Object [][] {{"Emp7788","123@4567"},{"Emp10108","1234567"},{"Emp123444","1235678"},{"Emp10108","123@4567"}};
	
	//Row stands for how many different data types test should execute
			//column stands for how many values per each test
			//Object[][] data = new Object[4][2];
			
			/*
			 * //0th Row - incorrect data[0][0]="Emp7788"; data[0][1]="123@4567";
			 * 
			 * //1st Row - incorrect data[1][0]="Emp10108"; data[1][1]="1234567";
			 * 
			 * //2nd Row - incorrect data[2][0]="Emp123444"; data[2][1]="1235678";
			 * 
			 * //3rd Row - incorrect data[3][0]="Emp10108"; data[3][1]="123@4567";
			 */
			
			//return data
//	}
	
	

}
