package LoginPage;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ReportMail.EmailSender;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class LoginTest {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	ReadPropFile prop;
	Actions myActions;
	ExcelRead excel;
	Robot robot;
	// InputStream inputStream;
	//String path = "C:\\POC-Automation\\TestData.xlsx";
	String path; //= "src/test/resources/TestData/TestData.xlsx";
	String loginId, password, loginBtn, url, failedMsg, okButton;

	@BeforeTest
	public void loginTest() throws IOException {
		System.out.println("In the Before Test");
		driver = BaseClass.getDriver();
		path = BaseClass.getTestDataPath();
		wait = BaseClass.getWebDriverWait();
		myActions = new Actions(driver);
		prop = new ReadPropFile();
		excel = new ExcelRead(path);
		js = BaseClass.getJSExecutor();
		robot = BaseClass.getRobot();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		BaseClass.sheetStatus = "Pass";
	}

	@Test
	public void navigateToURL() {
		url = excel.getCellData("Credentials", 1, 2);

		try {
			driver.get(url);
			//js.executeScript("document.body.style.zoom = '90%'");
			Thread.sleep(2000);
			if (BaseClass.excelToWrite.setCellData("Login", "Status", 7, 9, BaseClass.sheetStatus)) {
				System.out.println("Navigated to URL.");
			} else {
				System.out.println("Navigation to URL Failed.");
			}

		} catch (Exception e) {
			System.out.println("In catch of firefox");
			BaseClass.sheetStatus = "Fail";
			BaseClass.indexStatus = BaseClass.sheetStatus;
			BaseClass.excelToWrite.setCellData("Login", "Status", 7, 9, BaseClass.sheetStatus);
			BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 9, BaseClass.indexStatus);

		}
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
        //js.executeScript("document.body.style.transform = 'scale(0.9)'");
		
		System.out.println("In the url method");
		loginId = prop.getLoginIdXpath();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(loginId))));
	}

	@Test(dependsOnMethods = "navigateToURL")
	public void loginLite() throws InterruptedException, IOException {
		// driver = BaseClass.getDriver();
		// prop = new ReadPropFile();
		// excel = new ExcelRead(path);
		System.out.println("In the loginLite method");
		loginId = prop.getLoginIdXpath();
		password = prop.getPasswordXpath();
		loginBtn = prop.getLoginBtnXpath();
		failedMsg = prop.getFailedPopUpXpath();
		okButton = prop.getFailedPopUpOkBtn();

		System.out.println(loginId);
		String un = excel.getCellData("Credentials", 2, 2);
		String pwd = excel.getCellData("Credentials", 3, 2);
		System.out.println(un);
		System.out.println(pwd);

		try {
			driver.findElement(By.xpath(loginId)).sendKeys(excel.getCellData("Credentials", 2, 2));

			if (BaseClass.excelToWrite.setCellData("Login", "Status", 7, 10, BaseClass.sheetStatus)) {
				System.out.println("UserName Entered successfully.");
			} else {
				System.out.println("Failed to Enter UserName.");
			}

		} catch (Exception e) {
			System.out.println("In catch of firefox");
			BaseClass.sheetStatus = "Fail";
			BaseClass.indexStatus = BaseClass.sheetStatus;
			BaseClass.excelToWrite.setCellData("Login", "Status", 7, 10, BaseClass.sheetStatus);
			BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 9, BaseClass.indexStatus);

		}

		try {
			driver.findElement(By.xpath(password)).sendKeys(excel.getCellData("Credentials", 3, 2));

			if (BaseClass.excelToWrite.setCellData("Login", "Status", 7, 11, BaseClass.sheetStatus)) {
				System.out.println("Password Entered successfully.");
			} else {
				System.out.println("Failed to Enter Password.");
			}

		} catch (Exception e) {
			System.out.println("In catch of firefox");
			BaseClass.sheetStatus = "Fail";
			BaseClass.indexStatus = BaseClass.sheetStatus;
			BaseClass.excelToWrite.setCellData("Login", "Status", 7, 11, BaseClass.sheetStatus);
			BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 9, BaseClass.indexStatus);

		}

		if (BaseClass.browser.equalsIgnoreCase("firefox")) {
			Thread.sleep(2000);
			driver.findElement(By.xpath(loginId)).click();
		}

		try {
			driver.findElement(By.xpath(loginBtn)).click();

			if (BaseClass.excelToWrite.setCellData("Login", "Status", 7, 12, BaseClass.sheetStatus)) {
				System.out.println("Login successfully.");
			} else {
				System.out.println("Login Failed.");
			}
			if (BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 9, BaseClass.indexStatus)) {
				
				EmailSender.setResult(0, BaseClass.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				System.out.println(reportDate);
				EmailSender.setDateTime(0, reportDate);

			} else {
				System.out.println("Login Failed.");
			}

		} catch (Exception e) {
			System.out.println("In catch of firefox");
			e.printStackTrace();
			BaseClass.sheetStatus = "Fail";
			BaseClass.indexStatus = BaseClass.sheetStatus;
			BaseClass.excelToWrite.setCellData("Login", "Status", 7, 12, BaseClass.sheetStatus);
			BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 9, BaseClass.indexStatus);
			EmailSender.setResult(0, BaseClass.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			EmailSender.setDateTime(0, reportDate);
		}
		try {
			System.out.println("In try block");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(failedMsg)));

			WebElement failedPopup = driver.findElement(By.xpath(failedMsg));
			String failedMessage = driver.findElement(By.xpath(failedMsg)).getText();

			if (failedPopup.isDisplayed()) {
				if (failedMessage.contains("Login failed")) {
					System.out.println("Login failed. Used invalid credentials");
					driver.findElement(By.xpath(okButton)).click();
					// return false;
				} else if (failedMessage.contains("AMS Alerts loading failed")) {
					System.out.println("Login Successful, but AMS alerts loading failed");
					driver.findElement(By.xpath(okButton)).click();
					// return true;
				}

			} else {
				System.out.println("Login Successful");
			}

		} catch (TimeoutException e) {
			// e.printStackTrace();
			System.out.println("Login Successful");
		}
	}

}
