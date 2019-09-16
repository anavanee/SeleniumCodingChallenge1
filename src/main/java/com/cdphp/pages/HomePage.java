package com.cdphp.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cdphp.base.TestBase;

public class HomePage extends TestBase {

	
	@FindBy(xpath="//span[contains(@class,'search-input-location-placeholder-1')]") WebElement location;
	
	@FindBy(xpath="//select[@name='results_sort']") WebElement sortBy;
	
	@FindBy(xpath="//ul[@class='listing-results clearfix js-gtm-list']/li//div[@class='listing-results-wrapper']//a[@class='photo-hover']") List <WebElement> properties;
	
	
	public HomePage() throws IOException
	{
		super();
	PageFactory.initElements(driver, this);
	
}
	public String validateHomePageTitle()
	{
		return(driver.getTitle());
		
	}
	
	public boolean validateLocationDisplayed() {
		
		return(location.isDisplayed());
		
	}
	public void EnterLocationandSubmit() throws IOException
	{
		location.sendKeys("London",Keys.ENTER);
		
		
	}
	
	public void sortByPrice() throws IOException
	{
		Select sel=new Select(sortBy);
		sel.selectByVisibleText("Lowest price");
		
		
	}
	
	public void CapturePricesofAllproperties() throws IOException
	{
		System.out.println("NumberoF Properties:"+properties.size());
		for (int i=0;i<properties.size();i++)
				{
			
			System.out.println(properties.get(i).getText());
				}
		
	}
	
	
	public PropertyPage clickonProperty(int number) throws IOException
	{
		
			properties.get(number-1).click();
			return new PropertyPage();
		
	} 
}
