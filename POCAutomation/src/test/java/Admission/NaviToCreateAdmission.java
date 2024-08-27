package Admission;

import java.awt.Robot;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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

public class NaviToCreateAdmission {

	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	//String path = "C:\\POC-Automation\\TestData.xlsx";
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	String psMenuOption;
	String createAdmissionOption;
	String admissionPageHeader;

	@BeforeTest
	public void driversToNavigateToAdmission() throws IOException {
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
	public void navigateToCreateAdmission() throws InterruptedException {
		
		psMenuOption = prop.getMenuAtPS();
		createAdmissionOption = prop.getCreateAdmissionOption();
		
		int retries = 5;
		while (retries > 0) {
			try {
				WebElement psMenuOptionEle = driver.findElement(By.xpath(psMenuOption));
				wait.until(ExpectedConditions.visibilityOf(psMenuOptionEle));
				psMenuOptionEle.click();
				break;
			} catch (StaleElementReferenceException e) {
				retries--;
			}
		}
		
		WebElement createAdmissionOptionEle = driver.findElement(By.xpath(createAdmissionOption));
		wait.until(ExpectedConditions.visibilityOf(createAdmissionOptionEle));
		createAdmissionOptionEle.click();
		
		admissionPageHeader = prop.getAdmissionDetailsHeader();
		
		WebElement admissionPageHeaderEle = driver.findElement(By.xpath(admissionPageHeader));
		
		if(admissionPageHeaderEle.isDisplayed()) {
			System.out.println("Navigated to Create Admission page");
		}else {
			System.out.println("The screen is not navigated to Create Admission page");
		}
	}
}
