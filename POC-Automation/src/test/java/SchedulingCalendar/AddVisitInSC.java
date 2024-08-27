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
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class AddVisitInSC {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	//String path = "C:\\POC-Automation\\TestData.xlsx";
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	String psInExcel;
	String psNameInPopUp, psNameSearchInPopUp, psNameClick;
	String site, ps, visitDate, visitStartTime, visitEndTime;
	String serviceCode, serviceCodeSearch, serviceSelect;
	String createButton;
	String loadingSpinner;
	String assignDCSHeader;
	
	@BeforeTest
	public void driversForAddVisits() throws IOException {
		driver = BaseClass.getDriver();
		path = BaseClass.getTestDataPath();
		wait = BaseClass.getWebDriverWait();
		myActions = BaseClass.getDriverActions();
		robot = BaseClass.getRobot();
		prop = new ReadPropFile();
		excel = new ExcelRead(path);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
  @Test
  public void addVisitFromSC() throws InterruptedException {
	 Thread.sleep(5000); 
	  site = prop.getSiteInAddVisits();
	  ps = prop.getPSInAddVisits();
	  psNameSearchInPopUp = prop.getPSNameSearchInAddVisitsPopUp();
	  psNameClick = prop.getPSNameClickInAddVisits();
	  visitDate = prop.getVisitDateInPopUpHeader();
	  visitStartTime = prop.getVisitStartTimeInAddVisits();
	  visitEndTime = prop.getVisitEndTimeInAddVisits();
	  serviceCode = prop.getServiceInAddVisitsPopUp();
	  serviceCodeSearch = prop.getServiceSearchInAddVisitsPopUp();
	  serviceSelect = prop.getServiceListInAddVisitsPopUp();
	  createButton = prop.getcreateButtonInAddVisits();
	  loadingSpinner = prop.getLoadingSpinner();
	  assignDCSHeader = prop.getAssignDCSHeader();
	  psInExcel = excel.getCellData("Add_Visit_SC", 0, 2);
	  
	  
	  
	  WebElement siteEle = driver.findElement(By.xpath(site));
	  System.out.println(siteEle.getText());
	  
	  WebElement psEle = driver.findElement(By.xpath(ps));
	  psNameInPopUp = psEle.getText();
	  System.out.println(psNameInPopUp);
	  
	  WebElement psNameSearchInPopUpEle;
	  WebElement psNameClickEle;
	  
	  if(psNameInPopUp.isEmpty() || psNameInPopUp == null) {
		  System.out.println("PS Name field is empty");
		  psEle.click();
		  psNameSearchInPopUpEle = driver.findElement(By.xpath(psNameSearchInPopUp));
		  wait.until(ExpectedConditions.visibilityOf(psNameSearchInPopUpEle));
		  psNameSearchInPopUpEle.sendKeys(excel.getCellData("Add_Visit_SC", 0, 2));
		  psNameClickEle = driver.findElement(By.xpath(psNameClick));
		  wait.until(ExpectedConditions.visibilityOf(psNameClickEle));
		  psNameClickEle.click();
	  } else if (!psNameInPopUp.contentEquals(psInExcel)) {
		  System.out.println("PS Name is not same as given in the Excel");
		  psEle.click();
		  psNameSearchInPopUpEle = driver.findElement(By.xpath(psNameSearchInPopUp));
		  wait.until(ExpectedConditions.visibilityOf(psNameSearchInPopUpEle));
		  psNameSearchInPopUpEle.sendKeys(excel.getCellData("Add_Visit_SC", 0, 2));
		  psNameClickEle = driver.findElement(By.xpath(psNameClick));
		  wait.until(ExpectedConditions.visibilityOf(psNameClickEle));
		  psNameClickEle.click();
	  } else {
		  System.out.println("The PS is already been selected");
	  }
	  
	  WebElement visitDateEle = driver.findElement(By.xpath(visitDate));
	  String populatedDate = visitDateEle.getText();
	  System.out.println("The populated Date is: "+ populatedDate);
	  
	  if(populatedDate == null || populatedDate.isEmpty()) {
		  visitDateEle.sendKeys(excel.getCellData("Add_Visit_SC", 2, 2));
	  } else {
		  System.out.println("Visit Date is already selected");
	  }
	  
	  Thread.sleep(2000);
	  
	  WebElement visitStartTimeEle = driver.findElement(By.xpath(visitStartTime));
	  visitStartTimeEle.sendKeys(excel.getCellData("Add_Visit_SC", 3, 2));
	  
	 //WebElement loadingSpinnerEle = driver.findElement(By.xpath(loadingSpinner));
	 //wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));
	  
	  WebElement visitEndTimeEle = driver.findElement(By.xpath(visitEndTime));
	  visitEndTimeEle.sendKeys(excel.getCellData("Add_Visit_SC", 4, 2));
	  
	  
	  Thread.sleep(5000);
	  WebElement serviceCodeEle = driver.findElement(By.xpath(serviceCode));
	  serviceCodeEle.click();
	  
	  WebElement serviceCodeSearchEle = driver.findElement(By.xpath(serviceCodeSearch));
	  wait.until(ExpectedConditions.visibilityOf(serviceCodeSearchEle));
	  serviceCodeSearchEle.sendKeys(excel.getCellData("Add_Visit_SC", 6, 2));
	  
	  WebElement serviceSelectEle = driver.findElement(By.xpath(serviceSelect));
	  wait.until(ExpectedConditions.visibilityOf(serviceSelectEle));
	  serviceSelectEle.click();
	  Thread.sleep(2000);
	  
	  WebElement createButtonEle = driver.findElement(By.xpath(createButton));
	 
	  try {
		  createButtonEle.click();
			if (BaseClass.excelToWrite.setCellData("PS Schedule Cal-Add,Edit Visit", "Status", 7, 41, BaseClass.sheetStatus)) {
				//System.out.println("Login successfully.");
			} else {
				//System.out.println("Login Failed.");
			}
			if (BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 27, BaseClass.indexStatus)) {
				EmailSender.setResult(10, BaseClass.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				EmailSender.setDateTime(10, reportDate);
				

			} else {
				//System.out.println("Login Failed.");
			}
			
		} catch (Exception e) {
			System.out.println("In catch of firefox");e.printStackTrace();
			BaseClass.sheetStatus = "Fail";
			BaseClass.indexStatus = BaseClass.sheetStatus;
			BaseClass.excelToWrite.setCellData("PS Schedule Cal-Add,Edit Visit", "Status", 7, 41, BaseClass.sheetStatus);
			BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 27, BaseClass.indexStatus);
			EmailSender.setResult(10, BaseClass.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			EmailSender.setDateTime(10, reportDate);
			
			
		}
	  
	 // wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));
	  Thread.sleep(2000);
	  
	  WebElement assignDCSHeaderEle = driver.findElement(By.xpath(assignDCSHeader));
	  if(assignDCSHeaderEle.isDisplayed()) {
		  System.out.println("Navigated to Assign DCS screen");
	  } else {
		  System.out.println("Assign DCS screen is not opened");
	  }  
	  Thread.sleep(2000);
  }
  
}
