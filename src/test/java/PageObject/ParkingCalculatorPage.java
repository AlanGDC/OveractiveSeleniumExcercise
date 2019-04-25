package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParkingCalculatorPage {
	WebDriver driver;

//Locate each object from view


	By lotDrop				=	By.id("Lot");
	
	By entryTimeField		=	By.id("EntryTime");
	By entryAmRadioBtn		=	By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/font/input[2]");
	By entryPmRadioBtn		=	By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/font/input[3]");
	By entryDateField		=	By.id("EntryDate");
	By entrydateCalendar	=   By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/font/a");
	
	By leavingTimeField		=	By.id("ExitTime");
	By leavingAmRadioBtn	=	By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/font/input[2]");
	By leavingPmRadioBtn	=	By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/font/input[3]");
	By leavingDateField		=	By.id("ExitDate");
	By leavingdateCalendar	=   By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/font/a");
										  
	By costParkingText		= 	By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/span[1]/font/b");	
	By daysParkingText		= 	By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/span[2]/font/b");
	
	By calculateButton		=  By.name("Submit");
	
// Initialize Page
	
		public ParkingCalculatorPage(WebDriver driver)
		{
				this.driver=driver;		
		}
		
// Wait for element 
		public void waitForElement(By element) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
		}
		
// Actions for each objects combinations
		
		public void clickAndSelectLotDrop(String value)
		{
			waitForElement(lotDrop);
			driver.findElement(lotDrop).click();
			Select drpCountry = new Select(driver.findElement(lotDrop));
			drpCountry.selectByValue(value);
		}			

		public void completeEntryDate(String value)
		{
			waitForElement(entryDateField);
			driver.findElement(entryDateField).clear();
			driver.findElement(entryDateField).sendKeys(value);
		}			
		
		public void completeEntryTime(String value)
		{
			waitForElement(entryTimeField);
			driver.findElement(entryTimeField).clear();
			driver.findElement(entryTimeField).sendKeys(value);
		}
		
		public void completeLeaveDate(String value)
		{
			waitForElement(leavingDateField);
			driver.findElement(leavingDateField).clear();
			driver.findElement(leavingDateField).sendKeys(value);
		}
		
		public void completeLeaveTime(String value)
		{
			waitForElement(leavingTimeField);
			driver.findElement(leavingTimeField).clear();
			driver.findElement(leavingTimeField).sendKeys(value);
		}			
		
		public void clickOnCalculate()
		{
			waitForElement(calculateButton);
			driver.findElement(calculateButton).click();
		}			
		
		public String checkCost()
		{
			waitForElement(costParkingText);
			return driver.findElement(costParkingText).getText();
			
		}			
		
		public String checkDays()
		{
				waitForElement(daysParkingText);
				return driver.findElement(daysParkingText).getText() ;
		}

		
		public void clickAMEntry()
		{
			waitForElement(entryAmRadioBtn);
			driver.findElement(entryAmRadioBtn).click();
		}

		public void clickPMEntry()
		{
			waitForElement(entryPmRadioBtn);
			driver.findElement(entryPmRadioBtn).click();
		}
		
		public void clickAMLeave()
		{
			waitForElement(leavingAmRadioBtn);
			driver.findElement(leavingAmRadioBtn).click();
		}
		public void clickPMLeave()
		{
			waitForElement(leavingPmRadioBtn);
			driver.findElement(leavingPmRadioBtn).click();
		}
}

