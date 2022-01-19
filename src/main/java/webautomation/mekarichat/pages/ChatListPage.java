package webautomation.mekarichat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import webautomation.mekarichat.navigation.BasePage;
import webautomation.mekarichat.utils.ShareUtils;

public class ChatListPage extends BasePage {
	
	By pinImage = By.xpath("//span[@class='mr-1']//*[name()='svg']");
	By dropdownChat = By.xpath("//div[@id='listConversation59409969']//span[@class='ic ic-small ic-kebab']");
	By dropdownChat1 = By.xpath("//div[@id='listConversation59741797']//span[@class='ic ic-small ic-kebab']");
	By pinChat = By.xpath("//a[normalize-space()='Pin Chat']");
	By unpinChat = By.xpath("//a[normalize-space()='Unpin Chat']");
	By removeChat = By.xpath("//a[normalize-space()='Remove From Chats']");

	By statusChat = By.xpath("//div[@id='listConversation59741797']//div[@class='status-circle']");
	By titleChat = By.xpath("//span[normalize-space()='Chats']");
	By tabChatList = By.xpath("//div[@id='left-nav-chat-list']");
	
	public ChatListPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	public void tabChatList() {
		clickAndWaitByXpath(tabChatList);
	}
	
	@Step("# user melakukan pin chat")
	public void pinChat() {
		clickAndWaitByJavaScript(dropdownChat);
		ShareUtils.hardWait(3);
		clickAndWaitByJavaScript(pinChat);
	}
	
	@Step("# user melakukan unpin chat")
	public void unpinChat() {
		clickAndWaitByJavaScript(dropdownChat);
		ShareUtils.hardWait(3);
		clickAndWaitByJavaScript(unpinChat);
	}
	
	@Step("# Verify pin chat")
	public boolean findPinImage() {
		return displayElement(pinImage);
	}
	
	@Step("# verify status online/offline : {0}")
	public String statusChat(String value) {
		return getAttribute(statusChat, value);
	}
	
	@Step("# verify tab chat list")
	public String titleTabChat() {
		return getText(titleChat);
	}

}
