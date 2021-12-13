package webautomation.mekarichat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import webautomation.mekarichat.navigation.BasePage;
import webautomation.mekarichat.utils.ShareUtils;

public class ChatList extends BasePage {
	
	By pinImage = By.xpath("//span[@class='mr-1']//*[name()='svg']");
	By dropdownChat = By.xpath("//div[@id='listConversation59409969']//span[@class='ic ic-small ic-kebab']");
	By dropdownChat1 = By.xpath("//div[@id='listConversation59741797']//span[@class='ic ic-small ic-kebab']");
	By pinChat = By.xpath("//a[normalize-space()='Pin Chat']");
	By unpinChat = By.xpath("//a[normalize-space()='Unpin Chat']");
	By removeChat = By.xpath("//a[normalize-space()='Remove From Chats']");

	By chatTab = By.xpath("//div[@id='listConversation59741797']");
	
	public ChatList(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	
	public void pinChat() {
		clickAndWaitByJavaScript(dropdownChat);
		ShareUtils.hardWait(3);
		clickAndWaitByJavaScript(pinChat);
	}
	public void unpinChat() {
		clickAndWaitByJavaScript(dropdownChat);
		ShareUtils.hardWait(3);
		clickAndWaitByJavaScript(unpinChat);
	}
	
	public boolean findPinImage() {
		return findElement(pinImage);
	}
	
	public void chatTab() {
		clickAndWaitByXpath(chatTab);
		ShareUtils.hardWait(5);
	}

}
