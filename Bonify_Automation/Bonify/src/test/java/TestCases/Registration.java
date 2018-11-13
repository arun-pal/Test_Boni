package TestCases;
import org.openqa.selenium.WebDriver;
import CommonFunctions.TestContext;
import Pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class Registration {
	
	TestContext testContext;
	public WebDriver driver;
	public LoginPage loginpageinstance; 
	
	public Registration(TestContext testContext) {
		this.testContext=testContext;
		driver = testContext.getDriver();
		loginpageinstance=testContext.getPageObjectManager().getLoginPage();
	}

	@Then("^I redirect to Home Page and Logged out$")
	public void i_redirect_to_Home_Page_and_Logged_out() throws Throwable {
		loginpageinstance.signOut();
	
	}
}
