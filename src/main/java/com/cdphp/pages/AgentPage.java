package com.cdphp.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cdphp.base.TestBase;

public class AgentPage extends TestBase {
@FindBy(xpath="//strong[@xpath=1]") WebElement agentName;
	
	public AgentPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public String agentName()
	{
		return agentName.getText();
	}
	

}
