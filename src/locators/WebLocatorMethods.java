package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebLocatorMethods{
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Dec 2017  ***//
	//***                                  ***//
	//****************************************//


	
	
	//Methods4AddPlace
	public static int placeSizeByXpath(WebDriver webdriver, String placename, String locatorxpath, int seconds) throws InterruptedException
	{
		ReadProperties.retrieveProperty();
		String locxpath = ReadProperties.webLocatorProp.getProperty(locatorxpath);
		locxpath = locxpath+"[contains(text(), '"+placename+"')]";
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locxpath)));		 
		int isitpresent = elements.size();		
		return isitpresent;
	}
	
	//Methods4AddPlace
    public static String placeGetTextByXpath(WebDriver webdriver, String placename, String locatorxpath, int seconds) {
      	ReadProperties.retrieveProperty();
		String locxpath = ReadProperties.webLocatorProp.getProperty(locatorxpath);
		locxpath = locxpath+"[contains(text(), '"+placename+"')]";
        WebDriverWait wait = new WebDriverWait(webdriver, seconds);	
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locxpath)));
        WebElement element = webdriver.findElement(By.xpath(locxpath));
        return element.getText();
    }
	
	//Methods4AddPlace
    public static String placeAddressGetTextByXpath(WebDriver webdriver, String finalsavedaddress, String locatorxpath, int seconds) {
      	ReadProperties.retrieveProperty();
		String locxpath = ReadProperties.webLocatorProp.getProperty(locatorxpath);
		locxpath = locxpath+"[contains(text(), '"+finalsavedaddress+"')]";
        WebDriverWait wait = new WebDriverWait(webdriver, seconds);	
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locxpath)));
        WebElement element = webdriver.findElement(By.xpath(locxpath));
        return element.getText();
    }
    
    //Methods4AddPlace
    public static void selectPlaceClickByXpath(WebDriver webdriver, String placename, String locatorxpath, int seconds) {
    	    ReadProperties.retrieveProperty();
		String locxpath = ReadProperties.webLocatorProp.getProperty(locatorxpath);
		locxpath = locxpath+"[contains(text(), '"+placename+"')]";
		System.out.println("locxpath: "+locxpath);
        WebDriverWait wait = new WebDriverWait(webdriver, seconds);	
    		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locxpath)));
    		JavascriptExecutor executor = (JavascriptExecutor) webdriver;
    		executor.executeScript("arguments[0].click();", element);
    }
    
    
	//Methods4AddLocationBasedAlert
    public static void javscriptexecutorScrollIntoViewContainingTextByID (WebDriver webdriver, String placename, String locatorID, int seconds)
    {
	 	//retrieves webalertaddedinlist.xpath parameter for locator which is equal to //p and change to //p[contains(text(), '"+placename+"')]
		ReadProperties.retrieveProperty();
	    String locid = ReadProperties.webLocatorProp.getProperty(locatorID);
	    locid = locid + "[contains(text(), '"+placename+"')]";
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locid)));
        WebElement element = webdriver.findElement(By.id(locid));
		JavascriptExecutor executor = (JavascriptExecutor) webdriver;
		executor.executeScript("arguments[0].scrollIntoView();",element);
	}
    
	//Methods4AddLocationBasedAlert
    public static void javscriptexecutorScrollIntoViewContainingTextByClass (WebDriver webdriver, String placename, String locatorClass, int seconds)
    {
	 	//retrieves webalertaddedinlist.xpath parameter for locator which is equal to //p and change to //p[contains(text(), '"+placename+"')]
		ReadProperties.retrieveProperty();
	    String locclass = ReadProperties.webLocatorProp.getProperty(locatorClass);
	    locclass = locclass + "[contains(text(), '"+placename+"')]";
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locclass)));
        WebElement element = webdriver.findElement(By.className(locclass));
		JavascriptExecutor executor = (JavascriptExecutor) webdriver;
		executor.executeScript("arguments[0].scrollIntoView();",element);
	}
    
	//Methods4AddLocationBasedAlert
    public static void javscriptexecutorScrollIntoViewContainingTextByName (WebDriver webdriver, String placename, String locatorName, int seconds)
    {
	 	//retrieves webalertaddedinlist.xpath parameter for locator which is equal to //p and change to //p[contains(text(), '"+placename+"')]
		ReadProperties.retrieveProperty();
	    String locname = ReadProperties.webLocatorProp.getProperty(locatorName);
	    locname = locname + "[contains(text(), '"+placename+"')]";
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locname)));
        WebElement element = webdriver.findElement(By.name(locname));
		JavascriptExecutor executor = (JavascriptExecutor) webdriver;
		executor.executeScript("arguments[0].scrollIntoView();",element);
	}
    
	//Methods4AddLocationBasedAlert
    public static void javscriptexecutorScrollIntoViewContainingTextByXpath (WebDriver webdriver, String placename, String locatorxpath, int seconds)
    {
	 	//retrieves webalertaddedinlist.xpath parameter for locator which is equal to //p and change to //p[contains(text(), '"+placename+"')]
		ReadProperties.retrieveProperty();
	    String locxpath = ReadProperties.webLocatorProp.getProperty(locatorxpath);
	    locxpath = locxpath + "[contains(text(), '"+placename+"')]";
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locxpath)));
        WebElement element = webdriver.findElement(By.xpath(locxpath));
		JavascriptExecutor executor = (JavascriptExecutor) webdriver;
		executor.executeScript("arguments[0].scrollIntoView();",element);
	}
    
	//Methods4AddLocationBasedAlert
    public static void javscriptexecutorScrollIntoViewContainingTextByCSS (WebDriver webdriver, String placename, String locatorCSS, int seconds)
    {
	 	//retrieves webalertaddedinlist.xpath parameter for locator which is equal to //p and change to //p[contains(text(), '"+placename+"')]
		ReadProperties.retrieveProperty();
	    String locCSS = ReadProperties.webLocatorProp.getProperty(locatorCSS);
	    locCSS = locCSS + "[contains(text(), '"+placename+"')]";
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locCSS)));
        WebElement element = webdriver.findElement(By.cssSelector(locCSS));
		JavascriptExecutor executor = (JavascriptExecutor) webdriver;
		executor.executeScript("arguments[0].scrollIntoView();",element);
	}
    
    
    public static List <WebElement> arrayofelementsbyID (WebDriver webdriver, String locatorID, int seconds)
    {
    		ReadProperties.retrieveProperty();
		String locid = ReadProperties.webLocatorProp.getProperty(locatorID);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(locid)));		 
	    return elements;
    }
    
    public static List <WebElement> arrayofelementsbyClass (WebDriver webdriver, String locatorClass, int seconds)
    {
    		ReadProperties.retrieveProperty();
		String locclass = ReadProperties.webLocatorProp.getProperty(locatorClass);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(locclass)));		 
	    return elements;
    }
    
    public static List <WebElement> arrayofelementsbyName (WebDriver webdriver, String locatorName, int seconds)
    {
    		ReadProperties.retrieveProperty();
		String locname = ReadProperties.webLocatorProp.getProperty(locatorName);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(locname)));		 
	    return elements;
    }
    
    public static List <WebElement> arrayofelementsbyCSS (WebDriver webdriver, String locatorCSS, int seconds)
    {
    		ReadProperties.retrieveProperty();
		String loccss = ReadProperties.webLocatorProp.getProperty(locatorCSS);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(loccss)));		 
    	    return elements;
    }
    
    public static List <WebElement> arrayofelementsbyXpath (WebDriver webdriver, String locatorXpath, int seconds)
    {
    		ReadProperties.retrieveProperty();
		String locxpath = ReadProperties.webLocatorProp.getProperty(locatorXpath);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locxpath)));		 
	    return elements;
    }
    
	public static int sizeByID(WebDriver webdriver, String locatorID, int seconds) throws InterruptedException
	{
		ReadProperties.retrieveProperty();
		String locid = ReadProperties.webLocatorProp.getProperty(locatorID);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(locid)));			
		int isitpresent = elements.size();		
		return isitpresent;
	}
	
	public static int sizeByName(WebDriver webdriver, String locatorName, int seconds) throws InterruptedException
	{
		ReadProperties.retrieveProperty();
		String locname = ReadProperties.webLocatorProp.getProperty(locatorName);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(locname)));			
		int isitpresent = elements.size();		
		return isitpresent;
	}
	
	public static int sizeByClass(WebDriver webdriver, String locatorClass, int seconds) throws InterruptedException
	{
		ReadProperties.retrieveProperty();
		String locclass = ReadProperties.webLocatorProp.getProperty(locatorClass);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(locclass)));			
		int isitpresent = elements.size();			
		return isitpresent;
	}
	
	public static int sizeByXpath(WebDriver webdriver, String locatorxpath, int seconds) throws InterruptedException
	{
		ReadProperties.retrieveProperty();
		String locxpath = ReadProperties.webLocatorProp.getProperty(locatorxpath);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locxpath)));			
		int isitpresent = elements.size();		
		return isitpresent;
	}
	
	public static int sizeByCSS(WebDriver webdriver, String locatorCSS, int seconds) throws InterruptedException
	{
		ReadProperties.retrieveProperty();
		String loccss = ReadProperties.webLocatorProp.getProperty(locatorCSS);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(loccss)));			
		int isitpresent = elements.size();	
		return isitpresent;
	}

	
	public static Boolean existsSizeNotZeroByID(WebDriver webdriver, String locatorID, int seconds) throws InterruptedException
	{
		ReadProperties.retrieveProperty();
		String locid = ReadProperties.webLocatorProp.getProperty(locatorID);
		Boolean exists = webdriver.findElements(By.id(locid)).size() != 0;				
		return exists;
	}
	
	public static Boolean existsSizeNotZeroByName(WebDriver webdriver, String locatorName, int seconds) throws InterruptedException
	{
		ReadProperties.retrieveProperty();
		String locname = ReadProperties.webLocatorProp.getProperty(locatorName);		
		Boolean exists = webdriver.findElements(By.name(locname)).size() != 0;				
		return exists;
	}
	
	public static Boolean existsSizeNotZeroByClass(WebDriver webdriver, String locatorClass, int seconds) throws InterruptedException
	{
		ReadProperties.retrieveProperty();
		String locclass = ReadProperties.webLocatorProp.getProperty(locatorClass);		
		Boolean exists = webdriver.findElements(By.className(locclass)).size() != 0;				
		return exists;
	}
	
	public static Boolean existsSizeNotZeroByXpath(WebDriver webdriver, String locatorxpath, int seconds) throws InterruptedException
	{
		ReadProperties.retrieveProperty();
		String locxpath = ReadProperties.webLocatorProp.getProperty(locatorxpath);	
		Boolean exists = webdriver.findElements(By.xpath(locxpath)).size() != 0;				
		return exists;
	}
	
	public static Boolean existsSizeNotZeroByCSS(WebDriver webdriver, String locatorCSS, int seconds) throws InterruptedException
	{
		ReadProperties.retrieveProperty();
		String loccss = ReadProperties.webLocatorProp.getProperty(locatorCSS);		
		Boolean exists = webdriver.findElements(By.cssSelector(loccss)).size() != 0;				
		return exists;
	}
	
	
	public static Boolean isSelectedById (WebDriver webdriver, String locatorid, int seconds) throws InterruptedException
	{
		ReadProperties.retrieveProperty();
        String locid = ReadProperties.webLocatorProp.getProperty(locatorid);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locid)));
        boolean isSelected = webdriver.findElement(By.id(locid)).isSelected();
        return isSelected;
	}
	
	public static Boolean isSelectedByName (WebDriver webdriver, String locatorName, int seconds) throws InterruptedException
	{
		ReadProperties.retrieveProperty();
        String locname = ReadProperties.webLocatorProp.getProperty(locatorName);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locname)));
        boolean isSelected = webdriver.findElement(By.name(locname)).isSelected();
        return isSelected;
	}
	
	public static Boolean isSelectedByClass (WebDriver webdriver, String locatorClass, int seconds) throws InterruptedException
	{
		ReadProperties.retrieveProperty();
        String locclass = ReadProperties.webLocatorProp.getProperty(locatorClass);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locclass)));
        boolean isSelected = webdriver.findElement(By.className(locclass)).isSelected();
        return isSelected;
	}
	
	public static Boolean isSelectedByCSS (WebDriver webdriver, String locatorCSS, int seconds) throws InterruptedException
	{
		ReadProperties.retrieveProperty();
        String locCSS = ReadProperties.webLocatorProp.getProperty(locatorCSS);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locCSS)));
        boolean isSelected = webdriver.findElement(By.cssSelector(locCSS)).isSelected();
        return isSelected;
	}
	
	public static Boolean isSelectedByXpath (WebDriver webdriver, String locatorXpath, int seconds) throws InterruptedException
	{
		ReadProperties.retrieveProperty();
        String locxpath = ReadProperties.webLocatorProp.getProperty(locatorXpath);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locxpath)));
        boolean isSelected = webdriver.findElement(By.xpath(locxpath)).isSelected();
        return isSelected;
	}
	
	public static void scrollToById (WebDriver webdriver, String locatorid, int seconds) throws InterruptedException
	{	
			    ReadProperties.retrieveProperty();
    	            String locid = ReadProperties.webLocatorProp.getProperty(locatorid);
    	    			WebDriverWait wait = new WebDriverWait(webdriver, seconds);
    	    			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locid)));
		        WebElement element = webdriver.findElement(By.id(locid));
		        ((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	public static void scrollToByClass (WebDriver webdriver, String locatorclass, int seconds) throws InterruptedException
	{	
			    ReadProperties.retrieveProperty();
    	            String locclass = ReadProperties.webLocatorProp.getProperty(locatorclass);
    	    			WebDriverWait wait = new WebDriverWait(webdriver, seconds);
    	    			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locclass)));
		        WebElement element = webdriver.findElement(By.className(locclass));
		        ((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	public static void scrollToByName (WebDriver webdriver, String locatorname, int seconds) throws InterruptedException
	{	
			    ReadProperties.retrieveProperty();
    	            String locname = ReadProperties.webLocatorProp.getProperty(locatorname);
	    			WebDriverWait wait = new WebDriverWait(webdriver, seconds);
	    			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locname)));
		        WebElement element = webdriver.findElement(By.name(locname));
		        ((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	public static void scrollToByXpath (WebDriver webdriver, String locatorxpath, int seconds) throws InterruptedException
	{	
			    ReadProperties.retrieveProperty();
    	            String locxpath = ReadProperties.webLocatorProp.getProperty(locatorxpath);
	    			WebDriverWait wait = new WebDriverWait(webdriver, seconds);
	    			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locxpath)));
		        WebElement element = webdriver.findElement(By.xpath(locxpath));
		        ((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView(true);",element);
	}

	public static void scrollToByCSS (WebDriver webdriver, String locatorcss, int seconds) throws InterruptedException
	{	
			    ReadProperties.retrieveProperty();
    	            String loccss = ReadProperties.webLocatorProp.getProperty(locatorcss);
	    			WebDriverWait wait = new WebDriverWait(webdriver, seconds);
	    			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(loccss)));
		        WebElement element = webdriver.findElement(By.cssSelector(loccss));
		        ((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	
    public static  WebElement waitXSecsAndGetVisibleElementById(WebDriver webdriver, String locatorid, int seconds) {
        WebDriverWait wait = new WebDriverWait(webdriver, seconds);
     	ReadProperties.retrieveProperty();
    	    String locid = ReadProperties.webLocatorProp.getProperty(locatorid);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locid)));
        return element;
    }   
    
    public static  WebElement waitXSecsAndGetVisibleElementByClassName(WebDriver webdriver, String locatorclass, int seconds) {
        WebDriverWait wait = new WebDriverWait(webdriver, seconds);
        ReadProperties.retrieveProperty();
    	    String locclass = ReadProperties.webLocatorProp.getProperty(locatorclass);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locclass)));
        return element;
    }
    
    public static WebElement waitXSecsAndGetVisibleElementByName(WebDriver webdriver, String locatorname, int seconds) {
        WebDriverWait wait = new WebDriverWait(webdriver, seconds);
        ReadProperties.retrieveProperty();
      	String locname= ReadProperties.webLocatorProp.getProperty(locatorname);
     	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locname)));
        return element;
    }
    
    public static WebElement waitXSecsAndGetVisibleElementByXpath(WebDriver webdriver, String locatorxpath, int seconds) {
        WebDriverWait wait = new WebDriverWait(webdriver, seconds);
        ReadProperties.retrieveProperty();
        String locxpath = ReadProperties.webLocatorProp.getProperty(locatorxpath);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locxpath)));
        return element;
    }
       
    public static WebElement waitXSecsAndGetVisibleElementByCSS(WebDriver webdriver, String locatorCSS, int seconds) {
        WebDriverWait wait = new WebDriverWait(webdriver, seconds);
        ReadProperties.retrieveProperty();
    		String loccss = ReadProperties.webLocatorProp.getProperty(locatorCSS);
    		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loccss)));
    		return element;
    		
    }

    
    public static WebElement waitXSecsAndGetVisibleElementByLink(WebDriver webdriver, String linkText, int seconds) {

	 	WebDriverWait wait = new WebDriverWait(webdriver, seconds);  
		ReadProperties.retrieveProperty();
		String link = ReadProperties.webLocatorProp.getProperty(linkText);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(link))); 
		WebElement element = webdriver.findElement(By.linkText(link));
		return element;
}   

    
    public static void clickById(WebDriver webdriver, String locatorid, int seconds) {
    	    WebElement element = WebLocatorMethods.waitXSecsAndGetVisibleElementById(webdriver, locatorid, seconds);
        element.click();
    }
    
    public static void clickByClassName(WebDriver webdriver, String locatorClass, int seconds) {
        WebElement element = WebLocatorMethods.waitXSecsAndGetVisibleElementByClassName(webdriver, locatorClass, seconds);
        element.click();
    }
    
    
    public static void clickByName(WebDriver webdriver, String locatorName, int seconds) {
        WebElement element = WebLocatorMethods.waitXSecsAndGetVisibleElementByName(webdriver, locatorName, seconds);
        element.click();
    }
    
    public static void clickByXpath(WebDriver webdriver, String locatorxpath, int seconds) {
        WebElement element = WebLocatorMethods.waitXSecsAndGetVisibleElementByXpath(webdriver, locatorxpath, seconds);
        element.click();
    }
    
    
    public static void clickByCssSelector(WebDriver webdriver, String locatorCSS, int seconds) {
        WebElement element = WebLocatorMethods.waitXSecsAndGetVisibleElementByCSS(webdriver, locatorCSS, seconds);
        element.click();
    }
    
    public static void clickByLink(WebDriver webdriver, String linkText, int seconds) {
        WebElement element = WebLocatorMethods.waitXSecsAndGetVisibleElementByLink(webdriver, linkText, seconds);
        element.click();
    }
    
    
	public static void actionsClickandSendByID (WebDriver webdriver, String locatorID, String keys, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locid = ReadProperties.webLocatorProp.getProperty(locatorID);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locid)));
        WebElement element = webdriver.findElement(By.id(locid));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element);
		builder.click();
		builder.sendKeys(keys);
		builder.build().perform();		
	}
	

	
	public static void actionsClickandSendByClass (WebDriver webdriver, String locatorClass, String keys, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locclass = ReadProperties.webLocatorProp.getProperty(locatorClass);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locclass)));
        WebElement element = webdriver.findElement(By.className(locclass));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element);
		builder.click();
		builder.sendKeys(keys);
		builder.build().perform();		
	}
	
	public static void actionsClickandSendByName (WebDriver webdriver, String locatorName, String keys, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locname = ReadProperties.webLocatorProp.getProperty(locatorName);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locname)));
        WebElement element = webdriver.findElement(By.name(locname));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element);
		builder.click();
		builder.sendKeys(keys);
		builder.build().perform();		
	}
	
	public static void actionsClickandSendByCSS (WebDriver webdriver, String locatorCSS, String keys, int seconds)
	{
		ReadProperties.retrieveProperty();
        String loccss = ReadProperties.webLocatorProp.getProperty(locatorCSS);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(loccss)));
        WebElement element = webdriver.findElement(By.cssSelector(loccss));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element);
		builder.click();
		builder.sendKeys(keys);
		builder.build().perform();		
	}
	
	public static void actionsClickandSendByXpath (WebDriver webdriver, String locatorXpath, String keys, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locxpath = ReadProperties.webLocatorProp.getProperty(locatorXpath);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locxpath)));
        WebElement element = webdriver.findElement(By.xpath(locxpath));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element);
		builder.click();
		builder.sendKeys(keys);
		builder.build().perform();		
	}

	
	public static void actionsMoveToElementAndPageDownByID (WebDriver webdriver, String locatorID, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locid = ReadProperties.webLocatorProp.getProperty(locatorID);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locid)));
        WebElement element = webdriver.findElement(By.id(locid));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element).sendKeys(Keys.PAGE_DOWN).build().perform();		
	}
	
	public static void actionsMoveToElementAndPageDownByClass (WebDriver webdriver, String locatorClass, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locclass = ReadProperties.webLocatorProp.getProperty(locatorClass);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locclass)));
        WebElement element = webdriver.findElement(By.className(locclass));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element).sendKeys(Keys.PAGE_DOWN).build().perform();		
	}
	
	public static void actionsMoveToElementAndPageDownByName (WebDriver webdriver, String locatorName, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locname = ReadProperties.webLocatorProp.getProperty(locatorName);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locname)));
        WebElement element = webdriver.findElement(By.name(locname));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element).sendKeys(Keys.PAGE_DOWN).build().perform();			
	}
	
	public static void actionsMoveToElementAndPageDownByCSS (WebDriver webdriver, String locatorCSS, int seconds)
	{
		ReadProperties.retrieveProperty();
        String loccss = ReadProperties.webLocatorProp.getProperty(locatorCSS);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(loccss)));
        WebElement element = webdriver.findElement(By.cssSelector(loccss));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element).sendKeys(Keys.PAGE_DOWN).build().perform();			
	}
	
	public static void actionsMoveToElementAndPageDownByXpath (WebDriver webdriver, String locatorXpath, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locxpath = ReadProperties.webLocatorProp.getProperty(locatorXpath);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locxpath)));
        WebElement element = webdriver.findElement(By.xpath(locxpath));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element).sendKeys(Keys.PAGE_DOWN).build().perform();		
	}
	
	public static void actionsMoveToElementByID (WebDriver webdriver, String locatorID, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locid = ReadProperties.webLocatorProp.getProperty(locatorID);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locid)));
        WebElement element = webdriver.findElement(By.id(locid));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element).build().perform();		
	}
	
	public static void actionsMoveToElementByClass (WebDriver webdriver, String locatorClass, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locclass = ReadProperties.webLocatorProp.getProperty(locatorClass);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locclass)));
        WebElement element = webdriver.findElement(By.className(locclass));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element).build().perform();		
	}
	
	public static void actionsMoveToElementByName (WebDriver webdriver, String locatorName, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locname = ReadProperties.webLocatorProp.getProperty(locatorName);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locname)));
        WebElement element = webdriver.findElement(By.name(locname));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element).build().perform();		
	}
	
	public static void actionsMoveToElementByCSS (WebDriver webdriver, String locatorCSS, int seconds)
	{
		ReadProperties.retrieveProperty();
        String loccss = ReadProperties.webLocatorProp.getProperty(locatorCSS);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(loccss)));
        WebElement element = webdriver.findElement(By.cssSelector(loccss));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element).build().perform();		
	}
	
	public static void actionsMoveToElementByXpath (WebDriver webdriver, String locatorXpath, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locxpath = ReadProperties.webLocatorProp.getProperty(locatorXpath);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locxpath)));
        WebElement element = webdriver.findElement(By.xpath(locxpath));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element).build().perform();		
	}
	
	
	public static void actionsClickByID (WebDriver webdriver, String locatorID, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locid = ReadProperties.webLocatorProp.getProperty(locatorID);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locid)));
        WebElement element = webdriver.findElement(By.id(locid));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element);
		builder.click();
		builder.build().perform();		
	}
	
	public static void actionsClickByClass (WebDriver webdriver, String locatorClass, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locclass = ReadProperties.webLocatorProp.getProperty(locatorClass);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locclass)));
        WebElement element = webdriver.findElement(By.className(locclass));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element);
		builder.click();
		builder.build().perform();		
	}
	
	public static void actionsClickByName (WebDriver webdriver, String locatorName, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locname = ReadProperties.webLocatorProp.getProperty(locatorName);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locname)));
        WebElement element = webdriver.findElement(By.name(locname));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element);
		builder.click();
		builder.build().perform();		
	}
	
	public static void actionsClickByCSS (WebDriver webdriver, String locatorCSS, int seconds)
	{
		ReadProperties.retrieveProperty();
        String loccss = ReadProperties.webLocatorProp.getProperty(locatorCSS);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(loccss)));
        WebElement element = webdriver.findElement(By.cssSelector(loccss));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element);
		builder.click();
		builder.build().perform();		
	}
	
	public static void actionsClickByXpath (WebDriver webdriver, String locatorXpath, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locxpath = ReadProperties.webLocatorProp.getProperty(locatorXpath);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locxpath)));
        WebElement element = webdriver.findElement(By.xpath(locxpath));
		Actions builder = new Actions(webdriver);
		builder.moveToElement(element);
		builder.click();
		builder.build().perform();		
	}
	
	public static WebElement javascriptExecutorScrollIntoViewByID (WebDriver webdriver, String locatorID, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locID= ReadProperties.webLocatorProp.getProperty(locatorID);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locID)));
		WebElement element = webdriver.findElement(By.id(locID));
		JavascriptExecutor executor = (JavascriptExecutor) webdriver;
		executor.executeScript("arguments[0].scrollIntoView();",element);
		return element;
	}
	
	public static WebElement javascriptExecutorScrollIntoViewByClass (WebDriver webdriver, String locatorClass, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locClass= ReadProperties.webLocatorProp.getProperty(locatorClass);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locClass)));
		WebElement element = webdriver.findElement(By.className(locClass));
		JavascriptExecutor executor = (JavascriptExecutor) webdriver;
		executor.executeScript("arguments[0].scrollIntoView();",element);
		return element;
	}
	
	public static WebElement javascriptExecutorScrollIntoViewByName (WebDriver webdriver, String locatorName, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locName= ReadProperties.webLocatorProp.getProperty(locatorName);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locName)));
		WebElement element = webdriver.findElement(By.className(locName));
		JavascriptExecutor executor = (JavascriptExecutor) webdriver;
		executor.executeScript("arguments[0].scrollIntoView();",element);
		return element;
	}
	
	public static WebElement javascriptExecutorScrollIntoViewByCSS (WebDriver webdriver, String locatorCSS, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locCSS= ReadProperties.webLocatorProp.getProperty(locatorCSS);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locCSS)));
		WebElement element = webdriver.findElement(By.className(locCSS));
		JavascriptExecutor executor = (JavascriptExecutor) webdriver;
		executor.executeScript("arguments[0].scrollIntoView();",element);
		return element;
	}
	
	public static WebElement javascriptExecutorScrollIntoViewByXpath (WebDriver webdriver, String locatorXpath, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locXpath= ReadProperties.webLocatorProp.getProperty(locatorXpath);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locXpath)));
		WebElement element = webdriver.findElement(By.className(locXpath));
		JavascriptExecutor executor = (JavascriptExecutor) webdriver;
		executor.executeScript("arguments[0].scrollIntoView();",element);
		return element;
	}
	
	public static void javascriptExecutorClickByID (WebDriver webdriver, String locatorID, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locID= ReadProperties.webLocatorProp.getProperty(locatorID);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locID)));
        WebElement element = webdriver.findElement(By.id(locID));
		JavascriptExecutor executor = (JavascriptExecutor) webdriver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public static void javascriptExecutorClickByClass (WebDriver webdriver, String locatorClass, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locClass = ReadProperties.webLocatorProp.getProperty(locatorClass);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locClass)));
        WebElement element = webdriver.findElement(By.className(locClass));
		JavascriptExecutor executor = (JavascriptExecutor) webdriver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public static void javascriptExecutorClickByName (WebDriver webdriver, String locatorName, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locname = ReadProperties.webLocatorProp.getProperty(locatorName);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locname)));
        WebElement element = webdriver.findElement(By.name(locname));
		JavascriptExecutor executor = (JavascriptExecutor) webdriver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public static void javascriptExecutorClickByXpath (WebDriver webdriver, String locatorXpath, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locxpath = ReadProperties.webLocatorProp.getProperty(locatorXpath);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locxpath)));
        WebElement element = webdriver.findElement(By.xpath(locxpath));
		JavascriptExecutor executor = (JavascriptExecutor) webdriver;
		executor.executeScript("arguments[0].click();", element);
	}
    
	public static void javascriptExecutorClickByCSSSelector (WebDriver webdriver, String locatorCSS, int seconds)
	{
		ReadProperties.retrieveProperty();
        String locCSS = ReadProperties.webLocatorProp.getProperty(locatorCSS);
		WebDriverWait wait = new WebDriverWait(webdriver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locCSS)));
        WebElement element = webdriver.findElement(By.cssSelector(locCSS));
		JavascriptExecutor executor = (JavascriptExecutor) webdriver;
		executor.executeScript("arguments[0].click();", element);
	}
	

    
    public static void sendKeysIntoElementById(WebDriver webdriver, String locatorid, String keys, int seconds) {
        WebElement element = WebLocatorMethods.waitXSecsAndGetVisibleElementById(webdriver, locatorid, seconds);
        element.clear();
        element.sendKeys(keys);
    }
    
    public static void sendKeysIntoElementByClassName(WebDriver webdriver, String locatorclass, String keys, int seconds) {
        WebElement element = WebLocatorMethods.waitXSecsAndGetVisibleElementByClassName(webdriver, locatorclass, seconds);
        element.clear();
        element.sendKeys(keys);
    }
    
    public static void sendKeysIntoElementByName(WebDriver webdriver, String locatorname, String keys, int seconds) {
        WebElement element = WebLocatorMethods.waitXSecsAndGetVisibleElementByName(webdriver, locatorname, seconds);
        element.clear();
        element.sendKeys(keys);
    }
    
    public static void sendKeysIntoElementByXpath(WebDriver webdriver, String locatorxpath, String keys, int seconds) {
        WebElement element = WebLocatorMethods.waitXSecsAndGetVisibleElementByXpath(webdriver, locatorxpath, seconds);
        element.clear();
        element.sendKeys(keys);
    }

    public static void sendKeysIntoElementByCSS(WebDriver webdriver, String locatorCSS, String keys, int seconds) {     
        WebElement element = WebLocatorMethods.waitXSecsAndGetVisibleElementByCSS(webdriver, locatorCSS, seconds);
        element.clear();
        element.sendKeys(keys);
    }
 
    
    
    public static String getTextById(WebDriver webdriver, String locatorid, int seconds) {
        WebElement element = WebLocatorMethods.waitXSecsAndGetVisibleElementById(webdriver, locatorid, seconds);
        return element.getText();
    }
    
    public static String getTextByClassName(WebDriver webdriver, String locatorClass, int seconds) {
        WebElement element = WebLocatorMethods.waitXSecsAndGetVisibleElementByClassName(webdriver, locatorClass, seconds);
        return element.getText();
    }
    
    public static String getTextByName(WebDriver webdriver, String locatorName, int seconds) {
        WebElement element = WebLocatorMethods.waitXSecsAndGetVisibleElementByName(webdriver, locatorName, seconds);
        return element.getText();
    }
    
    public static String getTextByXpath(WebDriver webdriver, String locatorxpath, int seconds) {
        WebElement element = WebLocatorMethods.waitXSecsAndGetVisibleElementByXpath(webdriver, locatorxpath, seconds);
        return element.getText();
    }
    
    public static String getTextByCSS(WebDriver webdriver, String locatorCSS, int seconds) {
        WebElement element = WebLocatorMethods.waitXSecsAndGetVisibleElementByCSS(webdriver, locatorCSS, seconds);
        return element.getText();
    }
       
    
    public static WebElement waituntilXsecondsisDisplayedByID (WebDriver webdriver, String locatorID, int seconds) throws InterruptedException
    {
	    WebElement element = null;
	    WebDriverWait wait = new WebDriverWait(webdriver, seconds);
	    ReadProperties.retrieveProperty();
		String locid = ReadProperties.webLocatorProp.getProperty(locatorID);
		element = webdriver.findElement(By.id(locid));
		
		while (!isDisplayed(element))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locid)));
			System.out.println("Element is not visible yet");
		}

		return element;

    }
    
    
    public static WebElement waituntilXsecondsisDisplayedByName (WebDriver webdriver, String locatorName, int seconds) throws InterruptedException
    {
	    WebElement element = null;
	    WebDriverWait wait = new WebDriverWait(webdriver, seconds);
	    ReadProperties.retrieveProperty();
		String locname = ReadProperties.webLocatorProp.getProperty(locatorName);
		element = webdriver.findElement(By.name(locname));
		
		while (!isDisplayed(element))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locname)));
			System.out.println("Element is not visible yet");
		}

		return element;

    }
    
    public static WebElement waituntilXsecondsisDisplayedByClass (WebDriver webdriver, String locatorClass, int seconds) throws InterruptedException
    {
	    WebElement element = null;
	    WebDriverWait wait = new WebDriverWait(webdriver, seconds);
	    ReadProperties.retrieveProperty();
		String locclass = ReadProperties.webLocatorProp.getProperty(locatorClass);
		element = webdriver.findElement(By.className(locclass));
		
		while (!isDisplayed(element))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locclass)));
			System.out.println("Element is not visible yet");
		}

		return element;

    }
       
    
    public static WebElement waituntilXsecondsisDisplayedByXpath (WebDriver webdriver, String locatorXpath, int seconds) throws InterruptedException
    {
	    WebElement element = null;
	    WebDriverWait wait = new WebDriverWait(webdriver, seconds);
	    ReadProperties.retrieveProperty();
		String locxpath = ReadProperties.webLocatorProp.getProperty(locatorXpath);
		element = webdriver.findElement(By.xpath(locxpath));
		
		while (!isDisplayed(element))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locxpath)));
			System.out.println("Element is not visible yet");
		}

		return element;

    }
    
    public static WebElement waituntilXsecondsisDisplayedByCSS (WebDriver webdriver, String locatorCSS, int seconds) throws InterruptedException
    {
	    WebElement element = null;
	    WebDriverWait wait = new WebDriverWait(webdriver, seconds);
	    ReadProperties.retrieveProperty();
		String loccss = ReadProperties.webLocatorProp.getProperty(locatorCSS);
		element = webdriver.findElement(By.cssSelector(loccss));
		
		while (!isDisplayed(element))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loccss)));
			System.out.println("Element is not visible yet");
		}

		return element;
    }
    
 	public static boolean isDisplayed(WebElement element) 
	{
       try 
       {
            if(element.isDisplayed())
                return element.isDisplayed();
       }
       catch (NoSuchElementException ex) 
        {
            return false;
        }
        return false;
	}
    
    public static WebElement catchStaleElementByID (WebDriver webdriver, String locatorID) throws InterruptedException
    {
	    WebElement element = null;
	    ReadProperties.retrieveProperty();
		String locid = ReadProperties.webLocatorProp.getProperty(locatorID);
		element = webdriver.findElement(By.id(locid));
		
		for(int i=0; i<4;i++)
	        try {
	         webdriver.findElement(By.id(locid));
	            break;
	        } catch(StaleElementReferenceException e) {
	          e.toString();
	    System.out.println("Trying to recover from a stale element :" + e.getMessage());
	      
	    }

		return element;
    }
    
    public static WebElement catchStaleElementByName (WebDriver webdriver, String locatorName) throws InterruptedException
    {
	    WebElement element = null;
	    ReadProperties.retrieveProperty();
		String locname = ReadProperties.webLocatorProp.getProperty(locatorName);
		element = webdriver.findElement(By.name(locname));
		
		for(int i=0; i<4;i++)
	        try {
	         webdriver.findElement(By.name(locname));
	            break;
	        } catch(StaleElementReferenceException e) {
	          e.toString();
	    System.out.println("Trying to recover from a stale element :" + e.getMessage());
	      
	    }

		return element;
    }
    
    public static WebElement catchStaleElementByClass (WebDriver webdriver, String locatorClass) throws InterruptedException
    {
	    WebElement element = null;
	    ReadProperties.retrieveProperty();
		String locclass = ReadProperties.webLocatorProp.getProperty(locatorClass);
		element = webdriver.findElement(By.className(locclass));
		
		for(int i=0; i<4;i++)
	        try {
	         webdriver.findElement(By.className(locclass));
	            break;
	        } catch(StaleElementReferenceException e) {
	          e.toString();
	    System.out.println("Trying to recover from a stale element :" + e.getMessage());
	      
	    }

		return element;
    }
    
    public static WebElement catchStaleElementByXpath (WebDriver webdriver, String locatorXpath) throws InterruptedException
    {
	    WebElement element = null;
	    ReadProperties.retrieveProperty();
		String locxpath = ReadProperties.webLocatorProp.getProperty(locatorXpath);
		element = webdriver.findElement(By.xpath(locxpath));
		
		for(int i=0; i<4;i++)
	        try {
	         webdriver.findElement(By.xpath(locxpath));
	            break;
	        } catch(StaleElementReferenceException e) {
	          e.toString();
	    System.out.println("Trying to recover from a stale element :" + e.getMessage());
	      
	    }

		return element;
    }
    
    public static WebElement catchStaleElementByCSS (WebDriver webdriver, String locatorCSS) throws InterruptedException
    {
	    WebElement element = null;
	    ReadProperties.retrieveProperty();
		String loccss = ReadProperties.webLocatorProp.getProperty(locatorCSS);
		element = webdriver.findElement(By.cssSelector(loccss));
		
		for(int i=0; i<4;i++)
	        try {
	         webdriver.findElement(By.cssSelector(loccss));
	            break;
	        } catch(StaleElementReferenceException e) {
	          e.toString();
	    System.out.println("Trying to recover from a stale element :" + e.getMessage());
	      
	    }

		return element;
    }
	    
        
   

    	
    	public static void refreshPage(WebDriver webdriver)
    	{
    		webdriver.navigate().refresh();
    	}
}















