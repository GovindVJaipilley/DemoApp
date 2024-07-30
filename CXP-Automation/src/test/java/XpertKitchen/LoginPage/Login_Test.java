package XpertKitchen.LoginPage;

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

import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

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
		public void login_Before() throws IOException {
			
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
		public void navigateToUrl()
		{
			driver.get(excel.getCellData("Credentials", 1, 2));
		}
		@Test(dependsOnMethods = "navigateToUrl")
		 public void Login()
		{
			Common_Methods.waitForElement_Xpath(prop.getCaterId(), wait, "visibilityOfElementLocated");
			Common_Methods.enterDataToTextField_Xpath(prop.getCaterId(), driver, excel.getCellData("Credentials", 2, 2));
			Common_Methods.enterDataToTextField_Xpath(prop.getUserId(), driver, excel.getCellData("Credentials", 3, 2));
			Common_Methods.enterDataToTextField_Xpath(prop.getPassword(), driver, excel.getCellData("Credentials", 4, 2));
			Common_Methods.clickEleBy_Xpath(prop.getLogin(), driver);
			Assert.assertEquals(Common_Methods.getElementText_Xpath(prop.getHeader(), driver), excel.getCellData("Credentials", 5, 2));
		}
		   
		
		
		
}
