package webautomation.mekarichat.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import webautomation.mekarichat.navigation.BasePage;

public class SearchMessagePage extends BasePage {
	
	By inputSearch = By.xpath("//input[@placeholder='Search or start new chat']");
	By titleSearchRecent = By.xpath("//span[@class='text-truncate']");
	By titleSearchContact = By.xpath("//span[@class='break-word']");	
	By jobSearch = By.xpath("//span[@class='text-slate text-truncate job-position job-position-contact']");
		
	public SearchMessagePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	
	@Step("5# user melakukan pencarian berdasarkan nama/jobs dengan kata: {0}")
	public void searchText(String text) {
		searchText(inputSearch, text);
	}
	
	@Step("6# Verify pada recents chat room")
	public List<WebElement> listSearchRecent() {
		return getList(titleSearchRecent);
	}
	
	@Step("7# Verify pada contact chat room")
	public List<WebElement> listSearchContact() {
		return getList(titleSearchContact);
	}
	
	public List<WebElement> jobSearch() {
		return getList(jobSearch);
	}	
}
