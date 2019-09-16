package com.cdphp.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase() throws IOException {
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\cdphp\\config\\config.properties"));
			prop.load(ip);
			
			
		} catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void initialization() {
	String browserName=	prop.getProperty("browser");
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pavit\\Downloads\\chromedriver\\chromedriver.exe");
		 driver=new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.get(prop.getProperty("url"));
	
		
	}

}
