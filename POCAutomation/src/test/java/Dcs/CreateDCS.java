package Dcs;

import java.awt.Robot;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginPage.BaseClass;
import ReportMail.EmailSender;
import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class CreateDCS {
	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	
	//String path = "C:\\POC-Automation\\TestData.xlsx";
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	
	String flyoutMenuClick, flyoutCreateDCSClick, dcsListingClick, SalutationDdArrowClick, SalutationDdUL, LoadingSpinner;
	JavascriptExecutor js;
	@BeforeTest
	public void allProps() throws Exception 
	{
		driver = BaseClass.getDriver();
		path = BaseClass.getTestDataPath();
		wait = BaseClass.getWebDriverWait();
		myActions = BaseClass.getDriverActions();
		robot = BaseClass.getRobot();
		prop = new ReadPropFile();
		js = BaseClass.getJSExecutor();
		excel = new ExcelRead(path);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		BaseClass.sheetStatus = "Pass";
	}
	
	@Test(dependsOnMethods = "LoginPage.LoginTest.loginLite")
	public void navigateToDcsListing()  {
		System.out.println("In Dcs Listing");
		Common_Methods.navigateToDcsListingInCommon_Methods(driver, prop, wait);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
	}
	
	@Test(dependsOnMethods="navigateToDcsListing")
	public void navigateToCreateDCS() 
	{
		System.out.println("In navigateToCreateDCS");
		flyoutMenuClick = prop.getFlyoutMenu();
		flyoutCreateDCSClick = prop.getflyoutCreateDCSXpath();
		
		myActions.moveToElement(driver.findElement(By.xpath(flyoutMenuClick))).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(flyoutCreateDCSClick)));
		driver.findElement(By.xpath(flyoutCreateDCSClick)).click();
		
	}
	@Test(dependsOnMethods="navigateToCreateDCS")
	public void createDcs_BasicDetails() throws Exception
	{
		System.out.println("In createDcs_BasicDetails");
		SalutationDdArrowClick = prop.getSalutationDdArrow();
		SalutationDdUL = prop.getSalutationDdUL();
		LoadingSpinner = prop.getLoadingSpinner();
		System.out.println("SalutationDdUL "+SalutationDdUL);
	//CreateDcs_BasicDetails	
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LoadingSpinner)));
		Common_Methods.clickEleBy_Xpath(SalutationDdArrowClick, driver);
		Common_Methods.selectFormDropdown(SalutationDdUL, driver, excel.getCellData("CreateDcs_BasicDetails", 0, 2));
		Common_Methods.enterDataToTextField_Xpath((prop.getDcsLastName()), driver, excel.getCellData("CreateDcs_BasicDetails", 1, 2));
		Common_Methods.enterDataToTextField_Xpath((prop.getDcsFirstName()), driver, excel.getCellData("CreateDcs_BasicDetails", 2, 2));
		Common_Methods.enterDataToTextField_Xpath((prop.getDcsMiddleName()), driver, excel.getCellData("CreateDcs_BasicDetails", 3, 2));
		Common_Methods.enterDataToTextField_Xpath((prop.getDcsPreferredName()), driver, excel.getCellData("CreateDcs_BasicDetails", 4, 2));
		Common_Methods.clickEleBy_Xpath(prop.getMappedSitesDdArrow(), driver);
		Common_Methods.select_Mapped_Sites(excel.getCellData("CreateDcs_BasicDetails", 5, 2), driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getMappedSitesDdCross(), driver);
		//System.out.println(excel.getCellData("CreateDcs_BasicDetails", 9, 2));
		Common_Methods.change_Home_Site(excel.getCellData("CreateDcs_BasicDetails", 8, 2), driver, prop);
		Common_Methods.clickEleBy_Xpath(prop.getDcsDob(), driver);
		Common_Methods.selectMonthAndYearInDate(excel.getCellData("CreateDcs_BasicDetails", 10, 2), excel.getCellData("CreateDcs_BasicDetails", 9, 2), prop.getmonthTable(), driver, prop);
		Common_Methods.selectDayInDate(excel.getCellData("CreateDcs_BasicDetails", 11, 2), prop.getdayTable(), driver);
		//System.out.println(excel1.getData("CreateDcs_BasicDetails", 1, 6));
		//Common_Methods.enterDataToTextField_Xpath(prop.getDcsDob(), driver, excel1.getData("CreateDcs_BasicDetails", 1, 6));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getGenderDdArrow())));
		Common_Methods.clickEleBy_Xpath(prop.getGenderDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getGenderDdUl(), driver, excel.getCellData("CreateDcs_BasicDetails", 6, 2));
		//Common_Methods.clickOnRadio(excel.getCellData("CreateDcs_BasicDetails", 7, 2), driver, prop.getRadioParantDiv());
		Common_Methods.clickEleBy_Css(prop.getNASSNRadio(), driver);
		//System.out.println("CreateDcs"+excel.getCellData("CreateDcs_BasicDetails", 11, 2));
		//System.out.println(excel.getCellData("CreateDcs_BasicDetails", 10, 2)+excel.getCellData("CreateDcs_BasicDetails", 9, 2));
		
	//CreateDcs_Address
		Common_Methods.clickEleBy_Xpath(prop.getDcsLocDdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getDcsLocDdUl(), driver, excel.getCellData("CreateDcs_Address", 0, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getDcsAddL1(), driver, excel.getCellData("CreateDcs_Address", 1, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getDcsAddL2(), driver, excel.getCellData("CreateDcs_Address", 2, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getDcsZip(), driver, excel.getCellData("CreateDcs_Address", 3, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getDcsZip4(), driver, excel.getCellData("CreateDcs_Address", 4, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getDcsDirections(), driver, excel.getCellData("CreateDcs_Address", 6, 2));
		//Common_Methods.clickEleBy_Xpath(prop.getDcsPhone1DdArrow(), driver);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LoadingSpinner)));
		
		Common_Methods.clickEleBy_Xpath(prop.getDcsPhone1DdArrow(), driver);
		Common_Methods.selectFormDropdown(prop.getPhone1DdUl(), driver, excel.getCellData("CreateDcs_Address", 7, 2));
		//System.out.println(excel.getCellData("CreateDcs_Address", 8, 2));
		
		int retries = 5;
		while (retries > 0) {
			try {
				System.out.println("Into the while block of iteration: " + retries);
				//Common_Methods.enterDataToTextField_Xpath(prop.getPhone1num(), driver, excel.getCellData("CreateDcs_Address", 8, 2));
				//driver.findElement(By.xpath(prop.getPhone1num())).sendKeys(excel.getCellData("CreateDcs_Address", 8, 2));
				//driver.findElement(By.xpath("//p-inputmask[@formcontrolname='phone1']/input")).sendKeys("9786543215");
				 wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//p-inputmask[@formcontrolname='phone1']/input"))));
					WebElement input_field= driver.findElement(By.xpath("//p-inputmask[@formcontrolname='phone1']/input"));
					input_field.clear();
					js.executeScript("arguments[0].value = '978-654-3215';", input_field);
					input_field.click();
		break;
			} catch (Exception e) {
				System.out.println("Exception Occurred at the iteration: " + retries);
				
				Thread.sleep(5000);
				retries--;
			}
		}
		Thread.sleep(5000);
		
		//Common_Methods.clickEleBy_Xpath(prop.getDcsPhone2DdArrow(), driver);
		//Common_Methods.selectFormDropdown(prop.getPhone2DdUl(), driver, excel.getCellData("CreateDcs_Address", 9, 2));
		//Common_Methods.enterDataToTextField_Xpath(prop.getPhone2num(), driver, excel.getCellData("CreateDcs_Address", 10, 2));
		
		while (retries > 0) {
			try {
				System.out.println("Into the while block of iteration: " + retries);
				robot.mouseWheel(5);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getDcsPhone3DdArrow())));
		Common_Methods.clickEleBy_Xpath(prop.getDcsPhone3DdArrow(), driver);
		break;
			} catch (Exception e) {
				System.out.println("Exception Occurred at the iteration: " + retries);
				//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getDcsPhone3DdArrow())));
				Thread.sleep(5000);
				retries--;
			}
		}
		Common_Methods.selectFormDropdown(prop.getPhone3DdUl(), driver, excel.getCellData("CreateDcs_Address", 11, 2));
		while (retries > 0) {
			try {
				System.out.println("Into the while block of iteration: " + retries);
				//Common_Methods.enterDataToTextField_Xpath(prop.getPhone3num(), driver, excel.getCellData("CreateDcs_Address", 12, 2));
				//driver.findElement(By.xpath(prop.getPhone3num())).sendKeys(excel.getCellData("CreateDcs_Address", 12, 2));
				//driver.findElement(By.xpath(prop.getPhone3num())).sendKeys("9874563218");
				//driver.findElement(By.xpath("//p-inputmask[@formcontrolname='phone3']/input")).sendKeys("9786543215");
				
				 wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//p-inputmask[@formcontrolname='phone3']/input"))));
				WebElement input_field= driver.findElement(By.xpath("//p-inputmask[@formcontrolname='phone3']/input"));
				input_field.clear();
				js.executeScript("arguments[0].value = '987-456-3218';", input_field);
				input_field.click();
				
				
		break;
			} catch (Exception e) {
				System.out.println("Exception Occurred at the iteration: " + retries);
				
				Thread.sleep(5000);
				retries--;
			}
		}
		
		Common_Methods.enterDataToTextField_Xpath(prop.getFax(), driver, excel.getCellData("CreateDcs_Address", 13, 2));
		Common_Methods.enterDataToTextField_Xpath(prop.getEmail(), driver, excel.getCellData("CreateDcs_Address", 14, 2));
		Common_Methods.clickEleBy_Xpath(prop.getDcsSaveButton(), driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LoadingSpinner)));
		Assert.assertEquals(driver.findElement(By.xpath(prop.getDcsOkText())).getText(), excel.getCellData("CreateDcs_Address", 15, 2));
		
		try {
			Common_Methods.clickEleBy_Xpath(prop.getDcsOkButton(), driver);

			if (BaseClass.excelToWrite.setCellData("Create DCS", "Status", 7, 43, BaseClass.sheetStatus)) {
				//System.out.println("Login successfully.");
			} else {
				//System.out.println("Login Failed.");
			}
			if (BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 16, BaseClass.indexStatus)) {
				EmailSender.setResult(6, BaseClass.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				EmailSender.setDateTime(6, reportDate);

			} else {
				//System.out.println("Login Failed.");
			}
			
		} catch (Exception e) {
			System.out.println("In catch of firefox");e.printStackTrace();
			BaseClass.sheetStatus = "Fail";
			BaseClass.indexStatus = BaseClass.sheetStatus;
			BaseClass.excelToWrite.setCellData("Create DCS", "Status", 7, 43, BaseClass.sheetStatus);
			BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 16, BaseClass.indexStatus);
			EmailSender.setResult(6, BaseClass.indexStatus);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			Date date = new Date();
			String reportDate = df.format(date);
			EmailSender.setDateTime(6, reportDate);
			
		}
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.GetDcsOkButton())));
		}
	
	@Test(dependsOnMethods = "createDcs_BasicDetails")
	public void CreateDcs_Employment() throws InterruptedException
	{
		//CreateDcs_Employment
			System.out.println("In CreateDcs_Employment");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LoadingSpinner)));
			Common_Methods.clickEleBy_Xpath(prop.getDcsEmpCatDdArrow(), driver);
			Common_Methods.selectFormDropdown(prop.getDcsEmpCatDdUl(), driver, excel.getCellData("CreateDcs_Employment", 0, 2));
			Common_Methods.clickEleBy_Xpath(prop.getDcsEmpTypeDdArrow(), driver);
			Common_Methods.selectFormDropdown(prop.getDcsEmpTypeDdUl(), driver, excel.getCellData("CreateDcs_Employment", 1, 2));
			Common_Methods.clickEleBy_Xpath(prop.getDcsEmpHireDate(), driver);
			Common_Methods.selectMonthAndYearInDate(excel.getCellData("CreateDcs_Employment", 3, 2), excel.getCellData("CreateDcs_Employment", 2, 2), prop.getmonthTable(), driver, prop);
			Common_Methods.selectDayInDate(excel.getCellData("CreateDcs_Employment", 4, 2), prop.getdayTable(), driver);
			Common_Methods.clickEleBy_Xpath(prop.getDcsEmpDeptDdArrow(), driver);
			Common_Methods.selectFormDropdown(prop.getDcsEmpDeptDdUl(), driver, excel.getCellData("CreateDcs_Employment", 5, 2));
			Thread.sleep(1000);
			Common_Methods.clickEleBy_Xpath(prop.getDcsEmpOSADdArrow(), driver);
			Common_Methods.selectFormDropdown(prop.getDcsEmpOSADdUl(), driver, excel.getCellData("CreateDcs_Employment", 17, 2));
			Common_Methods.clickEleBy_Xpath(prop.getEmployeeMntnceDdArrow(), driver);
			Common_Methods.selectFormDropdown(prop.getEmployeeMntnceDdUl(), driver, excel.getCellData("CreateDcs_Employment", 19, 2));
