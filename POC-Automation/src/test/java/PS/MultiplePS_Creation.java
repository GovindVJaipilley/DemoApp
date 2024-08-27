package PS;

import java.io.IOException;

import org.testng.annotations.Test;

import Admission.CreateAdmission;
import Authorization.CreateAuthInBaseFlow;
import LoginPage.BaseClass;
import PayorPlan.AddPayorPlan;
import Utilities.ExcelRead;

public class MultiplePS_Creation 
{
	
	
	public static int i;
	
	
	
	int rowcount1 = new ExcelRead(BaseClass.getTestDataPath()).getRowCount("PSBasicDetails_1");
	@Test
	public void MultiplePS() throws InterruptedException, IOException{
		CreatePS CPS = new CreatePS();
		CreateAdmission CA = new CreateAdmission();
		AddPayorPlan APP = new AddPayorPlan();
		CreateAuthInBaseFlow CABF = new CreateAuthInBaseFlow();
		CreatePS.rowcount=rowcount1;

		for (i = 2; i<=rowcount1-2; i++) {
			if(i == 12)
				break;
			CPS.allProps();
			
			CPS.navigateToHome();
			CPS.createPSPopup();
			CPS.createPSBasicDetails();
			CPS.createPSAddressDetails();
			CPS.createPSGuarantorDetails();	
			CA.driversForAdmission();
			CA.createAdmission();
			APP.beforeTest();
			APP.CreatePayorPlan();
			CABF.driversForAdmission();
			CABF.createAuthorization();	
			CPS.driver.navigate().refresh();
			System.out.println("ps:"+(i-1));
		}
					
	}
	
	 
}

