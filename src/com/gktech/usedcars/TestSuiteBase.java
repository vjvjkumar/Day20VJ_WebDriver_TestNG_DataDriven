package com.gktech.usedcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import com.gktech.base.TestBase;
import com.gktech.util.TestUtil;

public class TestSuiteBase extends TestBase {
	
	@BeforeSuite
	public void checkSuiteSkip() throws Exception{
		Initialize();
		if(!TestUtil.isSuiteRunnable(Suitexls, "usedcars")){
		throw new SkipException("Runmode of usedcars suite is set as NO, so skipping runmode of usedcars suite");	
		}
		
	}
	

}
