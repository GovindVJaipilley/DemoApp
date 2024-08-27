package PS;

import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginPage.BaseClass;
import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class AddCarePlanFromHomeScreen {
	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	
	//String path = "C:\\POC-Automation\\TestData.xlsx";
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	//String flyoutMenuClick, flyoutCreateDCSClick, dcsListingClick, SalutationDdArrowClick, SalutationDdUL, LoadingSpinner;
	
	@BeforeTest
	public void allProps() throws Exception 
	{
		driver = BaseClass.getDriver();
		path = BaseClass.getTestDataPath();
		wait = BaseClass.getWebDriverWait();
		myActions = BaseClass.getDriverActions();
		robot = BaseClass.getRobot();
		prop = new ReadPropFile();
		excel = new ExcelRead(path);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	@Test(dependsOnMethods = "LoginPage.LoginTest.loginLite")
	public void navigateToCarePlanList() throws InterruptedException
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.filterPs(excel.getCellData("HomeFilter", 1, 3), excel.getCellData("HomeFilter", 2, 3), prop, driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getPSPlusIcon())));
		Thread.sleep(1000);
		Common_Methods.clickEleBy_Xpath(prop.getPSPlusIcon(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.clickEleBy_Xpath(prop.getPSPlusIconSiteLevel(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.clickEleBy_Xpath(prop.getPayorPlanlevelHambergermenu(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getActiveServiceOption(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		int retries = 5;
		while (retries > 0) {
			try {
				System.out.println("Into the while block of iteration: " + retries);
		Common_Methods.clickEleBy_Xpath(prop.getServiceLevelHambergermenu(), driver);
		break;
			} catch (Exception e) {
				System.out.println("Exception Occurred at the iteration: " + retries);
				//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getDcsPhone3DdArrow())));
				Thread.sleep(5000);
				retries--;
			}
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		
		while (retries > 0) {
			try {
				System.out.println("Into the while block of iteration: " + retries);
		Common_Methods.clickEleBy_Xpath(prop.getManageCarePlan(), driver);
		break;
			} catch (Exception e) {
				System.out.println("Exception Occurred at the iteration: " + retries);
				//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getDcsPhone3DdArrow())));
				Thread.sleep(5000);
				retries--;
			}
		}
	}
	@Test(dependsOnMethods = "navigateToCarePlanList")
	public void addCarePlan() throws InterruptedException
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		int retries = 5;
		while (retries > 0) {
			try {
				System.out.println("Into the while block of iteration: " + retries);
		Common_Methods.clickEleBy_Xpath(prop.getCategoryDdArrow(), driver);
		break;
			} catch (Exception e) {
				System.out.println("Exception Occurred at the iteration: " + retries);
				//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getDcsPhone3DdArrow())));
				Thread.sleep(5000);
				retries--;
			}
		}
		Common_Methods.selectFormDropdown(prop.getCategoryDdUl(), driver, excel.getCellData("AddCarePlanList", 0, 3));
		Common_Methods.clickEleBy_Xpath(prop.getEffectiveFromACareP(), driver);
		Common_Methods.selectMonthAndYearInDate(excel.getCellData("AddCarePlanList", 2, 3), excel.getCellData("AddCarePlanList", 1, 3), prop.getmonthTable(), driver, prop);
		Common_Methods.selectDayInDate(excel.getCellData("AddCarePlanList", 3, 3), prop.getdayTable(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getAddTasksBACareP(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Common_Methods.selectTaskForCarePlan(driver, prop, excel);
		Common_Methods.clickEleBy_Xpath(prop.getAddButtonOnTaskList(), driver);
		Common_Methods.enterDaysPerWeekInAddTask(driver, prop, excel);
		
		while (retries > 0) {
			try {
				System.out.println("Into the while block of iteration: " + retries);
		Common_Methods.clickEleBy_Xpath(prop.getCreateButtonOnTaskPlanList(), driver);
		break;
			} catch (Exception e) {
				System.out.println("Exception Occurred at the iteration: " + retries);
				//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getDcsPhone3DdArrow())));
				Thread.sleep(5000);
				retries--;
			}
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		Assert.assertEquals(driver.findElement(By.xpath(prop.getDcsOkText())).getText(), excel.getCellData("AddCarePlanList", 6, 3));
		Common_Methods.clickEleBy_Xpath(prop.getDcsOkButton(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getCancelButtonOnTaskPlanList(), driver);
	}
}
