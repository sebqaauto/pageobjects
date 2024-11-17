package pageobjectclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(css =".login-button")
	WebElement login;
	
	public void doUserLogin(String emailAddr, String pass) {
		email.sendKeys(emailAddr);
		password.sendKeys(pass);
		login.click();
	}
	
	public void enterEmailAddr(String emailAddr) {
		email.sendKeys(emailAddr);
	}
	
	public void enterPassword(String pass) {
		email.sendKeys(pass);
	}
	
	public void clickOnLoginButton() {
		login.click();
	}
	

}
