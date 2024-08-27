package Dcs;

import java.awt.Robot;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class CreateDcsAvailability {
	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	// InputStream inputStream;
	//String path = "C:\\POC-Automation\\TestData.xlsx";
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	
	@BeforeTest
	public void allProps() throws IOException {
		driver = BaseClass.getDriver();
		path = BaseClass.getTestDataPath();
		wait = BaseClass.getWebDriverWait();
		myActions = BaseClass.getDriverActions();
		robot = BaseClass.getRobot();
		prop = new ReadPropFile();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		excel = new ExcelRead(path);
		
		BaseClass.sheetStatus = "Pass";
	}

	@Test(dependsOnMethods = "LoginPage.LoginTest.loginLite", priority=1)
	public void navigateToDcsListing() {
		System.out.println("In Dcs Listing");
		Common_Methods.navigateToDcsListingInCommon_Methods(driver, prop, wait);
	}

	@Test(priority=2)
	public void filterDCS() throws Exception {
		
		
		

		int retries = 5;
		while (retries > 0) {
			try {
				System.out.println("Into the while block of iteration: " + retries);
				WebElement filterOptionEle = driver.findElement(By.xpath(prop.getFilterIcon()));
				filterOptionEle.click();
				break;
			} catch (ElementClickInterceptedException e) {
				System.out.println("Exception Occurred at the iteration: " + retries);
				//wait.until(ExpectedConditions.elementToBeClickable(filterOptionEle));
				Thread.sleep(5000);
				retries--;
			}
		}

		driver.findElement(By.xpath(prop.getDcsName())).sendKeys(excel.getCellData("DcsFilter", 1, 2));
		Common_Methods.clickEleBy_Xpath(prop.getDCSStatusDropdownArrow(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getDCSStatusAll(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getDCSStatusDropdownCross(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getDCSContractorCross(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getDCSSearchButton(), driver);

	}

	// @Test(dependsOnMethods = "filterDCS", retryAnalyzer =
	// Analyzer.RetryAnalyzer.class)
	@Test(dependsOnMethods = "filterDCS")
	public void navigateToDcsAvailability() throws InterruptedException {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getDhtmlOnDcsListing(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getAvailOpInDhtml(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.clickEleBy_Xpath(prop.getCreateAvaiButton(), driver);
	}

	// @Test(dependsOnMethods = "navigateToDcsAvailability", retryAnalyzer =
	// Analyzer.RetryAnalyzer.class)
	@Test(dependsOnMethods = "navigateToDcsAvailability", priority = 1, enabled = true)
	public void createDcsAvailability_Daily() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		// Common_Methods.clickOnRadio(excel.getCellData("CreateDcs_Availability_Daily",
		// 0, 3), driver, prop.getRecurrencePDiv());
		Common_Methods.enterDataToTextField_Xpath(prop.getEveryDaysInput(), driver,
				excel.getCellData("CreateDcs_Availability_Daily", 1, 3));
		System.out.println(excel.getCellData("CreateDcs_Availability_Daily", 2, 3));
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getSlot1StartTime())));
		Common_Methods.enterDataToTextField_Xpath(prop.getSlot1StartTimeD(), driver,
				Common_Methods.convertTextToTimeFormat(excel.getCellData("CreateDcs_Availability_Daily", 2, 3)));
		Common_Methods.enterDataToTextField_Xpath(prop.getSlot1EndTimeD(), driver,
				Common_Methods.convertTextToTimeFormat(excel.getCellData("CreateDcs_Availability_Daily", 3, 3)));
		Common_Methods.enterDataToTextField_Xpath(prop.getSlot2StartTimeD(), driver,
				Common_Methods.convertTextToTimeFormat(excel.getCellData("CreateDcs_Availability_Daily", 4, 3)));
		Common_Methods.enterDataToTextField_Xpath(prop.getSlot2EndTimeD(), driver,
				Common_Methods.convertTextToTimeFormat(excel.getCellData("CreateDcs_Availability_Daily", 5, 3)));
		Common_Methods.clickEleBy_Xpath(prop.getStartDate(), driver);
		Common_Methods.selectMonthAndYearInDate(excel.getCellData("CreateDcs_Availability_Daily", 7, 3),
				excel.getCellData("CreateDcs_Availability_Daily", 6, 3), prop.getmonthTable(), driver, prop);
		Common_Methods.selectDayInDate(excel.getCellData("CreateDcs_Availability_Daily", 8, 3), prop.getdayTable(),
				driver);
		Common_Methods.clickEleBy_Xpath(prop.getEndDate(), driver);
		Common_Methods.selectMonthAndYearInDate(excel.getCellData("CreateDcs_Availability_Daily", 10, 3),
				excel.getCellData("CreateDcs_Availability_Daily", 9, 3), prop.getmonthTable(), driver, prop);
		Common_Methods.selectDayInDate(excel.getCellData("CreateDcs_Availability_Daily", 11, 3), prop.getdayTable(),
				driver);
		Common_Methods.clickEleBy_Xpath(prop.getDcsEmpSaveButton(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Assert.assertEquals(driver.findElement(By.xpath(prop.getDcsOkText())).getText(),
				excel.getCellData("CreateDcs_Availability_Daily", 12, 3));
		Common_Methods.clickEleBy_Xpath(prop.getDcsOkButton(), driver);
	}

	@Test(dependsOnMethods = "navigateToDcsAvailability", priority = 2, enabled = true)
	public void createDcsAvailability_Weekly() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.clickOnRadio(excel.getCellData("CreateDcs_Availability_Weekly", 0, 3), driver,
				prop.getRecurrencePDiv());
		Common_Methods.enterDataToTextField_Xpath(prop.getEveryDaysInput(), driver,
				excel.getCellData("CreateDcs_Availability_Weekly", 1, 3));
		Common_Methods.enterTimeToWeeklyAvailability(driver, prop, excel, "CreateDcs_Availability_Weekly");
		Common_Methods.clickEleBy_Xpath(prop.getStartDate(), driver);
		Common_Methods.selectMonthAndYearInDate(excel.getCellData("CreateDcs_Availability_Weekly", 8, 3),
				excel.getCellData("CreateDcs_Availability_Weekly", 7, 3), prop.getmonthTable(), driver, prop);
		Common_Methods.selectDayInDate(excel.getCellData("CreateDcs_Availability_Weekly", 9, 3), prop.getdayTable(),
				driver);
		Common_Methods.clickEleBy_Xpath(prop.getEndDate(), driver);
		Common_Methods.selectMonthAndYearInDate(excel.getCellData("CreateDcs_Availability_Weekly", 11, 3),
				excel.getCellData("CreateDcs_Availability_Weekly", 10, 3), prop.getmonthTable(), driver, prop);
		Common_Methods.selectDayInDate(excel.getCellData("CreateDcs_Availability_Weekly", 12, 3), prop.getdayTable(),
				driver);
		Common_Methods.clickEleBy_Xpath(prop.getDcsEmpSaveButton(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Assert.assertEquals(driver.findElement(By.xpath(prop.getDcsOkText())).getText(),
				excel.getCellData("CreateDcs_Availability_Weekly", 13, 3));
		
		try {
			Common_Methods.clickEleBy_Xpath(prop.getDcsOkButton(), driver);

				EmailSender.setResult(8, BaseClass.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				EmailSender.setDateTime(8, reportDate);

		} catch (Exception e) {
			System.out.println("In catch of firefox");e.printStackTrace();
			BaseClass.sheetStatus = "Fail";
			BaseClass.indexStatus = BaseClass.sheetStatus;
			
			EmailSender.setResult(8, BaseClass.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			EmailSender.setDateTime(8, reportDate);
			
		}
	}

	@Test(dependsOnMethods = "navigateToDcsAvailability", priority = 3, enabled = true)
	public void createDcsAvailability_Monthly() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.clickOnRadio(excel.getCellData("CreateDcs_Availability_Monthly", 0, 3), driver,
				prop.getRecurrencePDiv());
		Common_Methods.enterDataToTextField_Xpath(prop.getEveryDaysInput(), driver,
				excel.getCellData("CreateDcs_Availability_Monthly", 1, 3));
		if (excel.getCellData("CreateDcs_Availability_Monthly", 2, 3).equalsIgnoreCase("yes")) {
			Common_Methods.clickEleBy_Xpath(prop.getMonthlyDayRadio(), driver);
		} else {
			Common_Methods.clickEleBy_Xpath(prop.getMonthlyWeekRadio(), driver);
			Common_Methods.clickEleBy_Xpath(prop.getWeekDdArrow(), driver);
			Common_Methods.selectFormDropdown(prop.getWeekDdUl(), driver,
					excel.getCellData("CreateDcs_Availability_Monthly", 4, 3));
			Common_Methods.clickEleBy_Xpath(prop.getDayDdArrow(), driver);
			Common_Methods.selectFormDropdown(prop.getDayDdUl(), driver,
					excel.getCellData("CreateDcs_Availability_Monthly", 5, 3));
			Common_Methods.enterDataToTextField_Xpath(prop.getSlot1StartTime(), driver,
					Common_Methods.convertTextToTimeFormat(excel.getCellData("CreateDcs_Availability_Monthly", 6, 3)));
			Common_Methods.enterDataToTextField_Xpath(prop.getSlot1EndTime(), driver,
					Common_Methods.convertTextToTimeFormat(excel.getCellData("CreateDcs_Availability_Monthly", 7, 3)));
			Common_Methods.enterDataToTextField_Xpath(prop.getSlot2StartTime(), driver,
					Common_Methods.convertTextToTimeFormat(excel.getCellData("CreateDcs_Availability_Monthly", 8, 3)));
			Common_Methods.enterDataToTextField_Xpath(prop.getSlot2EndTime(), driver,
					Common_Methods.convertTextToTimeFormat(excel.getCellData("CreateDcs_Availability_Monthly", 9, 3)));
			Common_Methods.clickEleBy_Xpath(prop.getStartDate(), driver);
			Common_Methods.selectMonthAndYearInDate(excel.getCellData("CreateDcs_Availability_Monthly", 11, 3),
					excel.getCellData("CreateDcs_Availability_Monthly", 10, 3), prop.getmonthTable(), driver, prop);
			Common_Methods.selectDayInDate(excel.getCellData("CreateDcs_Availability_Monthly", 12, 3),
					prop.getdayTable(), driver);
			Common_Methods.clickEleBy_Xpath(prop.getEndDate(), driver);
			Common_Methods.selectMonthAndYearInDate(excel.getCellData("CreateDcs_Availability_Monthly", 14, 3),
					excel.getCellData("CreateDcs_Availability_Monthly", 13, 3), prop.getmonthTable(), driver, prop);
			Common_Methods.selectDayInDate(excel.getCellData("CreateDcs_Availability_Monthly", 15, 3),
					prop.getdayTable(), driver);
			Common_Methods.clickEleBy_Xpath(prop.getDcsEmpSaveButton(), driver);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
			Assert.assertEquals(driver.findElement(By.xpath(prop.getDcsOkText())).getText(),
					excel.getCellData("CreateDcs_Availability_Monthly", 16, 3));
			Common_Methods.clickEleBy_Xpath(prop.getDcsOkButton(), driver);
		}

	}
}
