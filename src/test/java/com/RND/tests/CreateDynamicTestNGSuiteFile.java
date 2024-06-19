package com.RND.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class CreateDynamicTestNGSuiteFile {
	
	static String filePath = "C:\\Users\\prashanta.behera\\eclipse-workspace\\RND\\resources\\TestRunner.xlsx";

	public static void main(String[] args) {
		//create TestNG object
		TestNG testNG = new TestNG();
		
		//create suite object
		XmlSuite xmlSuite = new XmlSuite();
		xmlSuite.setName("Suite1");
		xmlSuite.setParallel(XmlSuite.ParallelMode.METHODS);
		xmlSuite.setThreadCount(5);
		xmlSuite.setVerbose(2);//to get all log file in console
		
		//create test object
		XmlTest xmlTest = new XmlTest(xmlSuite);
		xmlTest.setName("Test");
		xmlTest.setPreserveOrder(true);
		
		//create class object
		XmlClass xmlClass = new XmlClass("com.RND.tests.RND_Test");
		
		//add all test methods
		List<XmlInclude> allMethods = new ArrayList<XmlInclude>();
//		allMethods.add(new XmlInclude("TC_00_sendOTP"));
		
		Fillo fillo = new Fillo();
		Recordset recordset = null;
		Connection connection =  null;
		
		 try {
			    connection= fillo.getConnection(filePath);
	            String query = "SELECT * FROM Sheet1"; // Assuming the test method names are in Sheet1
	            recordset = connection.executeQuery(query);
	            while (recordset.next()) {
	            	if(recordset.getField("Run").equals("Yes")) {
	                String methodName = recordset.getField("TestMethod");
	                allMethods.add(new XmlInclude(methodName));
	            	}
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (connection != null) {
	                connection.close();
	            }
	        }
		
		
		xmlClass.setIncludedMethods(allMethods);//tagging to class
		
		xmlTest.getClasses().add(xmlClass);
		
		//add TestNG suite file if multiple
		List<XmlSuite> suiteList = new ArrayList<XmlSuite>();
		suiteList.add(xmlSuite);
		
		testNG.setXmlSuites(suiteList);
		
		//run TestNG suite
		testNG.run();

	}
	
	

}
