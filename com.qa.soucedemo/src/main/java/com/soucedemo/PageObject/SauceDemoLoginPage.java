package com.soucedemo.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SauceDemoLoginPage  
{
	public WebDriver driver;
	//Page Factory 
	@FindBy(id ="user-name")
	private WebElement username;

	@FindBy(id ="password")
	private WebElement password;

	@FindBy(id="login-button")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement errorMsg;
	
	@FindBy(xpath = "//button[@class='error-button']")
	private WebElement errorBtn;
	
	@FindBy(xpath = "//div[contains(@class,'error')]")
	private WebElement passwordError;

	//Initializing the Page Objects:
	public SauceDemoLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void enterUsername(String Username)
	{
		username.sendKeys(Username);		
	}
	public void enterPassword(String Password) 
	{
		password.sendKeys(Password);
	}
	public void clickOnLoginBtn() throws InterruptedException 
	{
		Assert.assertTrue(loginBtn.isDisplayed(),"Not dispalyed error Btn");
		System.out.println("Login Btn Clickable : "+loginBtn.isEnabled());
		loginBtn.click();
	}
	public void ErrorDisplayText() 
	{
		String msg=errorMsg.getText();
		String expectedError= "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(msg,expectedError);
		if(msg.equalsIgnoreCase(expectedError))
		{System.out.println("Error Msg. Displayed on LoginPage: "+msg);}
		else
		{System.out.println("Error not Displayed");}		
	}
	public void ClickonErrorBtn() 
	{	
		Assert.assertTrue(errorBtn.isDisplayed(),"Not dispalyed error Btn");
		System.out.println("Click on error Btn : "+errorBtn.isDisplayed());
		errorBtn.click();			
	}
	public void ClearUserName() 
	{
		username.clear();		
	}
	public void ClearPassword() 
	{
		password.clear();
	}
}
