package com.cdphp.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.cdphp.base.TestBase;
import com.cdphp.pages.AgentPage;
import com.cdphp.pages.HomePage;
import com.cdphp.pages.PropertyPage;
import com.cdphp.util.TestUtil;

public class AgentPageTest extends TestBase {
	public AgentPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	PropertyPage property;
	HomePage home;
	TestUtil util;
	AgentPage agent;
	
	
	
@BeforeMethod
	
	public void setUp() throws IOException
	{
		super.initialization();
		property=new PropertyPage();
		agent= new AgentPage();
		util=new TestUtil();
		property=home.clickonProperty(5);
		agent =property.clickOnAgent();
	}

public void agentNameTest()
{
	String expectedAgentName=property.getAgentName();
	String actualAgentName=agent.agentName();
	Assert.assertEquals(actualAgentName, expectedAgentName, "Agent Name mismatch");
}
}
