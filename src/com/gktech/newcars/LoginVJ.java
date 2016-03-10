package com.gktech.newcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gktech.util.TestUtil;

public class LoginVJ extends TestSuiteBase {

//Firstly, to check the testdata Runmode, we are declaring an integer count variable
	static int count = -1;
	
@BeforeTest
	public void checkTestCaseSkip () { 	
		if (!TestUtil.isTestCaseRunnable(newcarsxls, "Login")) {
		throw new SkipException("Runmode of Login testcase is set as NO, so skipping Login testcase");
			
		}
		runmodes = TestUtil.getTestDataRunmodes(newcarsxls, "Login");	
		}

// test case
@Test (dataProvider = "getData")
	public void login(String uname, String pass) {
		count++;
//now check the testdata runmodes		
		if (!runmodes[count].equalsIgnoreCase("Y")) {
		throw new SkipException("Runmode of the testdata is set as NO, so skipping row number: "+(count+1));	
		}
//Executing testcase
		System.out.println("Executing the testcase with parameters: "+uname+"  "+pass);
//webdriver code
		OpenBrowser();
		driver.get(CONFIG.getProperty("baseurl"));
		getObject("loglink").click();
		getObject("loguname").sendKeys(uname);
		getObject("logpass").sendKeys(pass);
		getObject("logbutton").click();

		}
//Get the data from excel file
@DataProvider
	public String[][] getData() {
		return TestUtil.getTestData(newcarsxls, "Login");
		}
}