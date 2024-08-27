package ManageVisits;

import java.awt.Robot;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginPage.BaseClass;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class NavigateToManageVisits {

	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	//String path = "C:\\POC-Automation\\TestData.xlsx";
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	String menuXpath;
	String schedMenu;
	String manageVisitsMenu;
	String loadingSpinner;
	String manageVisitsHeader;

	@BeforeTest
	public void driversForSchedMgmt() throws IOException {
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
	public void navigateToSchedMgmt() throws InterruptedException {
		menuXpath = prop.getMenuOption();
		schedMenu = prop.getSchedMenu();
		manageVisitsMenu = prop.getManageVisitsMenu();
		loadingSpinner = prop.getLoadingSpinner();
		manageVisitsHeader = prop.getManageVisitsHeader();
		
	
		WebElement menuXpathEle = driver.findElement(By.xpath(menuXpath));
		wait.until(ExpectedConditions.elementToBeClickable(menuXpathEle));
		int retries = 5;
		while (retries > 0) {
			try {
				System.out.println("Into the while block of iteration: " + retries);
		menuXpathEle.click();
		WebElement schedMenuEle = driver.findElement(By.xpath(schedMenu));
		wait.until(ExpectedConditions.visibilityOf(schedMenuEle));
		schedMenuEle.click();
		break;
			} catch (Exception e) {
				System.out.println("Exception Occurred at the iteration: " + retries);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menuXpath)));
				Thread.sleep(5000);
				retries--;
			}
		}
		
		
		
		WebElement manageVisitsMenuEle = driver.findElement(By.xpath(manageVisitsMenu));
		wait.until(ExpectedConditions.visibilityOf(manageVisitsMenuEle));
		manageVisitsMenuEle.click();
		
		//WebElement loadingSpinnerEle = driver.findElement(By.xpath(loadingSpinner));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(loadingSpinner)));
		
		WebElement manageVisitsHeaderEle = driver.findElement(By.xpath(manageVisitsHeader));
		wait.until(ExpectedConditions.visibilityOf(manageVisitsHeaderEle));
		
		if(manageVisitsHeaderEle.isDisplayed()) {
			System.out.println("Successfully navigated to Manage Visits screen");
		} else {
			System.out.println("It seems manage visits screen navigation failed");
		}
	}
}
