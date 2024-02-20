package resource;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
 
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ConfigurableReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.Base_Class;

 
public class ExtentManager {
    public static ExtentReports extent;
    public static ExtentReporter htmlReporter;
    public static ExtentTest test;
    public static void setExtent() {
    	  htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"//Reports/"+"ExtentReport_"+Base_Class.getCurrentTime()+".html");
    	  ((ConfigurableReporter) htmlReporter).loadXMLConfig(System.getProperty("user.dir")+"/src/main/java/resource/Extent-config.xml");
    	  //htmlReporter.config().setDocumentTitle("Automation Test Report");
    	  //htmlReporter.config().setReportName("OrangeHRM Test Automation Report");
    	  //htmlReporter.config().setTheme(Theme.DARK);
    	  
    	  extent = new ExtentReports();
    	  extent.attachReporter(htmlReporter);
    	 
    	  extent.setSystemInfo("ProjectName", "Appium_Andriod_Automation");
    	  extent.setSystemInfo("Tester", "Nasar");
    	  extent.setSystemInfo("OS", "MAC-Catalina");
    	 }
    	 public static void endReport() {
    	  extent.flush();
    	 }
    
}