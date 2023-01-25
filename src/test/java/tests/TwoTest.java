package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base 
{
	public WebDriver driver;
	
	@Test
	public void twoTest() throws IOException, InterruptedException 
	{
		System.out.println("This is the twoTest method");
		 driver = initialBrowserDriver();
		 driver.get("http://tutorialsninja.com/demo/index.php?route=account/account");
		 Thread.sleep(3000);
		 driver.close();
		
	}

	


}
