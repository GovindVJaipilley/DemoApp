      package XpertKitchen.Events;

import java.awt.Robot;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;
import XpertKitchen.LoginPage.Base_Class;

public class Create_Event 
{
	 	WebDriver driver;
		WebDriverWait wait;
		JavascriptExecutor js;
		ReadPropFile prop;
		Actions myActions;
		ExcelRead excel;
		Robot robot;
		String path; 
		
	 
		@BeforeTest
		public void CreateEvent_Before() throws IOException 
		{
			
			driver = Base_Class.getDriver();
			path = Base_Class.getTestDataPath();
			wait = Base_Class.getWebDriverWait();
			myActions = new Actions(driver);
			prop = new ReadPropFile();
			excel = new ExcelRead(path);
			js = Base_Class.getJSExecutor();
			robot = Base_Class.getRobot();
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Base_Class.sheetStatus = "Pass";
		}
	
	@Test(dependsOnMethods = "XpertKitchen.LoginPage.Login_Test.Login")
	public void eventCreation() throws InterruptedException
	{
		Common_Methods.waitForElement_Xpath(prop.getNewEvent(), wait, "elementToBeClickable");
		Common_Methods.clickEleBy_Xpath(prop.getNewEvent(), driver);
		Thread.sleep(3000);
		Common_Methods.clickEleBy_Xpath(prop.getBusinessUnitDdArrow(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getBusinessUnitDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getBusinessUnitDdUl(), driver, excel.getCellData("Create_Event", 0, 3));
		Common_Methods.clickEleBy_Xpath(prop.getCEBeginDate(), driver);
		Common_Methods.selectMonthAndYearInDate(excel.getCellData("Create_Event", 1, 3), excel.getCellData("Create_Event", 2, 3), prop.getmonthTable(), driver, prop);
		Common_Methods.selectDayInDate(excel.getCellData("Create_Event", 3, 3), prop.getdayTable(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getBeginTime(), driver);
		Common_Methods.clickOnTime(driver, prop, excel.getCellData("Create_Event", 4, 3));
		Common_Methods.clickEleBy_Xpath(prop.getEventTypeDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getEventTypeDdUl(), driver, excel.getCellData("Create_Event", 5, 3));
		Common_Methods.clickEleBy_Xpath(prop.getAccountExecutiveDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getAccountExecutiveDdUl(), driver, excel.getCellData("Create_Event", 10, 3));
		Common_Methods.clickEleBy_Xpath(prop.getStatusDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getStatusDdUl(), driver, excel.getCellData("Create_Event", 11, 3));
		Common_Methods.clickEleBy_Xpath(prop.getCEEndDate(), driver);
		Common_Methods.selectMonthAndYearInDate(excel.getCellData("Create_Event", 12, 3), excel.getCellData("Create_Event", 13, 3), prop.getmonthTable(), driver, prop);
		Common_Methods.selectDayInDate(excel.getCellData("Create_Event", 14, 3), prop.getdayTable(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getCEEndTime(), driver);
		Common_Methods.clickOnTime(driver, prop, excel.getCellData("Create_Event", 15, 3));
		Common_Methods.clickEleBy_Xpath(prop.getLocationNameDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getLocationNameDdUl(), driver, excel.getCellData("Create_Event", 9, 3));
		Common_Methods.clickEleBy_Xpath(prop.getEventThemeDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getEventThemeDdArrow(), driver, excel.getCellData("Create_Event", 6, 3));
		//Common_Methods.enterDataToTextField_Xpath(prop.getAdultCount(), driver, excel.getCellData("Create_Event", 7, 3));
		//Common_Methods.enterDataToTextField_Xpath(prop.getKidsCount(), driver, excel.getCellData("Create_Event", 8, 3));
		Common_Methods.enterDataToTextField_Xpath(prop.getProposalName(), driver, excel.getCellData("Create_Event", 17, 3));
		//Common_Methods.enterDataToTextField_Xpath(prop.getVendorCount(), driver, excel.getCellData("Create_Event", 19, 3));
		//Common_Methods.enterDataToTextField_Xpath(prop.getKosherCount(), driver, excel.getCellData("Create_Event", 18, 3));
		Common_Methods.clickEleBy_Xpath(prop.getCreateButton(), driver);
		Common_Methods.waitForElement_Xpath(prop.getAssertText(), wait, "visibilityOfElementLocated");
		Assert.assertEquals(Common_Methods.getElementText_Xpath(prop.getAssertText(), driver), excel.getCellData("Create_Event", 20, 3));
		Common_Methods.clickEleBy_Xpath(prop.getOkButton(), driver);
		Common_Methods.waitForElement_Xpath(prop.getEventId_Gen(), wait, "visibilityOfElementLocated");
		Filter_Event.event_Id = Common_Methods.getElementText_Xpath(prop.getEventId_Gen(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getCloseButton(), driver);
		
	}
}
