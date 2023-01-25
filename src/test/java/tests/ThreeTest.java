package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base {
	public WebDriver driver;
	@Test
	public void threeTest() throws IOException, InterruptedException {
	System.out.println("This is the Third Test Method");
	 driver = initialBrowserDriver();
	 driver.get("http://tutorialsninja.com/demo/index.php?route=account/account");
	 Thread.sleep(3000);
	 driver.close();
	}

}
