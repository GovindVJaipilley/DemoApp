package SchedulingCalendar;

import org.testng.annotations.Test;

import LoginPage.BaseClass;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

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

public class NaviToSchedCalendar {

	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	//String path = "C:\\POC-Automation\\TestData.xlsx";
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	String mainMenuOption;
	String schedMenu, schedCalendarMenu;
	String loadingSpinner, schedCalendarHeader;

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
	public void navigateToSchedCalendar() {
		mainMenuOption = prop.getMenuOption();
		schedMenu = prop.getSchedMenu();
		schedCalendarMenu = prop.getSchedCalendarMenu();
		schedCalendarHeader = prop.getSchedCalendarHeader();
		loadingSpinner = prop.getLoadingSpinner();

		WebElement mainMenuEle = driver.findElement(By.xpath(mainMenuOption));
		wait.until(ExpectedConditions.visibilityOf(mainMenuEle));
		mainMenuEle.click();
		WebElement schedMenuEle = driver.findElement(By.xpath(schedMenu));
		wait.until(ExpectedConditions.visibilityOf(schedMenuEle));
		schedMenuEle.click();
		WebElement schedCalendarMenuEle = driver.findElement(By.xpath(schedCalendarMenu));
		wait.until(ExpectedConditions.visibilityOf(schedCalendarMenuEle));
		schedCalendarMenuEle.click();

		WebElement loadingSpinnerEle = driver.findElement(By.xpath(loadingSpinner));
		wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));
		WebElement schedCalendarHeaderEle = driver.findElement(By.xpath(schedCalendarHeader));
		if (schedCalendarHeaderEle.isDisplayed()) {
			System.out.println("Navigated to Scheduling Calendar successfully");
			System.out.println(schedCalendarHeaderEle.getText());
		} else {
			System.out.println("Unable to navigate to Scheduling Calendar");
		}
	}

}
