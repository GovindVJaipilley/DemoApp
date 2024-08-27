package RecurringVisits;

import java.awt.Robot;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class CreateRecuVisits {
	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	JavascriptExecutor js;
	//String path = "C:\\POC-Automation\\TestData.xlsx";
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	// String CreateRecurringVisitsHeader;
	String recuStartDate, recuEndDate;
	String weeklyRadio, quickEntryRadio, monthlyRadio;
	String weeklyRadioSelected, quickEntryRadioSelected, monthlyRadioSelected;
	String everyText;
	String sundayST, sundayET, mondayST, mondayET, tuesdayET, tuesdayST, wednesdayST, wednesdayET, thursdayST,
			thursdayET, fridayST, fridayET, saturdayST, saturdayET;
	List<String> requiredDays;
	String searchDCS, firstDCS, targetToDropDCS, dcsRightMove, dcsAutoExtendSelect;
	String allowOverBook, overServedPopUp, overServedOKButton, createButton;
	String loadingSpinner;
	String visitSummPage, closeAtVisitSumm;
	String schedCalendarHeader;

	@BeforeTest
	public void driversForCreateRecuVisits() throws IOException {
		driver = BaseClass.getDriver();
		path = BaseClass.getTestDataPath();
		wait = BaseClass.getWebDriverWait();
		myActions = BaseClass.getDriverActions();
		robot = BaseClass.getRobot();
		js = BaseClass.getJSExecutor();
		prop = new ReadPropFile();
		excel = new ExcelRead(path);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		BaseClass.sheetStatus = "Pass";
	}

	@Test
	public void createRecurrVisits() throws InterruptedException {
		// CreateRecurringVisitsHeader = prop.getCreateRecurringVisitHeader();
		recuStartDate = prop.getRecuStartDate();
		recuEndDate = prop.getRecuEndDate();
		weeklyRadio = prop.getWeeklyRadio();
		quickEntryRadio = prop.getQuickEntryRadio();
		monthlyRadio = prop.getMonthlyRadio();
		everyText = prop.getEveryText();
		sundayST = prop.getSundayST();
		sundayET = prop.getSundayET();
		mondayST = prop.getMondayST();
		mondayET = prop.getMondayET();
		tuesdayET = prop.getTuesdayET();
		tuesdayST = prop.getTuesdayST();
		wednesdayST = prop.getWednesdayST();
		wednesdayET = prop.getWednesdayET();
		thursdayST = prop.getThursdayST();
		thursdayET = prop.getThursdayET();
		fridayST = prop.getFridayST();
		fridayET = prop.getFridayET();
		saturdayST = prop.getSaturdayST();
		saturdayET = prop.getSaturdayET();
		firstDCS = prop.getFirstDCS();
		targetToDropDCS = prop.getTargetToDropDCS();
		dcsRightMove = prop.getDCSRightMove();
		dcsAutoExtendSelect = prop.getDCSAutoExtendSelect();
		createButton = prop.getCreateButton();
		weeklyRadioSelected = prop.getWeeklyRadioSelected();
		quickEntryRadioSelected = prop.getQuickEntryRadioSelected();
		monthlyRadioSelected = prop.getMonthlyRadioSelected();
		searchDCS = prop.getSearchDCS();
		loadingSpinner = prop.getLoadingSpinner();
		visitSummPage = prop.getVisitSummPage();
		closeAtVisitSumm = prop.getCloseAtVisitSumm();
		schedCalendarHeader = prop.getSchedCalendarHeader();
		dcsAutoExtendSelect = prop.getDCSAutoExtendSelect();
		allowOverBook = prop.getAllowOverBookText();
		overServedPopUp = prop.getOverServedPopUp();
		overServedOKButton = prop.getOverServedOKButton();

		WebElement recuStartDateEle = driver.findElement(By.xpath(recuStartDate));
		wait.until(ExpectedConditions.visibilityOf(recuStartDateEle));
		recuStartDateEle.sendKeys(excel.getCellData("CreateRecurringVisits", 1, 2));
		WebElement recuEndDateEle = driver.findElement(By.xpath(prop.getRecuEndDate()));
		recuEndDateEle.sendKeys(excel.getCellData("CreateRecurringVisits", 2, 2));

		WebElement loadingSpinnerEle = driver.findElement(By.xpath(loadingSpinner));
		wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));
		Thread.sleep(2000);

		Thread.sleep(2000);
		WebElement weeklyRadioEle = driver.findElement(By.xpath(weeklyRadio));
		wait.until(ExpectedConditions.visibilityOf(weeklyRadioEle));

		WebElement quickEntryRadioEle = driver.findElement(By.xpath(quickEntryRadio));
		WebElement monthlyRadioEle = driver.findElement(By.xpath(monthlyRadio));

		String limit = excel.getCellData("CreateRecurringVisits", 3, 2);
		if (limit.equalsIgnoreCase("Weekly")) {
			WebElement weeklyRadioSelectedEle;
			try {
				weeklyRadioSelectedEle = driver.findElement(By.xpath(weeklyRadioSelected));
				if (weeklyRadioSelectedEle.isDisplayed()) {
					System.out.println("Weekly radio button is already selected");
				}
			} catch (NoSuchElementException nse) {
				System.out.println("Weekly radio button is not selected. In NSE catch block");
				weeklyRadioEle.click();
			} catch (Exception e) {
				System.out.println("Weekly radio button is not selected. In E catch block");
				weeklyRadioEle.click();
			}
			driver.findElement(By.xpath(everyText)).sendKeys(excel.getCellData("CreateRecurringVisits", 4, 2));
			Thread.sleep(5000);

			String requiredDaysData = excel.getCellData("CreateRecurringVisits", 5, 2);
			System.out.println("Days String: " + requiredDaysData);
			List<String> requiredDays = Arrays.asList(requiredDaysData.split(","));
			System.out.println("List of Days: " + requiredDays);
			System.out.println(requiredDays.size());

			for (String day : requiredDays) {
				if (day.equalsIgnoreCase("Sunday")) {
					driver.findElement(By.xpath(sundayST)).sendKeys(excel.getCellData("CreateRecurringVisits", 6, 2));
					driver.findElement(By.xpath(sundayET)).sendKeys(excel.getCellData("CreateRecurringVisits", 7, 2));
				} else if (day.equalsIgnoreCase("Monday")) {
					driver.findElement(By.xpath(mondayST)).sendKeys(excel.getCellData("CreateRecurringVisits", 8, 2));
					driver.findElement(By.xpath(mondayET)).sendKeys(excel.getCellData("CreateRecurringVisits", 9, 2));
				} else if (day.equalsIgnoreCase("Tuesday")) {
					driver.findElement(By.xpath(tuesdayST)).sendKeys(excel.getCellData("CreateRecurringVisits", 10, 2));
					driver.findElement(By.xpath(tuesdayET)).sendKeys(excel.getCellData("CreateRecurringVisits", 11, 2));
				} else if (day.equalsIgnoreCase("Wednesday")) {
					driver.findElement(By.xpath(wednesdayST))
							.sendKeys(excel.getCellData("CreateRecurringVisits", 12, 2));
					driver.findElement(By.xpath(wednesdayET))
							.sendKeys(excel.getCellData("CreateRecurringVisits", 13, 2));
				} else if (day.equalsIgnoreCase("Thursday")) {
					driver.findElement(By.xpath(thursdayST))
							.sendKeys(excel.getCellData("CreateRecurringVisits", 14, 2));
					driver.findElement(By.xpath(thursdayET))
							.sendKeys(excel.getCellData("CreateRecurringVisits", 15, 2));
				} else if (day.equalsIgnoreCase("Friday")) {
					driver.findElement(By.xpath(fridayST)).sendKeys(excel.getCellData("CreateRecurringVisits", 16, 2));
					driver.findElement(By.xpath(fridayET)).sendKeys(excel.getCellData("CreateRecurringVisits", 17, 2));
				} else if (day.equalsIgnoreCase("Saturday")) {
					driver.findElement(By.xpath(saturdayST))
							.sendKeys(excel.getCellData("CreateRecurringVisits", 18, 2));
					driver.findElement(By.xpath(saturdayET))
							.sendKeys(excel.getCellData("CreateRecurringVisits", 19, 2));
				}

			}

		} else if (limit.equalsIgnoreCase("Quick Entry")) {
			WebElement quickEntryRadioSelectedEle;
			try {
				quickEntryRadioSelectedEle = driver.findElement(By.xpath(quickEntryRadioSelected));
				if (quickEntryRadioSelectedEle.isDisplayed()) {
					System.out.println("Quick Entry radio button is already selected");
				}
			} catch (NoSuchElementException nse) {
				System.out.println("Quick Entry radio button is not selected. In NSE catch block");
				quickEntryRadioEle.click();
			} catch (Exception e) {
				System.out.println("Quick Entry radio button is not selected. In E catch block");
				quickEntryRadioEle.click();
			}
		} else if (limit.equalsIgnoreCase("Monthly")) {
			WebElement monthlyRadioSelectedEle;

			try {
				monthlyRadioSelectedEle = driver.findElement(By.xpath(monthlyRadioSelected));
				if (monthlyRadioSelectedEle.isDisplayed()) {
					System.out.println("Monthly radio button is already selected");
				}
			} catch (NoSuchElementException nse) {
				System.out.println("Quick Entry radio button is not selected. In NSE catch block");
				monthlyRadioEle.click();
			} catch (Exception e) {
				System.out.println("Quick Entry radio button is not selected. In E catch block");
				monthlyRadioEle.click();
			}
		}

		// js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// Thread.sleep(2000);

		WebElement searchDCSEle = driver.findElement(By.xpath(searchDCS));

		String requiredDCS = excel.getCellData("CreateRecurringVisits", 24, 2);
		System.out.println("DCS String: " + requiredDCS);
		List<String> requiredDCSList = Arrays.asList(requiredDCS.split(","));
		System.out.println("List of Days: " + requiredDCSList);
		System.out.println(requiredDCSList.size());

		// WebElement selectedListArea = driver.findElement(By.xpath(targetToDropDCS));
		WebElement dcsRightMoveEle = driver.findElement(By.xpath(dcsRightMove));

		// WebElement allowOverBookEle = driver.findElement(By.xpath(allowOverBook));
		/*
		 * if(allowOverBookEle.isDisplayed()) {
		 * System.out.println("Scrolling has done successfully"); } else {
		 * System.out.println("Scrolling has not done"); }
		 */
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		for (String dcs : requiredDCSList) {
			searchDCSEle.sendKeys(dcs);
			Thread.sleep(2000);
			// robot.mouseMove(1200, 650);
			// robot.mousePress(InputEvent.BUTTON1_MASK);
			// robot.mouseRelease(InputEvent.BUTTON1_MASK);
			// Thread.sleep(3000);
			WebElement firstDCSEle = driver.findElement(By.xpath(firstDCS));
			// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(firstDCS)));
			// Thread.sleep(2000);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(2000);
			int retries = 5;
			while (retries > 0) {
				try {
					System.out.println("Into the while block of iteration: " + retries);
					robot.mouseWheel(5);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(firstDCS)));
					Thread.sleep(2000);
					firstDCSEle.click();
					break;
				} catch (Exception e) {
					System.out.println("Exception Occurred at the iteration: " + retries);
					// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getDcsPhone3DdArrow())));
					Thread.sleep(2000);
					retries--;
				}
			}

			Thread.sleep(2000);
			dcsRightMoveEle.click();
			// myActions.dragAndDrop(firstDCSEle, selectedListArea).build().perform();
			Thread.sleep(2000);
			searchDCSEle.clear();
			Thread.sleep(3000);
		}

		dcsAutoExtendSelect = prop.getDCSAutoExtendSelect();

		driver.findElement(By.xpath(dcsAutoExtendSelect)).click();
		Thread.sleep(2000);

		WebElement createButtonEle = driver.findElement(By.xpath(createButton));
		wait.until(ExpectedConditions.elementToBeClickable(createButtonEle));
		createButtonEle.click();
		// WebElement loadingSpinnerEle = driver.findElement(By.xpath(loadingSpinner));
		wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));
		Thread.sleep(3000);
		/*
		if(driver.findElement(By.xpath("//div[contains(text(),'over served visits')]")).isDisplayed()) {
			System.out.println("Overserve pop-up is displayed");
			System.out.println("Overservice message is: " + driver.findElement(By.xpath(overServedPopUp)).getText());
			driver.findElement(By.xpath(overServedOKButton)).click();
			wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));
		} else if(driver.findElement(By.xpath(visitSummPage)).isDisplayed())
		{
			System.out.println("Recurring visits are being created");
		} else {
			System.out.println("Neither recurring visits nor overserve visits are created");
		}
		*/
		
		try {
			// overServedPopUp = prop.getOverServedPopUp();
			// overServedOKButton = prop.getOverServedOKButton();
			System.out.println("In try block");
			WebElement overServedPopUpEle = driver.findElement(By.xpath("//div[contains(text(),'over served visits')]"));
			wait.until(ExpectedConditions.visibilityOf(overServedPopUpEle));
			String overServeMessage = overServedPopUpEle.getText();
			
			if (overServedPopUpEle.isDisplayed()) {
				System.out.println(overServeMessage);
				driver.findElement(By.xpath("//button[text()='OK']")).click();
				wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));
			}

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Recurring visits are not being overserved");
		}
		
		WebElement visitSummPageEle = driver.findElement(By.xpath(visitSummPage));
		wait.until(ExpectedConditions.visibilityOf(visitSummPageEle));

		if (visitSummPageEle.isDisplayed()) {
			System.out.println("Recurring Visits created successfully");
		} else {
			System.out.println("Recurring Visits are not created");
		}
		
		
		WebElement closeAtVisitSummEle = driver.findElement(By.xpath(closeAtVisitSumm));
		closeAtVisitSummEle.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingSpinnerEle));

		WebElement schedCalendarHeaderEle = driver.findElement(By.xpath(schedCalendarHeader));
		if (schedCalendarHeaderEle.isDisplayed()) {
			System.out.println("Navigated to Scheduling Calendar successfully");
			System.out.println(schedCalendarHeaderEle.getText());
			try {
				
				if (BaseClass.excelToWrite.setCellData("Create Recurring Visits", "Status", 7, 21, BaseClass.sheetStatus)) {
					//System.out.println("Login successfully.");
				} else {
					//System.out.println("Login Failed.");
				}
				if (BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 18, BaseClass.indexStatus)) {
					EmailSender.setResult(9, BaseClass.indexStatus);
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
					Date date = new Date();
					String reportDate = df.format(date);
					EmailSender.setDateTime(9, reportDate);

				} else {
					//System.out.println("Login Failed.");
				}
				
			} catch (Exception e) {
				System.out.println("In catch of firefox");e.printStackTrace();
				BaseClass.sheetStatus = "Fail";
				BaseClass.indexStatus = BaseClass.sheetStatus;
				BaseClass.excelToWrite.setCellData("Create Recurring Visits", "Status", 7, 21, BaseClass.sheetStatus);
				BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 18, BaseClass.indexStatus);
				EmailSender.setResult(9, BaseClass.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				EmailSender.setDateTime(9, reportDate);
				
			}
			
		} else {
			System.out.println("Unable to navigate to Scheduling Calendar");
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
	}
}
