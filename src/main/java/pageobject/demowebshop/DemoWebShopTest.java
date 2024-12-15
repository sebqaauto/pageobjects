package pageobject.demowebshop;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

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
	
	//For the reporting we are using Extents Report 
	ExtentSparkReporter reporter; // write the results in html file format
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void runBeforeTest() {
		
		new DemoWebShopTest();
	}
	
	public DemoWebShopTest() {
		reporter = new ExtentSparkReporter("/Users/sebastianselvarajaugustine/eclipse-workspace/demowebshop/src/main/java/test-results/AutomationResults.html");
		reporter.config().setReportName("Demo WebShop Automation");
		extent = new ExtentReports();
		//Passing the ExtentSparkReporter object to ExtentReports object, so that ExtentReports object can record or listen to the tests
		extent.attachReporter(reporter);
	}
	
	// Test 1 - do user registration Smoke & Regression 
	@Test
	public void runRegistrationTest() throws InterruptedException, IOException {
		test=extent.createTest("runRegistrationTest");
		common.launchApp();
		test.log(Status.INFO, "App Launched");
		common.clickOnRegisterLink();
		test.log(Status.INFO, "Registration page is launched");
		regPage.doUserRegistration("Yuvi", "Singh", "yuvi4343@bcc424i1266.com", "YouKnowMe123", "YouKnowMe123");
		test.log(Status.INFO, "Registration is completed");
		String filePath = common.takeSnap();
		Thread.sleep(3000);
		test.addScreenCaptureFromPath(filePath);
		common.clickOnLogoutLink();
		extent.flush();
	}
	
	// Test 2 - do login for the registered user - Smoke
	@Test
	public void runLoginTest() throws IOException {
		test=extent.createTest("runLoginTest");
		test.log(Status.INFO, "Logout link  is Clicked");
		common.clickOnLoginLink();
		test.log(Status.INFO, "Login link  is Clicked");
		loginPage.doUserLogin("sky123@bcci11.com", "YouKnowMe123");
		test.log(Status.INFO, "Login  is Completed");
		String filePath = common.takeSnap();
		test.addScreenCaptureFromPath(filePath);
		extent.flush();
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
	

	public Object[] fetchDataFromDBTest2() throws ClassNotFoundException, SQLException {
		return dbHelper.fetchDBData3();
	}
	

	public void runRegTest(String str1) {
		System.out.println("From the DB through DataProvider");
		System.out.println(str1);
	}
	
	
	
//    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, SQLException {
//       DemoWebShopTest test = new DemoWebShopTest();
//        test.runRegistrationTest();
//        test.runLoginTest();
//        //test.runRegistrationTest2();
//        //test.fetchDataFromDBTest();
//        //test.runRegistrationTest3();
//        
//    }
}
