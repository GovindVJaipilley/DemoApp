package Dcs;

import java.awt.Robot;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginPage.BaseClass;
import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class CreateDcsAvailabilityUpdate {
	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	InputStream inputStream;
	OutputStream outputStream;
	Robot robot;
	
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
		excel = new ExcelRead(path);
		
	   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test(dependsOnMethods = "Dcs.CreateDcsAvailability.filterDCS")
	public void navigateToDcsAvailabilityUpdate() throws InterruptedException
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Thread.sleep(2000);
		Common_Methods.clickEleBy_Xpath(prop.getDhtmlOnDcsListing(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getAvailOpInDhtml(), driver);
		
	}
	
	@Test(dependsOnMethods = "navigateToDcsAvailabilityUpdate", priority = 1, enabled = false)
	public void createDcsAvailabilityUpdate_Daily()
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.searchByDateAndClickOnEdit(Common_Methods.convertTextToDateFormate(excel.getCellData("CreateDcs_Availability_Daily_Up", 6, 3), excel.getCellData("CreateDcs_Availability_Daily_Up", 7, 3), excel.getCellData("CreateDcs_Availability_Daily_Up", 8, 3)), driver, prop);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.enterDataToTextField_Xpath(prop.getEveryDaysInput(), driver, excel.getCellData("CreateDcs_Availability_Daily_Up", 1, 3));
		Common_Methods.enterDataToTextField_Xpath(prop.getSlot1StartTime(), driver, Common_Methods.convertTextToTimeFormat(excel.getCellData("CreateDcs_Availability_Daily_Up", 2, 3)));
		Common_Methods.enterDataToTextField_Xpath(prop.getSlot1EndTime(), driver, Common_Methods.convertTextToTimeFormat(excel.getCellData("CreateDcs_Availability_Daily_Up", 3, 3)));
		Common_Methods.enterDataToTextField_Xpath(prop.getSlot2StartTime(), driver, Common_Methods.convertTextToTimeFormat(excel.getCellData("CreateDcs_Availability_Daily_Up", 4, 3)));
		Common_Methods.enterDataToTextField_Xpath(prop.getSlot2EndTime(), driver, Common_Methods.convertTextToTimeFormat(excel.getCellData("CreateDcs_Availability_Daily_Up", 5, 3)));
		Common_Methods.clickEleBy_Xpath(prop.getEffectiveFromDate(), driver);
		Common_Methods.selectMonthAndYearInDate(excel.getCellData("CreateDcs_Availability_Daily_Up", 13, 3), excel.getCellData("CreateDcs_Availability_Daily_Up", 12, 3), prop.getmonthTable(), driver, prop);
		Common_Methods.selectDayInDate(excel.getCellData("CreateDcs_Availability_Daily_Up", 14, 3), prop.getdayTable(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getEndDate(), driver);
		Common_Methods.selectMonthAndYearInDate(excel.getCellData("CreateDcs_Availability_Daily_Up", 10, 3), excel.getCellData("CreateDcs_Availability_Daily_Up", 9, 3), prop.getmonthTable(), driver, prop);
		Common_Methods.selectDayInDate(excel.getCellData("CreateDcs_Availability_Daily_Up", 11, 3), prop.getdayTable(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getDcsEmpSaveButton(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Assert.assertEquals(driver.findElement(By.xpath(prop.getDcsOkText())).getText(), excel.getCellData("CreateDcs_Availability_Daily_Up", 15, 2));
		Common_Methods.clickEleBy_Xpath(prop.getDcsOkButton(), driver);
	}
	
	@Test(dependsOnMethods = "navigateToDcsAvailabilityUpdate", priority = 2, enabled = false)
	public void createDcsAvailabilityUpdate_Weekly()
	{
		System.out.println("In createDcsAvailabilityUpdate_Weekly");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		
		Common_Methods.searchByDateAndClickOnEdit(Common_Methods.convertTextToDateFormate(excel.getCellData("CreateDcs_Availability_WeeklyUp", 7, 3), excel.getCellData("CreateDcs_Availability_WeeklyUp", 8, 3), excel.getCellData("CreateDcs_Availability_WeeklyUp", 9, 3)), driver, prop);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.clickOnRadio(excel.getCellData("CreateDcs_Availability_WeeklyUp", 0, 3), driver, prop.getRecurrencePDiv());
		Common_Methods.enterDataToTextField_Xpath(prop.getEveryDaysInput(), driver, excel.getCellData("CreateDcs_Availability_WeeklyUp", 1, 3));
		Common_Methods.enterTimeToWeeklyAvailability(driver, prop, excel, "CreateDcs_Availability_WeeklyUp");
		Common_Methods.clickEleBy_Xpath(prop.getEndDate(), driver);
		Common_Methods.selectMonthAndYearInDate(excel.getCellData("CreateDcs_Availability_WeeklyUp", 11, 3), excel.getCellData("CreateDcs_Availability_WeeklyUp", 10, 3), prop.getmonthTable(), driver, prop);
		Common_Methods.selectDayInDate(excel.getCellData("CreateDcs_Availability_WeeklyUp", 12, 3), prop.getdayTable(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getEffectiveFromDate(), driver);
		Common_Methods.selectMonthAndYearInDate(excel.getCellData("CreateDcs_Availability_WeeklyUp", 14, 3), excel.getCellData("CreateDcs_Availability_WeeklyUp", 13, 3), prop.getmonthTable(), driver, prop);
		Common_Methods.selectDayInDate(excel.getCellData("CreateDcs_Availability_WeeklyUp", 15, 3), prop.getdayTable(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getDcsEmpSaveButton(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Assert.assertEquals(driver.findElement(By.xpath(prop.getDcsOkText())).getText(), excel.getCellData("CreateDcs_Availability_WeeklyUp", 16, 3));
		Common_Methods.clickEleBy_Xpath(prop.getDcsOkButton(), driver);
	}
	
	@Test(dependsOnMethods = "navigateToDcsAvailabilityUpdate", priority = 3, enabled = true)
	public void createDcsAvailabilityUpdate_Monthly()
	{
		System.out.println("In createDcsAvailabilityUpdate_Monthly");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		
		Common_Methods.searchByDateAndClickOnEdit(Common_Methods.convertTextToDateFormate(excel.getCellData("CreateDcs_AvailabilityMonthlyUp", 10, 3), excel.getCellData("CreateDcs_AvailabilityMonthlyUp", 11, 3), excel.getCellData("CreateDcs_AvailabilityMonthlyUp", 12, 3)), driver, prop);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.clickOnRadio(excel.getCellData("CreateDcs_AvailabilityMonthlyUp", 0, 3), driver, prop.getRecurrencePDiv());
		Common_Methods.enterDataToTextField_Xpath(prop.getEveryDaysInput(), driver, excel.getCellData("CreateDcs_AvailabilityMonthlyUp", 1, 3));
		if(excel.getCellData("CreateDcs_AvailabilityMonthlyUp", 2, 3).equalsIgnoreCase("yes"))
		{
			Common_Methods.clickEleBy_Xpath(prop.getMonthlyDayRadio(), driver);
		}
		else
		{
			Common_Methods.clickEleBy_Xpath(prop.getMonthlyWeekRadio(), driver);
			Common_Methods.clickEleBy_Xpath(prop.getWeekDdArrow(), driver);
			Common_Methods.selectFormDropdown(prop.getWeekDdUl(), driver, excel.getCellData("CreateDcs_AvailabilityMonthlyUp", 4, 3));
			Common_Methods.clickEleBy_Xpath(prop.getDayDdArrow(), driver);
			Common_Methods.selectFormDropdown(prop.getDayDdUl(), driver, excel.getCellData("CreateDcs_AvailabilityMonthlyUp", 5, 3));
			Common_Methods.enterDataToTextField_Xpath(prop.getSlot1StartTime(), driver, Common_Methods.convertTextToTimeFormat(excel.getCellData("CreateDcs_AvailabilityMonthlyUp", 6, 3)));
			Common_Methods.enterDataToTextField_Xpath(prop.getSlot1EndTime(), driver, Common_Methods.convertTextToTimeFormat(excel.getCellData("CreateDcs_AvailabilityMonthlyUp", 7, 3)));
			Common_Methods.enterDataToTextField_Xpath(prop.getSlot2StartTime(), driver, Common_Methods.convertTextToTimeFormat(excel.getCellData("CreateDcs_AvailabilityMonthlyUp", 8, 3)));
			Common_Methods.enterDataToTextField_Xpath(prop.getSlot2EndTime(), driver, Common_Methods.convertTextToTimeFormat(excel.getCellData("CreateDcs_AvailabilityMonthlyUp", 9, 3)));
			Common_Methods.clickEleBy_Xpath(prop.getEndDate(), driver);
			Common_Methods.selectMonthAndYearInDate(excel.getCellData("CreateDcs_AvailabilityMonthlyUp", 14, 3), excel.getCellData("CreateDcs_AvailabilityMonthlyUp", 13, 3), prop.getmonthTable(), driver, prop);
			Common_Methods.selectDayInDate(excel.getCellData("CreateDcs_AvailabilityMonthlyUp", 15, 3), prop.getdayTable(), driver);
			Common_Methods.clickEleBy_Xpath(prop.getEffectiveFromDate(), driver);
			Common_Methods.selectMonthAndYearInDate(excel.getCellData("CreateDcs_AvailabilityMonthlyUp", 17, 3), excel.getCellData("CreateDcs_AvailabilityMonthlyUp", 16, 3), prop.getmonthTable(), driver, prop);
			Common_Methods.selectDayInDate(excel.getCellData("CreateDcs_AvailabilityMonthlyUp", 18, 3), prop.getdayTable(), driver);
			robot.mouseWheel(5);
			Common_Methods.clickEleBy_Xpath(prop.getDcsEmpSaveButton(), driver);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
			Assert.assertEquals(driver.findElement(By.xpath(prop.getDcsOkText())).getText(), excel.getCellData("CreateDcs_AvailabilityMonthlyUp", 19, 3));
			Common_Methods.clickEleBy_Xpath(prop.getDcsOkButton(), driver);
	}
	}
}
