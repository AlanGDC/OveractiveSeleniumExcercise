package Tests;


 
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.ParkingCalculatorPage;
import TestData.ParkingTestData;
import Util.DriverConfiguration;
 
public class TestSelenium {

    private WebDriver driver;
    
    ParkingCalculatorPage parkingCalculatorPage ;
    SimpleDateFormat format ;
    
	@BeforeTest
	public void configuration() {
		driver = new FirefoxDriver(DriverConfiguration.configuration());
		parkingCalculatorPage = new ParkingCalculatorPage(driver);
		format = new SimpleDateFormat("MM-dd-yyyy");
	}
	
	
	
	@Test(dataProvider="getData")
    public void testParkingCalculator(ParkingTestData testData) throws InterruptedException, ParseException {
		
		driver.get("http://adam.goucher.ca/parkcalc");
		
		parkingCalculatorPage.clickAndSelectLotDrop(testData.getLotDropData());		
		parkingCalculatorPage.completeEntryDate((testData.getEntryDateData()));;
		parkingCalculatorPage.completeEntryTime(testData.getEntryTimeData());
		parkingCalculatorPage.completeLeaveDate((testData.getLeaveDateData()));
		parkingCalculatorPage.completeLeaveTime(testData.getLeaveTimeData());
		parkingCalculatorPage.clickOnCalculate();
		
		Assert.assertEquals(parkingCalculatorPage.checkCost(), testData.getCostText());
                

    }
    
    @DataProvider
    public Object[][] getData() throws ParseException, IOException {
    	                
    	ParkingTestData shortTermDataTest = ReadCSV.read();

    	ParkingTestData longTermDataTest  = ReadCSV.read(); 
    	
    	
        return new Object[][] {{shortTermDataTest},{longTermDataTest}};
    }
    
    
	
    
}


