package webTests;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.TestBase;
import webMethods.Methods4Login;
import webMethods.Methods4RemoveSchedAlert;

public class DeleteScheduledAlert extends TestBase{
	

	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Dec 2017  ***//
	//***                                  ***//
	//****************************************//
	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = Logger.getLogger(DeleteScheduledAlert.class);
	
	
	static String className = DeleteScheduledAlert.class.getSimpleName();
 	static Date date1= new Date();
 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
	static String foldername = folderpath+className+timestamp;
	static String error = "";
	static String errorname = "";


	@Test(dataProvider = "getData") 
	public void removeSchedAlertTest (String loginusername, String loginpwd, String schedalerttoremove) throws InterruptedException, IOException
	{
	    Methods4Login.loginFamilyLocator(webdriver, foldername, errorname, error, loginusername, loginpwd);
		Methods4RemoveSchedAlert.removeSchedAlert(webdriver, foldername, errorname, error);
	}


}
