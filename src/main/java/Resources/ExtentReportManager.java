package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportManager {
	
	
	public static ExtentReports getExtentReports() {
		
		String path = System.getProperty("user.dir")+"//Extentsreports//index.html"; // setting path for the report 
		ExtentSparkReporter ESReport = new ExtentSparkReporter(path);
		//ExtentSparkReporter: this is the class /sub class responsible for generating the HTML report.
		//new ExtentSparkReporter(path): It will create the report at the path defined above.
		ESReport.config().setDocumentTitle("IshaDonationflowreport");
		ESReport.config().setReportName("Isha Donation Flow Web Automation Testing");
		
		ExtentReports EXTReport = new ExtentReports();
		// ExtentReports is Main class for logging tests and generating the report.
		EXTReport.attachReporter(ESReport);
		EXTReport.setSystemInfo("Software Tester", "Gayatri Bodake");
		//This connects the ExtentSparkReporter (HTML generator) to the main ExtentReports object.Without this line, no report file will be generated.
		
		return EXTReport;
		
	}

}
