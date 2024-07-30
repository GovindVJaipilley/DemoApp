package Cxp_java.Sales;

import java.awt.Robot;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ReportMail.Email_Sender;
import XpertKitchen.LoginPage.Base_Class;
import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class Create_Event {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	ReadPropFile prop;
	Actions myActions;
	ExcelRead excel;
	Robot robot;
	String path; 
	static String event_Id = "";
 
	@BeforeTest
	public void createEvent_Before() throws IOException 
	{
		driver = Base_Class.getDriver();
		path = Base_Class.getTestDataPath();
		wait = Base_Class.getWebDriverWait();
		myActions = new Actions(driver);
		prop = new ReadPropFile();
		excel = new ExcelRead(path);
		js = Base_Class.getJSExecutor();
		robot = Base_Class.getRobot();
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		Base_Class.sheetStatus = "Pass";
	}
	
	@Test(dependsOnMethods = "Cxp_java.Sales.Create_Contact.create_Contact")
	public void create_Event() throws InterruptedException
	{
		Common_Methods.clickEleBy_Xpath(prop.getNewE_custCont(), driver);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getAccExecutive_E(), driver);
		Common_Methods.selectFormDropdown_Op(prop.getAccExecutive_E(), driver, excel.getCellData("Customer_ContactCx", 0, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getBeginDate_E(), driver, excel.getCellData("Create_EventCx", 9, 2));
		Common_Methods.clickEleBy_Xpath(prop.getBeginTime_E(), driver);
		Common_Methods.selectFormDropdown_Op(prop.getBeginTime_E(), driver, excel.getCellData("Create_EventCx", 0, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getEndDate_E(), driver, excel.getCellData("Create_EventCx", 10, 2));
		Common_Methods.clickEleBy_Xpath(prop.getEndTime_E(), driver);
		Common_Methods.selectFormDropdown_Op(prop.getEndTime_E(), driver, excel.getCellData("Create_EventCx", 2, 2));
		Common_Methods.clickEleBy_Xpath(prop.getEndAMPM_E(), driver);
		Common_Methods.selectFormDropdown_Op(prop.getEndAMPM_E(), driver, excel.getCellData("Create_EventCx", 3, 2));
		Common_Methods.clickEleBy_Xpath(prop.getEventType_E(), driver);
		Common_Methods.selectFormDropdown_Op(prop.getEventType_E(), driver, excel.getCellData("Create_EventCx", 4, 2));
		Common_Methods.clickEleBy_Xpath(prop.getStatus_E(), driver);
		Common_Methods.selectFormDropdown_Op(prop.getStatus_E(), driver, excel.getCellData("Create_EventCx", 5, 2));
		Common_Methods.selectFormDropdown_Op(prop.getBUnit_E(), driver, excel.getCellData("Cust_B_Info", 1, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getAdultCount_E(), driver, excel.getCellData("Create_EventCx", 7, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getComments_E(), driver, excel.getCellData("Create_EventCx", 8, 2));
		Common_Methods.selectFormDropdown_Op(prop.getEventTheme_E(), driver, excel.getCellData("Create_EventCx", 12, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getEmail_E(), driver, excel.getCellData("Customer_ContactCx", 1, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getEventName_E(), driver, excel.getCellData("Create_EventCx", 11, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getContactName_E(), driver, excel.getCellData("Cust_B_Info", 1, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getLocationName_E(), driver, excel.getCellData("Cust_B_Info", 1, 2));
		Common_Methods.clickEleBy_Xpath(prop.getCreateEventB_E(), driver);
		Thread.sleep(10000);
		String c_window = Common_Methods.switchToWindow_C(driver);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		int retries = 5;
		while (retries > 0) {
			try {
				System.out.println("Into the while block of iteration: " + retries);
				event_Id = Common_Methods.getElementText_Xpath(prop.getEventId_E(), driver);
		break;
			} catch (Exception e) {
				System.out.println("Exception Occurred at the iteration: " + retries);
				Thread.sleep(2000);
				retries--;
			}
		}
		try 
		{
			Assert.assertEquals(Common_Methods.isEleDisplayed(driver, prop.getEventId_E()), true);
			Common_Methods.clickEleBy_Xpath(prop.getCloseB_ED(), driver);
			Common_Methods.switchToWindow_P(driver, c_window);
			Email_Sender.setResult(5, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(5, reportDate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Base_Class.sheetStatus = "Fail";
			Email_Sender.setResult(5, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(5, reportDate);
		}
	}
	
}
