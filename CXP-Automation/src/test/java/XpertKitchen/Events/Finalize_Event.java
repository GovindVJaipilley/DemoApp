package XpertKitchen.Events;

import java.awt.Robot;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import XpertKitchen.LoginPage.Base_Class;
import Utilities.Common_Methods;
import Utilities.ExcelRead;
import Utilities.ReadPropFile;

public class Finalize_Event {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	ReadPropFile prop;
	Actions myActions;
	ExcelRead excel;
	Robot robot;
	String path; 
	//static String event_Id;
 
	@BeforeTest
	public void FinalizeEvent_Before() throws IOException
	{
		
		driver = Base_Class.getDriver();
		path = Base_Class.getTestDataPath();
		wait = Base_Class.getWebDriverWait();
		myActions = new Actions(driver);
		prop = new ReadPropFile();
		excel = new ExcelRead(path);
		js = Base_Class.getJSExecutor();
		robot = Base_Class.getRobot();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Base_Class.sheetStatus = "Pass";
	}
	
	@Test(dependsOnGroups = "Menu")
	public void finalize_Menu() throws InterruptedException
	{
		Common_Methods.waitForElement_Xpath(prop.getFinalizeB(), wait, "elementToBeClickable");
		Common_Methods.clickEleBy_Xpath(prop.getFinalizeB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getYesB(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getOkButton(), driver);
		Common_Methods.clickEleBy_Xpath(prop.getCloseButton(), driver);
		Thread.sleep(3000);
		Assert.assertEquals(Common_Methods.getElementText_Xpath(prop.getEventStatus_Sent(), driver), excel.getCellData("Add_Menu", 5, 2));
	}
	
	@Test(dependsOnMethods = "finalize_Menu")
	public void acceptMenu_Kitchen() throws InterruptedException
	{
		Common_Methods.navigateToKit_EvtListing(prop, driver, wait);
		
		Common_Methods.clickEleBy_Xpath(prop.getSentStatus(), driver);
		Thread.sleep(2000);		
    Common_Methods.clickEleBy_Xpath(prop.getAcceptBU(), driver);
    Thread.sleep(2000);
    Common_Methods.clickEleBy_Xpath(prop.getOkBU(), driver);
    Thread.sleep(2000);
    Common_Methods.clickEleBy_Xpath(prop.getClickNewOrder(), driver);
    Thread.sleep(2000);
    Common_Methods.enterDataToTextField_Xpath(prop.getEnterNewOrderName(), driver, excel.getCellData("Add_NonStandard", 0, 4));
	Common_Methods.enterDataToTextField_Xpath(prop.getEnterGuestCount(), driver, excel.getCellData("Add_NonStandard", 1, 4));
	Common_Methods.enterDataToTextField_Xpath(prop.getEnterComments(), driver, excel.getCellData("Add_NonStandard", 2, 4));
	Common_Methods.clickEleBy_Xpath(prop.getNewOrder(), driver);
	Common_Methods.clickEleBy_Xpath(prop.getOkButton(), driver);
	 Thread.sleep(2000);
	    Common_Methods.clickEleBy_Xpath(prop.getClickNewOrder(), driver);
	    Thread.sleep(2000);
    Common_Methods.enterDataToTextField_Xpath(prop.getEnterNewOrderName(), driver, excel.getCellData("Add_NonStandard", 0, 5));
 	Common_Methods.enterDataToTextField_Xpath(prop.getEnterGuestCount(), driver, excel.getCellData("Add_NonStandard", 1, 5));
 	Common_Methods.enterDataToTextField_Xpath(prop.getEnterComments(), driver, excel.getCellData("Add_NonStandard", 2, 5));
 	Common_Methods.clickEleBy_Xpath(prop.getBlankOrder(), driver);
 	Common_Methods.clickEleBy_Xpath(prop.getOkButton(), driver);
 	Thread.sleep(2000);
 	Common_Methods.clickEleBy_Xpath(prop.getCloseBU2(), driver);
 /*Quentification*/
 	Thread.sleep(2000);
 	Common_Methods.clickEleBy_Xpath(prop.getQuantifiedStatusNo(), driver);
 	Thread.sleep(2000);
 	
 	Common_Methods.clickEleBy_Xpath(prop.getClickAdd(), driver);
    Common_Methods.enterDataToTextField_Xpath(prop.getEnterQty(), driver, excel.getCellData("Quntification", 0, 2));
    Common_Methods.clickEleBy_Xpath(prop.getPrepItemName(), driver);
    Common_Methods.clickEleBy_Xpath(prop.getSelectPrepType(), driver);
    Common_Methods.clickEleBy_Xpath(prop.getClickAdd1(), driver);
    Thread.sleep(2000);
    Common_Methods.clickEleBy_Xpath(prop.getClckSave(), driver);
    Thread.sleep(2000);
	Common_Methods.clickEleBy_Xpath(prop.getOkButton2(), driver);
	Common_Methods.clickEleBy_Xpath(prop.getClickQuantifyAll(), driver);
	Thread.sleep(2000);
	Common_Methods.clickEleBy_Xpath(prop.getOkButton2(), driver);
	Thread.sleep(2000);
	Common_Methods.clickEleBy_Xpath(prop.getClickGatherAll(), driver);
	Thread.sleep(2000);
	Common_Methods.clickEleBy_Xpath(prop.getOkButton2(), driver);

	 Common_Methods.clickEleBy_Xpath(prop.getClckSave(), driver);
	    Thread.sleep(2000);
		Common_Methods.clickEleBy_Xpath(prop.getOkButton2(), driver);
		 Thread.sleep(2000);
			Common_Methods.clickEleBy_Xpath(prop.getClckClose(), driver);
			
			
			//production
			
	 Common_Methods.clickEleBy_Xpath(prop.getMenu1(), driver);
			 //   Common_Methods.clickEleBy_Xpath(prop.getKitchen(), driver);
			    Thread.sleep(2000);
			    Common_Methods.clickEleBy_Xpath(prop.getproductioncheckoff(), driver);
			  
			    Common_Methods.enterDataToTextField_Xpath(prop.getEvent(), driver, Filter_Event.event_Id);
			    Common_Methods.clickEleBy_Xpath(prop.getClickEdited(), driver);
		        Common_Methods.selectFormDropdown(prop.getClickEditedUl(), driver, excel.getCellData("ProductionCheckOff", 2, 2));
			    Common_Methods.clickEleBy_Xpath(prop.getClickDone(), driver);
		        Common_Methods.selectFormDropdown(prop.getClickDoneUl(), driver, excel.getCellData("ProductionCheckOff", 1, 2));
		        Common_Methods.clickEleBy_Xpath(prop.getClickBusinessUnits(), driver);
		        Common_Methods.selectFormDropdown(prop.getClickSelectBusinessUnit(), driver, excel.getCellData("ProductionCheckOff", 3, 2));
				Common_Methods.enterDataToTextField_Xpath(prop.getPrepName(), driver, excel.getCellData("ProductionCheckOff", 4, 2));
				  Common_Methods.clickEleBy_Xpath(prop.getprepTypyIds(), driver);
			        Common_Methods.selectFormDropdown(prop.getprepTypeIdsUl(), driver, excel.getCellData("ProductionCheckOff", 5, 2));
					  Common_Methods.clickEleBy_Xpath(prop.getLocationDB(), driver);
				        Common_Methods.selectFormDropdown(prop.getLocationDbUl(), driver, excel.getCellData("ProductionCheckOff", 6, 2));

				//
				  Common_Methods.clickEleBy_Xpath(prop.getClickEventBegin(), driver);
			        Common_Methods.selectMonthAndYearInDate(excel.getCellData("ProductionCheckOff", 7, 2), excel.getCellData("ProductionCheckOff", 8, 2), prop.getmonthTable(), driver, prop);
					Common_Methods.selectDayInDate(excel.getCellData("ProductionCheckOff", 9, 2), prop.getdayTable(), driver);
					Common_Methods.clickEleBy_Xpath(prop.getClickEventEnd(), driver);
				    Common_Methods.selectMonthAndYearInDate(excel.getCellData("ProductionCheckOff", 10, 2), excel.getCellData("ProductionCheckOff", 11, 2), prop.getmonthTable(), driver, prop);
					Common_Methods.selectDayInDate(excel.getCellData("ProductionCheckOff", 12, 2), prop.getdayTable(), driver);
				        
					Common_Methods.clickEleBy_Xpath(prop.getMakeBegin(), driver);
				    Common_Methods.selectMonthAndYearInDate(excel.getCellData("ProductionCheckOff", 13, 2), excel.getCellData("ProductionCheckOff", 14, 2), prop.getmonthTable(), driver, prop);
				    Common_Methods.selectDayInDate(excel.getCellData("ProductionCheckOff", 15, 2), prop.getdayTable(), driver);
				    Common_Methods.clickEleBy_Xpath(prop.getMakeEnd(), driver);
				    Common_Methods.selectMonthAndYearInDate(excel.getCellData("ProductionCheckOff", 16, 2), excel.getCellData("ProductionCheckOff", 17, 2), prop.getmonthTable(), driver, prop);
					Common_Methods.selectDayInDate(excel.getCellData("ProductionCheckOff", 18, 2), prop.getdayTable(), driver);
					Common_Methods.clickEleBy_Xpath(prop.getClickChanged(), driver);
				   Common_Methods.selectFormDropdown(prop.getClickChangedDbUrl(), driver, excel.getCellData("ProductionCheckOff", 19, 2));
				  Common_Methods.clickEleBy_Xpath(prop.getClickDeleted(), driver);
			      Common_Methods.selectFormDropdown(prop.getClickDeletedDbUl(), driver, excel.getCellData("ProductionCheckOff", 20, 2));
				 Common_Methods.clickEleBy_Xpath(prop.getClickGoButton(), driver);
			    // Common_Methods.clickEleBy_Xpath(prop.getOKBU4(), driver);
				 Thread.sleep(2000);
			    Common_Methods.clickEleBy_Xpath(prop.getClickRest(), driver);
			    Common_Methods.enterDataToTextField_Xpath(prop.getEvent(), driver, Filter_Event.event_Id);
			    Common_Methods.clickEleBy_Xpath(prop.getClickEventBegin(), driver);
		        Common_Methods.selectMonthAndYearInDate(excel.getCellData("ProductionCheckOff", 7, 2), excel.getCellData("ProductionCheckOff", 8, 2), prop.getmonthTable(), driver, prop);
				Common_Methods.selectDayInDate(excel.getCellData("ProductionCheckOff", 9, 2), prop.getdayTable(), driver);
				Common_Methods.clickEleBy_Xpath(prop.getClickEventEnd(), driver);
			    Common_Methods.selectMonthAndYearInDate(excel.getCellData("ProductionCheckOff", 10, 2), excel.getCellData("ProductionCheckOff", 11, 2), prop.getmonthTable(), driver, prop);
				Common_Methods.selectDayInDate(excel.getCellData("ProductionCheckOff", 12, 2), prop.getdayTable(), driver);

				 Common_Methods.clickEleBy_Xpath(prop.getClickGoButton(), driver);
			  //  Common_Methods.clickEleBy_Xpath(prop.getClickRest(), driver);
			  
				 Thread.sleep(2000);
				 
		// purchage senario1
				 
				   Common_Methods.clickEleBy_Xpath(prop.getMenu1(), driver);	 
				   Common_Methods.clickEleBy_Xpath(prop.getPurchase(), driver);
					Common_Methods.enterDataToTextField_Xpath(prop.getEvent(), driver, Filter_Event.event_Id);
				 
					
				 
					 Thread.sleep(2000);
					    Common_Methods.clickEleBy_Xpath(prop.getClickEdited(), driver);
				        Common_Methods.selectFormDropdown(prop.getClickEditedUl(), driver, excel.getCellData("Purchase", 1, 2));
					    Common_Methods.clickEleBy_Xpath(prop.getClickDone(), driver);
				        Common_Methods.selectFormDropdown(prop.getClickDoneUl(), driver, excel.getCellData("Purchase", 2, 2));
				        Common_Methods.clickEleBy_Xpath(prop.getClickBusinessUnits(), driver);
				        Common_Methods.selectFormDropdown(prop.getClickSelectBusinessUnit(), driver, excel.getCellData("Purchase", 3, 2));
				        Common_Methods.clickEleBy_Xpath(prop.getpurchaseTypeId(), driver);
				        Common_Methods.selectFormDropdown(prop.getSelectpurchaseTypeId(), driver, excel.getCellData("Purchase", 4, 2));
				        Common_Methods.clickEleBy_Xpath(prop.getClickPurchased(), driver);
				        Common_Methods.selectFormDropdown(prop.getSelectPurchasedUl(), driver, excel.getCellData("Purchase", 5, 2));
						Common_Methods.enterDataToTextField_Xpath(prop.getPrepName(), driver, excel.getCellData("Purchase", 6, 2));
				        Common_Methods.clickEleBy_Xpath(prop.getClickEventBegin(), driver);
				        Common_Methods.selectMonthAndYearInDate(excel.getCellData("Purchase", 7, 2), excel.getCellData("Purchase", 8, 2), prop.getmonthTable(), driver, prop);
						Common_Methods.selectDayInDate(excel.getCellData("Purchase", 9, 2), prop.getdayTable(), driver);
						Common_Methods.clickEleBy_Xpath(prop.getClickEventEnd(), driver);
					    Common_Methods.selectMonthAndYearInDate(excel.getCellData("Purchase", 10, 2), excel.getCellData("Purchase", 11, 2), prop.getmonthTable(), driver, prop);
						Common_Methods.selectDayInDate(excel.getCellData("Purchase", 12, 2), prop.getdayTable(), driver);
					        
						Common_Methods.clickEleBy_Xpath(prop.getMakeBegin(), driver);
					    Common_Methods.selectMonthAndYearInDate(excel.getCellData("Purchase", 13, 2), excel.getCellData("Purchase", 14, 2), prop.getmonthTable(), driver, prop);
					    Common_Methods.selectDayInDate(excel.getCellData("Purchase", 15, 2), prop.getdayTable(), driver);
					    Common_Methods.clickEleBy_Xpath(prop.getMakeEnd(), driver);
					    Common_Methods.selectMonthAndYearInDate(excel.getCellData("Purchase", 16, 2), excel.getCellData("Purchase", 17, 2), prop.getmonthTable(), driver, prop);
						Common_Methods.selectDayInDate(excel.getCellData("Purchase", 18, 2), prop.getdayTable(), driver);
						Common_Methods.clickEleBy_Xpath(prop.getPurchaseGrp(), driver);
					    Common_Methods.selectFormDropdown(prop.getPurchaseGrpUl(), driver, excel.getCellData("Purchase", 19, 2));
					    Common_Methods.clickEleBy_Xpath(prop.getClickChanged(), driver);
					    Common_Methods.selectFormDropdown(prop.getClickChangedDbUrl(), driver, excel.getCellData("Purchase", 20, 2));
					    Common_Methods.clickEleBy_Xpath(prop.getClickDeleted(), driver);
					    Common_Methods.selectFormDropdown(prop.getClickDeletedDbUl(), driver, excel.getCellData("Purchase", 21, 2));
					    Common_Methods.clickEleBy_Xpath(prop.getClickGoButton(), driver);
					  
				 //click check box
						 Thread.sleep(2000);
						 Common_Methods.clickEleBy_Xpath(prop.getRset(), driver);
			// purchage senario2
									Common_Methods.enterDataToTextField_Xpath(prop.getEvent(), driver, Filter_Event.event_Id);
								 
									 Common_Methods.clickEleBy_Xpath(prop.getClickGoButton(), driver);
									 Thread.sleep(2000);
									// Common_Methods.clickEleBy_Xpath(prop.getClickCheckBox1(), driver); 
									 //Common_Methods.clickEleBy_Xpath(prop.getSave1(), driver);
									 //Thread.sleep(2000);
									 //Common_Methods.clickEleBy_Xpath(prop.getOKBU4(), driver);
									 Thread.sleep(2000);
									 Common_Methods.clickEleBy_Xpath(prop.getRset(), driver);
									 
									 
				 
    		// purchage senario3	 
				 
										Common_Methods.enterDataToTextField_Xpath(prop.getEvent(), driver, Filter_Event.event_Id);
				 
										 Common_Methods.clickEleBy_Xpath(prop.getClickEventBegin(), driver);
									        Common_Methods.selectMonthAndYearInDate(excel.getCellData("Purchase", 7, 2), excel.getCellData("Purchase", 8, 2), prop.getmonthTable(), driver, prop);
											Common_Methods.selectDayInDate(excel.getCellData("Purchase", 9, 2), prop.getdayTable(), driver);
											Common_Methods.clickEleBy_Xpath(prop.getClickEventEnd(), driver);
										    Common_Methods.selectMonthAndYearInDate(excel.getCellData("Purchase", 10, 2), excel.getCellData("Purchase", 11, 2), prop.getmonthTable(), driver, prop);
											Common_Methods.selectDayInDate(excel.getCellData("Purchase", 12, 2), prop.getdayTable(), driver);
											 Common_Methods.clickEleBy_Xpath(prop.getClickGoButton(), driver);
											 Thread.sleep(5000);
											 
											Common_Methods.clickEleBy_Xpath(prop.getSave1(), driver);
											 Thread.sleep(2000);
											 Common_Methods.clickEleBy_Xpath(prop.getOKBU4(), driver);
											 Thread.sleep(2000);
											 System.out.println("OkBu4 working");
											 Common_Methods.clickEleBy_Xpath(prop.getRset(), driver);
											 System.out.println("Rset working");
											 
											 
											 
					//service logger
											 Common_Methods.clickEleBy_Xpath(prop.getMenu1(), driver);
											 Common_Methods.clickEleBy_Xpath(prop.getEventListing(), driver);
											 Common_Methods.clickEleBy_Xpath(prop.getMenu2(), driver);
											 Common_Methods.clickEleBy_Xpath(prop.getClickServiceLogger(), driver);
											 Thread.sleep(2000);
											 System.out.println("ServiceLogger working");
											 Common_Methods.clickEleBy_Xpath(prop.getServiceLogerClose1(), driver); 	
											 System.out.println("ServiceLogerClose1 is working");
											 Thread.sleep(2000);
											 Common_Methods.clickEleBy_Xpath(prop.getMenu2(), driver);
											 Common_Methods.clickEleBy_Xpath(prop.getClickMenuChanges(), driver);
											 Thread.sleep(2000);
											 Common_Methods.clickEleBy_Xpath(prop.getMenuChangesCloseButton(), driver); 
											 Thread.sleep(2000);
											 Common_Methods.clickEleBy_Xpath(prop.getMenu2(), driver);
											 Common_Methods.clickEleBy_Xpath(prop.getEventNotes(), driver);
										Common_Methods.enterDataToTextField_Xpath(prop.getEnterNotes(), driver, excel.getCellData("EventNotes", 0, 2));
										Common_Methods.clickEleBy_Xpath(prop.getSave2(), driver);
										 Thread.sleep(2000);
										 Common_Methods.clickEleBy_Xpath(prop.getOKBU4(), driver);
										 Thread.sleep(2000);
										 System.out.println("OkBu4 working");
										 Common_Methods.clickEleBy_Xpath(prop.getNotesDelete(), driver);
										 Thread.sleep(2000);
										 System.out.println("NotesDelete Working");
										 Common_Methods.clickEleBy_Xpath(prop.getDeleteYes(), driver);
										 Thread.sleep(2000);
										 Common_Methods.clickEleBy_Xpath(prop.getOKBU4(), driver);
										 Thread.sleep(2000);
										 Common_Methods.enterDataToTextField_Xpath(prop.getEnterNotes(), driver, excel.getCellData("EventNotes", 0, 3));
										 Thread.sleep(2000);
											Common_Methods.clickEleBy_Xpath(prop.getSave3(), driver);
											 Thread.sleep(2000);
											 Common_Methods.clickEleBy_Xpath(prop.getOKBU4(), driver);
											 Thread.sleep(2000);
											 Common_Methods.clickEleBy_Xpath(prop.getEventNotesCloseButton(), driver); 
											 Thread.sleep(2000);
											 Common_Methods.clickEleBy_Xpath(prop.getMenu2(), driver);
											 Thread.sleep(2000);
											 Common_Methods.clickEleBy_Xpath(prop.getEventhistory(), driver); 
											 Thread.sleep(2000);
											 Common_Methods.clickEleBy_Xpath(prop.getEventHistoryCloseButton(), driver); 
											 Thread.sleep(2000);
							 //repeat event
											 Common_Methods.clickEleBy_Xpath(prop.getMenu1(), driver);
											 Thread.sleep(2000);
											 Common_Methods.clickEleBy_Xpath(prop.getClickSales(), driver);
											 Thread.sleep(2000);
											 Common_Methods.clickEleBy_Xpath(prop.getClickSalesEventList(), driver);
											 Thread.sleep(2000);
											 Common_Methods.clickEleBy_Xpath(prop.getSalesMenu1(), driver);
											 Common_Methods.clickEleBy_Xpath(prop.getRepeatEvent(), driver);
											 Thread.sleep(2000);
									//begintime 
										/*	 Common_Methods.clickEleBy_Xpath(prop.getCEBeginDate(), driver);
											 System.out.println("test1");
												Common_Methods.selectMonthAndYearInDate(excel.getCellData("RepeateEvent", 0, 2), excel.getCellData("RepeateEvent", 1, 2), prop.getmonthTable(), driver, prop);
												System.out.println("test1");
												Common_Methods.selectDayInDate(excel.getCellData("RepeateEvent", 2, 2), prop.getdayTable(), driver);
												System.out.println("test1");
												Common_Methods.clickEleBy_Xpath(prop.getBeginTime(), driver);
												Common_Methods.clickOnTime(driver, prop, excel.getCellData("RepeateEvent", 3, 2));
												Thread.sleep(2000);
									//Endtime 		
												Common_Methods.clickEleBy_Xpath(prop.getCEEndDate(), driver);
												Common_Methods.selectMonthAndYearInDate(excel.getCellData("RepeateEvent", 4, 2), excel.getCellData("RepeateEvent", 5, 2), prop.getmonthTable(), driver, prop);
												Common_Methods.selectDayInDate(excel.getCellData("RepeateEvent", 6, 2), prop.getdayTable(), driver);
												Common_Methods.clickEleBy_Xpath(prop.getCEEndTime(), driver);
												Common_Methods.clickOnTime(driver, prop, excel.getCellData("RepeateEvent", 7, 2));
												*/
												Thread.sleep(2000);
												Common_Methods.clickEleBy_Xpath(prop.getUnCheckMenuCheckBox(), driver);
												Thread.sleep(2000);
												 Common_Methods.clickEleBy_Xpath(prop.getRsave(), driver);
												 Thread.sleep(2000);
												 System.out.println("Rsave working");
												 Common_Methods.clickEleBy_Xpath(prop.getOkBu3(), driver);
												 Thread.sleep(2000);
												 System.out.println("OkBu3 working");
												 Thread.sleep(2000);
												String p= Common_Methods.getElementText_Xpath(prop.getRepeate(), driver);
												System.out.println(p);
												Thread.sleep(2000);
												Common_Methods.clickEleBy_Xpath(prop.getClose1(), driver);
												 Thread.sleep(2000);
									//filter			 
												 Common_Methods.clickEleBy_Xpath(prop.getFilter2(), driver);
												 Thread.sleep(2000);
												 System.out.println("Filter2 working");
												 Common_Methods.clickEleBy_Xpath(prop.getReset2(), driver);
												 System.out.println("Reset button working");
												 Thread.sleep(2000);
											Common_Methods.enterDataToTextField_Xpath(prop.getSearchFild(), driver, p);
											Thread.sleep(2000);
											System.out.println("searchFild is working");
											Common_Methods.clickEleBy_Xpath(prop.getAply(), driver);
											System.out.println("Aply button working");
						//Repeate Event 2
											Thread.sleep(2000);
											Common_Methods.clickEleBy_Xpath(prop.getFilter2(), driver);
											 Thread.sleep(2000);
											 System.out.println("Filter2 working");
											 Common_Methods.clickEleBy_Xpath(prop.getReset2(), driver);
											 System.out.println("Reset button working");
											 Thread.sleep(2000);
										Common_Methods.enterDataToTextField_Xpath(prop.getSearchFild(), driver, Filter_Event.event_Id);
										 Thread.sleep(2000);
										 Common_Methods.clickEleBy_Xpath(prop.getAply(), driver);
											System.out.println("Aply button working");
											 Thread.sleep(2000);
											
											 
											 
											 Common_Methods.clickEleBy_Xpath(prop.getSalesMenu1(), driver);
											 Common_Methods.clickEleBy_Xpath(prop.getRepeatEvent(), driver);
											 Thread.sleep(2000);
											 Thread.sleep(2000);
												//Common_Methods.clickEleBy_Xpath(prop.getUnCheckMenuCheckBox(), driver);
												//Thread.sleep(2000);
												 Common_Methods.clickEleBy_Xpath(prop.getRsave(), driver);
												 Thread.sleep(2000);
												 System.out.println("Rsave working");
												 Common_Methods.clickEleBy_Xpath(prop.getOkBu3(), driver);
												 Thread.sleep(2000);
												 System.out.println("OkBu3 working");
												String p2= Common_Methods.getElementText_Xpath(prop.getRepeate(), driver);
												System.out.println(p2);
												Common_Methods.clickEleBy_Xpath(prop.getClose1(), driver);
												 Thread.sleep(2000);
							// agin filter			 
												 Common_Methods.clickEleBy_Xpath(prop.getFilter2(), driver);
												 Thread.sleep(2000);
												 System.out.println("Filter2 working");
												 Common_Methods.clickEleBy_Xpath(prop.getReset2(), driver);
												 System.out.println("Reset button working");
												 Thread.sleep(2000);
											Common_Methods.enterDataToTextField_Xpath(prop.getSearchFild(), driver, p2);
											Thread.sleep(2000);
											System.out.println("searchFild is working");
											Common_Methods.clickEleBy_Xpath(prop.getAply(), driver);
											System.out.println("Aply button working");		 
											
											
	}
	}

