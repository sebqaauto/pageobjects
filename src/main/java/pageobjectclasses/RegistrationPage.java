package pageobjectclasses;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DataBaseHelper;
import utils.DataHelper;

public class RegistrationPage {
	
	WebDriver driver;
	DataHelper dataHelper;
	DataBaseHelper dbHelper;
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		dataHelper = new DataHelper();
		dbHelper = new DataBaseHelper();
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
	
	public void doUserRegistration(String sheetName, int rowNo) throws IOException {
		//datahelper.fetchDataFromExcelSheet("userDetails");
		List<String> userData = dataHelper.fetchDataFromExcelSheet(sheetName, rowNo);
		gender.click();
		firstName.sendKeys(userData.get(0));
		lastName.sendKeys(userData.get(1));
		email.sendKeys(userData.get(2));
		password.sendKeys(userData.get(3));
		confirmPassword.sendKeys(userData.get(4));
		registerButton.click();
	}
	
	public void doUserRegistration() throws ClassNotFoundException, SQLException {
		// dbHelper is fetching data from data base 
		List<String> userData = dbHelper.fetchDBData2();
		gender.click();
		firstName.sendKeys(userData.get(0));
		lastName.sendKeys(userData.get(1));
		email.sendKeys(userData.get(2));
		password.sendKeys(userData.get(3));
		confirmPassword.sendKeys(userData.get(4));
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
