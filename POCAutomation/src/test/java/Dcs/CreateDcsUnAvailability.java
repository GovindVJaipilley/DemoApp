package Dcs;

import java.awt.Robot;
import java.io.IOException;
import java.io.InputStream;
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

public class CreateDcsUnAvailability {
	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	InputStream inputStream;
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
	@Test(dependsOnMethods = "Dcs.CreateDcsAvailabilityUpdate.navigateToDcsAvailabilityUpdate")
	public void CreateDCSUnAvailability()
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.clickEleBy_Xpath(prop.getCreateUnAvail(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getExceptionTypeDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getExceptionTypeDdUl(), driver, excel.getCellData("CreateDcsUnAvailability", 0, 3));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getStartDateInput())));
		Common_Methods.clickEleBy_Xpath(prop.getStartDateInput(), driver);
		Common_Methods.selectMonthAndYearInDate(excel.getCellData("CreateDcsUnAvailability", 2, 3), excel.getCellData("CreateDcsUnAvailability", 1, 3), prop.getmonthTable(), driver, prop);
		Common_Methods.selectDayInDate(excel.getCellData("CreateDcsUnAvailability", 3, 3), prop.getdayTable(), driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getEndDateInput())));
		Common_Methods.clickEleBy_Xpath(prop.getEndDateInput(), driver);
		Common_Methods.selectMonthAndYearInDate(excel.getCellData("CreateDcsUnAvailability", 5, 3), excel.getCellData("CreateDcsUnAvailability", 4, 3), prop.getmonthTable(), driver, prop);
		Common_Methods.selectDayInDate(excel.getCellData("CreateDcsUnAvailability", 6, 3), prop.getdayTable(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getStartTimeInput(), driver, Common_Methods.convertTextToTimeFormat(excel.getCellData("CreateDcsUnAvailability", 7, 3)));
		Common_Methods.enterDataToTextField_Xpath(prop.getEndTimeInput(), driver, Common_Methods.convertTextToTimeFormat(excel.getCellData("CreateDcsUnAvailability", 8, 3)));
		Common_Methods.enterDataToTextField_Xpath(prop.getDescriptionTextArea(), driver, excel.getCellData("CreateDcsUnAvailability", 9, 3));
		Common_Methods.clickEleBy_Xpath(prop.getUnAvailCreateButton(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Assert.assertEquals(driver.findElement(By.xpath(prop.getSuccessMsg())).getText(), excel.getCellData("CreateDcsUnAvailability", 10, 3));
		Common_Methods.clickEleBy_Xpath(prop.getSuccessOkBtn(), driver);
		
	}
}
