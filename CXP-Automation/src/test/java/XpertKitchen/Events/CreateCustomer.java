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

public class CreateCustomer {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	ReadPropFile prop;
	Actions myActions;
	ExcelRead excel;
	Robot robot;
	String path; 
	
 
	@BeforeTest
	public void CreateCustomer_Before() throws IOException 
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
 
  
  public void New_Customer() throws InterruptedException {
		Common_Methods.waitForElement_Xpath(prop.getMenu1(), wait, "elementToBeClickable");
		Common_Methods.clickEleBy_Xpath(prop.getMenu1(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getSales1Click(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getCustomerList(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getNewCustomer(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getCustomerTypes(), driver);
		Common_Methods.enterDataToTextField_Xpath(prop.getCustomerName(), driver, excel.getCellData("CreateCustomer", 1, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getFirstName(), driver, excel.getCellData("CreateCustomer", 2, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getEnterStreet(), driver, excel.getCellData("CreateCustomer", 3, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getEnterCity(), driver, excel.getCellData("CreateCustomer", 4, 2));
		Common_Methods.clickEleBy_Xpath(prop.getStateId(), driver);

		Common_Methods.selectFormDropdown(prop.getSelectState(), driver, excel.getCellData("CreateCustomer", 5, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getZipCode(), driver, excel.getCellData("CreateCustomer", 6, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getHomePhone(), driver, excel.getCellData("CreateCustomer", 7, 2));
		Common_Methods.clickEleBy_Xpath(prop.getCheckBox(), driver);
		Thread.sleep(3000);
		Common_Methods.clickEleBy_Xpath(prop.getReferalTypes(), driver);
	
		Common_Methods.clickEleBy_Xpath(prop.getReferalTypes(), driver);
		Common_Methods.selectFormDropdown(prop.getSelectType(), driver, excel.getCellData("CreateCustomer", 8, 2));
		Common_Methods.clickEleBy_Xpath(prop.getSelectBu1(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getClickButton(), driver);


		
  }
}
