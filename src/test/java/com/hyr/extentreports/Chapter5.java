package com.hyr.extentreports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Chapter5 {
public static void main(String[] args) throws IOException {
	
	//this is main for extent reports
	ExtentReports extentReports=new ExtentReports();//this is the engine
	//ExtentSparkReporter sparkReporter=new ExtentSparkReporter("D:\\Eclipse WorkSPace3\\PracticeTestNG\\report.html");
	
	File file = new File("report.html");
	ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);
	extentReports.attachReporter(sparkReporter);
	
	extentReports.createTest("Screenshot Test1","this is for attaching screenshot to test")
	.info("this is info msg")
	.add;	
	
	extentReports.flush();
	Desktop.getDesktop().browse(new File("report.html").toURI());
}
}
