package PS;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

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
import ReportMail.EmailSender;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class CreatePS {

	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	// String path = "C:\\POC-Automation\\TestData.xlsx";
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	String menuClick, HomeClick, flyout, createPSFlyout;
	String basicInfoTest, lastName, firstName;
	String raceDropdownClick, raceSearch, raceSelection, raceOtherUnknown, raceAfricanAmerican,raceWhite;
	String dob;
	String genderClick, genderSearch, femaleGender, maleGender, unknownGender;
	String salutation, salDR, salMiss, salMRS, salMS, salMR;
	String maritalStatusClick, maritalStatusSearch, maritalStatusSelect;
	String ssn;
	String primaryLangClick, primaryLangSearch, primaryLangSelect;
	String MappedSitesClick, MappedSitesSearch, MappedSitesSelect;
	String locationClick, locationSearch, locationSelect;
	String addressLine1, addressLine2, zipCode;
	String phoneTypeClick, phoneTypeSearch, phoneTypeSelect;
	String phoneNumber;
	String saveButton;
	String successMessage;
	String successMsgOkButton;
	String guarantorHeader;
	String selfGuarantorDetails;
	String selfGuarantorAddress;
	String saveAndNextButton;
	String guarSuccMsg;
	String guarSuccMsgOKBtn;
	WebElement flyoutOption;
	int i ;
	public static int rowcount = 0;
	String SheetName;
	
	@BeforeTest
	public void allProps() throws IOException {
		driver = BaseClass.getDriver();
		path = BaseClass.getTestDataPath();
		wait = BaseClass.getWebDriverWait();
		myActions = BaseClass.getDriverActions();
		robot = BaseClass.getRobot();
		prop = new ReadPropFile();
		excel = new ExcelRead(path);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		BaseClass.sheetStatus = "Pass";
	}

	@Test(dependsOnMethods = "LoginPage.LoginTest.loginLite")
	public void navigateToHome() throws InterruptedException {

		menuClick = prop.getMenuOption();
		HomeClick = prop.getHomeMenu();
		try {
			driver.findElement(By.xpath(menuClick)).click();

			if (BaseClass.excelToWrite.setCellData("Create PS_Basic", "Status", 7, 8, BaseClass.sheetStatus)
					&& BaseClass.excelToWrite.setCellData("Create PS_Basic", "Status", 7, 9, BaseClass.sheetStatus)
					&& BaseClass.excelToWrite.setCellData("Create PS_Basic", "Status", 7, 10, BaseClass.sheetStatus)) {
				System.out.println("menuClick  successfully.");
			} else {
				System.out.println("menuClick Failed.");
			}

		} catch (Exception e) {
			System.out.println("In catch of firefox");
			BaseClass.sheetStatus = "Fail";
			BaseClass.indexStatus = BaseClass.sheetStatus;
			BaseClass.excelToWrite.setCellData("Create PS_Basic", "Status", 7, 8, BaseClass.sheetStatus);
			BaseClass.excelToWrite.setCellData("Create PS_Basic", "Status", 7, 9, BaseClass.sheetStatus);
			BaseClass.excelToWrite.setCellData("Create PS_Basic", "Status", 7, 10, BaseClass.sheetStatus);
			BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 10, BaseClass.indexStatus);

		}

		try {
			driver.findElement(By.xpath(HomeClick)).click();

			if (BaseClass.excelToWrite.setCellData("Create PS_Basic", "Status", 7, 11, BaseClass.sheetStatus)
					&& BaseClass.excelToWrite.setCellData("Create PS_Basic", "Status", 7, 12, BaseClass.sheetStatus)) {
				System.out.println("HomeClick successfully.");
			} else {
				System.out.println("HomeClick Failed.");
			}

		} catch (Exception e) {
			System.out.println("In catch of firefox");
			BaseClass.sheetStatus = "Fail";
			BaseClass.indexStatus = BaseClass.sheetStatus;
			BaseClass.excelToWrite.setCellData("Create PS_Basic", "Status", 7, 11, BaseClass.sheetStatus);
			BaseClass.excelToWrite.setCellData("Create PS_Basic", "Status", 7, 12, BaseClass.sheetStatus);
			BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 10, BaseClass.indexStatus);

		}
		// Thread.sleep(2000);

		// Thread.sleep(5000);
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
	}

	@Test(dependsOnMethods = "navigateToHome")
	public void createPSPopup() throws InterruptedException {
		flyout = prop.getFlyoutMenu();
		createPSFlyout = prop.getFlyoutCreatePS();
		System.out.println("In the CreatePS pop-up method");
		// driver.findElement(By.xpath(flyout)).click();
		int retries = 5;
		while (retries > 0) {
			try {
				System.out.println("Into the while block of iteration: " + retries);
				flyoutOption = driver.findElement(By.xpath(flyout));
				wait.until(ExpectedConditions.visibilityOf(flyoutOption));
				myActions.moveToElement(flyoutOption).build().perform();
				System.out.println("try done successfully...");
				break;
			} catch (ElementClickInterceptedException e) {
				System.out.println("Exception Occurred at the iteration: " + retries);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(flyout)));
				Thread.sleep(5000);
				retries--;
			}
		}
		WebElement createPSOption = driver.findElement(By.xpath(createPSFlyout));
		wait.until(ExpectedConditions.visibilityOf(createPSOption));
		Thread.sleep(1000);
		myActions.moveToElement(createPSOption).build().perform();
		createPSOption.click();
		Thread.sleep(2000);

	}

	@Test(dependsOnMethods = "createPSPopup")
	public void createPSBasicDetails() throws InterruptedException{
		if (rowcount>2) {
			i= MultiplePS_Creation.i;
			SheetName = "PSBasicDetails_1";
		} else {
			
			i=2;
			SheetName ="PSBasicDetails";
			
		}
		System.out.println("i = "+MultiplePS_Creation.i);
		System.out.println(rowcount);
		System.out.println(SheetName);
		basicInfoTest = prop.getBasicInformationText();
		lastName = prop.getLastName();
		firstName = prop.getFirstName();
		raceDropdownClick = prop.getRaceDropDownClick();
		raceSearch = prop.getRaceListInput();
		raceSelection = prop.getRaceSelection();
		dob = prop.getDOB();
		genderClick = prop.getGenderField();
		genderSearch = prop.getGenderSearch();
		femaleGender = prop.getFemaleGender();
		maleGender = prop.getMaleGender();
		unknownGender = prop.getUnknownGender();
		salutation = prop.getSalutationField();
		salDR = prop.getSalutationDR();
		salMiss = prop.getSalutationMiss();
		salMR = prop.getSalutationMR();
		salMRS = prop.getSalutationMRS();
		salMS = prop.getSalutationMS();
		maritalStatusClick = prop.getMaritalStatusField();
		maritalStatusSearch = prop.getMaritalStatusSearch();
		maritalStatusSelect = prop.getMaritalStatusSelection();
		// primaryLangClick, primaryLangSearch, primaryLangSelect
		primaryLangClick = prop.getPrimLangField();
		primaryLangSearch = prop.getPrimLangSearch();
		primaryLangSelect = prop.getPrimLangSelection();
		// MappedSitesClick, MappedSitesSearch, MappedSitesSelect;
		MappedSitesClick = prop.getMappedSitesField();
		MappedSitesSearch = prop.getMappedSitesSearch();
		MappedSitesSelect = prop.getMappedSitesSelection();

		WebElement basicInfoTextEle = driver.findElement(By.xpath(basicInfoTest));
		wait.until(ExpectedConditions.visibilityOf(basicInfoTextEle));
		driver.findElement(By.xpath(lastName)).sendKeys(excel.getCellData(SheetName, 0, i));
		driver.findElement(By.xpath(firstName)).sendKeys(excel.getCellData(SheetName, 1, i));
		System.out.println("firstName = "+excel.getCellData(SheetName, 1, i));
		Thread.sleep(2000);
		driver.findElement(By.xpath(raceDropdownClick)).click();
		WebElement raceSearchEle = driver.findElement(By.xpath(raceSearch));
		wait.until(ExpectedConditions.visibilityOf(raceSearchEle));
		raceSearchEle.sendKeys(excel.getCellData(SheetName, 2, i));
		System.out.println("Race = "+excel.getCellData(SheetName, 2, i));
		Thread.sleep(2000);
		driver.findElement(By.xpath(raceSelection)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(dob)).sendKeys(excel.getCellData(SheetName, 3, i));
		Thread.sleep(2000);
		driver.findElement(By.xpath(genderClick)).click();
		Thread.sleep(2000);
		WebElement maleGenderEle = driver.findElement(By.xpath(maleGender));
		WebElement femaleGenderEle = driver.findElement(By.xpath(femaleGender));
		WebElement unknownGenderEle = driver.findElement(By.xpath(unknownGender));
		wait.until(ExpectedConditions.visibilityOf(maleGenderEle));
		String gender = excel.getCellData(SheetName, 4, i);
		System.out.println(gender);
		if (gender.equalsIgnoreCase("MALE")) {
			System.out.println("In Male if block");
			maleGenderEle.click();
		} else if (gender.equalsIgnoreCase("FEMALE")) {
			System.out.println("In Female if block");
			femaleGenderEle.click();
		} else if (gender.equalsIgnoreCase("UNKNOWN")) {
			System.out.println("In Unknown if block");
			unknownGenderEle.click();
		} else {
			System.out.println("Inavlid gender");
		}

		Thread.sleep(2000);
		driver.findElement(By.xpath(salutation)).click();
		WebElement salDREle = driver.findElement(By.xpath(salDR));
		WebElement salMREle = driver.findElement(By.xpath(salMR));
		WebElement salMissEle = driver.findElement(By.xpath(salMiss));
		WebElement salMRSEle = driver.findElement(By.xpath(salMRS));
		WebElement salMSEle = driver.findElement(By.xpath(salMS));
		wait.until(ExpectedConditions.visibilityOf(salDREle));
		String saluationValue = excel.getCellData(SheetName, 5, i);
		if (saluationValue.equalsIgnoreCase("DR")) {
			salDREle.click();
		} else if (saluationValue.equalsIgnoreCase("MR")) {
			salMREle.click();
		} else if (saluationValue.equalsIgnoreCase("MISS")) {
			salMissEle.click();
		} else if (saluationValue.equalsIgnoreCase("MRS")) {
			salMRSEle.click();
		} else if (saluationValue.equalsIgnoreCase("MS")) {
			salMSEle.click();
		} else {
			System.out.println("Inavlid salutation");
		}

		driver.findElement(By.xpath(maritalStatusClick)).click();
		WebElement maritalStatusSearchEle = driver.findElement(By.xpath(maritalStatusSearch));
		wait.until(ExpectedConditions.visibilityOf(maritalStatusSearchEle));
		maritalStatusSearchEle.sendKeys(excel.getCellData(SheetName, 6, i));
		Thread.sleep(2000);
		driver.findElement(By.xpath(maritalStatusSelect)).click();

		driver.findElement(By.xpath(primaryLangClick)).click();
		WebElement primaryLangSearchEle = driver.findElement(By.xpath(primaryLangSearch));
		wait.until(ExpectedConditions.visibilityOf(primaryLangSearchEle));
		primaryLangSearchEle.sendKeys(excel.getCellData(SheetName, 8, i));
		Thread.sleep(2000);
		driver.findElement(By.xpath(primaryLangSelect)).click();

		driver.findElement(By.xpath(MappedSitesClick)).click();
		WebElement mappedSiteSearchEle = driver.findElement(By.xpath(MappedSitesSearch));
		wait.until(ExpectedConditions.visibilityOf(mappedSiteSearchEle));
		mappedSiteSearchEle.sendKeys(excel.getCellData(SheetName, 9, i));
		Thread.sleep(2000);
		driver.findElement(By.xpath(MappedSitesSelect)).click();
	}

	@Test(dependsOnMethods = "createPSBasicDetails")
	public void createPSAddressDetails() throws InterruptedException {
		if (rowcount>2) {
			i=MultiplePS_Creation.i;
			SheetName ="PSAddress_1";
		} else {
			i=2;
			SheetName="PSAddress";
		}
		
		
		locationClick = prop.getLocationField();
		locationSearch = prop.getLocationSearch();
		locationSelect = prop.getLocationSelection();
		addressLine1 = prop.getAddressLine1Field();
		// addressLine2 = prop.getAddressLine2Field();
		zipCode = prop.getZipCodeField();
		phoneTypeClick = prop.getPhoneTypeField();
		phoneTypeSearch = prop.getPhoneTypeSearch();
		phoneTypeSelect = prop.getPhoneTypeSelection();

		driver.findElement(By.xpath(locationClick)).click();
		WebElement locationSearchEle = driver.findElement(By.xpath(locationSearch));
		wait.until(ExpectedConditions.visibilityOf(locationSearchEle));
		locationSearchEle.sendKeys(excel.getCellData("PSAddress", 0, 2));
		Thread.sleep(2000);
		driver.findElement(By.xpath(locationSelect)).click();

		driver.findElement(By.xpath(addressLine1)).sendKeys(excel.getCellData(SheetName, 1, i));

		// driver.findElement(By.xpath(addressLine1)).sendKeys(excel.getCellData("PSAddress",
		// 2, 2));

		driver.findElement(By.xpath(zipCode)).sendKeys(excel.getCellData(SheetName, 3, i));
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		WebElement phoneTypeEle = driver.findElement(By.xpath(phoneTypeClick));
		wait.until(ExpectedConditions.visibilityOf(phoneTypeEle));
		int retries = 5;
		while (retries > 0) {
			try {
				System.out.println("In phoneTypeEle");
				System.out.println("Into the while block of iteration: " + retries);
				phoneTypeEle.click();
				break;
			} catch (Exception e) {
				System.out.println("Exception Occurred at the iteration: " + retries);

				Thread.sleep(5000);
				retries--;
			}
		}
		
		WebElement phoneTypeSearchEle = driver.findElement(By.xpath(phoneTypeSearch));
		wait.until(ExpectedConditions.visibilityOf(phoneTypeSearchEle));
		while (retries > 0) {
			try {
				System.out.println("In phoneTypeSearchEle");
				System.out.println("Into the while block of iteration: " + retries);
				phoneTypeSearchEle.sendKeys(excel.getCellData(SheetName, 4, i));
				break;
			} catch (Exception e) {
				System.out.println("Exception Occurred at the iteration: " + retries);

				Thread.sleep(5000);
				retries--;
			}
		}
		
		Thread.sleep(2000);
		
		while (retries > 0) {
			try {
				System.out.println("In phoneTypeSelect");
				System.out.println("Into the while block of iteration: " + retries);
				driver.findElement(By.xpath(phoneTypeSelect)).click();
				break;
			} catch (Exception e) {
				System.out.println("Exception Occurred at the iteration: " + retries);

				Thread.sleep(5000);
				retries--;
			}
		}
		System.out.println(excel.getCellData(SheetName, 5, i));
		phoneNumber = prop.getPhoneNumber();
		WebElement phoneNumberEle = driver.findElement(By.xpath(phoneNumber));
		phoneNumberEle.click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(2000);
		phoneNumberEle.sendKeys(excel.getCellData(SheetName, 5, i));
		Thread.sleep(2000);
		saveButton = prop.getPsBDSaveButton();
		WebElement saveBtnEle = driver.findElement(By.xpath(saveButton));
		wait.until(ExpectedConditions.elementToBeClickable(saveBtnEle));
		
		try {
			saveBtnEle.click();

			if (BaseClass.excelToWrite.setCellData("Create PS_Basic", "Status", 7, 33, BaseClass.sheetStatus)) {
				//System.out.println("Login successfully.");
			} else {
				//System.out.println("Login Failed.");
			}
			if (BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 10, BaseClass.indexStatus)) {
				EmailSender.setResult(1, BaseClass.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				EmailSender.setDateTime(1, reportDate);

			} else {
				//System.out.println("Login Failed.");
			}

		} catch (Exception e) {
			System.out.println("In catch of firefox");
			BaseClass.sheetStatus = "Fail";
			BaseClass.indexStatus = BaseClass.sheetStatus;
			BaseClass.excelToWrite.setCellData("Create PS_Basic", "Status", 7, 33, BaseClass.sheetStatus);
			BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 10, BaseClass.indexStatus);
			EmailSender.setResult(1, BaseClass.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			EmailSender.setDateTime(1, reportDate);
		}
		Thread.sleep(5000);
		System.out.println("Waited for 5 seconds");
		// wait.until(ExpectedConditions.alertIsPresent());

		// Alert alert = driver.switchTo().alert();
		// alert.accept();

		successMsgOkButton = prop.getSuccessMsgOkBtn();
		WebElement swalElement = driver.findElement(By.xpath(successMsgOkButton));
		if (swalElement.isDisplayed()) {
			System.out.println("Swal element identified");
			swalElement.click();
			// robot.keyPress(KeyEvent.VK_ENTER);
			// robot.keyRelease(KeyEvent.VK_ENTER);
		} else {
			System.out.println("Element not identified");
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}

		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		/*
		 * successMessage = prop.getSuccessMsg(); successMsgOkButton =
		 * prop.getSuccessMsgOkBtn(); //WebElement successMsgEle =
		 * driver.findElement(By.xpath("successMessage")); WebElement
		 * successMsgOkButtonEle = driver.findElement(By.xpath("successMsgOkButton"));
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(successMsgOkButtonEle));
		 * successMsgOkButtonEle.click();
		 */
		// String successMsgText = successMsgEle.getText();
		// System.out.println(successMsgText);
		/*
		 * if(successMsgText.equalsIgnoreCase("Data saved successfully")) {
		 * System.out.println("PS Created Successfully"); successMsgOkButtonEle.click();
		 * } else { System.out.println("PS creation failed"); }
		 */
	}

	@Test(dependsOnMethods = "createPSAddressDetails")
	public void createPSGuarantorDetails() throws InterruptedException {
		
		guarantorHeader = prop.getGuarantorHeader();
		selfGuarantorDetails = prop.getSelfGuarantorCheckBox();
		selfGuarantorAddress = prop.getSelfGuarantorAddress();
		saveAndNextButton = prop.getSaveAndNextButton();
		guarSuccMsgOKBtn = prop.getSuccessMsgOkBtn();

		driver.findElement(By.xpath(selfGuarantorDetails)).click();
		driver.findElement(By.xpath(selfGuarantorAddress)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(saveAndNextButton)).click();
		Thread.sleep(5000);

		guarSuccMsg = prop.getGuarantorSuccessMsg();
		WebElement guarSuccMsgEle = driver.findElement(By.xpath(guarSuccMsg));
		String successMsg = guarSuccMsgEle.getText();
		System.out.println(successMsg);

		WebElement guarSuccMsgOKBtnEle = driver.findElement(By.xpath(guarSuccMsgOKBtn));
		if (guarSuccMsgEle.isDisplayed()) {
			System.out.println("Swal element at Guarantor completion is identified");
			try {
				guarSuccMsgOKBtnEle.click();

				if (BaseClass.excelToWrite.setCellData("Create PS_Basic", "Status", 7, 37, BaseClass.sheetStatus)) {
					//System.out.println("Login successfully.");
				} else {
					//System.out.println("Login Failed.");
				}
				if (BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 11, BaseClass.indexStatus)) {
					EmailSender.setResult(2, BaseClass.indexStatus);
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
					Date date = new Date();
					String reportDate = df.format(date);
					EmailSender.setDateTime(2, reportDate);

				} else {
					//System.out.println("Login Failed.");
				}

			} catch (Exception e) {
				System.out.println("In catch of firefox");
				BaseClass.sheetStatus = "Fail";
				BaseClass.indexStatus = BaseClass.sheetStatus;
				BaseClass.excelToWrite.setCellData("Create PS_Basic", "Status", 7, 37, BaseClass.sheetStatus);
				BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 11, BaseClass.indexStatus);
				EmailSender.setResult(2, BaseClass.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				EmailSender.setDateTime(2, reportDate);
			}
			
			// robot.keyPress(KeyEvent.VK_ENTER);
			// robot.keyRelease(KeyEvent.VK_ENTER);
		} else {
			System.out.println("Element at Guarantor completion is not identified");
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}

		Thread.sleep(3000);

	}

}
