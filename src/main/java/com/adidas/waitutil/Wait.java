package com.adidas.waitutil;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

 
 
public class Wait {
 static long waitTime=40;
 public static void untilJqueryIsDone(WebDriver driver){
 untilJqueryIsDone(driver, waitTime);
 }
 
 public static void untilJqueryIsDone(WebDriver driver, Long timeoutInSeconds){
 until(driver, (d) ->
 {
 Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
 if (!isJqueryCallDone) System.out.print("");
 return isJqueryCallDone;
 }, timeoutInSeconds);
 }
 
 public static void untilPageLoadComplete(WebDriver driver) {
 untilPageLoadComplete(driver, waitTime);
 }
 
 public static void untilPageLoadComplete(WebDriver driver, Long timeoutInSeconds){
 until(driver, (d) ->
 {
 Boolean isPageLoaded = (Boolean)((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
 if (!isPageLoaded) System.out.println("Document is loading");
 return isPageLoaded;
 }, timeoutInSeconds);
 }
 
 public static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition){
 until(driver, waitCondition, waitTime);
 }
 
 
 @SuppressWarnings("deprecation")
private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, Long timeoutInSeconds){
 WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
 webDriverWait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS);
 try{
 webDriverWait.until(waitCondition);
 }catch (Exception e){
 System.out.println(e.getMessage());
 }          
 }
 
 
}
