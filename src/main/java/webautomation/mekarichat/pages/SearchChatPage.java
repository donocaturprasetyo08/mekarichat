package webautomation.mekarichat.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import webautomation.mekarichat.navigation.BasePage;
import webautomation.mekarichat.utils.ShareUtils;

public class SearchChatPage extends BasePage {
	
	By buttonSearch = By.xpath("//div[@id='left-nav-universal-search']");
	By inputSearching = By.xpath("//input[@id='inputSearchChat']");
	
	By buttonFilterFrom = By.xpath("//div[contains(@class,'mb-2 padding-horizontal-small')]//div[@class='v-select vs--single vs--searchable']");
	By filterSelect = By.xpath("//input[@class='vs__search']");
	
	By dateChat = By.xpath("//span[@class='text-truncate']");
	By nameTitle = By.xpath("//span[@class='text-capitalize font-weight-bold']");
	By isiPesan = By.xpath("//span[@class='bg-info']");
	
	By buttonFilterPostIn = By.xpath("//input[@placeholder='All Chats']");
	By titleTabs = By.xpath("//span[normalize-space()='Search Chat']");

	public SearchChatPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	
	public void tabsSearch() {
		clickAndWaitByXpath(buttonSearch);
	}
	
	@Step("# verify halaman tabs search")
	public String getTitleTab() {
		return getText(titleTabs);
	}
	
	@Step("# user melakukan pencarian dengan kata: {0} dan filter form : {1}")
	public void searchChatFilterFrom(String text, String select) {
		setText(inputSearching, text);
		ShareUtils.hardWait(5);
		clickAndWaitByXpath(buttonFilterFrom);
		ShareUtils.hardWait(2);
		searchText(filterSelect, select);
		ShareUtils.hardWait(5);
	}

	@Step("# user melakukan pencarian dengan kata: {0} dan filter post in : {1}")
	public void searchChatFilterPostIn(String text, String select) {
		setText(inputSearching, text);
		ShareUtils.hardWait(5);
		clickAndWaitByXpath(buttonFilterPostIn);
		ShareUtils.hardWait(2);
		searchText(buttonFilterPostIn, select);
		ShareUtils.hardWait(5);
	}
	
	@Step("# user melakukan pencarian dengan kata: {0}, filter post in : {1} dan filter from : {2}")
	public void searchChatFilterFromAndPostIn(String text, String selectPostIn, String selectFrom) {
		setText(inputSearching, text);
		ShareUtils.hardWait(5);
		clickAndWaitByXpath(buttonFilterPostIn);
		ShareUtils.hardWait(2);
		searchText(buttonFilterPostIn, selectPostIn);
		ShareUtils.hardWait(5);
		clickAndWaitByXpath(buttonFilterFrom);
		ShareUtils.hardWait(2);
		searchText(filterSelect, selectFrom);
		ShareUtils.hardWait(5);
	}
	
	@Step("# user melakukan pencarian dengan kata: {0}")
	public void searchChatNoFilter(String text) {
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
