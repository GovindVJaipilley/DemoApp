package ManageVisits;

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

public class LinkVisitsFilter {

	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	//String path = "src/test/resources/TestData/TestData.xlsx";
	String path;// = "src/test/resources/TestData/TestData.xlsx";
	String siteFilter, siteSearch, siteSelect;

	@BeforeTest
	public void driversForManageVisitsFilter() throws IOException {
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
	public void filterInLinkVisits() {
		
		siteFilter = prop.getSiteFilterInManageVisits();
		siteSearch = prop.getSiteSearchInManageVisits();
		siteSelect = prop.getSiteSelectInManageVisits();
		
		WebElement siteFilterEle = driver.findElement(By.xpath(siteFilter));
		siteFilterEle.click();

		WebElement siteSearchEle = driver.findElement(By.xpath(siteSearch));
		wait.until(ExpectedConditions.visibilityOf(siteSearchEle));
		siteSearchEle.sendKeys(excel.getCellData("Add_Visit_SC", 1, 2));

		WebElement siteSelectEle = driver.findElement(By.xpath(siteSelect));
		wait.until(ExpectedConditions.visibilityOf(siteSelectEle));
		siteSelectEle.click();
		
		
	}
}
