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

import XpertKitchen.LoginPage.Base_Class;
import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class Purchase {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	ReadPropFile prop;
	Actions myActions;
	ExcelRead excel;
	Robot robot;
	String path; 
	
	@BeforeTest
	public void Purchase_Before() throws IOException
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
	@Test
  public void PurchaseQuery() throws InterruptedException {
	    Common_Methods.clickEleBy_Xpath(prop.getMenu1(), driver);
	    Common_Methods.clickEleBy_Xpath(prop.getKitchen(), driver);
	    Thread.sleep(2000);
	    Common_Methods.clickEleBy_Xpath(prop.getPurchase(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getEvent(), driver, excel.getCellData("Purchase", 0, 2));
	    Common_Methods.clickEleBy_Xpath(prop.getClickEdited(), driver);
        Common_Methods.selectFormDropdown(prop.getClickEditedUl(), driver, excel.getCellData("Purchase", 1, 2));
	    Common_Methods.clickEleBy_Xpath(prop.getClickDone(), driver);
        Common_Methods.selectFormDropdown(prop.getClickDoneUl(), driver, excel.getCellData("Purchase", 2, 2));
        Common_Methods.clickEleBy_Xpath(prop.getClickBusinessUnits(), driver);
        Common_Methods.selectFormDropdown(prop.getClickSelectBusinessUnit(), driver, excel.getCellData("Purchase", 3, 2));
        Common_Methods.clickEleBy_Xpath(prop.getpurchaseTypeId(), driver);
        Common_Methods.selectFormDropdown(prop.getSelectpurchaseTypeId(), driver, excel.getCellData("Purchase", 4, 2));
        Common_Methods.clickEleBy_Xpath(prop.getClickPurchased(), driver);
        Common_Methods.selectFormDropdown(prop.getSelectPurchasedUl(), driver, excel.getCellData("Purchase", 5, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getPrepName(), driver, excel.getCellData("Purchase", 6, 2));
        Common_Methods.clickEleBy_Xpath(prop.getClickEventBegin(), driver);
        Common_Methods.selectMonthAndYearInDate(excel.getCellData("Purchase", 7, 2), excel.getCellData("Purchase", 8, 2), prop.getmonthTable(), driver, prop);
		Common_Methods.selectDayInDate(excel.getCellData("Purchase", 9, 2), prop.getdayTable(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getClickEventEnd(), driver);
	    Common_Methods.selectMonthAndYearInDate(excel.getCellData("Purchase", 10, 2), excel.getCellData("Purchase", 11, 2), prop.getmonthTable(), driver, prop);
		Common_Methods.selectDayInDate(excel.getCellData("Purchase", 12, 2), prop.getdayTable(), driver);
	        
		Common_Methods.clickEleBy_Xpath(prop.getMakeBegin(), driver);
	    Common_Methods.selectMonthAndYearInDate(excel.getCellData("Purchase", 13, 2), excel.getCellData("Purchase", 14, 2), prop.getmonthTable(), driver, prop);
	    Common_Methods.selectDayInDate(excel.getCellData("Purchase", 15, 2), prop.getdayTable(), driver);
	    Common_Methods.clickEleBy_Xpath(prop.getMakeEnd(), driver);
	    Common_Methods.selectMonthAndYearInDate(excel.getCellData("Purchase", 16, 2), excel.getCellData("Purchase", 17, 2), prop.getmonthTable(), driver, prop);
		Common_Methods.selectDayInDate(excel.getCellData("Purchase", 18, 2), prop.getdayTable(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getPurchaseGrp(), driver);
	    Common_Methods.selectFormDropdown(prop.getPurchaseGrpUl(), driver, excel.getCellData("Purchase", 19, 2));
	    Common_Methods.clickEleBy_Xpath(prop.getClickChanged(), driver);
	    Common_Methods.selectFormDropdown(prop.getClickChangedDbUrl(), driver, excel.getCellData("Purchase", 20, 2));
	    Common_Methods.clickEleBy_Xpath(prop.getClickDeleted(), driver);
	    Common_Methods.selectFormDropdown(prop.getClickDeletedDbUl(), driver, excel.getCellData("Purchase", 21, 2));
	    Common_Methods.clickEleBy_Xpath(prop.getClickGoButton(), driver);
	   // Common_Methods.clickEleBy_Xpath(prop.getOKBU4(), driver);
  }
  
  
}
