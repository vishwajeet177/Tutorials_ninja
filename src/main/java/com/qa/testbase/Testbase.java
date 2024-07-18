package com.qa.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Testbase 
{
public static WebDriver driver;
	
	@BeforeMethod
	@Parameters("browser")
	public void setUP(String browser)
	{
		switch(browser.toLowerCase())
		{
		
			case "chrome" :
				driver = new ChromeDriver();
				driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
				break;
				
			case "firefox" :
				driver = new FirefoxDriver();
				driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
				break;
				
			default :
			driver = null;
			break;
		}

	
		// Window Maximize
		driver.manage().window().maximize();
		
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Handle Cookies
		driver.manage().deleteAllCookies();
	}
	
	@AfterMethod
	public void tearDown()
	{
		
		driver.quit();
	}
}
