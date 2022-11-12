package com.hyr.extentreports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Chapter4 {
public static void main(String[] args) throws IOException {
	
	//this is main for extent reports
	ExtentReports extentReports=new ExtentReports();//this is the engine
	//ExtentSparkReporter sparkReporter=new ExtentSparkReporter("D:\\Eclipse WorkSPace3\\PracticeTestNG\\report.html");
	
	File file = new File("report.html");
	ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);
	extentReports.attachReporter(sparkReporter);
	
	extentReports
	.createTest("Test 1")
	.log(Status.INFO, "info1")
	.log(Status.INFO, "info2")
	.log(Status.INFO, "info3")
	.log(Status.PASS, "pass")
	.log(Status.WARNING, "warning")
	.log(Status.WARNING, "warning")
	.log(Status.SKIP, "skip")
	.log(Status.INFO, "info8")
	.log(Status.FAIL ,"fail");
	
	extentReports.flush();    
	
	Desktop.getDesktop().browse(new File("report.html").toURI());
}
}
