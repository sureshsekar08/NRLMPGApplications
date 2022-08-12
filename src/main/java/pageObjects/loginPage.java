package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {

	public WebDriver driver;
    
	//life of driver
	public loginPage(WebDriver driver) {
		this.driver = driver;
	}

	// locator for login page
	By username = By.id("username");
	By password = By.id("password");

	public WebElement getusername() {

		return driver.findElement(username);

	}

	public WebElement getpassword() {

		return driver.findElement(password);

	}

}
