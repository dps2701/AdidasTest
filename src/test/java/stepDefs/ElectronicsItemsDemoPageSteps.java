package stepDefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adidas.javautil.GenericJavaMethods;
import com.adidas.managers.AdidasWebDriverInitializer;
import com.adidas.pageobjects.AddToCartPage;
import com.adidas.pageobjects.CartPage;
import com.adidas.pageobjects.HomePage;
import com.adidas.waitutil.Wait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.*;

public class ElectronicsItemsDemoPageSteps {
    
	AdidasWebDriverInitializer adidasWebDriverInitializer;
	WebDriver driver;
	HomePage homePage;
	AddToCartPage adToCartPage;
	CartPage cartPage;
	static String totalPrice;
	
	
	@Given("I am on HomePage")
	public void i_am_on_HomePage() {
		adidasWebDriverInitializer= new AdidasWebDriverInitializer();
		driver=adidasWebDriverInitializer.getDriver();
		homePage= new HomePage(driver);
		adToCartPage= new AddToCartPage(driver);
		cartPage= new CartPage(driver);
		homePage.navigateTo_HomePage();
		
	}

	@When("I select laptop")
	public void i_select_laptop() throws InterruptedException {
		
	    homePage.navigateTo_Laptops();
	    Wait.untilJqueryIsDone(driver);
	    homePage.select_Laptop();
	}

	@SuppressWarnings("deprecation")
	@When("I add it to cart")
	public void i_add_it_to_cart() {
		Wait.untilPageLoadComplete(driver);
	    adToCartPage.addProductToCart();
	    new WebDriverWait(driver, 20).pollingEvery(1,TimeUnit.SECONDS).until(ExpectedConditions.alertIsPresent());
	}
	@When("I accept the popup")
	public void i_accept_the_popup() throws InterruptedException {
	
		String alertMessage=adToCartPage.accept_popup();
		Assert.assertEquals("Product added", alertMessage);
		Wait.untilJqueryIsDone(driver);
		homePage.navigateTo_HomePage();
	}

	@When("I navigate to cart page")
	public void i_navigate_to_cart_page() throws InterruptedException {
	    cartPage.navigateTo_CartPage();
	    Wait.untilPageLoadComplete(driver);
	}

	@Then("I should see both the laptops on cart page")
	public void i_should_see_both_the_laptops_on_cart_page() {
	  Wait.untilJqueryIsDone(driver);
	 boolean isCartDetailsValid=  cartPage.validateCartDetails();
	 Assert.assertTrue(isCartDetailsValid);
	}

	@When("I delete laptop")
	public void i_delete_laptop() throws InterruptedException {
		Wait.untilJqueryIsDone(driver);
	   cartPage.deleteProduct(false);
	  Wait.untilJqueryIsDone(driver);
	  Wait.untilPageLoadComplete(driver);
	   
	}

	@When("I click on place order")
	public void i_click_on_place_order() {
	   totalPrice= cartPage.getTotalPrice();
	   cartPage.clickOnPlaceOrderButton();
	}

	@When("I fill the form with all the details")
	public void i_fill_the_form_with_all_the_details() throws InterruptedException {
	    cartPage.fillPurchaseForm("dps", "india", "india", "234", "4", "3456");
	}

	@When("I click on Purchase")
	public void i_click_on_Purchase() {
	 cartPage.clickOnPurchase();
	}

	@Then("I should see purchase id and expected total amount")
	public void i_should_see_purchase_id_and_expected_total_amount() throws ConfigurationException {
	    String purchaseIdAnAmount=cartPage.getPurchaseIdAndAmount();
	    String[] arr=purchaseIdAnAmount.split("\n");
	    
	    //Setting the purchase Id in config file for future reference
	    GenericJavaMethods.getInstance().setProperty("PurchaseId", arr[0].split(":")[1].trim());
	    Assert.assertEquals(totalPrice, arr[1].split(":")[1].trim().split(" ")[0].trim());
	    
	}

	@Then("I click on Ok button")
	public void i_click_on_Ok_button() {
	   cartPage.clickOnOK();
	   adidasWebDriverInitializer.closeDriver();
	   
	}
	

}
