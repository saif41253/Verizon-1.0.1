package com.crm.listenerutility.test;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.genericutility.test.BaseClassTest;

public class ListenerImp implements ITestListener, ISuiteListener{
	ExtentSparkReporter spark;
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		//progrm for report config
		
		// spark report config
		String time = new Date().toString().replace(" ", "-");// time stamp for overriding report
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);
		// add env info
		report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-10");
		report.setSystemInfo("BrowseR", "Chrome 32.54");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
//		progrm for report backup
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("==="+result.getMethod().getMethodName()+"===test start");
		test = report.createTest(result.getMethod().getMethodName());
		// before executing every test method we are set the test property
		
		test.log(Status.INFO, result.getMethod().getMethodName()+"==Start==");
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("==="+result.getMethod().getMethodName()+"===test end===");
		test.log(Status.PASS, result.getMethod().getMethodName()+"==Complete==");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot)BaseClassTest. sdriver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "-");
//		test.addScreenCaptureFromBase64String(src,"Error or fail");
		test.addScreenCaptureFromBase64String(src,testName+"_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"==Failed==");

//		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClassTest.sdriver);
//		File src = edriver.getScreenshotAs(OutputType.FILE);
//		String time = new Date().toString().replace(" ", "-");
//		File dest= new File("./screenshot/"+testName+"  + "+time+".png");
//		try {
//			FileUtils.copyFile(src, dest);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, result.getMethod().getMethodName()+"==Skiped==");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}



}
