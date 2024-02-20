package Appium_Andriod_Automation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import pageObjects.LoginPage;
import pageObjects.Product_List_Page;
import resource.ExtentManager;
import utils.Base_Class;

public class LoginTest extends Base_Class{

	private static final Object True = null;
	Logger logger=Logger.getLogger(LoginTest.class);
	ExtentManager manager=new ExtentManager();

	@Test(priority = 0)
	public void verify_App() throws InterruptedException, IOException{
		LoginPage login=new LoginPage(driver);
		logger.info("Verifying correct app launch or not");
		Boolean verify_app=login.verify_correct_app().isDisplayed();
		Thread.sleep(2000);
		Assert.assertTrue(verify_app);
		manager.test.log(Status.INFO, "Successfully launched General-store app");
		logger.info("Verified:Correct app launched successfully");
	}

	@Test(priority=1)
	public void verify_select_country_dropdown() throws InterruptedException, IOException {
		LoginPage login=new LoginPage(driver);
		logger.info("Try to select country dropdown");
		login.select_country_dropdown.click();
		login.select_country_dropdown_option.click();
		String dropdown=login.verify_dropdown_function.getText();
		Assert.assertEquals(dropdown, "American Samoa");
		manager.test.log(Status.INFO, "Dropdown button working fine");
		logger.info("Country dropdown selected successfully");
	}
	@Test(priority = 2)
	public void verify_name_field() throws InterruptedException {
		LoginPage login=new LoginPage(driver);
		logger.info("Try to sent text in Your name field");
		login.verify_enter_name().sendKeys("Varisha");
		String your_name=login.your_name_field.getText();
		Assert.assertEquals(your_name, "Varisha");	
		manager.test.log(Status.INFO, "Enter your name field working fine");
		logger.info("Text sent successfully in Your name field");
	}
	@Test(priority = 3)
	public void verify_gender_radio_button() throws InterruptedException {
		LoginPage login=new LoginPage(driver);
		logger.info("Try to choose gender radio button");
		login.gender_radio_button.click();
		Boolean gender=login.gender_radio_button.isDisplayed();
		assertTrue(gender);
		manager.test.log(Status.INFO, "Gender radio button working fine");
		logger.info("Successfully choosed gender radio button");
	}
	@Test(priority = 4)
	public void verify_Lets_Shop_button() throws InterruptedException {
		LoginPage login=new LoginPage(driver);
		logger.info("Try to click Lets shop button");
		login.Lets_Shop_button.click();
		Product_List_Page product=new Product_List_Page(driver);
		Thread.sleep(1000);
		Boolean verify_lets_shop= product.product_page.isDisplayed();
		Assert.assertTrue(verify_lets_shop);
		manager.test.log(Status.INFO, "Lets Shop button working fine");
		logger.info("Lets shop button tapped successfully");

	}
}
