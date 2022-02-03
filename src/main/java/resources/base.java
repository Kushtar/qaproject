package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties prop;

	
	public WebDriver initializeDriver() throws IOException
	{
		//Files properties
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
		//Load the content of that file
		prop.load(fis);
		
		//parameterizing with jenkins
		
		//mvn test -Dbrowser=chrome <--- this mvn command will give the input for browser from terminal and run it
		//for this maven command to run, we change the following command.
		
		//uncomment the following line if you want to use parameter input from terminal or jenkins
		//String browserName = System.getProperty("browser");
		
		String browserName = prop.getProperty("browser");

		//if(browserName.equals("chrome"))

			if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/resources/chromedriver");

			//RUNNING IN HEADLESS MODE - when the tests execute without invoking web browsers. It runs behind. Do this:
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless"))
				{
				options.addArguments("headless");
				}
			//execute in chrome driver
			driver = new ChromeDriver(options);
		}
		else if (browserName.contains("firefox"))
		{
			//execute in firefox
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/resources/geckodriver");
			driver = new FirefoxDriver();
		}
		else if (browserName.contains("IE"))
		{
			//execute in Enternet Explorer
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/resources/chromedriver");
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
	}
