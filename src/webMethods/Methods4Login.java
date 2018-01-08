package webMethods;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import common.ScreenshotURL;
import locators.WebLocatorMethods;

public class Methods4Login {
		
		//****************************************//
		//***                                  ***//
		//*** Created by Angela Tong Dec 2017  ***//
		//***                                  ***//
		//****************************************//
		
		static SoftAssert softAssert = new SoftAssert();
		final static Logger log = Logger.getLogger(Methods4Login.class);
		
		public static void loginFamilyLocator (WebDriver webdriver, String foldername, String errorname, String error, String loginusername, String loginpwd) throws InterruptedException, IOException
	    {
					
			    WebLocatorMethods.clickById(webdriver, "webloginusername.id", 30); 
			    WebLocatorMethods.sendKeysIntoElementById(webdriver, "webloginusername.id", loginusername, 30);
			    WebLocatorMethods.clickById(webdriver, "webloginpassword.id", 30); 
			    WebLocatorMethods.sendKeysIntoElementById(webdriver, "webloginpassword.id", loginpwd, 30);
			    WebLocatorMethods.clickById(webdriver, "webloginbtn.id", 30);
			    WebLocatorMethods.waitXSecsAndGetVisibleElementByXpath(webdriver, "webterms.xpath", 300);
			        
			        try
			        {
				        String vzfltermsheader = WebLocatorMethods.getTextByXpath(webdriver, "webterms.xpath", 30);
				        Assert.assertTrue(vzfltermsheader.contentEquals("Family Locator - Terms & Conditions"));	        
				        log.info("Verify correct VZFL terms and conditions header." );
			        	String currenturl = webdriver.getCurrentUrl();
			        	System.out.println("currenturl: "+currenturl);
				        Assert.assertTrue(webdriver.getCurrentUrl().equalsIgnoreCase("https://familylocator.qa.nimaws.com/terms"));
				        log.info("Verify VZFL terms and conditions page url." );
					}
					catch(AssertionError e)
					{ 
						log.info("Not on terms and conditions page.");
						log.error("Failed Assertion. Not on terms and conditions page.", e);
						errorname = "notontermsandconditionspage";
						ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
						softAssert.fail();
					}
					
			        
			        JavascriptExecutor javascript = (JavascriptExecutor) webdriver;
			        javascript.executeScript("window.scrollBy(0,2800)", "");           
			        

			        
			        WebLocatorMethods.scrollToByXpath(webdriver, "webtermscheckmark.xpath", 30);
			        WebLocatorMethods.clickByXpath(webdriver, "webtermscheckmark.xpath", 30);
			        //Clicks to open popup window
			        WebLocatorMethods.clickByXpath(webdriver, "webtermsaccept.xpath", 30);
			        
			        
			        Thread.sleep(3000);
			        webdriver.switchTo().activeElement();
			        
			        
				     try
				     {
				        String welcomeheader = WebLocatorMethods.getTextByCSS(webdriver, "webwelcomepopupheader.css", 30);
				        Assert.assertEquals(welcomeheader, "Welcome to the all new VZ Family Locator");
				        log.info("Checked welcome header.");
				        String welcomep1 = WebLocatorMethods.getTextByCSS(webdriver, "webwelcomeparagraph1.css", 30);
				        Assert.assertEquals(welcomep1, "Totally redesigned to help you stay connected with your family members anytime, anywhere.");
				        log.info("Checked welcome paragraph1.");
				        String welcomep2 = WebLocatorMethods.getTextByCSS(webdriver, "webwelcomeparagraph2.css", 30);
				        Assert.assertEquals(welcomep2, "Check the Help page to see what's new.");
				        log.info("Checked welcome paragraph2.");
				        String getstartedbtn = WebLocatorMethods.getTextByXpath(webdriver, "webwelcomegetstartedbtn.xpath", 30);
				        Assert.assertEquals(getstartedbtn, "Get started");
				        log.info("Checked Get started button.");
				        WebLocatorMethods.clickByXpath(webdriver, "webwelcomegetstartedbtn.xpath", 30);
				        
				     }
					catch(AssertionError e)
					{ 
						log.info("Not on welcome page.");
						log.error("This is an exception", e);
						errorname = "notonwelcomepage";
						ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
						softAssert.fail();
					}
				     
				    
			        javascript.executeScript("window.scrollBy(0,-1000)", "");  
			        
			
				
					softAssert.assertAll();
				
			}
			

}
