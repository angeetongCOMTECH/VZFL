package common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.TestBase;

public class ScreenshotURL extends TestBase{
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Dec 2017  ***//
	//***                                  ***//
	//****************************************//
	
	public static void screenshotURL (WebDriver driver, String foldername, String errorname, String error)  throws IOException 
	{		
		
		String url = "";
	    String file_name = "";
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
        String dateN = formatter.format(currentDate.getTime()).replace("/","_");
        String dateNow = dateN.replace(":","_");
        
	    
	try{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 

		//Must store all screen fails on hub which is on the PC
		//file_name = foldername + "\\" + errorname + dateNow + ".jpeg"; //Windows
		file_name = foldername + "/" + errorname + dateNow + ".jpg"; //Mac

		System.out.println("file_name: "+file_name);
		FileUtils.copyFile(scrFile, new File(file_name));

		
	    //FilePath
		//Must store all screen fails on hub which is on the PC
		//String filePath = foldername + "\\" + errorname + dateNow + "_URLResults.txt"; //Windows
		String filePath = foldername + "/" + errorname + dateNow + "_URLResults.txt"; //Mac
		url = driver.getCurrentUrl();

		try {
			      //Creating File object
			     File file = new File(filePath);
			     // if file doesn't exists, then create it
			     if (!file.exists()) {
			      file.createNewFile();
			     }
			   
			     //Creating FileWriter object
			     //using file object we got the filePath
			     //FileWriter fw = new FileWriter(file.getAbsoluteFile());
			     Boolean append = true;
			     FileWriter fw = new FileWriter(filePath, append);
			     //Creating BufferedWriter object
			     BufferedWriter bw = new BufferedWriter(fw);
			     //Writing content into file
			     bw.write(url);
			     //Adding new line 
			     bw.newLine();
			     bw.write(error);
			     //Adding new line 
			     bw.newLine();
			     bw.close();

	    } catch (IOException e2) 
		{
	    	e2.printStackTrace();
	    }


	} 
	catch (Exception e) 
	{
        e.printStackTrace();
    }
}
		
	
}

