package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resources.base;

public class stepDefinition extends base {

	@Given("Initialize the browser with chrome")
	public void initialize_the_browser_with_chrome() throws IOException {

		driver = initializeDriver();
	}

	@And("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_something_site(String arg1) throws Throwable {
		driver.get(arg1);
	}

	@And("Click on Login link in home page to land on Secure sign in Page")
	public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() {
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		
	}

	@When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		LoginPage lp =new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
	}

	@Then("Verify that user is successfully logged in")
	public void verify_that_user_is_successfully_logged_in() {
		portalHomePage p = new portalHomePage(driver);
		Assert.assertTrue(p.getSearchBox().isDisplayed());
		
	}
	   @And("^Close browsers$")
	    public void close_browsers() throws Throwable {
	        driver.quit();
	    }


}
