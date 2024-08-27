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
import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class NavigateToScheduleManagement {
	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	String schedMgtRadioButton, siteFilter, siteSearch, siteSelect, searchButton;
	String addVisitBtn;
	String loadingSpinner;
	String addVisitPopUpHeader;
	
	@BeforeTest
	public void driversForAddVisitSchedMgmt() throws IOException {
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
	public void navigateToSM() throws InterruptedException
	{
		schedMgtRadioButton = prop.getSchedMgtRadioButton();
		siteFilter = prop.getSiteFilterInManageVisits();
		siteSearch = prop.getSiteSearchInManageVisits();
		siteSelect = prop.getSiteSelectInManageVisits();
		searchButton = prop.getSearchButton();
		addVisitBtn = prop.getAddVisitInSchedMgmt();
		loadingSpinner = prop.getLoadingSpinner();
		addVisitPopUpHeader = prop.getAddVisitPopUpHeader();

		WebElement schedMgtRadioButtonEle = driver.findElement(By.xpath(schedMgtRadioButton));
		schedMgtRadioButtonEle.click();

		WebElement siteFilterEle = driver.findElement(By.xpath(siteFilter));
		siteFilterEle.click();

		WebElement siteSearchEle = driver.findElement(By.xpath(siteSearch));
		wait.until(ExpectedConditions.visibilityOf(siteSearchEle));
		siteSearchEle.sendKeys(excel.getCellData("Add_Visit_SC", 1, 2));

		WebElement siteSelectEle = driver.findElement(By.xpath(siteSelect));
		wait.until(ExpectedConditions.visibilityOf(siteSelectEle));
		siteSelectEle.click();

		Thread.sleep(2000);

		siteFilterEle.click();

		WebElement searchButtonEle = driver.findElement(By.xpath(searchButton));
		searchButtonEle.click();

		WebElement loadingSpinnerEle = driver.findElement(By.xpath(loadingSpinner));
		wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));
		int retries = 5;
		while (retries > 0) {
			try {
				System.out.println("Into the while block of iteration: " + retries);
		Common_Methods.clickEleBy_Xpath(prop.getVisitCheckBoxOnScheduleManagement(), driver);
		break;
			} catch (Exception e) {
				System.out.println("Exception Occurred at the iteration: " + retries);
				//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getDcsPhone3DdArrow())));
				Thread.sleep(5000);
				retries--;
			}
		}
	}
}
