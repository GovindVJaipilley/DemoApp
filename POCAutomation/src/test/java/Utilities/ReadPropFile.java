package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import LoginPage.BaseClass;

public class ReadPropFile {
	

	//private static String file_path = "C:\\POC-Automation\\Config.properties";
	//public static String file_path1 = "/src/test/resources/TestData/Config.properties";
	String configFilePath = "C:/POC_Automation/Config.properties";
	private Properties properties;
	ExcelRead excel;
	String testDataFilePath = BaseClass.getTestDataPath();
	//String testDataFilepath = "C:\\POC-Automation\\TestData.xlsx";
	//String testDataFilePath = "src/test/resources/TestData/TestData.xlsx";
	//InputStream inputStream;
	

	public ReadPropFile() throws IOException {
		properties = new Properties();
		FileInputStream fis = new FileInputStream(configFilePath);
		properties.load(fis);
		
		
		excel = new ExcelRead(testDataFilePath);
	}
	
	
	/************LoginPage properties********************/
	public String getLoginIdXpath() {
        return properties.getProperty("LoginIdXpath");
    }

    public String getPasswordXpath() {
        return properties.getProperty("PasswordXpath");
    }
    
    public String getLoginBtnXpath() {
        return properties.getProperty("LoginButtonXpath");
    }
    
    /**************Failed pop-up properties***************/
    public String getFailedPopUpXpath() {
    	return properties.getProperty("FailedPopUp");
    }
    
    public String getFailedPopUpOkBtn() {
    	return properties.getProperty("FailedPopUpOkBtn");
    }
    
    public String getAMSSpinner() {
    	return properties.getProperty("AMSSpinner");
    }
    
    /***************Main Menu properties*****************/
    public String getMenuOption() {
    	return properties.getProperty("MenuXpath");
    }
    
    public String getHomeMenu() {
    	return properties.getProperty("HomeMenuXpath");
    }
    
    public String getDcsMenu() {
    	return properties.getProperty("DCSMenuXpath");
    }
    
    public String getDcsListing() {
    	return properties.getProperty("DCSLisingXpath");
    }
    
    public String getSchedMenu() {
    	return properties.getProperty("SchedMenu");
    }
    
    
    /***************Home Filter properties***********************/
    public String getFilterIcon() {
    	return properties.getProperty("FilterIcon");
    }
    
    public String getPSStatus() {
    	return properties.getProperty("PSStatusClick");
    }
    
    public String getPSStatusActive() {
    	return properties.getProperty("PSStatusActive");
    }
    
    public String getPSStatusInActive() {
    	return properties.getProperty("PSStatusInactive");
    }
    
    public String getPSStatusAll() {
    	return properties.getProperty("PSStatusAll");
    }
    
    public String getPSNameFilter() {
    	return properties.getProperty("PSName");
    }
    
    public String getSearchFilterButton() {
    	return properties.getProperty("searchButton");
    }
    
    public String getCommunicationDashboardText() {
    	return properties.getProperty("CommunicationDashboardText");
    }
    
    /***************Flyout Menu properties***********************/
    public String getFlyoutMenu() {
    	return properties.getProperty("flyoutMenuXpath");
    }
    
    public String getFlyoutCreatePS() {
    	return properties.getProperty("flyoutCreatePSXpath");
    }
    
    public String getflyoutCreateDCSXpath() {
    	return properties.getProperty("flyoutCreateDCSXpath");
    }
    
    /**************Create PS Basic Information screen Properties******************/
    public String getBasicInformationText() {
    	return properties.getProperty("BasicInformationTextXpath");
    }
    
    public String getLastName() {
    	return properties.getProperty("LastNameXpath");
    }
    
    public String getFirstName() {
    	return properties.getProperty("FirstNameXpath");
    }
    
    public String getRaceDropDownClick() {
    	return properties.getProperty("RaceDropDownClick");
    }
    
    public String getRaceListInput() {
    	return properties.getProperty("RaceSearchInputfield");
    }
    
    public String getRaceSelection() {
    	return properties.getProperty("RaceSelection");
    }
    
    public String getDOB() {
    	return properties.getProperty("DOBInput");
    }
    
    public String getGenderField() {
    	return properties.getProperty("GenderField");
    }
    
    public String getGenderSearch() {
    	return properties.getProperty("GenderSearch");
    }
    
    public String getMaleGender() {
    	return properties.getProperty("MaleGender");
    }
    
    public String getFemaleGender() {
    	return properties.getProperty("FemaleGender");
    }
    
    public String getUnknownGender() {
    	return properties.getProperty("UnknownGender");
    }
    
    public String getSalutationField() {
    	return properties.getProperty("SalutationField");
    }
    
    public String getSalutationSearch() {
    	return properties.getProperty("GenderSearch");
    }
    
    public String getSalutationMiss() {
    	return properties.getProperty("SalutationMiss");
    }
    
    public String getSalutationDR() {
    	return properties.getProperty("SalutationDR");
    }
    
    public String getSalutationMR() {
    	return properties.getProperty("SalutationMR");
    }
    
    public String getSalutationMRS() {
    	return properties.getProperty("SalutationMRS");
    }
    
    public String getSalutationMS() {
    	return properties.getProperty("SalutationMS");
    }
    
    public String getMaritalStatusField() {
    	return properties.getProperty("MaritalStatusField");
    }
    
    public String getMaritalStatusSearch() {
    	return properties.getProperty("MaritalStatusSearch");
    }
    
    public String getMaritalStatusSelection() {
    	return properties.getProperty("MaritalStatusSelection");
    }
    
    public String getSSNField() {
    	return properties.getProperty("SSNField");
    }
    
    public String getPrimLangField() {
    	return properties.getProperty("PrimaryLanguageField");
    }
    
    public String getPrimLangSearch() {
    	return properties.getProperty("PrimaryLanguageSearch");
    }
    
    public String getPrimLangSelection() {
    	return properties.getProperty("PrimaryLanguageSelection");
    }
    
    public String getMappedSitesField() {
    	return properties.getProperty("MappedSitesField");
    }
    
    public String getMappedSitesSearch() {
    	return properties.getProperty("MappedSitesSearch");
    }
    
    public String getMappedSitesSelection() {
    	return properties.getProperty("MappedSitesSelection");
    }
    
    /********************Create PS - Address locators*****************************/
    public String getLocationField() {
    	return properties.getProperty("LocationField");
    }
    
    public String getLocationSearch() {
    	return properties.getProperty("LocationSearch");
    }
    
    public String getLocationSelection() {
    	return properties.getProperty("LocationSelection");
    }
    
    public String getAddressLine1Field() {
    	return properties.getProperty("AddressLine1Field");
    }
    
    public String getAddressLine2Field() {
    	return properties.getProperty("AddressLine2Field");
    }
    
    public String getZipCodeField() {
    	return properties.getProperty("ZipCodeField");
    }
    
    public String getPhoneTypeField() {
    	return properties.getProperty("PhoneTypeField");
    }
    
