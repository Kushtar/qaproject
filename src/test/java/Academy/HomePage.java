package Academy;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException 
	{
	driver =initializeDriver();

	}
	
	
	@Test(dataProvider="getData")
		public void basePageNavigation(String Username, String Password, String text) throws IOException
	{
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getLogin();
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.getLogin().click();
		log.info(text);
	
		lp.getLogin().click();
		ForgotPassword fp = lp.forgotPassword();
		fp.getEmail().sendKeys("xxx");
		fp.sendMeInstructions().click();
		
		
	}
	

	@AfterTest
	public void teardown()
	{
		driver.close();
		driver =null;
	}

	
	@DataProvider
	public Object[][] getData()
	{
		//row stands for hom many different data types test should run
		//column stands for how many values per test
		Object[][] data = new Object[2][3];
		//0th row - for one user
		data [0][0]="nonristricteduser@qw.com";
		data [0][1]="123456";  
		data [0][2]="Restricted User";
		//1st row
		data [1][0]="restricteduser@qw.com";
		data [1][1]="456789";
		data [1][2]="Non restricted user";
		
		
		 
		
		return data;
}
}