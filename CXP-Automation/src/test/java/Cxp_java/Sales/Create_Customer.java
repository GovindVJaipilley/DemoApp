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
import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;
import XpertKitchen.LoginPage.Base_Class;

public class Create_Customer 
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
		public void createCust_Before() throws IOException 
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
		
		@Test(dependsOnMethods = "Cxp_java.LoginPage.Login_Test.Login")
		public void create_Customer() throws InterruptedException
		{
			Common_Methods.naviToSales(driver, prop, wait);
			Thread.sleep(2000);
			Common_Methods.switchToHead(driver, prop);
			Thread.sleep(3000);
			Common_Methods.clickEle_JS(prop.getCustSearch(), driver);
			Thread.sleep(3000);
			Common_Methods.switchToDefault(driver);
			Common_Methods.switchToHead(driver, prop);
			Thread.sleep(3000);
			Common_Methods.clickEleBy_Xpath(prop.getNewCustomer(), driver);
			Thread.sleep(3000);
			Common_Methods.switchToDefault(driver);
			Common_Methods.switchToView(driver, prop);
			int retries = 5;
			while (retries > 0) {
				try {
					System.out.println("Into the while block of iteration: " + retries);
					Common_Methods.selectFormDropdown_Op(prop.getCustomerTypes(), driver, excel.getCellData("Customer_Basic_info", 0, 2));
			break;
				} catch (Exception e) {
					System.out.println("Exception Occurred at the iteration: " + retries);
					Thread.sleep(2000);
					retries--;
				}
			}
			Common_Methods.enterDataToTextField_Xpath(prop.getCustomerName(), driver, excel.getCellData("Customer_Basic_info", 1, 2));
			Common_Methods.enterDataToTextField_Xpath(prop.getCust_FirstName(), driver, excel.getCellData("Customer_Basic_info", 2, 2));
			Common_Methods.enterDataToTextField_Xpath(prop.getProposalNameCx(), driver, excel.getCellData("Customer_Basic_info", 5, 2));
			Common_Methods.enterDataToTextField_Xpath(prop.getA_Street(), driver, excel.getCellData("Customer_Address", 0, 2));
			Common_Methods.enterDataToTextField_Xpath(prop.getA_City(), driver, excel.getCellData("Customer_Address", 1, 2));
			Common_Methods.enterDataToTextField_Xpath(prop.getA_State(), driver, excel.getCellData("Customer_Address", 2, 2));
			Common_Methods.enterDataToTextField_Xpath(prop.getA_ZIP(), driver, excel.getCellData("Customer_Address", 3, 2));
			Common_Methods.enterDataToTextField_Xpath(prop.getA_Phone(), driver, excel.getCellData("Customer_Address", 4, 2));
			Common_Methods.clickEleBy_Xpath(prop.getSA_Add_CheckB(), driver);
			Common_Methods.enterDataToTextField_Xpath(prop.getBillContactName(), driver, excel.getCellData("Customer_Basic_info", 1, 2));
			Common_Methods.enterDataToTextField_Xpath(prop.getReferralType_BI(), driver, excel.getCellData("Cust_B_Info", 0, 2));
			Common_Methods.selectFormDropdown_Op(prop.getBusinessUnits_BI(), driver, excel.getCellData("Cust_B_Info", 1, 2));
			Common_Methods.clickEleBy_Xpath(prop.getCustSave(), driver);
			Thread.sleep(2000);
			Common_Methods.switchToDefault(driver);
			Common_Methods.switchToHead(driver, prop);
			Common_Methods.waitForElement_Xpath(prop.getCustVali_Text(), wait, "visibilityOfElementLocated");
			try 
			{
				Assert.assertEquals(Common_Methods.getElementText_Xpath(prop.getCustVali_Text(), driver).equalsIgnoreCase(excel.getCellData("Customer_Basic_info", 4, 2)), true);
				Email_Sender.setResult(3, Base_Class.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				Email_Sender.setDateTime(3, reportDate);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				Base_Class.sheetStatus = "Fail";
				Email_Sender.setResult(3, Base_Class.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				Email_Sender.setDateTime(3, reportDate);
			}
			}
}
