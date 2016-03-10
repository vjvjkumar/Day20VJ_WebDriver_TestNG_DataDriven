package com.gktech.sellcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gktech.util.TestUtil;

public class SearchCar extends TestSuiteBase {
	
	static int count = -1;
	
	@BeforeTest
	public void checkTestCaseSkip() {
		if(!TestUtil.isTestCaseRunnable(sellcarsxls, "SearchCar")) {
		throw new SkipException("Runmode of SearchCar testcase is set as NO, then skipping SearchCar testcase");
		}
		runmodes = TestUtil.getTestDataRunmodes(sellcarsxls, "SearchCar");
		}
	
	@Test (dataProvider = "getData")
	public void searchcar (String name, String email, String mobile, String passwd, String cnfmpasswd){
		count ++;
		if (!runmodes[count].equalsIgnoreCase("Y")){
		throw new SkipException("Runmode of testdata is set as NO, so skipping Rownumber :"+ (count+1));	
		}
	//Executing testcase
		System.out.println("Executing testcase of SearchCar with parameters: "+name+"  "+email+"  "+mobile+"  "+passwd+"  "+cnfmpasswd);
	//Webdriver code
		
		
		}
	
	@DataProvider
	public String [][] getData(){
		return TestUtil.getTestData(sellcarsxls, "SearchCar");
		
	}
}
