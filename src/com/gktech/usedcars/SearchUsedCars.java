package com.gktech.usedcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gktech.util.TestUtil;

public class SearchUsedCars extends TestSuiteBase {
	
	static int count =-1;
	@BeforeTest
	public void checkTestCaseSkip() {
		if (!TestUtil.isTestCaseRunnable(usedcarsxls, "SearchUsedCars")){
		throw new SkipException("Runmode of testcase SearchUsedCars is set as NO, so skipping SearchUsedCars testcase");
		}
		runmodes = TestUtil.getTestDataRunmodes(usedcarsxls, "SearchUsedCars");
		}
	
	@Test (dataProvider = "getData")
	public void searchUsedCars(String uname, String pass){
		count ++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
		throw new SkipException("Runmode of the testdata is set as NO, so skipping the Rownumber :" +(count+1));
		}
	//Executing the testcase
		System.out.println("Executing the testcase SearchUsedCars with parameters :"+uname+"  "+pass);
	//Webdriver code
		
		
		}
	
	@DataProvider
	public String [][] getData(){
		return TestUtil.getTestData(usedcarsxls, "SearchUsedCars");
		
	}
}
