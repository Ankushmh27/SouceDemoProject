package com.soucedemo.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SouceDemoHomePage 
{
	public WebDriver driver;
	//Page Factory 
	@FindBy(xpath = "//select[contains(@class,'product_sort')]")
	private WebElement dropdown;

	//Initializing the Page Objects:
	public SouceDemoHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void FilterDropDownItemByName() throws InterruptedException 
	{
		Select select = new Select(dropdown);
		System.out.println("dropdown list Displayed Z To A : "+dropdown.isDisplayed());
		select.selectByValue("za");				
	}
	public void FilterDropDownItemByPrice() throws InterruptedException 
	{
		Select select = new Select(dropdown);
		Assert.assertTrue(dropdown.isDisplayed(), "Dropdown List not Displayed ");
		System.out.println("dropdown list Displayed Low To High : "+dropdown.isDisplayed());		
		select.selectByValue("lohi");			
	}
}
