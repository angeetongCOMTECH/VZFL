package webMethods;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import common.ScreenshotURL;
import locators.WebLocatorMethods;


public class Methods4AddPlace {
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Dec 2017  ***//
	//***                                  ***//
	//****************************************//
	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = Logger.getLogger(Methods4AddPlace.class);
	
	public static void addPlace (WebDriver webdriver, String foldername, String errorname, String error, String entersearchfield, String expectedautosuggestionaddress, String expectedaddress, String finalsavedaddress, String placename) throws InterruptedException, IOException
	{
		
		    log.info("Checking the text on Add Place page.");
		    
			try
			{
				String headertext = WebLocatorMethods.getTextByCSS(webdriver, "webaddplacepgheader.css", 30);
				Assert.assertEquals(headertext, "Add Place");
			    
				String subheadertext = WebLocatorMethods.getTextByCSS(webdriver, "webaddplacepgsubheader.css", 30);
				Assert.assertEquals(subheadertext, "Enter address or place name");
				
			}
			catch(AssertionError e)
			{ 

				log.info("Failed checking text on Add Place page.");
				log.error("This is an exception", e);
				errorname = "failedcheckingtextonAddPlacepage";
				ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
				softAssert.fail();
			}
			
			
			log.info("Checking autosuggestion on Add Place page.");
			
			try
			{
				WebLocatorMethods.clickByCssSelector(webdriver, "webaddplacepgsearchfield.css", 30);
				WebLocatorMethods.sendKeysIntoElementByCSS(webdriver, "webaddplacepgsearchfield.css", entersearchfield, 120);
				Thread.sleep(1000);
				String autosuggestiontext = WebLocatorMethods.getTextByCSS(webdriver, "webaddplacesearchfieldautosuggestion.css", 120);
				Assert.assertEquals(autosuggestiontext, expectedautosuggestionaddress);
			}	
			catch(AssertionError e)
			{ 

				log.info("Failed autosuggestion on Add Place page.");
				log.error("This is an exception", e);
				errorname = "failedautosuggestiononAddPlacepage";
				ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
				softAssert.fail();
			}
			
			log.info("Checking text on Add Place: Select Icon page.");
			
			
			try
			{
				//Works for Chrome, but not for Firefox with click so use javascriptexecutor
				WebLocatorMethods.javascriptExecutorClickByCSSSelector(webdriver, "webaddplacesearchfieldautosuggestion.css", 120);
				Thread.sleep(1000);
				String selecticonheadertext = WebLocatorMethods.getTextByCSS(webdriver, "webaddplaceselecticonheader.css", 30);
				Assert.assertEquals(selecticonheadertext, "Add Place: Select Icon");
				
				String selecticonaddresstext = WebLocatorMethods.getTextByClassName(webdriver, "webaddplaceselecticonaddress.class", 30);
				Assert.assertEquals(selecticonaddresstext, expectedaddress);
				
				String selecticonsubheadertext = WebLocatorMethods.getTextByCSS(webdriver, "webaddplaceselecticonsubheader.css", 30);
				Assert.assertEquals(selecticonsubheadertext, "What is this place?");
			}
			catch(AssertionError e)
			{ 

				log.info("Failed checking text on Add Place Select Icon page.");
				log.error("This is an exception", e);
				errorname = "failedcheckingtextonAddPlaceSelectIconpage";
				ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
				softAssert.fail();
			}
			
			
			log.info("Checking text on Add Place: Name Place page.");
			
			try
			{
				WebLocatorMethods.clickByXpath(webdriver, "webaddplaceselecticongroceryicon.xpath", 30);
				Thread.sleep(1000);
				String addplacenameplaceheadertext = WebLocatorMethods.getTextByCSS(webdriver, "webaddplaceaddnameplaceheader.css", 30);
				Assert.assertEquals(addplacenameplaceheadertext, "Add Place: Name Place");
				
				String addplacenameplaceaddress = WebLocatorMethods.getTextByCSS(webdriver, "webaddplaceaddnameplaceaddress.css", 30);
				Assert.assertEquals(addplacenameplaceaddress, expectedaddress);
				
				String addplacenameplacesubheadertext = WebLocatorMethods.getTextByCSS(webdriver, "webaddplaceaddnameplacesubheader.css", 30);
				Assert.assertEquals(addplacenameplacesubheadertext, "What would you like to name this place?");

			}
			catch(AssertionError e)
			{ 

				log.info("Failed checking text on Add Place Name Place page.");
				log.error("This is an exception", e);
				errorname = "failedcheckingtextonAddPlaceNamePlacepage";
				ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
				softAssert.fail();
			}
			
			
			WebLocatorMethods.clickByXpath(webdriver, "webaddplaceaddnameplacetextbox.xpath", 30);
			WebLocatorMethods.sendKeysIntoElementByXpath(webdriver, "webaddplaceaddnameplacetextbox.xpath", placename, 30);
			Thread.sleep(500);
			WebLocatorMethods.clickByCssSelector(webdriver, "webaddplaceaddnamenextbtn.css", 30);
			Thread.sleep(1000);
			
			log.info("Confirming text on add place before saving.");
			
			try
			{
				String addplaceconfirmheadertext = WebLocatorMethods.getTextByCSS(webdriver, "webaddplaceconfirmheader.css", 30);
				Assert.assertEquals(addplaceconfirmheadertext, "Add Place: Confirm");
				
				String addplaceconfirmplacenametext = WebLocatorMethods.getTextByCSS(webdriver, "webaddplaceconfirmplacename.css", 30);
				Assert.assertEquals(addplaceconfirmplacenametext, placename);
				
				String addplaceconfirmplaceaddress = WebLocatorMethods.getTextByCSS(webdriver, "webaddplaceconfirmplaceaddress.css", 30);
				Assert.assertEquals(addplaceconfirmplaceaddress, expectedaddress);
			}

			catch(AssertionError e)
			{ 
				log.info("Failed confirming text on add place before saving.");
				log.error("This is an exception", e);
				errorname = "failedconfirmingtextonaddplacebeforesaving";
				ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
				softAssert.fail();
			}
	
			WebLocatorMethods.clickByCssSelector(webdriver, "webaddplaceconfirmplacesavebtn.css", 30);
			Thread.sleep(3000);
			
	        JavascriptExecutor javascript = (JavascriptExecutor) webdriver;
	        javascript.executeScript("window.scrollBy(0,350)", "");   
	      
			log.info("Checking added place saved to places page.");
	        
	        try
	        {
		        int elementexistsornot = WebLocatorMethods.placeSizeByXpath(webdriver, placename, "websavedaddedplacename.xpath", 30);
				Assert.assertEquals(elementexistsornot, 1);
				
				String actualplacename = WebLocatorMethods.placeGetTextByXpath(webdriver, placename, "websavedaddedplacename.xpath", 30);
				Assert.assertEquals(actualplacename, placename);
				
				String actualaddress = WebLocatorMethods.placeAddressGetTextByXpath(webdriver, finalsavedaddress, "websaveaddedplaceaddress.xpath", 30);
				Assert.assertEquals(actualaddress, finalsavedaddress);

			}
			catch(Exception e)
			{ 
				log.info("Something failed on adding place.");
				log.error("This is an exception", e);
				errorname = "failedtoaddplace";
				ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
			}


			softAssert.assertAll();

	   }


	
}
