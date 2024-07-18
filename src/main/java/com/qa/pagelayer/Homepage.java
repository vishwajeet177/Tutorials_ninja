package com.qa.pagelayer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.Testbase;

public class Homepage extends Testbase
{
	// public constuctor to initialize the variables
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//=================================================================
	
	// Search MacBook in Search box
	@FindBy (css = "div#search")
	private WebElement searchBox;
	
	// Click on Search Button
	@FindBy (xpath = "//span[@class = 'input-group-btn']")
	private WebElement searchButton;
	
	// Click on ADD TO CART Button
	@FindBy (xpath = "(//span[text() = 'Add to Cart'])[1]")
	private WebElement addToCart;
	
	// Click on shopping cart
	@FindBy (id = "cart-total")
	private WebElement shoppingCartButton;
	
	// Click on View Cart Button
	@FindBy (xpath = "//p[@class = 'text-right']/descendant::i[1]")
	private WebElement viewCartButton;
	
	
	//===================================================================
	
	
	// corresponding methods to perform different actions on different webelements
	
	public void enterTextIntoSearchBox() throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.click(searchBox).build().perform();
		act.sendKeys(searchBox, "MacBook").build().perform();
	}
	
	public void clickOnSearchButton() throws InterruptedException
	{
		Thread.sleep(1000);
		searchButton.click();
	}
	
	public void clickOnAddToCartButton() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		
		Thread.sleep(1000);
		addToCart.click();
	}
	
	public void clickOnShoppingCartButton() throws InterruptedException
	{
		Thread.sleep(1000);
		shoppingCartButton.click();
	}
	
	public void clickOnViewCartButton() throws InterruptedException
	{
		Thread.sleep(1000);
		viewCartButton.click();
	}
}
