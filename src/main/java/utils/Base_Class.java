package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import resource.ExtentManager;


public class Base_Class{

	public static AndroidDriver<AndroidElement>  driver;
	Logger logger=Logger.getLogger(Base_Class.class);

	@org.testng.annotations.BeforeSuite
	public void BeforeSuite() {
		ExtentManager.setExtent();
	}

	@org.testng.annotations.AfterSuite
	public void AfterSuite() {
		ExtentManager.endReport();
		driver.quit();
	}
	@BeforeSuite
	public void setUp() throws Exception {
		FileInputStream inputstream=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resource/globalproperties.properties");
		Properties prop=new Properties();
		prop.load(inputstream);
		String app_name=prop.getProperty("General_store_app");
		String device_name=prop.getProperty("Device");
//		if(device_name.contains("Device_Nasar_Emulator")) {
//		emulator_start();
//		logger.info("Emulator started successfully");
//		}

		File location = new File("src/main/java");
		File applocation=new File(location,app_name);
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Uiautomator2");
		cap.setCapability(MobileCapabilityType.APP,applocation.getAbsolutePath());
		logger.info("App Run via emulator");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		logger.info("Appium server started successfully in 4723 port");
	}
	public static String screenShot(AndroidDriver<AndroidElement>  driver,String filename) {
		String dateName = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"/Reports/"+"/Screenshot Failed Test Case/"+filename+"_"+dateName+".png";
		File finalDestination= new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return destination;
	}
	public static String getCurrentTime() {  
		String currentDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());  
		return currentDate;  
	}  	
	public static void emulator_start() throws IOException, InterruptedException {
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"/src/main/java/resource/Emulator_Start");
		Thread.sleep(2000);
	}
}