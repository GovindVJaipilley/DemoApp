package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class ReadPropFile {

	String configFilePath = "src/test/resources/TestData/Config.properties";
	private Properties properties;
	ExcelRead excel;
	String testDataFilePath = XpertKitchen.LoginPage.Base_Class.getTestDataPath();

	public ReadPropFile() throws IOException {
		properties = new Properties();
		FileInputStream fis = new FileInputStream(configFilePath);
		properties.load(fis);

		excel = new ExcelRead(testDataFilePath);
	}

	/************ LoginPage properties ********************/
	public String getCaterId() {
		return properties.getProperty("CaterId");
	}

	public String getUserId() {
		return properties.getProperty("UserId");
	}

	public String getPassword() {
		return properties.getProperty("Password");
	}

	public String getLogin() {
		return properties.getProperty("login");
	}

	public String getHeader() {
		return properties.getProperty("Header");
	}

	/*********** Logout locators **********/
	public String getLoggedInUser() {
		return properties.getProperty("LoggedInUser");
	}

	public String getLogOut() {
		return properties.getProperty("LogOut");
	}

	public String getConfirmMsg() {
		return properties.getProperty("ConfirmMsg");
	}

	public String getConfirmOk() {
		return properties.getProperty("ConfirmOk");
	}

	public String getConfirmCancel() {
		return properties.getProperty("ConfirmCancel");
	}

	public String getNewEvent() {
		return properties.getProperty("NewEvent");
	}

	public String getOrderStatus() {
		return properties.getProperty("OrderStatus");
	}

	public String getDropdownItem() {
		return properties.getProperty("DropdownItem");
	}

	public String getBeginTime() {
		return properties.getProperty("BeginTIme");
	}

	public String getRadioButton() {
		return properties.getProperty("RadioButton");
	}

	public String getSelectTime() {
		return properties.getProperty("SelectTime");
	}

	public String getEventName() {
		return properties.getProperty("EventName");
	}

	public String getEventType() {
		return properties.getProperty("EventType");
	}

	public String getSelectEventType() {
		return properties.getProperty("SelectEventType");
	}

	public String getLocation() {
		return properties.getProperty("Location");
	}

	public String getLocationDropdown() {
		return properties.getProperty("LocationDropdown");
	}

	public String getPopUp1() {
		return properties.getProperty("PopUp1");
	}

	public String getPopUp2() {
		return properties.getProperty("PopUp2");
	}

	public String getBusinessUnitDdArrow() {
		return properties.getProperty("BusinessUnitDdArrow");
	}

	public String getBusinessUnitDdUl() {
		return properties.getProperty("BusinessUnitDdUl");
	}

	public String getCEBeginDate() {
		return properties.getProperty("BeginDate");
	}

	public String getCEBeginTime() {
		return properties.getProperty("BeginTime");
	}

	public String getCEEndDate() {
		return properties.getProperty("EndDate");
	}

	public String getCEEndTime() {
		return properties.getProperty("EndTime");
	}

	public String getMonthButtonInDatePicker() {
		return properties.getProperty("MonthButtonInDatePicker");
	}

	public String getYearLeftArrowAfterMonthClick() {
		return properties.getProperty("YearLeftArrowAfterMonthClick");
	}

	public String getYearRightArrowAfterMonthClick() {
		return properties.getProperty("YearRightArrowAfterMonthClick");
	}

	public String getYearButtonAfterMonthClick() {
		return properties.getProperty("YearButtonAfterMonthClick");
	}
	
	public String getmonthTable() {
    	return properties.getProperty("MonthTable");
    }
	
	public String getdayTable() {
    	return properties.getProperty("DayTable");
    }
	
	public String getB_E_Time_Table() {
    	return properties.getProperty("B_E_Time_Table");
    }
	
	public String getB_E_Time_Radio() {
    	return properties.getProperty("B_E_Time_Radio");
    }
	
	public String getEventTypeDdArrow() {
    	return properties.getProperty("EventTypeDdArrow");
    }
	
	public String getEventTypeDdUl() {
    	return properties.getProperty("EventTypeDdUl");
    }
	
	public String getAccountExecutiveDdArrow() {
    	return properties.getProperty("AccountExecutiveDdArrow");
    }
	
	public String getAccountExecutiveDdUl() {
    	return properties.getProperty("AccountExecutiveDdUl");
    }
	
	public String getStatusDdArrow() {
    	return properties.getProperty("StatusDdArrow");
    }
	
	public String getStatusDdUl() {
    	return properties.getProperty("StatusDdUl");
    }
	
	public String getLocationNameDdArrow() {
    	return properties.getProperty("LocationNameDdArrow");
    }
	
	public String getLocationNameDdUl() {
    	return properties.getProperty("LocationNameDdUl");
    }
	
	public String getEventThemeDdArrow() {
    	return properties.getProperty("EventThemeDdArrow");
    }
	
	public String getEventThemeDdUl() {
    	return properties.getProperty("EventThemeDdUl");
    }
	
	public String getAdultCount() {
    	return properties.getProperty("AdultCount");
    }
	
	public String getKidsCount() {
    	return properties.getProperty("KidsCount");
    }
	
	public String getProposalName() {
    	return properties.getProperty("Proposal_Name");
    }
	
	public String getKosherCount() {
    	return properties.getProperty("KosherCount");
    }
	
	public String getVendorCount() {
    	return properties.getProperty("VendorCount");
    }
	
	public String getCreateButton() {
    	return properties.getProperty("CreateButton");
    }
	
	public String getAssertText() {
    	return properties.getProperty("AssertText");
    }
	
	public String getOkButton() {
    	return properties.getProperty("OkButton");
    }
	
	public String getCloseButton() {
    	return properties.getProperty("CloseButton");
    }
	
	public String getFilterIcon() {
    	return properties.getProperty("FilterIcon");
    }
	
	public String getEventId() {
    	return properties.getProperty("EventId");
    }
	
	public String getApplyButton() {
    	return properties.getProperty("ApplyButton");
    }
	
	public String getEventId_Gen() {
    	return properties.getProperty("EventId_Gen");
    }
	
	public String getNewButton() {
    	return properties.getProperty("NewButton");
    }
	
	public String getSearchAndAddB() {
    	return properties.getProperty("SearchAndAddB");
    }
	
	public String getMenuCategoryDdArrow() {
    	return properties.getProperty("MenuCategoryDdArrow");
    }
	
	public String getMenuCategoryDdUl() {
    	return properties.getProperty("MenuCategoryDdUl");
    }
	
	public String getMenuSubcategoryDdArrow() {
    	return properties.getProperty("MenuSubcategoryDdArrow");
    }
	
	public String getMenuSubcategoryDdUl() {
    	return properties.getProperty("MenuSubcategoryDdUl");
    }
	
	public String getTemperatureDdArrow() {
    	return properties.getProperty("TemperatureDdArrow");
    }
	
	public String getTemperatureDdUl() {
    	return properties.getProperty("TemperatureDdUl");
    }
	
	public String getSearchB_OnSAndAdd() {
    	return properties.getProperty("SearchB_OnSAndAdd");
    }
	
	public String getMenuCheckB1() {
    	return properties.getProperty("MenuCheckB1");
    }
	
	public String getMenuCheckB2() {
    	return properties.getProperty("MenuCheckB2");
    }
	
	public String getSaveB_OnSAndAdd() {
    	return properties.getProperty("SaveB_OnSAndAdd");
    }
	
	public String getAddB() {
    	return properties.getProperty("AddB");
    }
	
	public String getCourseDdArrow() {
    	return properties.getProperty("CourseDdArrow");
    }
	
	public String getCourseDdUl() {
    	return properties.getProperty("CourseDdUl");
    }
	
	public String getCategoryDdArrow() {
    	return properties.getProperty("CategoryDdArrow");
    }
	
	public String getCategoryDdUl() {
    	return properties.getProperty("CategoryDdUl");
    }
	
	public String getSubcategoryDdArrow() {
    	return properties.getProperty("SubcategoryDdArrow");
    }
	
	public String getSubcategoryDdUl() {
    	return properties.getProperty("SubcategoryDdUl");
    }
	
	public String getMenuItemDdArrow() {
    	return properties.getProperty("MenuItemDdArrow");
    }
	
	public String getMenuItemDdUl() {
    	return properties.getProperty("MenuItemDdUl");
    }
	
	public String getSaveB_OnAdd() {
    	return properties.getProperty("SaveB_OnAdd");
    }
	
	public String getCloseB_OnAddMenu() {
    	return properties.getProperty("CloseB_OnAddMenu");
    }
	
	public String getFinalizeB() {
    	return properties.getProperty("FinalizeB");
    }
	
	public String getYesB() {
    	return properties.getProperty("YesB");
    }
	
	public String getNewEvent_Id() {
    	return properties.getProperty("NewEvent_Id");
    }
	
	public String getEventStatus_Sent() {
    	return properties.getProperty("EventStatus_Sent");
    }
	
	public String getXpertKitchen_MainMenu() {
    	return properties.getProperty("XpertKitchen_MainMenu");
    }
	
	public String getkitchen_header() {
    	return properties.getProperty("kitchen_header");
    }
	
	public String getEventListing_Sales() {
    	return properties.getProperty("EventListing_Sales");
    }
	
	public String get1ItemQty_SandAMenu() {
    	return properties.getProperty("1ItemQty_SandAMenu");
    }
	
	public String get2ItemQty_SandAMenu() {
    	return properties.getProperty("2ItemQty_SandAMenu");
    }

	public String getItemQty_AddMenu() {
    	return properties.getProperty("ItemQty_AddMenu");
    }
	
	public String getItemCost_AddMenu() {
    	return properties.getProperty("ItemCost_AddMenu");
    }
	
	/*********** Add Non Standard Item properties  **********/
	
	public String getNew1() {
    	return properties.getProperty("New1");
    }
	public String getProg() {
    	return properties.getProperty("Prog");
    }
	public String getAddButton() {
    	return properties.getProperty("AddButton");
    }
	public String getCourseDdArrow1() {
    	return properties.getProperty("CourseDdArrow1");
    }
	public String getCourseDdUl1() {
    	return properties.getProperty("CourseDdUl1");
    }
	public String getCategoryDdArrow1() {
    	return properties.getProperty("CategoryDdArrow1");
    }
	public String getCategoryDdUl1() {
    	return properties.getProperty("CategoryDdUl1");
    }
	public String getNewMenuItem() {
    	return properties.getProperty("NewMenuItem");
    }
	public String getSaveB_OnAdd1() {
    	return properties.getProperty("SaveB_OnAdd1");
    }
	
	
	/*********** Ack_Rej_Services  **********/
	
	
	public String getMenu() {
    	return properties.getProperty("Menu");
    }
	public String getKitchen() {
    	return properties.getProperty("Kitchen");
    }
	public String getEventListing() {
    	return properties.getProperty("EventListing");
    }
	public String getSentStatus() {
    	return properties.getProperty("SentStatus");
    }
	public String getAcceptBU() {
    	return properties.getProperty("AcceptBU");
    }
	public String getRejectBU() {
    	return properties.getProperty("RejectBU");
    }
	public String getOkBU() {
    	return properties.getProperty("OkBU");
    }
	public String getClickNewOrder() {
    	return properties.getProperty("ClickNewOrder");
    }public String getEnterNewOrderName() {
    	return properties.getProperty("EnterNewOrderName");
    }public String getEnterGuestCount() {
    	return properties.getProperty("EnterGuestCount");
    }public String getEnterComments() {
    	return properties.getProperty("EnterComments");
    }public String getNewOrder() {
    	return properties.getProperty("NewOrder");
    }public String getBlankOrder() {
    	return properties.getProperty("BlankOrder");
    }
	public String getCrossSymbol1() {
    	return properties.getProperty("CrossSymbol1");
    }
	public String getCloseBU() {
    	return properties.getProperty("CloseBU");
    }
	
	/*********** Quantified  **********/
	public String getQuantifiedStatusNo() {
    	return properties.getProperty("QuantifiedStatusNo");
    }
	public String getQuantifiedStatusyes() {
    	return properties.getProperty("QuantifiedStatusyes");
    }
	public String getClickQuantifyAll() {
    	return properties.getProperty("ClickQuantifyAll");
    }
	public String getClickGatherAll() {
    	return properties.getProperty("ClickGatherAll");
    }
	public String getClickDeleteGather() {
    	return properties.getProperty("ClickDeleteGather");
    }public String getClickDeleteGatherYes() {
    	return properties.getProperty("ClickDeleteGatherYes");
    }public String getClickDeleteCancel() {
    	return properties.getProperty("ClickDeleteCancel");
    }public String getClickUpdatePrepQuantity() {
    	return properties.getProperty("ClickUpdatePrepQuantity");
    }public String getClickUpdatePrepQuantityYes() {
    	return properties.getProperty("ClickUpdatePrepQuantityYes");
    }public String getClickDeleteCancel1() {
    	return properties.getProperty("ClickDeleteCancel1");
    }public String getClickUpdatePrepDate() {
    	return properties.getProperty("ClickUpdatePrepDate");
    }public String getClickUpdateGather() {
    	return properties.getProperty("ClickUpdateGather");
    }public String getClickRefreshContent() {
    	return properties.getProperty("ClickRefreshContent");
    }public String getClickAdd1() {
    	return properties.getProperty("ClickAdd1");
    }
    public String getClickAdd() {
    	return properties.getProperty("ClickAdd");
    }public String getClickSave() {
    	return properties.getProperty("ClickSave");
    }
	public String getOkButton2() {
    	return properties.getProperty("OkButton2");
    }public String getEnterQty() {
    	return properties.getProperty("EnterQty");
    }public String getPrepItemName() {
    	return properties.getProperty("PrepItemName");
    }public String getSelectPrepType() {
    	return properties.getProperty("SelectPrepType");
    }
	public String getClckSave() {
    	return properties.getProperty("ClckSave");
    }
	public String getClckClose() {
    	return properties.getProperty("ClckClose");
    }
	public String getServiceLogerClose1() {
    	return properties.getProperty("ServiceLogerClose1");
    }
	public String getMenuChangesCloseButton() {
    	return properties.getProperty("MenuChangesCloseButton");
    }
	public String getEventNotesCloseButton() {
    	return properties.getProperty("EventNotesCloseButton");
    }
	public String getEventHistoryCloseButton() {
    	return properties.getProperty("EventHistoryCloseButton");
    }
	
	/*********** Create Customer  **********/
	public String getMenu1() {
    	return properties.getProperty("Menu1");
	}
	public String getSales1Click() {
    	return properties.getProperty("Sales1Click");
	}
	public String getCustomerList() {
    	return properties.getProperty("CustomerList");
    }
	public String getNewCustomer() {
    	return properties.getProperty("NewCustomer");
    }
	public String getCustomerTypes() {
    	return properties.getProperty("CustomerTypes");
    }
	public String getCustomerName() {
    	return properties.getProperty("CustomerName");
	}
	public String getFirstName() {
    	return properties.getProperty("FirstName");
	}
	public String getEnterStreet() {
    	return properties.getProperty("EnterStreet");
	}
	public String getEnterCity() {
    	return properties.getProperty("EnterCity");
	}
	public String getStateId() {
    	return properties.getProperty("StateId");
	}
	public String getSelectState() {
    	return properties.getProperty("SelectState");
	}
	public String getZipCode() {
    	return properties.getProperty("ZipCode");
	}
	public String getHomePhone() {
    	return properties.getProperty("HomePhone");
	}
	public String getCheckBox() {
    	return properties.getProperty("CheckBox");
	}
	public String getReferalTypes() {
    	return properties.getProperty("ReferalTypes");
	}
	public String getSelectType() {
    	return properties.getProperty("SelectType");
	}
	public String getSelectBu1() {
    	return properties.getProperty("SelectBu1");
	}
	public String getClickButton() {
    	return properties.getProperty("ClickButton");
	}
	
	
	/*********** Purchase  **********/
	
	
	public String getPurchase() {
    	return properties.getProperty("Purchase");
	}
	public String getEvent() {
    	return properties.getProperty("Event");
	}
	public String getClickEdited() {
    	return properties.getProperty("ClickEdited");
	}
	public String getClickEditedUl() {
    	return properties.getProperty("ClickEditedUl");
	}
	public String getClickDone() {
    	return properties.getProperty("ClickDone");
	}
	public String getClickDoneUl() {
    	return properties.getProperty("ClickDoneUl");
	}
	public String getClickBusinessUnits() {
    	return properties.getProperty("ClickBusinessUnits");
	}
	public String getClickSelectBusinessUnit() {
    	return properties.getProperty("ClickSelectBusinessUnit");
	}
   public String getpurchaseTypeId() {
	    return properties.getProperty("purchaseTypeId");
   }
   public String getSelectpurchaseTypeId() {
	    return properties.getProperty("SelectpurchaseTypeId");
    }
  public String getClickPurchased() {
	   return properties.getProperty("ClickPurchased");
   }
   public String getSelectPurchasedUl() {
	   return properties.getProperty("SelectPurchasedUl");
   }
   public String getPrepName() {
	   return properties.getProperty("PrepName");
   }


	public String getClickEventBegin() {
	return properties.getProperty("ClickEventBegin");
    }
   
	public String getClickEventEnd() {
    	return properties.getProperty("ClickEventEnd");
	}
	public String getMakeBegin() {
    	return properties.getProperty("MakeBegin");
	}
	public String getMakeEnd() {
    	return properties.getProperty("MakeEnd");
	}
	public String getPurchaseGrp() {
    	return properties.getProperty("PurchaseGrp");
	}
	public String getPurchaseGrpUl() {
    	return properties.getProperty("PurchaseGrpUl");
	}
	public String getClickChanged() {
    	return properties.getProperty("ClickChanged");
	}
	public String getClickChangedDbUrl() {
    	return properties.getProperty("ClickChangedDbUrl");
	}
	public String getClickDeleted() {
    	return properties.getProperty("ClickDeleted");
	}
	public String getClickDeletedDbUl() {
    	return properties.getProperty("ClickDeletedDbUl");
	}
	public String getClickGoButton() {
    	return properties.getProperty("ClickGoButton");
	}
	public String getClickResetButtton() {
    	return properties.getProperty("ClickResetButtton");
	}
	public String getClickReports() {
    	return properties.getProperty("ClickReports");
	}
	public String getCloseBU2() {
    	return properties.getProperty("CloseBU2");
	}

	

	public String getSales11() {
		
		return properties.getProperty("Sales11");
	}

	public String getOKBU4() {
    	return properties.getProperty("OKBU4");
	}
	public String getRset() {
    	return properties.getProperty("Rset");
	}
	public String getClickCheckBox1() {
    	return properties.getProperty("ClickCheckBox1");
	}
	public String getSave1() {
    	return properties.getProperty("Save1");
	}
	public String getSave2() {
    	return properties.getProperty("Save2");
    	
	}
	
	
	/*********** Servicelogger  **********/
	
	public String getMenu2() {
    	return properties.getProperty("Menu2");
	}
	public String getClickServiceLogger() {
    	return properties.getProperty("ClickServiceLogger");
	}
	public String getClickMenuChanges() {
    	return properties.getProperty("ClickMenuChanges");
	}
	public String getEventNotes() {
    	return properties.getProperty("EventNotes");
	}public String getEnterNotes() {
    	return properties.getProperty("EnterNotes");
	}
	public String getNotesDelete() {
    	return properties.getProperty("NotesDelete");
	}
	public String getDeleteYes() {
    	return properties.getProperty("DeleteYes");
	}
	public String getEventhistory() {
    	return properties.getProperty("Eventhistory");
	}
	public String getSave3() {
    	return properties.getProperty("Save3");
    	
	}
	/*******Repeat Event  **********/
	public String getClickSales() {
    	return properties.getProperty("ClickSales");
	}
	public String getClickSalesEventList() {
    	return properties.getProperty("ClickSalesEventList");
	}
	public String getSalesMenu1() {
    	return properties.getProperty("SalesMenu1");
    	
	}
	public String getRepeatEvent() {
    	return properties.getProperty("RepeatEvent");
    	}
	public String getUnCheckMenuCheckBox() {
    	return properties.getProperty("UnCheckMenuCheckBox");
    	}
	public String getRsave() {
    	return properties.getProperty("Rsave");
    	}
	
/***create contact **/
	
	public String getContactLIst() {
		return properties.getProperty("ContactLIst");
	}
 
	public String getNewContact() {
		return properties.getProperty("NewContact");
	}
 
	public String getAE() {
		return properties.getProperty("AE");
	}
 
	public String getSelectAE() {
		return properties.getProperty("SelectAE");
	}
 
	public String getFirstName1() {
		return properties.getProperty("FirstName1");
	}
 
	public String getlastName() {
		return properties.getProperty("lastName");
	}
 
	public String getInternationalAddress() {
		return properties.getProperty("InternationalAddress");
	}
 
	public String getState() {
		return properties.getProperty("State");
	}
 
	public String getphoneNumber() {
		return properties.getProperty("phoneNumber");
	}
 
	public String getStreet() {
		return properties.getProperty("Street");
	}
 
	public String getCity() {
		return properties.getProperty("City");
	}
 
	public String getState1() {
		return properties.getProperty("State1");
	}
 
	public String getSelectState1() {
		return properties.getProperty("SelectState1");
	}
 
	
	public String getZip() {
		return properties.getProperty("Zip");
	}
 
	public String getMobile() {
		return properties.getProperty("Mobile");
	}
	public String getEmail() {
		return properties.getProperty("Email");
	}
	
	public String getBU2() {
		return properties.getProperty("BU2");
	}
	
	public String getSave() {
		return properties.getProperty("Save");
	}
	
	public String getClose() {
		return properties.getProperty("Close");
	}
	public String getOkBu3() {
		return properties.getProperty("OkBu3");
	}
	public String getRepeate() {
		return properties.getProperty("Repeate");
	}
	public String getClose1() {
		return properties.getProperty("Close1");
	}
	public String getFilter2() {
		return properties.getProperty("Filter2");
	}
	public String getSearchFild() {
		return properties.getProperty("SearchFild");
	}
	public String getReset2() {
		return properties.getProperty("Reset2");
	}
	public String getAply() {
		return properties.getProperty("Aply");
	}
	
	
	/*** Production_Check_Off **/
	public String getClickRest() {
		return properties.getProperty("ClickRest");
	}
	
	public String getproductioncheckoff() {
		return properties.getProperty("productioncheckoff");
	}
	public String getprepTypyIds() {
		return properties.getProperty("prepTypyIds");
	}
	public String getprepTypeIdsUl() {
		return properties.getProperty("prepTypeIdsUl");
	}
	public String getLocationDB() {
		return properties.getProperty("LocationDB");
	}
	public String getLocationDbUl() {
		return properties.getProperty("LocationDbUl");
	}
	
	
	/*********************************************** CaterXpert *********************************************/
	
	
/************ LoginPage properties ********************/
	
	public String getCatererID() {
		return properties.getProperty("CatererID");
	}

	public String getUserIdCx() {
		return properties.getProperty("UserID");
	}

	public String getPasswordCx() {
		return properties.getProperty("PassWord");
	}

	public String getLoginCx() {
		return properties.getProperty("Login");
	}

	public String getLoginVerifyText() {
		return properties.getProperty("LoginVerifyText");
	}
	
	/************ HomePage properties ********************/
	
	public String getHomePageB() {
		return properties.getProperty("HomePageB");
	}
	
	public String getLogoutB() {
		return properties.getProperty("LogoutB");
	}
	
	public String getSalesMenu() {
		return properties.getProperty("SalesMenu");
	}
	
	public String getKitchenMenu() {
		return properties.getProperty("KitchenMenu");
	}
	
	public String getAccountingMenu() {
		return properties.getProperty("AccountingMenu");
	}
	
	public String getSchedulingMenu() {
		return properties.getProperty("SchedulingMenu");
	}
	
	public String getWarehouseMenu() {
		return properties.getProperty("WarehouseMenu");
	}
	
	/************ Frames properties ********************/
	
	public String getHeaderFrame() {
		return properties.getProperty("HeaderFrame");
	}
	
	public String getRightFrame() {
		return properties.getProperty("Rightframe");
	}
	
	public String getViewFrame() {
		return properties.getProperty("ViewFrame");
	}
	
	public String getListFrame() {
		return properties.getProperty("ListFrame");
	}
	
	/************ Customer properties ********************/
	
	public String getCustSearch() {
		return properties.getProperty("CustSearch");
	}
	
	public String getNewCustomerCx() {
		return properties.getProperty("NewCustomer");
	}
	
	public String getCustomerTypesCx() {
		return properties.getProperty("CustomerTypes");
	}
	
	public String getCustomerNameCx() {
		return properties.getProperty("CustomerName");
	}
	
	public String getCust_FirstName() {
		return properties.getProperty("Cust_FirstName");
	}
	
	public String getProposalNameCx() {
		return properties.getProperty("ProposalName");
	}
	
	public String getA_Street() {
		return properties.getProperty("A_Street");
	}
	
	public String getA_City() {
		return properties.getProperty("A_City");
	}
	
	public String getA_State() {
		return properties.getProperty("A_State");
	}
	
	public String getA_ZIP() {
		return properties.getProperty("A_ZIP");
	}
	
	public String getA_Phone() {
		return properties.getProperty("A_Phone");
	}
	
	public String getSA_Add_CheckB() {
		return properties.getProperty("SA_Add_CheckB");
	}
	
	public String getBillContactName() {
		return properties.getProperty("BillContactName");
	}
	
	public String getReferralType_BI() {
		return properties.getProperty("ReferralType_BI");
	}
	
	public String getBusinessUnits_BI() {
		return properties.getProperty("BusinessUnits_BI");
	}
	
	public String getCustSave() {
		return properties.getProperty("CustSave");
	}
	
	public String getCustVali_Text() {
		return properties.getProperty("CustVali_Text");
	}
	
	/************ Contact properties ********************/
	
	public String getAccExecutive_Cont() {
		return properties.getProperty("AccExecutive_Cont");
	}
	
	public String getFName_Cont() {
		return properties.getProperty("FName_Cont");
	}
	
	public String getLName_Cont() {
		return properties.getProperty("LName_Cont");
	}
	
	public String getAddCheckB_Cont() {
		return properties.getProperty("AddCheckB_Cont");
	}
	
	public String getPhone_FA() {
		return properties.getProperty("Phone_FA");
	}
	
	public String getMobile_OI() {
		return properties.getProperty("Mobile_OI");
	}
	
	public String getEmail_OI() {
		return properties.getProperty("Email_OI");
	}
	
	public String getCreatB_CustCont() {
		return properties.getProperty("CreatB_CustCont");
	}
	
	public String getNewE_custCont() {
		return properties.getProperty("NewE_custCont");
	}
	
	/************ Event properties ********************/
	
	public String getBeginTime_E() {
		return properties.getProperty("BeginTime_E");
	}
	
	public String getEndTime_E() {
		return properties.getProperty("EndTime_E");
	}
	
	public String getEndAMPM_E() {
		return properties.getProperty("EndAMPM_E");
	}
	
	public String getEventType_E() {
		return properties.getProperty("EventType_E");
	}
	
	public String getStatus_E() {
		return properties.getProperty("Status_E");
	}
	
	public String getBUnit_E() {
		return properties.getProperty("BUnit_E");
	}
	
	public String getAdultCount_E() {
		return properties.getProperty("AdultCount_E");
	}
	
	public String getComments_E() {
		return properties.getProperty("Comments_E");
	}
	
	public String getCreateEventB_E() {
		return properties.getProperty("CreateEventB_E");
	}
	
	public String getSaveB_EC() {
		return properties.getProperty("SaveB_EC");
	}
	
	public String getBeginDate_E() {
		return properties.getProperty("BeginDate_E");
	}
	
	public String getEndDate_E() {
		return properties.getProperty("EndDate_E");
	}
	
	public String getEventTheme_E() {
		return properties.getProperty("EventTheme_E");
	}
	
	public String getEventName_E() {
		return properties.getProperty("EventName_E");
	}
	
	public String getContactName_E() {
		return properties.getProperty("ContactName_E");
	}
	
	public String getLocationName_E() {
		return properties.getProperty("LocationName_E");
	}
	
	public String getEventId_E() {
		return properties.getProperty("EventId_E");
	}
	
	public String getCloseB_ED() {
		return properties.getProperty("CloseB_ED");
	}
	
	public String getEmail_E() {
		return properties.getProperty("Email_E");
	}
	
	public String getAccExecutive_E() {
		return properties.getProperty("AccExecutive_E");
	}
	
	
	/************ Filter_Event properties ********************/
	

	public String getFilterLink_SE() {
		return properties.getProperty("FilterLink_SE");
	}
	
	public String getEventId_TextB() {
		return properties.getProperty("EventId_TextB");
	}
	
	public String getApplyB_F() {
		return properties.getProperty("ApplyB_F");
	}
	
	/************ Test_Event properties ********************/
	
	public String getEventDHTML() {
		return properties.getProperty("EventDHTML");
	}
	
	public String getTestEve_L() {
		return properties.getProperty("TestEve_L");
	}
	
	/************ Repeat_Event properties ********************/
	
	public String getEventDHTML_Re() {
		return properties.getProperty("EventDHTML_Re");
	}
	
	public String getRepeatEve_L() {
		return properties.getProperty("RepeatEve_L");
	}
	
	public String getDMWDiv() {
		return properties.getProperty("DMWDiv");
	}
	
	public String getRepeatTimes_TB() {
		return properties.getProperty("RepeatTimes_TB");
	}
	
	public String getEventID_R() {
		return properties.getProperty("EventID_R");
	}
	
	/************ Event_Sales_Services properties ********************/

	public String getEMenuLink_ELHP() {
		return properties.getProperty("EMenuLink_ELHP");
	}
	
	public String getCreateMeno_Scratch() {
		return properties.getProperty("CreateMeno_Scratch");
	}
	
	public String getEStafLInk_ELHP() {
		return properties.getProperty("EStafLInk_ELHP");
	}
	
	public String getSup_Qty() {
		return properties.getProperty("Sup_Qty");
	}
	
	public String getSup_BeginT() {
		return properties.getProperty("Sup_BeginT");
	}
	
	public String getSup_EndT() {
		return properties.getProperty("Sup_EndT");
	}
	
	public String getChef_Qty() {
		return properties.getProperty("Chef_Qty");
	}
	
	public String getChef_BeginT() {
		return properties.getProperty("Chef_BeginT");
	}
	
	public String getChef_EndT() {
		return properties.getProperty("Chef_EndT");
	}
	
	public String getCap_Qty() {
		return properties.getProperty("Cap_Qty");
	}
	
	public String getCap_BeginT() {
		return properties.getProperty("Cap_BeginT");
	}
	
	public String getCap_EndT() {
		return properties.getProperty("Cap_EndT");
	}
	
	public String getSer_Qty() {
		return properties.getProperty("Ser_Qty");
	}
	
	public String getSer_BeginT() {
		return properties.getProperty("Ser_BeginT");
	}
	
	public String getSer_EndT() {
		return properties.getProperty("Ser_EndT");
	}
	
	public String getBar_Qty() {
		return properties.getProperty("Bar_Qty");
	}
	
	public String getBar_BeginT() {
		return properties.getProperty("Bar_BeginT");
	}
	
	public String getBar_EndT() {
		return properties.getProperty("Bar_EndT");
	}
	
	public String getStaf_SaveB() {
		return properties.getProperty("Staf_SaveB");
	}
	
	public String getStaf_FinalizeB() {
		return properties.getProperty("Staf_FinalizeB");
	}
	
	public String getUniformType_DdArrow() {
		return properties.getProperty("UniformType_DdArrow");
	}
	
	public String getUniformTypeDd_V() {
		return properties.getProperty("UniformTypeDd_V");
	}
	
	public String getSecurityList_RB() {
		return properties.getProperty("SecurityList_RB");
	}
	
	public String getRentalDelivery_DdArrow() {
		return properties.getProperty("RentalDelivery_DdArrow");
	}
	
	public String getRentalDelivery_DdValue() {
		return properties.getProperty("RentalDelivery_DdValue");
	}
	
	public String getLoadingDock_RB() {
		return properties.getProperty("LoadingDock_RB");
	}
	
	public String getBarOpenDD_RB() {
		return properties.getProperty("BarOpenDD_RB");
	}
	
	public String getSaveB() {
		return properties.getProperty("SaveB");
	}
	
	public String getEBeveragesL_ELHP() {
		return properties.getProperty("EBeveragesL_ELHP");
	}
	
	public String getMappedItem_CB() {
		return properties.getProperty("MappedItem_CB");
	}
	
	public String getCategoryInput() {
		return properties.getProperty("CategoryInput");
	}
	
	public String getGlenfiddich_CB() {
		return properties.getProperty("Glenfiddich_CB");
	}
	
	public String getGlenfiddich_Qty() {
		return properties.getProperty("Glenfiddich_Qty");
	}
	
	public String getBeve_SaveB() {
		return properties.getProperty("Beve_SaveB");
	}
	
	public String getIce_CB() {
		return properties.getProperty("Ice_CB");
	}
	
	public String getIce_Qty() {
		return properties.getProperty("Ice_Qty");
	}
	
	public String getCoke_CB() {
		return properties.getProperty("Coke_CB");
	}
	
	public String getDietCoke_CB() {
		return properties.getProperty("DietCoke_CB");
	}
	
	public String getGingerAle_CB() {
		return properties.getProperty("GingerAle_CB");
	}
	
	public String getSprite_CB() {
		return properties.getProperty("Sprite_CB");
	}
	
	public String getCoke_TB() {
		return properties.getProperty("Coke_TB");
	}
	
	public String getDietCoke_TB() {
		return properties.getProperty("DietCoke_TB");
	}
	
	public String getGingerAle_TB() {
		return properties.getProperty("GingerAle_TB");
	}
	
	public String getSprite_TB() {
		return properties.getProperty("Sprite_TB");
	}
	
	public String getBottleWater_CB() {
		return properties.getProperty("BottleWater_CB");
	}
	
	public String getBottleWater_TB() {
		return properties.getProperty("BottleWater_TB");
	}
	
	public String getIceCost_TB() {
		return properties.getProperty("IceCost_TB");
	}
	
	public String getIcePrice_TB() {
		return properties.getProperty("IcePrice_TB");
	}
	
	public String getBeveFinalise_B() {
		return properties.getProperty("BeveFinalise_B");
	}
	
	public String getNofBars_TB() {
		return properties.getProperty("NofBars_TB");
	}
	
	public String getBarDuration_TB() {
		return properties.getProperty("BarDuration_TB");
	}
	
	public String getBarCloDD_CB() {
		return properties.getProperty("BarCloDD_CB");
	}
	
	public String getHouseWineWD_CB() {
		return properties.getProperty("HouseWineWD_CB");
	}
	
	public String getIceForBS_CB() {
		return properties.getProperty("IceForBS_CB");
	}
	
	public String getDeliveryVehicleDDA() {
		return properties.getProperty("DeliveryVehicleDDA");
	}
	
	public String getDeliveryVehicleDDV() {
		return properties.getProperty("DeliveryVehicleDDV");
	}
	
	public String getIceForWGs_CB() {
		return properties.getProperty("IceForWGs_CB");
	}
	
	public String getEHallLink_ELHP() {
		return properties.getProperty("EHallLink_ELHP");
	}
	
	public String getGril_CB() {
		return properties.getProperty("Gril_CB");
	}
	
	public String getGrilKit_CB() {
		return properties.getProperty("GrilKit_CB");
	}
	
	public String getGril_TB() {
		return properties.getProperty("Gril_TB");
	}
	
	public String getGrilKit_TB() {
		return properties.getProperty("GrilKit_TB");
	}
	
	public String getMenuTypeDD() {
		return properties.getProperty("MenuTypeDD");
	}
	
	public String getMenuItem1() {
		return properties.getProperty("MenuItem1");
	}
	
	public String getCourseItem1() {
		return properties.getProperty("CourseItem1");
	}
	
	public String getMenuItem2() {
		return properties.getProperty("MenuItem2");
	}
	
	public String getCourseItem2() {
		return properties.getProperty("CourseItem2");
	}
	
	public String getMenuItem3() {
		return properties.getProperty("MenuItem3");
	}
	
	public String getCourseItem3() {
		return properties.getProperty("CourseItem3");
	}
	
	public String getCourseItem1_V() {
		return properties.getProperty("CourseItem1_V");
	}
	
	public String getCourseItem2_V() {
		return properties.getProperty("CourseItem2_V");
	}
	
	public String getCourseItem3_V() {
		return properties.getProperty("CourseItem3_V");
	}
	
	public String getSaveB2() {
		return properties.getProperty("SaveB2");
	}
	
	public String getFinalizeMB() {
		return properties.getProperty("FinalizeMB");
	}
	
	public String getKitchenAT_CX() {
		return properties.getProperty("KitchenAT_CX");
	}
	
	public String getEEstimateL_Dhtml() {
		return properties.getProperty("EEstimateL_Dhtml");
	}
	
	public String getEEsti_MenuL() {
		return properties.getProperty("EEsti_MenuL");
	}
	
	public String getEEstiMenuComment_TB() {
		return properties.getProperty("EEstiMenuComment_TB");
	}
	
	public String getGuestCount() {
		return properties.getProperty("GuestCount");
	}
	
	public String getProposedPPcost() {
		return properties.getProperty("ProposedPPcost");
	}
	
	public String getProposedPPcost_C() {
		return properties.getProperty("ProposedPPcost_C");
	}
	
	public String getEstiMenuValiSpan() {
		return properties.getProperty("EstiMenuValiSpan");
	}
	
	public String getEEsti_BeveL() {
		return properties.getProperty("EEsti_BeveL");
	}
	
	public String getEEsti_StafL() {
		return properties.getProperty("EEsti_StafL");
	}
	
	public String getPersonnelDD1() {
		return properties.getProperty("PersonnelDD1");
	}
	
	public String getPersonnelQty1() {
		return properties.getProperty("PersonnelQty1");
	}
	
	public String getInTime1() {
		return properties.getProperty("InTime1");
	}
	
	public String getOutTime1() {
		return properties.getProperty("OutTime1");
	}
	
	public String getPersonnelDD2() {
		return properties.getProperty("PersonnelDD2");
	}
	
	public String getPersonnelQty2() {
		return properties.getProperty("PersonnelQty2");
	}
	
	public String getInTime2() {
		return properties.getProperty("InTime2");
	}
	
	public String getOutTime2() {
		return properties.getProperty("OutTime2");
	}
	
	public String getPersonnelDD3() {
		return properties.getProperty("PersonnelDD3");
	}
	
	public String getPersonnelQty3() {
		return properties.getProperty("PersonnelQty3");
	}
	
	public String getInTime3() {
		return properties.getProperty("InTime3");
	}
	
	public String getOutTime3() {
		return properties.getProperty("OutTime3");
	}
	
	public String getPersonnelDD4() {
		return properties.getProperty("PersonnelDD4");
	}
	
	public String getPersonnelQty4() {
		return properties.getProperty("PersonnelQty4");
	}
	
	public String getInTime4() {
		return properties.getProperty("InTime4");
	}
	
	public String getOutTime4() {
		return properties.getProperty("OutTime4");
	}
	
	public String getPersonnelDD5() {
		return properties.getProperty("PersonnelDD5");
	}
	
	public String getPersonnelQty5() {
		return properties.getProperty("PersonnelQty5");
	}
	
	public String getInTime5() {
		return properties.getProperty("InTime5");
	}
	
	public String getOutTime5() {
		return properties.getProperty("OutTime5");
	}
	
	public String getStaffvali_text() {
		return properties.getProperty("Staffvali_text");
	}
	
	public String getEEsti_RentalsL() {
		return properties.getProperty("EEsti_RentalsL");
	}
	
	public String getPerPersonCost_R() {
		return properties.getProperty("PerPersonCost_R");
	}
	
	public String getRentVali_Text() {
		return properties.getProperty("RentVali_Text");
	}
	
	public String getELinLink_ELHP() {
		return properties.getProperty("ELinLink_ELHP");
	}
	
	public String getVendorSLinen_CB() {
		return properties.getProperty("VendorSLinen_CB");
	}
	
	public String getRoundTable_CB() {
		return properties.getProperty("RoundTable_CB");
	}
	
	public String getTableQty() {
		return properties.getProperty("TableQty");
	}
	
	public String getLinenFinalizeB() {
		return properties.getProperty("LinenFinalizeB");
	}
	
	public String getEEqipLink_ELHP() {
		return properties.getProperty("EEqipLink_ELHP");
	}
	
	public String getKitchenEqui_CB() {
		return properties.getProperty("KitchenEqui_CB");
	}
	
	public String getCoffWaterCup_CB() {
		return properties.getProperty("CoffWaterCup_CB");
	}
	
	public String getInductionBurner_CB() {
		return properties.getProperty("InductionBurner_CB");
	}
	
	public String getInductionPan_CB() {
		return properties.getProperty("InductionPan_CB");
	}
	
	public String getIBQty() {
		return properties.getProperty("IBQty");
	}
	
	public String getIBPQty() {
		return properties.getProperty("IBPQty");
	}
	
	public String getLinenDeliveryDDA() {
		return properties.getProperty("LinenDeliveryDDA");
	}
	
	public String getLinenDeliveryDDV() {
		return properties.getProperty("LinenDeliveryDDV");
	}
	
	public String getRemoveTrash_RB() {
		return properties.getProperty("RemoveTrash_RB");
	}
	
	public String getPlasticFloor_RB() {
		return properties.getProperty("PlasticFloor_RB");
	}
	
	public String getNOCMR_TB() {
		return properties.getProperty("NOCMR_TB");
	}
	
	public String getDepartTime_TB() {
		return properties.getProperty("DepartTime_TB");
	}
	
	public String getEConciergeL_ELHP() {
		return properties.getProperty("EConciergeL_ELHP");
	}
	
	public String getGourmetBarista_TB() {
		return properties.getProperty("GourmetBarista_TB");
	}
	
	public String getConciergeClose_B() {
		return properties.getProperty("ConciergeClose_B");
	}
	
	public String getEDisposablesL_ELHP() {
		return properties.getProperty("EDisposablesL_ELHP");
	}
	
	public String getHazelnut_P() {
		return properties.getProperty("Hazelnut_P");
	}
	
	public String getCFilters_P() {
		return properties.getProperty("CFilters_P");
	}
	
	public String getEEsti_LinenL() {
		return properties.getProperty("EEsti_LinenL");
	}
	
	public String getLinenPPC() {
		return properties.getProperty("LinenPPC");
	}
	
	public String getEEsti_DisposablesL() {
		return properties.getProperty("EEsti_DisposablesL");
	}
	
	public String getSubT_Conci() {
		return properties.getProperty("SubT_Conci");
	}
	
	public String getEEsti_ConciergeL() {
		return properties.getProperty("EEsti_ConciergeL");
	}
	
	public String getEsti_EventGroupL() {
		return properties.getProperty("Esti_EventGroupL");
	}
	
	public String getTAC_EventG() {
		return properties.getProperty("TAC_EventG");
	}
	
	
	/************ Kitchen Accept  ********************/
	
	
	
	public String getEventFilter() {
		return properties.getProperty("EventFilter");
	}
	
	public String getEnterEventNum() {
		return properties.getProperty("EnterEventNum");
	}
	
	public String getClickApply() {
		return properties.getProperty("ClickApply");
	}	
	public String getClickKitchen() {
		return properties.getProperty("ClickKitchen");
	}
	
	public String getConstraintClose() {
		return properties.getProperty("ConstraintClose");
	}
	public String getClickSent() {
		return properties.getProperty("ClickSent");
	}
	public String getCLickAccept() {
		return properties.getProperty("CLickAccept");
	}
	public String getClickAdd11() {
		return properties.getProperty("ClickAdd11");
	}
	public String getEnterQty1() {
		return properties.getProperty("EnterQty1");
	}
	
	
	
	
	
	
	
	
	
	
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

