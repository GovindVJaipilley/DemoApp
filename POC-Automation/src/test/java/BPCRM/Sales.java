package BPCRM;

import java.awt.Robot;
import java.io.IOException;
import java.time.Duration;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LoginPage.BaseClass;
import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class Sales {
	WebDriver driver;
	WebDriverWait wait;
	Actions myActions;
	ReadPropFile prop;
	ExcelRead excel;
	Robot robot;
	// String path = "C:\\POC-Automation\\TestData.xlsx";
	String path;
	String menuClick,BpcrmDropDown,SalesOptions,Accounts,
	BranchDropDown,BranchTextField,Branchvalue,DropdownFirstvalue,
	AccountPageHeading,AddAccount,CreateNewAccountHeadding,AccountName,
	AccountNameValue,HomeIcon,AdressHeading,LocationDropdown,LocationList,
	LocationValue,Address1,Adress1Value,Zip,ZipValue,Phone1,Phone1Value,
	Phone1Dropdown,Phone1DropDownlist,Phone1dropvalue,SaveBtn,Sucessok,
	RCHCDropDown,RCHEDropList,RchcRoadMapValue,Createbtn,contacticon,contact,
	Accountname1,phone,Searchbutton,AddContactbutton,Contactpage,CreateContactHeading,
	ContactFirstname,ContactFirstnamevalue,ContactLastname,ContactLastnamevalue,
	Assignedtodropdown,AssignedtosearchField,AssignedtoValue,AssignedToselection,
	Titlefield,TitleValue,SalesOpportunitiesoption,SalesOpportunityicon,
	SalesOpphedding,AddSalesOpportunity,CreateSalesOpportunitiespageHeadding,
	salesoppname,salesoppnamevalue,Typedropdown,typevalue,TypeDropdownlist,
	Revenuefield,Revenuevalue,SalesActivityIcon,SalesActivityheadding,
	Addsalesactivity,CreateNewSalesActivitypage,ActivitytypeDropdown,
	Activitytypelist,ActivityTypevalue,Activitydate,Activitydatevalue,
	statusdropdown,Statuslist,StatusValue,PreVisitObjectiveField,
	PreVisitObjectiveFieldvalue,PostVisitNotesField,PostVisitNotesFieldvalue,
	AbandonedDropdown,AbandonedList,Abandonedvalue,ContactBranchDropDown,
	ContactBranchvalue,AccountListIcon,Accountsearch,Accountsearchvalue,
	Thissiteradio,gobutton,AccountFirstValue;
	@BeforeTest
	public void allProps() throws IOException {
		driver = BaseClass.getDriver();
		path = BaseClass.getTestDataPath();
		wait = BaseClass.getWebDriverWait();
		myActions = BaseClass.getDriverActions();
		robot = BaseClass.getRobot();
		prop = new ReadPropFile();
		excel = new ExcelRead(path);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		BaseClass.sheetStatus = "Pass";
	}
		@Test(dependsOnMethods = "LoginPage.LoginTest.loginLite",priority=0)	
		public void BpcrmNavigation() throws InterruptedException
		{
			menuClick = prop.getMenuOption();
			BpcrmDropDown=prop.getBpcrmMenu();
			SalesOptions=prop.getSalesMenu();
			
			Common_Methods.clickEleBy_Xpath(menuClick, driver);
			Thread.sleep(3000);
			Common_Methods.clickEleBy_Xpath(BpcrmDropDown, driver);
			Thread.sleep(3000);
			Common_Methods.clickEleBy_Xpath(SalesOptions, driver);
			Thread.sleep(3000);
		}
		@Test(dependsOnMethods="BPCRM.Sales.BpcrmNavigation",priority=1)
		public void AddAccount() throws InterruptedException
		{
			
			Accounts=prop.getAccounts();
			AccountPageHeading=prop.getAccountsHeading();
			BranchDropDown=prop.getBranchDropdown();
			BranchTextField=prop.getBranchSearchInputfield();
			DropdownFirstvalue=prop.getBrancheSelection();
			AddAccount=prop.getAddAccountButton();
			CreateNewAccountHeadding=prop.getNewAccountCreateHeading();
			AccountName=prop.getAccountname();
			HomeIcon=prop.getHomeIcon();
			AdressHeading=prop.getAdressHeading();
			LocationDropdown=prop.getLocationDropdown();
			LocationList=prop.getLocationDropDownList();
			Address1=prop.getLocationAddressLine1();
			Zip=prop.getZipcode();
			Phone1=prop.getPhone1Numberfield();
			Phone1Dropdown=prop.getPhone1DropDownField();
			Phone1DropDownlist=prop.getPhone1DropDownList();
			SaveBtn=prop.getSaveButton1();
			Sucessok=prop.getSuccessMsgOkBtn();
			RCHCDropDown=prop.getRchc_Road_MapDropdown();
			RCHEDropList=prop.getRchcDropDownList();
			Createbtn=prop.getCreateButton1();	
			
			Branchvalue=excel.getCellData("Bpcrm_Sales_AddAccount", 0, 2);
			AccountNameValue=excel.getCellData("Bpcrm_Sales_AddAccount", 1, 2);	
			LocationValue=excel.getCellData("Bpcrm_Sales_AddAccount", 3, 2);
			Adress1Value=excel.getCellData("Bpcrm_Sales_AddAccount", 4, 2);
			ZipValue=excel.getCellData("Bpcrm_Sales_AddAccount", 5, 2);
			Phone1dropvalue=excel.getCellData("Bpcrm_Sales_AddAccount", 6, 2);
			Phone1Value	=excel.getCellData("Bpcrm_Sales_AddAccount", 2, 2);
			RchcRoadMapValue=excel.getCellData("Bpcrm_Sales_AddAccount", 7, 2);
					
			Common_Methods.clickEleBy_Xpath(Accounts, driver);
			Thread.sleep(2000);
			WebElement AccountsHeading= driver.findElement(By.xpath(AccountPageHeading));
			wait.until(ExpectedConditions.visibilityOf(AccountsHeading));
			Thread.sleep(2000);
			int retries = 5;
			while (retries > 0) {
				try {
					System.out.println("Into the while block of iteration: " + retries);
					Common_Methods.clickEleBy_Xpath(BranchDropDown, driver);
					break;
				} catch (ElementClickInterceptedException e) {
					System.out.println("Exception Occurred at the iteration: " + retries);
					
					Thread.sleep(5000);
					retries--;
				}	
			}
			Thread.sleep(2000);
			Common_Methods.enterDataToTextField_Xpath(BranchTextField, driver, Branchvalue);
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(DropdownFirstvalue, driver);
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(AddAccount, driver);
			Thread.sleep(2000);
			WebElement CeatenewAccountPageHeading=driver.findElement(By.xpath(CreateNewAccountHeadding));
			wait.until(ExpectedConditions.visibilityOf(CeatenewAccountPageHeading));
			Thread.sleep(2000);
			Common_Methods.enterDataToTextField_Xpath(AccountName, driver, AccountNameValue);
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(RCHCDropDown, driver);
			Thread.sleep(2000);
			Common_Methods.selectFormDropdown(RCHEDropList, driver, RchcRoadMapValue);
			Thread.sleep(2000);
			Addaddress();
		}
			
			
			public void Addaddress() throws InterruptedException{
			Common_Methods.clickEleBy_Xpath(HomeIcon, driver);
			Thread.sleep(2000);
			WebElement Adressheading=driver.findElement(By.xpath(AdressHeading));
			wait.until(ExpectedConditions.visibilityOf(Adressheading));
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(LocationDropdown, driver);
			Thread.sleep(2000);
			Common_Methods.selectFormDropdown(LocationList, driver, LocationValue);
			Thread.sleep(2000);
			Common_Methods.enterDataToTextField_Xpath(Address1, driver, Adress1Value);
			Thread.sleep(2000);
			Common_Methods.enterDataToTextField_Xpath(Zip, driver, ZipValue);
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(Phone1, driver);
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(Phone1Dropdown, driver);
			Thread.sleep(2000);
			Common_Methods.selectFormDropdown(Phone1DropDownlist, driver, Phone1dropvalue);
			Thread.sleep(2000);
			Common_Methods.enterDataToTextField_Xpath(Phone1, driver, Phone1Value);
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(SaveBtn, driver);
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(Sucessok, driver);
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(Createbtn, driver);
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(Sucessok, driver);
			Thread.sleep(2000);
		}
		@Test(dependsOnMethods="BPCRM.Sales.AddAccount",priority=2)
		public void SearchCriteria() throws InterruptedException
		{
			Accountname1=prop.getAccountname1();
			phone=prop.getPhonefield();
			Searchbutton=prop.getSearchBtn();
			Common_Methods.enterDataToTextField_Xpath(Accountname1, driver, AccountNameValue);
			Thread.sleep(2000);
			Common_Methods.enterDataToTextField_Xpath(phone, driver,Phone1Value);
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(Searchbutton, driver);
			Thread.sleep(5000);
		}
		@Test(dependsOnMethods="BPCRM.Sales.SearchCriteria",priority=3)
		public void ContactIcon() throws InterruptedException
		{
			contacticon=prop.getContactIcon();
			Common_Methods.clickEleBy_Xpath(contacticon, driver);
			Thread.sleep(2000);
			
		}
		
		@Test(dependsOnMethods="BPCRM.Sales.BpcrmNavigation")
		public void ContactNavigation() throws InterruptedException
		{
			contact=prop.getContacts();
			Contactpage=prop.getContactsHeading();
			ContactBranchDropDown=prop.getContactsBranchDropdown();
			AccountListIcon=prop.getAccountListIcon();
			Accountsearch=prop.getAcountsearchfield();
			Thissiteradio=prop.getThissiteradiobutton();
			gobutton=prop.getGobutton();
			AccountFirstValue=prop.getAccountnamefirstvalue();
			BranchTextField=prop.getBranchSearchInputfield();
			
			ContactBranchvalue=excel.getCellData("Bpcrm_Sales_AddContact", 0, 2);
			Accountsearchvalue=excel.getCellData("Bpcrm_Sales_AddAccount", 1, 2);
			System.out.println(ContactBranchvalue);
			Common_Methods.clickEleBy_Xpath(contact, driver);		
			Thread.sleep(5000);
			WebElement contactpageheadding=driver.findElement(By.xpath(Contactpage));
			wait.until(ExpectedConditions.visibilityOf(contactpageheadding));
			int retries = 5;
			while (retries > 0) {
				try {
					System.out.println("Into the while block of iteration: " + retries);
					Common_Methods.clickEleBy_Xpath(ContactBranchDropDown, driver);
					break;
				} catch (ElementClickInterceptedException e) {
					System.out.println("Exception Occurred at the iteration: " + retries);
					
					Thread.sleep(5000);
					retries--;
				}	
				Thread.sleep(5000);
				driver.findElement(By.xpath(BranchTextField)).sendKeys(ContactBranchvalue);
				//Common_Methods.enterDataToTextField_Xpath(BranchTextField, driver, ContactBranchvalue);
				Thread.sleep(2000);
				Common_Methods.clickEleBy_Xpath(DropdownFirstvalue, driver);
				Thread.sleep(2000);		
				WebElement accountlisticon = driver.findElement(By.xpath(AccountListIcon));
				accountlisticon.click();
				Thread.sleep(2000);
				Common_Methods.enterDataToTextField_Xpath(Accountsearch, driver, Accountsearchvalue);
				Thread.sleep(2000);
				Common_Methods.clickEleBy_Xpath(Thissiteradio, driver);
				Thread.sleep(2000);
				Common_Methods.clickEleBy_Xpath(gobutton, driver);
				Thread.sleep(2000);
				Common_Methods.clickEleBy_Xpath(AccountFirstValue, driver);
				Thread.sleep(2000);
				AddContact();
			}
			}
						
		
		@Test(priority=4)
		public void AddContact() throws InterruptedException
		{			
			AddContactbutton=prop.getAddContacts();
			Contactpage=prop.getContactsHeading();
			CreateContactHeading=prop.getContactsHeading();
			ContactFirstname=prop.getContactFirstName();
			ContactLastname=prop.getContactLastName();
			Titlefield=prop.getTitleField();
			Assignedtodropdown=prop.getAssignedToDropDown();
			AssignedtosearchField=prop.getAssignedToSearchField();
			AssignedToselection=prop.getAssignedToSelection();
					
			ContactFirstnamevalue=excel.getCellData("Bpcrm_Sales_AddContact", 1, 2);
			ContactLastnamevalue=excel.getCellData("Bpcrm_Sales_AddContact", 2, 2);
			TitleValue=excel.getCellData("Bpcrm_Sales_AddContact", 3, 2);
			AssignedtoValue=excel.getCellData("Bpcrm_Sales_AddContact", 4, 2);
			
			WebElement contactpageheadding=driver.findElement(By.xpath(Contactpage));
			wait.until(ExpectedConditions.visibilityOf(contactpageheadding));
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(AddContactbutton, driver);
			Thread.sleep(2000);
			WebElement contactcreatePage=driver.findElement(By.xpath(CreateContactHeading));
			wait.until(ExpectedConditions.visibilityOf(contactcreatePage));
			Thread.sleep(5000);
				
			Common_Methods.enterDataToTextField_Xpath(ContactFirstname, driver, ContactFirstnamevalue);
			Thread.sleep(2000);
			Common_Methods.enterDataToTextField_Xpath(ContactLastname, driver, ContactLastnamevalue);
			Thread.sleep(2000);
			Common_Methods.enterDataToTextField_Xpath(Titlefield, driver, TitleValue);
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(Assignedtodropdown, driver);		
			Thread.sleep(2000);
			Common_Methods.enterDataToTextField_Xpath(AssignedtosearchField, driver, AssignedtoValue);
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(AssignedToselection, driver);
			Thread.sleep(2000);
			Addaddress();
			Thread.sleep(2000);
		}
		@Test(dependsOnMethods="BPCRM.Sales.BpcrmNavigation")
		public void ContactSalesOpportunity() throws InterruptedException
		{
			SalesOpportunitiesoption=prop.getSalesOpportunities();
			Common_Methods.clickEleBy_Xpath(SalesOpportunitiesoption, driver);
			Thread.sleep(2000);
		}
		@Test(dependsOnMethods="BPCRM.Sales.AddContact",priority=5)
		public void SalesOpportunityicon() throws InterruptedException
		{
			SalesOpportunityicon=prop.getSalesOpportunitiesIcon();
			Common_Methods.clickEleBy_Xpath(SalesOpportunityicon, driver);
			Thread.sleep(2000);
		}
		
		@Test(priority=6)
		public void AddSalesOpportunity() throws InterruptedException
		{
			SalesOpphedding=prop.getSalesOpportunitiesHeading();
			AddSalesOpportunity=prop.getAddSales_Opportunity();
			CreateSalesOpportunitiespageHeadding=prop.getCreateSalesOpportunitiesHeadding();
			salesoppname=prop.getSalesOpportunitiesName();
			Typedropdown=prop.getTypeDropDown();
			TypeDropdownlist=prop.getTypeDropDownList();
			Revenuefield=prop.getRevenue();
			
			salesoppnamevalue=excel.getCellData("Bpcrm_Sales_SalesOpportunity", 0, 2);
			typevalue=excel.getCellData("Bpcrm_Sales_SalesOpportunity", 1, 2);
			Revenuevalue=excel.getCellData("Bpcrm_Sales_SalesOpportunity", 2, 2);
			
			WebElement SalesOpportunityPageHedding=driver.findElement(By.xpath(SalesOpphedding));
			wait.until(ExpectedConditions.visibilityOf(SalesOpportunityPageHedding));
			Thread.sleep(5000);
			Common_Methods.clickEleBy_Xpath(AddSalesOpportunity, driver);
			Thread.sleep(2000);
			WebElement createsalesopppagehedding=driver.findElement(By.xpath(CreateSalesOpportunitiespageHeadding));
			wait.until(ExpectedConditions.visibilityOf(createsalesopppagehedding));
			Thread.sleep(2000);
			Common_Methods.enterDataToTextField_Xpath(salesoppname, driver, salesoppnamevalue);
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(Typedropdown, driver);
			Thread.sleep(2000);
			Common_Methods.selectFormDropdown(TypeDropdownlist, driver, typevalue);
			Thread.sleep(2000);
			Common_Methods.enterDataToTextField_Xpath(Revenuefield, driver, Revenuevalue);
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(Createbtn, driver);
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(Sucessok, driver);
			Thread.sleep(2000);
		}
		@Test(dependsOnMethods="BPCRM.Sales.AddSalesOpportunity",priority=7)
		public void SalesActivityIcon() throws InterruptedException{
			SalesActivityIcon=prop.getSalesActivityIcon();
			Common_Methods.clickEleBy_Xpath(SalesActivityIcon, driver);	
			Thread.sleep(5000);
			}		
		@Test(dependsOnMethods="BPCRM.Sales.SalesActivityIcon",priority=8)
		public void AddSalesActivity() throws InterruptedException{
			SalesActivityheadding=prop.getSalesActivityHeadding();
			Addsalesactivity=prop.getAddSalesActivity();
			CreateNewSalesActivitypage=prop.getCreateNewSalesActivityHeadding();
			ActivitytypeDropdown=prop.getActivityTypeDropDown();
			Activitytypelist=prop.getActivityTypeList();
			Activitydate=prop.getActivityDate();
			statusdropdown=prop.getStatusDropDown();
			Statuslist=prop.getStatusDropDownlist();
			PreVisitObjectiveField=prop.getPreVisitObjectiveField();
			PostVisitNotesField=prop.getPostVisitNotesField();
			AbandonedDropdown=prop.getAbandonedDropdown();
			AbandonedList=prop.getAbandonedList();
			
			ActivityTypevalue=excel.getCellData("Bpcrm_Sales_SalesActivity", 0, 2);
			Activitydatevalue=excel.getCellData("Bpcrm_Sales_SalesActivity", 1, 2);
			StatusValue=excel.getCellData("Bpcrm_Sales_SalesActivity", 2, 2);
			PreVisitObjectiveFieldvalue=excel.getCellData("Bpcrm_Sales_SalesActivity", 4, 2);
			PostVisitNotesFieldvalue=excel.getCellData("Bpcrm_Sales_SalesActivity", 5, 2);
			Abandonedvalue=excel.getCellData("Bpcrm_Sales_SalesActivity", 3, 2);
			
			WebElement salesactivitypageheadfding=driver.findElement(By.xpath(SalesActivityheadding));
			wait.until(ExpectedConditions.visibilityOf(salesactivitypageheadfding));
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(Addsalesactivity, driver);
			Thread.sleep(5000);
			WebElement CreateSalesActivitypage = driver.findElement(By.xpath(CreateNewSalesActivitypage));
			wait.until(ExpectedConditions.visibilityOf(CreateSalesActivitypage));
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(ActivitytypeDropdown, driver);
			Thread.sleep(2000);
			Common_Methods.selectFormDropdown(Activitytypelist, driver, ActivityTypevalue);
			Thread.sleep(2000);
			Common_Methods.enterDataToTextField_Xpath(Activitydate, driver, Activitydatevalue);
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(statusdropdown, driver);
			Thread.sleep(2000);
			Common_Methods.selectFormDropdown(Statuslist, driver, StatusValue);
			Thread.sleep(2000);
			Common_Methods.enterDataToTextField_Xpath(PreVisitObjectiveField, driver, PreVisitObjectiveFieldvalue);
			Thread.sleep(2000);
			Common_Methods.enterDataToTextField_Xpath(PostVisitNotesField, driver, PostVisitNotesFieldvalue);
			Thread.sleep(2000);
			
			if (StatusValue.equalsIgnoreCase("Abandoned")) {
			WebElement Abandoneddropdown = driver.findElement(By.xpath(AbandonedDropdown));
			Abandoneddropdown.click();
			Thread.sleep(2000);
			Common_Methods.selectFormDropdown(AbandonedList, driver, Abandonedvalue);
			Thread.sleep(2000);
			}
			Common_Methods.clickEleBy_Xpath(Createbtn, driver);
			Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(Sucessok, driver);
			Thread.sleep(2000);
		}
		}




