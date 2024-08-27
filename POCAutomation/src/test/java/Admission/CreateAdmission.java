package Admission;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginPage.BaseClass;
import PS.MultiplePS_Creation;
import ReportMail.EmailSender;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class CreateAdmission {

	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	//String path = "C:\\POC-Automation\\TestData.xlsx";
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	String admissionPageHeader;
	String siteOption;
	String siteSearch;
	String siteSelection;
	String psField;
	String psSearch;
	String psSelection;
	String guarantorField;
	String guarantorSearch;
	String guarantorSelection;
	String coordinatorField;
	String coordinatorSearch;
	String coordinatorSelection;
	String admissionDate;
	String firstVisitDate;
	String referredDate;
	String referralSourceField;
	String referralSourceSearch;
	String referralSourceSelection;
	String diagnosisButton;
	String diagnosisDetails;
	String addBtnAtDiag;
	String diagTable;
	String saveAndNextButton;
	String admCreatedSuccMsg;
	String admSuccMsgOKBtn;
	String payorPlanHeader;
	int i ;
	public static int rowcount = 0;
	String SheetName;
	@BeforeTest
	public void driversForAdmission() throws IOException {
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

	@Test
	public void createAdmission() throws InterruptedException {
		
		if (rowcount>2) {
			i= MultiplePS_Creation.i;
			SheetName = "Admission_Details_1";
		} else {
			i=2;
			SheetName ="Admission_Details";
		}
		admissionPageHeader = prop.getAdmissionDetailsHeader();
		
		WebElement admissionPageHeaderEle = driver.findElement(By.xpath(admissionPageHeader));
		if(admissionPageHeaderEle.isDisplayed()) {
			System.out.println("Navigated to Create Admission page");
		}else {
			System.out.println("The screen is not navigated to Create Admission page");
		}
		
		siteOption = prop.getSiteOption();
		siteSearch = prop.getSiteSearch();
		siteSelection = prop.getSiteSelection();
		
		try {
			WebElement siteFieldEle = driver.findElement(By.xpath(siteOption));
			siteFieldEle.click();
			WebElement siteSearchEle = driver.findElement(By.xpath(siteSearch));
			wait.until(ExpectedConditions.visibilityOf(siteSearchEle));
			siteSearchEle.sendKeys(excel.getCellData(SheetName, 0, i));
			WebElement siteSelectionEle = driver.findElement(By.xpath(siteSelection));
			siteSelectionEle.click();
			Thread.sleep(2000);
		} catch(NoSuchElementException nse) {
			System.out.println("Site textbox is disabled");
		} catch (Exception e) {
		    // This will catch any broader exceptions that might occur
		    System.out.println("An exception occurred while getting the site element: " + e.getMessage());
		}
		
		psField = prop.getPSField();
		psSearch = prop.getPSSearch();
		psSelection = prop.getPSSelection();
		
		try {
			WebElement psFieldEle = driver.findElement(By.xpath(psField));
			psFieldEle.click();
			WebElement psSearchEle = driver.findElement(By.xpath(psSearch));
			wait.until(ExpectedConditions.visibilityOf(psSearchEle));
			psSearchEle.sendKeys(excel.getCellData(SheetName, 1, i));
			WebElement psSelectionEle = driver.findElement(By.xpath(psSelection));
			psSelectionEle.click();
			Thread.sleep(2000);
			
		} catch (NoSuchElementException nse) {
		    System.out.println("PS textbox is disabled: " + nse.getMessage());
		} catch (Exception e) {
		    // This will catch any broader exceptions that might occur
		    System.out.println("An exception occurred: " + e.getMessage());
		}
		
		guarantorField = prop.getGuarantor();
		guarantorSearch = prop.getGuarantorSearch();
		guarantorSelection = prop.getGuarantorSelection();
		
		WebElement guarantorFieldEle = driver.findElement(By.xpath(guarantorField));
		wait.until(ExpectedConditions.visibilityOf(guarantorFieldEle));
		guarantorFieldEle.click();
		WebElement guarantorSearchEle = driver.findElement(By.xpath(guarantorSearch));
		wait.until(ExpectedConditions.visibilityOf(guarantorSearchEle));
		guarantorSearchEle.sendKeys(excel.getCellData(SheetName, 2, i));
		WebElement guarantorSelectionEle = driver.findElement(By.xpath(guarantorSelection));
		guarantorSelectionEle.click();
		Thread.sleep(2000);
		
		coordinatorField = prop.getCoordinator();
		coordinatorSearch = prop.getCoordinatorSearch();
		coordinatorSelection = prop.getCoordinatorSelection();
		
		WebElement coordinatorFieldEle = driver.findElement(By.xpath(coordinatorField));
		wait.until(ExpectedConditions.visibilityOf(coordinatorFieldEle));
		coordinatorFieldEle.click();
		WebElement coordinatorSearchEle = driver.findElement(By.xpath(coordinatorSearch));
		wait.until(ExpectedConditions.visibilityOf(coordinatorSearchEle));
		coordinatorSearchEle.sendKeys(excel.getCellData(SheetName, 3, i));
		WebElement coordinatorSelectionEle = driver.findElement(By.xpath(coordinatorSelection));
		coordinatorSelectionEle.click();
		Thread.sleep(2000);
		
		admissionDate = prop.getAdmissionDate();
		driver.findElement(By.xpath(admissionDate)).sendKeys(excel.getCellData(SheetName, 4, i));
		
		firstVisitDate = prop.getFirstVisitDate();
		WebElement firstVisitDateEle = driver.findElement(By.xpath(firstVisitDate));
		firstVisitDateEle.clear();
		firstVisitDateEle.sendKeys(excel.getCellData(SheetName, 5, i));
		
		referredDate = prop.getReferredDate();
		driver.findElement(By.xpath(referredDate)).sendKeys(excel.getCellData(SheetName, 7, i));
		
		referralSourceField = prop.getReferralSource();
		referralSourceSearch = prop.getReferralSourceSearch();
		referralSourceSelection = prop.getReferralSourceSelection();
		
		WebElement referralSourceFieldEle = driver.findElement(By.xpath(referralSourceField));
		wait.until(ExpectedConditions.visibilityOf(referralSourceFieldEle));
		referralSourceFieldEle.click();
		WebElement referralSourceSearchEle = driver.findElement(By.xpath(referralSourceSearch));
		wait.until(ExpectedConditions.visibilityOf(referralSourceSearchEle));
		referralSourceSearchEle.sendKeys(excel.getCellData(SheetName, 8, i));
		WebElement referralSourceSelectionEle = driver.findElement(By.xpath(referralSourceSelection));
		referralSourceSelectionEle.click();
		Thread.sleep(2000);
		
		/*******************Adding Diagnoses details******************************/
		diagnosisButton = prop.getAddDiaganosisButton();
		driver.findElement(By.xpath(diagnosisButton)).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		String diagnosisDetails = prop.getDiagnosisdetails();
		WebElement diagnosisDetailsEle = driver.findElement(By.xpath(diagnosisDetails));
		wait.until(ExpectedConditions.visibilityOf(diagnosisDetailsEle));
		
		if(diagnosisDetailsEle.isDisplayed()) {
			System.out.println("Diagnosis Details Pop-up is opened");
		}
		else {
			System.out.println("Diagnosis details pop-up is not opened");
		}
		
		List<String> diagXpaths = prop.getDiagnosesList();
		int NoOfDiagsGiven = diagXpaths.size();
		System.out.println("Number of diagnoses are: " + NoOfDiagsGiven);
		for(String diagPath : diagXpaths) {
			WebElement diagCheckBox = driver.findElement(By.xpath(diagPath));
			diagCheckBox.click();
		}
		
		addBtnAtDiag = prop.getAddButtonAtDiag();
		WebElement addBtnAtDiagEle = driver.findElement(By.xpath(addBtnAtDiag));
		wait.until(ExpectedConditions.elementToBeClickable(addBtnAtDiagEle));
		addBtnAtDiagEle.click();
		
		diagTable = prop.getDiagTableContent();
		WebElement diagTableEle = driver.findElement(By.xpath(diagTable));
		wait.until(ExpectedConditions.visibilityOf(diagTableEle));
		
		List<WebElement> diagRows = diagTableEle.findElements(By.tagName("tr"));
		int diagRowCount = diagRows.size();
		System.out.println("The number of diagnosis added are: "+ diagRowCount);
		
		if(diagRowCount-1 == NoOfDiagsGiven) {
			System.out.println("The given diagnoses were added");
		} else {
			System.out.println("There is a descripancy in adding the given diagnoses");
		}
		
		saveAndNextButton = prop.getSaveAndNextButton();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getSaveAndNextButton())));
		Thread.sleep(5000);
		driver.findElement(By.xpath(saveAndNextButton)).click();
		Thread.sleep(5000);
		
		admCreatedSuccMsg = prop.getAdmCreatedSuccMsg();
		WebElement admCreatedSuccMsgEle = driver.findElement(By.xpath(admCreatedSuccMsg));
		wait.until(ExpectedConditions.visibilityOf(admCreatedSuccMsgEle));
		
		admSuccMsgOKBtn = prop.getSuccessMsgOkBtn();
		WebElement admSuccMsgOKBtnEle = driver.findElement(By.xpath(admSuccMsgOKBtn));
		if(admSuccMsgOKBtnEle.isDisplayed()) {
			System.out.println("Swal element at Admission completion is identified");
			
			try {
				admSuccMsgOKBtnEle.click();

				if (BaseClass.excelToWrite.setCellData("Create Admission", "Status", 7, 22, BaseClass.sheetStatus)) {
					//System.out.println("Login successfully.");
				} else {
					//System.out.println("Login Failed.");
				}
				if (BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 12, BaseClass.indexStatus)) {
					EmailSender.setResult(3, BaseClass.indexStatus);
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
					Date date = new Date();
					String reportDate = df.format(date);
					EmailSender.setDateTime(3, reportDate);

				} else {
					//System.out.println("Login Failed.");
				}

			} catch (Exception e) {
				System.out.println("In catch of firefox");
				BaseClass.sheetStatus = "Fail";
				BaseClass.indexStatus = BaseClass.sheetStatus;
				BaseClass.excelToWrite.setCellData("Create Admission", "Status", 7, 22, BaseClass.sheetStatus);
				BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 12, BaseClass.indexStatus);
				EmailSender.setResult(3, BaseClass.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				EmailSender.setDateTime(3, reportDate);
			}
			//robot.keyPress(KeyEvent.VK_ENTER);
			//robot.keyRelease(KeyEvent.VK_ENTER);
		}else {
			System.out.println("Element at Admission completion is not identified");
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		
		payorPlanHeader = prop.getPayorPlanDetailsHeader();
		WebElement payorPlanHeaderEle = driver.findElement(By.xpath(payorPlanHeader));
		wait.until(ExpectedConditions.visibilityOf(payorPlanHeaderEle));
		if(payorPlanHeaderEle.isDisplayed()) {
			System.out.println("Screen is navigated to Payor/Plan creation screen");
		} else {
			System.out.println("Failed to navigate to Payor/Plan creation screen");
		}

	}
}
