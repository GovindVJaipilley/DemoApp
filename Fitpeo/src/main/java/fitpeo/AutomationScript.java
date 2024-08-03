package fitpeo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationScript {

	public static void main(String[] args) {
		WebDriver driver = null;

		try {
			// WebDriver setup
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			// Set implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

			// Set page load timeout
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			// Delete all previous cookies
			driver.manage().deleteAllCookies();

			// Maximize Chrome
			driver.manage().window().maximize();

			// Navigate to Fitpeo URL
			driver.get("https://fitpeo.com");

			// Navigate to revenue calculator
			driver.findElement(By.xpath("//div[text()='Revenue Calculator']/..")).click();

			// Element to scroll till
			WebElement text = driver.findElement(By.xpath("//h4[text()='Medicare Eligible Patients']"));

			// Scroll down to revenue calculator
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", text);

			// Find the slider element
			WebElement slider = driver.findElement(By.xpath("//input[@aria-valuemax='2000']"));

			// Create a Robot instance (if needed for other operations)
			// Robot robot = new Robot();

			// Set the slider value using Actions
			Actions actions = new Actions(driver);
			actions.clickAndHold(slider).moveByOffset(93, 0).release().perform();

			// Scroll down to revenue calculator
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", text);

			// Enter value to textbox
			((JavascriptExecutor) driver).executeScript(
					"var element = document.evaluate(arguments[0], document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;"
							+ "if (element) {" + "    element.value = '560';"
							+ "    var event = new Event('input', { bubbles: true });"
							+ "    element.dispatchEvent(event);"
							+ "    var changeEvent = new Event('change', { bubbles: true });"
							+ "    element.dispatchEvent(changeEvent);" + "} else {"
							+ "    console.error('Element not found');" + "}",
					"//input[@id=':r0:']");

			// Print value to console
			System.out.println("Value entered in Text Box: "
					+ driver.findElement(By.xpath("//input[@id=':r0:']")).getAttribute("value"));

			// Slider test
			String sliderValue = driver.findElement(By.xpath("//input[@aria-valuemax='2000']")).getAttribute("value");
			String textBoxValue = driver.findElement(By.xpath("//input[@id=':r0:']")).getAttribute("value");

			if (textBoxValue.equals(sliderValue)) {
				System.out.println("Slider Test Pass");
			} else {
				System.out.println("Slider Test Fail");
			}

			// Click on checkboxes
			driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
			driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
			driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
			driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();

			// Print reimbursement value
			String reimbursementValue = driver.findElement(By.xpath("(//p)[8]")).getText();
			System.out.println("Value calculated for Reimbursement: " + reimbursementValue);

			// Reimbursement Test
			if ("$110700".equals(reimbursementValue)) {
				System.out.println("Reimbursement Test Pass");
			} else {
				System.out.println("Reimbursement Test Fail");
			}

		} catch (NoSuchElementException e) {
			System.err.println("Element not found: " + e.getMessage());
		} catch (TimeoutException e) {
			System.err.println("Timeout occurred: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
		} finally {
			if (driver != null) {
				// Close the browser
				driver.quit();
			}
		}
	}
}

/*
 * getting output as
 * 
 * 
 * Value entered in Text Box: 560 
 * Slider Test Fail 
 * Value calculated for Reimbursement: $110295 
 * Reimbursement Test Fail
 *
 * 
 */
