package com.adidas.managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.adidas.javautil.GenericJavaMethods;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdidasWebDriverInitializer{
	String browserName;
	private WebDriver driver;
	
	public AdidasWebDriverInitializer(){
		browserName=GenericJavaMethods.getInstance().getBrowserName();
	}
	
	public  WebDriver getDriver(){
		if(driver==null) driver=initiateDriver();
		return driver;
	}
	
	public WebDriver initiateDriver(){
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			driver= new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	public void closeDriver(){
		driver.quit();
	}
	
	
}
