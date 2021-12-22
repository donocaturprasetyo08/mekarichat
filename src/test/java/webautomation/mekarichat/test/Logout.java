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
import webautomation.mekarichat.pages.LoginPage;
import webautomation.mekarichat.pages.LogoutTest;
import webautomation.mekarichat.utils.DataUtils;
import webautomation.mekarichat.utils.ShareUtils;

@Listeners({TestAllureListener.class})
@Epic("Logout")
public class Logout extends BaseWebDriver{
	
	LoginPage loginPage = new LoginPage(driver, explicitWait);
	LogoutTest logoutTest = new LogoutTest(driver, explicitWait);
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User berhasil logout dari Mekari Chat App")
	@Feature("Test Case ID : MC-002-02")
	@Story("User logout dari Mekari Chat App")
    @Test
    public void logoutFromMekariChat()
    {
		String actualResults = loginPage.getTitlePage();
		String expectedResults = DataUtils.titlePageLogin;
		Assert.assertEquals(actualResults, expectedResults);
		
		String email = DataUtils.emailMekari;
    	String password = DataUtils.passwordMekari;
    	loginPage.inputEmailPassword(email, password);
    	
    	String expectedResults1 = DataUtils.urlDashboard;
    	String actualResults1 = loginPage.getUrlPage();
    	Assert.assertEquals(actualResults1, expectedResults1);
    	
    	ShareUtils.hardWait(5);
    	logoutTest.logOut();
    	ShareUtils.hardWait(5);
    	boolean actualResults2 = logoutTest.verifyLogout();
    	Assert.assertTrue(actualResults2);
    }
}
