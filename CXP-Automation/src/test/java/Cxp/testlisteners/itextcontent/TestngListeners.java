package Cxp.testlisteners.itextcontent;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class TestngListeners extends XpertKitchen.LoginPage.Base_Class implements ITestListener 
 
{
	//public ExtentHtmlReporter htmlReporter;
	
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	File source;
	TakesScreenshot ts;
	File target;

	public void onTestStart(ITestResult result) 
	{

	}

	public void onTestSuccess(ITestResult result)
	{
		logger = extent.createTest(result.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\ErrorScreenshots\\" + tr.getName() + ".png";
		File destination = new File(dest);
		try
		{
			FileUtils.copyFile(source, destination);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try 
		{
			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(dest));
		} 
		catch (Exception e)
       {
			e.printStackTrace();
		}
	}


	public void onTestSkipped(ITestResult result) 
	{

		logger = extent.createTest(result.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{

	}

	public void onStart(ITestContext context)
	{
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Extentreports/myReport123.html");		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "qa tester");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Testing");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onFinish(ITestContext context) 
	{

		extent.flush();
	}
	

}
