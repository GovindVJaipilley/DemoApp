package TestNgRunner;

import java.util.Collections;

import org.testng.TestNG;

public class CXP_Xml_Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		TestNG testng = new TestNG();
		String suiteXmlFilePath = "src/test/resources/TestNG/CXP_RegressionScripts.xml";
		testng.setTestSuites(Collections.singletonList(suiteXmlFilePath));
		testng.run();
	}
}
