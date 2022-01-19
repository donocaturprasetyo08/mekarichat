package webautomation.mekarichat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import webautomation.mekarichat.navigation.BasePage;
import webautomation.mekarichat.utils.ShareUtils;

public class AccountTabs extends BasePage {
	
	By accountTabs = By.xpath("//div[@id='left-nav-account']");
	By titleAccountTabs = By.xpath("//span[normalize-space()='Account']");
	
	By img = By.xpath("//img[@alt='profile_pic']");
	By nama = By.xpath("//span[@class='font-weight-bold text-capitalize']");
	By jobs = By.xpath("//span[@class='text-center text-slate text-capitalize mt-1']");
	
	By uploadPicture = By.xpath("//input[@class='d-none']");

	public AccountTabs(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	
	@Step("# user klik account tabs")
	public void accountTabs() {
		clickAndWaitByXpath(accountTabs);
	}
	
	@Step("# verify halaman account tabs")
	public String titleAccountTabs() {
		return getText(titleAccountTabs);
	}
	
	@Step("# verify img display")
	public boolean findElementImg() {
		ShareUtils.hardWait(2);
		return displayElement(img);
	}
	
	@Step("# verify nama display")
	public boolean findElementNama() {
		ShareUtils.hardWait(2);
		return displayElement(nama);
	}
	
	@Step("# verify job display")
	public boolean findElementJobs() {
		ShareUtils.hardWait(2);
		return displayElement(jobs);
	}
	
	@Step("# user change profile picture")
	public void changePicture(String location) {
		//clickAndWaitByXpath(changePicture);
		uploadPicture(uploadPicture, location);
		ShareUtils.hardWait(2);
	}
	
	@Step("# verify url profile picture uploaded")
	public boolean verifyPictureUploaded(String value, String contains) {
		return getAttributeVerify(img, value, contains);
	}
	
	

}
