package Cxp_java.Kitchen;

import java.awt.Robot;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;
import XpertKitchen.LoginPage.Base_Class;

public class Menu_Accept {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	ReadPropFile prop;
	Actions myActions;
	ExcelRead excel;
	Robot robot;
	String path; 
	
	@BeforeTest
	public void Menu_Accept_Before() throws IOException 
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
	@Test(dependsOnMethods = "Cxp_java.Sales.Sales_Services.create_Menu")
	public void menu_Accept() throws InterruptedException
	{
		Common_Methods.naviToKitchen(driver, prop, wait);
		
//		Common_Methods.naviToSales(driver, prop, wait);
//		Thread.sleep(2000);
//		Common_Methods.switchToHead(driver, prop);
//		Thread.sleep(3000);
//		Common_Methods.clickEleBy_Xpath(prop.getEventFilter(), driver);
//		Thread.sleep(3000);
//		System.out.println("hii");
//		String c_window = Common_Methods.switchToWindow_C(driver);
//		Common_Methods.enterDataToTextField_Xpath(prop.getEnterEventNum(), driver, excel.getCellData("KitchenAccept", 0, 2));
//		System.out.println("hii");
//		Common_Methods.clickEleBy_Xpath(prop.getClickApply(), driver);
//		System.out.println("hello");
//		Common_Methods.switchToWindow_P(driver, c_window);
//		System.out.println("hello");
//		Common_Methods.naviToHome(driver, prop);
//		System.out.println("hello");
//		Thread.sleep(3000);
//		Common_Methods.clickEleBy_Xpath(prop.getClickKitchen(), driver);
//		Thread.sleep(2000);
//		System.out.println("hell2o");
//		String c_window1 = Common_Methods.switchToWindow_C(driver);
//		Thread.sleep(2000);
//		Common_Methods.clickEleBy_Xpath(prop.getConstraintClose(), driver);
//		Common_Methods.switchToWindow_P(driver, c_window1);
//		Thread.sleep(2000);
//		Common_Methods.clickEleBy_Xpath(prop.getClickSent(), driver);
//		Common_Methods.clickEleBy_Xpath(prop.getCLickAccept(), driver);

		
		
		
	}
}