    public String getPhoneTypeSearch() {
    	return properties.getProperty("PhoneTypeSearch");
    }
    
    public String getPhoneTypeSelection() {
    	return properties.getProperty("PhoneTypeSelection");
    }
    
    public String getPhoneNumber() {
    	return properties.getProperty("PhoneNumberField");
    }
    
    public String getPsBDSaveButton() {
    	return properties.getProperty("PsBDSaveButton");
    }
    
    public String getSuccessMsg() {
    	return properties.getProperty("successMsg");
    }
    
    public String getSuccessMsgOkBtn() {
    	return properties.getProperty("successMsgOkbtn");
    }
    
    /*************Create PS - Guarantor details**************/
    
    public String getGuarantorHeader() {
    	return properties.getProperty("GuarantorDetailsHeader");
    }
    
    public String getSelfGuarantorCheckBox() {
    	return properties.getProperty("SelfGuarantorCheckBox");
    }
    
    public String getSelfGuarantorAddress() {
    	return properties.getProperty("SelfGuarantorAddressCheckBox");
    }

    public String getSaveAndNextButton() {
    	return properties.getProperty("SaveAndNextBtn");
    }
    
    public String getGuarantorSuccessMsg() {
    	return properties.getProperty("GuarantorSaveSuccessMsg");
    }
    
    /***************************Create Admission Properties*******************************/
    public String getMenuAtPS() {
    	return properties.getProperty("MenuAtPS");
    }
    
    public String getCreateAdmissionOption() {
    	return properties.getProperty("CreateAdmissionOption");
    }
    
    public String getAdmissionDetailsHeader() {
    	return properties.getProperty("AdmissionPageHeader");
    }
    
    public String getPSField() {
    	return properties.getProperty("PSField");
    }
    
    public String getPSSearch() {
    	return properties.getProperty("PSSearch");
    }
    
    public String getPSSelection() {
    	return properties.getProperty("PSSelect");
    }
    
    public String getSiteOption() {
    	return properties.getProperty("SiteOption");
    }
    
    public String getSiteSearch() {
    	return properties.getProperty("SiteSearch");
    }
    
    public String getSiteSelection() {
    	return properties.getProperty("SiteSelect");
    }
    
    public String getGuarantor() {
    	return properties.getProperty("GuarantorOption");
    }
    
    public String getGuarantorSearch() {
    	return properties.getProperty("GuarantorSearch");
    }
    
    public String getGuarantorSelection() {
    	return properties.getProperty("GuarantorSelect");
    }
    
    public String getCoordinator() {
    	return properties.getProperty("CoordinatorOption");
    }
    
    public String getCoordinatorSearch() {
    	return properties.getProperty("CoordinatorSearch");
    }
    
    public String getCoordinatorSelection() {
    	return properties.getProperty("CoordinatorSelect");
    }
    
    public String getAdmissionDate() {
    	return properties.getProperty("AdmissionDate");
    }
    
    public String getFirstVisitDate() {
    	return properties.getProperty("FirstVisitDate");
    }
    
    public String getReferredDate() {
    	return properties.getProperty("ReferredDate");
    }
    
    public String getReferralSource() {
    	return properties.getProperty("ReferralSourceOption");
    }
    
    public String getReferralSourceSearch() {
    	return properties.getProperty("ReferralSourceSearch");
    }
    
    public String getReferralSourceSelection() {
    	return properties.getProperty("ReferralSourceSelect");
    }
    
    public String getAddDiaganosisButton() {
    	return properties.getProperty("AddDiagnosisButton");
    }
    
    public String getDiagnosisdetails() {
    	return properties.getProperty("DiagnosisDetails");
    }
    
    public List<String> getDiagnosesList() {
    	System.out.println(excel.getCellData("Admission_Details", 8, 2));
    	String diagnosesData = excel.getCellData("Admission_Details", 10, 2);
    	List<String> diagnosesXPaths = new ArrayList<String>();
    	List<String> diagnosisCodes = Arrays.asList(diagnosesData.split(","));
    	for(String code : diagnosisCodes) {
    		String xpath = "//td[text()='"+code+"']/ancestor::tr//p-checkbox";
    		System.out.println("Diagnosis Code xpaths are: " + xpath);
    		diagnosesXPaths.add(xpath);
    	}
		return diagnosesXPaths;
    }
    
    public String getAddButtonAtDiag() {
    	return properties.getProperty("AddButtonAtDiag");
    }
    
    public String getDiagTableContent() {
    	return properties.getProperty("DiagTableContent");
    }
    
    public String getAdmCreatedSuccMsg() {
    	return properties.getProperty("AdmissionCreateSuccMsg");
    }
    
    /*********************Payor Plan screen properties**********************/
    
    public String getPayorPlanPrivateDuty() {
    	return properties.getProperty("PayorPlanPrivateDuty");
    }
    public String getPayorPlanDetailsHeader() {
    	return properties.getProperty("PayorPlanScreenHeader");
    }
    
    public String getPayorPlanOption() {
    	return properties.getProperty("PayorPlanOption");
    }
    
    public String getPayorPlanSearch() {
    	return properties.getProperty("PayorPlanSearch");
    }
    
    public String getPayorPlanSelection() {
    	return properties.getProperty("PayorPlanSelect");
    }
    
    public String getPPRankOption() {
    	return properties.getProperty("PPRankOption");
    }
    
    public String getPPRankSearch() {
    	return properties.getProperty("PPRankSearch");
    }
    
    public String getPPRankSelection() {
    	return properties.getProperty("PPRankSelect");
    }
    
    public String getPPEffectiveFrom() {
    	return properties.getProperty("PPEffectiveFrom");
    }
    
    public String getPPEffectiveTo() {
    	return properties.getProperty("PPEffectiveTo");
    }
    
    public String getSelfSubscriberCheckBox() {
    	return properties.getProperty("SelfSubscriberCheckBox");
    }
    
    public String getPPPolicyNumber() {
    	return properties.getProperty("PolicyNumber");
    }
    
    public String getCreateBtnAtPP() {
    	return properties.getProperty("CreateButton");
    } 
    
    public String getPPSuccMsg() {
    	return properties.getProperty("PPCreateSuccMsg");
    }
    
    /**********************Authorization Details Screen ************************/
   
    public String getAuthDetailsPrivateDuty() {
    	return properties.getProperty("AuthDetailsPrivateDuty");
    }
    public String getAuthDetailsHeader() {
    	return properties.getProperty("AuthDetailsHeader");
    }
    
    public String getServiceOption() {
    	return properties.getProperty("ServiceOption");
    }
    
    public String getServiceSearch() {
    	return properties.getProperty("ServiceSearch");
    }
    
    public String getServiceSelection() {
    	return properties.getProperty("ServiceSelect");
    }
    
    public String getServiceBeginDate() {
    	return properties.getProperty("ServiceBeginDate");
    }
    
    public String getServiceEndDate() {
    	return properties.getProperty("ServiceEndDate");
    }
    
    public String getTotalUnitsInput() {
    	return properties.getProperty("TotalUnitsInput");
    }
    
