package pageobject.demowebshop;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageobjectclasses.CommonPage;
import pageobjectclasses.LoginPage;
import pageobjectclasses.RegistrationPage;
import utils.DataBaseHelper;
import utils.DataHelper;

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
	DataBaseHelper dbHelper = new DataBaseHelper();
	
	// Test 1 - do user registration Smoke & Regression 
	public void runRegistrationTest() throws InterruptedException {
		common.launchApp();
		common.clickOnRegisterLink();
		regPage.doUserRegistration("Yuvi", "Singh", "yuvi@bcci12.com", "YouKnowMe123", "YouKnowMe123");
		Thread.sleep(3000);
	}
	
	// Test 2 - do login for the registered user - Smoke
	public void runLoginTest() {
		common.clickOnLogoutLink();
		common.clickOnLoginLink();
		loginPage.doUserLogin("sky123@bcci11.com", "YouKnowMe123");
	}
	
	// Test 3 - do user registration taking data from Excel Sheet
	public void runRegistrationTest2() throws IOException {
		common.launchApp();
		common.clickOnRegisterLink();
		regPage.doUserRegistration("userDetails", 4);
		common.getRegisteredEmailId();
		common.writeRegisteredUserToExcel("registeredUserList");
	}
	
	// Test 4 fetch data from SQL BD 
	public void fetchDataFromDBTest() throws ClassNotFoundException, SQLException {
		dbHelper.fetchDBData2();
	}
	
	// Test 5 fetch data from SQL BD and do customer registration 
	public void runRegistrationTest3() throws ClassNotFoundException, SQLException, IOException {
		common.launchApp();
		common.clickOnRegisterLink();
		regPage.doUserRegistration();
		common.getRegisteredEmailId();
		common.writeRegisteredUserToExcel("registeredUserList");
	}
	
	
	
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, SQLException {
        DemoWebShopTest test = new DemoWebShopTest();
        //test.runRegistrationTest();
        //test.runLoginTest();
        //test.runRegistrationTest2();
        //test.fetchDataFromDBTest();
        test.runRegistrationTest3();
        
      
        
    }
}
