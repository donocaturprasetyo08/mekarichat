package webautomation.mekarichat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import webautomation.mekarichat.navigation.BasePage;

public class ChatRoom extends BasePage {
	By statusChat = By.xpath("//div[@class='d-flex align-items-center']//div[@class='status-circle']");
	By readStatus = By.xpath("//div[starts-with(@id,'container-')]//div[@class='c-bubble__section c-bubble__section--text']//p[@class='overflow-break c-caption']//div//img[@title='Message is sent']");

	public ChatRoom(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	
	public String statusChat(String value) {
		return getAttribute(statusChat, value);
	}
	
	public String readStatus(String value) {
		return getAttribute(readStatus, value);
	}
	

}
