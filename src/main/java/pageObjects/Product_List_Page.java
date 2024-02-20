package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Product_List_Page {
	public Product_List_Page(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Products']")
	public WebElement product_page;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	public WebElement Product_add;
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement click_cart;
}
