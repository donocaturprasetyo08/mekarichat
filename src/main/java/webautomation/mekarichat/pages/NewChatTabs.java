package webautomation.mekarichat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import webautomation.mekarichat.navigation.BasePage;
import webautomation.mekarichat.utils.DataUtils;
import webautomation.mekarichat.utils.ShareUtils;

public class NewChatTabs extends BasePage {
	
	By add = By.xpath("//img[@id='left-nav-new-button']");
	By newChat = By.xpath("//a[normalize-space()='New chat']");
	By clickTo = By.xpath("//div[@class='v-select vs--searchable']");
	By inputTo = By.xpath("//input[@placeholder='Type a contact name']");
	By verifySelect = By.xpath("//span[@class='mr-1']");
	By sendMessage = By.xpath("//textarea[@placeholder='Type a message...']");
	By verifyMessage = By.xpath("//span[normalize-space()='"+DataUtils.sendMessage+"']");
	By clickTextArea = By.xpath("//div[@class='d-flex flex-fill justify-content-center align-items-center']");

	public NewChatTabs(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	
	@Step("# user membuka add tabs new chat")
	public void tabsNewChat() {
		clickAndWaitByXpath(add);
		clickAndWaitByJavaScript(newChat);
		ShareUtils.hardWait(2);
	}
	
	@Step("# user melakukan add to contact dengan nama: {1}")
	public void selectTo(String text) {
		clickAndWaitByXpath(clickTo);
		ShareUtils.hardWait(2);
		searchText(inputTo, text);
		ShareUtils.hardWait(2);
	}
	
	@Step("# verify select to")
	public boolean verifySelect() {
		return displayElement(verifySelect);
	}
	
	@Step("# user send message")
	public void sendMessage(String text) {
		clickAndWaitByXpath(clickTextArea);
		ShareUtils.hardWait(2);
		searchText(sendMessage, text);
	}
	
	@Step("# verify send message")
	public boolean verifyMessage() {
		return displayElement(verifyMessage);
	}

}