    public String getUnlimitedTotalUnits() {
    	return properties.getProperty("TotalUnitsUnlimted");
    }
    
    public String getDPEffectiveFrom() {
    	return properties.getProperty("DPEffectiveFrom");
    }
    
    public String getDPEffectiveTo() {
    	return properties.getProperty("DPEffectiveTo");
    }
    
    public String getWeeklyDPToggle() {
    	return properties.getProperty("WeeklyToggle");
    }
    
    public String getWeeklyDPHeader() {
    	return properties.getProperty("WeeklyDPHeader");
    }
    
    public String getWeeklyDPMaxUnits() {
    	return properties.getProperty("WeeklyDPMaxUnits");
    }
    
    public String getAuthSaveBtn() {
    	return properties.getProperty("SaveButton");
    }
    
    public String getDailyDPToggle() {
    	return properties.getProperty("DailyToggle");
    }
    
    public String getMonthlyDPToggle() {
    	return properties.getProperty("MonthlyToggle");
    }
    
    public String getAuthCreatedSuccMsg() {
    	return properties.getProperty("AuthCreatedSuccMsg");
    }
    public String getRateTypeDdArrow() {
    	return properties.getProperty("RateTypeDdArrow");
    }
    public String getRateTypeDdUl() {
    	return properties.getProperty("RateTypeDdUl");  
    }
    public String getRateTypeDdUlInSM() {
    	return properties.getProperty("RateTypeDdUlInSM");  
    }
    public String getAuthDetailsShiftTextB() {
    	return properties.getProperty("AuthDetailsShiftTextB");
    }
   
   
    /******************************Tree View Properties**************************************/
    public String getextendPSTree() {
    	return properties.getProperty("extendPSTree");
    }
    
    public String getCollapsePSTree() {
    	return properties.getProperty("collapsePSTree");
    }
    
    public String getextendAdmissionTree() {
    	return properties.getProperty("extendAdmissionTree");
    }
    
    public String getextendFirstAdmissionTree() {
    	return properties.getProperty("extendFirstAdmissionTree");
    }
    
    public String getMenuAtPayorPlanTree() {
    	return properties.getProperty("MenuAtPayorPlanTree");
    }
    
    public String getActiveServiceOption() {
    	return properties.getProperty("ActiveServiceOption");
    }
    
    public String getInactiveServicesOption() {
    	return properties.getProperty("InactiveServicesOption");
    }
    
    public String getAllServicesOption() {
    	return properties.getProperty("AllServicesOption");
    }
    
    public String getMenuAtServiceTree() {
    	return properties.getProperty("MenuAtServiceTree");
    }
    
    public String getCreateRecurringVisitsOption() {
    	return properties.getProperty("CreateRecurringVisitsOption");
    }
    
    public String getCreateRecurringVisitHeader() {
    	return properties.getProperty("CreateRecurringVisitsOption");
    }
    
    /*********************Create Recurring Visits Locators****************************/
    public String getRecuStartDate() {
    	return properties.getProperty("RecuStartDate");
    }
    
    public String getRecuEndDate() {
    	return properties.getProperty("RecuEndDate");
    }
    
    /************Weekly Timings***************/
    public String getWeeklyRadio() {
    	return properties.getProperty("WeeklyRadio");
    }
    
    public String getWeeklyRadioSelected() {
    	return properties.getProperty("WeeklyRadioSelected");
    }
    
    public String getSundayST() {
    	return properties.getProperty("SundayST");
    }
    
    public String getSundayET() {
    	return properties.getProperty("SundayET");
    }
    
    public String getMondayST() {
    	return properties.getProperty("MondayST");
    }
    
    public String getMondayET() {
    	return properties.getProperty("MondayET");
    }
    
    public String getTuesdayST() {
    	return properties.getProperty("TuesdayST");
    }
    
    public String getTuesdayET() {
    	return properties.getProperty("TuesdayET");
    }
    
    public String getWednesdayST() {
    	return properties.getProperty("WednesdayST");
    }
    
    public String getWednesdayET() {
    	return properties.getProperty("WednesdayET");
    }
    
    public String getThursdayST() {
    	return properties.getProperty("ThursdayST");
    }
    
    public String getThursdayET() {
    	return properties.getProperty("ThursdayET");
    }
    
    public String getFridayST() {
    	return properties.getProperty("FridayST");
    }
    
    public String getFridayET() {
    	return properties.getProperty("FridayET");
    }
    
    public String getSaturdayST() {
    	return properties.getProperty("SaturdayST");
    }
    
    public String getSaturdayET() {
    	return properties.getProperty("SaturdayET");
    }
    
    /*****************Quick Entry******************/
    public String getQuickEntryRadio() {
    	return properties.getProperty("QuickEntryRadio");
    }
    
    public String getQuickEntryRadioSelected() {
    	return properties.getProperty("QuickEntryRadioSelected");
    }
    
    /*****************Monthly******************/
    public String getMonthlyRadio() {
    	return properties.getProperty("MonthlyRadio");
    }
    
    public String getMonthlyRadioSelected() {
    	return properties.getProperty("MonthlyRadioSelected");
    }
    
    public String getEveryText() {
    	return properties.getProperty("EveryText");
    }
    
    /******************Drag and Drop*******************/
    public String getSearchDCS() {
    	return properties.getProperty("DCSSearch");
    }
    public String getFirstDCS() {
    	return properties.getProperty("FirstDCS");
    }
    
    public String getTargetToDropDCS() {
    	return properties.getProperty("TargetToDropDCS");
    }
    
    public String getDCSRightMove() {
    	return properties.getProperty("DCSRightMove");
    }
    
    public String getDCSAutoExtendSelect() {
    	return properties.getProperty("DCSAutoExtendSelect");
    }
    
    public String getAllowOverBookText() {
    	return properties.getProperty("AllowOverBook");
    }
    
    public String getCreateButton() {
    	return properties.getProperty("RecuCreateButton");
    }
    
    public String getLoadingSpinner() {
    	return properties.getProperty("LoadingSpinner");
    }
    
    public String getVisitSummPage() {
    	return properties.getProperty("VisitSummPage");
    }
    
    public String getCloseAtVisitSumm() {
    	return properties.getProperty("CloseAtVisitSumm");
    }
    
    public String getOverServedPopUp() {
    	return properties.getProperty("OverServedPopUp");
    }
	public String getOverServedOKButton() {
		return properties.getProperty("OverServedOKButton");
	}
    
    /********************Scheduling Calendar Properties************************/
    public String getSchedCalendarHeader() {
    	return properties.getProperty("SchedCalendarHeader");
    }
    
    public String getSchedCalendarMenu() {
    	return properties.getProperty("SchedCalendarMenu");
    }
    
    public String getPSDropDownInSC() {
    	return properties.getProperty("PSDropDownInSC");
    }
    
    public String getPSDropDownInSCSearch() {
    	return properties.getProperty("PSDropDownInSCSearch");
    }
    
