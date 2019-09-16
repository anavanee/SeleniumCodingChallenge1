package com.cdphp.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.cdphp.base.TestBase;
import com.cdphp.pages.AgentPage;
import com.cdphp.pages.HomePage;
import com.cdphp.pages.PropertyPage;
import com.cdphp.util.TestUtil;

public class PropertyPageTest extends TestBase	 {
	PropertyPage property;
	HomePage home;
	TestUtil util;
	AgentPage agent;
	
	public PropertyPageTest() throws IOException
	{
		super();
		
	}
	
@BeforeMethod
	
	public void setUp() throws IOException
	{
		super.initialization();
		property=new PropertyPage();
		agent= new AgentPage();
		util=new TestUtil();
		property=home.clickonProperty(5);
	}


public void clickOnAgentTest() throws IOException
{
	agent=property.clickOnAgent();
}

}
