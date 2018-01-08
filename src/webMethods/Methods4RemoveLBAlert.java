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
			
			WebLocatorMethods.javascriptExecutorClickByClass(webdriver, "webalertsicon.class", 120);


            Thread.sleep(2000);
			Boolean emptyalertsexists = WebLocatorMethods.existsSizeNotZeroByCSS(webdriver, "webemptyalerts.css", 30);
			
			if (emptyalertsexists == true)
			{
					log.info("There is an empty alerts list so there are no alerts to delete.");
			}
			else if (emptyalertsexists == false)
			{
	
			WebLocatorMethods.clickByCssSelector(webdriver, "webalertfirstalerticontorefreshpage.css", 30);
			
			//To avoid org.openqa.selenium.StaleElementReferenceException error by storing locators to the elements instead of references
			List <WebElement> alertselements = WebLocatorMethods.arrayofelementsbyCSS(webdriver, "webalertsinlistarray.css", 30);
			int alertslistsize = alertselements.size();
			System.out.println("alertslistsize: "+alertslistsize);

					log.info("There are "+alertslistsize+" alerts.");
					for (int i=0; i<alertslistsize; i++) //Don't put -1 because it won't go to the matching Albertsons alert at the end to delete
					{
						log.info("i: "+i);
					
					
						String elementalert = alertselements.get(i).getText();
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
							
									List <WebElement> deletealertelements = WebLocatorMethods.arrayofelementsbyClass(webdriver, "webdeletealertdescriptionarray.class", 180); 
									int deletealertslistsize = deletealertelements.size();
									log.info("There are "+deletealertslistsize+" alerts that can be checked off to delete.");
									
									for (int j=0; j<deletealertslistsize; j++)
									{
										
										String deleteelementalert = deletealertelements.get(j).getText();
				
										
										if (!deleteelementalert.contains(placename))
										{
											log.info("This is not the alert that I want to checkoff to delete. "+deleteelementalert);
										}
										else
										{
											log.info("Found alert to delete. "+deleteelementalert);
											WebLocatorMethods.arrayofelementsbyCSS(webdriver, "webdeletealerticonarray.css", 180).get(j);
											WebLocatorMethods.arrayofelementsbyClass(webdriver, "webdeletealertcheckboxarray.class", 180).get(j).click();
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
				
									    Thread.sleep(2000);	
										WebLocatorMethods.clickByCssSelector(webdriver, "webdeletealertremovebtn.css", 30);
										Thread.sleep(4000);	
										
										Boolean emptyalertsexists2 = WebLocatorMethods.existsSizeNotZeroByCSS(webdriver, "webemptyalerts.css", 180);
											
										if (emptyalertsexists2 == false)
										{
											int afterdeletedalertlistsize = WebLocatorMethods.sizeByCSS(webdriver, "webalertsinlistarray.css", 30);
											
											for (int k=0; k<afterdeletedalertlistsize; k++) 
											{
												String checkdeletedalertstillexists = WebLocatorMethods.arrayofelementsbyCSS(webdriver, "webalertsinlistarray.css", 180).get(k).getText();
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
										else
										{
											log.info("Alert was deleted.");	
											break;
										}
									} //else if
								} //for loop		
								
									break;		
						}//else if
						
						

					 }//first for loop
					

			
			}//first else if

			
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
