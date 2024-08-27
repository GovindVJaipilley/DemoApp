package SchedulingCalendar;

import java.awt.Robot;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginPage.BaseClass;
import ReportMail.EmailSender;
import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class AssignDCS {

	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	//String path = "C:\\POC-Automation\\TestData.xlsx";
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	String loadingSpinner;
	String dcsListBox, dcsListSearch, dcsListSelect;
	String checkAvailabilityButton, selectDCSRadioButton, scheduleButton;
	String successMsg, successOkBtn;
	String otHeader, otProceed;
	
	
	
	@BeforeTest
	public void driversForAssignDCS() throws IOException {
		driver = BaseClass.getDriver();
		path = BaseClass.getTestDataPath();
		wait = BaseClass.getWebDriverWait();
		myActions = BaseClass.getDriverActions();
		robot = BaseClass.getRobot();
		prop = new ReadPropFile();
		excel = new ExcelRead(path);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		BaseClass.sheetStatus = "Pass";
	}

	@Test
	public void assingDCS() throws InterruptedException {
		int flag = 0;
		loadingSpinner = prop.getLoadingSpinner();
		dcsListBox = prop.getDCSListBox();
		dcsListSearch = prop.getDCSListSearch();
		dcsListSelect = prop.getDCSListSelect();
		checkAvailabilityButton =prop.getCheckAvailabilityButton();
		selectDCSRadioButton = prop.getSelectDCSRadioButton();
		scheduleButton = prop.scheduleButton();
		otHeader = prop.getDCSOTPopupHeader();
		otProceed = prop.getDCSOTPopupProceed();
		successMsg = prop.getSuccessMsgHeader();
		successOkBtn = prop.getSuccessOkBtn();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		WebElement dcsListBoxEle = driver.findElement(By.xpath(dcsListBox));
		wait.until(ExpectedConditions.visibilityOf(dcsListBoxEle));
		dcsListBoxEle.click();
		
		WebElement dcsListSearchEle = driver.findElement(By.xpath(dcsListSearch));
		wait.until(ExpectedConditions.visibilityOf(dcsListSearchEle));
		dcsListSearchEle.sendKeys(excel.getCellData("AssignDCS", 0, 2));
		
		WebElement dcsListSelectEle = driver.findElement(By.xpath(dcsListSelect));
		wait.until(ExpectedConditions.visibilityOf(dcsListSelectEle));
		dcsListSelectEle.click();
		
		Thread.sleep(2000);
		
		WebElement checkAvailabilityButtonEle = driver.findElement(By.xpath(checkAvailabilityButton));
		wait.until(ExpectedConditions.elementToBeClickable(checkAvailabilityButtonEle));
		checkAvailabilityButtonEle.click();
		
		WebElement loadingSpinnerEle = driver.findElement(By.xpath(loadingSpinner));
		wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));
		
		WebElement selectDCSRadioButtonEle = driver.findElement(By.xpath(selectDCSRadioButton));
		
		wait.until(ExpectedConditions.visibilityOf(selectDCSRadioButtonEle));
		selectDCSRadioButtonEle.click();
		
		driver.findElement(By.xpath(scheduleButton)).click();
		
		wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));
		
		try {
			System.out.println("In the try block of Assign DCS to check whether DCS is assigned Successfully or not");
			WebElement successMsgEle = driver.findElement(By.xpath(successMsg));
			if(successMsgEle.isDisplayed()) {
				System.out.println("DCS was assigned successfully");
				try {
					
					
						EmailSender.setResult(11, BaseClass.indexStatus);
						DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
						Date date1 = new Date();
						String reportDate1 = df1.format(date1);
						EmailSender.setDateTime(11, reportDate1);

					
				} catch (Exception e) {
					e.printStackTrace();
					
					EmailSender.setResult(11, BaseClass.indexStatus);
					DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
					Date date1 = new Date();
					String reportDate1 = df1.format(date1);
					EmailSender.setDateTime(11, reportDate1);
					
				}
			}
			
			System.out.println();
			//driver.findElement(By.xpath(successOkBtn)).click();
			//wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));
			
		} catch(Exception e){
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
			if(driver.findElement(By.xpath(prop.getCloseBAfterAssignDCS())).isDisplayed())
			{
				Common_Methods.clickEleBy_Xpath(prop.getCloseBAfterAssignDCS(), driver);
				System.out.println("DCS was assigned successfully");
try {
					
						EmailSender.setResult(11, BaseClass.indexStatus);
						DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
						Date date1 = new Date();
						String reportDate1 = df1.format(date1);
						EmailSender.setDateTime(11, reportDate1);

					
					
				} catch (Exception e1) {
					e1.printStackTrace();
					
					EmailSender.setResult(11, BaseClass.indexStatus);
					DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
					Date date1 = new Date();
					String reportDate1 = df1.format(date1);
					EmailSender.setDateTime(11, reportDate1);
					
				}
				flag = 1;
			}
			else
			{
			System.out.println(e.getMessage());
			System.out.println("Into the Catch block, means might be navigated to OT screen");
			WebElement otHeaderEle = driver.findElement(By.xpath(otHeader));
			if(otHeaderEle.isDisplayed()) {
				System.out.println("Navigated to OT screen");
				
				try {
					System.out.println("Trying to hit the Proceed button if it is enabled");
					WebElement otProceedEle = driver.findElement(By.xpath(otProceed));
					otProceedEle.click();
					wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));
					WebElement successMsgEle = driver.findElement(By.xpath(successMsg));
					wait.until(ExpectedConditions.visibilityOf(successMsgEle));
					if(successMsgEle.isDisplayed()) {
						System.out.println("DCS was assigned successfully");
						try {
							
							
								EmailSender.setResult(11, BaseClass.indexStatus);
								DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
								Date date1 = new Date();
								String reportDate1 = df1.format(date1);
								EmailSender.setDateTime(11, reportDate1);

							
							
						} catch (Exception e2) {
							e2.printStackTrace();
							
							EmailSender.setResult(11, BaseClass.indexStatus);
							DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
							Date date1 = new Date();
							String reportDate1 = df1.format(date1);
							EmailSender.setDateTime(11, reportDate1);
							
						}
					}
					System.out.println("Completed the assign DCS process in the OT try block");
					
				} catch(Exception ei) {
					System.out.println(ei.getMessage());
					System.out.println("It seems the user doesn't have the privilege to assign the DCS as OT");
				}
			}
		}
		}
		if(flag == 0)
		{
			driver.findElement(By.xpath(successOkBtn)).click();
			try {
				
				
					EmailSender.setResult(11, BaseClass.indexStatus);
					DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
					Date date1 = new Date();
					String reportDate1 = df1.format(date1);
					EmailSender.setDateTime(11, reportDate1);

				
				
			} catch (Exception e) {
				e.printStackTrace();
				
				EmailSender.setResult(11, BaseClass.indexStatus);
				DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date1 = new Date();
				String reportDate1 = df1.format(date1);
				EmailSender.setDateTime(11, reportDate1);
				
			}
		}
		wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));
	}
}
