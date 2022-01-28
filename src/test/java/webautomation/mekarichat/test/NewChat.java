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
import webautomation.mekarichat.pages.NewChatTabs;
import webautomation.mekarichat.utils.TestData;
import webautomation.mekarichat.utils.TimesUtils;

@Listeners({TestAllureListener.class})
@Epic("New Chat")
public class NewChat extends BaseWebDriver{
	
	NewChatTabs newChat = new NewChatTabs(driver, explicitWait);
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan dapat memulai percakapan baru dari fitur New Chat")
	@Feature("Test Case ID : MC-010-01")
	@Story("User memulai percakapan baru dari fitur New Chat")
	@Test
	public void newChat() {	
    	newChat.tabsNewChat();
    	TimesUtils.hardWait(2);
    	
    	String select = "deni istika";
    	newChat.selectTo(select);
    	
    	TimesUtils.hardWait(2);
    	boolean selectTo = newChat.verifySelect();
    	Assert.assertTrue(selectTo);

    	String text = TestData.sendMessage;
    	newChat.sendMessage(text);
    	TimesUtils.hardWait(8);
    	
    	boolean verifyMessage = newChat.verifyMessage();
		Assert.assertTrue(verifyMessage);
    }
}
