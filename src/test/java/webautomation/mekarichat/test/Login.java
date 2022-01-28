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
import webautomation.mekarichat.utils.TestData;
import webautomation.mekarichat.utils.TimesUtils;

@Listeners({TestAllureListener.class})
@Epic("Login")
public class Login extends BaseWebDriver {

	LoginPage loginPage = new LoginPage(driver, explicitWait);
	LogoutTest logoutTest = new LogoutTest(driver, explicitWait);
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("Verifikasi login dengan email dan password yang benar")
	@Feature("Test Case ID : MC-001-02")
	@Story("User login dengan email dan password yang benar")
	@Test(priority=6)
    public void loginWithValidEmailandPassword()
    {
		String actualResults = loginPage.getTitlePage();
		String expectedResults = TestData.titlePageLogin;
		Assert.assertEquals(actualResults, expectedResults);
		
		loginPage.clearText();
		TimesUtils.hardWait(2);
		
		String email = TestData.emailMekari;
    	String password = TestData.passwordMekari;
    	loginPage.inputEmailPassword(email, password);
    	
    	String expectedResults1 = TestData.urlDashboard;
    	String actualResults1 = loginPage.getUrlPage();
    	Assert.assertEquals(actualResults1, expectedResults1);
    }
    
	@Severity(SeverityLevel.CRITICAL)	
	@Description("Verifikasi login dengan email yang benar dan password yang salah")
	@Feature("Test Case ID : MC-001-03")
	@Story("User login dengan email yang benar dan password yang salah")
    @Test(priority=1)
    public void loginWithValidEmailandWrongPassword()
    {
		TimesUtils.hardWait(2);
    	logoutTest.logOut();
    	TimesUtils.hardWait(2);
		String actualResults = loginPage.getTitlePage();
		String expectedResults = TestData.titlePageLogin;
		Assert.assertEquals(actualResults, expectedResults);
		
		loginPage.clearText();
		TimesUtils.hardWait(2);
		
		String email = TestData.emailMekari;
    	String password = "12345678";
    	loginPage.inputEmailPassword(email, password);
    	
    	boolean actualResults1 = loginPage.notifFailed();
    	Assert.assertTrue(actualResults1);  
    }
    
	@Severity(SeverityLevel.CRITICAL)	
	@Description("Verifikasi login dengan email salah dan password yang benar")
	@Feature("Test Case ID : MC-001-04")
	@Story("User login dengan email yang salah dan password yang benar")
    @Test(priority=2)
    public void loginWithWrongEmailandValidPassword()
    {
		String actualResults = loginPage.getTitlePage();
		String expectedResults = TestData.titlePageLogin;
		Assert.assertEquals(actualResults, expectedResults);
		
		loginPage.clearText();
		TimesUtils.hardWait(2);
		
		String email = "abcd@mail.co";
    	String password = TestData.passwordMekari;
    	loginPage.inputEmailPassword(email, password);
    	
    	boolean actualResults1 = loginPage.notifFailed();
    	Assert.assertTrue(actualResults1);  
    }
    
	@Severity(SeverityLevel.CRITICAL)	
	@Description("Verifikasi login dengan email dan password yang salah")
	@Feature("Test Case ID : MC-001-05")
	@Story("User login dengan email dan password yang salah")
    @Test(priority=3)
    public void loginWithWrongEmailandPassword()
    {
		String actualResults = loginPage.getTitlePage();
		String expectedResults = TestData.titlePageLogin;
		Assert.assertEquals(actualResults, expectedResults);
		
		loginPage.clearText();
		TimesUtils.hardWait(2);
		
		String email = "abcd@mail.co";
    	String password = "12345678";
    	loginPage.inputEmailPassword(email, password);
    	
    	boolean actualResults1 = loginPage.notifFailed();
    	Assert.assertTrue(actualResults1);   
    }
    
	@Severity(SeverityLevel.NORMAL)	
	@Description("User dapat melihat password")
	@Feature("Test Case ID : MC-001-06")
	@Story("User melihat password yang diisi")
	@Test(priority=4)
    public void checkPasswordShowed()
    {
		String actualResults = loginPage.getTitlePage();
		String expectedResults = TestData.titlePageLogin;
		Assert.assertEquals(actualResults, expectedResults);
		
		loginPage.clearText();
		TimesUtils.hardWait(2);
		
    	String password = "12345678";
    	loginPage.setPassword(password);
    	loginPage.clickShowPassword();
    	boolean isEncrypted = loginPage.showPassword();
    	Assert.assertTrue(isEncrypted);
    }

	@Severity(SeverityLevel.NORMAL)	
	@Description("User dapat menyembunyikan password yang diisi")
	@Feature("Test Case ID : MC-001-07")
	@Story("User menyembunyikan password yang diisi")
	@Test(priority=5)
    public void checkPasswordHidden()
    {
		String actualResults = loginPage.getTitlePage();
		String expectedResults = TestData.titlePageLogin;
		Assert.assertEquals(actualResults, expectedResults);
		
		loginPage.clearText();
		TimesUtils.hardWait(2);
		
		String password = "12345678";
    	loginPage.setPassword(password);
    	boolean isEncrypted = loginPage.hiddenPassword();
    	Assert.assertTrue(isEncrypted);
    }
	
}