    public String getPSDropDownInSCSelect() {
    	String psName = excel.getCellData("Add_visit_SC", 0, 2);
    	String psNameXpath = "//li[contains(@aria-label,'"+psName+"')]";
    	return psNameXpath;
    }
    
    public String getsiteDropDownInSC() {
    	return properties.getProperty("siteDropDownInSC");
    }
    
    public String getsiteDropDownInSCSearch() {
    	return properties.getProperty("siteDropDownInSCSearch");
    }
    
    public String getSitesListInSC() {
    	String siteValue = excel.getCellData("Add_Visit_SC", 1, 2);
    	String siteXpath = "//li[contains(@aria-label,'"+siteValue+"')]";
		return siteXpath;
    }
    
    public String getGoButtonInSC() {
    	return properties.getProperty("goButtonInSCSearch");
    }
    
    public String getFlyOutInSC() {
    	return properties.getProperty("flyoutMenuInSC");
    }
    
    public String getflyOutAddVisitsInSC() {
    	return properties.getProperty("flyOutAddVisitsInSC");
    }
    
    public String getSiteInAddVisits() {
    	return properties.getProperty("siteInAddVisits");
    }
    
    public String getPSInAddVisits() {
    	return properties.getProperty("psNameInAddVisits");
    }
    
    public String getpsNameInAddVisitsUl() {
    	return properties.getProperty("psNameInAddVisitsUl");
    }
    
    public String getPSNameSearchInAddVisitsPopUp() {
    	return properties.getProperty("psSearchInAddVisits");
    }
    
    public String getPSNameClickInAddVisits() {
    	String psName = excel.getCellData("Add_visit_SC", 0, 2);
    	String visitDateXpath = "//li[contains(@aria-label,'"+psName+"')]";
    	return visitDateXpath;
    }
    
    
    
    public String getVisitDateInSC() {
    	String visitDate = excel.getCellData("Add_visit_SC", 7, 2);
    	String visitDateXpath = "//td[@data-date='"+visitDate+"']";
    	return visitDateXpath;
    }
    
    public String getAddVisitPopUpHeader() {
    	return properties.getProperty("addVisitPopUpHeader");
    }
    
    public String getVisitDateInPopUpHeader() {
    	return properties.getProperty("visitDateInPopUpHeader");
    }
    
    public String getVisitStartTimeInAddVisits() {
    	return properties.getProperty("visitStartTimeInAddVisits");
    }
    
    public String getVisitEndTimeInAddVisits() {
    	return properties.getProperty("visitEndTimeInAddVisits");
    }
    
    public String getServiceInAddVisitsPopUp() {
    	return properties.getProperty("serviceInAddVisitsPopUp");
    }
    
    public String getServiceSearchInAddVisitsPopUp() {
    	return properties.getProperty("serviceSearchInAddVisitsPopUp");
    }
    
    public String getServiceListInAddVisitsPopUp() {
    	String serviceCode = excel.getCellData("Add_Visit_SC", 6, 2);
    	String serviceCodeXpath = "//li[contains(@aria-label,'"+serviceCode+"')]";
		return serviceCodeXpath;
    }
    
    public String getcreateButtonInAddVisits() {
    	return properties.getProperty("createButtonInAddVisits");
    }
    public String getCancelVisitIcon() {
    	return properties.getProperty("CancelVisitIcon");
    }
    public String getCancelCodeDdArrowInSC() {
    	return properties.getProperty("CancelCodeDdArrowInSC");
    }
    public String getCancelCodeDdUlInSc() {
    	return properties.getProperty("CancelCodeDdUlInSc");
    }
    public String getCancelCodeCommentInSc() {
    	return properties.getProperty("CancelCodeCommentInSc");
    }
    public String getCancelCodeProceedBInSc() {
    	return properties.getProperty("CancelCodeProceedBInSc");
    }
    
    /*****************Assign DCS PopUp Properties*****************/
    public String getAssignDCSHeader() {
    	return properties.getProperty("assignDCSHeader");
    }
    
    public String getDCSListBox() {
    	return properties.getProperty("dcsListBox");
    }
    
    public String getDCSListSearch() {
    	return properties.getProperty("dcsListSearch");
    }
    
    public String getDCSListSelect() {
    	String dcsName = excel.getCellData("AssignDCS", 0, 2);
    	String dcsListXpath = "//li[contains(@aria-label,'"+dcsName+"')]";
		return dcsListXpath;
    }
    
    public String getCheckAvailabilityButton() {
    	return properties.getProperty("checkAvailabilityButton");
    }
    
    public String getSelectDCSRadioButton() {
    	String dcsName = excel.getCellData("AssignDCS", 0, 2);
    	String dcsRadioBtnXpath = "//a[contains(text(),'"+dcsName+"')]/parent::td/preceding-sibling::td//p-radiobutton";
		return dcsRadioBtnXpath;
    }
	
    public String scheduleButton() {
    	return properties.getProperty("scheduleButton");
    }
    
    /*********************OT Pop-Up handling***********************/
    public String getDCSOTPopupHeader() {
    	return properties.getProperty("dcsOTPopupHeader");
    }
    
    public String getDCSOTPopupProceed() {
    	return properties.getProperty("dcsOTPopupProceed");
    }
    
    /********************Schedule Criteria Properties******************/
    public String getScheduleCriteriaButton() {
    	return properties.getProperty("scheduleCriteriaButton");
    }
    
    public String getScheduleCriteriaHeader() {
    	return properties.getProperty("scheduleCriteriaHeader");
    }
    
    public String getScheduleCriteriaQualification() {
    	return properties.getProperty("scheduleCriteriaQualification");
    }
    
    public String getScheduleCreteriaQualChecked() {
    	return properties.getProperty("scheduleCriteriaQualChecked");
    }
    
    public String getScheduleCriteriaPreferences() {
    	return properties.getProperty("scheduleCriteriaPreferences");
    }
    
    public String getScheduleCreteriaPrefChecked() {
    	return properties.getProperty("scheduleCriteriaPrefChecked");
    }
    
    public String getScheduleCriteriaScheduledDCS() {
    	return properties.getProperty("scheduleCriteriaScheduledDCS");
    }
    
    public String getScheduleCreteriaSchedDCSChecked() {
    	return properties.getProperty("scheduleCriteriaSchedDCSChecked");
    }
    
    public String getScheduleCriteriaPreviouslyServedPS() {
    	return properties.getProperty("scheduleCriteriaPreviouslyServedPS");
    }
    
    public String getScheduleCreteriaPrevServChecked() {
    	return properties.getProperty("scheduleCriteriaPrevServChecked");
    }
    
    public String getScheduleCriteriaSharedDCS() {
    	return properties.getProperty("scheduleCriteriaSharedDCS");
    }
    
    public String getScheduleCreteriaSharedChecked() {
    	return properties.getProperty("scheduleCriteriaSharedChecked");
    }
    
    public String getScheduleCriteriaGetPreferredDCS() {
    	return properties.getProperty("scheduleCriteriaGetPreferredDCS");
    }
    