//			Common_Methods.clickEleBy_Xpath(prop.getDcsEmpCoordinatorDdArrow(), driver);
//			Common_Methods.selectFormDropdown(prop.getDcsEmpCoordinatorDdUl(), driver, excel.getCellData("CreateDcs_Employment", 6, 2));
//			Common_Methods.clickEleBy_Xpath(prop.getDcsEmpWSD(), driver);
//			Common_Methods.selectMonthAndYearInDate(excel.getCellData("CreateDcs_Employment", 8, 2), excel.getCellData("CreateDcs_Employment", 7, 2), prop.getmonthTable(), driver, prop);
//			Common_Methods.selectDayInDate(excel.getCellData("CreateDcs_Employment", 9, 2), prop.getdayTable(), driver);
//			Common_Methods.enterDataToTextField_Xpath(prop.getDcsEmpMHFI(), driver, excel.getCellData("CreateDcs_Employment", 10, 2));
//			Common_Methods.clickEleBy_Xpath(prop.getDcsEmpTermiCodeDdArrow(), driver);
//			Common_Methods.selectFormDropdown(prop.getDcsEmpTermiCodeDdUl(), driver, excel.getCellData("CreateDcs_Employment", 11, 2));
//			Common_Methods.clickEleBy_Xpath(prop.getDcsEmpTermiDate(), driver);
//			Common_Methods.selectMonthAndYearInDate(excel.getCellData("CreateDcs_Employment", 13, 2), excel.getCellData("CreateDcs_Employment", 12, 2), prop.getmonthTable(), driver, prop);
//			Common_Methods.selectDayInDate(excel.getCellData("CreateDcs_Employment", 14, 2), prop.getdayTable(), driver);
//			Common_Methods.clickEleBy_Xpath(prop.getDcsEmpTransModeDdArrow(), driver);
//			Common_Methods.selectFormDropdown(prop.getDcsEmpTransModeDdUl(), driver, excel.getCellData("CreateDcs_Employment", 15, 2));
//			Common_Methods.enterDataToTextField_Xpath(prop.getDcsEmpLicenseNbr(), driver, excel.getCellData("CreateDcs_Employment", 16, 2));
//			Common_Methods.enterDataToTextField_Xpath(prop.getDcsEmpReqtedHours(), driver, excel.getCellData("CreateDcs_Employment", 18, 2));
//			Common_Methods.enterDataToTextField_Xpath(prop.getDcsEmpAvailHours(), driver, excel.getCellData("CreateDcs_Employment", 20, 2));
//			Common_Methods.clickEleIfYes(prop.getDcsEmpPRN(), driver, excel.getCellData("CreateDcs_Employment", 21, 2));
//			Common_Methods.clickEleIfYes(prop.getDcsEmpEliforPay(), driver, excel.getCellData("CreateDcs_Employment", 22, 2));
//			Common_Methods.clickEleIfYes(prop.getDcsEmpEliforOverTime(), driver, excel.getCellData("CreateDcs_Employment", 23, 2));
//			Common_Methods.clickEleIfYes(prop.getDcsEmpEliforRehire(), driver, excel.getCellData("CreateDcs_Employment", 24, 2));
			Common_Methods.clickEleBy_Xpath(prop.getDcsEmpSaveButton(), driver);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LoadingSpinner)));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getDcsEmpOkText())));
			Assert.assertEquals(driver.findElement(By.xpath(prop.getDcsEmpOkText())).getText(), excel.getCellData("CreateDcs_Employment", 25, 2));
			
			try {
				Common_Methods.clickEleBy_Xpath(prop.getDcsEmpOkButton(), driver);

				if (BaseClass.excelToWrite.setCellData("Create DCS_Employment", "Status", 7, 38, BaseClass.sheetStatus)) {
					//System.out.println("Login successfully.");
				} else {
					//System.out.println("Login Failed.");
				}
				if (BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 17, BaseClass.indexStatus)) {
					EmailSender.setResult(7, BaseClass.indexStatus);
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
					Date date = new Date();
					String reportDate = df.format(date);
					EmailSender.setDateTime(7, reportDate);

				} else {
					//System.out.println("Login Failed.");
				}
				
			} catch (Exception e) {
				System.out.println("In catch of firefox");e.printStackTrace();
				BaseClass.sheetStatus = "Fail";
				BaseClass.indexStatus = BaseClass.sheetStatus;
				BaseClass.excelToWrite.setCellData("Create DCS_Employment", "Status", 7, 38, BaseClass.sheetStatus);
				BaseClass.excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 17, BaseClass.indexStatus);
				EmailSender.setResult(7, BaseClass.indexStatus);
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
				Date date = new Date();
				String reportDate = df.format(date);
				EmailSender.setDateTime(7, reportDate);
				
			}
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LoadingSpinner)));
	}
	
}
