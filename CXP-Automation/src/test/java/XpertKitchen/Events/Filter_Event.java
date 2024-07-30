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

public class Filter_Event {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	ReadPropFile prop;
	Actions myActions;
	ExcelRead excel;
	Robot robot;
	String path; 
	static String event_Id; 
	int retries = 5;
	@BeforeTest
	public void FilterEvent_Before() throws IOException {
		
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

	@Test(dependsOnMethods = "XpertKitchen.Events.Create_Event.eventCreation")
	public void e_Filter() throws InterruptedException
	{
		Common_Methods.waitForElement_Xpath(prop.getFilterIcon(), wait, "elementToBeClickable");
		
		while (retries > 0)
		{
			try {
					System.out.println("Into the while block of iteration: " + retries);
					Common_Methods.clickEleBy_Xpath(prop.getFilterIcon(), driver);
					break;
				} 
			catch (Exception e) 
				{
					System.out.println("Exception Occurred at the iteration: " + retries);
					Thread.sleep(5000);
					retries--;
				}
		}
		
		Common_Methods.enterDataToTextField_Xpath(prop.getEventId(), driver, event_Id);
		Common_Methods.clickEleBy_Xpath(prop.getApplyButton(), driver);
		
	}
	
	
}
