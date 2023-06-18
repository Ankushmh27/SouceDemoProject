package com.soucedemo.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SouceDemoShoppingCartPage 
{
	public WebDriver driver;

	//Page Factory 
	@FindBy(xpath = "//div[contains(@id,'shop')]")
	private WebElement shopCartLink;
	
	@FindBy(xpath ="//button[text()='Remove']")
	private WebElement removeBtn;
	
	@FindBy(xpath ="//div[contains(@class,'summary_info_label ')]")
	private WebElement totalPrice;
	
	@FindBy(id = "finish")
	private WebElement finishBtn;
	
	@FindBy(id = "back-to-products")
	private WebElement backToHome;
	
	//Initializing the Page Objects:
	public SouceDemoShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void ClickOnShoppingCartLink() throws InterruptedException
	{
		Assert.assertTrue(shopCartLink.isDisplayed(),"shopCartLink not displayed");
		System.out.println("Click on shopCartLink Btn : "+shopCartLink.isDisplayed());
		shopCartLink.click();
	}
	public void ClickOnRemoveBtn() throws InterruptedException 
	{
		removeBtn.click();	
	}
	public void CheckTotalPriceWithEmptyItem() 
	{
		String price= totalPrice.getText();
		System.out.println("Empty Cart Price Displayed : "+price);
	}
	public void ClickOnFinishBtn() 
	{
		finishBtn.click();	
	}
	public void ClickOnBackToHomeBtn() 
	{
		backToHome.click();
	}
}
