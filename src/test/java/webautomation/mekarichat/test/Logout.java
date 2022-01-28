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
import webautomation.mekarichat.pages.LogoutTest;
import webautomation.mekarichat.utils.TimesUtils;

@Listeners({TestAllureListener.class})
@Epic("Logout")
public class Logout extends BaseWebDriver{
	
	LogoutTest logoutTest = new LogoutTest(driver, explicitWait);
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User berhasil logout dari Mekari Chat App")
	@Feature("Test Case ID : MC-002-02")
	@Story("User logout dari Mekari Chat App")
    @Test
    public void logoutFromMekariChat()
    {
    	TimesUtils.hardWait(5);
    	logoutTest.logOut();
    	TimesUtils.hardWait(5);
    	boolean actualResults2 = logoutTest.verifyLogout();
    	Assert.assertTrue(actualResults2);
    }
}
