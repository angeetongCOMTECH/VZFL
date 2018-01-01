package webTests;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.TestBase;
import locators.WebLocatorMethods;
import webMethods.Methods4AddLocationBasedAlerts;
import webMethods.Methods4Login;
import webMethods.Methods4RemoveLBAlert;
import webMethods.Methods4RemovePlace;


public class AddLocationBasedAlert extends TestBase{
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Dec 2017  ***//
	//***                                  ***//
	//****************************************//
	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = Logger.getLogger(AddLocationBasedAlert.class);
	
	
	static String className = AddLocationBasedAlert.class.getSimpleName();
 	static Date date1= new Date();
 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
	static String foldername = folderpath+className+timestamp;
	static String error = "";
	static String errorname = "";


	//The test delete existing Albertsons alert and place first
	//It uses existing A1, 9493300677, nimtester00@gmail.com contact
	@Test(dataProvider = "getData", priority=1) 
	public void addLBAlertWithPlaceTest (String loginusername, String loginpwd, String entersearchfield, String expectedautosuggestionaddress, String expectedaddress, String finalsavedaddress, String placename, String contactname, String phone, String email) throws InterruptedException, IOException
	{
		
	    Methods4Login.loginFamilyLocator(webdriver, foldername, errorname, error, loginusername, loginpwd);
		Methods4RemoveLBAlert.removeLBAlert(webdriver, foldername, errorname, error, placename); 
		Thread.sleep(1000);
		Methods4RemovePlace.removePlace(webdriver, foldername, errorname, error, placename);
		Methods4AddLocationBasedAlerts.addPlaceandLocationBasedAlert(webdriver, foldername, errorname, error, entersearchfield, expectedautosuggestionaddress, expectedaddress, finalsavedaddress, placename, contactname, phone, email);	
		Thread.sleep(300);
	}



	//The test keep added Albertsons place from above test
	//Then delete existing Albertsons alert first
	//It uses existing A1, 9493300677, nimtester00@gmail.com contact
	@Test(dataProvider = "getData", priority=2, dependsOnMethods= {"addLBAlertWithPlaceTest"}) 
	public void addLBAlertExistingPlaceTest (String loginusername, String loginpwd, String finalsavedaddress, String placename, String contactname, String phone, String email) throws InterruptedException, IOException
	{
		
	    Methods4Login.loginFamilyLocator(webdriver, foldername, errorname, error, loginusername, loginpwd);
		Methods4RemoveLBAlert.removeLBAlert(webdriver, foldername, errorname, error, placename);
		Thread.sleep(1000);
		WebLocatorMethods.javascriptExecutorClickByCSSSelector(webdriver, "webplacesicon.css", 1000);
		Methods4AddLocationBasedAlerts.addLocationBasedAlertWithoutAddingPlace(webdriver, foldername, errorname, error, finalsavedaddress, placename, contactname, phone, email);
		Thread.sleep(300);
	}


}


