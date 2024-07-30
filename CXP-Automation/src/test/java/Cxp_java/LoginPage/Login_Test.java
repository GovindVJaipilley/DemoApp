package Cxp_java.LoginPage;

import java.awt.Robot;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ReportMail.Email_Sender;
import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;
import XpertKitchen.LoginPage.Base_Class;

public class Login_Test 
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
		public void login_Before() throws IOException 
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
		@Test()
		public void navigateToUrl()
		{
			try {
			driver.get(excel.getCellData("Credentials", 1, 3));
			if(excel.getCellData("Credentials", 1, 3).equalsIgnoreCase(driver.getCurrentUrl()))
			{
				Email_Sender.setResult(1, Base_Class.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				Email_Sender.setDateTime(1, reportDate);
			}
			} catch (Exception e) {
				e.printStackTrace();
				Base_Class.sheetStatus = "Fail";
				Email_Sender.setResult(1, Base_Class.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				Email_Sender.setDateTime(1, reportDate);
			}
		}
		@Test(dependsOnMethods = "navigateToUrl")
		public void Login() throws InterruptedException
		{
				Common_Methods.waitForElement_Xpath(prop.getCatererID(), wait, "visibilityOfElementLocated");
				Common_Methods.enterDataToTextField_Xpath(prop.getCatererID(), driver, excel.getCellData("Credentials", 2, 3));
				Common_Methods.enterDataToTextField_Xpath(prop.getUserIdCx(), driver, excel.getCellData("Credentials", 3, 3));
				Common_Methods.enterDataToTextField_Xpath(prop.getPasswordCx(), driver, excel.getCellData("Credentials", 4, 3));
				Common_Methods.clickEleBy_Xpath(prop.getLoginCx(), driver);
				Common_Methods.switchToRight(driver, prop);
			try 
			{
				Assert.assertEquals(Common_Methods.getElementText_Xpath(prop.getLoginVerifyText(), driver).equalsIgnoreCase(excel.getCellData("Credentials", 5, 3)), true);
				Email_Sender.setResult(2, Base_Class.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				Email_Sender.setDateTime(2, reportDate);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				Base_Class.sheetStatus = "Fail";
				Email_Sender.setResult(2, Base_Class.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				Email_Sender.setDateTime(2, reportDate);
			}
		}
}
