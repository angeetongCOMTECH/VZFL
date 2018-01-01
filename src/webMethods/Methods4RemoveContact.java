package webMethods;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import common.ScreenshotURL;
import locators.WebLocatorMethods;

public class Methods4RemoveContact {
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Dec 2017  ***//
	//***                                  ***//
	//****************************************//
	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = Logger.getLogger(Methods4RemoveContact.class);
	
	public static void removeContacts (WebDriver webdriver, String foldername, String errorname, String error) throws InterruptedException, IOException
	{
		WebLocatorMethods.waitXSecsAndGetVisibleElementByCSS(webdriver, "contactslink.css", 1000);
		WebLocatorMethods.javascriptExecutorClickByCSSSelector(webdriver, "contactslink.css", 30);
		WebLocatorMethods.waitXSecsAndGetVisibleElementByCSS(webdriver, "contactsheader.css", 60);
		String contactsheadertext = WebLocatorMethods.getTextByCSS(webdriver, "contactsheader.css",30);		
		Assert.assertEquals(contactsheadertext, "Contacts");
		
		log.info("Check add contact button exists.");
		
		try
		{
			int addbtnexists = WebLocatorMethods.sizeByClass(webdriver, "contactsaddcontactbutton.class", 30);
			Assert.assertEquals(addbtnexists, 1);
		}
		catch(AssertionError e)
		{ 
			log.info("Missing add contact button.");
			log.error("This is an exception", e);
			errorname = "missingaddcontactbutton";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
			softAssert.fail();
		}
	
		Boolean deletecontactsbtnexists = WebLocatorMethods.existsSizeNotZeroByClass(webdriver, "contactsdeletebutton.class", 300);	  
			
	    Boolean nocontactexist = WebLocatorMethods.existsSizeNotZeroByClass(webdriver, "nocontactsdefinedtext.class", 300);
		if (nocontactexist == true)
			{
			//If no contacts exist exit if/else statement.
			log.info("No contacts exist to delete.");
		}
		else if (deletecontactsbtnexists == true)
		{
			//If delete btn exists, then delete all contacts.
		         try
				  {
		        	 	 WebLocatorMethods.clickByClassName(webdriver, "contactsdeletebutton.class", 30);
		 			 log.info("On delete contacts page.");
					 log.info("Check delete contacts button and its select all link exists.");

					  
					  String deletecontactsheader = WebLocatorMethods.getTextByCSS(webdriver, "deletecontactspageheader.css", 30);
					  Assert.assertEquals(deletecontactsheader, "Delete Contacts");
					  String selectall = WebLocatorMethods.getTextByCSS(webdriver, "deletecontactsselectalllink.css", 30);
					  Assert.assertEquals(selectall, "Select All");
				  
				  }
				  catch(AssertionError e)
				  { 
					  log.info("Missing delete contacts button and select all link.");
					  log.error("This is an exception", e);
					  errorname = "missingdeletecontactsbuttonandselectalllink";
					  ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
					  softAssert.fail();
				  }

		         
		       try
		       {
		    	     log.info("Only compare the total list of names to the total list of checkboxes, because some contacts may not have both email and phone number, so the count will be off.");
		         int numberofcontactsnamestodelete = WebLocatorMethods.sizeByCSS(webdriver, "deletecontactsnamearray.css", 120);
		         int numberofcontactscheckboxestodelete = WebLocatorMethods.sizeByCSS(webdriver, "deletecontactsnotyetcheckedoffcheckboxesarray.css", 120);
		         
		         Assert.assertEquals(numberofcontactsnamestodelete, numberofcontactscheckboxestodelete);

		         log.info("Select all contacts to delete.");
		         WebLocatorMethods.javascriptExecutorClickByCSSSelector(webdriver, "deletecontactsselectalllink.css", 300);
		         
		         int numberofcheckedcontactscheckboxestodelete = WebLocatorMethods.sizeByCSS(webdriver, "deletecontactscheckedoffcheckboxesarray.css", 600);
		         Assert.assertEquals(numberofcheckedcontactscheckboxestodelete, numberofcontactscheckboxestodelete);
		         
		         
		       }
			   catch(AssertionError e)
			  { 
				  log.info("The number of contact names and checkboxes to delete doesn't match up.");
				  log.error("This is an exception", e);
				  errorname = "numberofcontactstodeletedoesntmatchup";
				  ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
				  softAssert.fail();
			  } 
		       
     
			 log.info("Check delete contacts cancel and remove button.");
			  
			  try
			  {
				  String cancelbtntext = WebLocatorMethods.getTextByCSS(webdriver, "deletecontactscancelbtn.css", 300);
				  Assert.assertEquals(cancelbtntext, "Cancel");
				  

				  String removebtntext = WebLocatorMethods.getTextByCSS(webdriver, "deletecontactsremovebtn.css", 300);
				  Assert.assertEquals(removebtntext, "Remove");
			  }
			  catch(AssertionError e)
			  { 
				  log.info("Missing delete contacts cancel and remove button.");
				  log.error("This is an exception", e);
				  errorname = "missingdeletecontactscancelandremovebutton";
				  ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
				  softAssert.fail();
			  }
				  
			  WebLocatorMethods.clickByCssSelector(webdriver,"deletecontactsremovebtn.css", 300);
			  
			  //Verify deleting all contacts returns back to Contacts page
			  log.info("Check after deleting contacts return to contacts page by checking contacts header.");
			  
			  try
			  {

				  String returntocontactsheader = WebLocatorMethods.getTextByCSS(webdriver, "contactsheader.css", 1000);
				  Assert.assertEquals(returntocontactsheader,"Contacts");
				  
				  String nocontactsdefinedtext = WebLocatorMethods.getTextByClassName(webdriver, "nocontactsdefinedtext.class", 1000);
				  Assert.assertEquals(nocontactsdefinedtext, "No contacts defined.");
				  
			  }
			  catch(AssertionError e)
			  { 
				  log.info("Missing contacts header and no contacts defined text after deleting contact.");
				  log.error("This is an exception", e);
				  errorname = "missingcontactsheadernocontactsdefinedtextafterdeletingcontact";
				  ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
				  softAssert.fail();
			  }
			  
			  
			log.info("All contacts deleted.");


	
	  } //else tag
		
		softAssert.assertAll();
		
	} //method tag
} //class tag
