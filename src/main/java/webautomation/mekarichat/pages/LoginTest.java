package webautomation.mekarichat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import webautomation.mekarichat.navigation.BasePage;
import webautomation.mekarichat.utils.ShareUtils;

public class LoginTest extends BasePage {

	By inputEmail = By.xpath("//input[@id='user_email']");
	By inputPassword = By.xpath("//input[@id='user_password']");
	By buttonSignIn = By.xpath("//input[@id='new-signin-button']");
	
	By notifMessage = By.xpath("//p[normalize-space()='Akun email atau password anda salah']");
	
	By showPassword = By.xpath("//i[@id='show-password']");
	
	public LoginTest(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}
	
	@Step("# getting login page title")
	public String getTitle() {
		return driver.get().getTitle();
	}
		
	@Step("# login with username: {0} and password: {1}")
	public void testLogin(String email, String password) {
		ShareUtils.hardWait(5);
		setText(inputEmail, email);
		setText(inputPassword, password);
		clickAndWaitByXpath(buttonSignIn);
		ShareUtils.hardWait(10);
	}
	
	public String getNotif() {
		return getText(notifMessage);	
	}
	
	public void passwordHidden(String password) {
		setText(inputPassword, password);
	}
	
	public void showPassword(String password) {
		setText(inputPassword, password);
		clickAndWaitByXpath(showPassword);
		ShareUtils.hardWait(5);
	}
}
