package Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.loginPage;

public class base {

	public WebDriver driver;
	public Properties  prop;
	public loginPage LOGINPAGE;

	public WebDriver initializeDriver() throws IOException {

	    prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if (browserName.equals("firefox")) {

			// firefox driver
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\libs\\geckodriver");
			driver = new FirefoxDriver();
			

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		return driver;

	}
	
public List<HashMap<String, String>> getJsonDataToMap(String Filepath) throws IOException {
		
		//Read Json to string
		String jsonContent = FileUtils.readFileToString(new File(Filepath),
				StandardCharsets.UTF_8);
		
		
		//Json to Hashmap - Jackson Databind library - convert string to Hashmap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper. readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
			});
		
		return data;
		
		
		
	}
	
    //Screenshot code 
    public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
	
	TakesScreenshot ts = (TakesScreenshot)driver;
   	File source = ts.getScreenshotAs(OutputType.FILE);
	File file = new File(System.getProperty("user.dir")+  "//reports//" + testCaseName + ".png");
	FileUtils.copyFile(source, file);
	return System.getProperty("user.dir")+  "//reports//" + testCaseName + ".png";
	
}

	//launch application
	@BeforeMethod(alwaysRun = true)
	public loginPage launchapplication() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	    LOGINPAGE = new loginPage(driver);
		return LOGINPAGE;
		
		
	}
	
//	@AfterMethod
//	public void quitbrowser() {
//		driver.close();
//	}
	
	
	
	
	

}
