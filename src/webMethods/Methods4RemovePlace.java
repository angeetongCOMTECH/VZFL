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

public class Methods4RemovePlace {
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Dec 2017  ***//
	//***                                  ***//
	//****************************************//

	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = Logger.getLogger(Methods4RemovePlace.class);
	
	public static void removePlace (WebDriver webdriver, String foldername, String errorname, String error, String placename) throws InterruptedException, IOException
	{
			try
			{
			    log.info("Methods4RemovePlace starting");		
				WebLocatorMethods.javascriptExecutorClickByCSSSelector(webdriver, "webplacesicon.css", 1000);
				
				Thread.sleep(2000);
				Boolean emptyplacesexists = WebLocatorMethods.existsSizeNotZeroByCSS(webdriver, "webemptyplaces.css", 1000);
				
				if (emptyplacesexists == false)
				{
				
				//To avoid org.openqa.selenium.StaleElementReferenceException error by storing locators to the elements instead of references
				List <WebElement> placeelements = WebLocatorMethods.arrayofelementsbyCSS(webdriver, "webplaceslistarray.css", 4000);
				int placeslistsize = placeelements.size();
				System.out.println("placeslistsize: "+placeslistsize);
				
				if (placeslistsize == 0)
				{
					log.info("There are 0 places so nothing to delete.");
				}
				else
				{
					log.info("There are "+placeslistsize+" places.");

						for (int i=0; i<placeslistsize; i++)
						{
							log.info("i: "+i);
					
							String placetext = placeelements.get(i).getText();
							
						    if (i==placeslistsize-1 && !placetext.contains(placename))
						    {
						    	   log.info("The place does not exists so nothing to delete.");
						    }
							else if (i<placeslistsize && !placetext.contains(placename))
						    {
							    log.info("This "+placetext+" place does not match the place we want.");
						    }
						    else if (placetext.contains(placename))
						    {
							    System.out.println("placetext: "+placetext);
							    log.info("Found the place that we want to delete.");
							    
							    JavascriptExecutor javascript = (JavascriptExecutor) webdriver;
						        javascript.executeScript("window.scrollBy(0,-600)", "");   
						        
							    WebLocatorMethods.javascriptExecutorClickByID(webdriver, "webplacesdeleteicon.id", 30);
				
							    
							    try
							    {

								    String deleteplaceheadertext = WebLocatorMethods.getTextByCSS(webdriver, "webdeleteplaceheader.css", 30);
								    Assert.assertEquals(deleteplaceheadertext, "Delete Place");
								    
								    String deleteplaceselectalllinktext = WebLocatorMethods.getTextByCSS(webdriver, "webdeleteplaceselectall.css", 30);
								    Assert.assertEquals(deleteplaceselectalllinktext, "Select All");
								    
								    log.info("On delete place selection page.");
							    }
								catch(AssertionError e)
							    { 
									  log.info("Missing delete place header and select all link.");
									  log.error("This is an exception", e);
									  errorname = "missingdeleteplaceheadernandselectalllink";
									  ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
									  softAssert.fail();
								}
								  
							    log.info("Going through the list of places that are about to be deleted.");
							    //have to click somewhere on page to be able to find rest of other elements by selecting all and unselecting all
							    WebLocatorMethods.actionsClickByCSS(webdriver, "webdeleteplaceselectall.css", 30);
							    Thread.sleep(1000);
							    WebLocatorMethods.actionsClickByCSS(webdriver, "webdeleteplaceselectall.css", 30);
							    Thread.sleep(1000);
							    
							    List <WebElement> deleteplacesarray = WebLocatorMethods.arrayofelementsbyCSS(webdriver, "webdeleteplacearray.css", 2000);
					    	    
							    int deleteplacearraysize = deleteplacesarray.size();
							    log.info("There are "+deleteplacearraysize+" alerts for deleting.");
							    
							    for (int j=0; j<deleteplacearraysize; j++) 
							    {
							    		String deleteplacetext = deleteplacesarray.get(j).getText();
							    	    if (!deleteplacetext.contains(placename))
							    	    {
							    	    	    log.info("This is not the place I want to delete. " + deleteplacetext);
							    	    }
							    	    else
							    	    {
							    	    	    log.info("Found place to delete. " + deleteplacetext);
							    	    	    WebLocatorMethods.arrayofelementsbyCSS(webdriver, "webdeleteplaceiconarray.css", 2000).get(j);
							    	    	    WebLocatorMethods.arrayofelementsbyCSS(webdriver, "webdeleteplacecheckboxarray.css", 2000).get(j).click();
							    	    	    WebLocatorMethods.waitXSecsAndGetVisibleElementByCSS(webdriver, "webdeleteplacecheckedcheckbox.css", 30);
									    log.info("Checkoff place to delete.");
									    
									    String deleteplacecancelbuttontext = WebLocatorMethods.getTextByCSS(webdriver, "webdeleteplacecancelbtn.css", 30);
									    Assert.assertEquals(deleteplacecancelbuttontext, "Cancel");
									    
									    String deleteplaceremovebuttontext = WebLocatorMethods.getTextByCSS(webdriver, "webdeleteplaceremovebtn.css", 30);
									    Assert.assertEquals(deleteplaceremovebuttontext, "Remove");
									    
									    WebLocatorMethods.clickByCssSelector(webdriver, "webdeleteplaceremovebtn.css", 120);
									    log.info("Clicked delete button.");
									    
								Thread.sleep(2000);
								Boolean emptyplacesexists2 = WebLocatorMethods.existsSizeNotZeroByCSS(webdriver, "webemptyplaces.css", 1000);
										
								if (emptyplacesexists2 == false)
								{
									    
									    List <WebElement> afterdeleteplacearray = WebLocatorMethods.arrayofelementsbyCSS(webdriver, "webplaceslistarray.css", 4000);
									    int afterdeleteplacesize = afterdeleteplacearray.size();
									    
									    for (int k=0; k<afterdeleteplacesize; k++)
									    {
									    	    String afterdeleteplacenametext = afterdeleteplacearray.get(k).getText();
									    	    if (afterdeleteplacenametext.contains(placename))
									    	    {
									    	    	   log.info("Checking through the list that this is not the deleted place.");
									    	    }
									    	    else if (afterdeleteplacenametext.contains(placename))
									    	    {
									    	    	   log.info("Place was deleted, but has not been removed from places list.");
									    	    }
									    }
									    
									    log.info("Place has been deleted.");
									    javascript.executeScript("window.scrollBy(0,-800)", "");
								        
									    break;
								}
								else 
								{
								    log.info("Place has been deleted.");
								    break;
								}
									    
							    	    }
									    
							    }

							    break;
						    }
						    
						    
						 }
							    
				        
				}
				}
				else
				{
					log.info("There is an empty places list so there are no places to delete.");
				}

			}
			catch(Exception e)
			{ 
				log.info("Something failed on remove place.");
				log.error("This is an exception", e);
				errorname = "failedtoremoveplace";
				ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
			}
		

			softAssert.assertAll();

		
		
	}
}
