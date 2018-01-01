package locators;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.Logger;


public class ReadProperties {
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Dec 2017  ***//
	//***                                  ***//
	//****************************************//
	
	public static Properties webLocatorProp;
	public static Properties globalProp;
	final static Logger logger = Logger.getLogger(Class.class);
	
	
	public static void retrieveProperty()
	{
	
		
		try {
			webLocatorProp = new Properties();
			//FileInputStream in = new FileInputStream("C:\\EclipseProjects\\FamilyLocator\\src\\locators\\locators.properties");
			FileInputStream in = new FileInputStream("/Users/atong/Documents/EclipseProjects/FamilyLocator/src/locators/locators.properties");
			webLocatorProp.load(in);
			in.close();
		}
		catch (Exception e) {
			System.out.println("Can't read webLocator properties file.");
			logger.error("An exception occurred.", e);
		}

		
		
	}
	
	
	public static void retrieveGlobalProperties()
	{
		
		try {
        globalProp=new Properties();
		//FileInputStream in=new FileInputStream("C:\\EclipseProjects\\FamilyLocator\\src\\base\\global.properties");
        FileInputStream in=new FileInputStream("/Users/atong/Documents/EclipseProjects/FamilyLocator/src/base/global.properties");
		globalProp.load(in);
		in.close();
		}
		catch (Exception e) {
			System.out.println("Can't read global properties file.");
			logger.error("An exception occurred.", e);
		}
	}
	

}
