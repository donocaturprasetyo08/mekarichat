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
import webautomation.mekarichat.pages.ChannelsInfoPage;
import webautomation.mekarichat.pages.ChannelsTabs;

import webautomation.mekarichat.utils.TestData;
import webautomation.mekarichat.utils.TimesUtils;

@Listeners({TestAllureListener.class})
@Epic("Channel Chat on Channels Tabs")
public class ChannelChat extends BaseWebDriver {
	
	ChannelsTabs channels = new ChannelsTabs(driver, explicitWait);
	ChannelsInfoPage channelsInfo = new ChannelsInfoPage(driver, explicitWait);
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan dapat mengirim pesan text ")
	@Feature("Test Case ID : MC-005-01")
	@Story("User mengirim pesan text")
	@Test
	public void sendMessageOnChannelChat() {
		channels.tabsChatList();
    	channels.tabsChannel();
    	String expectedResults2 = TestData.titleChannelTabs;
    	String actualResults2 = channels.titleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	TimesUtils.hardWait(5);
    	channels.tabsYourChannel();
    	String value1 = "class";
    	String contains1 = "active";
       	boolean yourTabs = channels.yourActive(value1, contains1);
 	    Assert.assertTrue(yourTabs);
    	    	
 	    TimesUtils.hardWait(2);
 	    channels.chatRoomChannel();
 	    
 	    TimesUtils.hardWait(2);
 	    String text = TestData.sendMessage;
 	    channels.sendText(text);
 	    
 	    TimesUtils.hardWait(3);
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
    	String expectedResults2 = TestData.titleChannelTabs;
    	String actualResults2 = channels.titleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	TimesUtils.hardWait(5);
    	channels.tabsYourChannel();
    	String value1 = "class";
    	String contains1 = "active";
       	boolean yourTabs = channels.yourActive(value1, contains1);
 	    Assert.assertTrue(yourTabs);
    	    	
 	    TimesUtils.hardWait(2);
 	    channels.chatRoomChannel();
 	    
 	    TimesUtils.hardWait(2);
 	    String text = TestData.sendMessage;
 	    channels.inputText(text);
 	    
 	    TimesUtils.hardWait(2);
 	    channels.inputEmoji();
 	    
 	    TimesUtils.hardWait(2);
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
    	String expectedResults2 = TestData.titleChannelTabs;
    	String actualResults2 = channels.titleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	TimesUtils.hardWait(5);
    	channels.tabsYourChannel();
    	String value1 = "class";
    	String contains1 = "active";
       	boolean yourTabs = channels.yourActive(value1, contains1);
 	    Assert.assertTrue(yourTabs);
 	    
 	    TimesUtils.hardWait(2);
	    channels.chatRoomChannel();
	    
	    TimesUtils.hardWait(2);
		String location = TestData.fotoProfile;
		channels.upload(location);
		
		TimesUtils.hardWait(2);
		boolean verifyImg = channels.preview();
		Assert.assertTrue(verifyImg);
		
		channels.sendFile();
		
		TimesUtils.hardWait(3);
		String value = "src";
		String contains = "testUpload.png";
		boolean uploaded = channels.verifyPictureUploaded(value, contains);
		Assert.assertTrue(uploaded);
	}
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("1. User dapat memilih video\n"
			+ "2. User dapat melihat preview video sebelum dikirimkan\n"
			+ "3. User memutar video di pop up preview\n"
			+ "4. Format video mp4 dan mov\n"
			+ "5. Video yang dikirim masuk ke chat room")
	@Feature("Test Case ID : MC-05-05")
	@Story("User mengirim pesan video")
	@Test
	public void userSendVideo() {
		channels.tabsChatList();
		channels.tabsChannel();
    	String expectedResults2 = TestData.titleChannelTabs;
    	String actualResults2 = channels.titleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	TimesUtils.hardWait(5);
    	channels.tabsYourChannel();
    	String value1 = "class";
    	String contains1 = "active";
       	boolean yourTabs = channels.yourActive(value1, contains1);
 	    Assert.assertTrue(yourTabs);
 	    
 	    TimesUtils.hardWait(2);
	    channels.chatRoomChannel();
	    
	    TimesUtils.hardWait(2);
	    List<String> vid = TestData.fileVideo;
	    for(int i = 0; i<vid.size();i++) {
			channels.upload(vid.get(i));
			TimesUtils.hardWait(2);
			channels.playVideoPengirim();
			TimesUtils.hardWait(2);
			
			boolean verifyStatusVideo = channels.statusVideoPengirim();
			
			try {
				Assert.assertFalse(verifyStatusVideo);
			}catch (Exception e) {
				System.out.println("Can not preview");
			}
			channels.sendFile();
			TimesUtils.hardWait(5);
			TimesUtils.hardWait(3);
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
    	String expectedResults2 = TestData.titleChannelTabs;
    	String actualResults2 = channels.titleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	TimesUtils.hardWait(5);
    	channels.tabsYourChannel();
    	String value1 = "class";
    	String contains1 = "active";
       	boolean yourTabs = channels.yourActive(value1, contains1);
 	    Assert.assertTrue(yourTabs);
 	    
 	    TimesUtils.hardWait(2);
	    channels.chatRoomChannel();
	    
	    TimesUtils.hardWait(2);
	    List<String> doc = TestData.fileDoc;
		for(int i = 0; i<doc.size();i++) {
			channels.upload(doc.get(i));
			TimesUtils.hardWait(2);
			boolean verifyDoc = channels.previewDoc();
			try {
				Assert.assertTrue(verifyDoc);
			}catch (Exception e) {
				System.out.println("Can not preview");
			}
			channels.sendFile();
			TimesUtils.hardWait(5);
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
    	String expectedResults2 = TestData.titleChannelTabs;
    	String actualResults2 = channels.titleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	TimesUtils.hardWait(5);
    	channels.tabsYourChannel();
    	String value1 = "class";
    	String contains1 = "active";
       	boolean yourTabs = channels.yourActive(value1, contains1);
 	    Assert.assertTrue(yourTabs);
 	    
 	    TimesUtils.hardWait(2);
	    channels.chatRoomChannel();
	    
	    TimesUtils.hardWait(2);
	   
	    channels.searchChatOnGroup();
		TimesUtils.hardWait(2);
		
		String text = "test";
		channels.searchChatChannel(text);
		TimesUtils.hardWait(2);
		
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
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("1. User sebagai admin dapat melihat profile channel \n"
			+ "2. Channel info yang di verifikasi: \n"
			+ "- img profile tampil di channel info\n"
			+ "- nama channel di channel info sama dengan nama channel di header chat room\n"
			+ "- total member sama dengan jumlah member yang join channel\n"
			+ "- channel type"
			+ "- who can see/remove to channel")
	@Feature("Test Case ID : MC-05-13")
	@Story("User sebagai admin dapat melihat profil Channel")
	@Test
	public void userCanSeeProfileChannel() {
		channels.tabsChatList();
		channels.tabsChannel();
    	String expectedResults2 = TestData.titleChannelTabs;
    	String actualResults2 = channels.titleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	TimesUtils.hardWait(5);
    	channels.tabsYourChannel();
    	String value1 = "class";
    	String contains1 = "active";
       	boolean yourTabs = channels.yourActive(value1, contains1);
 	    Assert.assertTrue(yourTabs);
 	    
 	    TimesUtils.hardWait(2);
	    channels.chatRoomChannel();
	    
	    TimesUtils.hardWait(2);
	    channels.channelInfoChats();
	    
		TimesUtils.hardWait(5);
		String value = "src";
		String contains = "testUpload.png";
		boolean uploaded = channelsInfo.verifyPictureUrl(value, contains);
		Assert.assertTrue(uploaded);
		
		Assert.assertTrue(channelsInfo.verifyPictureDisplayed());
		String expectedNameChannel = channelsInfo.verifyNameHeader();
		String actualNameChannel = channelsInfo.verifyNameChannel();
		Assert.assertEquals(actualNameChannel, expectedNameChannel);
		
		Assert.assertTrue(channelsInfo.verifyName());
		
		List<WebElement> listJoined = channelsInfo.getListJoined();
		int totalistJoined = listJoined.size();
		String expectedTotalMember= Integer.toString(totalistJoined);
		String actualTotalMember = channelsInfo.verifyMemberDisplayed();
		Assert.assertEquals(actualTotalMember, expectedTotalMember);
		
		TimesUtils.hardWait(2);
		Assert.assertTrue(channelsInfo.verifyChannelTypeDisplayed());
		Assert.assertTrue(channelsInfo.verifyWhoDisplayed());
	}
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("1. User dapat mengedit profile channel : \n"
			+ "- nama channel\n"
			+ "- channel type\n"
			+ "- total member sama dengan jumlah member yang join channel\n"
			+ "- who can see/remove to channel\n"
			+ "- purpose\n"
			+ "2. button cancel pada modal edit channel berfungsi\n"
			+ "3. button close pada modal edit channel berfungsi")
	@Feature("Test Case ID : MC-05-14")
	@Story("User mengedit profil Channel ")
	@Test
	public void userCanEditChannel() {
		channels.tabsChatList();
		channels.tabsChannel();
    	String expectedResults2 = TestData.titleChannelTabs;
    	String actualResults2 = channels.titleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	TimesUtils.hardWait(5);
    	channels.tabsYourChannel();
    	String value1 = "class";
    	String contains1 = "active";
       	boolean yourTabs = channels.yourActive(value1, contains1);
 	    Assert.assertTrue(yourTabs);
 	    
 	    TimesUtils.hardWait(2);
	    channels.chatRoomChannel();
	    
	    TimesUtils.hardWait(2);
	    channels.channelInfoChats();
	    
	    TimesUtils.hardWait(2);
	    channelsInfo.editChannel();
	    
	    TimesUtils.hardWait(2);
	    channelsInfo.cancelEdit();
	    TimesUtils.hardWait(2);
	    Assert.assertFalse(channelsInfo.verifyModalEdit());
	    
	    TimesUtils.hardWait(2);
	    channelsInfo.editChannel();
	    
	    TimesUtils.hardWait(2);
	    channelsInfo.closeEdit();
	    TimesUtils.hardWait(2);
	    Assert.assertFalse(channelsInfo.verifyModalEdit());
	    
	    TimesUtils.hardWait(2);
	    channelsInfo.editChannel();
	    
	    TimesUtils.hardWait(2);
	    String channelName = TestData.changeNameChannel;
	    channelsInfo.changeTextChannelName(channelName);
	    
	    TimesUtils.hardWait(2);
	    String channelType = TestData.changeChannelType;
	    channelsInfo.changeChannelType(channelType);
	    
	    TimesUtils.hardWait(2);
	    String whoInvite = TestData.changeWhoInvite;
	    channelsInfo.changeWhoInvite(whoInvite);
	    
	    TimesUtils.hardWait(2);
	    String purpose = TestData.changePurpose;
	    channelsInfo.changeTextPurpose(purpose);
	    
	    TimesUtils.hardWait(2);
	    channelsInfo.saveEdit();
	    
	    TimesUtils.hardWait(2);
	    String expectedChangeName = TestData.changeNameChannel;
	    String actualChangeName = channelsInfo.verifyChangeName();
	    Assert.assertEquals(actualChangeName, expectedChangeName);
	    
	    TimesUtils.hardWait(2);
	    String expectedChangeName1 = channelsInfo.verifyNameHeaderAfterChange();
	    String actualChangeName1 = channelsInfo.verifyChangeName();
	    Assert.assertEquals(actualChangeName1, expectedChangeName1);
	    
	    TimesUtils.hardWait(2);
	    Assert.assertTrue(channelsInfo.verifyPurpose());
	    
	    TimesUtils.hardWait(2);
	    String expectedChannelType = TestData.changeChannelTypes;
	    String actualChannelType = channelsInfo.verifyChangeType();
	    Assert.assertEquals(actualChannelType, expectedChannelType);
	    
	    TimesUtils.hardWait(2);
	    String expectedWhoInvite = TestData.changeWhoInvite;
	    String actualWhoInvite = channelsInfo.verifyChangWhoInvite();
	    Assert.assertEquals(actualWhoInvite, expectedWhoInvite);
	    
	    TimesUtils.hardWait(2);
	    channelsInfo.editChannel();
	    
	    TimesUtils.hardWait(2);
	    String channelName1 = TestData.nameChannel;
	    String channelType1 = TestData.channelType;
	    String whoInvite1 = TestData.whoInvite;
	    channelsInfo.backToDefault(channelName1, channelType1, whoInvite1);
	    TimesUtils.hardWait(2);
	    
	}
}
