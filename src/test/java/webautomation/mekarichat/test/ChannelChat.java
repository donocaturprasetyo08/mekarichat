package webautomation.mekarichat.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
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
import webautomation.mekarichat.pages.ChannelsTabs;

import webautomation.mekarichat.utils.DataUtils;
import webautomation.mekarichat.utils.ShareUtils;

@Listeners({TestAllureListener.class})
@Epic("Channel Chat")
public class ChannelChat extends BaseWebDriver {
	
	ChannelsTabs channels = new ChannelsTabs(driver, explicitWait);
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan dapat mengirim pesan text ")
	@Feature("Test Case ID : MC-005-01")
	@Story("User mengirim pesan text")
	@Test
	public void sendMessageOnChannelChat() {
		channels.tabsChatList();
    	channels.tabsChannel();
    	String expectedResults2 = DataUtils.titleChannelTabs;
    	String actualResults2 = channels.titleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	ShareUtils.hardWait(5);
    	channels.tabsYourChannel();
    	String value1 = "class";
    	String contains1 = "active";
       	boolean yourTabs = channels.yourActive(value1, contains1);
 	    Assert.assertTrue(yourTabs);
    	    	
 	    ShareUtils.hardWait(2);
 	    channels.chatRoomChannel();
 	    
 	    ShareUtils.hardWait(2);
 	    String text = DataUtils.sendMessage;
 	    channels.sendText(text);
 	    
 	    ShareUtils.hardWait(3);
		boolean verifyMessage = channels.verifyMessage();
		Assert.assertTrue(verifyMessage);
	}
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("1. User akan dapat mengirim pesan text dan emoji\n"
			+ "2. Emoji akan dapat terbaca pada penerima pesan")
	@Feature("Test Case ID : MC-005-03")
	@Story("User mengirim pesan berupa emoji dan text")
	@Test
	public void sendEmojiOnChannelChat() {
		channels.tabsChatList();
    	channels.tabsChannel();
    	String expectedResults2 = DataUtils.titleChannelTabs;
    	String actualResults2 = channels.titleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	ShareUtils.hardWait(5);
    	channels.tabsYourChannel();
    	String value1 = "class";
    	String contains1 = "active";
       	boolean yourTabs = channels.yourActive(value1, contains1);
 	    Assert.assertTrue(yourTabs);
    	    	
 	    ShareUtils.hardWait(2);
 	    channels.chatRoomChannel();
 	    
 	    ShareUtils.hardWait(2);
 	    String text = DataUtils.sendMessage;
 	    channels.inputText(text);
 	    
 	    ShareUtils.hardWait(2);
 	    channels.inputEmoji();
 	    
 	    ShareUtils.hardWait(2);
	    channels.send();
	}
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("1. User dapat memilih gambar\n"
			+ "2. User dapat melihat preview gambar sebelum dikirimkan")
	@Feature("Test Case ID : MC-05-04")
	@Story("User mengirim pesan gambar")
	@Test
	public void userSendImage() {
		channels.tabsChatList();
		channels.tabsChannel();
    	String expectedResults2 = DataUtils.titleChannelTabs;
    	String actualResults2 = channels.titleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	ShareUtils.hardWait(5);
    	channels.tabsYourChannel();
    	String value1 = "class";
    	String contains1 = "active";
       	boolean yourTabs = channels.yourActive(value1, contains1);
 	    Assert.assertTrue(yourTabs);
 	    
 	    ShareUtils.hardWait(2);
	    channels.chatRoomChannel();
	    
	    ShareUtils.hardWait(2);
		String location = DataUtils.fotoProfile;
		channels.upload(location);
		
		ShareUtils.hardWait(2);
		boolean verifyImg = channels.preview();
		Assert.assertTrue(verifyImg);
		
		channels.sendFile();
		
		ShareUtils.hardWait(3);
		String value = "src";
		String contains = "testUpload.png";
		boolean uploaded = channels.verifyPictureUploaded(value, contains);
		Assert.assertTrue(uploaded);
	}
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("1. User dapat memilih video\n"
			+ "2. User dapat melihat preview video sebelum dikirimkan\n"
			+ "3. User memutar video di pop up preview\n"
			+ "4. Format video mp4 dan mov")
	@Feature("Test Case ID : MC-05-05")
	@Story("User mengirim pesan video")
	@Test
	public void userSendVideo() {
		channels.tabsChatList();
		channels.tabsChannel();
    	String expectedResults2 = DataUtils.titleChannelTabs;
    	String actualResults2 = channels.titleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	ShareUtils.hardWait(5);
    	channels.tabsYourChannel();
    	String value1 = "class";
    	String contains1 = "active";
       	boolean yourTabs = channels.yourActive(value1, contains1);
 	    Assert.assertTrue(yourTabs);
 	    
 	    ShareUtils.hardWait(2);
	    channels.chatRoomChannel();
	    
	    ShareUtils.hardWait(2);
	    List<String> vid = DataUtils.fileVideo;
	    for(int i = 0; i<vid.size();i++) {
			channels.upload(vid.get(i));
			ShareUtils.hardWait(2);
			channels.playVideoPengirim();
			ShareUtils.hardWait(2);
			
			boolean verifyStatusVideo = channels.statusVideoPengirim();
			
			try {
				Assert.assertFalse(verifyStatusVideo);
			}catch (Exception e) {
				System.out.println("Can not preview");
			}
			channels.sendFile();
			ShareUtils.hardWait(5);
			ShareUtils.hardWait(3);
			String value = "src";
			String contains = "mp4-1mb.mp4";
			boolean sended = channels.verifyVideoSended(value, contains);
			Assert.assertTrue(sended);
		}
	}
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User dapat mengirim dokumen/file")
	@Feature("Test Case ID : MC-05-06")
	@Story("User mengirim pesan dokumen(ex:.ppt, .docx, .xlsx, etc)")
	@Test
	public void userSendDoc() {
		channels.tabsChatList();
		channels.tabsChannel();
    	String expectedResults2 = DataUtils.titleChannelTabs;
    	String actualResults2 = channels.titleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	ShareUtils.hardWait(5);
    	channels.tabsYourChannel();
    	String value1 = "class";
    	String contains1 = "active";
       	boolean yourTabs = channels.yourActive(value1, contains1);
 	    Assert.assertTrue(yourTabs);
 	    
 	    ShareUtils.hardWait(2);
	    channels.chatRoomChannel();
	    
	    ShareUtils.hardWait(2);
	    List<String> doc = DataUtils.fileDoc;
		for(int i = 0; i<doc.size();i++) {
			channels.upload(doc.get(i));
			ShareUtils.hardWait(2);
			boolean verifyDoc = channels.previewDoc();
			try {
				Assert.assertTrue(verifyDoc);
			}catch (Exception e) {
				System.out.println("Can not preview");
			}
			channels.sendFile();
			ShareUtils.hardWait(5);
		}
	}
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("1. User akan dapat mencari pesan yang diinginkan sesuai keyword \n"
			+ "2. Result akan tampil dengan highlight kuning pada keyword")
	@Feature("Test Case ID : MC-05-12")
	@Story("User mencari pesan di dalam Channel Room")
	@Test
	public void userSearchChatOnChannel() {
		channels.tabsChatList();
		channels.tabsChannel();
    	String expectedResults2 = DataUtils.titleChannelTabs;
    	String actualResults2 = channels.titleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	ShareUtils.hardWait(5);
    	channels.tabsYourChannel();
    	String value1 = "class";
    	String contains1 = "active";
       	boolean yourTabs = channels.yourActive(value1, contains1);
 	    Assert.assertTrue(yourTabs);
 	    
 	    ShareUtils.hardWait(2);
	    channels.chatRoomChannel();
	    
	    ShareUtils.hardWait(2);
	   
	    channels.searchChatOnGroup();
		ShareUtils.hardWait(2);
		
		String text = "test";
		channels.searchChatChannel(text);
		ShareUtils.hardWait(2);
		
		List<WebElement> listChat;
		try {
			listChat = channels.getList();
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
			System.out.println(channels.getMessage());
		}
	}
}
