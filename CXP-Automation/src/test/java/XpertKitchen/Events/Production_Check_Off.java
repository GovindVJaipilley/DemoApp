package XpertKitchen.Events;

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

public class Production_Check_Off {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	ReadPropFile prop;
	Actions myActions;
	ExcelRead excel;
	Robot robot;
	String path; 
	 
	@BeforeTest
	public void Production_Check_Off_Before() throws IOException
	{
		
		driver = Base_Class.getDriver();
		path = Base_Class.getTestDataPath();
		wait = Base_Class.getWebDriverWait();
		myActions = new Actions(driver);
		prop = new ReadPropFile();
		excel = new ExcelRead(path);
		js = Base_Class.getJSExecutor();
		robot = Base_Class.getRobot();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Base_Class.sheetStatus = "Pass";
	}
  @Test()
  public void Production_Check_Off_Test() throws InterruptedException {
	  Thread.sleep(3000);
	  Common_Methods.clickEleBy_Xpath(prop.getMenu1(), driver);
	 //   Common_Methods.clickEleBy_Xpath(prop.getKitchen(), driver);
	    Thread.sleep(2000);
	    Common_Methods.clickEleBy_Xpath(prop.getproductioncheckoff(), driver);
	  
	    Common_Methods.enterDataToTextField_Xpath(prop.getEvent(), driver, Filter_Event.event_Id);
	    Common_Methods.clickEleBy_Xpath(prop.getClickEdited(), driver);
        Common_Methods.selectFormDropdown(prop.getClickEditedUl(), driver, excel.getCellData("ProductionCheckOff", 2, 2));
	    Common_Methods.clickEleBy_Xpath(prop.getClickDone(), driver);
        Common_Methods.selectFormDropdown(prop.getClickDoneUl(), driver, excel.getCellData("ProductionCheckOff", 1, 2));
        Common_Methods.clickEleBy_Xpath(prop.getClickBusinessUnits(), driver);
        Common_Methods.selectFormDropdown(prop.getClickSelectBusinessUnit(), driver, excel.getCellData("ProductionCheckOff", 3, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getPrepName(), driver, excel.getCellData("ProductionCheckOff", 4, 2));
		  Common_Methods.clickEleBy_Xpath(prop.getprepTypyIds(), driver);
	        Common_Methods.selectFormDropdown(prop.getprepTypeIdsUl(), driver, excel.getCellData("ProductionCheckOff", 5, 2));
			  Common_Methods.clickEleBy_Xpath(prop.getLocationDB(), driver);
		        Common_Methods.selectFormDropdown(prop.getLocationDbUl(), driver, excel.getCellData("ProductionCheckOff", 6, 2));

		//
		  Common_Methods.clickEleBy_Xpath(prop.getClickEventBegin(), driver);
	        Common_Methods.selectMonthAndYearInDate(excel.getCellData("ProductionCheckOff", 7, 2), excel.getCellData("ProductionCheckOff", 8, 2), prop.getmonthTable(), driver, prop);
			Common_Methods.selectDayInDate(excel.getCellData("ProductionCheckOff", 9, 2), prop.getdayTable(), driver);
			Common_Methods.clickEleBy_Xpath(prop.getClickEventEnd(), driver);
		    Common_Methods.selectMonthAndYearInDate(excel.getCellData("ProductionCheckOff", 10, 2), excel.getCellData("ProductionCheckOff", 11, 2), prop.getmonthTable(), driver, prop);
			Common_Methods.selectDayInDate(excel.getCellData("ProductionCheckOff", 12, 2), prop.getdayTable(), driver);
		        
			Common_Methods.clickEleBy_Xpath(prop.getMakeBegin(), driver);
		    Common_Methods.selectMonthAndYearInDate(excel.getCellData("ProductionCheckOff", 13, 2), excel.getCellData("ProductionCheckOff", 14, 2), prop.getmonthTable(), driver, prop);
		    Common_Methods.selectDayInDate(excel.getCellData("ProductionCheckOff", 15, 2), prop.getdayTable(), driver);
		    Common_Methods.clickEleBy_Xpath(prop.getMakeEnd(), driver);
		    Common_Methods.selectMonthAndYearInDate(excel.getCellData("ProductionCheckOff", 16, 2), excel.getCellData("ProductionCheckOff", 17, 2), prop.getmonthTable(), driver, prop);
			Common_Methods.selectDayInDate(excel.getCellData("ProductionCheckOff", 18, 2), prop.getdayTable(), driver);
			Common_Methods.clickEleBy_Xpath(prop.getClickChanged(), driver);
		   Common_Methods.selectFormDropdown(prop.getClickChangedDbUrl(), driver, excel.getCellData("ProductionCheckOff", 19, 2));
		  Common_Methods.clickEleBy_Xpath(prop.getClickDeleted(), driver);
	      Common_Methods.selectFormDropdown(prop.getClickDeletedDbUl(), driver, excel.getCellData("ProductionCheckOff", 20, 2));
		 Common_Methods.clickEleBy_Xpath(prop.getClickGoButton(), driver);
	   //  Common_Methods.clickEleBy_Xpath(prop.getOKBU4(), driver);
	     Thread.sleep(2000);
	     Common_Methods.clickEleBy_Xpath(prop.getClickRest(), driver);
  }
  
}
