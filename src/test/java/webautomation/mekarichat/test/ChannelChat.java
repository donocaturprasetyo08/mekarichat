package webautomation.mekarichat.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import webautomation.mekarichat.BaseWebDriver;
import webautomation.mekarichat.pages.ChannelsTabs;
import webautomation.mekarichat.utils.DataUtils;
import webautomation.mekarichat.utils.ShareUtils;

public class ChannelChat extends BaseWebDriver {
	
	ChannelsTabs channels = new ChannelsTabs(driver, explicitWait);
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan dapat mengirim pesan text ")
	@Feature("Test Case ID : MC-005-01")
	@Story("User mengirim pesan text")
	@Test
	public void sendOnChannelChat() {
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
}
