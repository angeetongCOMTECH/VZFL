package webMethods;

import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import common.DateTimeMethods;
import common.ScreenshotURL;
import locators.WebLocatorMethods;

public class Methods4AddScheduledAlerts {
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Dec 2017  ***//
	//***                                  ***//
	//****************************************//

	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = Logger.getLogger(Methods4AddScheduledAlerts.class);
	static String schedalerttime = "";
	static String reviewschedalerttime = "";
		
	public static void addScheduledAlert (WebDriver webdriver, String foldername, String errorname, String error, String contactname, String phone, String email, String timezoneid, String setalertxminsintofuture, String timezone) throws InterruptedException, IOException
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
				
				try
				{
					//Click on scheduled alerts to create a scheduled alert.
					WebLocatorMethods.clickByCssSelector(webdriver, "webselectalerttypeschedalertheader.css", 30);
					
					//Needed longer wait before and after click or get stuck loading the add place page when clicked
					String schedulealerttimetext = WebLocatorMethods.getTextByCSS(webdriver, "websetschedulealerttimeheader.css", 180);
					Assert.assertEquals(schedulealerttimetext, "Schedule alert time");
					
					String selecttimetext = WebLocatorMethods.getTextByCSS(webdriver,"websetschedulealertselecttimeheader.css", 30);
					Assert.assertEquals(selecttimetext, "Select time");
					
					//The time input field for scheduled alert is not clickable nor does actions work, so had to sendKeys this way.
			        
					schedalerttime = DateTimeMethods.addXminToCurrentTimeInSpecificTimezone(webdriver, timezoneid, setalertxminsintofuture);
					
					WebElement timeinput = WebLocatorMethods.waituntilXsecondsisDisplayedByCSS(webdriver, "websetschedulealerttimeinput.css", 180);
					timeinput.sendKeys(Keys.DELETE);
					timeinput.sendKeys(schedalerttime);

					WebLocatorMethods.clickByClassName(webdriver, "websetschedulealertclicktorefresh.class", 30);
					
					String repeatonthesedaystext = WebLocatorMethods.getTextByXpath(webdriver, "websetschedulealertrepeatonthesedaysheader.xpath", 60);
					Assert.assertEquals(repeatonthesedaystext, "Repeat on these days");
					
					log.info("Check by default Monday through Friday checkboxes are checked.");
					
					String sundaytext = WebLocatorMethods.getTextByCSS(webdriver, "websetschedulealertsundaytext.css", 30);
					Assert.assertEquals(sundaytext, "Sunday");
					Boolean sundaycheckbox = WebLocatorMethods.existsSizeNotZeroByCSS(webdriver, "websetschedulealertsundaycheckbox.css", 30);
					Assert.assertEquals(sundaycheckbox, (Boolean) true);
					
					String mondaytext = WebLocatorMethods.getTextByCSS(webdriver, "websetschedulealertmondaytext.css", 30);
					Assert.assertEquals(mondaytext, "Monday");
					Boolean mondaycheckbox = WebLocatorMethods.existsSizeNotZeroByCSS(webdriver, "websetschedulealertmondaycheckboxchecked.css", 30);
					Assert.assertEquals(mondaycheckbox, (Boolean) true);
					
					String tuesdaytext = WebLocatorMethods.getTextByCSS(webdriver, "websetschedulealerttuesdaytext.css", 30);
					Assert.assertEquals(tuesdaytext, "Tuesday");
					Boolean tuesdaycheckbox = WebLocatorMethods.existsSizeNotZeroByCSS(webdriver, "websetschedulealerttuesdaycheckboxchecked.css", 30);
					Assert.assertEquals(tuesdaycheckbox, (Boolean) true);
					
					String wednesdaytext = WebLocatorMethods.getTextByCSS(webdriver, "websetschedulealertwednesdaytext.css", 30);
					Assert.assertEquals(wednesdaytext, "Wednesday");
					Boolean wednesdaycheckbox = WebLocatorMethods.existsSizeNotZeroByCSS(webdriver, "websetschedulealertwednesdaycheckboxchecked.css", 30);
					Assert.assertEquals(wednesdaycheckbox, (Boolean) true);
					
					String thursdaytext = WebLocatorMethods.getTextByCSS(webdriver, "websetschedulealertthursdaytext.css", 30);
					Assert.assertEquals(thursdaytext, "Thursday");
					Boolean thursdaycheckbox = WebLocatorMethods.existsSizeNotZeroByCSS(webdriver, "websetschedulealertthursdaycheckboxchecked.css", 30);
					Assert.assertEquals(thursdaycheckbox, (Boolean) true);
					
					String fridaytext = WebLocatorMethods.getTextByCSS(webdriver, "websetschedulealertfridaytext.css", 30);
					Assert.assertEquals(fridaytext, "Friday");
					Boolean fridaycheckbox = WebLocatorMethods.existsSizeNotZeroByCSS(webdriver, "websetschedulealertfridaycheckboxchecked.css", 30);
					Assert.assertEquals(fridaycheckbox, (Boolean) true);
					
					String saturdaytext = WebLocatorMethods.getTextByCSS(webdriver, "websetschedulealertsaturdaytext.css", 30);
					Assert.assertEquals(saturdaytext, "Saturday");
					Boolean saturdaycheckbox = WebLocatorMethods.existsSizeNotZeroByCSS(webdriver, "websetschedulealertsaturdaycheckbox.css", 30);
					Assert.assertEquals(saturdaycheckbox, (Boolean) true);
										
				}
				catch(AssertionError e)
				{ 
					log.info("Schedule alert time screen has issues.");
					log.error("This is an exception", e);
					errorname = "schedulealerttimescreenissues";
					ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
					softAssert.fail();
				}
				
