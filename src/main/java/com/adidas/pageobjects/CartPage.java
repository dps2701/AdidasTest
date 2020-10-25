package com.adidas.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.adidas.javautil.GenericJavaMethods;

public class CartPage {

	@FindBy(how=How.XPATH,using="//a[text()='Cart']")
	WebElement cartLink;


	@FindAll(@FindBy(how=How.XPATH,using="//tbody//tr"))
	List<WebElement> cartPageProducts;

	@FindAll(@FindBy(how=How.XPATH,using="//tbody[@id='tbodyid']//td"))
	List<WebElement> cartPageProductDetails;

	@FindBy(how=How.XPATH,using="//h3[@id='totalp']")
	WebElement totalPrice;

	@FindBy(how=How.XPATH,using="//button[text()='Place Order']")
	WebElement placeOrderButton;

	@FindBy(how=How.XPATH,using="//input[@id='name']")
	WebElement formName;

	@FindBy(how=How.XPATH,using="//input[@id='city']")
	WebElement formCity;

	@FindBy(how=How.XPATH,using="//input[@id='country']")
	WebElement formCountry;

	@FindBy(how=How.XPATH,using="//input[@id='card']")
	WebElement formCard;

	@FindBy(how=How.XPATH,using="//input[@id='month']")
	WebElement formMonth;

	@FindBy(how=How.XPATH,using="//input[@id='year']")
	WebElement formYear;

	@FindBy(how=How.XPATH,using="//button[text()='Purchase']")
	WebElement purchaseButton;

	@FindBy(how=How.XPATH,using="//p[@class='lead text-muted ']")
	WebElement purchaseIdAndAmount;
	
	@FindBy(how=How.XPATH,using="//button[text()='OK']")
	WebElement okButton;

	WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateTo_CartPage(){
		cartLink.click();
	}
	public boolean validateCartDetails(){
		boolean flag=false;
		int totalProductsInCart= cartPageProducts.size();
		int totalProductsAdded=GenericJavaMethods.getInstance().getLaptopsToBeAdded().split(",").length;
		if(totalProductsAdded==totalProductsInCart){
			flag=true;
		}
		return flag;
	}

	//This method will deleteAll the similar products if 'ifSimilarDeleteAll' is true
	public void deleteProduct(boolean ifSimilarDeleteAll){
		String proudctName=GenericJavaMethods.getInstance().getLaptopsToBeDeleted();
		try{
			for(WebElement ele : cartPageProductDetails){
				try{
					String cartPageProductName=ele.getText();
					if(cartPageProductName.equalsIgnoreCase(proudctName)){
						List<WebElement> deleteEle=	driver.findElements(By.xpath
								("//tbody[@id='tbodyid']//td[text()='"+proudctName+"']/following-sibling::td//a"));
						if(deleteEle.size()>1){
							if(ifSimilarDeleteAll){
								for(int i=0; i<deleteEle.size();i++){
									deleteEle.get(i).click();
								}
							}else{
								deleteEle.get(0).click();
							}
						}else{
							deleteEle.get(0).click();
						}

					}
				}catch(Exception e){
					System.out.println("Table data does not have the required text");
				}
			}
		}catch(Exception e){
			throw new RuntimeException("Product asked to be deleted is not added to the cart yet");
		}
	}

	public String getTotalPrice(){
		return totalPrice.getText();
	}

	public void clickOnPlaceOrderButton(){
		placeOrderButton.click();
	}

	public void fillPurchaseForm(String name, String country, String city, String card, String mon, String year) throws InterruptedException{
		Thread.sleep(1000);
		formName.sendKeys(name);
		Thread.sleep(1000);
		formCity.sendKeys(city);
		Thread.sleep(1000);
		formCountry.sendKeys(country);
		Thread.sleep(1000);
		formCard.sendKeys(card);
		Thread.sleep(1000);
		formMonth.sendKeys(mon);
		Thread.sleep(1000);
		formYear.sendKeys(year);
		Thread.sleep(1000);
	}

	public void clickOnPurchase(){
		purchaseButton.click();
	}
	
	public void clickOnOK(){
		okButton.click();
	}

	public String getPurchaseIdAndAmount(){
		return purchaseIdAndAmount.getText();
	}
}
