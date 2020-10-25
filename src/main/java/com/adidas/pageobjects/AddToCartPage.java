package com.adidas.pageobjects;

import org.openqa.selenium.Alert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	
	@FindBy(how=How.XPATH,using="//a[text()='Add to cart']")
	WebElement addToCartButton;
	
    WebDriver driver;
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addProductToCart(){
		addToCartButton.click();
	}
	
	public String accept_popup(){
		Alert alert= driver.switchTo().alert();
		String alertText=alert.getText();
		alert.accept();
		return alertText;
	}
}
