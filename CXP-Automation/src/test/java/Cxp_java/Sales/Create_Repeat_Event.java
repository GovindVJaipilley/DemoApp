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

import XpertKitchen.LoginPage.Base_Class;
import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class Create_Repeat_Event {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	ReadPropFile prop;
	Actions myActions;
	ExcelRead excel;
	Robot robot;
	String path; 
	
 
	@BeforeTest
	public void createRe_Before() throws IOException 
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
	public void create_Repeat_Event() throws InterruptedException
	{
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		myActions.moveToElement(Common_Methods.getEle_Xpath(prop.getEventDHTML_Re(), driver)).build().perform();
		Common_Methods.clickEleBy_Xpath(prop.getRepeatEve_L(), driver);
		Thread.sleep(2000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickOnRadio_CB(excel.getCellData("Create_Repeat_E", 2, 2), driver, prop.getDMWDiv());
		Common_Methods.enterDataToTextField_Xpath(prop.getRepeatTimes_TB(), driver, excel.getCellData("Create_Repeat_E", 3, 2));
		Common_Methods.clickEleBy_Xpath(prop.getCustSave(), driver);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Assert.assertEquals(Common_Methods.getEle_Xpath(prop.getEventID_R(), driver).isDisplayed(), true);
		Common_Methods.clickEleBy_Xpath(prop.getCloseB_ED(), driver);
	}
}
