package base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import locators.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import common.ExcelMethods;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;



public class TestBase {

	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Dec 2017  ***//
	//***                                  ***//
	//****************************************//
	
        @SuppressWarnings("rawtypes")
        public static AppiumDriver driver;
	    public static WebDriver webdriver;
	    public static String folderpath = "/Users/atong/Documents/EclipseProjects/FamilyLocator/screencaptures";
		public static String runonrealdevice = "";
		public String methodname = "";


        @SuppressWarnings({ "rawtypes", "deprecation" })
		@BeforeMethod 
		//Use before method instead of before class or before test so each method/test will open in new browser; 
		//This was tested and found beforemethod was the only one that works.
		public void Setup() throws IOException{
	         
        		ReadProperties.retrieveGlobalProperties();
        	
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			if (ReadProperties.globalProp.getProperty("webautomation").contains("yes") && ReadProperties.globalProp.getProperty("mobileautomation").contains("no"))
			{
				if(ReadProperties.globalProp.getProperty("webbrowser").contains("firefox"))
				{
					System.setProperty("webdriver.gecko.driver","/Users/atong/Documents/geckodriver/geckodriver");
					webdriver = new FirefoxDriver();
				}
				else if (ReadProperties.globalProp.getProperty("webbrowser").contains("chrome"))
				{
					System.setProperty("webdriver.chrome.driver", "/Users/atong/Documents/chromedriver/chromedriver");
					webdriver = new ChromeDriver();
				}
				else 
				{
					System.setProperty("webdriver.ie.driver","C:\\IEdriver\\IEDriverServer.exe");
					DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
					//Enable IE security tab protected mode for all zones then you can skip flakiness line
					//ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
					ieCapabilities.setCapability("ensureCleanSession", true);
					ieCapabilities.setCapability("ignoreZoomSetting", true);
					ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
					ieCapabilities.setCapability("ignore-certificate-error", true);
					ieCapabilities.setCapability("capabilityType.ACCEPT_SSL_CERTS", true);
	
					webdriver = new InternetExplorerDriver(ieCapabilities);
				}
			
				    String weburl = ReadProperties.globalProp.getProperty("weburl");
					webdriver.get(weburl);
					webdriver.manage().window().maximize(); 
			}
			else if (ReadProperties.globalProp.getProperty("webautomation").contains("no") && ReadProperties.globalProp.getProperty("mobileautomation").contains("yes"))
			{

					if (ReadProperties.globalProp.getProperty("mobiledevice").contains("Android")&& ReadProperties.globalProp.getProperty("runonrealdevice").contains("yes"))
					{
						//Remove "Unlock" and "Appium settings" apps from Android device
                        //Appium installs those apps automatically. (In my case those apps were not compatible after updating Android from version 6 to version 7.
			            capabilities.setCapability("platformName", "Android");     
						capabilities.setCapability("platformVersion", "7.1.1");     
						capabilities.setCapability("deviceName", "Android");    
						capabilities.setCapability("automationName", "uiautomator2");//need this or else can't locate some elements
						
						if (ReadProperties.globalProp.getProperty("reset").contains("fullReset")) { // uninstall and install client
				            System.out.println("Driver DO FULL-RESET");
				            capabilities.setCapability("fullReset", true);
				            capabilities.setCapability("noReset", false);
				        } else if (ReadProperties.globalProp.getProperty("reset").contains("fastReset")) { // clears cache and settings without reinstall
				            System.out.println("Driver DO FAST-RESET");
				            capabilities.setCapability("fullReset", false);
				            capabilities.setCapability("noReset", false);
				        } else { // just start client
				            System.out.println("Driver DO NORMAL start"); 
				            capabilities.setCapability("fullReset", false);
				            capabilities.setCapability("noReset", true);
				        }
						
						
						capabilities.setCapability("newCommandTimeout", 120);    
						capabilities.setCapability("appPackage", "com.zillow.android.zillowmap");
						capabilities.setCapability("appActivity", "com.zillow.android.re.ui.SplashScreenActivity");
						//capabilities.setCapability("appWaitActivity", "com.zillow.android.re.ui.homesmapscreen.RealEstateMapActivity");
						
						runonrealdevice = "yes";

						driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
					}
					else if (ReadProperties.globalProp.getProperty("mobiledevice").contains("iOS")&& ReadProperties.globalProp.getProperty("runonrealdevice").contains("yes"))
					{
     
			            File appDir = new File("/Users/angee/Apps/TestApp/Apps/"); //this ipa was done with automatic signing
			            File app = new File(appDir, "TestApp.ipa");
			            capabilities.setCapability("app", app.getAbsolutePath());
						capabilities.setCapability("platformName", "iOS");     
						capabilities.setCapability("platformVersion", "10.3.3");     
						capabilities.setCapability("deviceName", "iPhone 5");     
						capabilities.setCapability("udid", "8319807bbbc1d04c9bbc0634e14d28aca946b536");
						capabilities.setCapability("automationName", "Appium");
						capabilities.setCapability("appiumVersion","1.2.3");
						capabilities.setCapability("agentPath", "/usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent/WebDriverAgent.xcodeproj"); //must use this or won't work
						capabilities.setCapability("bootstrapPath", "/usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent"); //must use this or won't work
						capabilities.setCapability("xcodeOrgid", "Angela Tong");
						capabilities.setCapability("xcodeSigningId", "iPhone Developer");
			            capabilities.setCapability("fullReset", false);
			            capabilities.setCapability("noReset", true);
						capabilities.setCapability("newCommandTimeout", 120);    

						
						runonrealdevice = "yes";
						
						driver = new IOSDriver (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
					}
					else if (ReadProperties.globalProp.getProperty("simulator").contains("Android")&& ReadProperties.globalProp.getProperty("runonrealdevice").contains("no"))
					{
						//Tested work for Android simulator
			            File appDir = new File("/Users/atong/Documents/EclipseProjects/FamilyLocator/src/");
			            File app = new File(appDir, "base.apk");
			            capabilities.setCapability("app", app.getAbsolutePath());
						capabilities.setCapability("platformName", "Android");
						capabilities.setCapability("platformVersion", "6.0");     
						capabilities.setCapability("deviceName", "Nexus 4");  
						//capabilities.setCapability("session-override", true); //set this in appium desktop settings
						capabilities.setCapability("newCommandTimeout", 120);
						 // Launches the below android virtual device and waits for 120 seconds for AVD to be ready
						capabilities.setCapability("avd", "Nexus_4_AVD"); //need underscore for spaces in name for appium inspector
						capabilities.setCapability("avdReadyTimeout", 120000);
						capabilities.setCapability("appPackage", "com.zillow.android.zillowmap");
						capabilities.setCapability("appActivity", "com.zillow.android.re.ui.SplashScreenActivity");
						
						driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
											
						
					}
					else if (ReadProperties.globalProp.getProperty("simulator").contains("iOS")&& ReadProperties.globalProp.getProperty("runonrealdevice").contains("no"))
					{
     
			            File appDir = new File("/Users/atong/Documents/EclipseProjects/FamilyLocator/src/");
			            File app = new File(appDir, "TestApp.app");
						capabilities.setCapability("platformName", "iOS");
						capabilities.setCapability("platformVersion", "11.0");   
						capabilities.setCapability("deviceName", "iPhone Simulator"); 
			            capabilities.setCapability("app", app.getAbsolutePath());
						capabilities.setCapability("newCommandTimeout", 120);
						
						driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
					}
				   
					

			}
			
				
	    }

        
    	
    	@DataProvider(name = "getData")
    	public Object[][] getData(Method method) throws Exception {
    		String testName= method.getName();
    		Object[][] arrayObject = null;
    			arrayObject = ExcelMethods.getDataFromExcelTestData(testName);

    		return (arrayObject);
    	}
        
    	
    	@AfterMethod 
    	public static void OnFailure(ITestResult testResult) throws IOException { 
    		if (testResult.getStatus() == ITestResult.FAILURE) 
    		{ 
    			System.out.println(testResult.getStatus()); 
    		} 
    	} 
    	

    @AfterMethod
    //Use after method instead of after class or after test so each method/test will open in new browser; 
  	//This was tested and found aftermethod was the only one that works.  	
    public void tearDown() {
        if (driver != null) 
        {
            driver.quit();
        }
        else if (webdriver != null)
        {
            webdriver.quit();
        }
    }

	    
}

/***


Remove below jar's from class path and it should fix the issue of not running

log4j-to-slf4j-2.0.2.jar
log4j-to-slf4j-2.0.2-sources.jar
log4j-slf4j-impl-2.0.2.jar
log4j-slf4j-impl-2.0.2-sources.jar
 
 ***/