				log.info("Checked off Saturday and Sunday.");
				WebLocatorMethods.clickByCssSelector(webdriver, "websetschedulealertsundaycheckbox.css", 30);
				WebLocatorMethods.clickByCssSelector(webdriver, "websetschedulealertsaturdaycheckbox.css", 30);
				
				try
				{
					Boolean checkedsundaycheckbox = WebLocatorMethods.existsSizeNotZeroByCSS(webdriver, "websetschedulealertsundaycheckboxchecked.css", 180);
					Assert.assertEquals(checkedsundaycheckbox, (Boolean) true);
									
					Boolean checkedsaturdaycheckbox = WebLocatorMethods.existsSizeNotZeroByCSS(webdriver, "websetschedulealertsaturdaycheckboxchecked.css", 180);
					Assert.assertEquals(checkedsaturdaycheckbox, (Boolean) true);
				
					String backbtntext = WebLocatorMethods.getTextByCSS(webdriver, "websetschedulealertbackbtn.css", 30);
					Assert.assertEquals(backbtntext, "Back");
				}
				catch(AssertionError e)
				{ 
					log.info("Saturday and Sunday not checked.");
					log.error("This is an exception", e);
					errorname = "schedulealertsaturdaysundaynotchecked";
					ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
					softAssert.fail();
				}
				
				WebLocatorMethods.clickByCssSelector(webdriver, "websetschedlealertnextbtn.css", 30);
				
				
				log.info("Select family members");
				
