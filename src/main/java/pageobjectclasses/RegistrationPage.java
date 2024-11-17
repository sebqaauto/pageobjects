package pageobjectclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="gender-female")
	WebElement gender;
	
	@FindBy(id="FirstName")
	WebElement firstName;
	
	@FindBy(id="LastName")
	WebElement lastName;
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPassword;
	
	@FindBy(id="register-button")
	WebElement registerButton;
	
	public void doUserRegistration(String fName, String lName, String emailAddr, String pass, String confirmPass) {
		gender.click();
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		email.sendKeys(emailAddr);
		password.sendKeys(pass);
		confirmPassword.sendKeys(confirmPass);
		registerButton.click();
	}
	
	public void selectGender() {
		gender.click();
	}
	
	public void enterFirstName(String fName) {
		firstName.sendKeys(fName);
	}
	
	public void enterLastName(String lName) {
		lastName.sendKeys(lName);
	}
	
	public void enterEmailAddr(String emailAddr) {
		email.sendKeys(emailAddr);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void enterConfirmPassword(String confirmPass) {
		confirmPassword.sendKeys(confirmPass);
	}
	
	public void clickOnRegisterButton() {
		registerButton.click();
	}


}
