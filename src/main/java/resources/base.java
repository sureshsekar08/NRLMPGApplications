package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				
				//Uma - data.properties file location
				//"C:\\Users\\Arul\\eclipse-workspace\\NRLMPGApplications\\src\\main\\java\\resources\\data.properties");
				
				//suresh - data.properties file location
				"C:\\Users\\admin\\eclipse-workspace\\NewPGApplication\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			
			// uma - chrome driver location
			//System.setProperty("webdriver.chrome.driver", "E:\\Uma\\seleniumdriver\\chromedriver.exe");
			
			//suresh - chrome driver location
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\libs\\chromedriver.exe");
			
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {

			// firefox driver
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\libs\\geckodriver");
			driver = new FirefoxDriver();
			

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

}