				try
				{
					String selectfamilymemberstext = WebLocatorMethods.getTextByCSS(webdriver, "webalertselectfamilymembersheader.css", 60);
					Assert.assertEquals(selectfamilymemberstext, "Select family members");
					
					int familymember1picexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember1pic.css", 60);
					Assert.assertEquals(familymember1picexists, 1);
					
					int familymember1nameexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember1name.css", 60);
					Assert.assertEquals(familymember1nameexists, 1);
					
					int familymember1checkboxexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember1checkbox.css", 60);
					Assert.assertEquals(familymember1checkboxexists, 1);
					
					int familymember2picexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember2pic.css", 60);
					Assert.assertEquals(familymember2picexists, 1);
					
					int familymember2nameexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember2name.css", 60);
					Assert.assertEquals(familymember2nameexists, 1);
					
					int familymember2checkboxexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember2checkbox.css", 60);
					Assert.assertEquals(familymember2checkboxexists, 1);
					
					int familymember3picexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember3pic.css", 60);
					Assert.assertEquals(familymember3picexists, 1);
					
					int familymember3nameexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember3name.css", 60);
					Assert.assertEquals(familymember3nameexists, 1);
					
					int familymember3checkboxexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember3checkbox.css", 60);
					Assert.assertEquals(familymember3checkboxexists, 1);
					
					WebLocatorMethods.clickByCssSelector(webdriver, "webalertselectfamilymember1checkbox.css", 60);
					WebLocatorMethods.clickByCssSelector(webdriver, "webalertselectfamilymember2checkbox.css", 60);
					WebLocatorMethods.clickByCssSelector(webdriver, "webalertselectfamilymember3checkbox.css", 60);
					
					int member1selected = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember1checkboxchecked.css", 180);
					Assert.assertEquals(member1selected, 1);
					
					int member2selected = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember2checkboxchecked.css", 180);
					Assert.assertEquals(member2selected, 1);
					
					int member3selected = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember3checkboxchecked.css", 180);
					Assert.assertEquals(member3selected, 1);
					
					int familymemberbackbtn = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymemberbackbtn.css", 30);
					Assert.assertEquals(familymemberbackbtn, 1);
					
					WebLocatorMethods.clickByCssSelector(webdriver, "webalertselectfamilynextbtn.css", 180);
					
				}
				catch(AssertionError e)
				{ 
					log.info("Scheduled alert select family members screen has issues.");
					log.error("This is an exception", e);
					errorname = "schedulealertfamilymemberscreenissues";
					ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
					softAssert.fail();
				}
				
				log.info("On Review/Edit alert page");
				
