package Appium_Andriod_Automation;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.Checkout_Page;
import pageObjects.Product_List_Page;
import resource.ExtentManager;
import utils.Base_Class;
import utils.Utilities;

public class Product_List_Page_Test extends Base_Class {
	Logger logger=Logger.getLogger(Product_List_Page_Test.class);
	ExtentManager manager=new ExtentManager();
	@Test(priority = 5)
	public void verify_add_to_cart() throws InterruptedException {
		Product_List_Page product=new Product_List_Page(driver);
		Thread.sleep(2000);		
		logger.info("Try to add product from cart");
		product.Product_add.click();
		Thread.sleep(2000);
		product.Product_add.click();
		Thread.sleep(2000);
		product.click_cart.click();
		logger.info("product added in cart session");
		Checkout_Page checkout=new Checkout_Page(driver);
		Thread.sleep(2000);
		logger.info("Verfying cart session product there or not");
		String verify_product=checkout.add_to_cart.getText();
		Assert.assertEquals(verify_product,"Air Jordan 4 Retro");
		manager.test.log(Status.INFO, "Add to cart button working fine");		
	}
	@Test(priority = 6)
	public void verify_scroll_down() throws InterruptedException {
		Checkout_Page checkout=new Checkout_Page(driver);
		
		checkout.back_checkout.click();
		Thread.sleep(2000);
		Utilities scroll=new Utilities(driver);
		logger.info("Try to scroll down");
		scroll.scrollToText("PG 3");
		manager.test.log(Status.INFO, "Scrolling working Fine");
		logger.info("Scrolling successfully");
		scroll.scrollToText("Air Jordan 4 Retro");
	}
}
