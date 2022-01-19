package webautomation.mekarichat.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import webautomation.mekarichat.BaseWebDriver;
import webautomation.mekarichat.TestAllureListener;
import webautomation.mekarichat.pages.PrivateChatPage;
import webautomation.mekarichat.utils.DataUtils;
import webautomation.mekarichat.utils.ShareUtils;
import org.openqa.selenium.support.Color;

@Listeners({TestAllureListener.class})
@Epic("Private Chat")
public class PrivateChat extends BaseWebDriver {
	
	PrivateChatPage privateChat = new PrivateChatPage(driver, explicitWait);
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan dapat mengirim pesan text")
	@Feature("Test Case ID : MC-04-01")
	@Story("User mengirim pesan text")
	@Test
	public void userSendMessage() {
		privateChat.tabChatList();
		ShareUtils.hardWait(2);
		privateChat.chatRoom();
		ShareUtils.hardWait(2);
		
		String text = DataUtils.sendMessage;
		privateChat.sendMessage(text);
		
		ShareUtils.hardWait(3);
		boolean verifyMessage = privateChat.verifyMessage();
		Assert.assertTrue(verifyMessage);
		
		ShareUtils.hardWait(2);
		privateChat.screenShootAfterTest();
	}
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan dapat mengirim pesan text dan emoji")
	@Feature("Test Case ID : MC-04-02")
	@Story("User mengirim pesan text dan emoji")
	@Test
	public void userSendMessageTextAndEmoji() {
		privateChat.tabChatList();
		ShareUtils.hardWait(2);
		
		privateChat.chatRoom();
		ShareUtils.hardWait(2);
		
		String text = DataUtils.sendMessage;
		privateChat.inputMessageText(text);
		
		ShareUtils.hardWait(2);
		privateChat.inputEmoji();
		
		ShareUtils.hardWait(2);
		privateChat.sendText();
		
		ShareUtils.hardWait(2);
		Assert.assertTrue(privateChat.verifyMessageEmoji());
		
		ShareUtils.hardWait(2);
		privateChat.screenShootAfterTest();
	}
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan dapat mengirim pesan gambar")
	@Feature("Test Case ID : MC-04-03")
	@Story("User mengirim pesan gambar")
	@Test
	public void userSendImage() {
		privateChat.tabChatList();
		ShareUtils.hardWait(2);
		privateChat.chatRoom();
		ShareUtils.hardWait(5);
		
		String location = DataUtils.fotoProfile;
		privateChat.upload(location);
		
		ShareUtils.hardWait(2);
		boolean verifyImg = privateChat.preview();
		Assert.assertTrue(verifyImg);
		
		privateChat.send();
		
		ShareUtils.hardWait(3);
		String value = "src";
		String contains = "testUpload.png";
		boolean uploaded = privateChat.verifyPictureUploaded(value, contains);
		Assert.assertTrue(uploaded);
		
		ShareUtils.hardWait(2);
		privateChat.screenShootAfterTest();
	}
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("1. Pengirim dapat memilih video \n"
			+ "2. Pengirim dapat memutar video di preview\n"
			+ "3. Video yang dikirimkan dapat diputar di sisi penerima")
	@Feature("Test Case ID : MC-04-04")
	@Story("User mengirim pesan video")
	@Test
	public void userSendVideo() {	
		privateChat.tabChatList();
		ShareUtils.hardWait(2);
		privateChat.chatRoom();
		ShareUtils.hardWait(5);
		
		String location = DataUtils.locationVideo;
		privateChat.upload(location);
		
		ShareUtils.hardWait(2);
		privateChat.playVideoPengirim();
		ShareUtils.hardWait(2);
		
		boolean verifyStatusVideo = privateChat.statusVideoPengirim();
		Assert.assertFalse(verifyStatusVideo);
		
		privateChat.send();
		
		ShareUtils.hardWait(3);
		String value = "src";
		String contains = "mp4-1mb.mp4";
		boolean sended = privateChat.verifyVideoSended(value, contains);
		Assert.assertTrue(sended);
		
		ShareUtils.hardWait(2);
		privateChat.playVideoPenerima();
		ShareUtils.hardWait(2);
		
		boolean verifyStatusVideoPenerima = privateChat.statusVideoPenerima();
		Assert.assertFalse(verifyStatusVideoPenerima);
		
		ShareUtils.hardWait(2);
		privateChat.screenShootAfterTest();
	}
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User dapat mengirim dokumen/file (untuk saat ini tidak ada batasan ekstensi)")
	@Feature("Test Case ID : MC-04-05")
	@Story("User mengirim pesan dokumen(ex:.ppt, .docx, .xlsx, etc)")
	@Test
	public void userSendDoc() {	
		privateChat.tabChatList();
		ShareUtils.hardWait(2);
		privateChat.chatRoom();
		ShareUtils.hardWait(5);
		
		List<String> doc = DataUtils.fileDoc;
		for(int i = 0; i<doc.size();i++) {
			privateChat.upload(doc.get(i));
			ShareUtils.hardWait(2);
			boolean verifyDoc = privateChat.previewDoc();
			try {
				Assert.assertTrue(verifyDoc);
			}catch (Exception e) {
				System.out.println("Can not preview");
			}
			privateChat.send();
			ShareUtils.hardWait(5);
		}
		
		ShareUtils.hardWait(2);
		privateChat.screenShootAfterTest();
	}
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("1. User akan dapat mencari pesan yang diinginkan sesuai keyword \n"
			+ "2. Result akan tampil dengan highlight kuning pada keyword")
	@Feature("Test Case ID : MC-04-11")
	@Story("User melakukan pencarian pesan didalam chat room")
	@Test
	public void userSearchMessageOnChat() {  	
		privateChat.tabChatList();
		ShareUtils.hardWait(2);
		
		privateChat.chatRoom();
		ShareUtils.hardWait(2);
		
		privateChat.searchChat();
		ShareUtils.hardWait(2);
		
		String text = "feedback";
		privateChat.inputSearch(text);
		ShareUtils.hardWait(2);
		
		List<WebElement> listChat;
		try {
			listChat = privateChat.getList();
			System.out.println(listChat.size());
			for(int i = 0; i<listChat.size();i++) {
				String chat = listChat.get(i).getText();
				String value = "background-color";
				String color = listChat.get(i).getCssValue(value);
				String actualColor = Color.fromString(color).asHex();
				String expectedColor = "#ffeb99";
				if ((chat.toLowerCase().contains(text.toLowerCase()))){
					Assert.assertTrue(true, text);
					Assert.assertEquals(actualColor, expectedColor);
				}
			}
		} catch (Exception e) {
			System.out.println(privateChat.getMessage());
		}
		
		ShareUtils.hardWait(2);
		privateChat.screenShootAfterTest();
	}
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User melihat status last seen pada kontak")
	@Feature("Test Case ID : MC-04-12")
	@Story("User melihat status last seen pada kontak")
	@Test
	public void userStatusLastSeen() {
		privateChat.tabChatList();
		ShareUtils.hardWait(2);
		
		privateChat.chatRoom();
		ShareUtils.hardWait(2);
		
		boolean lastSeen = privateChat.lastSeen();
		Assert.assertTrue(lastSeen);
		
		ShareUtils.hardWait(2);
		privateChat.screenShootAfterTest();
	}
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan dapat melihat profil kontak: \n"
			+ "1. Foto Profil Kontak (dapat dilihat dalam ukuran penuh)\n"
			+ "2. Nama kontak \n"
			+ "3. Email\n"
			+ "4. Phone Number\n"
			+ "5. Job Position\n"
			+ "6. Organization\n"
			+ "7. Branch\n"
			+ "8. Media List")
	@Feature("Test Case ID : MC-04-13")
	@Story("User melihat profil kontak ")
	@Test
	public void userViewProfileContact() {	
		privateChat.tabChatList();
		ShareUtils.hardWait(2);
		
		privateChat.chatRoom();
		ShareUtils.hardWait(2);
		
		privateChat.viewProfile();
		ShareUtils.hardWait(2);
		
		boolean nama = privateChat.nama();
		Assert.assertTrue(nama);
		boolean emails = privateChat.email();
		Assert.assertTrue(emails);
		boolean phone = privateChat.phone();
		Assert.assertTrue(phone);
		boolean job = privateChat.job();
		Assert.assertTrue(job);
		boolean squad = privateChat.squad();
		Assert.assertTrue(squad);
		boolean branch = privateChat.branch();
		Assert.assertTrue(branch);
		
		List<WebElement> listChat;
		try {
			listChat = privateChat.mediaList();
			for(int i = 0; i<listChat.size();i++) {
				boolean media = listChat.get(i).isDisplayed();
				Assert.assertTrue(media);			
			}
		} catch (Exception e) {
			System.out.println("Media list is not found");
		}
		
		ShareUtils.hardWait(2);
		privateChat.screenShootAfterTest();
		
		privateChat.profileImg();
		ShareUtils.hardWait(2);
		boolean imgProfie = privateChat.imgLoaded();
		Assert.assertTrue(imgProfie);
		
	}
}
