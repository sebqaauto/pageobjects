package pageobject.demowebshop;

import org.testng.annotations.Test;

public class TestNGDemoApp3 {
	
	@Test(dependsOnMethods = "app2AmzTest2")
	public void app2AmzTest1() {
		System.out.println("From the -- AmzTest1 method ");
	}
	
	@Test(dependsOnMethods = {"app2AmzTest3"}, alwaysRun=true)
	//If Test3 fails this method will be skipped 
	public void app2AmzTest2() {
		System.out.println("From the -- AmzTest2 method ");
	}
	
	@Test(priority = 3)
	public void app2AmzTest3() {
		System.out.println("From the -- AmzTest3 method ");
	}
	
	@Test(priority = 3)
	public void app2AmzTest4() {
		System.out.println("From the -- AmzTest4 method ");
	}
	
	@Test(priority = 2)
	public void app2AmzTest5() {
		System.out.println("From the -- AmzTest5 method ");
	}
	
	@Test(priority = 1, invocationCount = 3)
	public void app2AmzTest6() {
		System.out.println("From the -- AmzTest6 method ");
	}


}
