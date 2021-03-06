package com.adidas.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.adidas.javautil.GenericJavaMethods;
import com.adidas.waitutil.Wait;

public class HomePage {

	WebDriver driver;
    static int count=0;
	@FindBy(how=How.XPATH, using="//a[text()='Laptops']")
	WebElement laptopsLink;

	@FindBy(how=How.XPATH, using="//a[text()='Phones']")
	WebElement phonesLink;

	@FindBy(how=How.XPATH, using="//a[text()='Monitors']")
	WebElement monitorsLink;
	
	@FindAll(@FindBy(how=How.XPATH,using="//div[@id='tbodyid']//a[@class='hrefch']"))
	List<WebElement> allLaptops;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void navigateTo_HomePage() {
		driver.get(GenericJavaMethods.getInstance().getHomePageURL());
		Wait.untilPageLoadComplete(driver);
	}
	public void navigateTo_Laptops(){
		laptopsLink.click();
		Wait.untilPageLoadComplete(driver);
	}
	public void navigateTo_Phones(){
		phonesLink.click();
	}
	public void navigateTo_Monitors(){
		monitorsLink.click();
	}
	
	public void select_Laptop(){
		String laptopNames=GenericJavaMethods.getInstance().getLaptopsToBeAdded();
		String[] laptopNameArr= laptopNames.split(",");
		String name=null;
		for(WebElement s : allLaptops){
			try{
			 name= s.getText();
			}catch(Exception e){
				driver.navigate().refresh();
			}
		    if(name.equalsIgnoreCase(laptopNameArr[count])){
				s.click();
				count++;
				break;
			}
			
		}
	}
}
