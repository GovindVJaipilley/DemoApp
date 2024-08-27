package SchedulingCalendar;

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

public class SearchInSC {

	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	String psSearch, psName, psSelect;
	String siteSearch, siteCode, siteSelect;
	String goButton;
	String pageLoading;

	@BeforeTest
	public void driversForSchedCalendar() throws IOException {
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
	public void filterSCScreen() throws InterruptedException {
		
		psSearch = prop.getPSDropDownInSC();
		psName = prop.getPSDropDownInSCSearch();
		psSelect = prop.getPSDropDownInSCSelect();
		siteSearch = prop.getsiteDropDownInSC();
		siteCode = prop.getsiteDropDownInSCSearch();
		siteSelect = prop.getSitesListInSC();
		goButton = prop.getGoButtonInSC();
		pageLoading = prop.getLoadingSpinner();
		
		WebElement psSearchEle = driver.findElement(By.xpath(psSearch));
		psSearchEle.click();
		
		WebElement psNameEle = driver.findElement(By.xpath(psName));
		wait.until(ExpectedConditions.visibilityOf(psNameEle));
		psNameEle.sendKeys(excel.getCellData("Add_Visit_SC", 0, 2));
		
		Thread.sleep(3000);
		
		WebElement psSelectEle = driver.findElement(By.xpath(psSelect));
		wait.until(ExpectedConditions.visibilityOf(psSelectEle));
		psSelectEle.click();
		
		Thread.sleep(3000);
		WebElement siteSearchEle = driver.findElement(By.xpath(siteSearch));
		siteSearchEle.click();
		
		WebElement siteCodeEle = driver.findElement(By.xpath(siteCode));
		wait.until(ExpectedConditions.visibilityOf(siteCodeEle));
		siteCodeEle.sendKeys(excel.getCellData("Add_Visit_SC", 1, 2));
		
		Thread.sleep(3000);
		WebElement siteSelectEle = driver.findElement(By.xpath(siteSelect));
		wait.until(ExpectedConditions.visibilityOf(siteSelectEle));
		siteSelectEle.click();
		
		Thread.sleep(2000);
		WebElement goButtonEle = driver.findElement(By.xpath(goButton));
		goButtonEle.click();
		
		WebElement pageLoadingEle = driver.findElement(By.xpath(pageLoading));
		wait.until(ExpectedConditions.invisibilityOf(pageLoadingEle));

	}
}
