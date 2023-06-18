package com.soucedemo.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SouceDemoLogoutPage 
{
	public WebDriver driver;
	@FindBy(xpath = "//button[contains(@id,'react-burger-m')]")
	private WebElement menubar;

	@FindBy(xpath = "//a[contains(@id,'logout')]")
	private WebElement logoutbtn;

	public SouceDemoLogoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnMenuBar() throws InterruptedException 
	{
		menubar.click();
	}
	public void clickLogoutBtn() throws InterruptedException 
	{
		Assert.assertTrue(logoutbtn.isEnabled(), "Logout btn not Enabled ");
		System.out.println("dropdown list Displayed Low To High : "+logoutbtn.isEnabled());
		logoutbtn.click();
	}
}
