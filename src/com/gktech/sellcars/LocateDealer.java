package com.gktech.sellcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gktech.util.TestUtil;

public class LocateDealer extends TestSuiteBase {
	
	static int count = -1;
	
	@BeforeTest
	public void checkTestCaseSkip() {
		if(!TestUtil.isTestCaseRunnable(sellcarsxls, "LocateDealer")) {
		throw new SkipException("Runmode of LocateDealer testcase is set as NO, then skipping LocateDealer testcase");
		}
		runmodes = TestUtil.getTestDataRunmodes(sellcarsxls, "LocateDealer");
		}
	
	
	@Test(dataProvider = "getData")
	public void locatedealer(String uname, String passwd) {
		count ++;
		if (!runmodes[count].equalsIgnoreCase("Y")){
		throw new SkipException("Runmode of testdata is set as NO, then skipping Rownumber :" +(count+1));
		}
	//Executing testcase	
		System.out.println("Executing testcase of LocateDealer with parameters: "+uname+"  "+passwd);
	//Webdriver code
	
		
		}
	
	@DataProvider
	public String[][] getData() {
		return TestUtil.getTestData(sellcarsxls, "LocateDealer");
	}

}
