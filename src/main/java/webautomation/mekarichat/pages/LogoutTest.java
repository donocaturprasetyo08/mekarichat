package webautomation.mekarichat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import webautomation.mekarichat.navigation.BasePage;
import webautomation.mekarichat.utils.ShareUtils;

public class LogoutTest extends BasePage{
	
	By tabMenu = By.xpath("//span[@class='mr-2 ml-2 text-capitalize cursor-pointer']");
	By signOut = By.xpath("//div[@id='top-nav-signout']");
	
	By textH2 = By.xpath("//h2[normalize-space()='Sign in']");

	public LogoutTest(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	
	public void logOut() {
		clickAndWaitByXpath(tabMenu);
		ShareUtils.hardWait(5);
		clickAndWaitByXpath(signOut);
	}
	
	public String getLogout() {
		return getText(textH2);
	}

}
