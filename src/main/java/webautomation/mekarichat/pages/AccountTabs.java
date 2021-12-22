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
	
	//By changePicture = By.xpath("//div[@class='edit-avatar']//input[@id='changeAvatar']");
	By uploadPicture = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div[1]/div/input");

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
		return findElement(img);
	}
	
	@Step("# verify nama display")
	public boolean findElementNama() {
		ShareUtils.hardWait(2);
		return findElement(nama);
	}
	
	@Step("# verify job display")
	public boolean findElementJobs() {
		ShareUtils.hardWait(2);
		return findElement(jobs);
	}
	
	@Step("# user change profile picture")
	public void changePicture(String location) {
		//clickAndWaitByXpath(changePicture);
		changePicture(uploadPicture, location);
		ShareUtils.hardWait(2);
	}
	
	

}
