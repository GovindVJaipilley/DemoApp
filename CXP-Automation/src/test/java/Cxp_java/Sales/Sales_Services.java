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

public class Sales_Services {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	ReadPropFile prop;
	Actions myActions;
	ExcelRead excel;
	Robot robot;
	String path; 
	
 
	@BeforeTest
	public void createSS_Before() throws IOException 
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
	public void create_Menu() throws InterruptedException
	{
		Thread.sleep(3000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getEMenuLink_ELHP(), driver);
		Thread.sleep(3000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getCreateMeno_Scratch(), driver);
		Thread.sleep(5000);
		String windowP1 = Common_Methods.switchToWindow_C(driver);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getStaf_SaveB(), driver);
		String windowP2 = Common_Methods.switchToWindow_C(driver);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Thread.sleep(5000);
		Common_Methods.selectFormDropdown_Op(prop.getMenuTypeDD(), driver, excel.getCellData("Menu", 0, 2));
		Common_Methods.clickEleBy_Xpath(prop.getSaveB_EC(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getMenuItem1(), driver);
		Common_Methods.selectFormDropdown_Op(prop.getMenuItem1(), driver, excel.getCellData("Menu", 1, 2));
		Common_Methods.clickEleBy_Xpath(prop.getCourseItem1(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getCourseItem1_V(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getMenuItem2(), driver);
		Common_Methods.selectFormDropdown_Op(prop.getMenuItem2(), driver, excel.getCellData("Menu", 1, 2));
		Common_Methods.clickEleBy_Xpath(prop.getCourseItem2(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getCourseItem2_V(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getMenuItem3(), driver);
		Common_Methods.selectFormDropdown_Op(prop.getMenuItem3(), driver, excel.getCellData("Menu", 1, 2));
		Common_Methods.clickEleBy_Xpath(prop.getCourseItem3(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getCourseItem3_V(), driver);
		Thread.sleep(2000);
		Common_Methods.clickEleBy_Xpath(prop.getSaveB2(), driver);
		Thread.sleep(2000);
		Common_Methods.clickEleBy_Xpath(prop.getStaf_SaveB(), driver);
		Thread.sleep(2000);
		Common_Methods.switchToWindow_P(driver, windowP2);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Thread.sleep(2000);
		Common_Methods.clickEleBy_Xpath(prop.getFinalizeMB(), driver);
		Thread.sleep(2000);
		Common_Methods.switchToWindow_C(driver);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Thread.sleep(2000);
		Common_Methods.enterDataToTextField_Xpath(prop.getNofBars_TB(), driver, excel.getCellData("Menu", 2, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getKitchenAT_CX(), driver, excel.getCellData("Menu", 3, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getBarDuration_TB(), driver, excel.getCellData("Menu", 4, 2));
		Common_Methods.clickEleBy_Xpath(prop.getRentalDelivery_DdArrow(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getDeliveryVehicleDDV(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getSaveB(), driver);
		Common_Methods.switchToWindow_P(driver, windowP1);
		Common_Methods.naviToSales(driver, prop, wait);
		Thread.sleep(5000);
		Common_Methods.switchToRight(driver, prop);
		try 
		{
			Assert.assertEquals(Common_Methods.getElementText_Xpath(prop.getEMenuLink_ELHP(), driver).equalsIgnoreCase(excel.getCellData("Menu", 6, 2)), true);
			Email_Sender.setResult(7, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(7, reportDate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Base_Class.sheetStatus = "Fail";
			Email_Sender.setResult(7, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(7, reportDate);
		}
	}
	
	@Test(dependsOnMethods = "Cxp_java.Sales.Filter_Event.filter_Event", priority = 2)
	public void create_Staf() throws InterruptedException 
	{
		Common_Methods.clickEleBy_Xpath(prop.getEStafLInk_ELHP(), driver);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.enterDataToTextField_Xpath(prop.getSup_Qty(), driver, excel.getCellData("Staffing", 0, 2));
		Common_Methods.selectFormDropdown_Op(prop.getSup_BeginT(), driver, excel.getCellData("Staffing", 1, 2));
		Common_Methods.selectFormDropdown_Op(prop.getSup_EndT(), driver, excel.getCellData("Staffing", 2, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getChef_Qty(), driver, excel.getCellData("Staffing", 0, 3));
		Common_Methods.selectFormDropdown_Op(prop.getChef_BeginT(), driver, excel.getCellData("Staffing", 1, 3));
		Common_Methods.selectFormDropdown_Op(prop.getChef_EndT(), driver, excel.getCellData("Staffing", 2, 3));
		Common_Methods.enterDataToTextField_Xpath(prop.getCap_Qty(), driver, excel.getCellData("Staffing", 0, 4));
		Common_Methods.selectFormDropdown_Op(prop.getCap_BeginT(), driver, excel.getCellData("Staffing", 1, 4));
		Common_Methods.selectFormDropdown_Op(prop.getCap_EndT(), driver, excel.getCellData("Staffing", 2, 4));
		Common_Methods.enterDataToTextField_Xpath(prop.getSer_Qty(), driver, excel.getCellData("Staffing", 0, 5));
		Common_Methods.selectFormDropdown_Op(prop.getSer_BeginT(), driver, excel.getCellData("Staffing", 1, 5));
		Common_Methods.selectFormDropdown_Op(prop.getSer_EndT(), driver, excel.getCellData("Staffing", 2, 5));
		Common_Methods.enterDataToTextField_Xpath(prop.getBar_Qty(), driver, excel.getCellData("Staffing", 0, 6));
		Common_Methods.selectFormDropdown_Op(prop.getBar_BeginT(), driver, excel.getCellData("Staffing", 1, 6));
		Common_Methods.selectFormDropdown_Op(prop.getBar_EndT(), driver, excel.getCellData("Staffing", 2, 6));
		Common_Methods.clickEleBy_Xpath(prop.getStaf_SaveB(), driver);
		Thread.sleep(3000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getStaf_FinalizeB(), driver);
		Thread.sleep(3000);
		String pWindow = Common_Methods.switchToWindow_C(driver);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Thread.sleep(3000);
		Common_Methods.clickEleBy_Xpath(prop.getUniformType_DdArrow(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getUniformTypeDd_V(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getSecurityList_RB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getRentalDelivery_DdArrow(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getRentalDelivery_DdValue(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getLoadingDock_RB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getBarOpenDD_RB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getSaveB(), driver);
		Common_Methods.switchToWindow_P(driver, pWindow);
		Common_Methods.naviToSales(driver, prop, wait);
		Thread.sleep(2000);
		Common_Methods.switchToRight(driver, prop);
		try 
		{
			Assert.assertEquals(Common_Methods.getElementText_Xpath(prop.getEStafLInk_ELHP(), driver).equalsIgnoreCase(excel.getCellData("Staffing", 3, 2)), true);
			Email_Sender.setResult(8, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(8, reportDate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Base_Class.sheetStatus = "Fail";
			Email_Sender.setResult(8, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(8, reportDate);
		}
	}
	
	@Test(dependsOnMethods = "Cxp_java.Sales.Filter_Event.filter_Event", priority = 3)
	public void create_Beverages() throws InterruptedException 
	{
		Common_Methods.clickEleBy_Xpath(prop.getEBeveragesL_ELHP(), driver);
		Thread.sleep(3000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getStaf_SaveB(), driver);
		String pWindow = Common_Methods.switchToWindow_C(driver);
		Thread.sleep(3000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getMappedItem_CB(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getCategoryInput(), driver, excel.getCellData("Beverages", 0, 2));
		Common_Methods.clickEleBy_Xpath(prop.getSaveB_EC(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getGlenfiddich_CB(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getGlenfiddich_Qty(), driver, excel.getCellData("Beverages", 1, 2));
		Common_Methods.clickEleBy_Xpath(prop.getBeve_SaveB(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getCategoryInput(), driver, excel.getCellData("Beverages", 0, 3));
		Common_Methods.clickEleBy_Xpath(prop.getSaveB_EC(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getIce_CB(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getIce_Qty(), driver, excel.getCellData("Beverages", 1, 3));
		Common_Methods.clickEleBy_Xpath(prop.getBeve_SaveB(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getCategoryInput(), driver, excel.getCellData("Beverages", 0, 4));
		Common_Methods.clickEleBy_Xpath(prop.getSaveB_EC(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getCoke_CB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getDietCoke_CB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getGingerAle_CB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getSprite_CB(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getCoke_TB(), driver, excel.getCellData("Beverages", 1, 4));
		Common_Methods.enterDataToTextField_Xpath(prop.getDietCoke_TB(), driver, excel.getCellData("Beverages", 1, 4));
		Common_Methods.enterDataToTextField_Xpath(prop.getGingerAle_TB(), driver, excel.getCellData("Beverages", 1, 4));
		Common_Methods.enterDataToTextField_Xpath(prop.getSprite_TB(), driver, excel.getCellData("Beverages", 1, 4));
		Common_Methods.clickEleBy_Xpath(prop.getBeve_SaveB(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getCategoryInput(), driver, excel.getCellData("Beverages", 0, 5));
		Common_Methods.clickEleBy_Xpath(prop.getSaveB_EC(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getBottleWater_CB(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getBottleWater_TB(), driver, excel.getCellData("Beverages", 1, 5));
		Common_Methods.clickEleBy_Xpath(prop.getBeve_SaveB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getStaf_FinalizeB(), driver);
		Common_Methods.switchToWindow_P(driver, pWindow);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Thread.sleep(3000);
		Common_Methods.enterDataToTextField_Xpath(prop.getIceCost_TB(), driver, excel.getCellData("Beverages", 2, 3));
		Common_Methods.enterDataToTextField_Xpath(prop.getIcePrice_TB(), driver, excel.getCellData("Beverages", 3, 3));
		Common_Methods.clickEleBy_Xpath(prop.getBeveFinalise_B(), driver);
		String windowP = Common_Methods.switchToWindow_C(driver);
		driver.manage().window().maximize();
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Thread.sleep(1000);
		Common_Methods.enterDataToTextField_Xpath(prop.getNofBars_TB(), driver, excel.getCellData("Beverages", 4, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getBarDuration_TB(), driver, excel.getCellData("Beverages", 5, 2));
		Common_Methods.clickEleBy_Xpath(prop.getBarCloDD_CB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getHouseWineWD_CB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getIceForBS_CB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getDeliveryVehicleDDA(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getDeliveryVehicleDDV(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getIceForWGs_CB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getSaveB(), driver);
		Common_Methods.switchToWindow_P(driver, windowP);
		Common_Methods.naviToSales(driver, prop, wait);
		Thread.sleep(2000);
		Common_Methods.switchToRight(driver, prop);
		try 
		{
			Assert.assertEquals(Common_Methods.getElementText_Xpath(prop.getEStafLInk_ELHP(), driver).equalsIgnoreCase(excel.getCellData("Beverages", 6, 2)), true);
			Email_Sender.setResult(9, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(9, reportDate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Base_Class.sheetStatus = "Fail";
			Email_Sender.setResult(9, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(9, reportDate);
		}
	}
	
	@Test(dependsOnMethods = "Cxp_java.Sales.Filter_Event.filter_Event", priority = 4)
	public void create_Hall() throws InterruptedException
	{
		Common_Methods.clickEleBy_Xpath(prop.getEHallLink_ELHP(), driver);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getStaf_SaveB(), driver);
		String windowP = Common_Methods.switchToWindow_C(driver);
		Thread.sleep(5000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getCoke_CB(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getChef_Qty(), driver, excel.getCellData("Halls_Equipment", 0, 2));
		Common_Methods.clickEleBy_Xpath(prop.getGril_CB(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getGril_TB(), driver, excel.getCellData("Halls_Equipment", 0, 2));
		Common_Methods.clickEleBy_Xpath(prop.getGrilKit_CB(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getGrilKit_TB(), driver, excel.getCellData("Halls_Equipment", 0, 2));
		Common_Methods.clickEleBy_Xpath(prop.getBeve_SaveB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getStaf_FinalizeB(), driver);
		Common_Methods.switchToWindow_P(driver, windowP);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Thread.sleep(3000);
		Common_Methods.clickEleBy_Xpath(prop.getBeveFinalise_B(), driver);
		Thread.sleep(3000);
		String windowP1 = Common_Methods.switchToWindow_C(driver);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getCloseB_ED(), driver);
		Common_Methods.switchToWindow_P(driver, windowP1);
		Thread.sleep(3000);
		Common_Methods.naviToSales(driver, prop, wait);
		Thread.sleep(2000);
		Common_Methods.switchToRight(driver, prop);
		try 
		{
			Assert.assertEquals(Common_Methods.getElementText_Xpath(prop.getEHallLink_ELHP(), driver).equalsIgnoreCase(excel.getCellData("Halls_Equipment", 1, 2)), true);
			Email_Sender.setResult(10, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(10, reportDate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Base_Class.sheetStatus = "Fail";
			Email_Sender.setResult(10, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(10, reportDate);
		}
		}
	@Test(dependsOnMethods = "Cxp_java.Sales.Filter_Event.filter_Event", priority = 5)
	public void create_Linen () throws InterruptedException
	{
		Common_Methods.clickEleBy_Xpath(prop.getELinLink_ELHP(), driver);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getStaf_SaveB(), driver);
		String windowP = Common_Methods.switchToWindow_C(driver);
		Thread.sleep(3000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getVendorSLinen_CB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getRoundTable_CB(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getTableQty(), driver, excel.getCellData("linen", 0, 2));
		Common_Methods.clickEleBy_Xpath(prop.getBeve_SaveB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getStaf_FinalizeB(), driver);
		Thread.sleep(2000);
		Common_Methods.switchToWindow_P(driver, windowP);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getLinenFinalizeB(), driver);
		Thread.sleep(3000);
		String windowP1 = Common_Methods.switchToWindow_C(driver);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getCloseB_ED(), driver);
		Common_Methods.switchToWindow_P(driver, windowP1);
		Thread.sleep(3000);
		Common_Methods.naviToSales(driver, prop, wait);
		Thread.sleep(2000);
		Common_Methods.switchToRight(driver, prop);
		try 
		{
			Assert.assertEquals(Common_Methods.getElementText_Xpath(prop.getELinLink_ELHP(), driver).equalsIgnoreCase(excel.getCellData("linen", 1, 2)), true);
			Email_Sender.setResult(11, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(11, reportDate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Base_Class.sheetStatus = "Fail";
			Email_Sender.setResult(11, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(11, reportDate);
		}
	}
	
	@Test(dependsOnMethods = "Cxp_java.Sales.Filter_Event.filter_Event", priority = 6)
	public void create_Eqip () throws InterruptedException
	{
		Common_Methods.clickEleBy_Xpath(prop.getEEqipLink_ELHP(), driver);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getStaf_SaveB(), driver);
		String windowP = Common_Methods.switchToWindow_C(driver);
		Thread.sleep(3000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getKitchenEqui_CB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getCoffWaterCup_CB(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getSup_Qty(), driver, excel.getCellData("Equipments", 0, 2));
		Common_Methods.clickEleBy_Xpath(prop.getInductionBurner_CB(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getIBQty(), driver, excel.getCellData("Equipments", 0, 3));
		Common_Methods.clickEleBy_Xpath(prop.getInductionPan_CB(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getIBPQty(), driver, excel.getCellData("Equipments", 0, 4));
		Common_Methods.clickEleBy_Xpath(prop.getBeve_SaveB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getStaf_FinalizeB(), driver);
		Thread.sleep(2000);
		Common_Methods.switchToWindow_P(driver, windowP);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getBeveFinalise_B(), driver);
		Thread.sleep(3000);
		String windowP1 = Common_Methods.switchToWindow_C(driver);
		driver.manage().window().maximize();
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getUniformType_DdArrow(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getDeliveryVehicleDDV(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getLinenDeliveryDDA(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getLinenDeliveryDDV(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getPlasticFloor_RB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getIceForWGs_CB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getRemoveTrash_RB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getHouseWineWD_CB(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getNOCMR_TB(), driver, excel.getCellData("Equipments", 2, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getDepartTime_TB(), driver, excel.getCellData("Equipments", 3, 2));
		Common_Methods.clickEleBy_Xpath(prop.getSaveB(), driver);
		Common_Methods.switchToWindow_P(driver, windowP1);
		Thread.sleep(3000);
		Common_Methods.naviToSales(driver, prop, wait);
		Thread.sleep(2000);
		Common_Methods.switchToRight(driver, prop);
		try 
		{
			Assert.assertEquals(Common_Methods.getElementText_Xpath(prop.getEEqipLink_ELHP(), driver).equalsIgnoreCase(excel.getCellData("Equipments", 1, 2)), true);
			Email_Sender.setResult(12, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(12, reportDate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Base_Class.sheetStatus = "Fail";
			Email_Sender.setResult(12, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(12, reportDate);
		}
	}
	
	@Test(dependsOnMethods = "Cxp_java.Sales.Filter_Event.filter_Event", priority = 7)
	public void create_Concierge() throws InterruptedException 
	{
		Common_Methods.clickEleBy_Xpath(prop.getEConciergeL_ELHP(), driver);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getStaf_SaveB(), driver);
		String windowP = Common_Methods.switchToWindow_C(driver);
		Thread.sleep(3000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getCoke_CB(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getGourmetBarista_TB(), driver, excel.getCellData("Concierge", 0, 2));
		Common_Methods.clickEleBy_Xpath(prop.getBeve_SaveB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getConciergeClose_B(), driver);
		Thread.sleep(2000);
		Common_Methods.switchToWindow_P(driver, windowP);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getBeveFinalise_B(), driver);
		Thread.sleep(3000);
		Common_Methods.naviToSales(driver, prop, wait);
		Thread.sleep(2000);
		Common_Methods.switchToRight(driver, prop);
		try 
		{
			Assert.assertEquals(Common_Methods.getElementText_Xpath(prop.getEConciergeL_ELHP(), driver).equalsIgnoreCase(excel.getCellData("Concierge", 1, 2)), true);
			Email_Sender.setResult(13, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(13, reportDate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Base_Class.sheetStatus = "Fail";
			Email_Sender.setResult(13, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(13, reportDate);
		}
	}
	
	@Test(dependsOnMethods = "Cxp_java.Sales.Filter_Event.filter_Event", priority = 8)
	public void create_Disposables() throws InterruptedException
	{
		Common_Methods.clickEleBy_Xpath(prop.getEDisposablesL_ELHP(), driver);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getStaf_SaveB(), driver);
		String windowP = Common_Methods.switchToWindow_C(driver);
		Thread.sleep(3000);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getVendorSLinen_CB(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getPersonnelQty5(), driver, excel.getCellData("Disposables", 0, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getHazelnut_P(), driver, excel.getCellData("Disposables", 1, 2));
		Common_Methods.clickEleBy_Xpath(prop.getInductionPan_CB(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getIBPQty(), driver, excel.getCellData("Disposables", 0, 3));
		Common_Methods.enterDataToTextField_Xpath(prop.getCFilters_P(), driver, excel.getCellData("Disposables", 1, 3));
		Common_Methods.clickEleBy_Xpath(prop.getBeve_SaveB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getStaf_FinalizeB(), driver);
		Thread.sleep(2000);
		Common_Methods.switchToWindow_P(driver, windowP);
		Common_Methods.switchToDefault(driver);
		Common_Methods.switchToRight(driver, prop);
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getBeveFinalise_B(), driver);
		Thread.sleep(3000);
		Common_Methods.naviToSales(driver, prop, wait);
		Thread.sleep(2000);
		Common_Methods.switchToRight(driver, prop);
		try 
		{
			Assert.assertEquals(Common_Methods.getElementText_Xpath(prop.getEDisposablesL_ELHP(), driver).equalsIgnoreCase(excel.getCellData("Disposables", 2, 2)), true);
			Email_Sender.setResult(14, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(14, reportDate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			Base_Class.sheetStatus = "Fail";
			Email_Sender.setResult(14, Base_Class.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			Email_Sender.setDateTime(14, reportDate);
		}
	}
}
