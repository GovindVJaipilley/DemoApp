package Scheduling;

import java.awt.Robot;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginPage.BaseClass;
import ReportMail.EmailSender;
import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class ManageVisits {
	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	JavascriptExecutor js;
	Robot robot;

	//String path = "C:\\POC-Automation\\TestData.xlsx";
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	
	public static boolean isTestMethodEnabled(String methodName) {
		try {
			// Use reflection to get the @Test annotation of the method
			Test testAnnotation = ManageVisits.class.getMethod(methodName).getAnnotation(Test.class);

			// Check the 'enabled' attribute
			return (testAnnotation != null) && testAnnotation.enabled();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			return false;
		}
	}

	@BeforeTest
	public void allProps() throws Exception {
		driver = BaseClass.getDriver();
		path = BaseClass.getTestDataPath();
		wait = BaseClass.getWebDriverWait();
		myActions = BaseClass.getDriverActions();
		js = BaseClass.getJSExecutor();
		robot = BaseClass.getRobot();
		prop = new ReadPropFile();
		excel = new ExcelRead(path);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		BaseClass.sheetStatus = "Pass";
	}

	@Test(dependsOnMethods = "LoginPage.LoginTest.loginLite")
	public void navigateToManageVisits() throws InterruptedException {
		System.out.println("In navigate To Manage Visits");
		int retries = 5;
		while (retries > 0) {
			try {
				System.out.println("Into the while block of iteration: " + retries);
				Common_Methods.clickEleBy_Xpath(prop.getMenuOption(), driver);
				Common_Methods.clickEleBy_Xpath(prop.getSchedulingHeader(), driver);
				Common_Methods.clickEleBy_Xpath(prop.getManageVisitsOption(), driver);
				break;
			} catch (Exception e) {
				System.out.println("Exception Occurred at the iteration: " + retries);

				Thread.sleep(5000);
				retries--;
			}
		}
	}

	@Test(dependsOnMethods = "navigateToManageVisits", priority = 1, enabled = true)
	public void linkVisits() throws InterruptedException {
		driver.navigate().refresh();
		System.out.println("In linkVisits");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Thread.sleep(2000);
		int retries = 5;
		while (retries > 0) {
			try {
				System.out.println("Into the while block of iteration: " + retries);
				Common_Methods.clickEleBy_Xpath(prop.getLinkVisitsSiteDdArrow(), driver);
				break;
			} catch (Exception e) {
				System.out.println("Exception Occurred at the iteration: " + retries);

				Thread.sleep(5000);
				retries--;
			}
		}
		Common_Methods.selectFormDropdown(prop.getLinkVisitsSiteDdul(), driver, excel.getCellData("Link_Visits", 0, 3));
//		Common_Methods.clickEleBy_Xpath(prop.getLVStartDate(), driver);
//		Common_Methods.selectMonthAndYearInDate(excel.getCellData("Link_Visits", 8, 3), excel.getCellData("Link_Visits", 7, 3), prop.getmonthTable(), driver, prop);
//		Common_Methods.selectDayInDate(excel.getCellData("Link_Visits", 9, 3), prop.getdayTable(), driver);
//		Common_Methods.clickEleBy_Xpath(prop.getLVStartDate(), driver);
//		Common_Methods.selectMonthAndYearInDate(excel.getCellData("Link_Visits", 11, 3), excel.getCellData("Link_Visits", 10, 3), prop.getmonthTable(), driver, prop);
//		Common_Methods.selectDayInDate(excel.getCellData("Link_Visits", 12, 3), prop.getdayTable(), driver);
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getPsDdArrowInMV(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.selectFormDropdown(prop.getPsDdUlInMV(), driver, excel.getCellData("Link_Visits", 1, 3));
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getDcsDdArrowInMV(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.selectFormDropdown(prop.getDcsDdUlInMV(), driver, excel.getCellData("Link_Visits", 3, 3));
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getLinkVisitsSearchButton(), driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getLinkVisitsCheckOut())));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Thread.sleep(2000);
		Common_Methods.clickEleBy_Xpath(prop.getLinkVisitsCheckOut(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getLVClockIn())));
		Thread.sleep(2000);
		Common_Methods.clickEleBy_Xpath(prop.getLVClockIn(), driver);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.clickEleBy_Xpath(prop.getLVClockOut(), driver);
		robot.mouseWheel(5);
		Thread.sleep(1000);
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getLVarrivalAdjsutReasonDdArrow())));
		Common_Methods.clickEleBy_Xpath(prop.getLVarrivalAdjsutReasonDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getLVarrivalAdjsutReasonDdUl(), driver,
				excel.getCellData("Link_Visits", 14, 3));
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getLVdepartureAdjsutReasonDdArrow())));
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getLVdepartureAdjsutReasonDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getLVdepartureAdjsutReasonDdUl(), driver, excel.getCellData("Link_Visits", 15, 3));
		Common_Methods.clickEleBy_Xpath(prop.getLVAddTaskButton(), driver);
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getLVAddTaskDdArrow(), driver);
		Thread.sleep(1000);
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getLVAddTaskDdUl())));
		Common_Methods.selectFormDropdown(prop.getLVAddTaskDdUl(), driver, excel.getCellData("Link_Visits", 16, 3));
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLVAddTaskDdUl())));
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getLVTaskAddButton(), driver);
		Thread.sleep(2000);
		Common_Methods.clickEleBy_Xpath(prop.getLVTaskCloseButton(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getLvCreateButton(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getSuccessMsgOkBtn())));
		System.out.println(driver.findElement(By.xpath(prop.getSuccessMsg())).getText());
		// System.out.println(excel.getCellData("Link_Visits", 17, 2));
		Assert.assertEquals(driver.findElement(By.xpath(prop.getSuccessMsg())).getText(),
				excel.getCellData("Link_Visits", 17, 3));
		Common_Methods.clickEleBy_Xpath(prop.getSuccessMsgOkBtn(), driver);
		try {
			
			if (BaseClass.excelToWrite.setCellData("Processed Visits", "Status", 7, 11, BaseClass.sheetStatus)) {
				//System.out.println("Login successfully.");
			} else {
				//System.out.println("Login Failed.");
			}
			if (BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 19, BaseClass.indexStatus)) {
				EmailSender.setResult(14, BaseClass.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				EmailSender.setDateTime(14, reportDate);
				

			} else {
				//System.out.println("Login Failed.");
			}
			
		} catch (Exception e) {
			System.out.println("In catch of firefox");e.printStackTrace();
			BaseClass.sheetStatus = "Fail";
			BaseClass.indexStatus = BaseClass.sheetStatus;
			BaseClass.excelToWrite.setCellData("Processed Visits", "Status", 7, 11, BaseClass.sheetStatus);
			BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 19, BaseClass.indexStatus);
			EmailSender.setResult(14, BaseClass.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			EmailSender.setDateTime(14, reportDate);
			
			
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = "navigateToManageVisits", priority = 2, enabled = true)
	public void Reconciliation() throws InterruptedException {
		System.out.println("In Reconciliation");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Thread.sleep(2000);
		Common_Methods.clickEleBy_Xpath(prop.getReconcilRadioButton(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		if (!isTestMethodEnabled("linkVisits")) {
			Common_Methods.clickEleBy_Xpath(prop.getLinkVisitsSiteDdArrow(), driver);
			Common_Methods.selectFormDropdown(prop.getLinkVisitsSiteDdul(), driver,
					excel.getCellData("Reconciliation", 0, 3));
		}
		Thread.sleep(2000);
		// Common_Methods.clickEleBy_Xpath(prop.getPsDdArrowInMV(), driver);
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		// Common_Methods.selectFormDropdown(prop.getPsDdUlInMV(), driver,
		// excel.getCellData("Link_Visits", 1, 3));
		// Thread.sleep(1000);
		// Common_Methods.clickEleBy_Xpath(prop.getDcsDdArrowInMV(), driver);
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		// Common_Methods.selectFormDropdown(prop.getDcsDdUlInMV(), driver,
		// excel.getCellData("Link_Visits", 3, 3));
		// Thread.sleep(1000);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getLinkVisitsSearchButton())));
		//Thread.sleep(2000);
		//Common_Methods.clickEleBy_Xpath(prop.getLinkVisitsSearchButton(), driver);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getReconcilVisitCB())));
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getReconcilVisitCB(), driver);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getReconcilProcessB())));
		Thread.sleep(2000);
		System.out.println(prop.getReconcilProcessB());
		Common_Methods.clickEleBy_Xpath(prop.getReconcilProcessB(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.clickEleBy_Xpath(prop.getSuccessMsgOkBtn(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Assert.assertEquals(driver.findElement(By.xpath(prop.getRCAccertText())).getText(),excel.getCellData("Reconciliation", 15, 3));
		Common_Methods.clickEleBy_Xpath(prop.getSuccessMsgOkBtn(), driver);
try {
			
			if (BaseClass.excelToWrite.setCellData("Processed Visits", "Status", 7, 12, BaseClass.sheetStatus)) {
				//System.out.println("Login successfully.");
			} else {
				//System.out.println("Login Failed.");
			}
			if (BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 20, BaseClass.indexStatus)) {
				EmailSender.setResult(15, BaseClass.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				EmailSender.setDateTime(15, reportDate);
				

			} else {
				//System.out.println("Login Failed.");
			}
			EmailSender.esend();
		} catch (Exception e) {
			System.out.println("In catch of firefox");e.printStackTrace();
			BaseClass.sheetStatus = "Fail";
			BaseClass.indexStatus = BaseClass.sheetStatus;
			BaseClass.excelToWrite.setCellData("Processed Visits", "Status", 7, 12, BaseClass.sheetStatus);
			BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 20, BaseClass.indexStatus);
			EmailSender.setResult(15, BaseClass.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			EmailSender.setDateTime(15, reportDate);
			EmailSender.esend();
			
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
	}
}
