package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;


public class MobileLocatorMethods{
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Dec 2017  ***//
	//***                                  ***//
	//****************************************//

	public static final int TIME_OUT_IN_SECONDS = 30;
	

    public static  WebElement waitAndGetVisibleElementById(AppiumDriver<?> driver, String locatorid) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
    	ReadProperties.retrieveProperty();
    	String locid = ReadProperties.webLocatorProp.getProperty(locatorid);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locid)));
        return element;
    }
    
    public static void clickById(AppiumDriver<?> driver, String locatorid) {
    	WebElement element = MobileLocatorMethods.waitAndGetVisibleElementById(driver, locatorid);
        element.click();
    }
    
    
    
    public static  WebElement waitAndGetVisibleElementByClassName(AppiumDriver<?> driver, String locatorclass) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        ReadProperties.retrieveProperty();
    	String locclass = ReadProperties.webLocatorProp.getProperty(locatorclass);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locclass)));
        return element;
    }
    
    
    public static void clickByClassName(AppiumDriver<?> driver, String locatorClass) {
        WebElement element = MobileLocatorMethods.waitAndGetVisibleElementByClassName(driver, locatorClass);
        element.click();
    }
    
    
    public static WebElement waitAndGetVisibleElementByName(AppiumDriver<?> driver, String locatorname) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        ReadProperties.retrieveProperty();
    	String locname= ReadProperties.webLocatorProp.getProperty(locatorname);
    	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locname)));
        return element;
    }
    
    public static void clickByName(AppiumDriver<?> driver, String locatorName) {
        WebElement element = MobileLocatorMethods.waitAndGetVisibleElementByName(driver, locatorName);
        element.click();
    }
    
    
    
    public static WebElement waitAndGetVisibleElementByXpath(AppiumDriver<?> driver, String locatorxpath) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        ReadProperties.retrieveProperty();
    	String locxpath = ReadProperties.webLocatorProp.getProperty(locatorxpath);
    	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locxpath)));
    	System.out.println("gettext for element: "+element.getText());
        return element;
    }
    
    
    public static void clickByXpath(AppiumDriver<?> driver, String locatorxpath) {
        WebElement element = MobileLocatorMethods.waitAndGetVisibleElementByXpath(driver, locatorxpath);
        element.click();
    }
    
    
    public static WebElement waitAndGetVisibleElementByCSS(AppiumDriver<?> driver, String locatorCSS) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        ReadProperties.retrieveProperty();
    	String loccss = ReadProperties.webLocatorProp.getProperty(locatorCSS);
    	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loccss)));
        return element;
    }
    
    
    public static void clickByCssSelector(AppiumDriver<?> driver, String locatorCSS) {
        WebElement element = MobileLocatorMethods.waitAndGetVisibleElementByCSS(driver, locatorCSS);
        element.click();
    }
    
    
    
    public static void sendKeysIntoElementById(AppiumDriver<?> driver, String locatorid, String keys) {
        WebElement element = MobileLocatorMethods.waitAndGetVisibleElementById(driver, locatorid);
        element.clear();
        element.sendKeys(keys);
    }
    
    public static void sendKeysIntoElementByClassName(AppiumDriver<?> driver, String locatorclass, String keys) {
        WebElement element = MobileLocatorMethods.waitAndGetVisibleElementByClassName(driver, locatorclass);
        element.clear();
        element.sendKeys(keys);
    }
    
    public static void sendKeysIntoElementByName(AppiumDriver<?> driver, String locatorname, String keys) {
        WebElement element = MobileLocatorMethods.waitAndGetVisibleElementByName(driver, locatorname);
        element.clear();
        element.sendKeys(keys);
    }
    
    public static void sendKeysIntoElementByXpath(AppiumDriver<?> driver, String locatorxpath, String keys) {
        WebElement element = MobileLocatorMethods.waitAndGetVisibleElementByXpath(driver, locatorxpath);
        element.clear();
        element.sendKeys(keys);
    }

    public static void sendKeysIntoElementByCSS(AppiumDriver<?> driver, String locatorCSS, String keys) {     
        WebElement element = MobileLocatorMethods.waitAndGetVisibleElementByCSS(driver, locatorCSS);
        element.clear();
        element.sendKeys(keys);
    }
    
    
    
    
    
    public static String getTextById(AppiumDriver<?> driver, String locatorid) {
        WebElement element = MobileLocatorMethods.waitAndGetVisibleElementById(driver, locatorid);
        return element.getText();
    }
    
    public static String getTextByClassName(AppiumDriver<?> driver, String locatorClass) {
        WebElement element = MobileLocatorMethods.waitAndGetVisibleElementByClassName(driver, locatorClass);
        return element.getText();
    }
    
    public static String getTextByName(AppiumDriver<?> driver, String locatorName) {
        WebElement element = MobileLocatorMethods.waitAndGetVisibleElementByName(driver, locatorName);
        return element.getText();
    }
    
    public static String getTextByXpath(AppiumDriver<?> driver, String locatorxpath) {
        WebElement element = MobileLocatorMethods.waitAndGetVisibleElementByXpath(driver, locatorxpath);
        return element.getText();
    }
    
    public static String getTextByCssSelector(AppiumDriver<?> driver, String locatorCSS) {
        WebElement element = MobileLocatorMethods.waitAndGetVisibleElementByCSS(driver, locatorCSS);
        return element.getText();
    }
    
   
   public static void tapById (AppiumDriver<?> driver, String locatorid){
	   WebElement element = MobileLocatorMethods.waitAndGetVisibleElementById(driver, locatorid);
	   TouchAction t = new TouchAction(driver);
	   t.tap(element).perform();
   }
    
   
   public static void tapByClass (AppiumDriver<?> driver, String locatorClass){
	   WebElement element = MobileLocatorMethods.waitAndGetVisibleElementByClassName(driver, locatorClass);
	   TouchAction t = new TouchAction(driver);
	   t.tap(element).perform();
   }
   
   public static void tapByName (AppiumDriver<?> driver, String locatorName){
	   WebElement element = MobileLocatorMethods.waitAndGetVisibleElementByName(driver, locatorName);
	   TouchAction t = new TouchAction(driver);
	   t.tap(element).perform();
   }
   
   public static void tapByXpath (AppiumDriver<?> driver, String locatorxpath){
	   WebElement element = MobileLocatorMethods.waitAndGetVisibleElementByXpath(driver, locatorxpath);
	   TouchAction t = new TouchAction(driver);
	   t.tap(element).perform();
   }
   
   public static void tapByCSS (AppiumDriver<?> driver, String locatorCSS){
	   WebElement element = MobileLocatorMethods.waitAndGetVisibleElementByCSS(driver, locatorCSS);
	   TouchAction t = new TouchAction(driver);
	   t.tap(element).perform();
   }
    
   
   public static void longPressByXpath (AppiumDriver<?> driver, String locatorxpath){
	   WebElement element = MobileLocatorMethods.waitAndGetVisibleElementByXpath(driver, locatorxpath);
	   TouchAction t = new TouchAction(driver);
	   t.longPress(element).release().perform();
   }

   

    public static void swipeLeft(AppiumDriver<?> appiumDriver) {
        Dimension size = appiumDriver.manage().window().getSize();
        int startx = (int) (size.width * 0.2);
        int endx = (int) (size.width * 0.8);
        int starty = size.height / 2;
        new TouchAction(appiumDriver).press(startx, starty).waitAction().moveTo(endx, starty).release().perform();

    }

    public static void swipeRight(AppiumDriver<?> appiumDriver) {
        Dimension size = appiumDriver.manage().window().getSize();
        int startx = (int) (size.width * 0.8);
        int endx = (int) (size.width * 0.2);
        int starty = size.height / 2;
        new TouchAction(appiumDriver).press(startx, starty).waitAction().moveTo(endx, starty).release().perform();

    }

    public static void swipeUp(AppiumDriver<?> appiumDriver) {
        Dimension size = appiumDriver.manage().window().getSize();
        int starty = (int) (size.height * 0.2);
        int endy = (int) (size.height * 0.8);
        int startx = size.width / 2;
        new TouchAction(appiumDriver).press(startx, starty).waitAction().moveTo(startx, endy).release().perform();

    }

    public static void swipeDown(AppiumDriver<?> appiumDriver) {
        Dimension size = appiumDriver.manage().window().getSize();
        int starty = (int) (size.height * 0.8);
        int endy = (int) (size.height * 0.2);
        int startx = size.width / 2;
        new TouchAction(appiumDriver).press(startx, starty).waitAction().moveTo(startx, endy).release().perform();

    }
    
    
}