				try
				{
					String revieweditalertheadertext = WebLocatorMethods.getTextByCSS(webdriver, "webreviewschedulealertheader.css", 180);
					Assert.assertEquals(revieweditalertheadertext, "Review/Edit alert");
					
					String familymembersheadertext = WebLocatorMethods.getTextByCSS(webdriver, "webreviewschedulealertfamilymembersheader.css", 30);
					Assert.assertEquals(familymembersheadertext, "Family Members");
					
					String familymemberseditlinktext = WebLocatorMethods.getTextByCSS(webdriver, "webreviewschedulealertfamilymemberseditlink.css", 30);
					Assert.assertEquals(familymemberseditlinktext, "Edit");
					
					int reviewfamilymember1picexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember1pic.css", 30);
					Assert.assertEquals(reviewfamilymember1picexists, 1);
					int reviewfamilymember1nameexists = WebLocatorMethods.sizeByCSS(webdriver, "webreviewschedulealertfamilymembername1.css", 30);
					Assert.assertEquals(reviewfamilymember1nameexists, 1);
					
					int reviewfamilymember2picexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember2pic.css", 30);
					Assert.assertEquals(reviewfamilymember2picexists, 1);
					int reviewfamilymember2nameexists = WebLocatorMethods.sizeByCSS(webdriver, "webreviewschedulealertfamilymembername2.css", 30);
					Assert.assertEquals(reviewfamilymember2nameexists, 1);
					
					int reviewfamilymember3picexists = WebLocatorMethods.sizeByCSS(webdriver, "webalertselectfamilymember3pic.css", 30);
					Assert.assertEquals(reviewfamilymember3picexists, 1);
					int reviewfamilymember3nameexists = WebLocatorMethods.sizeByCSS(webdriver, "webreviewschedulealertfamilymembername3.css", 30);
					Assert.assertEquals(reviewfamilymember3nameexists, 1);
				
					String alertimeheadertext = WebLocatorMethods.getTextByCSS(webdriver, "webreviewschedulealertalerttimeheader.css", 30);
					Assert.assertEquals(alertimeheadertext, "Alert Time");
					
					String alertimeeditlink = WebLocatorMethods.getTextByCSS(webdriver, "webreviewschedulealertalerttimeeditlink.css", 30);
					Assert.assertEquals(alertimeeditlink, "Edit");
					
					String schedalertimetext = WebLocatorMethods.getTextByClassName(webdriver, "webreviewschedulealertstarttime.class", 30);
				    reviewschedalerttime = schedalerttime +" "+ timezone;				
					Assert.assertEquals(schedalertimetext, reviewschedalerttime);
					
					String schedalertrepeatstext = WebLocatorMethods.getTextByClassName(webdriver, "webreviewschedulealertactivedays.class", 30);
					Assert.assertEquals(schedalertrepeatstext, "Repeats on, Su. M. T. W. Th. F. S");
					
					JavascriptExecutor javascript = (JavascriptExecutor) webdriver;
			        javascript.executeScript("window.scrollBy(0,350)", "");
					
					log.info("Check review add web alert page notify header text.");
					
					String notifyheadertext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewwhodoyouwanttonotifyheader.css", 30);
					Assert.assertEquals(notifyheadertext, "Who do you want to notify?");
					
					String youwillbealertedtext = WebLocatorMethods.getTextByCSS(webdriver, "webalertreviewnotifytext.css", 30);
					Assert.assertEquals(youwillbealertedtext, "You will be alerted via a VZ Family Locator notification.");
					
				}
				catch(AssertionError e)
				{ 
					log.info("Review scheduled alert screen has issues.");
					log.error("This is an exception", e);
					errorname = "reviewschedulealertscreenissues";
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


				log.info("Check review add web schedule alert page notify sms, email, A1 text.");
				
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
					log.info("Fail notify sms email A1 text on review add web scheduled alert page.");
					log.error("This is an exception", e);
					errorname = "failnotifysmsemailA1textonreviewaddwebschedalertpg";
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
				
				log.info("Check back button exists on review add web scheduled alert page.");
				
				try
				{
					WebLocatorMethods.actionsMoveToElementByXpath(webdriver, "webalertreviewbackbtn.xpath", 30);
				    int backbtnexists = WebLocatorMethods.sizeByXpath(webdriver, "webalertreviewbackbtn.xpath", 30);
				    Assert.assertEquals(backbtnexists, 1);
				}
				catch(AssertionError e)
				{ 
					log.info("Missing back btn on review add web scheduled alert page.");
					log.error("This is an exception", e);
					errorname = "missingbackbtnonreviewaddwebschedalertpg";
					ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
					softAssert.fail();
				}
				
			    
			    
				WebLocatorMethods.actionsMoveToElementByCSS(webdriver, "webalertreviewsavebtn.css", 30);
				WebLocatorMethods.javascriptExecutorClickByCSSSelector(webdriver, "webalertreviewsavebtn.css", 30);
				Thread.sleep(60);
				
				List <WebElement> scheduledalerts = WebLocatorMethods.arrayofelementsbyCSS(webdriver, "webscheduledalertsinlistarray.css", 180);
				int scheduledalertssize = scheduledalerts.size();
				
				for (int i=0; i < scheduledalertssize; i++)
				{
					String schedalerttext = scheduledalerts.get(i).getText();
					
					if (schedalerttext.contains(reviewschedalerttime))
					{
						log.info("Scheduled alert has been created.");
						log.info("Scheduled alert text is "+schedalerttext);
						break;
					}
					else if ((i==scheduledalertssize-1) && !schedalerttext.contains(reviewschedalerttime))
					{
						log.info("Scheduled alert failed to be created.");
					}
				}
		}
		catch(Exception e)
		{ 
			log.info("Something failed on adding scheduled alerts.");
			log.error("This is an exception", e);
			errorname = "failedtoaddsheduledalert";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
		}


		softAssert.assertAll();
	}

}
