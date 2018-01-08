package webMethods;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import common.ScreenshotURL;
import locators.WebLocatorMethods;


public class Methods4AddContact {
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Dec 2017  ***//
	//***                                  ***//
	//****************************************//
	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = Logger.getLogger(Methods4AddContact.class);
	
	public static void addContacts (WebDriver webdriver, String foldername, String errorname, String error, String contactname, String phone, String email) throws InterruptedException, IOException
	{
		WebLocatorMethods.javascriptExecutorClickByCSSSelector(webdriver, "contactslink.css", 180);
		String contactsheadertext = WebLocatorMethods.getTextByCSS(webdriver, "contactsheader.css", 60);		
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
	
        Boolean deletecontactsbtnexists = WebLocatorMethods.existsSizeNotZeroByClass(webdriver, "contactsdeletebutton.class", 180);	  
		
		Boolean nocontactexist = WebLocatorMethods.existsSizeNotZeroByClass(webdriver, "nocontactsdefinedtext.class", 180);
		if (nocontactexist == true)
		{
			//If no contacts exist exit if/else statement and go add a contact.
			log.info("No contacts exist to delete.");
		}
		else if (deletecontactsbtnexists == true)
		{
			//If delete btn exists, then check if A1 contact exists and if so delete it.
			log.info("On delete contacts page.");
			int sizeofcontactslist = WebLocatorMethods.sizeByCSS(webdriver, "searchcontactsarraynameA1.css", 30);
			for (int i=0; i<sizeofcontactslist; i++) 
			{
			  String elementcontactname = WebLocatorMethods.arrayofelementsbyCSS(webdriver, "searchcontactsarraynameA1.css", 30).get(i).getText();

			  if (elementcontactname.equalsIgnoreCase(contactname))
			  {
				  log.info("Check delete contacts button and its select all link exists.");
				  
				  try
				  {
					  //If contactname is A1 then click delete contacts to delete it.
					  WebLocatorMethods.clickByClassName(webdriver, "contactsdeletebutton.class", 30);
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
				  
				  
				  int sizeofdeletecontactslist = WebLocatorMethods.sizeByCSS(webdriver, "deletecontactA1array.css", 30);
				  for (int j=0; j<sizeofdeletecontactslist; j++)
				  {
					  
					 //Find A1 contactname to delete it and verify remove button is enabled after clicking on contactname
					  String deleteelementcontactname = WebLocatorMethods.arrayofelementsbyCSS(webdriver, "deletecontactA1array.css", 30).get(j).getText();
					  if (deleteelementcontactname.equalsIgnoreCase(contactname))
					  {
						  WebElement A1checkboxtodelete = WebLocatorMethods.arrayofelementsbyCSS(webdriver, "deletecontactA1checkboxarray.css", 30).get(j);						  
						  A1checkboxtodelete.click();
						  
						  log.info("Check delete contacts cancel and remove button.");
						  
						  try
						  {
							  String cancelbtntext = WebLocatorMethods.getTextByCSS(webdriver, "deletecontactscancelbtn.css", 30);
							  Assert.assertEquals(cancelbtntext, "Cancel");
							  
							  String removebtntext = WebLocatorMethods.getTextByCSS(webdriver, "deletecontactsremovebtn.css", 70);
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
							  
						  WebLocatorMethods.clickByCssSelector(webdriver,"deletecontactsremovebtn.css", 30);
						  
						  //Verify deleting contact returns back to Contacts page
						  log.info("Check after deleting contacts return to contacts page by checking contacts header.");
						  
						  try
						  {
							  WebLocatorMethods.waitXSecsAndGetVisibleElementByCSS(webdriver, "contactsheader.css", 60);
							  String returntocontactsheader = WebLocatorMethods.getTextByCSS(webdriver, "contactsheader.css", 30);
							  Assert.assertEquals(returntocontactsheader,"Contacts");
						  }
						  catch(AssertionError e)
						  { 
							  log.info("Missing contacts header after deleting contact.");
							  log.error("This is an exception", e);
							  errorname = "missingcontactsheaderafterdeletingcontact";
							  ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
							  softAssert.fail();
						  }
						  
						  int sizeofreturncontactslist = WebLocatorMethods.sizeByCSS(webdriver, "searchcontactsarraynameA1.css", 30);
						  
						  if (sizeofreturncontactslist > 0)
						  {
								  for (int k=0; k<sizeofreturncontactslist; k++)
									{
									  String deletedcontactname = WebLocatorMethods.arrayofelementsbyCSS(webdriver, "searchcontactsarraynameA1.css", 30).get(k).getText();
									  if (deletedcontactname.equalsIgnoreCase(contactname))
									  {	  
										  log.error("Contact name was not deleted.");
									  }
									  else
									  {
										  log.info("Contact name was successfully deleted.");
									  }
									}
						  }
						  else
						  {
							  log.info("Contact name was successfully deleted.");
						  }
							
						  
					  }
				  }
				  
				  
			  }
			
			}
	
		}
		
	
	    //Click on add new contact and fill in new contact information and save.
		 log.info("Check add new contact page text - header, contact name, phone, email, save and close buttons.");
		
		try
		{ 
			WebLocatorMethods.clickByClassName(webdriver, "contactsaddcontactbutton.class", 30);
	        String addnewcontactheadertext = WebLocatorMethods.getTextByCSS(webdriver, "addnewcontactpgheader.css", 70);
	        Assert.assertEquals(addnewcontactheadertext, "Add new contact");
	        
	        String contactnametext = WebLocatorMethods.getTextByCSS(webdriver, "addnewcontactcontactnamelabel.css", 30);
	        Assert.assertEquals(contactnametext,"Contact name");
	        WebLocatorMethods.sendKeysIntoElementByName(webdriver, "addnewcontactcontactnameinputfield.name", "A1", 30);
	        Thread.sleep(30);
	        
	        String phonenumbertext = WebLocatorMethods.getTextByCSS(webdriver, "addnewcontactcontactphonelabel.css", 30);
	        Assert.assertEquals(phonenumbertext,"Phone number");
	        WebLocatorMethods.actionsClickandSendByName(webdriver, "addnewcontactphonenumberinputfield.name", "9493300677", 30);
	        Thread.sleep(30);
	        
	        String emailtext = WebLocatorMethods.getTextByCSS(webdriver, "addnewcontactcontactemaillabel.css", 30);
	        Assert.assertEquals(emailtext,"Email address");
	        WebLocatorMethods.actionsClickandSendByName(webdriver, "addnewcontactemailinputfield.name", "nimtester00@gmail.com", 30);
	        
			String savebtntext = WebLocatorMethods.getTextByXpath(webdriver, "addnewcontactsavebtn.xpath", 70);
			Assert.assertEquals(savebtntext, "Save");
			String closebtntext = WebLocatorMethods.getTextByXpath(webdriver, "addnewcontactclosebtn.xpath", 30);
			Assert.assertEquals(closebtntext, "Close");
		
		}
		catch(AssertionError e)
		{ 
			 log.info("Missing elements on add new contact pg.");
			 log.error("This is an exception", e);
			 errorname = "missingelementsonaddnewcontactpg";
			 ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
			 softAssert.fail();
		 }
			
        WebLocatorMethods.clickByXpath(webdriver, "addnewcontactsavebtn.xpath", 30);
        
        //Verify adding contact returns back to Contacts page
		log.info("Check after adding contact is returned to contacts page.");
		 
	    try
	    {
		    String returntocontactsheader = WebLocatorMethods.getTextByCSS(webdriver, "contactsheader.css", 90);
		    Assert.assertEquals(returntocontactsheader,"Contacts");
	    }
		catch(AssertionError e)
		{ 
			 log.info("Didn't return to contacts page after adding contact.");
			 log.error("This is an exception", e);
			 errorname = "didntreturnttocontactspageafteraddingcontact";
			 ScreenshotURL.screenshotURL(webdriver, foldername, errorname, error);
			 softAssert.fail();
		 }
	  
	    int sizeofreturncontactslist = WebLocatorMethods.sizeByCSS(webdriver, "searchcontactsarraynameA1.css", 30);
	    for (int m=0; m<sizeofreturncontactslist; m++)
		{
		  String addedcontactname = WebLocatorMethods.arrayofelementsbyCSS(webdriver, "searchcontactsarraynameA1.css", 30).get(m).getText();
		  if (addedcontactname.equalsIgnoreCase(contactname))
		  {	  
			  log.info("Contact name was added.");
			  WebLocatorMethods.clickByCssSelector(webdriver, "closebtn.css", 30);
		  }
		  else
		  {
			  log.info("Contact name was not added.");
		  }
		}
			
		softAssert.assertAll();
		
	}

}
