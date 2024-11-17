package pageobject.demowebshop;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageobjectclasses.CommonPage;
import pageobjectclasses.LoginPage;
import pageobjectclasses.RegistrationPage;
import testdata.DataHelper;

/**
 *  Single Inheritance at class level  - override || Java allows multiple interfaces to be implemented 
 *  Import - I need the object of the class & Inheritance - I don't need the object of my parent 
 *  Import - you are going simply use it and no changes will be made to it & Inheritance - overriding or changing the behaviour 
 */
public class DemoWebShopTest {
	
	
	WebDriver driver = new ChromeDriver();
	//Passing driver to the page object class
	CommonPage common = new CommonPage(driver);
	RegistrationPage regPage = new RegistrationPage(driver);
	LoginPage loginPage =  new LoginPage(driver);
	DataHelper datahelper = new DataHelper();
	
	// Test 1 - do user registration
	public void runRegistrationTest() throws InterruptedException {
		common.launchApp();
		common.clickOnRegisterLink();
		regPage.doUserRegistration("Yuvi", "Singh", "yuvi@bcci12.com", "YouKnowMe123", "YouKnowMe123");
		Thread.sleep(3000);
	}
	
	// Test 2 - do login for the registered user
	public void runLoginTest() {
		common.clickOnLogoutLink();
		common.clickOnLoginLink();
		loginPage.doUserLogin("sky123@bcci11.com", "YouKnowMe123");
		
	}
	
	public void getUserData() throws IOException {
		datahelper.fetchDataFromExcelSheet("userDetails");
	}
	
    public static void main(String[] args) throws InterruptedException, IOException {
        DemoWebShopTest test = new DemoWebShopTest();
        //test.runRegistrationTest();
        //test.runLoginTest();
        test.getUserData();
        
    }
}
