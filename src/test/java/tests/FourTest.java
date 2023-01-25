package tests;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base{
	public WebDriver driver;
	@Test
	public void fourTest() throws IOException, InterruptedException {
		System.out.println("This is the four test method");
		driver = initialBrowserDriver();
		 driver.get("http://tutorialsninja.com/demo/index.php?route=account/account");
		 Thread.sleep(3000);
		 Assert.assertTrue(false);
	
	
	}
	@AfterMethod
	public void closingBrowser() {
		driver.close();
	}

}
