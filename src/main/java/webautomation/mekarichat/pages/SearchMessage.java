package webautomation.mekarichat.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import webautomation.mekarichat.navigation.BasePage;
import webautomation.mekarichat.utils.ShareUtils;

public class SearchMessage extends BasePage {
	
	By inputSearch = By.xpath("//input[@placeholder='Search or start new chat']");
	By titleSearchRecent = By.xpath("//span[@class='text-truncate']");
	By titleSearchContact = By.xpath("//span[@class='break-word']");	
	By jobSearch = By.xpath("//span[@class='text-slate text-truncate job-position job-position-contact']");
	
	By buttonSearch = By.xpath("//div[@id='left-nav-universal-search']");
	By inputSearching = By.xpath("//input[@id='inputSearchChat']");
	
	By buttonFilterFrom = By.xpath("//div[contains(@class,'mb-2 padding-horizontal-small')]//div[@class='v-select vs--single vs--searchable']");
	By filterSelect = By.xpath("//input[@class='vs__search']");
	
	By dateChat = By.xpath("//span[@class='text-truncate']");
	By nameTitle = By.xpath("//span[@class='text-capitalize font-weight-bold']");
	By isiPesan = By.xpath("//span[@class='bg-info']");
	
	By buttonFilterPostIn = By.xpath("//input[@placeholder='All Chats']");
	
	
	public SearchMessage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	
	public void searchText(String text) {
		searchText(inputSearch, text);
	}
	
	public List<WebElement> listSearchRecent() {
		return getList(titleSearchRecent);
	}
	
	public List<WebElement> listSearchContact() {
		return getList(titleSearchContact);
	}
	
	public List<WebElement> jobSearch() {
		return getList(jobSearch);
	}
	
	public void searchChatFilterFrom(String text, String select) {
		clickAndWaitByXpath(buttonSearch);
		setText(inputSearching, text);
		ShareUtils.hardWait(5);
		clickAndWaitByXpath(buttonFilterFrom);
		searchText(filterSelect, select);
		ShareUtils.hardWait(5);
	}
	
	public void searchChatFilterPostIn(String text, String select) {
		clickAndWaitByXpath(buttonSearch);
		setText(inputSearching, text);
		ShareUtils.hardWait(5);
		clickAndWaitByXpath(buttonFilterPostIn);
		searchText(buttonFilterPostIn, select);
		ShareUtils.hardWait(5);
	}
	
	public void searchChatFilterFromAndPostIn(String text, String selectPostIn, String selectFrom) {
		clickAndWaitByXpath(buttonSearch);
		setText(inputSearching, text);
		ShareUtils.hardWait(5);
		clickAndWaitByXpath(buttonFilterPostIn);
		searchText(buttonFilterPostIn, selectPostIn);
		ShareUtils.hardWait(5);
		clickAndWaitByXpath(buttonFilterFrom);
		searchText(filterSelect, selectFrom);
		ShareUtils.hardWait(5);
	}
	
	public void searchChatNoFilter(String text) {
		clickAndWaitByXpath(buttonSearch);
		setText(inputSearching, text);
		ShareUtils.hardWait(5);
	}
	
	public List<WebElement> listSearchChat() {
		return getList(isiPesan);
	}
	
	public List<WebElement> listNameSearchChat() {
		return getList(nameTitle);
	}
	
	public List<WebElement> listDateSearchChat() {
		return getList(dateChat);
	}
}
