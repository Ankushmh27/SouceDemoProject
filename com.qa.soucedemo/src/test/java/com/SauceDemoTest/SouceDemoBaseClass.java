package com.SauceDemoTest;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class SouceDemoBaseClass 
{
	public WebDriver driver;

	@BeforeTest(alwaysRun=true)
	@Parameters("browser")
	public void Setup(String browser) throws Exception 
	{	
		//Check if parameter passed as 'chrome'
		if(browser.equalsIgnoreCase("chrome"))
		{
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver","C://Users//Ankush Mhala//git//repository3//com.qa.soucedemo//Drivers//chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();
		}
		//Check if parameter passed as 'firefox'
		else if(browser.equalsIgnoreCase("firefox"))
		{		
			System.setProperty("webdriver.firefox.marionette","/com.qa.soucedemo/Drivers/geckodriver.exe");
			//create firefox instance		
			driver = new FirefoxDriver();
		}	
		else{
			//If no browser is passed throw exception
			throw new Exception("Incorrect Browser");
		}
		driver.get("https://www.saucedemo.com/");	
		Reporter.log("The SauceDemo Site Launched");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterTest(alwaysRun=true)
	public void TearDown() 
	{
		driver.quit();
		Reporter.log("Quite the driver");
	}
}

