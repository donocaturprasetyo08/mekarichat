package webautomation.mekarichat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import webautomation.mekarichat.navigation.BasePage;
import webautomation.mekarichat.utils.ShareUtils;

public class LoginPage extends BasePage {
	
	By inputEmail = By.xpath("//input[@id='user_email']");
	By inputPassword = By.xpath("//input[@id='user_password']");
	By buttonSignIn = By.xpath("//input[@id='new-signin-button']");
	
	By notifMessage = By.xpath("//p[normalize-space()='Akun email atau password anda salah']");
	
	By showPassword = By.xpath("//i[@id='show-password']");
	
	public LoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}
	
	@Step("1# verifikasi halaman login mekari chat")
	public String getTitlePage() {
		return getTitle();
	}
		
	@Step("2# user input email: {0} dan password: {1}")
	public void inputEmailPassword(String email, String password) {
		ShareUtils.hardWait(2);
		setText(inputEmail, email);
		setText(inputPassword, password);
		clickAndWaitByXpath(buttonSignIn);
		ShareUtils.hardWait(10);
	}
	
	@Step("3# verifikasi login berhasil")
	public String getUrlPage() {
		return getUrl();
	}
	
	@Step("3# verifikasi login gagal")
	public boolean notifFailed() {
		return findElement(notifMessage);	
	}
	
	public String getNotif() {
		return getText(notifMessage);	
	}
	
	@Step("2# user input password{0}")
	public void setPassword(String password) {
		setText(inputPassword, password);
	}
	
	@Step("3# user click show password")
	public void clickShowPassword() {
		clickAndWaitByXpath(showPassword);
		ShareUtils.hardWait(5);
	}
	
	@Step("4# verify password showed")
	public boolean showPassword() {
		return passwordShowed(inputPassword);
	}
	
	@Step("3# verify password hidden")
	public boolean hiddenPassword() {
		return passwordHidden(inputPassword);
	}
	
}
