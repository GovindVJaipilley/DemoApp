package SchedulingCalendar;

import java.awt.Robot;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

public class Schedule_Criteria {
	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	String scheduleCriteriaButton, scheduleCriteriaHeader;
	String scheduleCriteriaQualification, scheduleCreteriaQualChecked;
	String scheduleCriteriaPreferences, scheduleCreteriaPrefChecked;
	String scheduleCriteriaScheduledDCS, scheduleCreteriaSchedDCSChecked;
	String scheduleCriteriaPreviouslyServedPS, scheduleCreteriaPrevServChecked;
	String scheduleCriteriaSharedDCS, scheduleCreteriaSharedChecked;
	String scheduleCriteriaGetPreferredDCS, scheduleCreteriaPrefDCSChecked;
	String scheduleCriteriaGetUnAvailableDCS, scheduleCreteriaUnAvailDCSChecked;
	String scheduleCriteriaDoNotUseUnPreferredDCS, scheduleCreteriaUnPrefDCSChecked;
	String scheduleCriteriaGetFamilyServingFamilyDCS, scheduleCreteriaFamilyServChecked;
	String scheduleCriteriaSave, scheduleCriteriaSuccess, scheduleCriteriaSuccessOkBtn;
	String loadingSpinner;

	@BeforeTest
	public void driversForScheduleCriteria() throws IOException {
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
	public void updateScheduleCriteria() throws InterruptedException {

		scheduleCriteriaButton = prop.getScheduleCriteriaButton();
		scheduleCriteriaHeader = prop.getScheduleCriteriaHeader();
		scheduleCriteriaQualification = prop.getScheduleCriteriaQualification();
		scheduleCreteriaQualChecked = prop.getScheduleCreteriaQualChecked();
		scheduleCriteriaPreferences = prop.getScheduleCriteriaPreferences();
		scheduleCreteriaPrefChecked = prop.getScheduleCreteriaPrefChecked();
		scheduleCriteriaScheduledDCS = prop.getScheduleCriteriaScheduledDCS();
		scheduleCreteriaSchedDCSChecked = prop.getScheduleCreteriaSchedDCSChecked();
		scheduleCriteriaPreviouslyServedPS = prop.getScheduleCriteriaPreviouslyServedPS();
		scheduleCreteriaPrevServChecked = prop.getScheduleCreteriaPrevServChecked();
		scheduleCriteriaSharedDCS = prop.getScheduleCriteriaSharedDCS();
		scheduleCreteriaSharedChecked = prop.getScheduleCreteriaSharedChecked();
		scheduleCriteriaGetPreferredDCS = prop.getScheduleCriteriaGetPreferredDCS();
		scheduleCreteriaPrefDCSChecked = prop.getScheduleCreteriaPrefDCSChecked();
		scheduleCriteriaGetUnAvailableDCS = prop.getScheduleCriteriaGetUnAvailableDCS();
		scheduleCreteriaUnAvailDCSChecked = prop.getScheduleCreteriaUnAvailDCSChecked();
		scheduleCriteriaDoNotUseUnPreferredDCS = prop.getScheduleCriteriaDoNotUseUnPreferredDCS();
		scheduleCreteriaUnPrefDCSChecked = prop.getScheduleCreteriaUnPrefDCSChecked();
		scheduleCriteriaGetFamilyServingFamilyDCS = prop.getScheduleCriteriaGetFamilyServingFamilyDCS();
		scheduleCreteriaFamilyServChecked = prop.getScheduleCreteriaFamilyServChecked();
		scheduleCriteriaSave = prop.getScheduleCriteriaSave();
		scheduleCriteriaSuccess = prop.getSuccessMsgHeader();
		scheduleCriteriaSuccessOkBtn=prop.getSuccessOkBtn();
		loadingSpinner = prop.getLoadingSpinner();

		// Schedule Criteria preferences by the user - Taking from the excel sheet
		String qualificationVal = excel.getCellData("ScheduleCriteria", 0, 2);
		String preferencesVal = excel.getCellData("ScheduleCriteria", 1, 2);
		String scheduledDCSVal = excel.getCellData("ScheduleCriteria", 2, 2);
		String previouslyServedPSVal = excel.getCellData("ScheduleCriteria", 3, 2);
		String sharedDCSVal = excel.getCellData("ScheduleCriteria", 4, 2);
		String getPreferredDCSVal = excel.getCellData("ScheduleCriteria", 5, 2);
		String getUnAvailableDCSVal = excel.getCellData("ScheduleCriteria", 6, 2);
		String doNotUseUnPreferredDCSVal = excel.getCellData("ScheduleCriteria", 7, 2);
		String getFamilyServingFamilyDCSVal = excel.getCellData("ScheduleCriteria", 8, 2);

		List<String> scheduleCriteriaList = new ArrayList<>();

		scheduleCriteriaList.add("qualification");
		scheduleCriteriaList.add("preferences");
		scheduleCriteriaList.add("scheduledDCS");
		scheduleCriteriaList.add("previouslyServedPS");
		scheduleCriteriaList.add("sharedDCS");
		scheduleCriteriaList.add("getPreferredDCS");
		scheduleCriteriaList.add("getUnAvailableDCS");
		scheduleCriteriaList.add("doNotUseUnPreferredDCS");
		scheduleCriteriaList.add("getFamilyServingFamilyDCS");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		WebElement scheduleCriteriaButtonEle = driver.findElement(By.xpath(scheduleCriteriaButton));
		
		int retries = 5;
		while (retries > 0) {
			try {
				System.out.println("Into the while block of iteration: " + retries);
				wait.until(ExpectedConditions.elementToBeClickable(scheduleCriteriaButtonEle));
				scheduleCriteriaButtonEle.click();
				break;
			} catch (Exception e) {
				System.out.println("Exception Occurred at the iteration: " + retries);

				Thread.sleep(5000);
				retries--;
			}
		}

		WebElement scheduleCriteriaHeaderEle = driver.findElement(By.xpath(scheduleCriteriaHeader));
		wait.until(ExpectedConditions.visibilityOf(scheduleCriteriaHeaderEle));
		System.out.println("The header of the Schedule Criteria is: " + scheduleCriteriaHeaderEle.getText());

		for (String criteria : scheduleCriteriaList) {

			if(criteria.equalsIgnoreCase("qualification")) {
				try {
					WebElement scheduleCreteriaQualCheckedEle = driver.findElement(By.xpath(scheduleCreteriaQualChecked));
					if (scheduleCreteriaQualCheckedEle.isDisplayed() && qualificationVal.equalsIgnoreCase("No")) {
						scheduleCreteriaQualCheckedEle.click();
					} else {
						System.out.println("Qualification is already selected");
					}
				} catch (Exception e) {
					e.printStackTrace();
					WebElement scheduleCriteriaQualificationEle = driver.findElement(By.xpath(scheduleCriteriaQualification));
					if (scheduleCriteriaQualificationEle.isDisplayed() && qualificationVal.equalsIgnoreCase("Yes")) {
						scheduleCriteriaQualificationEle.click();
					} else {
						System.out.println("Qualification value is already un-checked");
					}
				}
			}
			
			if(criteria.equalsIgnoreCase("preferences")) {
				try {
					WebElement scheduleCreteriaPrefCheckedEle = driver.findElement(By.xpath(scheduleCreteriaPrefChecked));
					if (scheduleCreteriaPrefCheckedEle.isDisplayed() && preferencesVal.equalsIgnoreCase("No")) {
						scheduleCreteriaPrefCheckedEle.click();
					} else {
						System.out.println("Preferences is already selected");
					}
				} catch (Exception e) {
					e.printStackTrace();
					WebElement scheduleCriteriaPreferencesEle = driver.findElement(By.xpath(scheduleCriteriaPreferences));
					if (scheduleCriteriaPreferencesEle.isDisplayed() && preferencesVal.equalsIgnoreCase("Yes")) {
						scheduleCriteriaPreferencesEle.click();
					} else {
						System.out.println("Preferences value is already un-checked");
					}
				}
			}
			
			if(criteria.equalsIgnoreCase("scheduledDCS")) {
				try {
					WebElement scheduleCreteriaSchedDCSCheckedEle = driver.findElement(By.xpath(scheduleCreteriaSchedDCSChecked));
					if (scheduleCreteriaSchedDCSCheckedEle.isDisplayed() && scheduledDCSVal.equalsIgnoreCase("No")) {
						scheduleCreteriaSchedDCSCheckedEle.click();
					} else {
						System.out.println("Scheduled DCS is already selected");
					}
				} catch (Exception e) {
					e.printStackTrace();
					WebElement scheduleCriteriaScheduledDCSEle = driver.findElement(By.xpath(scheduleCriteriaScheduledDCS));
					if (scheduleCriteriaScheduledDCSEle.isDisplayed() && scheduledDCSVal.equalsIgnoreCase("Yes")) {
						scheduleCriteriaScheduledDCSEle.click();
					} else {
						System.out.println("Scheduled DCS value is already un-checked");
					}
				}
			}
			
			if(criteria.equalsIgnoreCase("previouslyServedPS")) {
				try {
					WebElement scheduleCreteriaPrevServCheckedEle = driver.findElement(By.xpath(scheduleCreteriaPrevServChecked));
					if (scheduleCreteriaPrevServCheckedEle.isDisplayed() && previouslyServedPSVal.equalsIgnoreCase("No")) {
						scheduleCreteriaPrevServCheckedEle.click();
					} else {
						System.out.println("Previously Served PS is already selected");
					}
				} catch (Exception e) {
					e.printStackTrace();
					WebElement scheduleCriteriaPreviouslyServedPSEle = driver.findElement(By.xpath(scheduleCriteriaPreviouslyServedPS));
					if (scheduleCriteriaPreviouslyServedPSEle.isDisplayed() && previouslyServedPSVal.equalsIgnoreCase("Yes")) {
						scheduleCriteriaPreviouslyServedPSEle.click();
					} else {
						System.out.println("Previously Served PS value is already un-checked");
					}
				}
			}
			
			if(criteria.equalsIgnoreCase("sharedDCS")) {
				try {
					WebElement scheduleCreteriaSharedCheckedEle = driver.findElement(By.xpath(scheduleCreteriaSharedChecked));
					if (scheduleCreteriaSharedCheckedEle.isDisplayed() && sharedDCSVal.equalsIgnoreCase("No")) {
						scheduleCreteriaSharedCheckedEle.click();
					} else {
						System.out.println("Shared DCS is already selected");
					}
				} catch (Exception e) {
					e.printStackTrace();
					WebElement scheduleCriteriaSharedDCSEle = driver.findElement(By.xpath(scheduleCriteriaSharedDCS));
					if (scheduleCriteriaSharedDCSEle.isDisplayed() && sharedDCSVal.equalsIgnoreCase("Yes")) {
						scheduleCriteriaSharedDCSEle.click();
					} else {
						System.out.println("Shared DCS value is already un-checked");
					}
				}
			}
			
			if(criteria.equalsIgnoreCase("getPreferredDCS")) {
				try {
					WebElement scheduleCreteriaPrefDCSCheckedEle = driver.findElement(By.xpath(scheduleCreteriaPrefDCSChecked));
					if (scheduleCreteriaPrefDCSCheckedEle.isDisplayed() && getPreferredDCSVal.equalsIgnoreCase("No")) {
						scheduleCreteriaPrefDCSCheckedEle.click();
					} else {
						System.out.println("Get Preferred DCS is already selected");
					}
				} catch (Exception e) {
					e.printStackTrace();
					WebElement scheduleCriteriaGetPreferredDCSEle = driver.findElement(By.xpath(scheduleCriteriaGetPreferredDCS));
					if (scheduleCriteriaGetPreferredDCSEle.isDisplayed() && getPreferredDCSVal.equalsIgnoreCase("Yes")) {
						scheduleCriteriaGetPreferredDCSEle.click();
					} else {
						System.out.println("Get Preferred DCS value is already un-checked");
					}
				}
			}
			
			if(criteria.equalsIgnoreCase("getUnAvailableDCS")) {
				try {
					WebElement scheduleCreteriaUnAvailDCSCheckedEle = driver.findElement(By.xpath(scheduleCreteriaUnAvailDCSChecked));
					if (scheduleCreteriaUnAvailDCSCheckedEle.isDisplayed() && getUnAvailableDCSVal.equalsIgnoreCase("No")) {
						scheduleCreteriaUnAvailDCSCheckedEle.click();
					} else {
						System.out.println("Get UnAvailable DCS is already selected");
					}
				} catch (Exception e) {
					e.printStackTrace();
					WebElement scheduleCriteriaGetUnAvailableDCSEle = driver.findElement(By.xpath(scheduleCriteriaGetUnAvailableDCS));
					if (scheduleCriteriaGetUnAvailableDCSEle.isDisplayed() && getUnAvailableDCSVal.equalsIgnoreCase("Yes")) {
						scheduleCriteriaGetUnAvailableDCSEle.click();
					} else {
						System.out.println("Get UnAvailable DCS value is already un-checked");
					}
				}
			}
			
			if(criteria.equalsIgnoreCase("doNotUseUnPreferredDCS")) {
				try {
					WebElement scheduleCreteriaUnPrefDCSCheckedEle = driver.findElement(By.xpath(scheduleCreteriaUnPrefDCSChecked));
					if (scheduleCreteriaUnPrefDCSCheckedEle.isDisplayed() && doNotUseUnPreferredDCSVal.equalsIgnoreCase("No")) {
						scheduleCreteriaUnPrefDCSCheckedEle.click();
					} else {
						System.out.println("Do Not Use Un Preferred DCS is already selected");
					}
				} catch (Exception e) {
					e.printStackTrace();
					WebElement scheduleCriteriaDoNotUseUnPreferredDCSEle = driver.findElement(By.xpath(scheduleCriteriaDoNotUseUnPreferredDCS));
					if (scheduleCriteriaDoNotUseUnPreferredDCSEle.isDisplayed() && doNotUseUnPreferredDCSVal.equalsIgnoreCase("Yes")) {
						scheduleCriteriaDoNotUseUnPreferredDCSEle.click();
					} else {
						System.out.println("Do Not Use Un Preferred DCS value is already un-checked");
					}
				}
			}
			
			if(criteria.equalsIgnoreCase("getFamilyServingFamilyDCS")) {
				try {
					WebElement scheduleCreteriaFamilyServCheckedEle = driver.findElement(By.xpath(scheduleCreteriaFamilyServChecked));
					if (scheduleCreteriaFamilyServCheckedEle.isDisplayed() && getFamilyServingFamilyDCSVal.equalsIgnoreCase("No")) {
						scheduleCreteriaFamilyServCheckedEle.click();
					} else {
						System.out.println("Get Family Serving Family DCS is already selected");
					}
				} catch (Exception e) {
					e.printStackTrace();
					WebElement scheduleCriteriaGetFamilyServingFamilyDCSEle = driver.findElement(By.xpath(scheduleCriteriaGetFamilyServingFamilyDCS));
					if (scheduleCriteriaGetFamilyServingFamilyDCSEle.isDisplayed() && getFamilyServingFamilyDCSVal.equalsIgnoreCase("Yes")) {
						scheduleCriteriaGetFamilyServingFamilyDCSEle.click();
					} else {
						System.out.println("Get Family Serving Family DCS value is already un-checked");
					}
				}
			}
			
		}
		
		driver.findElement(By.xpath(scheduleCriteriaSave)).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(loadingSpinner))));
		
		try {
			WebElement scheduleCriteriaSuccessEle = driver.findElement(By.xpath(scheduleCriteriaSuccess));
			if(scheduleCriteriaSuccessEle.isDisplayed()) {
				System.out.println("Scheduled Criteria is saved successfully");
				driver.findElement(By.xpath(scheduleCriteriaSuccessOkBtn)).click();
			}
		}catch(Exception e) {
			System.out.println("It seems Scheduled Criteria is not saved");
		}
		
		Thread.sleep(2000);
		
	}
}
