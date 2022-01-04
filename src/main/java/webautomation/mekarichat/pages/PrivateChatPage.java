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

public class PrivateChatPage extends BasePage {
	
	By tabChatList = By.xpath("//div[@id='left-nav-chat-list']");
	By chatRoom = By.xpath("//span[@title='Deni Istika Handayani']");
	By textArea = By.xpath("//textarea[@placeholder='Type a message...']");
	
	By verifyMessage = By.xpath("//span[contains(text(),'"+DataUtils.sendMessage+"')]");
	By uploadPicture = By.xpath("//input[@id='chat-room-attach']");
	By send = By.xpath("//div[@id='chat-room-attach-send']");
	By displayImg = By.xpath("//img[@class='c-attachment-preview__content p-5']");
	By img = By.xpath("//img[@class='c-attachment-preview__file c-attachment-preview__file--image rounded-top rounded-bottom']");
	
	By video = By.xpath("//video[@class='c-attachment-preview__content']");
	By srcVideo = By.xpath("//video[@class='c-attachment-preview__file c-attachment-preview__file--video rounded-bottom']");
	
	By buttonMore = By.xpath("//div[@id='dropdownMenuData']");
	By searchChat = By.xpath("//a[normalize-space()='Search chat']");
	
	By inputSearch = By.xpath("//input[@id='inputSearchChat']");
	By keyword = By.xpath("//span[@class='bg-info']");
	
	By message = By.xpath("//span[contains(text(),'No result found for')]");
	By lastSeen = By.xpath("//span[@class='text-slate']");
	
	By viewProfile = By.xpath("//a[normalize-space()='View profile']");
	By imgProfile = By.xpath("//img[@class='rounded-circle img-pic']");
	By avatarLoaded = By.xpath("//img[@class='avatar-pic']");
	By nama = By.xpath("//span[@class='font-weight-bold text-center']");
	By email = By.xpath("//span[normalize-space()='deni.istika@qiscus.net']");
	By phone = By.xpath("//span[normalize-space()='083840150492']");
	By job = By.xpath("//span[normalize-space()='QA Engineer']");
	By squad = By.xpath("//span[normalize-space()='Integration']");
	By branch = By.xpath("//span[normalize-space()='Pusat']");
	By media = By.xpath("//img[@class='bg-cloud rounded mr-3']");
	
	public PrivateChatPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	
	public void tabChatList() {
		clickAndWaitByXpath(tabChatList);
	}
	
	@Step("# user open chat room")
	public void chatRoom() {
		clickAndWaitByXpath(chatRoom);
	}
	
	@Step("# user send message")
	public void sendMessage(String text) {
		searchText(textArea, text);
	}
	
	@Step("# verify send message")
	public boolean verifyMessage() {
		return findElement(verifyMessage);
	}
	
	@Step("# user upload picture")
	public void upload(String location) {
		uploadPicture(uploadPicture, location);
		ShareUtils.hardWait(3);
	}
	
	@Step("# verify preview picture can display")
	public boolean preview() {
		return findElement(displayImg);
	}
	
	@Step("# pengirim send picture")
	public void send() {
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
	
	@Step("# penerima play video")
	public void playVideoPenerima() {
		playVideo(srcVideo);
	}
	
	@Step("# verify status playing video penerima")
	public boolean statusVideoPenerima() {
		return verifyStatusVideo(srcVideo);
	}
	
	@Step("# user open search chat")
	public void searchChat() {
		clickAndWaitByXpath(buttonMore);
		clickAndWaitByJavaScript(searchChat);
	}
	
	@Step("# user input keyword {0} pada input search")
	public void inputSearch(String text) {
		searchText(inputSearch, text);
	}
	
	@Step("# verify result seearch")
	public List<WebElement> getList(){
		return getList(keyword);
	}
	
	@Step("# notifikasi not found")
	public String getMessage () {
		return getText(message);
	}
	
	@Step("# user can last seen")
	public boolean lastSeen() {
		return findElement(lastSeen);
	}
	
	@Step("# user open search chat")
	public void viewProfile() {
		clickAndWaitByXpath(buttonMore);
		clickAndWaitByJavaScript(viewProfile);
	}
	
	public void profileImg() {
		clickAndWaitByXpath(imgProfile);
	}
	
	@Step("# user can see profile kontak")
	public boolean imgLoaded() {
		return findImgLoaded(avatarLoaded);
	}
	
	@Step("# user can see nama kontak")
	public boolean nama() {
		return findElement(nama);
	}
	@Step("# user can see email kontak")
	public boolean email() {
		return findElement(email);
	}
	@Step("# user can see phone number kontak")
	public boolean phone() {
		return findElement(phone);
	}
	@Step("# user can see job position kontak")
	public boolean job() {
		return findElement(job);
	}
	@Step("# user can see organization kontak")
	public boolean squad() {
		return findElement(squad);
	}
	@Step("# user can see branch kontak")
	public boolean branch() {
		return findElement(branch);
	}
	@Step("# user can see media list")
	public List<WebElement> mediaList(){
		return getList(media);
	}
	

}
