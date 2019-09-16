package com.cdphp.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cdphp.base.TestBase;
import com.cdphp.pages.HomePage;

import com.cdphp.pages.PropertyPage;
import com.cdphp.util.TestUtil;

public class HomePageTest extends TestBase {
	PropertyPage property;
	HomePage home;
	TestUtil util;

	public HomePageTest() throws IOException
	{
		super();
		
	}
	
	@BeforeMethod
	
	public void setUp() throws IOException
	{
		super.initialization();
		property=new PropertyPage();
		util=new TestUtil();
		
	}
@Test(priority=1)
	
	public void homePageTitleTest() throws IOException
	{
		String title=home.validateHomePageTitle();
		util.takeScreenShot();
		Assert.assertEquals(title, "Search Property to Buy, Rent, House Prices, Estate Agents","Home Page Title does not match");
	}
@Test(priority=2)
public void validateLocationDisplayedTest()
{
	//util.switchFrame("mainpanel");
	Assert.assertTrue(home.validateLocationDisplayed(),"Location Text Box not displayed properly");
}

@Test(priority=3)
public void EnterLocationandSubmitTest() throws IOException
{
	home.EnterLocationandSubmit();
}
@Test(priority=4)
public void sortByPriceTest() throws IOException
{
	home.sortByPrice();
}

public void CapturePricesofAllpropertiesTest() throws IOException
{
	home.CapturePricesofAllproperties();
}

public void clickonPropertyTest() throws IOException
{
	property=home.clickonProperty(5);
}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
