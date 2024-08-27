package ManageVisits;

import java.awt.Robot;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginPage.BaseClass;
import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class CancelAVisit {
	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	//String path = "src/test/resources/TestData/TestData.xlsx";
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
	public void cancelAVisit()
	{
		Common_Methods.clickEleBy_Xpath(prop.getCancelVisitsButton(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.clickEleBy_Xpath(prop.getSuccessOkBtn(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.clickEleBy_Xpath(prop.getCancelCodeDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getCancelCodeDdUlInSM(), driver, excel.getCellData("CancelAVisit", 0, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getCancelCodeComments(), driver, excel.getCellData("CancelAVisit", 1, 2));
		Common_Methods.clickEleBy_Xpath(prop.getProceedButton(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.clickEleBy_Xpath(prop.getSuccessOkBtn(), driver);
	}
	
}
