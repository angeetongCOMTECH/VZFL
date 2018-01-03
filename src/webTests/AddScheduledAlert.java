package webTests;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.TestBase;
import webMethods.Methods4AddScheduledAlerts;
import webMethods.Methods4Login;


public class AddScheduledAlert extends TestBase{
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Dec 2017  ***//
	//***                                  ***//
	//****************************************//
	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = Logger.getLogger(AddScheduledAlert.class);
	
	
	static String className = AddScheduledAlert.class.getSimpleName();
 	static Date date1= new Date();
 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
	static String foldername = folderpath+className+timestamp;
	static String error = "";
	static String errorname = "";


	@Test(dataProvider = "getData") 
	public void addSchedAlertTest (String loginusername, String loginpwd, String contactname, String phone, String email) throws InterruptedException, IOException
	{
	    Methods4Login.loginFamilyLocator(webdriver, foldername, errorname, error, loginusername, loginpwd);
		Methods4AddScheduledAlerts.addScheduledAlert(webdriver, foldername, errorname, error, contactname, phone, email);
	}


}
