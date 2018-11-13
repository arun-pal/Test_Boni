package TestCases;

import org.openqa.selenium.WebDriver;

import CommonFunctions.TestContext;
import Pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Common_Step {
	
	TestContext testContext;
	public WebDriver driver;
	public LoginPage loginpageinstance; 
	
	public Common_Step(TestContext testContext) {
		this.testContext=testContext;
		driver = testContext.getDriver();
		loginpageinstance=testContext.getPageObjectManager().getLoginPage();
	}

	@Given("^I have started Browser$")
	public void i_have_started_Browser() throws Throwable {
		loginpageinstance.getURL();
	 
	}

	@When("^I sign in to Bonify Application$")
	public void i_sign_in_to_Bonify_Application() throws Throwable {
		loginpageinstance.registration();

	}

}
