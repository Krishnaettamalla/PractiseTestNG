package com.hyr.extentreports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Chapter3 {
	public static void main(String[] args) throws IOException {
		//this is main for extent reports
		ExtentReports extentReports=new ExtentReports();//this is the engine
		//ExtentSparkReporter sparkReporter=new ExtentSparkReporter("D:\\Eclipse WorkSPace3\\PracticeTestNG\\report.html");
		
		File file = new File("report.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		
		ExtentTest test1=extentReports.createTest("Test 1");
		test1.pass("this is passed");
		
		ExtentTest test2=extentReports.createTest("Test 1");
		test1.log(Status.FAIL, "this is failed");
		
		//we an directly do without creating instance
		extentReports.createTest("Test 1").skip("thi si skipped");
		
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}
}