    public String getScheduleCreteriaPrefDCSChecked() {
    	return properties.getProperty("scheduleCriteriaPrefDCSChecked");
    }
    
    public String getScheduleCriteriaGetUnAvailableDCS() {
    	return properties.getProperty("scheduleCriteriaGetUnAvailableDCS");
    }
    
    public String getScheduleCreteriaUnAvailDCSChecked() {
    	return properties.getProperty("scheduleCriteriaUnAvailDCSChecked");
    }
    
    public String getScheduleCriteriaDoNotUseUnPreferredDCS() {
    	return properties.getProperty("scheduleCriteriaDoNotUseUnPreferredDCS");
    }
    
    public String getScheduleCreteriaUnPrefDCSChecked() {
    	return properties.getProperty("scheduleCriteriaUnPrefDCSChecked");
    }
    
    public String getScheduleCriteriaGetFamilyServingFamilyDCS() {
    	return properties.getProperty("scheduleCriteriaGetFamilyServingFamilyDCS");
    }
    
    public String getScheduleCreteriaFamilyServChecked() {
    	return properties.getProperty("scheduleCriteriaFamilyServChecked");
    }
    
    public String getScheduleCriteriaSave() {
    	return properties.getProperty("scheduleCriteriaSave");
    }
    
    public String getSuccessMsgHeader() {
    	return properties.getProperty("successMsgHeader");
    }
    
    public String getSuccessOkBtn() {
    	return properties.getProperty("successOkBtn");
    }
    
    /*************Manage Visits Locators***************/
    public String getManageVisitsMenu() {
    	return properties.getProperty("manageVisitsMenu");
    }
    
    public String getManageVisitsHeader() {
    	return properties.getProperty("manageVisitsHeader");
    }
    
    public String getSiteFilterInManageVisits() {
    	return properties.getProperty("siteFilterInManageVisits");
    }
    
    public String getSiteSearchInManageVisits() {
    	return properties.getProperty("siteSearchInManageVisits");
    }
    
    public String getSiteSelectInManageVisits() {
    	String siteNumber = excel.getCellData("Add_Visit_SC", 1, 2);
    	String siteNumberXpath = "//li[contains(@aria-label,'"+siteNumber+"')]";
    	return siteNumberXpath;
    }
    
    public String getSearchButton() {
    	return properties.getProperty("searchButton");
    }
    
    public String getLVStartDate() {
    	return properties.getProperty("LVStartDate");
    }
    
    public String getLVEndDate() {
    	return properties.getProperty("LVEndDate");
    }
    
    //Schedule Management Locators
    public String getSchedMgtRadioButton() {
    	return properties.getProperty("schedMgtRadioButton");
    }
    
    public String getAddVisitInSchedMgmt() {
    	return properties.getProperty("addVisitsBtn");
    }
    
    public String getVisitCheckBoxOnScheduleManagement() {
    	return properties.getProperty("VisitCheckBoxOnScheduleManagement");
    }
    
    public String getGetDCSBOnScheduleManagement() {
    	return properties.getProperty("GetDCSBOnScheduleManagement");
    }
    public String getCloseBAfterAssignDCS() {
    	return properties.getProperty("CloseBAfterAssignDCS");
    }
    public String getCancelVisitsButton() {
    	return properties.getProperty("CancelVisitsButton");
    }
    public String getCancelCodeDdArrow() {
    	return properties.getProperty("CancelCodeDdArrow");
    }
    public String getCancelCodeDdUlInSM() {
    	return properties.getProperty("CancelCodeDdUlInSM");
    }
    public String getCancelCodeComments() {
    	return properties.getProperty("CancelCodeComments");
    }
    public String getProceedButton() {
    	return properties.getProperty("ProceedButton");
    }
    public String getRemoveDcsButton() {
    	return properties.getProperty("RemoveDcsButton");
    }
    public String getVisitTypeDdArrow() {
    	return properties.getProperty("VisitTypeDdArrow");
    }
    public String getPsDdArrowInMV() {
    	return properties.getProperty("PsDdArrow");
    }
    public String getPsDdUlInMV() {
    	return properties.getProperty("PsDdUl");
    }
    public String getDcsDdArrowInMV() {
    	return properties.getProperty("DcsDdArrow");
    }
    public String getDcsDdUlInMV() {
    	return properties.getProperty("DcsDdUl");
    }
    public String getVisitTypeDdUl() {
    	return properties.getProperty("VisitTypeDdUl");
    }
    public String getVisitStatusDdArrow() {
    	return properties.getProperty("VisitStatusDdArrow");
    }
    public String getVisitStatusDdUl() {
    	return properties.getProperty("VisitStatusDdUl");
    }
    public String getRateTypeInMVDdArrow() {
    	return properties.getProperty("RateTypeDdArrow");
    }
    public String getRateTypeInMVDdUl() {
    	return properties.getProperty("RateTypeDdUl");
    }
    public String getActOverriddenInput() {
    	return properties.getProperty("Act/OverriddenInput");
    }
    public String getSaveButton() {
    	return properties.getProperty("SaveButton");
    }
    
    
    /*************DCS FILTER Locators***************/
   
    public String getDcsName() {
    	return properties.getProperty("DCSName");
    }
    public String getDCSStatusDropdownArrow() {
    	return properties.getProperty("DCSStatusDropdownArrow");
    }
    public String getDCSStatusActive() {
    	return properties.getProperty("DCSStatusActive");
    }
    public String getDCSStatusTerminated() {
    	return properties.getProperty("DCSStatusTerminated");
    }
    public String getDCSStatusTransferred() {
    	return properties.getProperty("DCSStatusTransferred");
    }
    public String getDCSStatusAll() {
    	return properties.getProperty("DCSStatusAll");
    }
    public String getDCSStatusDropdownCross() {
    	return properties.getProperty("DCSStatusDropdownCross");
    }
    public String getDCSContractorCross() {
    	return properties.getProperty("DCSContractorCross");
    }
    public String getDCSSearchButton() {
    	return properties.getProperty("DCSSearchButton");
    }
    
    /*************Create DCS Locators***************/
    
