package XpertKitchen.Events;

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

public class SearchAdd_Menu 
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
	public void Menu_Before() throws IOException
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
	
	@Test(dependsOnMethods = "XpertKitchen.Events.Filter_Event.e_Filter", priority = 1, groups = "Menu")
	public void searchAndAdd_Menu() throws InterruptedException
	{
		Common_Methods.waitForElement_Xpath(prop.getNewButton(), wait, "elementToBeClickable");
		
		int retries = 5;
		while (retries > 0)
		{
			try {
					System.out.println("Into the while block of iteration: " + retries);
					Common_Methods.clickEleBy_Xpath(prop.getNewButton(), driver);
					break;
				} 
			catch (Exception e) 
				{
					System.out.println("Exception Occurred at the iteration: " + retries);
					Thread.sleep(5000);
					retries--;
				}
		}
		
		Common_Methods.clickEleBy_Xpath(prop.getSearchAndAddB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getMenuCategoryDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getMenuCategoryDdUl(), driver, excel.getCellData("SearchAdd_Menu", 0, 2));
		Common_Methods.clickEleBy_Xpath(prop.getMenuSubcategoryDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getMenuSubcategoryDdUl(), driver, excel.getCellData("SearchAdd_Menu", 1, 2));
		Common_Methods.clickEleBy_Xpath(prop.getTemperatureDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getTemperatureDdUl(), driver, excel.getCellData("SearchAdd_Menu", 3, 2));
		Common_Methods.clickEleBy_Xpath(prop.getSearchB_OnSAndAdd(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getMenuCheckB1(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getMenuCheckB2(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.get1ItemQty_SandAMenu(), driver, excel.getCellData("Create_Event", 7, 3));
		Common_Methods.enterDataToTextField_Xpath(prop.get2ItemQty_SandAMenu(), driver, excel.getCellData("Create_Event", 7, 3));
		Common_Methods.clickEleBy_Xpath(prop.getSaveB_OnSAndAdd(), driver);
		Common_Methods.waitForElement_Xpath(prop.getAssertText(), wait, "visibilityOfElementLocated");
		Assert.assertEquals(Common_Methods.getElementText_Xpath(prop.getAssertText(), driver), excel.getCellData("SearchAdd_Menu", 4, 2));
		Common_Methods.clickEleBy_Xpath(prop.getOkButton(), driver);
		
	}
	
	@Test(dependsOnMethods = "XpertKitchen.Events.Filter_Event.e_Filter", priority = 2, groups = "Menu")
	public void add_Menu() throws InterruptedException
	{
		Common_Methods.waitForElement_Xpath(prop.getAddB(), wait, "elementToBeClickable");
		Common_Methods.clickEleBy_Xpath(prop.getAddB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getCourseDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getCourseDdUl(), driver, excel.getCellData("Add_Menu", 0, 2));
		Common_Methods.clickEleBy_Xpath(prop.getCategoryDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getCategoryDdUl(), driver, excel.getCellData("Add_Menu", 1, 2));
		Common_Methods.clickEleBy_Xpath(prop.getSubcategoryDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getSubcategoryDdUl(), driver, excel.getCellData("Add_Menu", 2, 2));
		Common_Methods.clickEleBy_Xpath(prop.getMenuItemDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getMenuItemDdUl(), driver, excel.getCellData("Add_Menu", 3, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getItemQty_AddMenu(), driver, excel.getCellData("Create_Event", 7, 3));
		Common_Methods.enterDataToTextField_Xpath(prop.getItemCost_AddMenu(), driver, excel.getCellData("Add_Menu", 6, 2));
		Common_Methods.clickEleBy_Xpath(prop.getSaveB_OnAdd(), driver);
		Common_Methods.waitForElement_Xpath(prop.getAssertText(), wait, "visibilityOfElementLocated");
		Assert.assertEquals(Common_Methods.getElementText_Xpath(prop.getAssertText(), driver), excel.getCellData("Add_Menu", 4, 2));
		Common_Methods.clickEleBy_Xpath(prop.getOkButton(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getCloseB_OnAddMenu(), driver);
		
	}
	@Test(dependsOnMethods = "XpertKitchen.Events.Filter_Event.e_Filter", priority = 3, groups = "Menu")
	public void add_NonStandradItem() throws InterruptedException{
		Common_Methods.waitForElement_Xpath(prop.getAddButton(), wait, "elementToBeClickable");
		Common_Methods.clickEleBy_Xpath(prop.getAddButton(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getCourseDdArrow1(), driver);
		Common_Methods.selectFormDropdown(prop.getCourseDdUl1(), driver, excel.getCellData("Add_NonStandard", 0, 2));
		Common_Methods.clickEleBy_Xpath(prop.getCategoryDdArrow1(), driver);
        Common_Methods.selectFormDropdown(prop.getCategoryDdUl1(), driver, excel.getCellData("Add_NonStandard", 1, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getNewMenuItem(), driver, excel.getCellData("Add_NonStandard", 2, 2));
		
		Thread.sleep(2000);
		Common_Methods.clickEleBy_Xpath(prop.getSaveB_OnAdd1(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getOkButton(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getCloseB_OnAddMenu(), driver);
		Thread.sleep(2000);
	//	Common_Methods.clickEleBy_Xpath(prop.getCloseButton(), driver);


	}
}    
