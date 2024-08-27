package Utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Common_Methods {
	
	static String [] site;
	
	public static void selectFormDropdown(String xPathOfUl, WebDriver driver, String data) {
		//System.out.println(data);
		List<WebElement> UlList = driver.findElement(By.xpath(xPathOfUl)).findElements(By.tagName("li"));
		//System.out.println(UlList.size());
		for(int i = 0; i < UlList.size(); i++) {
			//System.out.println(UlList.get(i).getText());
			if(UlList.get(i).getText().trim().equalsIgnoreCase(data.trim())) {
				//System.out.println("In If Condition True");
				UlList.get(i).click();
				break;
				
			}
		}
	}
	
	public static void clickEleBy_Xpath(String xpath, WebDriver driver) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public static void clickEleBy_Css(String css, WebDriver driver) {
		driver.findElement(By.xpath(css)).click();
	}
	
	public static void enterDataToTextField_Xpath(String xPath, WebDriver driver, String data) {
		try{
			driver.findElement(By.xpath(xPath)).clear();
			driver.findElement(By.xpath(xPath)).sendKeys(data);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void select_Mapped_Sites(String sites, WebDriver driver, ReadPropFile p) throws Exception {
		site = sites.split(" ");
		for(int i = 0; i < site.length; i++) {
			String site_Number = site[i].trim();
			enterDataToTextField_Xpath(p.getMappedSitesDdTextBox(), driver, site_Number);
			clickEleBy_Xpath(p.getMappedSitesDdCheckBox(), driver);
		}
	}
	public static void change_Home_Site(String homeSite, WebDriver driver, ReadPropFile p) throws Exception {
		String xPath1 = p.getChangeHomeSiteRadioPart1();
		String xPath2 = p.getChangeHomeSiteRadioPart2();
		System.out.println(xPath1);
		System.out.println(xPath2);
		for(int i = 0; i < site.length; i++) {
			String com_XPath = xPath1 + i + xPath2;
			System.out.println(com_XPath);
			WebElement radio = driver.findElement(By.xpath(com_XPath));
			//System.out.println(radio.getText());
			if(radio.getText().contains(homeSite)) {
				radio.click();
				break;
			}
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
						//System.out.println(cells.get(j).getText());
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
								//System.out.println(cells.get(j).getText());
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
	
	
	public static void selectMonthAndYearInDate(String month, String year, String monthTableXpath, WebDriver driver, ReadPropFile p)
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
			//System.out.println("not selected");
		}
		else if((driver.findElement(By.xpath(xPath)).isSelected()) & yesOrNo.equalsIgnoreCase("no"))
		{
			driver.findElement(By.xpath(xPath)).click();
			//System.out.println("selected");
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
	
	public static void searchByDateAndClickOnEdit(String date, WebDriver driver, ReadPropFile p)
	{
		int NoOfRows = driver.findElement(By.xpath(p.getDcsAvailabilityNoOfRows())).findElements(By.tagName("tr")).size();
		
		for(int i = 1; i <= NoOfRows; i++)
		{
			if(driver.findElement(By.xpath(String.format(p.getDcsAvailabilityDateCell(), i, 2))).getText().equals(date))
			{
				driver.findElement(By.xpath(String.format(p.getDcsAvailabilityDateCell(), i, 1)+"/span")).click();
				break;
			}
		}
	}
	
	public static void enterTimeToWeeklyAvailability(WebDriver driver, ReadPropFile p, ExcelRead excel, String sheetName)
	{
		for(int i = 3; i < 10; i++)
		{
			for(int j = 3; j < 7; j++)
			{
				
				String xPath = String.format(p.getWeeklyTimeInput(), i-2, j-1);
				
				enterDataToTextField_Xpath(xPath, driver, convertTextToTimeFormat(excel.getCellData(sheetName, j, i)));
			}
		}
	}
	
	public static void filterPs (String psName, String psStatus, ReadPropFile p, WebDriver driver)
	{
		clickEleBy_Xpath(p.getFilterIcon(), driver);
		enterDataToTextField_Xpath(p.getPSNameFilter(), driver, psName);
		clickEleBy_Xpath(p.getPSStatus(), driver);
		clickEleBy_Xpath(p.getPSStatusAll(), driver);
		clickEleBy_Xpath(p.getSearchFilterButton(), driver);
	}
	
	public static void selectTaskForCarePlan(WebDriver driver, ReadPropFile prop, ExcelRead excel)
	{
		
		WebElement taskTable = driver.findElement(By.xpath(prop.getTaskTableInCarePlan()));
		List<WebElement> allTask = taskTable.findElements(By.tagName("tr")); 
		String [] taskCode = excel.getCellData("AddCarePlanList", 4, 3).split(" ");
		for(int j = 0; j < taskCode.length; j++)
		{
			for(int i = 1; i <= allTask.size(); i++)
			{
			
				String taskCodeXpath = String.format(prop.getTaskCodeInCarePlan(), i);
				if(driver.findElement(By.xpath(taskCodeXpath)).getText().equalsIgnoreCase(taskCode[j]))
				{
					String taskCheckB = String.format(prop.getTaskCheckBInCarePlan(), i);
					driver.findElement(By.xpath(taskCheckB)).click();
				}
			}
		}
	}
	
	public static void enterDaysPerWeekInAddTask(WebDriver driver, ReadPropFile prop, ExcelRead excel)
	{
		String [] days = excel.getCellData("AddCarePlanList", 5, 3).split(" ");
		for(int i = 0; i < days.length; i++)
		{
			String xPath = String.format(prop.getDaysPerWeekOnTaskPlanList(), i+1);
			enterDataToTextField_Xpath(xPath, driver, days[i]);
		}
	}
	
	public static void navigateToDcsListingInCommon_Methods(WebDriver driver, ReadPropFile prop, WebDriverWait wait)  {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getMenuOption())));
		driver.findElement(By.xpath(prop.getMenuOption())).click();
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getDcsMenu())));
		driver.findElement(By.xpath(prop.getDcsMenu())).click();
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getDcsListing())));
		driver.findElement(By.xpath(prop.getDcsListing())).click();
	}
	
	public static void navigateToHomeInCommon_Methods(WebDriver driver, ReadPropFile prop, WebDriverWait wait)  {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getMenuOption())));
		driver.findElement(By.xpath(prop.getMenuOption())).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getDcsMenu())));
		driver.findElement(By.xpath(prop.getHomeMenu())).click();
	}
}
