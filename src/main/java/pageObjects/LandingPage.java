package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	
	public WebDriver driver;
	private By signin = By.cssSelector("a[href*='sign_in']");
	private By title = By.cssSelector(".text-center>h2");
	private By NavBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	private By header= By.cssSelector("div[class*='video-banner'] h3");
	private By popup = By.xpath("//button[text()=NO THANKS]");
	//this is a constructor.
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}



	public WebElement getLogin()
	{
	
		//LoginPage lp= new LoginPage(driver);
		return 	driver.findElement(signin);
		
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavigationBar()
	{
		return driver.findElement(NavBar);
	}
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}

}
