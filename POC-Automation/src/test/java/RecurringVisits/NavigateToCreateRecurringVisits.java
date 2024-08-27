package RecurringVisits;

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

public class NavigateToCreateRecurringVisits {

	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	//String path = "C:\\POC-Automation\\TestData.xlsx";
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	String extendPSTree;
	String collapsePSTree;
	String extendAdmissionTree;
	String extendFirstAdmissionTree;
	String menuAtPayorPlanTree;
	String activeServiceOption;
	String inactiveServicesOption;
	String allServicesOption;
	String menuAtServiceTree;
	String createRecurringVisitsOption;
	String CreateRecurringVisitHeader;
	
	@BeforeTest
	public void driversToNavigateCreateRecuVisits() throws IOException {
		driver = BaseClass.getDriver();
		path = BaseClass.getTestDataPath();
		wait = BaseClass.getWebDriverWait();
		myActions = BaseClass.getDriverActions();
		robot = BaseClass.getRobot();
		prop = new ReadPropFile();
		excel = new ExcelRead(path);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	@Test
	public void naviToCreateRecuVisits() {
		
		extendPSTree = prop.getextendPSTree();
		collapsePSTree = prop.getCollapsePSTree(); 
		extendAdmissionTree = prop.getextendAdmissionTree(); 
		extendFirstAdmissionTree = prop.getextendFirstAdmissionTree(); 
		menuAtPayorPlanTree = prop.getMenuAtPayorPlanTree(); 
		activeServiceOption = prop.getActiveServiceOption(); 
		inactiveServicesOption = prop.getInactiveServicesOption(); 
		allServicesOption = prop.getAllServicesOption(); 
		menuAtServiceTree = prop.getMenuAtServiceTree(); 
		createRecurringVisitsOption = prop.getCreateRecurringVisitsOption();
		CreateRecurringVisitHeader = prop.getCreateRecurringVisitHeader();
		
		WebElement extendPSTreeEle = driver.findElement(By.xpath(extendPSTree));
		wait.until(ExpectedConditions.visibilityOf(extendPSTreeEle));
		extendPSTreeEle.click();
		WebElement collapsePSTreeEle = driver.findElement(By.xpath(collapsePSTree));
		wait.until(ExpectedConditions.visibilityOf(collapsePSTreeEle));
		WebElement extendFirstAdmissionTreeEle = driver.findElement(By.xpath(extendFirstAdmissionTree));
		wait.until(ExpectedConditions.visibilityOf(extendFirstAdmissionTreeEle));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		extendFirstAdmissionTreeEle.click();
		WebElement menuAtPayorPlanTreeEle = driver.findElement(By.xpath(menuAtPayorPlanTree));
		wait.until(ExpectedConditions.visibilityOf(menuAtPayorPlanTreeEle));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		menuAtPayorPlanTreeEle.click();
		WebElement activeServiceOptionEle = driver.findElement(By.xpath(activeServiceOption));
		wait.until(ExpectedConditions.visibilityOf(activeServiceOptionEle));
		activeServiceOptionEle.click();
		WebElement menuAtServiceTreeEle = driver.findElement(By.xpath(menuAtServiceTree));
		wait.until(ExpectedConditions.visibilityOf(menuAtServiceTreeEle));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(prop.getLoadingSpinner())));
		menuAtServiceTreeEle.click();
		WebElement createRecurringVisitsOptionEle = driver.findElement(By.xpath(createRecurringVisitsOption));
		wait.until(ExpectedConditions.visibilityOf(createRecurringVisitsOptionEle));
		createRecurringVisitsOptionEle.click();
		WebElement CreateRecurringVisitHeaderEle = driver.findElement(By.xpath(CreateRecurringVisitHeader));
		wait.until(ExpectedConditions.visibilityOf(CreateRecurringVisitHeaderEle));
		if(CreateRecurringVisitHeaderEle.isDisplayed()) {
			System.out.println("Create Recurring Visits pop-up is opened successfully");
		}else {
			System.out.println("Create Recurring Visits pop-up is not opened");
		}
	}
}
