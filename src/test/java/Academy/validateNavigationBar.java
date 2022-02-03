package Academy;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import java.io.IOException;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.LandingPage;
import resources.base;


//Adding extends and the File name will import all the content form that file 

public class validateNavigationBar extends base{
	public WebDriver driver;
	public static Logger log= LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException 
	{
	driver =initializeDriver();
	driver.get(prop.getProperty("url"));
	}
	
	
	
	@Test
	public void basePageNavigation() throws IOException
	{
	
		//two ways to access methods of other class
		//1. inheritance
		//2. creating object to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		AssertJUnit.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Navigation Bar is Displayed");
		
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}


}
