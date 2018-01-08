package webMethods;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import common.ScreenshotURL;
import locators.WebLocatorMethods;


public class Methods4AddLocationBasedAlerts {
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Dec 2017  ***//
	//***                                  ***//
	//****************************************//

	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = Logger.getLogger(Methods4AddLocationBasedAlerts.class);
	
	public static void addPlaceandLocationBasedAlert (WebDriver webdriver, String foldername, String errorname, String error, String entersearchfield, String expectedautosuggestionaddress, String expectedaddress, String finalsavedaddress, String placename, String contactname, String phone, String email) throws InterruptedException, IOException
	{

			try
			{
			
				WebLocatorMethods.javascriptExecutorClickByClass(webdriver, "webalertsicon.class", 180);

				WebLocatorMethods.javascriptExecutorClickByClass(webdriver, "webaddanalerticon.class", 180);

				
				log.info("Check select alert page.");
				
				try
				{
					String alerttypeheader = WebLocatorMethods.getTextByCSS(webdriver, "webselectalerttypeheader.css", 180);
					Assert.assertEquals(alerttypeheader, "Select alert type");
					
					String lbalertheader = WebLocatorMethods.getTextByCSS(webdriver, "webselectalerttypelbalertheader.css", 30);
					Assert.assertEquals(lbalertheader, "Arrival/Departure Alert");
					
					String lbalertdescription = WebLocatorMethods.getTextByCSS(webdriver, "webselectalerttypelbalertdescription.css", 30);
					Assert.assertEquals(lbalertdescription, "Receive an alert when your family members leave or arrive.");
					
					String schedalertheader = WebLocatorMethods.getTextByCSS(webdriver, "webselectalerttypeschedalertheader.css", 30);
					Assert.assertEquals(schedalertheader, "Scheduled Alert");
					
					String schedalertdescription = WebLocatorMethods.getTextByCSS(webdriver, "webselectalerttypeschedalertdescription.css", 30);
					Assert.assertEquals(schedalertdescription, "Receive an alert with a family member's location at a specific time.");
					
				}
				catch(AssertionError e)
				{ 
					log.info("Failed text check on select alert type page.");
					log.error("This is an exception", e);
					errorname = "failedtextcheckonselectalerttypepage";
					ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
					softAssert.fail();
				}
				
				//Click location based alert and add a place from alerts.
				WebLocatorMethods.clickByCssSelector(webdriver, "webselectalerttypelbalertheader.css", 30);
				//Needed longer wait before and after click or get stuck loading the add place page when clicked

				WebLocatorMethods.javascriptExecutorClickByCSSSelector(webdriver, "webselectalertlocationaddaplace.css", 180);
				Thread.sleep(4000);
				

				Methods4AddPlace.addPlace( webdriver, foldername, errorname, error, entersearchfield, expectedautosuggestionaddress, expectedaddress, finalsavedaddress, placename);				
			    Thread.sleep(1000);
			    
				//After adding a place from alerts then reclick on alerts to create a location based alert.
				WebLocatorMethods.javascriptExecutorClickByClass(webdriver, "webalertsicon.class", 180);

				WebLocatorMethods.javascriptExecutorClickByClass(webdriver, "webaddanalerticon.class", 180);

				WebLocatorMethods.clickByCssSelector(webdriver, "webselectalerttypelbalertheader.css", 180);
				Thread.sleep(1000);
			
		        JavascriptExecutor javascript = (JavascriptExecutor) webdriver;
		        javascript.executeScript("window.scrollBy(0,200)", "");   
		        
		        WebLocatorMethods.selectPlaceClickByXpath(webdriver, placename, "websavedaddedplacename.xpath", 40);
		        Thread.sleep(1000);
		        javascript.executeScript("window.scrollBy(0,-400)", ""); 
	
				
				log.info("Check text on customize alert boundary page.");
		        
				try
				{
					String customizealertboundaryheader = WebLocatorMethods.getTextByCSS(webdriver, "webcustomizealertboundaryheader.css", 180);
					Assert.assertEquals(customizealertboundaryheader, "Customize alert boundary");
					
					String customizealertboundaryplaceheader = WebLocatorMethods.getTextByCSS(webdriver, "webalertboundaryplaceheader.css", 30);
					Assert.assertEquals(customizealertboundaryplaceheader, placename);
					
					String customizealertboundaryplaceaddress = WebLocatorMethods.getTextByCSS(webdriver, "webalertboundaryplaceaddress.css", 30);
					Assert.assertEquals(customizealertboundaryplaceaddress, finalsavedaddress);
					
					String customizealertboundarydescription = WebLocatorMethods.getTextByCSS(webdriver, "webalertboundarydescription.css", 30);
					Assert.assertEquals(customizealertboundarydescription, "Adjust the distance to be alerted farther away (Optional)");
	
					
				    int size300m = WebLocatorMethods.sizeByCSS(webdriver, "webalertboundary300m.css", 40);
				    Assert.assertEquals(size300m, 1);
				    
				    int sizehalfm = WebLocatorMethods.sizeByCSS(webdriver, "webalertboundaryhalfmi.css", 40);
				    Assert.assertEquals(sizehalfm, 1);
				    
				    int size1m = WebLocatorMethods.sizeByCSS(webdriver, "webalertboundary1m.css", 40);
				    Assert.assertEquals(size1m, 1);
				    
				    int size5m = WebLocatorMethods.sizeByCSS(webdriver, "webalertboundary5m.css", 40);
				    Assert.assertEquals(size5m, 1);
				    
				    int size10m = WebLocatorMethods.sizeByCSS(webdriver, "webalertboundary10m.css", 40);
				    Assert.assertEquals(size10m, 1);
				    
				    int size25m = WebLocatorMethods.sizeByCSS(webdriver, "webalertboundary25m.css", 40);
				    Assert.assertEquals(size25m, 1);
					
				}
				catch(AssertionError e)
				{ 
					log.info("Failed text check on alert boundary page.");
					log.error("This is an exception", e);
					errorname = "failedtextcheckonalertboundarypage";
					ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
					softAssert.fail();
				}
				
				
				WebLocatorMethods.javascriptExecutorClickByCSSSelector(webdriver, "webalertboundary1m.css", 30);

				WebLocatorMethods.clickByCssSelector(webdriver, "webalertboundarynextbtn.css", 180);
				
				String selectfamilymembersheader = WebLocatorMethods.getTextByCSS(webdriver, "webalertselectfamilymembersheader.css", 180);
				Assert.assertEquals(selectfamilymembersheader, "Select family members");
				
				
				log.info("Check family member pic, name, and checkbox exists.");
				
				try
				{
					int familymemberpic1 = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember1pic.css", 60);
					Assert.assertEquals(familymemberpic1, 1);
					
					int familymemberpic2 = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember2pic.css", 60);
					Assert.assertEquals(familymemberpic2, 1);
					
					int familymemberpic3 = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember3pic.css", 60);
					Assert.assertEquals(familymemberpic3, 1);
					
					int familymember1name = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember1name.css", 60);
					Assert.assertEquals(familymember1name, 1);
					
					int familymember2name = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember2name.css", 60);
					Assert.assertEquals(familymember2name, 1);
					
					int familymember3name = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember3name.css", 60);
					Assert.assertEquals(familymember3name, 1);
					
					int familymember1checkbox = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember1checkbox.css", 60);
					Assert.assertEquals(familymember1checkbox, 1);
					
					int familymember2checkbox = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember2checkbox.css", 60);
					Assert.assertEquals(familymember2checkbox, 1);
					
					int familymember3checkbox = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember3checkbox.css", 60);
					Assert.assertEquals(familymember3checkbox, 1);
				}
				catch(AssertionError e)
				{ 
					log.info("Missing member pic name checkbox on adding alert.");
					log.error("This is an exception", e);
					errorname = "missingmemberpicnamecheckboxonaddingalert";
					ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
					softAssert.fail();
				}

				WebLocatorMethods.clickByCssSelector(webdriver, "webalertselectfamilymember1checkbox.css", 30);
				
				int isselectedcheckbox1 = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember1checkboxchecked.css", 40);
				
				WebLocatorMethods.clickByCssSelector(webdriver, "webalertselectfamilymember2checkbox.css", 30);
			
				int isselectedcheckbox2 = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember2checkboxchecked.css", 40);
				
				WebLocatorMethods.clickByCssSelector(webdriver, "webalertselectfamilymember3checkbox.css", 30);
				
				int isselectedcheckbox3 = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember3checkboxchecked.css", 40);
				

				log.info("Check next button exists.");
				Thread.sleep(2000);
				
				if (isselectedcheckbox1 == 1 && isselectedcheckbox2 == 1 && isselectedcheckbox3 == 1)
				{
					try
					{

						String nextbtntext = WebLocatorMethods.getTextByCSS(webdriver, "webalertselectfamilynextbtn.css", 120);
						Assert.assertEquals(nextbtntext, "Next");
					}
					catch(AssertionError e)
					{ 
						log.info("Missing next button on selecting family members on alert.");
						log.error("This is an exception", e);
						errorname = "missingnextbtnonselectingfamilymembersonalert";
						ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
						softAssert.fail();
					}
					
				}
				else
				{
					log.error("Failed Assertion. Check all checkboxes, but no next button.");
				}
				

				WebLocatorMethods.javascriptExecutorClickByCSSSelector(webdriver, "webalertselectfamilynextbtn.css", 180);
				
				log.info("Check review add web alert page.");
				
				try
				{
		
					String revieweditalertheadertext = WebLocatorMethods.getTextByCSS(webdriver, "webalertrevieweditalertpageheader.css", 50);
					Assert.assertEquals(revieweditalertheadertext, "Review/Edit alert");
					
					String alertlocationheadertext = WebLocatorMethods.getTextByCSS(webdriver, "webalertrevieweditalertlocationheader.css", 30);
					Assert.assertEquals(alertlocationheadertext, "Alert Location");
					
					String alertlocationeditlinktext = WebLocatorMethods.getTextByCSS(webdriver, "webalertrevieweditalertlocationedit.css", 30);
					Assert.assertEquals(alertlocationeditlinktext, "Edit");
					
					int placeiconexists = WebLocatorMethods.sizeByClass(webdriver, "webalertreviewlocationicon.class", 30);
					Assert.assertEquals(placeiconexists, 1);
					System.out.println("placeiconexists: "+placeiconexists);
					
					String locationname = WebLocatorMethods.getTextByClassName(webdriver, "webalertreviewlocationame.class", 30);
					Assert.assertEquals(locationname, placename);
					
					String locationaddress = WebLocatorMethods.getTextByClassName(webdriver, "webalertreviewlocationaddress.class", 30);
					Assert.assertEquals(locationaddress, finalsavedaddress);
					
					int alertboundaryexists = WebLocatorMethods.sizeByClass(webdriver, "webalertreviewlocationalertboundarycircle.class", 30);
					Assert.assertEquals(alertboundaryexists, 1);
					System.out.println("alertboundaryexists: "+alertboundaryexists);
					
					String alertboundarytext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewlocationalertboundarytext.css", 30);
					Assert.assertEquals(alertboundarytext, "Alert Boundary: 1 mi");
					
					String familymemberstext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewfamilymembersheader.css", 30);
					Assert.assertEquals(familymemberstext, "Family Members");
					
					String editfamilymemberstext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewfamilymembersedit.css", 30);
					Assert.assertEquals(editfamilymemberstext, "Edit");
					
					//Thread.sleep(1000);
					int member1avatarexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertreviewfamilymember1avatar.css", 180);
					Assert.assertEquals(member1avatarexists, 1);
					System.out.println("member1avatarexists: "+member1avatarexists);
					
					int member1nameexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertreviewfamilymember1name.css", 30);
					Assert.assertEquals(member1nameexists, 1);
					System.out.println("member1nameexists: "+member1nameexists);
					
					int member2avatarexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertreviewfamilymember2avatar.css", 30);
					Assert.assertEquals(member2avatarexists, 1);
					System.out.println("member2avatarexists: "+member2avatarexists);
					
					int member2nameexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertreviewfamilymember2name.css", 30);
					Assert.assertEquals(member2nameexists, 1);
					System.out.println("member2nameexists: "+member2nameexists);
					
					int member3avatarexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertreviewfamilymember3avatar.css", 30);
					Assert.assertEquals(member3avatarexists, 1);
					System.out.println("member3avatarexists: "+member3avatarexists);
					
					int member3nameexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertreviewfamilymember3name.css", 30);
					Assert.assertEquals(member3nameexists, 1);
					System.out.println("member3nameexists: "+member3nameexists);
					
					String alertmeupontext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewnalertmeuponheader.css", 30);
					Assert.assertEquals(alertmeupontext, "Alert me upon");
					
					String arrivaltext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewarrivaltext.css", 30);
					Assert.assertEquals(arrivaltext, "Arrival");
					
					String departuretext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewdeparturetext.css", 30);
					Assert.assertEquals(departuretext, "Departure");
				}
				catch(AssertionError e)
				{ 
					log.info("Failed on review add web alert pg.");
					log.error("This is an exception", e);
					errorname = "failedonreviewaddwebalertpg";
					ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
					softAssert.fail();
				}
				
				
				WebLocatorMethods.clickByCssSelector(webdriver, "webalertreviewarrivalcheckbox.css", 30);
				WebLocatorMethods.clickByCssSelector(webdriver, "webalertreviewdeparturecheckbox.css", 30);
				
				//Scroll elements into view
				//actionsMoveToElementandPageDown works on Chrome, but not Firefox
				//WebLocatorMethods.actionsMoveToElementAndPageDownByCSS(webdriver, "webalertreviewwhodoyouwanttonotifyheader.css", 30);
				//WebLocatorMethods.actionsMoveToElementAndPageDownByCSS(webdriver, "webalertreviewnotifytext.css", 30);

		        javascript.executeScript("window.scrollBy(0,350)", "");
				
				log.info("Check review add web alert page notify header text.");
				
				try
				{
					String notifyheadertext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewwhodoyouwanttonotifyheader.css", 30);
					Assert.assertEquals(notifyheadertext, "Who do you want to notify?");
					
					String notifytext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewnotifytext.css", 30);
					Assert.assertEquals(notifytext, "You will be alerted via a VZ Family Locator notification.");			
				}
				catch(AssertionError e)
				{ 
					log.info("Fail notify header text on review and web alert page.");
					log.error("This is an exception", e);
					errorname = "failnotifyheadertextonreviewaddwebalertpg";
					ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
					softAssert.fail();
				}
				
				Boolean nocontactstextexists = WebLocatorMethods.existsSizeNotZeroByClass(webdriver, "webalertreviewnocontacts.class", 30);
				if (nocontactstextexists == true)
				{
					Methods4AddContact.addContacts(webdriver, foldername, errorname, error, contactname, phone, email);
					Thread.sleep(1000);
				}
				else
				{
					log.info("There is a contacts list.");
				}

				
				//Scroll elements into view

				log.info("Check review add web alert page notify sms, email, A1 text.");
				
				try
				{
					WebLocatorMethods.actionsMoveToElementByClass(webdriver, "webalertreviewSMScontactheader.class", 30);
					log.info("Moved to SMS element.");
					String smstext = WebLocatorMethods.getTextByClassName(webdriver, "webalertreviewSMScontactheader.class", 30);
					Assert.assertEquals(smstext, "SMS");
					Thread.sleep(1000);
					
					WebLocatorMethods.actionsMoveToElementByCSS(webdriver, "webalertreviewEmailcontactheader.css", 30);
					log.info("Moved to Email element.");
					String emailtext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewEmailcontactheader.css", 30);
					Assert.assertEquals(emailtext, "Email");
					Thread.sleep(1000);
					
					WebLocatorMethods.actionsMoveToElementByCSS(webdriver, "webalertreviewA1contacttext.css", 30);
					log.info("Moved to A1 element.");
					String A1text = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewA1contacttext.css", 30);
					Assert.assertEquals(A1text, "A1");
					Thread.sleep(1000);
					
				}
				catch(AssertionError e)
				{ 
					log.info("Fail notify sms email A1 text on review add web alert page.");
					log.error("This is an exception", e);
					errorname = "failnotifysmsemailA1textonreviewaddwebalertpg";
					ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
					softAssert.fail();
				}
				

				WebLocatorMethods.actionsMoveToElementByCSS(webdriver, "webalertreviewA1contactSMScheckbox.css", 30);
				log.info("Moved to SMS checkbox.");
				WebLocatorMethods.clickByCssSelector(webdriver, "webalertreviewA1contactSMScheckbox.css", 30);
				Thread.sleep(1000);
			
				WebLocatorMethods.actionsMoveToElementByCSS(webdriver, "webalertreviewA1contactEmailcheckbox.css", 30);
				log.info("Moved to Email checkbox.");
				WebLocatorMethods.clickByCssSelector(webdriver, "webalertreviewA1contactEmailcheckbox.css", 30);
				
				Thread.sleep(200);
				
				log.info("Check back button exists on review add web alert page.");
				
				try
				{
					WebLocatorMethods.actionsMoveToElementByXpath(webdriver, "webalertreviewbackbtn.xpath", 30);
				    int backbtnexists = WebLocatorMethods.sizeByXpath(webdriver, "webalertreviewbackbtn.xpath", 30);
				    Assert.assertEquals(backbtnexists, 1);
				}
				catch(AssertionError e)
				{ 
					log.info("Missing back btn on review add web alert page.");
					log.error("This is an exception", e);
					errorname = "missingbackbtnonreviewaddwebalertpg";
					ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
					softAssert.fail();
				}
				
			    
			    
				WebLocatorMethods.actionsMoveToElementByCSS(webdriver, "webalertreviewsavebtn.css", 30);
				WebLocatorMethods.javascriptExecutorClickByCSSSelector(webdriver, "webalertreviewsavebtn.css", 30);
				Thread.sleep(60);
				
				//Need this line or if there is a long list of alerts, you can't see the newly created one. Have to click somewhere then scroll.
				WebLocatorMethods.clickByCssSelector(webdriver, "webalertaddedclickonbellicontoscrolluptoreachnewlyaddedalert.css", 30);
				WebLocatorMethods.javscriptexecutorScrollIntoViewContainingTextByXpath(webdriver, placename, "webalertaddedinlist.xpath", 30);
				log.info("Alert was created.");

				
			}
			catch(Exception e)
			{ 
				log.info("Something failed on adding alerts.");
				log.error("This is an exception", e);
				errorname = "failedtoaddalert";
				ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
			}

	
			softAssert.assertAll();
	}
	
	
	public static void addLocationBasedAlertWithoutAddingPlace (WebDriver webdriver, String foldername, String errorname, String error, String finalsavedaddress, String placename, String contactname, String phone, String email) throws InterruptedException, IOException
	{

		try
		{
		
			WebLocatorMethods.javascriptExecutorClickByClass(webdriver, "webalertsicon.class", 180);

			WebLocatorMethods.javascriptExecutorClickByClass(webdriver, "webaddanalerticon.class", 180);

			
			log.info("Check select alert page.");
			
			try
			{
				String alerttypeheader = WebLocatorMethods.getTextByCSS(webdriver, "webselectalerttypeheader.css", 180);
				Assert.assertEquals(alerttypeheader, "Select alert type");
				
				String lbalertheader = WebLocatorMethods.getTextByCSS(webdriver, "webselectalerttypelbalertheader.css", 30);
				Assert.assertEquals(lbalertheader, "Arrival/Departure Alert");
				
				String lbalertdescription = WebLocatorMethods.getTextByCSS(webdriver, "webselectalerttypelbalertdescription.css", 30);
				Assert.assertEquals(lbalertdescription, "Receive an alert when your family members leave or arrive.");
				
				String schedalertheader = WebLocatorMethods.getTextByCSS(webdriver, "webselectalerttypeschedalertheader.css", 30);
				Assert.assertEquals(schedalertheader, "Scheduled Alert");
				
				String schedalertdescription = WebLocatorMethods.getTextByCSS(webdriver, "webselectalerttypeschedalertdescription.css",30);
				Assert.assertEquals(schedalertdescription, "Receive an alert with a family member's location at a specific time.");
				
			}
			catch(AssertionError e)
			{ 
				log.info("Failed text check on select alert type page.");
				log.error("This is an exception", e);
				errorname = "failedtextcheckonselectalerttypepage";
				ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
				softAssert.fail();
			}
			
			//Click location based alert and choose a place
			WebLocatorMethods.clickByCssSelector(webdriver, "webselectalerttypelbalertheader.css", 30);
			WebLocatorMethods.waitXSecsAndGetVisibleElementByCSS(webdriver, "webselectalertlocationaddaplace.css", 180);			 
	        
	        WebLocatorMethods.selectPlaceClickByXpath(webdriver, placename, "websavedaddedplacename.xpath", 180);
	        

			
			log.info("Check text on customize alert boundary page.");
	        
			try
			{
				String customizealertboundaryheader = WebLocatorMethods.getTextByCSS(webdriver, "webcustomizealertboundaryheader.css", 180);
				Assert.assertEquals(customizealertboundaryheader, "Customize alert boundary");
				
				String customizealertboundaryplaceheader = WebLocatorMethods.getTextByCSS(webdriver, "webalertboundaryplaceheader.css", 30);
				Assert.assertEquals(customizealertboundaryplaceheader, placename);
				
				String customizealertboundaryplaceaddress = WebLocatorMethods.getTextByCSS(webdriver, "webalertboundaryplaceaddress.css", 30);
				Assert.assertEquals(customizealertboundaryplaceaddress, finalsavedaddress);
				
				String customizealertboundarydescription = WebLocatorMethods.getTextByCSS(webdriver, "webalertboundarydescription.css", 30);
				Assert.assertEquals(customizealertboundarydescription, "Adjust the distance to be alerted farther away (Optional)");

			    int size300m = WebLocatorMethods.sizeByCSS(webdriver, "webalertboundary300m.css", 40);
			    Assert.assertEquals(size300m, 1);
			    
			    int sizehalfm = WebLocatorMethods.sizeByCSS(webdriver, "webalertboundaryhalfmi.css", 40);
			    Assert.assertEquals(sizehalfm, 1);
			    
			    int size1m = WebLocatorMethods.sizeByCSS(webdriver, "webalertboundary1m.css", 40);
			    Assert.assertEquals(size1m, 1);
			    
			    int size5m = WebLocatorMethods.sizeByCSS(webdriver, "webalertboundary5m.css", 40);
			    Assert.assertEquals(size5m, 1);
			    
			    int size10m = WebLocatorMethods.sizeByCSS(webdriver, "webalertboundary10m.css", 40);
			    Assert.assertEquals(size10m, 1);
			    
			    int size25m = WebLocatorMethods.sizeByCSS(webdriver, "webalertboundary25m.css", 40);
			    Assert.assertEquals(size25m, 1);
				
			}
			catch(AssertionError e)
			{ 
				log.info("Failed text check on alert boundary page.");
				log.error("This is an exception", e);
				errorname = "failedtextcheckonalertboundarypage";
				ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
				softAssert.fail();
			}
			
			
			WebLocatorMethods.javascriptExecutorClickByCSSSelector(webdriver, "webalertboundary1m.css", 30);

			WebLocatorMethods.clickByCssSelector(webdriver, "webalertboundarynextbtn.css", 180);
			
			String selectfamilymembersheader = WebLocatorMethods.getTextByCSS(webdriver, "webalertselectfamilymembersheader.css", 180);
			Assert.assertEquals(selectfamilymembersheader, "Select family members");
			
			log.info("Check family member pic, name, and checkbox exists.");
			
			try
			{
				int familymemberpic1 = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember1pic.css", 60);
				Assert.assertEquals(familymemberpic1, 1);
				
				int familymemberpic2 = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember2pic.css", 60);
				Assert.assertEquals(familymemberpic2, 1);
				
				int familymemberpic3 = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember3pic.css", 60);
				Assert.assertEquals(familymemberpic3, 1);
				
				int familymember1name = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember1name.css", 60);
				Assert.assertEquals(familymember1name, 1);
				
				int familymember2name = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember2name.css", 60);
				Assert.assertEquals(familymember2name, 1);
				
				int familymember3name = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember3name.css", 60);
				Assert.assertEquals(familymember3name, 1);
				
				int familymember1checkbox = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember1checkbox.css", 60);
				Assert.assertEquals(familymember1checkbox, 1);
				
				int familymember2checkbox = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember2checkbox.css", 60);
				Assert.assertEquals(familymember2checkbox, 1);
				
				int familymember3checkbox = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember3checkbox.css", 60);
				Assert.assertEquals(familymember3checkbox, 1);
			}
			catch(AssertionError e)
			{ 
				log.info("Missing member pic name checkbox on adding alert.");
				log.error("This is an exception", e);
				errorname = "missingmemberpicnamecheckboxonaddingalert";
				ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
				softAssert.fail();
			}

			WebLocatorMethods.clickByCssSelector(webdriver, "webalertselectfamilymember1checkbox.css", 30);
						
			int isselectedcheckbox1 = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember1checkboxchecked.css", 40);
			
			WebLocatorMethods.clickByCssSelector(webdriver, "webalertselectfamilymember2checkbox.css", 30);
							
			int isselectedcheckbox2 = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember2checkboxchecked.css", 40);
			
			WebLocatorMethods.clickByCssSelector(webdriver, "webalertselectfamilymember3checkbox.css", 30);
							
			int isselectedcheckbox3 = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember3checkboxchecked.css", 40);
			
			
			log.info("Check next button exists.");
			Thread.sleep(2000);
			
			if (isselectedcheckbox1 == 1 && isselectedcheckbox2 == 1 && isselectedcheckbox3 == 1)
			{
				try
				{
					
					String nextbtntext = WebLocatorMethods.getTextByCSS(webdriver, "webalertselectfamilynextbtn.css", 180);
					Assert.assertEquals(nextbtntext, "Next");
				}
				catch(AssertionError e)
				{ 
					log.info("Missing next button on selecting family members on alert.");
					log.error("This is an exception", e);
					errorname = "missingnextbtnonselectingfamilymembersonalert";
					ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
					softAssert.fail();
				}
				
			}
			else
			{
				log.error("Failed Assertion. Check all checkboxes, but no next button.");
			}
			
			WebLocatorMethods.javascriptExecutorClickByCSSSelector(webdriver, "webalertselectfamilynextbtn.css", 180);
			
			log.info("Check review add web alert page.");
			
			try
			{
	
				String revieweditalertheadertext = WebLocatorMethods.getTextByCSS(webdriver, "webalertrevieweditalertpageheader.css", 50);
				Assert.assertEquals(revieweditalertheadertext, "Review/Edit alert");
				
	
				String alertlocationheadertext = WebLocatorMethods.getTextByCSS(webdriver, "webalertrevieweditalertlocationheader.css", 50);
				Assert.assertEquals(alertlocationheadertext, "Alert Location");
				
	
				String alertlocationeditlinktext = WebLocatorMethods.getTextByCSS(webdriver, "webalertrevieweditalertlocationedit.css", 50);
				Assert.assertEquals(alertlocationeditlinktext, "Edit");
				

				int placeiconexists = WebLocatorMethods.sizeByClass(webdriver, "webalertreviewlocationicon.class", 50);
				Assert.assertEquals(placeiconexists, 1);
				log.info("placeiconexists: "+placeiconexists);
				

				String locationname = WebLocatorMethods.getTextByClassName(webdriver, "webalertreviewlocationame.class", 50);
				Assert.assertEquals(locationname, placename);
				

				String locationaddress = WebLocatorMethods.getTextByClassName(webdriver, "webalertreviewlocationaddress.class", 50);
				Assert.assertEquals(locationaddress, finalsavedaddress);
				

				int alertboundaryexists = WebLocatorMethods.sizeByClass(webdriver, "webalertreviewlocationalertboundarycircle.class", 50);
				Assert.assertEquals(alertboundaryexists, 1);
				log.info("alertboundaryexists: "+alertboundaryexists);
				

				String alertboundarytext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewlocationalertboundarytext.css", 50);
				Assert.assertEquals(alertboundarytext, "Alert Boundary: 1 mi");
				

				String familymemberstext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewfamilymembersheader.css", 50);
				Assert.assertEquals(familymemberstext, "Family Members");
				

				String editfamilymemberstext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewfamilymembersedit.css", 50);
				Assert.assertEquals(editfamilymemberstext, "Edit");
				

				int member1avatarexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertreviewfamilymember1avatar.css", 50);
				Assert.assertEquals(member1avatarexists, 1);
				log.info("member1avatarexists: "+member1avatarexists);
				

				int member1nameexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertreviewfamilymember1name.css", 50);
				Assert.assertEquals(member1nameexists, 1);
				log.info("member1nameexists: "+member1nameexists);
				

				int member2avatarexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertreviewfamilymember2avatar.css", 50);
				Assert.assertEquals(member2avatarexists, 1);
				log.info("member2avatarexists: "+member2avatarexists);
				

				int member2nameexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertreviewfamilymember2name.css", 50);
				Assert.assertEquals(member2nameexists, 1);
				log.info("member2nameexists: "+member2nameexists);
				

				int member3avatarexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertreviewfamilymember3avatar.css", 50);
				Assert.assertEquals(member3avatarexists, 1);
				log.info("member3avatarexists: "+member3avatarexists);
				

				int member3nameexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertreviewfamilymember3name.css", 50);
				Assert.assertEquals(member3nameexists, 1);
				log.info("member3nameexists: "+member3nameexists);
				

				String alertmeupontext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewnalertmeuponheader.css", 50);
				Assert.assertEquals(alertmeupontext, "Alert me upon");
				

				String arrivaltext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewarrivaltext.css", 50);
				Assert.assertEquals(arrivaltext, "Arrival");
				

				String departuretext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewdeparturetext.css", 50);
				Assert.assertEquals(departuretext, "Departure");
			}
			catch(AssertionError e)
			{ 
				log.info("Failed on review add web alert page.");
				log.error("This is an exception", e);
				errorname = "failedonreviewaddwebalertpg";
				ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
				softAssert.fail();
			}
			
			
			WebLocatorMethods.clickByCssSelector(webdriver, "webalertreviewarrivalcheckbox.css", 30);
			WebLocatorMethods.clickByCssSelector(webdriver, "webalertreviewdeparturecheckbox.css", 30);
			
			
			//Scroll elements into view
			//actionsMoveToElementandPageDown works on Chrome, but not Firefox
			//WebLocatorMethods.actionsMoveToElementAndPageDownByCSS(webdriver, "webalertreviewwhodoyouwanttonotifyheader.css", 30);
			//WebLocatorMethods.actionsMoveToElementAndPageDownByCSS(webdriver, "webalertreviewnotifytext.css", 30);

			JavascriptExecutor javascript = (JavascriptExecutor) webdriver;
	        javascript.executeScript("window.scrollBy(0,350)", "");
			
			log.info("Check review add web alert page notify header text.");
			
			try
			{
				String notifyheadertext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewwhodoyouwanttonotifyheader.css", 30);
				Assert.assertEquals(notifyheadertext, "Who do you want to notify?");
				
				String notifytext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewnotifytext.css", 30);
				Assert.assertEquals(notifytext, "You will be alerted via a VZ Family Locator notification.");			
			}
			catch(AssertionError e)
			{ 
				log.info("Fail notify header text on review add web alert page.");
				log.error("This is an exception", e);
				errorname = "failnotifyheadertextonreviewaddwebalertpg";
				ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
				softAssert.fail();
			}
			
			
			//If there is no contacts, add contact
			Boolean nocontactstextexists = WebLocatorMethods.existsSizeNotZeroByClass(webdriver, "webalertreviewnocontacts.class", 30);
			if (nocontactstextexists == true)
			{
				Methods4AddContact.addContacts(webdriver, foldername, errorname, error, contactname, phone, email);
				Thread.sleep(1000);
			}
			else
			{
				log.info("There is a contacts list.");
			}

			
			//Scroll elements into view

			log.info("Check review add web alert page notify sms, email, A1 text.");
			
			try
			{
				WebLocatorMethods.actionsMoveToElementByClass(webdriver, "webalertreviewSMScontactheader.class", 30);
				log.info("Moved to SMS element.");
				String smstext = WebLocatorMethods.getTextByClassName(webdriver, "webalertreviewSMScontactheader.class", 30);
				Assert.assertEquals(smstext, "SMS");
				Thread.sleep(1000);
				
				WebLocatorMethods.actionsMoveToElementByCSS(webdriver, "webalertreviewEmailcontactheader.css", 30);
				log.info("Moved to Email element.");
				String emailtext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewEmailcontactheader.css", 30);
				Assert.assertEquals(emailtext, "Email");
				Thread.sleep(1000);
				
				WebLocatorMethods.actionsMoveToElementByCSS(webdriver, "webalertreviewA1contacttext.css", 30);
				log.info("Moved to A1 element.");
				String A1text = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewA1contacttext.css", 30);
				Assert.assertEquals(A1text, "A1");
				Thread.sleep(1000);
				
			}
			catch(AssertionError e)
			{ 
				log.info("Fail notify sms email A1 text on review add web alert page.");
				log.error("This is an exception", e);
				errorname = "failnotifysmsemailA1textonreviewaddwebalertpg";
				ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
				softAssert.fail();
			}
			

			WebLocatorMethods.actionsMoveToElementByCSS(webdriver, "webalertreviewA1contactSMScheckbox.css", 30);
			log.info("Moved to SMS checkbox.");
			WebLocatorMethods.clickByCssSelector(webdriver, "webalertreviewA1contactSMScheckbox.css", 30);
			Thread.sleep(1000);
		
			WebLocatorMethods.actionsMoveToElementByCSS(webdriver, "webalertreviewA1contactEmailcheckbox.css", 30);
			log.info("Moved to Email checkbox.");
			WebLocatorMethods.clickByCssSelector(webdriver, "webalertreviewA1contactEmailcheckbox.css", 30);
			
			Thread.sleep(200);
			
			log.info("Check back button exists on review add web alert page.");
			
			try
			{
				WebLocatorMethods.actionsMoveToElementByXpath(webdriver, "webalertreviewbackbtn.xpath", 30);
			    int backbtnexists = WebLocatorMethods.sizeByXpath(webdriver, "webalertreviewbackbtn.xpath", 30);
			    Assert.assertEquals(backbtnexists, 1);
			}
			catch(AssertionError e)
			{ 
				log.info("Missing back button on review add web alert page.");
				log.error("This is an exception", e);
				errorname = "missingbackbtnonreviewaddwebalertpg";
				ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
				softAssert.fail();
			}
			
		    
		    
			WebLocatorMethods.actionsMoveToElementByCSS(webdriver, "webalertreviewsavebtn.css", 30);
			WebLocatorMethods.javascriptExecutorClickByCSSSelector(webdriver, "webalertreviewsavebtn.css", 30);
			Thread.sleep(60);
			
			//Need this line or if there is a long list of alerts, you can't see the newly created one. Have to click somewhere then scroll.
			WebLocatorMethods.clickByCssSelector(webdriver, "webalertaddedclickonbellicontoscrolluptoreachnewlyaddedalert.css", 30);
			WebLocatorMethods.javscriptexecutorScrollIntoViewContainingTextByXpath(webdriver, placename, "webalertaddedinlist.xpath", 30);
			log.info("Alert was created.");
			
		}
		catch(Exception e)
		{ 
			log.info("Something failed on adding alerts.");
			log.error("This is an exception", e);
			errorname = "failedtoaddalert";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
		}


		softAssert.assertAll();
	}
	
}
