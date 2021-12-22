package webautomation.mekarichat.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import webautomation.mekarichat.navigation.BasePage;

public class ContactPage extends BasePage{
	
	By contactMenu = By.xpath("//div[@id='left-nav-contact-list']");
	By name = By.xpath("//span[@class='break-word']");
	By jobs = By.xpath("//span[@class='text-slate text-truncate job-position job-position-contact']");
	By status = By.xpath("//div[@class='status-circle']");
	By img = By.xpath("//div[@class='pt-2 d-flex flex-column sidebar-left border-right-1-smoke']//div[@class='d-flex flex-column']//img");
	By titleContact = By.xpath("//span[normalize-space()='Contacts']");
	By inputSearch = By.xpath("//input[@placeholder='Search name/job position']");
	By getMessage = By.xpath("//span[@class='text-slate text-center mt-3']");
	
	By startChat = By.xpath("//div[@class='chatroom-empty__start']");
	By listContact = By.xpath("//div[@id='list-contacts']");

	public ContactPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	
	public void contactPage() {
		clickAndWaitByXpath(contactMenu);
	}
	
	@Step("# verify informasi nama kontak urut")
	public List<WebElement> listName() {
		return getList(name);
	}
	
	@Step("# verify informasi jobs position")
	public List<WebElement> listJobs() {
		return getList(jobs);
	}
	
	@Step("# verify informasi status online/offline")
	public List<WebElement> listStatus() {
		return getList(status);
	}
	
	@Step("# verify halaman tabs contacts")
	public String titleContact() {
		return getText(titleContact);
	}
	
	@Step("# verify informasi foto profile loaded")
	public List<WebElement> imgLoaded() {
		return getList(img);
	}
	
	@Step("# usert melakukan pencarian dengan kata : {0}")
	public void searchText(String text) {
		searchText(inputSearch, text);
	}
	
	public String getMessage() {
		return getText(getMessage);
	}
	
	public void listChat() {
		clickAndWaitByXpath(listContact);
	}
	
	@Step("# verify akses private chat room")
	public boolean getStartChat() {
		return findElement(startChat);
	}
	
	@Step("# verify informasi status online/offline")
	public List<WebElement> listStatusInfo() {
		return getList(status);
	}
	
}