    public String getSalutationDdArrow() {
    	return properties.getProperty("SalutationDdArrow");
    }
    public String getSalutationDdUL() {
    	return properties.getProperty("SalutationDdUL");
    }
    public String getDcsLastName() {
    	return properties.getProperty("DcsLastName");
    }
    public String getDcsFirstName() {
    	return properties.getProperty("DcsFirstName");
    } 
    public String getDcsMiddleName() {
    	return properties.getProperty("DcsMiddleName");
    }
    public String getDcsPreferredName() {
    	return properties.getProperty("DcsPreferredName");
    }
    public String getMappedSitesDdArrow() {
    	return properties.getProperty("MappedSitesDdArrow");
    }
    public String getMappedSitesDdTextBox() {
    	return properties.getProperty("MappedSitesDdTextBox");
    }
    public String getMappedSitesDdCheckBox() {
    	return properties.getProperty("MappedSitesDdCheckBox");
    }
    public String getChangeHomeSiteRadioPart1() {
    	return properties.getProperty("ChangeHomeSiteRadioPart1");
    }
    public String getChangeHomeSiteRadioPart2() {
    	return properties.getProperty("ChangeHomeSiteRadioPart2");
    }
    public String getMappedSitesDdCross() {
    	return properties.getProperty("MappedSitesDdCross");
    }
    public String getDcsDob() {
    	return properties.getProperty("DcsDob");
    }
    public String getGenderDdUl() {
    	return properties.getProperty("GenderDdUl");
    }
    public String getGenderDdArrow() {
    	return properties.getProperty("GenderDdArrow");
    }
    public String getRadioParantDiv() {
    	return properties.getProperty("RadioParantDiv");
    }
    public String getNASSNRadio() {
    	return properties.getProperty("NASSN");
    }
    public String getmonthTable() {
    	return properties.getProperty("monthTable");
    }
    public String getdayTable() {
    	return properties.getProperty("dayTable");
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
    public String getDcsLocDdArrow() {
    	return properties.getProperty("DcsLocDdArrow");
    }
    public String getDcsLocDdUl() {
    	return properties.getProperty("DcsLocDdUl");
    }
    public String getDcsAddL1() {
    	return properties.getProperty("DcsAddL1");
    }
    public String getDcsAddL2() {
    	return properties.getProperty("DcsAddL2");
    }
    public String getDcsZip() {
    	return properties.getProperty("DcsZip");
    }
    public String getDcsZip4() {
    	return properties.getProperty("DcsZip4");
    }
    public String getDcsDirections() {
    	return properties.getProperty("DcsDirections");
    }
    public String getDcsPhone1DdArrow() {
    	return properties.getProperty("DcsPhone1DdArrow");
    }
    public String getPhone1DdUl() {
    	return properties.getProperty("Phone1DdUl");
    }
    public String getPhone1num() {
    	return properties.getProperty("Phone1num");
    }
    public String getDcsPhone2DdArrow() {
    	return properties.getProperty("DcsPhone2DdArrow");
    }
    public String getPhone2DdUl() {
    	return properties.getProperty("Phone2DdUl");
    }
    public String getPhone2num() {
    	return properties.getProperty("Phone2num");
    }
    public String getDcsPhone3DdArrow() {
    	return properties.getProperty("DcsPhone3DdArrow");
    }
    public String getPhone3DdUl() {
    	return properties.getProperty("Phone3DdUl");
    }
    public String getPhone3num() {
    	return properties.getProperty("Phone3num");
    }
    public String getFax() {
    	return properties.getProperty("Fax");
    }
    public String getEmail() {
    	return properties.getProperty("Email");
    }
    public String getDcsSaveButton() {
    	return properties.getProperty("SaveButton");
    }
    public String getDcsOkButton() {
    	return properties.getProperty("OkButton");
    }
    public String getDcsEmpCatDdArrow() {
    	return properties.getProperty("DcsEmpCatDdArrow");
    }
    public String getDcsEmpCatDdUl() {
    	return properties.getProperty("DcsEmpCatDdUl");
    }
    public String getDcsOkText() {
    	return properties.getProperty("DcsOkText");
    }
    public String getDcsEmpTypeDdArrow() {
    	return properties.getProperty("DcsEmpTypeDdArrow");
    }
    public String getDcsEmpTypeDdUl() {
    	return properties.getProperty("DcsEmpTypeDdUl");
    }
    public String getDcsEmpHireDate() {
    	return properties.getProperty("DcsEmpHireDate");
    }
   
    public String getDcsEmpDeptDdArrow() {
    	return properties.getProperty("DcsEmpDeptDdArrow");
    }
    public String getDcsEmpDeptDdUl() {
    	return properties.getProperty("DcsEmpDeptDdUl");
    }
    public String getDcsEmpOSADdArrow() {
    	return properties.getProperty("DcsEmpOSADdArrow");
    }
    public String getDcsEmpOSADdUl() {
    	return properties.getProperty("DcsEmpOSADdUl");
    }
    public String getEmployeeMntnceDdArrow() {
    	return properties.getProperty("EmployeeMntnceDdArrow");
    }
    public String getEmployeeMntnceDdUl() {
    	return properties.getProperty("EmployeeMntnceDdUl");
    }
    public String getDcsEmpCoordinatorDdArrow() {
    	return properties.getProperty("DcsEmpCoordinatorDdArrow");
    }
    public String getDcsEmpCoordinatorDdUl() {
    	return properties.getProperty("DcsEmpCoordinatorDdUl");
    }
   
    public String getDcsEmpWSD() {
    	return properties.getProperty("DcsEmpWSD");
    }
    public String getDcsEmpMHFI() {
    	return properties.getProperty("DcsEmpMHFI");
    }
    public String getDcsEmpTermiCodeDdArrow() {
    	return properties.getProperty("DcsEmpTermiCodeDdArrow");
    }
    public String getDcsEmpTermiCodeDdUl() {
    	return properties.getProperty("DcsEmpTermiCodeDdUl");
    }
    public String getDcsEmpSaveButton() {
    	return properties.getProperty("DcsEmpSaveButton");
    }
    public String getDcsEmpOkText() {
    	return properties.getProperty("DcsEmpOkText");
    }
    public String getDcsEmpOkButton() {
    	return properties.getProperty("DcsEmpOkButton");
    }
    public String getDcsEmpTermiDate() {
    	return properties.getProperty("DcsEmpTermiDate");
    }
   
    public String getDcsEmpTransModeDdArrow() {
    	return properties.getProperty("DcsEmpTransModeDdArrow");
    }
    public String getDcsEmpTransModeDdUl() {
    	return properties.getProperty("DcsEmpTransModeDdUl");
    }
    public String getDcsEmpLicenseNbr() {
    	return properties.getProperty("DcsEmpLicenseNbr");
    }
    public String getDcsEmpReqtedHours() {
    	return properties.getProperty("DcsEmpReqtedHours");
    }
    public String getDcsEmpAvailHours() {
    	return properties.getProperty("DcsEmpAvailHours");
    }
    public String getDcsEmpPRN() {
    	return properties.getProperty("DcsEmpPRN");
    }
    public String getDcsEmpEliforPay() {
    	return properties.getProperty("DcsEmpEliforPay");
    }
    public String getDcsEmpEliforOverTime() {
    	return properties.getProperty("DcsEmpEliforOverTime");
    }
    public String getDcsEmpEliforRehire() {
    	return properties.getProperty("DcsEmpEliforRehire");
    }
    
    /*************Create DCS Availability Locators***************/
    
    public String getDhtmlOnDcsListing() {
    	return properties.getProperty("DhtmlOnDcsListing");
    }
    public String getAvailOpInDhtml() {
    	return properties.getProperty("AvailOpInDhtml");
    }
    public String getCreateAvaiButton() {
    	return properties.getProperty("CreateAvaiButton");
    }
    public String getRecurrencePDiv() {
    	return properties.getProperty("RecurrencePDiv");
    }
    public String getEveryDaysInput() {
    	return properties.getProperty("EveryDaysInput");
    }
    public String getSlot1StartTimeD() {
    	return properties.getProperty("Slot1StartTimeD");
    }
    public String getSlot1EndTimeD() {
    	return properties.getProperty("Slot1EndTimeD");
    }
    public String getSlot2StartTimeD() {
    	return properties.getProperty("Slot2StartTimeD");
    }
    public String getSlot2EndTimeD() {
    	return properties.getProperty("Slot2EndTimeD");
    }
    public String getSlot1StartTime() {
    	return properties.getProperty("Slot1StartTime");
    }
    public String getSlot1EndTime() {
    	return properties.getProperty("Slot1EndTime");
    }
    public String getSlot2StartTime() {
    	return properties.getProperty("Slot2StartTime");
    }
    public String getSlot2EndTime() {
    	return properties.getProperty("Slot2EndTime");
    }
    public String getStartDate() {
    	return properties.getProperty("StartDate");
    }
    public String getEndDate() {
    	return properties.getProperty("EndDate");
    }
    public String getDcsAvailabilityNoOfRows() {
    	return properties.getProperty("DcsAvailabilityNoOfRows");
    }
    public String getDcsAvailabilityDateCell() {
    	return properties.getProperty("DcsAvailabilityDateCell");
    }
    public String getEffectiveFromDate() {
    	return properties.getProperty("EffectiveFromDate");
    }
    public String getWeeklyTimeInput() {
    	return properties.getProperty("WeeklyTimeInput");
    }
    public String getMonthlyDayRadio() {
    	return properties.getProperty("MonthlyDayRadio");
    }
    public String getMonthlyWeekRadio() {
    	return properties.getProperty("MonthlyWeekRadio");
    }
    public String getWeekDdArrow() {
    	return properties.getProperty("WeekDdArrow");
    }
    public String getWeekDdUl() {
    	return properties.getProperty("WeekDdUl");
    }
    public String getDayDdArrow() {
    	return properties.getProperty("DayDdArrow");
    }
    public String getDayDdUl() {
    	return properties.getProperty("DayDdUl");
    }
    public String getDivToSwitch() {
    	return properties.getProperty("DivToSwitch");
    }
    public String getCreateUnAvail() {
    	return properties.getProperty("createUnAvail");
    }
    public String getExceptionTypeDdArrow() {
    	return properties.getProperty("ExceptionTypeDdArrow");
    }
    public String getExceptionTypeDdUl() {
    	return properties.getProperty("ExceptionTypeDdUl");
    }
    public String getStartDateInput() {
    	return properties.getProperty("StartDateInput");
    }
    public String getEndDateInput() {
    	return properties.getProperty("EndDateInput");
    }
    public String getStartTimeInput() {
    	return properties.getProperty("StartTimeInput");
    }
    public String getEndTimeInput() {
    	return properties.getProperty("EndTimeInput");
    }
    public String getDescriptionTextArea() {
    	return properties.getProperty("DescriptionTextArea");
    }
    public String getUnAvailCreateButton() {
    	return properties.getProperty("UnAvailCreateButton");
    }
    
   
    
    /*************ManageVisits Locators***************/
    
    public String getSchedulingHeader() {
    	return properties.getProperty("SchedulingHeader");
    }
    public String getManageVisitsOption() {
    	return properties.getProperty("ManageVisitsOption");
    }
    public String getLinkVisitsSiteDdArrow() {
    	return properties.getProperty("LinkVisitsSiteDdArrow");
    }
    public String getLinkVisitsSiteDdul() {
    	return properties.getProperty("LinkVisitsSiteDdul");
    }
    public String getLinkVisitsSearchButton() {
    	return properties.getProperty("LinkVisitsSearchButton");
    }
    public String getLinkVisitsCheckOut() {
    	return properties.getProperty("LinkVisitsCheckOut");
    }
    public String getLVClockIn() {
    	return properties.getProperty("LVClock-In");
    }
    public String getLVClockOut() {
    	return properties.getProperty("LVClock-Out");
    }
    public String getLVarrivalAdjsutReasonDdArrow() {
    	return properties.getProperty("LVarrivalAdjsutReasonDdArrow");
    }
    public String getLVarrivalAdjsutReasonDdUl() {
    	return properties.getProperty("LVarrivalAdjsutReasonDdUl");
    }
    public String getLVdepartureAdjsutReasonDdArrow() {
    	return properties.getProperty("LVdepartureAdjsutReasonDdArrow");
    }
    public String getLVdepartureAdjsutReasonDdUl() {
    	return properties.getProperty("LVdepartureAdjsutReasonDdUl");
    }
    public String getLVAddTaskButton() {
    	return properties.getProperty("LVAddTaskButton");
    }
    public String getLVAddTaskDdArrow() {
    	return properties.getProperty("LVAddTaskDdArrow");
    }
    public String getLVAddTaskDdUl() {
    	return properties.getProperty("LVAddTaskDdUl");
    }
    public String getLVTaskAddButton() {
    	return properties.getProperty("LVTaskAddButton");
    }
    public String getLVTaskCloseButton() {
    	return properties.getProperty("LVTaskCloseButton");
    }
    public String getLvCreateButton() {
    	return properties.getProperty("LvCreateButton");
    }
    public String getReconcilRadioButton() {
    	return properties.getProperty("ReconcilRadioButton");
    }
    public String getReconcilVisitCB() {
    	return properties.getProperty("ReconcilVisitCB");
    }
    public String getReconcilProcessB() {
    	return properties.getProperty("ReconcilProcessB");
    }
    public String getReconcilProcessWarning() {
    	return properties.getProperty("ReconcilProcessWarning");
    }
    public String getRCAccertText() {
    	return properties.getProperty("RCAccertText");
    }
    
    
    /*************HomePage Ps Locators***************/
    
    public String getPSPlusIcon() {
    	return properties.getProperty("PSPlusIcon");
    }
    public String getPSPlusIconSiteLevel() {
    	return properties.getProperty("PSPlusIconSiteLevel");
    }
    public String getPayorPlanlevelHambergermenu() {
    	return properties.getProperty("PayorPlanlevelHambergermenu");
    }
    public String getActiveService() {
    	return properties.getProperty("ActiveService");
    }
    public String getServiceLevelHambergermenu() {
    	return properties.getProperty("ServiceLevelHambergermenu");
    }
    public String getManageCarePlan() {
    	return properties.getProperty("ManageCarePlan");
    }
    public String getCategoryDdArrow() {
    	return properties.getProperty("CategoryDdArrow");
    }
    public String getCategoryDdUl() {
    	return properties.getProperty("CategoryDdUl");
    }
    public String getEffectiveFromACareP() {
    	return properties.getProperty("EffectiveFromACareP");
    }
    public String getAddTasksBACareP() {
    	return properties.getProperty("AddTasksBACareP");
    }
    public String getTaskCheckBInCarePlan() {
    	return properties.getProperty("TaskCheckBInCarePlan");
    }
    public String getTaskTableInCarePlan() {
    	return properties.getProperty("TaskTableInCarePlan");
    }
    public String getTaskCodeInCarePlan() {
    	return properties.getProperty("TaskCodeInCarePlan");
    }
    public String getAddButtonOnTaskList() {
    	return properties.getProperty("AddButtonOnTaskList");
    }
    public String getDaysPerWeekOnTaskPlanList() {
    	return properties.getProperty("DaysPerWeekOnTaskPlanList");
    }
    public String getCreateButtonOnTaskPlanList() {
    	return properties.getProperty("CreateButtonOnTaskPlanList");
    }
    public String getCancelButtonOnTaskPlanList() {
    	return properties.getProperty("CancelButtonOnTaskPlanList");
    }
    /*************BPCRM_SALES_ACCOUNTS***************/
    public String getBpcrmMenu() {
    	return properties.getProperty("BpcrmMenu");
    }
    public String getSalesMenu(){
    	return properties.getProperty("SalesMenu");
    }
    public String getAccounts() {
    	return properties.getProperty("Accounts");
    }
    public String getAccountsHeading() {
    	return properties.getProperty("AccountsHeading");
    }
    public String getBranchDropdown() {
    	return properties.getProperty("BranchDropdown");
    }
    public String getBranchSearchInputfield() {
    	return properties.getProperty("BranchSearchInputfield");
    }
    public String getBrancheSelection() {
    	return properties.getProperty("BrancheSelection");
    }
    public String getAddAccountButton() {
    	return properties.getProperty("AddAccountButton");
    }
    public String getNewAccountCreateHeading() {
    	return properties.getProperty("NewAccountCreateHeading");
    }
    public String getAccountname() {
    	return properties.getProperty("Accountname");
    }
    public String getHomeIcon() {
    	return properties.getProperty("HomeIcon");
    }
    public String getAdressHeading() {
    	return properties.getProperty("AdressHeading");
    }
    public String getLocationDropdown() {
    	return properties.getProperty("LocationDropdown");
    }
    public String getLocationDropDownList() {
    	return properties.getProperty("LocationDropDownList");
    }
    public String getLocationAddressLine1() {
    	return properties.getProperty("AddressLine1");
    }
    public String getZipcode() {
    	return properties.getProperty("Zipcode");
    }
    public String getPhone1Numberfield() {
    	return properties.getProperty("Phone1Numberfield");
    }
    public String getPhone1DropDownField() {
    	return properties.getProperty("Phone1DropDownField");
    }
    public String getPhone1DropDownList() {
    	return properties.getProperty("Phone1DropDownList");
    }
    public String getSaveButton1() {
    	return properties.getProperty("SaveButton1");
    }
    public String getRchc_Road_MapDropdown() {
    	return properties.getProperty("Rchc_Road_MapDropdown");
    }
    public String getRchcDropDownList() {
    	return properties.getProperty("RchcDropDownList");
    }
    public String getCreateButton1() {
    	return properties.getProperty("CreateButton1");
    }
    public String getContactIcon() {
    	return properties.getProperty("ContactIcon");
    }
    public String getContacts() {
    	return properties.getProperty("Contacts");
    }
    public String getAccountname1() {
    	return properties.getProperty("Accountname1");
    }
    public String getPhonefield() {
    	return properties.getProperty("Phonefield");
    }
    public String getSearchBtn() {
    	return properties.getProperty("SearchButton");
    }
    public String getAddContacts() {
    	return properties.getProperty("AddContacts");
    }
    public String getContactsHeading() {
    	return properties.getProperty("ContactsHeading");
    }
    public String getContactFirstName() {
    	return properties.getProperty("ContactFirstName");
    }
    public String getContactLastName() {
    	return properties.getProperty("ContactLastName");
    }
    public String getTitleField() {
    	return properties.getProperty("Titlefield");
    }
    public String getAssignedToDropDown() {
    	return properties.getProperty("AssignedToDropDown");
    }
    public String getAssignedToSearchField() {
    	return properties.getProperty("AssignedToSearchField");
    }
    public String getAssignedToSelection() {
    	return properties.getProperty("AssignedToSelection");
    }
    public String getSalesOpportunities() {
    	return properties.getProperty("SalesOpportunities");
    }
    public String getSalesOpportunitiesIcon() {
    	return properties.getProperty("SalesOpportunitiesIcon");
    }
    public String getSalesOpportunitiesHeading() {
    	return properties.getProperty("SalesOpportunitiesHeading");
    }
    public String getAddSales_Opportunity() {
    	return properties.getProperty("AddSales_Opportunity");
    }
    public String getCreateSalesOpportunitiesHeadding() {
    	return properties.getProperty("CreateSalesOpportunitiesHeadding");
    }
    public String getSalesOpportunitiesName() {
    	return properties.getProperty("SalesOpportunitiesName");
    }
    public String getTypeDropDown() {
    	return properties.getProperty("TypeDropDown");
    }
    public String getTypeDropDownList() {
    	return properties.getProperty("TypeDropDownList");
    }
    public String getRevenue() {
    	return properties.getProperty("Revenue");
    }
    public String getSalesActivityIcon() {
    	return properties.getProperty("SalesActivityIcon");
    }
    public String getSalesActivityHeadding() {
    	return properties.getProperty("SalesActivityHeadding");
    }
    public String getAddSalesActivity() {
    	return properties.getProperty("AddSalesActivity");
    } 
    public String getCreateNewSalesActivityHeadding() {
    	return properties.getProperty("CreateNewSalesActivityHeadding");
    }
    public String getActivityTypeDropDown() {
    	return properties.getProperty("ActivityTypeDropDown");
    }
    public String getActivityTypeList() {
    	return properties.getProperty("ActivityTypeList");
    }
    public String getActivityDate() {
    	return properties.getProperty("ActivityDate");
    }
    public String getStatusDropDown() {
    	return properties.getProperty("StatusDropDown");
    }
    public String getStatusDropDownlist() {
    	return properties.getProperty("StatusDropDownlist");
    }
    public String getPreVisitObjectiveField() {
    	return properties.getProperty("PreVisitObjectiveField");
    }
    public String getPostVisitNotesField() {
    	return properties.getProperty("PostVisitNotesField");
    }
    public String getAbandonedDropdown() {
    	return properties.getProperty("AbandonedDropdown");
    }
    public String getAbandonedList() {
    	return properties.getProperty("AbandonedList");
    }
    public String getContactsBranchDropdown() {
    	return properties.getProperty("ContactsBranchDropdown");
    }
    public String getAccountListIcon() {
    	return properties.getProperty("AccountListIcon");
    }
    public String getAcountsearchfield() {
    	return properties.getProperty("Acountsearchfield");
    }
    public String getThissiteradiobutton() {
    	return properties.getProperty("Thissiteradiobutton");
    }
    public String getGobutton() {
    	return properties.getProperty("Gobutton");
    }
    public String getAccountnamefirstvalue() {
    	return properties.getProperty("Accountnamefirstvalue");
    }
    
    }
