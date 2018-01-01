package webTests;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.TestBase;
import locators.WebLocatorMethods;
import webMethods.Methods4AddPlace;
import webMethods.Methods4Login;
import webMethods.Methods4RemoveLBAlert;
import webMethods.Methods4RemovePlace;

public class AddaPlace extends TestBase{
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Dec 2017  ***//
	//***                                  ***//
	//****************************************//
	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = Logger.getLogger(AddaPlace.class);
	
	
	static String className =  AddaPlace.class.getSimpleName();
 	static Date date1= new Date();
 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
	static String foldername = folderpath+className+timestamp;
	static String error = "";
	static String errorname = "";
	
	
	@Test(dataProvider = "getData") 
	public void addPlaceTest (String loginusername, String loginpwd, String entersearchfield, String expectedautosuggestionaddress, String expectedaddress, String finalsavedaddress, String placename) throws InterruptedException, IOException
	{
		
	    Methods4Login.loginFamilyLocator(webdriver, foldername, errorname, error, loginusername, loginpwd);
		//Remove the associated alert first before you can remove a place
		Methods4RemoveLBAlert.removeLBAlert(webdriver, foldername, errorname, error, placename);
		Thread.sleep(1000);
		Methods4RemovePlace.removePlace(webdriver, foldername, errorname, error, placename);
		log.info("Going to click add a place icon.");
		WebLocatorMethods.waituntilXsecondsisDisplayedByCSS(webdriver, "webaddaplaceicon.css", 4000);
		WebLocatorMethods.javascriptExecutorClickByCSSSelector(webdriver, "webaddaplaceicon.css", 10);
		Thread.sleep(4000);
		Methods4AddPlace.addPlace(webdriver, foldername, errorname, error, entersearchfield, expectedautosuggestionaddress, expectedaddress, finalsavedaddress, placename);
	}
	
	

	
}
