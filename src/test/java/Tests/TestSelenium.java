package Tests;


 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.ParkingCalculatorPage;
import TestData.ParkingTestData;
 
public class TestSelenium {
	

    @Test(dataProvider="getData")
    public static void testParkingCalculator(ParkingTestData testData) throws InterruptedException, ParseException {
		System.setProperty("webdriver.gecko.driver","/home/alannote/Downloads/geckodriver-v0.24.0-linux64/geckodriver");
	    
		FirefoxBinary firefoxBinary = new FirefoxBinary();
	    firefoxBinary.addCommandLineOptions("--headless");
	    FirefoxOptions firefoxOptions = new FirefoxOptions();
	    firefoxOptions.setBinary(firefoxBinary);
		FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
		
		ParkingCalculatorPage parkingCalculatorPage = new ParkingCalculatorPage(driver);
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
    	
        
		driver.get("http://adam.goucher.ca/parkcalc");
		
		parkingCalculatorPage.clickAndSelectLotDrop(testData.getLotDropData());		
		parkingCalculatorPage.completeEntryDate(format.format(testData.getEntryDateData()));;
		parkingCalculatorPage.completeEntryTime(testData.getEntryTimeData());
		parkingCalculatorPage.completeLeaveDate(format.format(testData.getLeaveDateData()));
		parkingCalculatorPage.completeLeaveTime(testData.getLeaveTimeData());
		parkingCalculatorPage.clickOnCalculate();
		
		
		Assert.assertEquals(parkingCalculatorPage.checkCost(), testData.getCostText());
 
        driver.quit();
                

    }
    
    @DataProvider
    public Object[][] getData() throws ParseException {
    	
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        Date 	dateEntry;
        String 	timeEntry;
        
        Date 	dateLeave;
        String 	timeLeave;
        
        String 	costExpected;
        String 	daysExpected;
        
        String 	lotDrop;
        
        
        // 	1 test for "Short-Term" :
       
        dateEntry = format.parse ( "02-28-2019" );
        timeEntry = "12:00";
        
        dateLeave = format.parse ( "03-01-2019" );
        timeLeave = "12:00";
        
        costExpected = "$ 756.00";
    	daysExpected = "";
    	
    	lotDrop = "STP";
    	
    	ParkingTestData shortTermDataTest = new ParkingTestData
    			(lotDrop, timeEntry, 
				dateEntry, timeLeave, 
				dateLeave, costExpected,
				daysExpected); 
    	

        // 	1 test for "Long-Term parking" :

        dateEntry = format.parse ( "02-28-2019" );
        timeEntry = "12:00";
        
        dateLeave = format.parse ( "03-01-2019" );
        timeLeave = "12:00";
        
        costExpected = "$ 250.00";
    	daysExpected = "";
    	
    	lotDrop = "LTS";
    	
    	ParkingTestData longTermDataTest  = new ParkingTestData
    			(lotDrop, timeEntry, 
				dateEntry, timeLeave, 
				dateLeave, costExpected,
				daysExpected); 
    	
    	
        return new Object[][] {{shortTermDataTest},{longTermDataTest}};
    }
    
    
	
    
}


