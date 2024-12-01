package pageobject.demowebshop;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemoApp1 {
	// This is a Class having 2 tests - are methods 
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("From the -- @BeforeSuite method ");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("From the -- @BeforeTest method ");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("From the -- @BeforeClass method ");
	}
	@BeforeMethod // this is concerned at test methods it will run before every @Test method
	public void beforeMethod() {
		System.out.println("From the -- @BeforeMethod method ");
	}
	// The @Test is considering a method to be TestNG Test
	@Test
	public void app1FirstTest() {
		System.out.println("From the -- app1FirstTest method ");
	}
	@Test
	public void app1SecondTest() {
		System.out.println("From the -- app1SecondTest method ");
	}
	
	@AfterMethod // this is concerned at test methods it will run after every @Test method
	public void afterMethod() {
		System.out.println("From the -- @AfterMethod method ");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("From the -- @AfterClass method ");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("From the -- @AfterTest method ");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("From the -- @AfterSuite method ");
	}

}
