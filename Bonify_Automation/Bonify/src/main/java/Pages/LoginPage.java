package Pages;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonFunctions.Log;
import CommonFunctions.PropertyManager;
import CommonFunctions.SharedDriver;
public class LoginPage {

	private SharedDriver shareddriver;
	WebDriverWait wait;
	
	// All Locators related to the Login page is kept here. 
	private static String EMAIL = "//input[@name='email']";
	private static String PASSWORD = "//input[@name='password']";
	private static String REGISTRATION = "//button[@type='submit']";
	private static String SIGNOUT_DROPDOWN = "//header[@id='main-header']/div/div/div[2]/button";
	private static String SIGNOUT_BUTTON = "//div[@id='main-body']/ul/li[4]/button";	
	private static String FORGOT_PASSWORD = "//div[@id='content']/div/div[2]/div/div[2]/div/form/div[3]/a/span";
	private static String REGISTER_BUTTON = "//button[@type='button']";	
	private static String LOGIN_NAME = "//header[@id='main-header']/div/div/div[2]/button";
	private static String INVALID_USERNAME_PASSOWRD  = "//div[@id='content']/div/div[2]/div/div[2]/div/form/p";		
	
	public LoginPage(SharedDriver shareddriver) {
		this.shareddriver = shareddriver;
	}
	
	// Get Login URL of Bonify
	public void getURL() throws IOException{
		shareddriver.maximizeWindow();
		shareddriver.goToURL(PropertyManager.getProp("Url"));
		Log.info("URL loaded in Browser:" + PropertyManager.getProp("Url"));
	}
	
	// Sign in to Bonify Application.
	public void registration()
	{
		shareddriver.typeText(By.xpath(EMAIL), PropertyManager.getProp("Email"));
		shareddriver.typeText(By.xpath(PASSWORD), PropertyManager.getProp("Password"));
		shareddriver.click(By.xpath(REGISTRATION));
		Log.info("Login to Application");
		shareddriver.waitForElementToBeClickable(By.xpath(LOGIN_NAME));
		String Name = shareddriver.getText(By.xpath(LOGIN_NAME));
		System.out.println("Login Name Is :" + Name);				
	}
	
	// Checking for Invalid Email 
	public void invalid_Email_Registration()
	{
		shareddriver.typeText(By.xpath(EMAIL), PropertyManager.getProp("Invalid_Email"));
		shareddriver.typeText(By.xpath(PASSWORD), PropertyManager.getProp("Password"));
		shareddriver.click(By.xpath(REGISTRATION));
		shareddriver.waitForElementToBeClickable(By.xpath(INVALID_USERNAME_PASSOWRD));
		String Invalid_Email = shareddriver.getText(By.xpath(INVALID_USERNAME_PASSOWRD));
		System.out.println("Error for Email Address Is :" + Invalid_Email);
		
	}
	
	// Checking for Invalid Password
	public void invalid_Password_Registration()
	{
		shareddriver.typeText(By.xpath(EMAIL), PropertyManager.getProp("Email"));
		shareddriver.typeText(By.xpath(PASSWORD), PropertyManager.getProp("Invalid_Password"));
		shareddriver.click(By.xpath(REGISTRATION));
		shareddriver.waitForElementToBeClickable(By.xpath(INVALID_USERNAME_PASSOWRD));
		String Invalid_Password = shareddriver.getText(By.xpath(INVALID_USERNAME_PASSOWRD));
		System.out.println("Error for Password Is :" + Invalid_Password);
		
	}
	
	//  Click on Forgot Password in Login Page.
	public void forgetPassword()
	{
		shareddriver.click(By.xpath(FORGOT_PASSWORD));
		System.out.println("Clicked on Forgot Password Link");
	}
	
	// Signout from Bonify Application.
	public void signOut()
	{
		shareddriver.waitForElementToBeClickable(By.xpath(SIGNOUT_DROPDOWN));
		shareddriver.click(By.xpath(SIGNOUT_DROPDOWN));	
		shareddriver.click(By.xpath(SIGNOUT_BUTTON));	
		System.out.println("Logged out of Bonify Application");
		Log.info("Logged Out of Application");
	}
	
	// Click on Register Link in Login Page
	public void clickRegisterLink()
	{
		shareddriver.click(By.xpath(REGISTER_BUTTON));
		System.out.println("Clicked on Register Button");
	}
	
	// Navigate back to previous Web Page
	public void NavigateBack()
	{
		shareddriver.navigateBack();
	}
					
}