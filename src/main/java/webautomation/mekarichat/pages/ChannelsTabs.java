package webautomation.mekarichat.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import webautomation.mekarichat.navigation.BasePage;
import webautomation.mekarichat.utils.DataUtils;
import webautomation.mekarichat.utils.ShareUtils;

public class ChannelsTabs extends BasePage {
	
	By tabChatList = By.xpath("//div[@id='left-nav-chat-list']");
	By tabChannel = By.xpath("//div[@id='left-nav-channel-list']");
	By titleTabs = By.xpath("//span[normalize-space()='Channels']");
	
	By availableChannel = By.xpath("//a[normalize-space()='Available Channels']");
	By join = By.xpath("//span[@class='col-2 text-link']");
	
	By yourChannel = By.xpath("//a[normalize-space()='Your Channels']");
	By chevron = By.xpath("//span[@class='ic ic-small ic-chevron-right']");
	
	By inputSearch = By.xpath("//input[@placeholder='Search channels...']");
	By listChannel = By.xpath("//div[@class='custom-padding-top']");
	
	By generalChannel = By.xpath("//span[normalize-space()='Halo Jumat']");
	By buttonJoin = By.xpath("//button[normalize-space()='Join channel']");
	By titleChannel = By.xpath("//div[normalize-space()='Halo Jumat']");
	
	By buttonEmoji = By.xpath("//img[@class='emoji cursor-pointer']");
	By emoji = By.xpath("//button[@title='"+DataUtils.emoji+"']");
	
	By img = By.xpath("//img[@class='c-attachment-preview__file c-attachment-preview__file--image rounded-top rounded-bottom']");
	By uploadPicture = By.xpath("//input[@id='chat-room-attach']");
	By send = By.xpath("//div[@id='chat-room-attach-send']");
	By displayImg = By.xpath("//img[@class='c-attachment-preview__content p-5']");
	By video = By.xpath("//video[@class='c-attachment-preview__content']");
	By srcVideo = By.xpath("//video[@class='c-attachment-preview__file c-attachment-preview__file--video rounded-bottom']");
	By doc = By.xpath("//img[@class='c-attachment-preview__content p-5 c-attachment-preview__content--document bg-muted']");

	By buttonDot = By.xpath("//span[@class='ic ic-small ic-kebab']");
	By channelInfo = By.xpath("//a[normalize-space()='Channel info']");
	By searchChat = By.xpath("//a[normalize-space()='Search chat']");
	By buttonLeave = By.xpath("//span[@class='text-danger font-weight-bold']");
	By buttonConfirmLeave = By.xpath("//button[@id='confirmButtonModal']");
	By inputSearchChat = By.xpath("//input[@id='inputSearchChat']");
	By keyword = By.xpath("//span[@class='bg-info']");
	By message = By.xpath("//span[@class='text-slate']");
	
	By testChannel = By.xpath("//span[normalize-space()='test']");
	By inputText = By.xpath("//div[@id='customINputMessageForChannel']");
	By verifyText = By.xpath("//span[normalize-space()='"+DataUtils.sendMessage+"']");
	
	By titleChannelSearch = By.xpath("//div[@class='flex-row d-flex align-items-center justify-content-center cursor-pointer margin-vertical-small channel-list-your-channel-test']//span[@class='text-truncate']");
	
	public ChannelsTabs(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	public void tabsChatList() {
		clickAndWaitByXpath(tabChatList);
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
	@Step("# verify channel at your channel tabs")
	public List<WebElement> listSearchChannelAvailable() {
		return getList(titleChannelSearch);
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
		ShareUtils.hardWait(2);
		clickAndWaitByJavaScript(buttonJoin);
	}
	
	@Step("# verify join channel berhasil")
	public boolean verifyJoin() {
		return displayElement(titleChannel);
	}
	
	@Step("# user klik channel yang berhasil di join sebelumnya")
	public void clickChannel() {
		clickAndWaitByJavaScript(generalChannel);
	}
	public void scrollChannel() {
		scrollUntilElement(generalChannel);
	}
	public void leaveGroup() {
		clickAndWaitByXpath(buttonDot);
		clickAndWaitByJavaScript(channelInfo);
		ShareUtils.hardWait(2);
		clickAndWaitByJavaScript(buttonLeave);
		ShareUtils.hardWait(2);
		clickAndWaitByJavaScript(buttonConfirmLeave);
	}
	
	@Step("# user membuka channel chat room")
	public void chatRoomChannel() {
		clickAndWaitByXpath(testChannel);
	}
	
	@Step("# user send text : {0} at chat room channel")
	public void sendText(String text) {
		searchText(inputText, text);
	}
	
	@Step("# verify send message")
	public boolean verifyMessage() {
		return displayElement(verifyText);
	}
	@Step("# user input text")
	public void inputText(String text) {
		setText(inputText, text);
	}
	@Step("# user input emoji")
	public void inputEmoji() {
		clickAndWaitByXpath(buttonEmoji);
		ShareUtils.hardWait(2);
		clickAndWaitByJavaScript(emoji);
	}
	@Step("# user send text and emoji")
	public void send() {
		clickAndWaitByJavaScript(inputText);
		sendText(inputText);
	}	
	@Step("# user upload picture")
	public void upload(String location) {
		uploadPicture(uploadPicture, location);
		ShareUtils.hardWait(3);
	}
	@Step("# verify preview picture can display")
	public boolean preview() {
		return displayElement(displayImg);
	}
	@Step("# pengirim send picture")
	public void sendFile() {
		clickAndWaitByXpath(send);
	}
	@Step("# verify url profile picture sended")
	public boolean verifyPictureUploaded(String value, String contains) {
		return getAttributeVerify(img, value, contains);
	}
	@Step("# pengirim play video")
	public void playVideoPengirim() {
		playVideo(video);
	}	
	@Step("# verify status playing video pengirim di preview")
	public boolean statusVideoPengirim() {
		return verifyStatusVideo(video);
	}
	@Step("# verify url video sended")
	public boolean verifyVideoSended(String value, String contains) {
		return getAttributeVerify(srcVideo, value, contains);
	}
	@Step("# verify preview picture can display")
	public boolean previewDoc() {
		return displayElement(doc);
	}
	public void searchChatOnGroup() {
		clickAndWaitByXpath(buttonDot);
		clickAndWaitByJavaScript(searchChat);
		ShareUtils.hardWait(2);
	}
	@Step("# user melakukan pencarian dengan kata : {0}")
	public void searchChatChannel(String text) {
		searchText(inputSearchChat, text);
	}
	@Step("# notifikasi not found")
	public String getMessage () {
		return getText(message);
	}
	@Step("# verify result search")
	public List<WebElement> getList(){
		return getList(keyword);
	}
}
