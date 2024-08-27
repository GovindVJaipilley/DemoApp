package TestNgRunner;

import java.util.Collections;

import org.testng.TestNG;

public class Poc_Xml_Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		TestNG testng = new TestNG();
		String suiteXmlFilePath = "RegressionScripts.xml";
		testng.setTestSuites(Collections.singletonList(suiteXmlFilePath));
		testng.run();
	}
}
