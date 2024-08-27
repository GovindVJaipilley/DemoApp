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

public class AddVisitPopUp {

	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	//String path = "C:\\POC-Automation\\TestData.xlsx";
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	String flyOutInSC, flyOutAddVisitsInSC;
	String dayInSC;
	String pageLoading;
	String addVisitPopUpHeader;

	@BeforeTest
	public void driversForAddVisits() throws IOException {
		driver = BaseClass.getDriver();
		path = BaseClass.getTestDataPath();
		wait = BaseClass.getWebDriverWait();
		myActions = BaseClass.getDriverActions();
		robot = BaseClass.getRobot();
		prop = new ReadPropFile();
		excel = new ExcelRead(path);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		addVisitPopUpHeader = prop.getAddVisitPopUpHeader();
		pageLoading = prop.getLoadingSpinner();
		flyOutInSC = prop.getFlyOutInSC();
		flyOutAddVisitsInSC = prop.getflyOutAddVisitsInSC();
	}

	@Test
	public void openAddVisitsFromCalendar() throws InterruptedException {

		dayInSC = prop.getVisitDateInSC();
		// pageLoading = prop.getLoadingSpinner();
		System.out.println(dayInSC);

		driver.findElement(By.xpath(dayInSC)).click();
		// Thread.sleep(30000);
		// WebElement pageLoadingEle = driver.findElement(By.xpath(pageLoading));
		// wait.until(ExpectedConditions.invisibilityOf(pageLoadingEle));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		WebElement addVisitPopUpHeaderEle = null;
		int retries = 5;
		while (retries > 0) {
			try {
				System.out.println("Into the while block of iteration: " + retries);
				addVisitPopUpHeaderEle = driver.findElement(By.xpath(addVisitPopUpHeader));
				break;
			} catch (Exception e) {
				System.out.println("Exception Occurred at the iteration: " + retries);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addVisitPopUpHeader)));
				Thread.sleep(5000);
				retries--;
			}
		}
		if (addVisitPopUpHeaderEle.isDisplayed()) {
			System.out.println(addVisitPopUpHeaderEle.getText());
		} else {
			System.out.println("Add Visits pop-up is not opened");
		}

	}

	@Test
	public void openAddVisitsFromFlyOut() throws InterruptedException {

		WebElement flyOutInSCEle = driver.findElement(By.xpath(flyOutInSC));
		wait.until(ExpectedConditions.visibilityOf(flyOutInSCEle));
		myActions.moveToElement(flyOutInSCEle).build().perform();

		WebElement flyOutAddVisitsInSCEle = driver.findElement(By.xpath(flyOutAddVisitsInSC));
		int retries = 5;
		while (retries > 0) {
			try {
				System.out.println("Into the while block of iteration: " + retries);

				myActions.moveToElement(flyOutAddVisitsInSCEle).build().perform();
				flyOutAddVisitsInSCEle.click();
				break;
			} catch (Exception e) {
				System.out.println("Exception Occurred at the iteration: " + retries);

				Thread.sleep(5000);
				retries--;
			}
		}

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(pageLoading)));

		WebElement addVisitPopUpHeaderEle = driver.findElement(By.xpath(addVisitPopUpHeader));
		if (addVisitPopUpHeaderEle.isDisplayed()) {
			System.out.println(addVisitPopUpHeaderEle.getText());
		} else {
			System.out.println("Add Visits pop-up is not opened");
		}

		Thread.sleep(2000);

	}
}
