package ManageVisits;

import java.awt.Robot;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginPage.BaseClass;
import ReportMail.EmailSender;
import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class AddVisitPopUpInSchedMgmt {

	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	// String path = "C:\\POC-Automation\\TestData.xlsx";
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
		BaseClass.sheetStatus = "Pass";
	}

	@Test
	public void openAddVisitInSchedule() throws InterruptedException {

		schedMgtRadioButton = prop.getSchedMgtRadioButton();
		siteFilter = prop.getSiteFilterInManageVisits();
		siteSearch = prop.getSiteSearchInManageVisits();
		siteSelect = prop.getSiteSelectInManageVisits();
		searchButton = prop.getSearchButton();
		addVisitBtn = prop.getAddVisitInSchedMgmt();
		loadingSpinner = prop.getLoadingSpinner();
		addVisitPopUpHeader = prop.getAddVisitPopUpHeader();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(schedMgtRadioButton)));
		Thread.sleep(2000);
		WebElement schedMgtRadioButtonEle = driver.findElement(By.xpath(schedMgtRadioButton));
		Thread.sleep(5000);
		schedMgtRadioButtonEle.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
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

		Thread.sleep(5000);
		WebElement addVisitBtnEle = driver.findElement(By.xpath(addVisitBtn));
		addVisitBtnEle.click();

		wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));

		WebElement addVisitPopUpHeaderEle = driver.findElement(By.xpath(addVisitPopUpHeader));
		if (addVisitPopUpHeaderEle.isDisplayed()) {
			System.out.println(addVisitPopUpHeaderEle.getText());
		} else {
			System.out.println("Add Visits pop-up is not opened");
		}

		Thread.sleep(2000);
		// AddVisitInSC().addVisitFromSC()
		String psNameInPopUp, psNameSearchInPopUp, psNameClick;
		String site, ps, visitDate, visitStartTime, visitEndTime;
		String serviceCode, serviceCodeSearch, serviceSelect;
		String createButton;
		String assignDCSHeader;
		String psInExcel;
		site = prop.getSiteInAddVisits();
		ps = prop.getPSInAddVisits();
		psNameSearchInPopUp = prop.getPSNameSearchInAddVisitsPopUp();
		psNameClick = prop.getPSNameClickInAddVisits();
		visitDate = prop.getVisitDateInPopUpHeader();
		visitStartTime = prop.getVisitStartTimeInAddVisits();
		visitEndTime = prop.getVisitEndTimeInAddVisits();
		serviceCode = prop.getServiceInAddVisitsPopUp();
		serviceCodeSearch = prop.getServiceSearchInAddVisitsPopUp();
		serviceSelect = prop.getServiceListInAddVisitsPopUp();
		createButton = prop.getcreateButtonInAddVisits();
		loadingSpinner = prop.getLoadingSpinner();
		assignDCSHeader = prop.getAssignDCSHeader();
		psInExcel = excel.getCellData("Add_Visit_SC", 0, 2);

		WebElement siteEle = driver.findElement(By.xpath(site));
		System.out.println(siteEle.getText());

		WebElement psEle = driver.findElement(By.xpath(ps));
		psNameInPopUp = psEle.getText();
		System.out.println(psNameInPopUp);

		WebElement psNameSearchInPopUpEle;
		WebElement psNameClickEle;

		if (psNameInPopUp.isEmpty() || psNameInPopUp == null) {
			System.out.println("PS Name field is empty");
			int retries = 5;
			while (retries > 0) {
				try {
					System.out.println("Into the while block of iteration: " + retries);
					psEle.click();
					break;
				} catch (Exception e) {
					System.out.println("Exception Occurred at the iteration: " + retries);
					
					Thread.sleep(5000);
					retries--;
				}
			}
			
			psNameSearchInPopUpEle = driver.findElement(By.xpath(psNameSearchInPopUp));
			wait.until(ExpectedConditions.visibilityOf(psNameSearchInPopUpEle));
			psNameSearchInPopUpEle.sendKeys(excel.getCellData("Add_Visit_SC", 0, 2));
			psNameClickEle = driver.findElement(By.xpath(psNameClick));
			wait.until(ExpectedConditions.visibilityOf(psNameClickEle));
			psNameClickEle.click();
		} else if (!psNameInPopUp.contentEquals(psInExcel)) {
			System.out.println("PS Name is not same as given in the Excel");
			psEle.click();
			psNameSearchInPopUpEle = driver.findElement(By.xpath(psNameSearchInPopUp));
			wait.until(ExpectedConditions.visibilityOf(psNameSearchInPopUpEle));
			psNameSearchInPopUpEle.sendKeys(excel.getCellData("Add_Visit_SC", 0, 2));
			psNameClickEle = driver.findElement(By.xpath(psNameClick));
			wait.until(ExpectedConditions.visibilityOf(psNameClickEle));
			psNameClickEle.click();
		} else {
			System.out.println("The PS is already been selected");
		}

		WebElement visitDateEle = driver.findElement(By.xpath(visitDate));
		String populatedDate = visitDateEle.getText();
		System.out.println("The populated Date is: " + populatedDate);

		if (populatedDate == null || populatedDate.isEmpty()) {
			visitDateEle.sendKeys(excel.getCellData("Add_Visit_SC", 2, 2));
		} else {
			System.out.println("Visit Date is already selected");
		}

		Thread.sleep(2000);

		WebElement visitStartTimeEle = driver.findElement(By.xpath(visitStartTime));
		visitStartTimeEle.sendKeys(excel.getCellData("Add_Visit_SC", 3, 2));

		// WebElement loadingSpinnerEle = driver.findElement(By.xpath(loadingSpinner));
		// wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));

		WebElement visitEndTimeEle = driver.findElement(By.xpath(visitEndTime));
		visitEndTimeEle.sendKeys(excel.getCellData("Add_Visit_SC", 4, 2));

		Thread.sleep(5000);
		WebElement serviceCodeEle = driver.findElement(By.xpath(serviceCode));
		serviceCodeEle.click();

		WebElement serviceCodeSearchEle = driver.findElement(By.xpath(serviceCodeSearch));
		wait.until(ExpectedConditions.visibilityOf(serviceCodeSearchEle));
		serviceCodeSearchEle.sendKeys(excel.getCellData("Add_Visit_SC", 6, 2));

		WebElement serviceSelectEle = driver.findElement(By.xpath(serviceSelect));
		wait.until(ExpectedConditions.visibilityOf(serviceSelectEle));
		serviceSelectEle.click();
		Thread.sleep(2000);

		WebElement createButtonEle = driver.findElement(By.xpath(createButton));
		
		try {
			createButtonEle.click();
			if (BaseClass.excelToWrite.setCellData("Add a visit-Schedule Management", "Status", 7, 31, BaseClass.sheetStatus)) {
				//System.out.println("Login successfully.");
			} else {
				//System.out.println("Login Failed.");
			}
			if (BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 22, BaseClass.indexStatus)) {
				EmailSender.setResult(12, BaseClass.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				EmailSender.setDateTime(12, reportDate);
				

			} else {
				//System.out.println("Login Failed.");
			}
			
		} catch (Exception e) {
			System.out.println("In catch of firefox");e.printStackTrace();
			BaseClass.sheetStatus = "Fail";
			BaseClass.indexStatus = BaseClass.sheetStatus;
			BaseClass.excelToWrite.setCellData("Add a visit-Schedule Management", "Status", 7, 31, BaseClass.sheetStatus);
			BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 22, BaseClass.indexStatus);
			EmailSender.setResult(12, BaseClass.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			EmailSender.setDateTime(12, reportDate);
			
			
		}

		// wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));
		Thread.sleep(2000);

		WebElement assignDCSHeaderEle = driver.findElement(By.xpath(assignDCSHeader));
		if (assignDCSHeaderEle.isDisplayed()) {
			System.out.println("Navigated to Assign DCS screen");
		} else {
			System.out.println("Assign DCS screen is not opened");
		}
		Thread.sleep(2000);
		// new AssignDCS().assingDCS();

		String dcsListBox, dcsListSearch, dcsListSelect;
		String checkAvailabilityButton, selectDCSRadioButton, scheduleButton;
		String successMsg, successOkBtn;
		String otHeader, otProceed;
		int flag = 0;
		loadingSpinner = prop.getLoadingSpinner();
		dcsListBox = prop.getDCSListBox();
		dcsListSearch = prop.getDCSListSearch();
		dcsListSelect = prop.getDCSListSelect();
		checkAvailabilityButton = prop.getCheckAvailabilityButton();
		selectDCSRadioButton = prop.getSelectDCSRadioButton();
		scheduleButton = prop.scheduleButton();
		otHeader = prop.getDCSOTPopupHeader();
		otProceed = prop.getDCSOTPopupProceed();
		successMsg = prop.getSuccessMsgHeader();
		successOkBtn = prop.getSuccessOkBtn();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		WebElement dcsListBoxEle = driver.findElement(By.xpath(dcsListBox));
		wait.until(ExpectedConditions.visibilityOf(dcsListBoxEle));
		dcsListBoxEle.click();

		WebElement dcsListSearchEle = driver.findElement(By.xpath(dcsListSearch));
		wait.until(ExpectedConditions.visibilityOf(dcsListSearchEle));
		dcsListSearchEle.sendKeys(excel.getCellData("AssignDCS", 0, 2));

		WebElement dcsListSelectEle = driver.findElement(By.xpath(dcsListSelect));
		wait.until(ExpectedConditions.visibilityOf(dcsListSelectEle));
		dcsListSelectEle.click();

		Thread.sleep(2000);

		WebElement checkAvailabilityButtonEle = driver.findElement(By.xpath(checkAvailabilityButton));
		wait.until(ExpectedConditions.elementToBeClickable(checkAvailabilityButtonEle));
		checkAvailabilityButtonEle.click();

		// WebElement loadingSpinnerEle = driver.findElement(By.xpath(loadingSpinner));
		wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));

		WebElement selectDCSRadioButtonEle = driver.findElement(By.xpath(selectDCSRadioButton));

		wait.until(ExpectedConditions.visibilityOf(selectDCSRadioButtonEle));
		selectDCSRadioButtonEle.click();

		driver.findElement(By.xpath(scheduleButton)).click();

		wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));

		try {
			System.out.println("In the try block of Assign DCS to check whether DCS is assigned Successfully or not");
			WebElement successMsgEle = driver.findElement(By.xpath(successMsg));
			if (successMsgEle.isDisplayed()) {
				System.out.println("DCS was assigned successfully");
				try {
					
					if (BaseClass.excelToWrite.setCellData("Assign DCS", "Status", 7, 21, BaseClass.sheetStatus)) {
						//System.out.println("Login successfully.");
					} else {
						//System.out.println("Login Failed.");
					}
					if (BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 24, BaseClass.indexStatus)) {
						
						EmailSender.setResult(13, BaseClass.indexStatus);
						DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
						Date date1 = new Date();
						String reportDate1 = df1.format(date1);
						EmailSender.setDateTime(13, reportDate1);

					} else {
						//System.out.println("Login Failed.");
					}
					
				} catch (Exception e) {
					System.out.println("In catch of firefox");e.printStackTrace();
					BaseClass.sheetStatus = "Fail";
					BaseClass.indexStatus = BaseClass.sheetStatus;
					BaseClass.excelToWrite.setCellData("Assign DCS", "Status", 7, 21, BaseClass.sheetStatus);
					BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 24, BaseClass.indexStatus);
					
					EmailSender.setResult(13, BaseClass.indexStatus);
					DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
					Date date1 = new Date();
					String reportDate1 = df1.format(date1);
					EmailSender.setDateTime(13, reportDate1);
					
				}
			}

			System.out.println();
			// driver.findElement(By.xpath(successOkBtn)).click();
			// wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));

		} catch (Exception e) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
			try {
				WebElement closeBtnAfterDCSAssigned = driver.findElement(By.xpath(prop.getCloseBAfterAssignDCS()));
				if (closeBtnAfterDCSAssigned.isDisplayed()) {
					System.out.println("Seems DCS was available to schedule. Closing the pop-up window");
					Common_Methods.clickEleBy_Xpath(prop.getCloseBAfterAssignDCS(), driver);
					System.out.println("DCS was assigned successfully");
					try {
						
						if (BaseClass.excelToWrite.setCellData("Assign DCS", "Status", 7, 21, BaseClass.sheetStatus)) {
							//System.out.println("Login successfully.");
						} else {
							//System.out.println("Login Failed.");
						}
						if (BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 24, BaseClass.indexStatus)) {
							
							EmailSender.setResult(13, BaseClass.indexStatus);
							DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
							Date date1 = new Date();
							String reportDate1 = df1.format(date1);
							EmailSender.setDateTime(13, reportDate1);

						} else {
							//System.out.println("Login Failed.");
						}
						
					} catch (Exception e1) {
						System.out.println("In catch of firefox");e1.printStackTrace();
						BaseClass.sheetStatus = "Fail";
						BaseClass.indexStatus = BaseClass.sheetStatus;
						BaseClass.excelToWrite.setCellData("Assign DCS", "Status", 7, 21, BaseClass.sheetStatus);
						BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 24, BaseClass.indexStatus);
						
						EmailSender.setResult(13, BaseClass.indexStatus);
						DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
						Date date1 = new Date();
						String reportDate1 = df1.format(date1);
						EmailSender.setDateTime(13, reportDate1);
						
					}
					flag = 1;
				}
			} catch (Exception e2) {
				System.out.println(e.getMessage());
				System.out.println("Into the Catch block, means might be navigated to OT screen");
				WebElement otHeaderEle = driver.findElement(By.xpath(otHeader));
				if (otHeaderEle.isDisplayed()) {
					System.out.println("Navigated to OT screen");

					try {
						System.out.println("Trying to hit the Proceed button if it is enabled");
						WebElement otProceedEle = driver.findElement(By.xpath(otProceed));
						otProceedEle.click();
						wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));
						WebElement successMsgEle = driver.findElement(By.xpath(successMsg));
						wait.until(ExpectedConditions.visibilityOf(successMsgEle));
						if (successMsgEle.isDisplayed()) {
							System.out.println("DCS was assigned successfully");
							try {
								
								if (BaseClass.excelToWrite.setCellData("Assign DCS", "Status", 7, 21, BaseClass.sheetStatus)) {
									//System.out.println("Login successfully.");
								} else {
									//System.out.println("Login Failed.");
								}
								if (BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 24, BaseClass.indexStatus)) {
									
									EmailSender.setResult(13, BaseClass.indexStatus);
									DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
									Date date1 = new Date();
									String reportDate1 = df1.format(date1);
									EmailSender.setDateTime(13, reportDate1);

								} else {
									//System.out.println("Login Failed.");
								}
								
							} catch (Exception e1) {
								System.out.println("In catch of firefox");e1.printStackTrace();
								BaseClass.sheetStatus = "Fail";
								BaseClass.indexStatus = BaseClass.sheetStatus;
								BaseClass.excelToWrite.setCellData("Assign DCS", "Status", 7, 21, BaseClass.sheetStatus);
								BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 24, BaseClass.indexStatus);
								
								EmailSender.setResult(13, BaseClass.indexStatus);
								DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
								Date date1 = new Date();
								String reportDate1 = df1.format(date1);
								EmailSender.setDateTime(13, reportDate1);
								
							}
						}
						System.out.println("Completed the assign DCS process in the OT try block");

					} catch (Exception ei) {
						System.out.println(ei.getMessage());
						System.out.println("It seems the user doesn't have the privilege to assign the DCS as OT");
					}
				}
			}
		}
		if (flag == 0) {
			driver.findElement(By.xpath(successOkBtn)).click();
			try {
				
				if (BaseClass.excelToWrite.setCellData("Assign DCS", "Status", 7, 21, BaseClass.sheetStatus)) {
					//System.out.println("Login successfully.");
				} else {
					//System.out.println("Login Failed.");
				}
				if (BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 24, BaseClass.indexStatus)) {
					
					EmailSender.setResult(13, BaseClass.indexStatus);
					DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
					Date date1 = new Date();
					String reportDate1 = df1.format(date1);
					EmailSender.setDateTime(13, reportDate1);

				} else {
					//System.out.println("Login Failed.");
				}
				
			} catch (Exception e) {
				System.out.println("In catch of firefox");e.printStackTrace();
				BaseClass.sheetStatus = "Fail";
				BaseClass.indexStatus = BaseClass.sheetStatus;
				BaseClass.excelToWrite.setCellData("Assign DCS", "Status", 7, 21, BaseClass.sheetStatus);
				BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 24, BaseClass.indexStatus);
				
				EmailSender.setResult(13, BaseClass.indexStatus);
				DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date1 = new Date();
				String reportDate1 = df1.format(date1);
				EmailSender.setDateTime(13, reportDate1);
				
			}
		}
		wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));
	}
}
