package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	
	public WebDriver driver;
	By email = By.cssSelector("#email");
	By password = By.cssSelector("#password");
	By login = By.name("commit");
	By forgotPassword = By.cssSelector("[href*='password/new']");

	//this is a constructor.
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}


public ForgotPassword forgotPassword()
{
	driver.findElement(forgotPassword).click();
	return new ForgotPassword(driver);
	
}
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}


}
