package CommonFunctions;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SharedDriver extends EventFiringWebDriver {
	
	private static WebDriver driver = getDriver(); 
	private static String parentWindow;
	
	public static WebDriver getDriver() {
   	 String browser = PropertyManager.getProp("Browser");	
   	 if(browser.equalsIgnoreCase("Firefox")){
   		 driver = new FirefoxDriver();
   	 }
   	 else if(browser.equalsIgnoreCase("Chrome")) {   		 
   		System.out.println("Started Chrome....");
   		 driver = new ChromeDriver();
   	 }
   	 
   	 else if(browser.equalsIgnoreCase("HeadLessChrome")){
   		 System.out.println("Started HeadLess Chrome....");
   		 System.setProperty("webdriver.chrome.driver", "/usr/local/chromedriver");
   		 ChromeOptions options = new ChromeOptions();
   	     options.addArguments("--headless");
   	     driver = new ChromeDriver(options);
   	 }
   	 else{
   		 driver = new FirefoxDriver();
   	 }
   	 return driver;
	}
	
	public SharedDriver(){
		super(driver);	
	}
		
	// Provide Below User Define Functions (Repeated function).
	
	public String getText(By Element)
	{
		return driver.findElement(Element).getText();
	}
	
	public String getAttribute(By Element)
	{
		return driver.findElement(Element).getText();
	}
		
	public void maximizeWindow(){
		Log.info("Maximized Window");
		driver.manage().window().maximize();
		parentWindow = driver.getWindowHandle();
	}

	public WebElement findElement(By locator){
		scrollTo(locator);
		return driver.findElement(locator);
	}

	public void goToURL(String url){
		driver.get(url);
	}
	
	public void navigateBack(){
		driver.navigate().back();
	}

	public void click(By locator){
		waitForVisibilityOfElement(locator);
		waitForElementToBeClickable(locator);
		driver.findElement(locator).click();
	}

	public void waitForElementToBeClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 800);
	    wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public void closeDriver(){
		driver.close();
	}

	public void quitDriver(){
		driver.quit();
	}

	public void waitForVisibilityOfElement(By locator){
		WebDriverWait wait = new WebDriverWait(driver, 2000);
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
	}

	public void typeText(By locator, String value){
		WebDriverWait wait = new WebDriverWait(driver, 800);
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
		driver.findElement(locator).clear();
	    driver.findElement(locator).sendKeys(value);
	}	

	public void scrollTo(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 1000);
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
   }	
}