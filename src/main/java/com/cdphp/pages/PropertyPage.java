package com.cdphp.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cdphp.base.TestBase;

public class PropertyPage extends TestBase{

	
	@FindBy(xpath="//h4[@class='ui-agent__name']") WebElement agentName;
	
	
	public PropertyPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	public AgentPage clickOnAgent() throws IOException

	{
		
		agentName.click();
		return new AgentPage();
	}
	public String getAgentName()
	{
		return agentName.getText();
}
}
