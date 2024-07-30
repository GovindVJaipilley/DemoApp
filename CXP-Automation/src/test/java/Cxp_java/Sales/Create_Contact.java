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

public class Create_Contact 
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
	public void createCon_Before() throws IOException 
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
	
	@Test(dependsOnMethods = "Cxp_java.Sales.Create_Customer.create_Customer")
	public void create_Contact() throws InterruptedException
	{
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToView(driver, prop);
		Common_Methods.enterDataToTextField_Xpath(prop.getAccExecutive_Cont(), driver, excel.getCellData("Customer_Contact", 0, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getFName_Cont(), driver, excel.getCellData("Customer_Basic_info", 2, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getLName_Cont(), driver, excel.getCellData("Customer_Basic_info", 3, 2));
		Common_Methods.clickEleBy_Xpath(prop.getAddCheckB_Cont(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getPhone_FA(), driver, excel.getCellData("Customer_Address", 4, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getMobile_OI(), driver, excel.getCellData("Customer_Contact", 2, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getEmail_OI(), driver, excel.getCellData("Customer_Contact", 1, 2));
		Common_Methods.selectFormDropdown_Op(prop.getBusinessUnits_BI(), driver, excel.getCellData("Cust_B_Info", 1, 2));
		Common_Methods.clickEleBy_Xpath(prop.getCreatB_CustCont(), driver);
		Common_Methods.waitForElement_Xpath(prop.getNewE_custCont(), wait, "visibilityOfElementLocated");
		try 
		{
			Assert.assertEquals(Common_Methods.isEleDisplayed(driver, prop.getNewE_custCont()), true);
			Email_Sender.setResult(4, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(4, reportDate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Base_Class.sheetStatus = "Fail";
			Email_Sender.setResult(4, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(4, reportDate);
		}
		
	}
}
