package PayorPlan;

import org.testng.annotations.Test;

import LoginPage.BaseClass;
import PS.MultiplePS_Creation;
import ReportMail.EmailSender;
import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class AddPayorPlan {

	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	//String path = "C:\\POC-Automation\\TestData.xlsx";
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	int i ;
	public static int rowcount = 0;
	String SheetName;
	
	
	@BeforeTest
	public void beforeTest() throws IOException {
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
	public void CreatePayorPlan() throws InterruptedException {
		if (rowcount>2) {
			i= MultiplePS_Creation.i;
			SheetName = "PayorPlan_Details_1";
		} else {
			i=2;
			SheetName ="PayorPlan_Details";
		}
		String payorPlanOption = prop.getPayorPlanOption();
		String payorPlanSearch = prop.getPayorPlanSearch();
		String payorPlanSelect = prop.getPayorPlanSelection();
		String ppRankOption = prop.getPPRankOption();
		String ppRankSearch = prop.getPPRankSearch();
		String ppRankSelect = prop.getPPRankSelection();
		String ppEffectiveFrom = prop.getPPEffectiveFrom();
		//String ppEffectiveTo = prop.getPPEffectiveTo();
		String ppSelfSubsCheckbox = prop.getSelfSubscriberCheckBox();
		String ppPolicyNumber = prop.getPPPolicyNumber();
		String createBtn = prop.getCreateBtnAtPP();
		String saveAndNextButton = prop.getSaveAndNextButton();
		
		
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.clickEleIfYes(prop.getPayorPlanPrivateDuty(), driver, excel.getCellData(SheetName, 5, i));
		if(!excel.getCellData(SheetName, 5, i).equalsIgnoreCase("yes"))
		{
			WebElement payorPlanOptionEle = driver.findElement(By.xpath(payorPlanOption));
			wait.until(ExpectedConditions.visibilityOf(payorPlanOptionEle));
			payorPlanOptionEle.click();
			WebElement payorPlanSearchEle = driver.findElement(By.xpath(payorPlanSearch));
			wait.until(ExpectedConditions.visibilityOf(payorPlanSearchEle));
			payorPlanSearchEle.sendKeys(excel.getCellData(SheetName, 0, i));
			WebElement payorPlanSelectEle = driver.findElement(By.xpath(payorPlanSelect));
			payorPlanSelectEle.click();
			Thread.sleep(2000);
		}
		else
		{
			WebElement payorPlanOptionEle = driver.findElement(By.xpath(payorPlanOption));
			
			wait.until(ExpectedConditions.elementToBeClickable(payorPlanOptionEle));
			Thread.sleep(2000);
			payorPlanOptionEle.click();
			WebElement payorPlanSearchEle = driver.findElement(By.xpath(payorPlanSearch));
			wait.until(ExpectedConditions.visibilityOf(payorPlanSearchEle));
			payorPlanSearchEle.sendKeys(excel.getCellData(SheetName, 0, i));
			WebElement payorPlanSelectEle = driver.findElement(By.xpath(payorPlanSelect));
			payorPlanSelectEle.click();
			Thread.sleep(2000);
		}
		if(!excel.getCellData(SheetName, 5, i).equalsIgnoreCase("yes"))
		{
			WebElement ppRankOptionEle = driver.findElement(By.xpath(ppRankOption));
			wait.until(ExpectedConditions.visibilityOf(ppRankOptionEle));
			ppRankOptionEle.click();
			WebElement ppRankSearchEle = driver.findElement(By.xpath(ppRankSearch));
			wait.until(ExpectedConditions.visibilityOf(ppRankSearchEle));
			ppRankSearchEle.sendKeys(excel.getCellData(SheetName, 1, i));
			WebElement ppRankSelectEle = driver.findElement(By.xpath(ppRankSelect));
			ppRankSelectEle.click();
			Thread.sleep(2000);
		}
		else
		{
			WebElement ppRankOptionEle = driver.findElement(By.xpath(ppRankOption));
			wait.until(ExpectedConditions.visibilityOf(ppRankOptionEle));
			ppRankOptionEle.click();
			WebElement ppRankSearchEle = driver.findElement(By.xpath(ppRankSearch));
			wait.until(ExpectedConditions.visibilityOf(ppRankSearchEle));
			ppRankSearchEle.sendKeys(excel.getCellData(SheetName, 1, i));
			WebElement ppRankSelectEle = driver.findElement(By.xpath(ppRankSelect));
			ppRankSelectEle.click();
			Thread.sleep(2000);
		}
		driver.findElement(By.xpath(ppEffectiveFrom)).sendKeys(excel.getCellData(SheetName, 2, i));
		driver.findElement(By.xpath(ppSelfSubsCheckbox)).click();
		Thread.sleep(2000);
		
			WebElement ppPolicyNumberEle = driver.findElement(By.xpath(ppPolicyNumber));
			wait.until(ExpectedConditions.visibilityOf(ppPolicyNumberEle));
			ppPolicyNumberEle.sendKeys(excel.getCellData(SheetName, 4, i));
			Thread.sleep(2000);
		
		try {
			System.out.println("Entered into try block to click Create button");
			driver.findElement(By.xpath(saveAndNextButton)).click();
			System.out.println("Completed the create button click");
		} catch (NoSuchElementException nse) {
		    System.out.println("Create button is not found" + nse.getMessage());
		    driver.findElement(By.xpath(createBtn)).click();
		} catch (Exception e) {
		    // This will catch any broader exceptions that might occur
		    System.out.println("An exception occurred: " + e.getMessage());
		    driver.findElement(By.xpath(createBtn)).click();
		}
		
		Thread.sleep(5000);
		
		String ppCreatedSuccMsg = prop.getPPSuccMsg();
		WebElement ppCreatedSuccMsgEle = driver.findElement(By.xpath(ppCreatedSuccMsg));
		wait.until(ExpectedConditions.visibilityOf(ppCreatedSuccMsgEle));
		
		String ppSuccMsgOKBtn = prop.getSuccessMsgOkBtn();
		WebElement ppSuccMsgOKBtnEle = driver.findElement(By.xpath(ppSuccMsgOKBtn));
		if(ppSuccMsgOKBtnEle.isDisplayed()) {
			System.out.println("Swal element at Payor/Plan completion is identified");
			
			try {
				ppSuccMsgOKBtnEle.click();

				if (BaseClass.excelToWrite.setCellData("Add Payor_Plan", "Status", 7, 36, BaseClass.sheetStatus)) {
					//System.out.println("Login successfully.");
				} else {
					//System.out.println("Login Failed.");
				}
				if (BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 13, BaseClass.indexStatus)) {
					EmailSender.setResult(4, BaseClass.indexStatus);
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
					Date date = new Date();
					String reportDate = df.format(date);
					EmailSender.setDateTime(4, reportDate);

				} else {
					//System.out.println("Login Failed.");
				}

			} catch (Exception e) {
				System.out.println("In catch of firefox");
				BaseClass.sheetStatus = "Fail";
				BaseClass.indexStatus = BaseClass.sheetStatus;
				BaseClass.excelToWrite.setCellData("Add Payor_Plan", "Status", 7, 36, BaseClass.sheetStatus);
				BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 13, BaseClass.indexStatus);
				EmailSender.setResult(4, BaseClass.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				EmailSender.setDateTime(4, reportDate);
			}
			//robot.keyPress(KeyEvent.VK_ENTER);
			//robot.keyRelease(KeyEvent.VK_ENTER);
		}else {
			System.out.println("Element at Payor/Plan completion is not identified");
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		
		String authDetailsHeader = prop.getAuthDetailsHeader();
		WebElement authDetailsHeaderEle = driver.findElement(By.xpath(authDetailsHeader));
		wait.until(ExpectedConditions.visibilityOf(authDetailsHeaderEle));
		if(authDetailsHeaderEle.isDisplayed()) {
			System.out.println("Screen is navigated to Authorization creation screen");
		} else {
			System.out.println("Failed to navigate to Authorization creation screen");
		}
		
	}
	
}
