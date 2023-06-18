package com.SauceDemoTest;
import java.io.IOException;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.soucedemo.PageObject.SauceDemoLoginPage;
import com.soucedemo.PageObject.SouceDemoAddToCartPage;
import com.soucedemo.PageObject.SouceDemoCheckoutPage;
import com.soucedemo.PageObject.SouceDemoHomePage;
import com.soucedemo.PageObject.SouceDemoLogoutPage;
import com.soucedemo.PageObject.SouceDemoShoppingCartPage;
public class SauceDemoTestCases extends SouceDemoBaseClass
{  
	SauceDemoLoginPage login;
	SouceDemoHomePage filter;
	SouceDemoAddToCartPage addtocart;
	SouceDemoShoppingCartPage shopCart;
	SouceDemoCheckoutPage checkout;
	SouceDemoCheckoutPage info;
	SouceDemoLogoutPage logout;
	SoftAssert asserts ;

	@Test(priority = 1)
	public void LoginWithInValidCridential() throws InterruptedException 
	{	//This is negative test case for LoginTest
		login = new SauceDemoLoginPage(driver);
		login.enterUsername("standard_user123");
		Reporter.log("Enter Invalid Username");
		Thread.sleep(1000);
		
		login.enterPassword("secret_sauce123");
		Reporter.log("Enter Invalid Password");
		Thread.sleep(1000);
		
		login.clickOnLoginBtn();
		Reporter.log("Click on Login Button");			
		login.ErrorDisplayText();
		Reporter.log("Get Error Msg");
		Reporter.log("User not login with Invalid credentials");
		Thread.sleep(2000);	
		
		login.ClickonErrorBtn();
		Thread.sleep(1000);	
	}

	@Test(priority = 2)
	public void LoginWithValidCridential() throws InterruptedException 
	{	//This is positive test case for LoginTest
		login = new SauceDemoLoginPage(driver);
		asserts = new SoftAssert();
		
		login.ClearUserName();
		Thread.sleep(1000);
		
		login.enterUsername("standard_user");
		Reporter.log("Enter Valid Username");
		Thread.sleep(1000);
		
		login.ClearPassword();
		Thread.sleep(1000);
		
		login.enterPassword("secret_sauce");
		Reporter.log("Enter Valid Password");
		Thread.sleep(1000);
		
		login.clickOnLoginBtn();
		Reporter.log("Click on Login Button");
		Thread.sleep(1000);	
		
		Reporter.log("User login with valid credentials");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Swag Labs";
		asserts.assertEquals(actualTitle,expectedTitle,"Title not Matched");
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{System.out.println("PageTitle Matched : "+actualTitle);}
		else
		{System.out.println("PageTitle didn't match");}
		Reporter.log("Check Page Title : Test Case Pass");
		asserts.assertAll();
	}

	@Test(priority = 3)
	public void VerifyFiltersDropDown() throws InterruptedException 
	{   //This is positive Test case for Filter Drop-down
		filter = new SouceDemoHomePage(driver);
		filter.FilterDropDownItemByName();
		Reporter.log("Items filter by Name z-a");
		Thread.sleep(1000);	
		
		filter.FilterDropDownItemByPrice();
		Reporter.log("Items filter by Price Low to High");
		Thread.sleep(1000);	
	}

	@Test(priority = 4)
	public void VerifyAddToCartTest() throws InterruptedException 
	{   //This is positive Test case for AddToCardTest
		addtocart = new SouceDemoAddToCartPage(driver);
		addtocart.ClickAddToCartBtn();
		Reporter.log("Click on Add To Cart Btn");
		Reporter.log("Items Added to cart");	
		Thread.sleep(2000);	
		
		addtocart.IteamDetails();
		Reporter.log("Check Item Details");	
	}

	@Test(priority = 5)
	public void VerifyShoppingCartWithEmptyItem() throws InterruptedException 
	{	//This is negative test case for Empty Shopping Cart
		checkout= new SouceDemoCheckoutPage(driver);
		shopCart= new SouceDemoShoppingCartPage(driver);
		shopCart.ClickOnShoppingCartLink();
		Thread.sleep(1000);
		
		Reporter.log("Click on shopping cart link");
		shopCart.ClickOnRemoveBtn();
		Reporter.log("Click on Remove Btn");
		Thread.sleep(1000);
		
		checkout.ClickonCheckoutBtn();
		Reporter.log("Click on Checkout Btn");
		Thread.sleep(1000);
		
		checkout.EnterFname("Ankush");
		checkout.EnterLname("Mhala");
		checkout.EnterZipCode("306308");
		Reporter.log("Enter Fname,LName,ZipCode");
		
		checkout.ClickOnContinueBtn();
		Reporter.log("Click on Continue Btn");
		Thread.sleep(1000);
		
		shopCart.CheckTotalPriceWithEmptyItem();
		Reporter.log("Check total price for Empty card");
		Thread.sleep(2000);
		
		shopCart.ClickOnFinishBtn();
		Reporter.log("Click on Finish Btn");
		Thread.sleep(1000);
		
		shopCart.ClickOnBackToHomeBtn();	
		Reporter.log("Click Back To Home Btn");
		Thread.sleep(1000);
	}

