package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	public WebDriver driver;
    
	//life of driver-constructor
	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// locator for login page
	
	@FindBy(id ="username" )
	WebElement username;
	
	@FindBy(id ="password" )
	WebElement password;
	
	@FindBy(css = "div[class=\'d_content\'] p")
	WebElement Invalidcrederrormsg;
	
	public void loginApplication(String loginID,String loginpwd) {
		username.sendKeys(loginID);
		password.sendKeys(loginpwd);
		
	}
	
	public String ErrorMsg() {
		
		return Invalidcrederrormsg.getText();
		
	}
	
	
	
}
