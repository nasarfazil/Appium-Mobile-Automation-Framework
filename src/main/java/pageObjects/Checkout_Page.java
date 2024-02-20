package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Checkout_Page {
	
	public Checkout_Page(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Air Jordan 4 Retro']")
	public WebElement add_to_cart;
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_back")
	public WebElement back_checkout;
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	public WebElement remove_product;
	@AndroidFindBy(id="com.androidsample.generalstore:id/rvCartProductList")
	public List<WebElement> verify_remove_product;
	@AndroidFindBy(className = "android.widget.CheckBox")
	public WebElement click_check_box;
}


