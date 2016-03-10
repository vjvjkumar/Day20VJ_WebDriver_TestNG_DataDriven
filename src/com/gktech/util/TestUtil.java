package com.gktech.util;

public class TestUtil {
	
// Getting the Runmode of the TestSuite
		public static boolean isSuiteRunnable(XLS_Reader xls, String suiteName) {
		boolean isExecutable = false;
			
		for (int i=2; i<=xls.getRowCount("Testsuites"); i++) {
				
		String suite=xls.getCellData("Testsuites", "TSID", i);
		String runmode = xls.getCellData("TestSuites", "Runmode", i);
				
		System.out.println(suite+"   "+runmode);
				
			if (suite.equalsIgnoreCase(suiteName)){
			if (runmode.equalsIgnoreCase("Y")){
			isExecutable = true;
			}
			}
	}
	return isExecutable;
	}
		
// Getting the Runmode of the TestCase
		public static boolean isTestCaseRunnable(XLS_Reader xls, String testcaseName){
		boolean isExecutable = false;
		
		for (int i=2; i<=xls.getRowCount("Testcases"); i++) {
			String testcase = xls.getCellData("Testcases", "TCID", i);
			String runmode = xls.getCellData("Testcases", "Runmode", i);
			
			System.out.println(testcase+"   "+runmode);
			if (testcase.equalsIgnoreCase(testcaseName)){
			if (runmode.equalsIgnoreCase("Y")){
			isExecutable = true;
			}		
			}		
	}
	return isExecutable;		
	}
		
// Getting the Runmodes of TestData from Excel sheet
		public static String[] getTestDataRunmodes(XLS_Reader xls, String sheetName) {
			
			if (!xls.isSheetExist(sheetName)){
			System.out.println("Test data sheet not found");
			}
		
	// Size declaration
			String[] runmodes = new String[xls.getRowCount(sheetName)-1];
		
	// Values declaration
			for (int i=2; i<=xls.getRowCount(sheetName); i++){
			System.out.println(xls.getCellData(sheetName, "Runmode", i));
			
			runmodes[i-2]=xls.getCellData(sheetName, "Runmode", i);
		}
		return runmodes;
		}
		
//Getting the TestData from Excel Sheet
 		public static String[][]  getTestData(XLS_Reader xls, String sheetName) {
 			if (!xls.isSheetExist(sheetName)) {
 			System.out.println("Test data sheet not found");
 			}
 			int rows = xls.getRowCount(sheetName);
 			int cols = xls.getColumnCount(sheetName);
 
 //Size declaration
 			String[][] data = new String[rows-1][cols-1];
 
 //Values declaration
 			for (int rowNum=2; rowNum<=rows; rowNum++){
			for (int colNum=0; colNum<=cols-2; colNum++){   
	//in above col loop as we are not taking the "runmode" column, so "colNum<=cols-2" because cols count start from 0 1 2 3 4...etc  
				
			System.out.print(xls.getCellData(sheetName, colNum, rowNum)+"  ==  ");
			data[rowNum-2][colNum]=xls.getCellData(sheetName, colNum, rowNum);
			}
			System.out.println();
			}
			return data;
 	}	





}