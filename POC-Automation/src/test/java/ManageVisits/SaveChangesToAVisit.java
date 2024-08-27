package ManageVisits;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginPage.BaseClass;
import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class SaveChangesToAVisit {
	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	
	@BeforeTest
	public void driversForManageVisitsFilter() throws IOException {
		driver = BaseClass.getDriver();
		path = BaseClass.getTestDataPath();
		wait = BaseClass.getWebDriverWait();
		myActions = BaseClass.getDriverActions();
		robot = BaseClass.getRobot();
		prop = new ReadPropFile();
		excel = new ExcelRead(path);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test
	public void SaveChanges()
	{
		Common_Methods.clickEleBy_Xpath(prop.getVisitTypeDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getVisitTypeDdUl(), driver, excel.getCellData("SaveChangesToVisit", 0, 2));
		Common_Methods.clickEleBy_Xpath(prop.getVisitStatusDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getVisitStatusDdUl(), driver, excel.getCellData("SaveChangesToVisit", 1, 2));
		Common_Methods.clickEleBy_Xpath(prop.getRateTypeInMVDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getRateTypeInMVDdUl(), driver, excel.getCellData("SaveChangesToVisit", 2, 2));
		String [] s =(excel.getCellData("SaveChangesToVisit", 3, 2)).split(" ");
		String str = s[0]+"."+s[1];
		Common_Methods.enterDataToTextField_Xpath(prop.getActOverriddenInput(), driver, str);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getSaveButton())));
		//Common_Methods.clickEleBy_Xpath(prop.getSaveButton(), driver);
		robot.mouseMove(900, 700);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
	}
}
