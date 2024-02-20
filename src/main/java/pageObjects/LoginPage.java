package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
public LoginPage(AndroidDriver<AndroidElement> driver) {
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}
@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
private WebElement AppLogo;
@AndroidFindBy(xpath="//android.widget.TextView[@text='Select the country where you want to shop']")
public WebElement Select_country_text;
@AndroidFindBy(className="android.widget.Spinner")
public WebElement select_country_dropdown;
@AndroidFindBy(xpath="//android.widget.TextView[@index='3']")
public WebElement select_country_dropdown_option;
@AndroidFindBy(xpath="//android.widget.TextView[@text='Your Name']")
public WebElement your_name_text;
@AndroidFindBy(id="android:id/text1")
public WebElement verify_dropdown_function;
@AndroidFindBy(className="android.widget.EditText")
public WebElement your_name_field;
@AndroidFindBy(xpath="//android.widget.TextView[@text='Gender']")
public WebElement gender_text;
@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
public WebElement gender_radio_button;
@AndroidFindBy(className = "android.widget.Button")
public WebElement Lets_Shop_button;
@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter name here']")
private WebElement enter_your_name;

public WebElement verify_correct_app() {
	System.out.println("Verifying app correct app launched or not");
	return AppLogo;
}
public WebElement verify_enter_name() {
	System.out.println("Verifying your name field");
	return enter_your_name;
}
}
