package com.soucedemo.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SouceDemoCheckoutPage 
{
	public WebDriver driver;
	//Page Factory 
	@FindBy(id = "checkout")
	private WebElement checkout;

	@FindBy(id = "first-name")
	private WebElement Fname;

	@FindBy(id = "last-name")
	private WebElement Lname;

	@FindBy(id = "postal-code")
	private WebElement Zip;

	@FindBy(id = "continue")
	private WebElement continueBtn;

	//Initializing the Page Objects:
	public SouceDemoCheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void ClickonCheckoutBtn() throws InterruptedException
	{
		Assert.assertTrue(checkout.isEnabled(),"checkout Btn not enable");
		System.out.println("Click on error Btn : "+checkout.isEnabled());
		checkout.click();	
	}
	public void EnterFname(String fName) throws InterruptedException 
	{
		Fname.sendKeys(fName);
	}
	public void EnterLname(String lName) throws InterruptedException 
	{
		Lname.sendKeys(lName);
	}
	public void EnterZipCode(String zip) throws InterruptedException 
	{
		Zip.sendKeys(zip);
	}
	public void ClickOnContinueBtn() throws InterruptedException 
	{
		continueBtn.click();
	}
	public void ClearFname() throws InterruptedException 
	{
		Fname.clear();	
	}
	public void ClearLname() throws InterruptedException 
	{
		Lname.clear();
	}
	public void ClearZipCode() throws InterruptedException 
	{
		Zip.clear();	
	}
}
