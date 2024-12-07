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
		System.out.println("From the -- @BeforeSuite method  from TestNGDemoApp2");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("From the -- @BeforeTest method from TestNGDemoApp2 ");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("From the -- @BeforeClass method from TestNGDemoApp2");
	}
	@BeforeMethod // this is concerned at test methods it will run before every @Test method
	public void beforeMethod() {
		System.out.println("From the -- @BeforeMethod method from TestNGDemoApp2");
	}
	// The @Test is considering a method to be TestNG Test
	@Test(dependsOnMethods = "app2AmzTest2")
	public void app2AmzTest1() {
		System.out.println("From the -- AmzTest1 method ");
	}
	
	@Test(dependsOnMethods = {"app2AmzTest3"}, alwaysRun=true)
	//If Test3 fails this method will be skipped 
	public void app2AmzTest2() {
		System.out.println("From the -- AmzTest2 method ");
	}
	
	@Test
	public void app2AmzTest3() {
		System.out.println("From the -- AmzTest3 method ");
	}
	
	@Test
	public void app2AmzTest4() {
		System.out.println("From the -- AmzTest4 method ");
	}
	
	@Test
	public void app2AmzTest5() {
		System.out.println("From the -- AmzTest5 method ");
	}
	
	@Test
	public void app2AmzTest6() {
		System.out.println("From the -- AmzTest6 method ");
	}


}
