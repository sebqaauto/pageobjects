package pageobject.demowebshop;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemoApp2 {
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
	
	public void app2FirstTest() {
		System.out.println("From the -- app2FirstTest method ");
	}
	

	public void app2SecondTest() {
		System.out.println("From the -- app2SecondTest method ");
	}


}
