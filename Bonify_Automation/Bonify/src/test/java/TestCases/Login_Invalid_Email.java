package TestCases;
import org.openqa.selenium.WebDriver;
import CommonFunctions.TestContext;
import Pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class Login_Invalid_Email {
	
	TestContext testContext;
	public WebDriver driver;
	public LoginPage loginpageinstance; 
	
	public Login_Invalid_Email(TestContext testContext) {
		this.testContext=testContext;
		driver = testContext.getDriver();
		loginpageinstance=testContext.getPageObjectManager().getLoginPage();
	}

	@Then("^I sign in to Bonify Application with invalid Email$")
	public void i_sign_in_to_Bonify_Application_with_invalid_Email() throws Throwable {
		loginpageinstance.invalid_Email_Registration();
	}
}
