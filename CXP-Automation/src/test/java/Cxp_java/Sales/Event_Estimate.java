package Cxp_java.Sales;

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

public class Event_Estimate {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	ReadPropFile prop;
	Actions myActions;
	ExcelRead excel;
	Robot robot;
	String path; 
	
 
	@BeforeTest
	public void createEEsti_Before() throws IOException 
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
	
	@Test(dependsOnMethods = "Cxp_java.Sales.Filter_Event.filter_Event", priority = 1)
	public void menu_Estimate () throws InterruptedException
	{
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		myActions.moveToElement(driver.findElement(By.xpath(prop.getEventDHTML()))).build().perform();
		Common_Methods.clickEleBy_Xpath(prop.getEEstimateL_Dhtml(), driver);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToList(driver, prop);
		Common_Methods.waitForElement_Xpath(prop.getEEsti_MenuL(), wait, "elementToBeClickable");
		Common_Methods.clickEle_JS(prop.getEEsti_MenuL(), driver);
		Thread.sleep(3000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToView(driver, prop);
		Common_Methods.waitForElement_Xpath(prop.getEEstiMenuComment_TB(), wait, "visibilityOfElementLocated");
		Common_Methods.enterDataToTextField_Xpath(prop.getEEstiMenuComment_TB(), driver, excel.getCellData("Esti_Menu", 0, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getGuestCount(), driver, excel.getCellData("Create_EventCx", 7, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getProposedPPcost(), driver, excel.getCellData("Esti_Menu", 1, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getProposedPPcost_C(), driver, excel.getCellData("Esti_Menu", 3, 2));
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getCustSave(), driver);
		Thread.sleep(7000);
		try 
		{
			Assert.assertEquals((driver.findElement(By.xpath(prop.getEstiMenuValiSpan())).getAttribute("value")).equalsIgnoreCase(excel.getCellData("Esti_Menu", 2, 2)), true);
			Email_Sender.setResult(15, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(15, reportDate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Base_Class.sheetStatus = "Fail";
			Email_Sender.setResult(15, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(15, reportDate);
		}
	}
	
	@Test(dependsOnMethods = "Cxp_java.Sales.Filter_Event.filter_Event", priority = 2)
	public void beve_Estimate () throws InterruptedException 
	{
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToList(driver, prop);
		Common_Methods.clickEle_JS(prop.getEEsti_BeveL(), driver);
		Thread.sleep(3000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToView(driver, prop);
		Common_Methods.waitForElement_Xpath(prop.getEEstiMenuComment_TB(), wait, "visibilityOfElementLocated");
		Common_Methods.enterDataToTextField_Xpath(prop.getEEstiMenuComment_TB(), driver, excel.getCellData("Esti_Menu", 0, 3));
		Common_Methods.enterDataToTextField_Xpath(prop.getGuestCount(), driver, excel.getCellData("Create_EventCx", 7, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getProposedPPcost(), driver, excel.getCellData("Esti_Menu", 1, 3));
		Common_Methods.enterDataToTextField_Xpath(prop.getProposedPPcost_C(), driver, excel.getCellData("Esti_Menu", 3, 3));
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getCustSave(), driver);
		Thread.sleep(7000);
		try 
		{
			Assert.assertEquals((driver.findElement(By.xpath(prop.getEstiMenuValiSpan())).getAttribute("value")).equalsIgnoreCase(excel.getCellData("Esti_Menu", 2, 3)), true);
			Email_Sender.setResult(16, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(16, reportDate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Base_Class.sheetStatus = "Fail";
			Email_Sender.setResult(16, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(16, reportDate);
		}
	}
	
	@Test(dependsOnMethods = "Cxp_java.Sales.Filter_Event.filter_Event", priority = 3)
	public void staf_Estimate () throws InterruptedException 
	{
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToList(driver, prop);
		Common_Methods.clickEle_JS(prop.getEEsti_StafL(), driver);
		Thread.sleep(3000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToView(driver, prop);
		Common_Methods.selectFormDropdown_Op(prop.getPersonnelDD1(), driver, excel.getCellData("Esti_Menu", 4, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getPersonnelQty1(), driver, excel.getCellData("Staffing", 0, 2));
		Common_Methods.selectFormDropdown_Op(prop.getInTime1(), driver, excel.getCellData("Staffing", 1, 2));
		Common_Methods.selectFormDropdown_Op(prop.getOutTime1(), driver, excel.getCellData("Staffing", 2, 2));
		Common_Methods.selectFormDropdown_Op(prop.getPersonnelDD2(), driver, excel.getCellData("Esti_Menu", 4, 3));
		Common_Methods.enterDataToTextField_Xpath(prop.getPersonnelQty2(), driver, excel.getCellData("Staffing", 0, 3));
		Common_Methods.selectFormDropdown_Op(prop.getInTime2(), driver, excel.getCellData("Staffing", 1, 2));
		Common_Methods.selectFormDropdown_Op(prop.getOutTime2(), driver, excel.getCellData("Staffing", 2, 2));
		Common_Methods.selectFormDropdown_Op(prop.getPersonnelDD3(), driver, excel.getCellData("Esti_Menu", 4, 4));
		Common_Methods.enterDataToTextField_Xpath(prop.getPersonnelQty3(), driver, excel.getCellData("Staffing", 0, 4));
		Common_Methods.selectFormDropdown_Op(prop.getInTime3(), driver, excel.getCellData("Staffing", 1, 2));
		Common_Methods.selectFormDropdown_Op(prop.getOutTime3(), driver, excel.getCellData("Staffing", 2, 2));
		Common_Methods.selectFormDropdown_Op(prop.getPersonnelDD4(), driver, excel.getCellData("Esti_Menu", 4, 5));
		Common_Methods.enterDataToTextField_Xpath(prop.getPersonnelQty4(), driver, excel.getCellData("Staffing", 0, 5));
		Common_Methods.selectFormDropdown_Op(prop.getInTime4(), driver, excel.getCellData("Staffing", 1, 2));
		Common_Methods.selectFormDropdown_Op(prop.getOutTime4(), driver, excel.getCellData("Staffing", 2, 2));
		Common_Methods.selectFormDropdown_Op(prop.getPersonnelDD5(), driver, excel.getCellData("Esti_Menu", 4, 6));
		Common_Methods.enterDataToTextField_Xpath(prop.getPersonnelQty5(), driver, excel.getCellData("Staffing", 0, 6));
		Common_Methods.selectFormDropdown_Op(prop.getInTime5(), driver, excel.getCellData("Staffing", 1, 2));
		Common_Methods.selectFormDropdown_Op(prop.getOutTime5(), driver, excel.getCellData("Staffing", 2, 2));
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getCustSave(), driver);
		Thread.sleep(7000);
		try 
		{
			Assert.assertEquals((driver.findElement(By.xpath(prop.getStaffvali_text())).getAttribute("value")).equalsIgnoreCase(excel.getCellData("Esti_Menu", 2, 4)), true);
			Email_Sender.setResult(17, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(17, reportDate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Base_Class.sheetStatus = "Fail";
			Email_Sender.setResult(17, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(17, reportDate);
		}
	}
	
	@Test(dependsOnMethods = "Cxp_java.Sales.Filter_Event.filter_Event", priority = 4)
	public void rentals_Estimate () throws InterruptedException 
	{
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToList(driver, prop);
		Common_Methods.clickEle_JS(prop.getEEsti_RentalsL(), driver);
		Thread.sleep(3000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToView(driver, prop);
		Common_Methods.enterDataToTextField_Xpath(prop.getPerPersonCost_R(), driver, excel.getCellData("Esti_Menu", 1, 5));
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getCustSave(), driver);
		Thread.sleep(7000);
		try 
		{
			Assert.assertEquals((driver.findElement(By.xpath(prop.getRentVali_Text())).getAttribute("value")).equalsIgnoreCase(excel.getCellData("Esti_Menu", 2, 5)), true);
			Email_Sender.setResult(18, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(18, reportDate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Base_Class.sheetStatus = "Fail";
			Email_Sender.setResult(18, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(18, reportDate);
		}
	}
	
	@Test(dependsOnMethods = "Cxp_java.Sales.Filter_Event.filter_Event", priority = 5)
	public void linen_Estimate() throws InterruptedException
	{
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToList(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getEEsti_LinenL(), driver);
		Thread.sleep(3000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToView(driver, prop);
		Common_Methods.enterDataToTextField_Xpath(prop.getLinenPPC(), driver, excel.getCellData("Esti_Menu", 1, 6));
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getCustSave(), driver);
		Thread.sleep(7000);
		try 
		{
			Assert.assertEquals((driver.findElement(By.xpath(prop.getRentVali_Text())).getAttribute("value")).equalsIgnoreCase(excel.getCellData("Esti_Menu", 2, 6)), true);
			Email_Sender.setResult(19, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(19, reportDate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Base_Class.sheetStatus = "Fail";
			Email_Sender.setResult(19, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(19, reportDate);
		}
	}
	
	@Test(dependsOnMethods = "Cxp_java.Sales.Filter_Event.filter_Event", priority = 6)
	public void disposible_Estimate() throws InterruptedException
	{
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToList(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getEEsti_DisposablesL(), driver);
		Thread.sleep(3000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToView(driver, prop);
		Common_Methods.enterDataToTextField_Xpath(prop.getLinenPPC(), driver, excel.getCellData("Esti_Menu", 1, 7));
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getCustSave(), driver);
		Thread.sleep(7000);
		try 
		{
			Assert.assertEquals((driver.findElement(By.xpath(prop.getRentVali_Text())).getAttribute("value")).equalsIgnoreCase(excel.getCellData("Esti_Menu", 2, 7)), true);
			//Common_Methods.clickEleBy_Xpath(prop.getSaveB_EC(), driver);
			Email_Sender.setResult(20, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(20, reportDate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Base_Class.sheetStatus = "Fail";
			Email_Sender.setResult(20, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(20, reportDate);
		}
	}
	
	@Test(dependsOnMethods = "Cxp_java.Sales.Filter_Event.filter_Event", priority = 7)
	public void Concierge_Estimate() throws InterruptedException
	{
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToList(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getEEsti_ConciergeL(), driver);
		Thread.sleep(3000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToView(driver, prop);
		Common_Methods.enterDataToTextField_Xpath(prop.getSubT_Conci(), driver, excel.getCellData("Esti_Menu", 2, 8));
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getTAC_EventG(), driver);
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getCustSave(), driver);
		Thread.sleep(7000);
		try 
		{
			Assert.assertEquals((driver.findElement(By.xpath(prop.getRentVali_Text())).getAttribute("value")).equalsIgnoreCase(excel.getCellData("Esti_Menu", 2, 8)), true);
			Email_Sender.setResult(21, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(21, reportDate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Base_Class.sheetStatus = "Fail";
			Email_Sender.setResult(21, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(21, reportDate);
		}
	}
	
	@Test(dependsOnMethods = "Cxp_java.Sales.Filter_Event.filter_Event", priority = 8)
	public void EventGroup_Estimates() throws InterruptedException
	{
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToList(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getEsti_EventGroupL(), driver);
		Thread.sleep(3000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToView(driver, prop);
		Common_Methods.enterDataToTextField_Xpath(prop.getSubT_Conci(), driver, excel.getCellData("Esti_Menu", 2, 9));
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getTAC_EventG(), driver);
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getCustSave(), driver);
		Thread.sleep(7000);
		try 
		{
			Assert.assertEquals((driver.findElement(By.xpath(prop.getRentVali_Text())).getAttribute("value")).equalsIgnoreCase(excel.getCellData("Esti_Menu", 2, 9)), true);
			Common_Methods.clickEleBy_Xpath(prop.getSaveB_EC(), driver);
			Email_Sender.setResult(22, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(22, reportDate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Base_Class.sheetStatus = "Fail";
			Email_Sender.setResult(22, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(22, reportDate);
		}
		//Email_Sender.esend();
	}
	
}
