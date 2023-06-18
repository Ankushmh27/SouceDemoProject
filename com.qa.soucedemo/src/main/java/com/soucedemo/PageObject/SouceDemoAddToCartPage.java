package com.soucedemo.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SouceDemoAddToCartPage 
{
	public WebDriver driver;
	//Page Factory 
	@FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-o')]")
	private WebElement addToCartBtn;

	@FindBy(xpath ="//div[text()='Sauce Labs Onesie']")
	private WebElement itemName;
	
	@FindBy(xpath ="//div[contains(@class,'inventory_item_p')]")
	private WebElement itemPrice;
	
	@FindBy(xpath ="//button[text()='Remove']")
	private WebElement removeBtn;
	//Initializing the Page Objects:
	public SouceDemoAddToCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void ClickAddToCartBtn() throws InterruptedException 
	{
		System.out.println("addToCartBtn Displayed : "+addToCartBtn.isDisplayed());
		addToCartBtn.click();		
	}
	public void IteamDetails() throws InterruptedException 
	{
		String ItemName = itemName.getText();
		System.out.println("Item Name : "+ItemName);
		String itemPrices = itemPrice.getText();
		System.out.println("Item Price : "+itemPrices);		
	}	
	public void ClickRemoveItem() throws InterruptedException 
	{
		Assert.assertTrue(removeBtn.isDisplayed(),"Remove Btn not display");
		System.out.println("Click on error Btn : "+removeBtn.isDisplayed());
		removeBtn.click();
	}
}
