package TestCases;
import org.openqa.selenium.WebDriver;
import CommonFunctions.TestContext;
import Pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class Click_Forgot_Password {
	
	TestContext testContext;
	public WebDriver driver;
	public LoginPage loginpageinstance; 
	
	public Click_Forgot_Password(TestContext testContext) {
		this.testContext=testContext;
		driver = testContext.getDriver();
		loginpageinstance=testContext.getPageObjectManager().getLoginPage();
	}
	
	@When("^I Click on Forgot Password Link$")
	public void i_Click_on_Forgot_Password_Link() throws Throwable {
		loginpageinstance.forgetPassword();
	}

	@Then("^I redirect to Appropriate Page$")
	public void i_redirect_to_Appropriate_Page() throws Throwable {
		loginpageinstance.NavigateBack();
	}

}
