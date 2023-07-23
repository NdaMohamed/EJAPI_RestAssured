package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportlistner {

	ExtentSparkReporter spark = new ExtentSparkReporter("Report.html");
	
	// create ExtentReports and attach reporter(s)
    ExtentReports extent = new ExtentReports();
    
    
}
