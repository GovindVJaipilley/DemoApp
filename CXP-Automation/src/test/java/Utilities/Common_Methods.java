package Utilities;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import XpertKitchen.LoginPage.Base_Class;



public class Common_Methods 
{          
	
	public static void selectFormDropdown(String xPathOfUl, WebDriver driver, String data) 
	{
		List<WebElement> UlList = driver.findElement(By.xpath(xPathOfUl)).findElements(By.tagName("li"));
		for(int i = 0; i < UlList.size(); i++)
		{
			if(UlList.get(i).getText().trim().equalsIgnoreCase(data.trim()))
			{
				UlList.get(i).click();
				break;
			}
		}
	}
	
	public static void selectFormDropdown_Op(String xPathOfUl, WebDriver driver, String data) 
	{
		List<WebElement> UlList = driver.findElement(By.xpath(xPathOfUl)).findElements(By.tagName("option"));
		for(int i = 0; i < UlList.size(); i++)
		{
			if(UlList.get(i).getText().trim().equalsIgnoreCase(data.trim()))
			{
				UlList.get(i).click();
				break;
			}
		}
	}
	
	public static void clickEleBy_Xpath(String xpath, WebDriver driver) 
	{
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public static void clickEleBy_Css(String css, WebDriver driver) 
	{
		driver.findElement(By.xpath(css)).click();
	}
	
	public static void enterDataToTextField_Xpath(String xPath, WebDriver driver, String data) 
	{
		try
		{
			driver.findElement(By.xpath(xPath)).clear();
			driver.findElement(By.xpath(xPath)).sendKeys(data);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getElementText_Xpath(String xpath, WebDriver driver)
	{
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public static void waitForElement_Xpath(String xpath, WebDriverWait wait, String waitCondition)
	{
		if(waitCondition.equalsIgnoreCase("visibilityOfElementLocated"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		}
		else if(waitCondition.equalsIgnoreCase("elementToBeClickable"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		}
		else if(waitCondition.equalsIgnoreCase("presenceOfElementLocated"))
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		}
		
	}
	

	
	public static void clickOnRadio(String radioText, WebDriver driver, String radioParantDiv)
	{
		List<WebElement> radio = driver.findElement(By.xpath(radioParantDiv)).findElements(By.tagName("div"));
		for(WebElement r : radio)
		{
			if(r.getText().equalsIgnoreCase(radioText))
			{
				r.click();
			}
		}
		
	}
	
	public static void clickOnRadio_CB(String radioText, WebDriver driver, String radioParantDiv)
	{
		List<WebElement> radio = driver.findElement(By.xpath(radioParantDiv)).findElements(By.tagName("div"));
		for(WebElement r : radio)
		{
			System.out.println("CheckBox: "+r.findElement(By.tagName("input")).getAttribute("name"));
			if(r.findElement(By.tagName("input")).getAttribute("name").equalsIgnoreCase(radioText))
			{
				r.findElement(By.tagName("input")).click();
			}
		}
		
	}
	
	public static void selectEleFromTable(String tableXpath, String eleToSelect, WebDriver driver)
	{
		List<WebElement> rows = driver.findElement(By.xpath(tableXpath)).findElements(By.tagName("tr"));
	l1: for(int i = 0; i < rows.size(); i++)
		{
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			if(tableXpath.contains("days"))
			{
				for(int j = 1; j < cells.size(); j++)
				{
					if(eleToSelect.equalsIgnoreCase(cells.get(j).getText()))
					{
						cells.get(j).click();
						break l1;
					}
				}
			}
				else if(tableXpath.contains("month"))
				{
					for(int j = 0; j < cells.size(); j++)
					{
						if(eleToSelect.equalsIgnoreCase(cells.get(j).getText()))
						{
							cells.get(j).click();
							break l1;
						}
					}
				}
			}
				
		}
	
	
	
	public static void selectDayInDate(String day, String daytableXpath, WebDriver driver)
	{
		selectEleFromTable(daytableXpath, day, driver);
	}
	
	
	public static void selectMonthAndYearInDate(String year, String month, String monthTableXpath, WebDriver driver, ReadPropFile p)
	{
		clickEleBy_Xpath(p.getMonthButtonInDatePicker(), driver);
		while(true)
		{
			if(Integer.parseInt(year) < Integer.parseInt((driver.findElement(By.xpath(p.getYearButtonAfterMonthClick())).getText())))
			{
				driver.findElement(By.xpath(p.getYearLeftArrowAfterMonthClick())).click();
			}
			else if(Integer.parseInt(year) > Integer.parseInt((driver.findElement(By.xpath(p.getYearButtonAfterMonthClick())).getText())))
			{
				driver.findElement(By.xpath(p.getYearRightArrowAfterMonthClick())).click();
			}
			else
				break;
		}
		selectEleFromTable(monthTableXpath, month, driver);
	}
	
	public static void clickEleIfYes(String xPath, WebDriver driver, String yesOrNo)
	{
		if((!driver.findElement(By.xpath(xPath)).isSelected()) & yesOrNo.equalsIgnoreCase("yes"))
		{
			driver.findElement(By.xpath(xPath)).click();
			
		}
		else if((driver.findElement(By.xpath(xPath)).isSelected()) & yesOrNo.equalsIgnoreCase("no"))
		{
			driver.findElement(By.xpath(xPath)).click();
			
		}
	}
	
	public static String convertTextToTimeFormat(String timeAsText)
	{
		String [] timeArray = timeAsText.split(" ");
		if(timeArray.length == 3)
		{
			return timeArray[0]+":"+timeArray[1]+" "+timeArray[2];
		}
		else
			return "";
	}
	
	public static String convertTextToDateFormate(String year, String month, String day)
	{
		Map<String, String> monthToNumberMap = new HashMap<>();
        monthToNumberMap.put("January", "01");
        monthToNumberMap.put("February", "02");
        monthToNumberMap.put("March", "03");
        monthToNumberMap.put("April", "04");
        monthToNumberMap.put("May", "05");
        monthToNumberMap.put("June", "06");
        monthToNumberMap.put("July", "07");
        monthToNumberMap.put("August", "08");
        monthToNumberMap.put("September", "09");
        monthToNumberMap.put("October", "10");
        monthToNumberMap.put("November", "11");
        monthToNumberMap.put("December", "12");
      if(day.length()==1)
      {
    	  return monthToNumberMap.get(month)+"/0"+day+"/"+year;
      }
		return monthToNumberMap.get(month)+"/"+day+"/"+year;
	}
	
	public static void clickOnTime(WebDriver driver, ReadPropFile p, String data)
	{
		String[] time = data.split(" ");
		clickOnRadio(time[1], driver, p.getB_E_Time_Radio());
		List<WebElement> spanList = driver.findElement(By.xpath(p.getB_E_Time_Table())).findElements(By.tagName("span"));
		for(int i = 0; i < spanList.size(); i++)
		{
			if(spanList.get(i).getText().equalsIgnoreCase(time[0]))
			{
				spanList.get(i).click();
				break;
			}
		}
	}
	
	public static void navigateToKit_EvtListing(ReadPropFile p, WebDriver dirver, WebDriverWait wait)
	{
		waitForElement_Xpath(p.getXpertKitchen_MainMenu(), wait, "elementToBeClickable");
		clickEleBy_Xpath(p.getXpertKitchen_MainMenu(), dirver);
		waitForElement_Xpath(p.getkitchen_header(), wait, "elementToBeClickable");
		clickEleBy_Xpath(p.getkitchen_header(), dirver);
		waitForElement_Xpath(p.getEventListing_Sales(), wait, "elementToBeClickable");
		clickEleBy_Xpath(p.getEventListing_Sales(), dirver);
	}
	
	public static void naviToHome(WebDriver driver, ReadPropFile p)
	{
		switchToDefault(driver);
		switchToHead(driver, p);
		clickEleBy_Xpath(p.getHomePageB(), driver);
	}
	
	public static void switchToHead(WebDriver driver, ReadPropFile p)
	{
		driver.switchTo().frame(driver.findElement(By.xpath(p.getHeaderFrame())));
	}
	
	public static void switchToRight(WebDriver driver, ReadPropFile p)
	{
		driver.switchTo().frame(driver.findElement(By.xpath(p.getRightFrame())));
	}
	
	public static void switchToView(WebDriver driver, ReadPropFile p)
	{
		driver.switchTo().frame(driver.findElement(By.xpath(p.getViewFrame())));
	}
	
	public static void switchToDefault(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	public static void switchToList(WebDriver driver, ReadPropFile p)
	{
		driver.switchTo().frame(driver.findElement(By.xpath(p.getListFrame())));
	}
	
	public static void naviToSales(WebDriver driver, ReadPropFile p, WebDriverWait wait) throws InterruptedException
	{
		naviToHome(driver, p);
		switchToDefault(driver);
		switchToRight(driver, p);
		waitForElement_Xpath(p.getSalesMenu(), wait, "elementToBeClickable");
		clickEleBy_Xpath(p.getSalesMenu(), driver);
		switchToDefault(driver);
	}
	
	public static boolean isEleDisplayed(WebDriver driver, String xPath)
	{
		return driver.findElement(By.xpath(xPath)).isDisplayed();
	}
	
	public static String switchToWindow_C(WebDriver driver)
	{
		String currentW = driver.getWindowHandle();
		Set<String> windowL = driver.getWindowHandles();
		for(String window : windowL)
		{
			if(!currentW.equalsIgnoreCase(window))
			{
				driver.switchTo().window(window);
			}
		}
		return currentW;
	}
	
	public static void switchToWindow_P(WebDriver driver, String window_ID)
	{
		driver.switchTo().window(window_ID);
	}
	
	public static void clickEle_JS(String xpath, WebDriver driver)
	{
		Base_Class.getJSExecutor().executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
	}
	
	public static WebElement getEle_Xpath(String xpath, WebDriver driver)
	{
		return driver.findElement(By.xpath(xpath));
	}
	
	public static void naviToKitchen(WebDriver driver, ReadPropFile p, WebDriverWait wait)
	{
		naviToHome(driver, p);
		switchToDefault(driver);
		switchToRight(driver, p);
		waitForElement_Xpath(p.getKitchenMenu(), wait, "elementToBeClickable");
		clickEleBy_Xpath(p.getKitchenMenu(), driver);
		switchToDefault(driver);
	}
	
	public static void naviToAccounting(WebDriver driver, ReadPropFile p, WebDriverWait wait)
	{
		naviToHome(driver, p);
		switchToDefault(driver);
		switchToRight(driver, p);
		waitForElement_Xpath(p.getAccountingMenu(), wait, "elementToBeClickable");
		clickEleBy_Xpath(p.getAccountingMenu(), driver);
		switchToDefault(driver);
	}
	
	public static void naviToScheduling(WebDriver driver, ReadPropFile p, WebDriverWait wait)
	{
		naviToHome(driver, p);
		switchToDefault(driver);
		switchToRight(driver, p);
		waitForElement_Xpath(p.getSchedulingMenu(), wait, "elementToBeClickable");
		clickEleBy_Xpath(p.getSchedulingMenu(), driver);
		switchToDefault(driver);
	}
	
	public static void naviToWarehouse(WebDriver driver, ReadPropFile p, WebDriverWait wait)
	{
		naviToHome(driver, p);
		switchToDefault(driver);
		switchToRight(driver, p);
		waitForElement_Xpath(p.getWarehouseMenu(), wait, "elementToBeClickable");
		clickEleBy_Xpath(p.getWarehouseMenu(), driver);
		switchToDefault(driver);
	}
	
}
