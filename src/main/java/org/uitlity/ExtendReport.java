package org.uitlity;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfiguration;

public class ExtendReport extends BaseClas {

	public static ExtentReports extendsreport() {

		ExtentReports report = new ExtentReports();

		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\repost.html");

		ExtentSparkReporter spark = new ExtentSparkReporter(f);

		ExtentSparkReporterConfiguration config = spark.config();

		config.setDocumentTitle("LibertHealth");

		config.setReportName("ExtendReports");

		report.attachReporter(spark);

		report.setSystemInfo("userName",System.getProperty("user.name"));

		report.setSystemInfo("OS",System.getProperty("os.name"));

		report.setSystemInfo("Java Version",System.getProperty("java.version"));

//		report.setSystemInfo("BrowserName", browserName());
//		
//		report.setSystemInfo("BrowserVersion", browserVersion());
//		
		
	
		return report;


	}


//	public static String browserName() {
//
//		RemoteWebDriver r = ((RemoteWebDriver)driver);
//
//		return r.getCapabilities().getBrowserName();
//
//
//	}
//
//	public static String browserVersion() {
//
//		RemoteWebDriver r = ((RemoteWebDriver)driver);
//
//		return r.getCapabilities().getBrowserVersion();
//
//
//	}


}
