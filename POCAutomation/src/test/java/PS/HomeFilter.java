package PS;

import java.awt.Robot;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
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

public class HomeFilter {

	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	//String path = "C:\\POC-Automation\\TestData.xlsx";
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	String filterOption;
	String psStatusFilter;
	String psStatusAll;
	String psStausActive;
	String psStatusInactive;
	String psNameFilter;
	String filterSearch;

	@BeforeTest
	public void driversForFilter() throws IOException {
		driver = BaseClass.getDriver();
		path = BaseClass.getTestDataPath();
		wait = BaseClass.getWebDriverWait();
		myActions = BaseClass.getDriverActions();
		robot = BaseClass.getRobot();
		prop = new ReadPropFile();
		excel = new ExcelRead(path);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test(priority = 1)
	public void navigateToHome() throws InterruptedException{
		int retries = 5;
		while (retries > 0) {
			try {
				System.out.println("Into the while block of iteration: " + retries);
		Common_Methods.navigateToHomeInCommon_Methods(driver, prop, wait);
		break;
			} catch (Exception e) {
				System.out.println("Exception Occurred at the iteration: " + retries);
				
				Thread.sleep(5000);
				retries--;
			}
		}
	}

	@Test(priority = 2)
	public void filterChange() throws InterruptedException {
	
		
		//String menuClick = prop.getMenuOption();
		//String HomeClick = prop.getHomeMenu();
		filterOption = prop.getFilterIcon();
		psStatusFilter = prop.getPSStatus();
		psStatusAll = prop.getPSStatusAll();
		psStausActive = prop.getPSStatusActive();
		psStatusInactive = prop.getPSStatusInActive();
		psNameFilter = prop.getPSNameFilter();
		filterSearch = prop.getSearchFilterButton();
		
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		WebElement filterOptionEle = driver.findElement(By.xpath(filterOption));
		wait.until(ExpectedConditions.elementToBeClickable(filterOptionEle));
		
		int retries = 5;
		while (retries > 0) {
			try {
				System.out.println("Into the while block of iteration: "+retries);
				filterOptionEle.click();
				break;
			} catch (ElementClickInterceptedException e) {
				System.out.println("Exception Occurred at the iteration: "+retries);
				wait.until(ExpectedConditions.elementToBeClickable(filterOptionEle));
				Thread.sleep(10000);
				retries--;
			}
		}
		
		Thread.sleep(2000);
		WebElement psNameFilterEle = driver.findElement(By.xpath(psNameFilter));
		wait.until(ExpectedConditions.visibilityOf(psNameFilterEle));
		psNameFilterEle.sendKeys(excel.getCellData("HomeFilter", 1, 2));
		driver.findElement(By.xpath(psStatusFilter)).click();
		Thread.sleep(2000);
		WebElement psStatusFilterAllEle = driver.findElement(By.xpath(psStatusAll));
		WebElement psStatusFilterActiveEle = driver.findElement(By.xpath(psStausActive));
		WebElement psStatusFilterInActiveEle = driver.findElement(By.xpath(psStatusInactive));
		wait.until(ExpectedConditions.visibilityOf(psStatusFilterAllEle));
		String psStatusData = excel.getCellData("HomeFilter", 2, 2); 
		System.out.println(psStatusData);

		if (psStatusData.equalsIgnoreCase("All")) {
			psStatusFilterAllEle.click();
		} else if (psStatusData.equalsIgnoreCase("Active")) {
			psStatusFilterActiveEle.click();
		} else if (psStatusData.equalsIgnoreCase("Inactive")) {
			psStatusFilterInActiveEle.click();
		} else {
			System.out.println("Invalid PS Status");
		}
		
		driver.findElement(By.xpath(filterSearch)).click();
		Thread.sleep(5000);
	}
}
