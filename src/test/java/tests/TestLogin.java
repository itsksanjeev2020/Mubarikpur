package tests;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobject.LandingPage;
import pageobject.LoginPage;
import pageobject.MyAccount;
import resources.Base;

public class TestLogin extends Base {
	Logger log ;
    WebDriver driver; 
	@BeforeMethod
	public void OpenApplication() throws IOException {
		log=LogManager.getLogger(TestLogin.class.getName());
		driver = initialBrowserDriver();
		log.debug("Driver got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}


	@Test(dataProvider="getLoginData")
	public void login(String email,String password,String expectedStatus) throws IOException, InterruptedException {
		LandingPage landingPage=new LandingPage(driver);
		landingPage.myAccountDropDown().click();
		log.debug("My Account Drop Down got clicked on landing page");
		landingPage.LoginOption().click();
		log.debug("Login option got clicked on landing page");
		Thread.sleep(5000);
		LoginPage loginPage=new LoginPage(driver);
		loginPage.emailField().sendKeys(email);
		log.debug("Email address typed in email field on login page");
		loginPage.passwordField().sendKeys(password);
		log.debug("password typed in password field on login page");
		loginPage.LoginButton().click();
		log.debug("clicked on login button on login page");
		Thread.sleep(5000);
		MyAccount myAcount=new MyAccount(driver);
		String actualResult = null;
		try
		{
		if (myAcount.pageHeading().isDisplayed())
			log.debug("user got login");
			actualResult="Success";
			}catch(Exception e) 
		{
				actualResult="Failure";
				log.debug("user not got login");
		}
		Assert.assertEquals(expectedStatus, actualResult);
		log.debug("login test passed");	
	}
		
	
	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("Browser got closed");
	}
	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data= {{"itssanjeev2012@yahoo.com","123456","Success"},{"dummy@yahoo.com","123456","Failure"}};
		return data;
		
	}
	
	

}
