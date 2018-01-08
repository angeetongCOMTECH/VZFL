package common;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.zone.ZoneRules;
import java.util.Locale;

import org.openqa.selenium.WebDriver;

public class DateTimeMethods {
	
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Dec 2017  ***//
	//***                                  ***//
	//****************************************//

	//Use to set scheduled alert time and add x minutes into future so then the scheduled alert will be trigger in the near future
	public static String addXminToCurrentTimeInSpecificTimezone(WebDriver webdriver, String timezoneid, String setalertxminsintofuture) throws InterruptedException
	{
		String finalnowhhmmampm = "";
		String [] splitArray;
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime( FormatStyle.SHORT ).withLocale( Locale.US ).withZone(ZoneId.of(timezoneid));		
		Instant instant = Instant.now();

		ZoneId z = ZoneId.of(timezoneid);
		ZonedDateTime zdt = instant.atZone( z );
		ZoneRules rules = zdt.getZone().getRules();
		Boolean dstInEffect = rules.isDaylightSavings( zdt.toInstant() );
		System.out.println("dstInEffect: "+dstInEffect);

		if (dstInEffect == false)
		{
		    String dstnow = formatter.format(zdt);
		    System.out.println("dstnow: "+dstnow);
		    
		    int addxmins = Integer.parseInt(setalertxminsintofuture);
			String nowplusxmins = formatter.format(instant.plus(addxmins, ChronoUnit.MINUTES)).toString();
			System.out.println("nowplusxmins: "+nowplusxmins);
			splitArray = nowplusxmins.split(" ");
			finalnowhhmmampm = splitArray[1]+" "+splitArray[2];
			System.out.println("finalnowhhmmampm: "+finalnowhhmmampm);
		}
		else if (dstInEffect == true)
		{
		    String dstnow = formatter.format(zdt);
		    System.out.println("dstnow: "+dstnow);
		    
		    //Daylight Savings Time Is Minus 1 Hr Behind
			String nowplusxmins = formatter.format(instant.plus(5, ChronoUnit.MINUTES).minus(1, ChronoUnit.HOURS)).toString();
			System.out.println("nowplusxmins: "+nowplusxmins);
			splitArray = nowplusxmins.split(" ");
			finalnowhhmmampm = splitArray[1]+" "+splitArray[2];
			System.out.println("finalnowhhmmampm: "+finalnowhhmmampm);
		}
		return finalnowhhmmampm;
	    
	}
}