	@Test(priority = 6)
	public void VerifyShoppingCartWithItem() throws InterruptedException 
	{   //This is positive test case for Shopping Cart
		filter = new SouceDemoHomePage(driver);
		filter.FilterDropDownItemByName();
		Reporter.log("Filter Dropdown list by Name Z-A");
		Thread.sleep(1000);	
		
		filter.FilterDropDownItemByPrice();	
		Reporter.log("Filter Dropdown list by price Low to High");
		Thread.sleep(1000);	
		
		addtocart = new SouceDemoAddToCartPage(driver);
		addtocart.ClickAddToCartBtn();
		Reporter.log("Click on AddToCard Btn");
		Thread.sleep(1000);	
		
		addtocart.IteamDetails();
		Thread.sleep(1000);
		
		shopCart = new SouceDemoShoppingCartPage(driver);
		shopCart.ClickOnShoppingCartLink();
		Thread.sleep(1000);
		
		Reporter.log("Click on shopping cart link");
		checkout= new SouceDemoCheckoutPage(driver);
		checkout.ClickonCheckoutBtn();	
		Reporter.log("Click on Checkout Btn");	
		Thread.sleep(1000);		
	}

	@Test(priority = 7)
	public void VerifyCheckoutInfoWithInValidData() throws InterruptedException, IOException 
	{   //This is negative test case for Checkout with invalid data
		info = new SouceDemoCheckoutPage(driver);
		info.EnterFname("Ankush");
		Reporter.log("Enter firstname");
		info.EnterLname("Mhala");
		Reporter.log("Enter lastname");	
		info.EnterZipCode("");	
		Reporter.log("Blank Zip code");
		info.ClickOnContinueBtn();
		Thread.sleep(1000);	
		Reporter.log("Error Msg. : Postal Code is required");		   		
	}

	@Test(priority = 8)
	public void VerifyCheckoutInfoWithValidData() throws InterruptedException 
	{   //This is positive test case for Checkout with valid data
		info = new SouceDemoCheckoutPage(driver);
		info.ClearFname();
		info.EnterFname("Ankush");
		Reporter.log("Enter firstname");
		info.ClearLname();
		info.EnterLname("Mhala");
		Reporter.log("Enter lastname");
		info.ClearZipCode();
		info.EnterZipCode("306308");
		Reporter.log("Enter ZipCode");	
		Thread.sleep(1000);
		
		info.ClickOnContinueBtn();
		Reporter.log("Click on Continue Btn");	
		shopCart = new SouceDemoShoppingCartPage(driver);
		shopCart.ClickOnFinishBtn();
		Reporter.log("Click on Finish Btn");	
		Thread.sleep(1000);
		
		shopCart.ClickOnBackToHomeBtn();	
		Reporter.log("Click on Back Home Btn");	
		Thread.sleep(1000);
	}
	@Test(priority = 9,dependsOnMethods = "LoginWithValidCridential")
	public void LogoutTest() throws InterruptedException 
	{   //This is positive test case for Logout 
		logout = new SouceDemoLogoutPage(driver);
		logout.clickOnMenuBar();
		Reporter.log("Click on MenuBar");
		Thread.sleep(1000);	
		
		logout.clickLogoutBtn();
		Reporter.log("Click on logout btn");
		Reporter.log("User logout");
		Thread.sleep(1000);				
	}
	@Test(priority = 10)
	public void LoginWithEmptyCridential() throws InterruptedException 
	{	//This is negative Test case for Logout with Empty data
		login = new SauceDemoLoginPage(driver);
		asserts = new SoftAssert();
		login.enterUsername("");
		Reporter.log("Blank field Username");	
		Thread.sleep(1000);
		
		login.enterPassword("");
		Reporter.log("Blank field Password");	
		Thread.sleep(1000);
		
		login.clickOnLoginBtn();
		Reporter.log("Click on Login Btn");	
		Reporter.log("Error Msg. Displayed");	
		Thread.sleep(1000);
		Reporter.log("User not login with Empty credentials");		
	}	
}

