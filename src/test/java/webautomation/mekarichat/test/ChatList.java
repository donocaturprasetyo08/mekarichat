package webautomation.mekarichat.test;

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
import webautomation.mekarichat.pages.ChatListPage;
import webautomation.mekarichat.pages.LoginPage;
import webautomation.mekarichat.utils.DataUtils;
import webautomation.mekarichat.utils.ShareUtils;

@Listeners({TestAllureListener.class})
@Epic("Chat List")
public class ChatList extends BaseWebDriver{
	
	ChatListPage chatList = new ChatListPage(driver, explicitWait);
	LoginPage loginPage = new LoginPage(driver, explicitWait);
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User dapat melihat status Online/Offline pada Private Chat")
	@Feature("Test Case ID : MC-003-03")
	@Story("User melihat status Online/Offline pada Private Chat")
    @Test
    public void checkStatusChatOnlineOffline() {
		String actualResults = loginPage.getTitlePage();
		String expectedResults = "Mekari Account";
		Assert.assertEquals(expectedResults, actualResults);
		
		String email = DataUtils.emailMekari;
    	String password = DataUtils.passwordMekari;
    	loginPage.inputEmailPassword(email, password);
    	
    	String expectedResults1 = "https://messenger.mekari.com/dashboard";
    	String actualResults1 = loginPage.getUrlPage();
    	Assert.assertEquals(expectedResults1, actualResults1);
    	
    	String expectedResults2 = "Chats";
    	String actualResults2 = chatList.titleTabChat();
    	Assert.assertEquals(expectedResults2, actualResults2);
    	
    	try {
    		String expectedResults3 = "background-color: rgb(180, 180, 180);";
        	String value = "style";
        	String actualResults3 = chatList.statusChat(value);
        	Assert.assertEquals(actualResults3, expectedResults3);
    	}catch(Exception e) {
    		String expectedResults4 = "background-color: rgb(0, 159, 97);";
        	String value1 = "style";
        	String actualResults4 = chatList.statusChat(value1);
        	Assert.assertEquals(actualResults4, expectedResults4);
    	}
    }
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User dapat menyematkan pesan")
	@Feature("Test Case ID : MC-003-05")
	@Story("User menyematkan pesan")
	@Test
    public void pinTest() {
		String actualResults = loginPage.getTitlePage();
		String expectedResults = "Mekari Account";
		Assert.assertEquals(expectedResults, actualResults);
		
		String email = DataUtils.emailMekari;
    	String password = DataUtils.passwordMekari;
    	loginPage.inputEmailPassword(email, password);
    	
    	String expectedResults1 = "https://messenger.mekari.com/dashboard";
    	String actualResults1 = loginPage.getUrlPage();
    	Assert.assertEquals(expectedResults1, actualResults1);
    	
    	String expectedResults2 = "Chats";
    	String actualResults2 = chatList.titleTabChat();
    	Assert.assertEquals(expectedResults2, actualResults2);
    	
    	ShareUtils.hardWait(5);
    	chatList.pinChat();
    	ShareUtils.hardWait(5);
    	
    	boolean checkPin = chatList.findPinImage();
    	Assert.assertTrue(checkPin);
    	
    	ShareUtils.hardWait(5);
    	chatList.unpinChat();
    	ShareUtils.hardWait(3);
    }
}
