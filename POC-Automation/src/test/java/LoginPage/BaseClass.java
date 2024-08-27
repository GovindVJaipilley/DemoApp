package LoginPage;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import Utilities.ExcelRead;
import Utilities.ReadPropFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	static WebDriverWait wait;
	static ChromeOptions opt;
	static FirefoxOptions ffOpt;
	static EdgeOptions eOpt;
	static ReadPropFile prop;
	static Actions myActions;
	static Robot robot;
	static JavascriptExecutor js;
	ExcelRead excel;
	public static ExcelRead excelToWrite;
	static String browser;
	public static String sheetStatus;
	public static String indexStatus;
	
	//InputStream inputStream;
	//String path = "C:\\POC-Automation\\TestData.xlsx";
	static String path = "C:/POC_Automation/TestData.xlsx";
	String pathToWrite = "C:/POC_Automation/POCRegressionScripts.xlsx";
	
	@BeforeSuite
	public void launchBrowser() throws AWTException {
		excel = new ExcelRead(path);
		excelToWrite = new ExcelRead(pathToWrite);//excelToWrite.getCellData(sheetName, colNum, rowNum)
		System.out.println("data from excel file "+excelToWrite.getCellData("Login", 0, 8));
		sheetStatus = "Pass";
		indexStatus = sheetStatus;
		
		 browser = excel.getCellData("Credentials", 0, 2);
		//System.out.println(browser);
		if(browser.equalsIgnoreCase("Chrome")) {
			//WebDriverManager.chromedriver().setup();
			WebDriverManager.chromedriver().browserVersion("122.0.6261.58").setup();
			opt = new ChromeOptions();
			//opt.setBrowserVersion("122.0.6261.58");
			//System.out.println();
			driver = new ChromeDriver(opt);
			opt.addArguments("--disable-infobars");
			opt.addArguments("--disable-cache");
			driver.manage().window().maximize();
		} else if(browser.equalsIgnoreCase("Firefox")) {
			
				WebDriverManager.firefoxdriver().setup();
				
				
			ffOpt = new FirefoxOptions();
			
			try
			{
				
			driver = new FirefoxDriver(ffOpt);
			
			if (excelToWrite.setCellData("Login", "Status", 7, 8, sheetStatus)) {
		        System.out.println("Browser Launched.");
		    } else {
		        System.out.println("Browser Launched Failed.");
		    }
			
			
		}
		catch(Exception e)
		{ 
			System.out.println("In catch of firefox");
			sheetStatus = "Fail";
			indexStatus = sheetStatus;
			excelToWrite.setCellData("Login", "Status", 7, 8, sheetStatus);
			excelToWrite.setCellData("Login", "Status", 7, 9, sheetStatus);
			excelToWrite.setCellData("Login", "Status", 7, 10, sheetStatus);
			excelToWrite.setCellData("Login", "Status", 7, 11, sheetStatus);
			excelToWrite.setCellData("Login", "Status", 7, 12, sheetStatus);
			excelToWrite.setCellData("Index", "Pass/Fail/Skipped", 8, 9, indexStatus);
			e.printStackTrace();
		}
			ffOpt.addArguments("--disable-infobars");
			ffOpt.addArguments("--disable-cache");
			driver.manage().window().maximize();
		} else if(browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			eOpt = new EdgeOptions();
			driver = new EdgeDriver(eOpt);
			eOpt.addArguments("--disable-infobars");
			eOpt.addArguments("--disable-cache");
			driver.manage().window().maximize();
		} else {
			System.out.println("No valid browser name");
		}
		
		driver.manage().deleteAllCookies();
		myActions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(150));
		robot = new Robot();
		js = (JavascriptExecutor) driver;
		
	}
	/*
	@AfterSuite
	public void quitBrowser() {
		driver.quit();
	}
	*/
	
	public static String getTestDataPath() {
		return path;
	}
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static ChromeOptions getChromeOptions() {
		return opt;
	}
	
	public static ReadPropFile getPropFile() {
		return prop;
	}
	
	public static Actions getDriverActions() {
		return myActions;
	}
	
	public static WebDriverWait getWebDriverWait() {
		return wait;
	}
	
	public static Robot getRobot() {
		return robot;
	}
	
	public static JavascriptExecutor getJSExecutor() {
		return js;
	}
	
}
