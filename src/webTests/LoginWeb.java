package webTests;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.TestBase;
import webMethods.Methods4Login;

public class LoginWeb extends TestBase {
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Dec 2017  ***//
	//***                                  ***//
	//****************************************//

	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = Logger.getLogger(LoginWeb.class);
	
	
	String className = LoginWeb.class.getSimpleName();
 	Date date1= new Date();
 	String originaltimestamp = new Timestamp(date1.getTime()).toString();
 	String timestamp = originaltimestamp.replace(':', 'x').substring(11);
	String foldername = folderpath+className+timestamp;
	String error = "";
	String errorname = "";
	

	@Test(dataProvider = "getData") 
	public void loginWebVZFL (String loginusername, String loginpwd) throws InterruptedException, IOException
	{
			
	    Methods4Login.loginFamilyLocator(webdriver, foldername, errorname, error, loginusername, loginpwd);
		
	}
	


}
