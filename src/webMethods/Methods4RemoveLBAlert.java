package webMethods;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import common.ScreenshotURL;
import locators.WebLocatorMethods;

public class Methods4RemoveLBAlert {
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Dec 2017  ***//
	//***                                  ***//
	//****************************************//

	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = Logger.getLogger(Methods4RemoveLBAlert.class);
	
	
	public static void removeLBAlert (WebDriver webdriver, String foldername, String errorname, String error, String placename) throws InterruptedException, IOException
	{

		try
		{

		
			log.info("Methods4RemoveLBAlert starting");
			
			WebLocatorMethods.javascriptExecutorClickByClass(webdriver, "webalertsicon.class", 1000);
			WebLocatorMethods.clickByCssSelector(webdriver, "webalertfirstalerticontorefreshpage.css", 30);
		
		/***
			WebLocatorMethods.clickByCssSelector(webdriver, "webalertaddedclickonbellicontoscrolluptoreachnewlyaddedalert.css");
			WebLocatorMethods.javscriptexecutorScrollIntoViewContainingTextByXpath(webdriver, placename, "webalertaddedinlist.xpath" );
            WebLocatorMethods.javascriptExecutorScrollIntoViewByClass(webdriver, "webalertdeleteicon.class");
        ***/
			
			
			//To avoid org.openqa.selenium.StaleElementReferenceException error by storing locators to the elements instead of references
			List <WebElement> placeelements = WebLocatorMethods.arrayofelementsbyCSS(webdriver, "webalertsinlistarray.css", 2000);
			int alertslistsize = placeelements.size();
			System.out.println("alertslistsize: "+alertslistsize);
			
			if (alertslistsize == 0)
			{
				log.info("There are no alerts created so nothing to delete.");
			}
			else
			{
					log.info("There are "+alertslistsize+" alerts.");
					for (int i=0; i<alertslistsize; i++) //Don't put -1 because it won't go to the matching Albertsons alert at the end to delete
					{
						log.info("i: "+i);
					
					
						String elementalert = placeelements.get(i).getText();
						log.info("elementalert: "+elementalert);
						
						if (i==alertslistsize-1 && !elementalert.contains(placename))
						{
							log.info("The alert does not exists, so nothing to delete.");
						}
						else if (i<alertslistsize && !elementalert.contains(placename))
						{
								log.info("This is not the alert that I want to delete. "+ elementalert);
						}
						else if (elementalert.contains(placename))
						{
								log.info("Found the alert to delete. " + elementalert);
								WebLocatorMethods.javascriptExecutorClickByClass(webdriver, "webalertdeleteicon.class", 30);
								
								 
							    WebLocatorMethods.waituntilXsecondsisDisplayedByCSS(webdriver, "webdeletealertheader.css", 60);
										
									 try
									 {
										String deletealertheadertext = WebLocatorMethods.getTextByCSS(webdriver, "webdeletealertheader.css", 30);
										Assert.assertEquals(deletealertheadertext, "Delete Alert");
										
										String selectalllinktext = WebLocatorMethods.getTextByCSS(webdriver, "webdeletealertselectalllinktext.css", 30);
										Assert.assertEquals(selectalllinktext, "Select All");
										System.out.println("selectallinktext: "+selectalllinktext);
										
									  }
									  catch(AssertionError e)
									  { 
				
										  log.error("This is an exception", e);
										  errorname = "missingdeletealertsheaderandselectalllink";
										  ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
										  softAssert.fail();
									  }
									
									//needed to remove below commented lines or else get stale reference
									//have to click somewhere on page to be able to find rest of other elements 
									//WebLocatorMethods.clickByCssSelector(webdriver, "webdeletealertclickonfirstalerticontofreshenpage.css");
									
									List <WebElement> deleteplaceelements = WebLocatorMethods.arrayofelementsbyClass(webdriver, "webdeletealertdescriptionarray.class", 2000); 
									int deletealertslistsize = deleteplaceelements.size();
									log.info("There are "+deletealertslistsize+" alerts that can be checked off to delete.");
									
									for (int j=0; j<deletealertslistsize; j++)
									{
										
										String deleteelementalert = deleteplaceelements.get(j).getText();
				
										
										if (!deleteelementalert.contains(placename))
										{
											log.info("This is not the alert that I want to checkoff to delete. "+deleteelementalert);
										}
										else
										{
											log.info("Found alert to delete. "+deleteelementalert);
											WebLocatorMethods.arrayofelementsbyCSS(webdriver, "webdeletealerticonarray.css", 2000).get(j);
											WebLocatorMethods.arrayofelementsbyClass(webdriver, "webdeletealertcheckboxarray.class", 2000).get(j).click();
											WebLocatorMethods.waitXSecsAndGetVisibleElementByCSS(webdriver, "webdeletealertcheckedcheckbox.css", 30);
											log.info("Checkoff alert to delete.");
											
											try
											{
												 WebLocatorMethods.scrollToByCSS(webdriver, "webdeletealertcancelbtn.css", 30);
												 WebLocatorMethods.scrollToByCSS(webdriver, "webdeletealertremovebtn.css", 30);
												 String cancelbuttontext = WebLocatorMethods.getTextByCSS(webdriver, "webdeletealertcancelbtn.css", 30);
												 Assert.assertEquals(cancelbuttontext, "Cancel");
												 String removebuttontext = WebLocatorMethods.getTextByCSS(webdriver, "webdeletealertremovebtn.css", 30);
												 Assert.assertEquals(removebuttontext, "Remove");
											}
											catch(AssertionError e)
											{ 
				
												  log.error("This is an exception", e);
												  errorname = "missingdeletealertcancelandremovebuttons";
												  ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
												  softAssert.fail();
											}
				
											
											WebLocatorMethods.clickByCssSelector(webdriver, "webdeletealertremovebtn.css", 30);
											
											int afterdeletedalertlistsize = WebLocatorMethods.sizeByCSS(webdriver, "webalertsinlistarray.css", 30);
											
											for (int k=0; k<afterdeletedalertlistsize; k++) 
											{
												String checkdeletedalertstillexists = WebLocatorMethods.arrayofelementsbyCSS(webdriver, "webalertsinlistarray.css", 2000).get(k).getText();
												if (checkdeletedalertstillexists.contains(placename))
												{
													log.error("Alert was deleted, but not removed from the alerts list.");
												}
									
											}
											
											log.info("Alert was deleted.");	
											
									        JavascriptExecutor javascript = (JavascriptExecutor) webdriver;
									        javascript.executeScript("window.scrollBy(0,-800)", "");
									        
									        break;
										}
									}			
								
									break;		
						}
						
						

					 }
					

			}

			
		}
		catch(Exception e)
		{ 
			log.info("Something failed on remove lb alert.");
			log.error("This is an exception", e);
			errorname = "failedtoremovelbalert";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
		}


		softAssert.assertAll();
	
		
	}

}
