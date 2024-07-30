package Cxp_java.Sales;

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

public class Create_Testing_Event {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	ReadPropFile prop;
	Actions myActions;
	ExcelRead excel;
	Robot robot;
	String path; 
	
 
	@BeforeTest
	public void createTE_Before() throws IOException 
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
	
	@Test(dependsOnMethods = "Cxp_java.Sales.Filter_Event.filter_Event")
	public void createTesting_Event() throws InterruptedException
	{
		Thread.sleep(500);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		myActions.moveToElement(Common_Methods.getEle_Xpath(prop.getEventDHTML(), driver)).build().perform();
		Common_Methods.clickEleBy_Xpath(prop.getTestEve_L(), driver);
		Thread.sleep(3000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.enterDataToTextField_Xpath(prop.getBeginDate_E(), driver, excel.getCellData("Create_Testing_E", 0, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getEndDate_E(), driver, excel.getCellData("Create_Testing_E", 1, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getContactName_E(), driver, excel.getCellData("Customer_Basic_info", 1, 2));
		Common_Methods.clickEleBy_Xpath(prop.getCustSave(), driver);
		Thread.sleep(10000);
		String c_window = Common_Methods.switchToWindow_C(driver);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Thread.sleep(1000);
		Assert.assertEquals(Common_Methods.isEleDisplayed(driver, prop.getEventId_E()), true);
		Common_Methods.clickEleBy_Xpath(prop.getCloseB_ED(), driver);
		Common_Methods.switchToWindow_P(driver, c_window);
	}
}
