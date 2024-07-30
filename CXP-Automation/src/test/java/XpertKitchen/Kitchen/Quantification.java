
package XpertKitchen.Kitchen;


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

public class Quantification {
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
	@Test
  public void QuantificationTest() {
		Common_Methods.clickEleBy_Xpath(prop.getQuantifiedStatusNo(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getClickQuantifyAll(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getOkButton2(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getClickGatherAll(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getOkButton2(), driver);

  }
}
