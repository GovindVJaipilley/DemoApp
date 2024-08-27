package Authorization;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import PS.MultiplePS_Creation;
import ReportMail.EmailSender;
import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class CreateAuthInBaseFlow {

	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	//String path = "C:\\POC-Automation\\TestData.xlsx";
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	String serviceOption;
	String serviceSearch;
	String serviceSelect;
	String serviceBeginDate;
	String serviceEndDate;
	String totalUnits;
	String unlimitedTotalUnits;
	String dpEffectiveFrom;
	String dpEffectiveTo;
	String dpWeeklyToggle;
	String dpWeeklyHeader;
	String weeklyDPMaxUnits;
	String authSaveBtn;
	String authCreatedSuccMsg;
	String authSuccMsgOKBtn;
	int i ;
	public static int rowcount = 0;
	String SheetName,SheetName1;
	
	@BeforeTest
	public void driversForAdmission() throws IOException {
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
	public void createAuthorization() throws InterruptedException {
		if (rowcount>2) {
			i= MultiplePS_Creation.i+1;
			SheetName = "PayorPlan_Details_1";
			SheetName1 ="AuthDetails_1";
		} else {
			i=3;
			SheetName ="PayorPlan_Details";
			SheetName1 ="AuthDetails";
		}
		serviceOption = prop.getServiceOption();
		serviceSearch = prop.getServiceSearch();
		serviceSelect = prop.getServiceSelection();
		serviceBeginDate = prop.getServiceBeginDate();
		serviceEndDate = prop.getServiceEndDate();
		totalUnits = prop.getTotalUnitsInput();
		unlimitedTotalUnits = prop.getUnlimitedTotalUnits();
		dpEffectiveFrom = prop.getDPEffectiveFrom();
		dpEffectiveTo = prop.getDPEffectiveTo();
		dpWeeklyToggle = prop.getWeeklyDPToggle();
		dpWeeklyHeader = prop.getWeeklyDPHeader();
		weeklyDPMaxUnits = prop.getWeeklyDPMaxUnits();
		authSaveBtn = prop.getAuthSaveBtn();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		WebElement serviceOptionEle = driver.findElement(By.xpath(serviceOption));
		serviceOptionEle.click();
		WebElement serviceSearchEle = driver.findElement(By.xpath(serviceSearch));
		wait.until(ExpectedConditions.visibilityOf(serviceSearchEle));
		serviceSearchEle.sendKeys(excel.getCellData(SheetName1, 1, i));
		WebElement serviceSelectEle = driver.findElement(By.xpath(serviceSelect));
		serviceSelectEle.click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(serviceBeginDate)).sendKeys(excel.getCellData(SheetName1, 2, i));
		driver.findElement(By.xpath(unlimitedTotalUnits)).click();
		if(!excel.getCellData(SheetName, 5, i).equalsIgnoreCase("yes"))
		{
		driver.findElement(By.xpath(dpEffectiveFrom)).sendKeys(excel.getCellData(SheetName1, 5, i));
		driver.findElement(By.xpath(dpEffectiveTo)).sendKeys(excel.getCellData(SheetName1, 6, i));
		
		driver.findElement(By.xpath(dpWeeklyToggle)).click();
		WebElement dpWeeklyHeaderEle = driver.findElement(By.xpath(dpWeeklyHeader));
		wait.until(ExpectedConditions.visibilityOf(dpWeeklyHeaderEle));
		
		driver.findElement(By.xpath(weeklyDPMaxUnits)).sendKeys(excel.getCellData(SheetName1, 8, i));
		Thread.sleep(2000);
		}
		
		
		if(excel.getCellData(SheetName, 5, i).equalsIgnoreCase("yes"))
		{
			Common_Methods.clickEleIfYes(prop.getAuthDetailsPrivateDuty(), driver, excel.getCellData(SheetName, 5, i));
			Common_Methods.clickEleBy_Xpath(prop.getRateTypeDdArrow(), driver);
			Common_Methods.selectFormDropdown(prop.getRateTypeDdUl(), driver, excel.getCellData(SheetName1, 9, i));
			int colNum = 10;
			for(int i = 1; i <= 3; i++)
			{
				for(int j = 1; j <= 3; j++)
				{
					String shiftTextB = String.format(prop.getAuthDetailsShiftTextB(), i, j);
					Common_Methods.enterDataToTextField_Xpath(shiftTextB, driver, excel.getCellData(SheetName1, colNum, i));
					colNum++;
				}
			}
			
		}
		
		
		driver.findElement(By.xpath(authSaveBtn)).click();
		Thread.sleep(5000);
		
		authCreatedSuccMsg = prop.getAuthCreatedSuccMsg();
		WebElement authCreatedSuccMsgEle = driver.findElement(By.xpath(authCreatedSuccMsg));
		wait.until(ExpectedConditions.visibilityOf(authCreatedSuccMsgEle));
		
		authSuccMsgOKBtn = prop.getSuccessMsgOkBtn();
		WebElement authSuccMsgOKBtnEle = driver.findElement(By.xpath(authSuccMsgOKBtn));
		if(authSuccMsgOKBtnEle.isDisplayed()) {
			System.out.println("Swal element at Authorization create completion is identified");
			
			try {
				authSuccMsgOKBtnEle.click();

				if (BaseClass.excelToWrite.setCellData("Create Authorization", "Status", 7, 32, BaseClass.sheetStatus)) {
					//System.out.println("Login successfully.");
				} else {
					//System.out.println("Login Failed.");
				}
				if (BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 14, BaseClass.indexStatus)) {
					EmailSender.setResult(5, BaseClass.indexStatus);
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
					Date date = new Date();
					String reportDate = df.format(date);
					EmailSender.setDateTime(5, reportDate);

				} else {
					//System.out.println("Login Failed.");
				}
				
			} catch (Exception e) {
				System.out.println("In catch of firefox");e.printStackTrace();
				BaseClass.sheetStatus = "Fail";
				BaseClass.indexStatus = BaseClass.sheetStatus;
				BaseClass.excelToWrite.setCellData("Create Authorization", "Status", 7, 32, BaseClass.sheetStatus);
				BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 14, BaseClass.indexStatus);
				EmailSender.setResult(5, BaseClass.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				EmailSender.setDateTime(5, reportDate);
				
			}
			//robot.keyPress(KeyEvent.VK_ENTER);
			//robot.keyRelease(KeyEvent.VK_ENTER);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		}else {
			System.out.println("Element at Authorization create completion is not identified");
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		}
	}
}
