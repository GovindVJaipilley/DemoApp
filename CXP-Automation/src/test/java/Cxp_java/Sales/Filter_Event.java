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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ReportMail.Email_Sender;
import XpertKitchen.LoginPage.Base_Class;
import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class Filter_Event {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	ReadPropFile prop;
	Actions myActions;
	ExcelRead excel;
	Robot robot;
	String path; 
	
 
	@BeforeTest
	public void filter_Before() throws IOException 
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
	
	@Test(dependsOnMethods = "Cxp_java.Sales.Create_Event.create_Event")
	public void filter_Event() throws InterruptedException
	{
		Thread.sleep(3000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToHead(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getFilterLink_SE(), driver);
		Thread.sleep(2000);
		String cWindow = Common_Methods.switchToWindow_C(driver);
		Thread.sleep(3000);
		Common_Methods.enterDataToTextField_Xpath(prop.getEventId_TextB(), driver, Create_Event.event_Id);
		try 
		{
			Common_Methods.clickEleBy_Xpath(prop.getApplyB_F(), driver);
			Common_Methods.switchToWindow_P(driver, cWindow);
			Email_Sender.setResult(6, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(6, reportDate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Base_Class.sheetStatus = "Fail";
			Email_Sender.setResult(6, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(6, reportDate);
		}
	}
}
