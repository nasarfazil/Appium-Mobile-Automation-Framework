package Appium_Andriod_Automation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.Checkout_Page;
import pageObjects.Product_List_Page;
import resource.ExtentManager;
import utils.Base_Class;
import utils.DB_Connect;
import utils.Utilities;

public class Checkout_Test extends Base_Class {
	@Test(priority = 7)
	public void verify_remove_product() throws InterruptedException {
		ExtentManager manager=new ExtentManager();
		Checkout_Page checkout=new Checkout_Page(driver);
		Product_List_Page product=new Product_List_Page(driver);
		product.click_cart.click();
		Thread.sleep(2000);
		checkout.back_checkout.click();
		Thread.sleep(2000);
		checkout.remove_product.click();
		product.click_cart.click();	
		Thread.sleep(4000);
		List<WebElement> element=checkout.verify_remove_product;
		for (WebElement webElement : element) {
			String alldata=webElement.getText();
			System.out.println(alldata);
		}
		
		//Assert.assertFalse(product_removed);
		manager.test.log(Status.INFO, "Remove product from cart button working fine");	
	}
	
	@Test(priority = 8)
	public void verify_checkbox() {
		ExtentManager manager=new ExtentManager();
		Checkout_Page checkout=new Checkout_Page(driver);
		checkout.click_check_box.click();
		Boolean checkbox_verify=checkout.click_check_box.isDisplayed();
		Assert.assertTrue(checkbox_verify);
		manager.test.log(Status.INFO, "Checkbox working fine");	
	}
//	@Test(priority = 9)
//	public void veridy_db() throws Exception {
//		ExtentManager manager=new ExtentManager();
////		DB_Connect connect=new DB_Connect();
////	    String sql="SELECT * FROM `help_keyword` where help_keyword_id='17'";
////		HashMap<String, String> getdata=connect.getSqlResultInMap(sql);
////		String db_verify_delete=getdata.get("help_keyword_id");
////		Assert.assertEquals(db_verify_delete, "1"); 
////		Assert.assertNull(db_verify_delete);
////		manager.test.log(Status.INFO, "Delete function working fine");	
//		String sqlcount="SELECT COUNT(*) FROM `help_keyword`";
//		Utilities util=new Utilities(driver);
//		String db_count=util.Db_table_count(sqlcount);
//		Assert.assertEquals(db_count, "464");
//		}
}


