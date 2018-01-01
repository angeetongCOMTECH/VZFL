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

public class DeleteLocationBasedAlert extends TestBase{
	    
	    //****************************************//
		//***                                  ***//
		//*** Created by Angela Tong Dec 2017  ***//
		//***                                  ***//
		//****************************************//
		
		static SoftAssert softAssert = new SoftAssert();
		final static Logger log = Logger.getLogger(DeleteLocationBasedAlert.class);
		
		
		static String className = DeleteLocationBasedAlert.class.getSimpleName();
	 	static Date date1= new Date();
	 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
	 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
		static String foldername = folderpath+className+timestamp;
		static String error = "";
		static String errorname = "";

		
		//Remember to delete existing Albertsons place and alert first 
		//Remember to delete all contacts before starting test or only keep existing A1, 9493300677, nimtester00@gmail.com contact
		@Test(dataProvider = "getData") 
		public void removeLBAlertTest (String loginusername, String loginpwd,  String placename) throws InterruptedException, IOException
		{
			
		    Methods4Login.loginFamilyLocator(webdriver, foldername, errorname, error, loginusername, loginpwd);
			Methods4RemoveLBAlert.removeLBAlert(webdriver, foldername, errorname, error, placename);
		}
}
