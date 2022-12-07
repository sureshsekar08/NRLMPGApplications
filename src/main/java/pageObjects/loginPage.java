package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {

	public WebDriver driver;
    
	//life of driver-constructor
	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//fwefef

	// locator for login page
	
	@FindBy(id ="username" )
	WebElement username;
	
	@FindBy(id ="password" )
	WebElement password;
	
//	@FindBy(xpath = "//*[@id=\\\"main\\\"]/section[2]/div/div/div[3]/form/div[3]/div/div[3]/input")
//	WebElement captchavalues;
	
	@FindBy(css  ="ngx-spinner[type='ball-climbing-dot']")
	WebElement loader;
	
	@FindBy(id="btnLogin")
	WebElement loginbutton;
	
	@FindBy(css = "div[class=\'d_content\'] p")
	WebElement Invalidcrederrormsg;
	
	public void loginApplication(String loginID,String loginpwd) {
		username.sendKeys(loginID);
		password.sendKeys(loginpwd);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOf(loader));
		

		loginbutton.click();
		
		
		
		
	}

	private WebDriver getWebDriver() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
//	public void loginbutton() {
//		login.click();
//	}
	
//	public void captchaval() {
//		//captchavalues.sendKeys(st);
//	}
	
//	public String ErrorMsg() {
//		
//		return Invalidcrederrormsg.getText();
//		
//	}
	
	
	
}
