package TestCases;
import org.openqa.selenium.WebDriver;
import CommonFunctions.TestContext;
import Pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class Click_Register_Link {
	
	TestContext testContext;
	public WebDriver driver;
	public LoginPage loginpageinstance; 
	
	public Click_Register_Link(TestContext testContext) {
		this.testContext=testContext;
		driver = testContext.getDriver();
		loginpageinstance=testContext.getPageObjectManager().getLoginPage();
	}

	@When("^I click on Register Link$")
	public void i_click_on_Register_Link() throws Throwable {
		loginpageinstance.clickRegisterLink();
	}

	@Then("^I redirect to appropriate Page$")
	public void i_redirect_to_appropriate_Page() throws Throwable {
		loginpageinstance.NavigateBack();
	}
}
