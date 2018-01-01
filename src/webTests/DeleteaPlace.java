package webTests;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import webMethods.Methods4Login;
import webMethods.Methods4RemoveLBAlert;
import webMethods.Methods4RemovePlace;

public class DeleteaPlace extends TestBase{
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Dec 2017  ***//
	//***                                  ***//
	//****************************************//
	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = Logger.getLogger(DeleteaPlace.class);
	
	
	static String className =  DeleteaPlace.class.getSimpleName();
 	static Date date1= new Date();
 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
	static String foldername = folderpath+className+timestamp;
	static String error = "";
	static String errorname = "";
	
	
	@Test(dataProvider = "getData") 
	public void removePlaceTest (String loginusername, String loginpwd, String placename) throws InterruptedException, IOException
	{
		
	    Methods4Login.loginFamilyLocator(webdriver, foldername, errorname, error, loginusername, loginpwd);
		//Remove the associated alert first before you can remove a place
		Methods4RemoveLBAlert.removeLBAlert(webdriver, foldername, errorname, error, placename);
		Methods4RemovePlace.removePlace(webdriver, foldername, errorname, error, placename);
	}
	

	
}
