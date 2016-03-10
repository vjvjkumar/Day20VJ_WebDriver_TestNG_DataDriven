package com.gktech.usedcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gktech.util.TestUtil;

public class UsedCarValuation extends TestSuiteBase{
	static int count =-1;

@BeforeTest
	public void checkTestCaseSkip () {
		if (!TestUtil.isTestCaseRunnable(usedcarsxls, "UsedCarValuation")){
		throw new SkipException("Runmode of UsedCarValuation testcase is set as NO, so skipping UsedCarValuation testcase");
		}
		runmodes = TestUtil.getTestDataRunmodes(usedcarsxls, "UsedCarValuation");
		}
	
@Test (dataProvider = "getData")
	public void usedCarValuation(String name, String email, String mobile, String passwd, String cnfmpasswd) {
		count ++;
		if (!runmodes[count].equalsIgnoreCase("Y")){
		throw new SkipException("Runmode of testdata is set as NO, so skipping Rownumber "+ (count+1));
		}
	//Executing testcase
		System.out.println("Executing the testcase of UsedCarvaluation with parameters: "+name+"  "+email+"  "+mobile+"  "+passwd+"  "+cnfmpasswd); 
	//Webdriver code
		
		
		}
	
@DataProvider
	public String [][] getData(){
		return TestUtil.getTestData(usedcarsxls, "UsedCarValuation");
		
	}
	
	
}
