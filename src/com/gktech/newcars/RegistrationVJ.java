package com.gktech.newcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gktech.util.TestUtil;

public class RegistrationVJ extends TestSuiteBase {
	
	static int count= -1;
	
	@BeforeTest
	public void checkTestCaseSkip(){
		if (!TestUtil.isTestCaseRunnable(newcarsxls, "Registration")){
		throw new SkipException("Runmode of Registration testcase is set as NO, then skipping Registration testcase");
		}
		runmodes = TestUtil.getTestDataRunmodes(newcarsxls, "Registration"); 	
		}
	
	@Test (dataProvider="getData")
	public void registration(String name, String email, String mobile, String passwd, String cnfmpasswd){
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
		throw new SkipException("Runmode of testdata is set as NO, then skipping Rownumber  "+ (count+1));
		}
		
// Executing testcase
		System.out.println("Executing testcase Registration with parameters: "+name+"  "+email+"  "+passwd+"  "+cnfmpasswd);	
// Webdriver code
		OpenBrowser();
		driver.get(CONFIG.getProperty("baseurl"));
		getObject("loglink").click();
		getObject("regsignup").click();
		getObject("regname").sendKeys(name);
		getObject("regemail").sendKeys(email);
		getObject("regmobile").sendKeys(mobile);
		getObject("regpass").sendKeys(passwd);
		getObject("regconfpass").sendKeys(cnfmpasswd);
		getObject("regsignupbutton").click();

	}
	
	@DataProvider
	public String [][] getData(){
		return TestUtil.getTestData(newcarsxls, "Registration");
	}

}
