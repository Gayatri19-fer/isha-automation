package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class BaseExtentReport {
	
	 public static ExtentReports extent;

	    public static void initReports() {
	        if (extent == null) {
	            extent = ExtentReportManager.getExtentReports();
	        }
	    }

	    public static void flushReports() {
	        if (extent != null) {
	            extent.flush();
	        }
	    }

}