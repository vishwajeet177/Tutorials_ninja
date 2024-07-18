package com.qa.testlayer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pagelayer.Homepage;
import com.qa.testbase.Testbase;

public class Testcase_001 extends Testbase
{
	@Test
	public void testCase_001() throws InterruptedException
	{
		Homepage home = new Homepage();
		home.enterTextIntoSearchBox();
		home.clickOnSearchButton();
		home.clickOnAddToCartButton();
		home.clickOnAddToCartButton();
		
		Thread.sleep(1000);
		
		String actualSuccessMessage = driver.findElement(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).getText();
	
		String expectedSuccessMessage = "Success: You have added MacBook to your shopping cart!";
	
		if(actualSuccessMessage.contains(expectedSuccessMessage))
		{
			System.out.println("Success message displayed correctly");
		}
		
		home.clickOnShoppingCartButton();
		home.clickOnViewCartButton();
		
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://tutorialsninja.com/demo/index.php?route=checkout/cart";
		
		if(actualURL.equals(expectedURL))
		{
			System.out.println("URL of the page displayed correctly");
		}
		
		// Assertion to check Unit Price
		String actualUnitPrice = driver.findElement(By.xpath("(//td[@class = 'text-right'])[13]")).getText();
		String expectedUnitPrice = "$602.00";
		Assert.assertEquals(actualUnitPrice, expectedUnitPrice);
		System.out.println("Unit Price Displayed Correctly");
		
		// Assertion to check Total Price
		String actualTotalPrice = driver.findElement(By.xpath("(//td[@class = 'text-right'])[14]")).getText();
		String expectedTotalPrice = "$1,204.00";
		Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
		System.out.println("Total Price Displayed Correctly");
		
	
	}
}
