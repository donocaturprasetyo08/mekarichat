package webautomation.mekarichat.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import webautomation.mekarichat.navigation.BasePage;
import webautomation.mekarichat.utils.ShareUtils;

public class ChannelsTabs extends BasePage {
	
	By tabChannel = By.xpath("//div[@id='left-nav-channel-list']");
	By titleTabs = By.xpath("//span[normalize-space()='Channels']");
	
	By availableChannel = By.xpath("//a[normalize-space()='Available Channels']");
	By join = By.xpath("//span[@id='channel-list-available-General']");
	
	By yourChannel = By.xpath("//a[normalize-space()='Your Channels']");
	By chevron = By.xpath("//div[@class='flex-row d-flex align-items-center justify-content-center cursor-pointer margin-vertical-small channel-list-your-channel-Woro_Woro']//span[@class='ic ic-small ic-chevron-right']");
	
	By inputSearch = By.xpath("//input[@placeholder='Search channels...']");
	By listChannel = By.xpath("//div[@class='custom-padding-top']");
	
	By generalChannel = By.xpath("//span[normalize-space()='General']");
	By buttonJoin = By.xpath("//button[normalize-space()='Join channel']");
	By titleChannel = By.xpath("//div[normalize-space()='General']");
	
	//leave group
	By buttonDot = By.xpath("//span[@class='ic ic-small ic-kebab']");
	By channelInfo = By.xpath("//a[normalize-space()='Channel info']");
	By buttonLeave = By.xpath("//span[@class='text-danger font-weight-bold']");
	By buttonConfirmLeave = By.xpath("//button[@id='confirmButtonModal']");

	public ChannelsTabs(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	
	@Step("# user klik channel tabs")
	public void tabsChannel() {
		clickAndWaitByXpath(tabChannel);
	}
	
	@Step("# verify channel tabs")
	public String titleTab() {
		return getText(titleTabs);
	}
	
	@Step("# user klik available channel tabs")
	public void tabsAvailableChannel() {
		clickAndWaitByXpath(availableChannel);
	}
	
	@Step("# verify available channel tabs active")
	public boolean availableActive(String value, String contains) {
		return getAttributeVerify(availableChannel, value, contains);
	}
	
	@Step("# verify channel at available channel tabs")
	public List<WebElement> listChannelAvailable() {
		return getList(join);
	}
	
	@Step("# user klik your channel tabs")
	public void tabsYourChannel() {
		clickAndWaitByXpath(yourChannel);
	}
	
	@Step("# verify your channel tabs active")
	public boolean yourActive(String value, String contains) {
		return getAttributeVerify(yourChannel, value, contains);
	}
	
	@Step("# verify channel at your channel tabs")
	public List<WebElement> listYourChannel() {
		return getList(chevron);
	}
	
	@Step("# user melakukan pencarian dengan kata : {0}")
	public void searchChannel(String text) {
		searchText(inputSearch, text);
	}
	
	@Step("# user melakukan join channel")
	public void joinChannel() {
		clickAndWaitByXpath(generalChannel);
		clickAndWaitByJavaScript(buttonJoin);
	}
	
	@Step("# verify join channel berhasil")
	public boolean verifyJoin() {
		return findElement(titleChannel);
	}
	
	@Step("# user klik channel yang berhasil di join sebelumnya")
	public void clickChannel() {
		clickAndWaitByXpath(generalChannel);
	}
	
	public void leaveGroup() {
		clickAndWaitByXpath(buttonDot);
		clickAndWaitByJavaScript(channelInfo);
		ShareUtils.hardWait(2);
		clickAndWaitByJavaScript(buttonLeave);
		ShareUtils.hardWait(2);
		clickAndWaitByJavaScript(buttonConfirmLeave);
	}
}
