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
import webautomation.mekarichat.BaseWebLogin;
import webautomation.mekarichat.TestAllureListener;
import webautomation.mekarichat.pages.LoginPage;
import webautomation.mekarichat.utils.DataUtils;

@Listeners({TestAllureListener.class})
@Epic("Login")
public class Login extends BaseWebLogin {

	LoginPage loginPage = new LoginPage(driver, explicitWait);
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("Verifikasi login dengan email dan password yang benar")
	@Feature("Test Case ID : MC-001-02")
	@Story("User login dengan email dan password yang benar")
	@Test
    public void loginWithValidEmailandPassword()
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
    }
    
	@Severity(SeverityLevel.CRITICAL)	
	@Description("Verifikasi login dengan email yang benar dan password yang salah")
	@Feature("Test Case ID : MC-001-03")
	@Story("User login dengan email yang benar dan password yang salah")
    @Test
    public void loginWithValidEmailandWrongPassword()
    {
		String actualResults = loginPage.getTitlePage();
		String expectedResults = DataUtils.titlePageLogin;
		Assert.assertEquals(actualResults, expectedResults);
		
		String email = DataUtils.emailMekari;
    	String password = "12345678";
    	loginPage.inputEmailPassword(email, password);
    	
    	boolean actualResults1 = loginPage.notifFailed();
    	Assert.assertTrue(actualResults1);  
    }
    
	@Severity(SeverityLevel.CRITICAL)	
	@Description("Verifikasi login dengan email salah dan password yang benar")
	@Feature("Test Case ID : MC-001-04")
	@Story("User login dengan email yang salah dan password yang benar")
    @Test
    public void loginWithWrongEmailandValidPassword()
    {
		String actualResults = loginPage.getTitlePage();
		String expectedResults = DataUtils.titlePageLogin;
		Assert.assertEquals(actualResults, expectedResults);
		
		String email = "abcd@mail.co";
    	String password = DataUtils.passwordMekari;
    	loginPage.inputEmailPassword(email, password);
    	
    	boolean actualResults1 = loginPage.notifFailed();
    	Assert.assertTrue(actualResults1);  
    }
    
	@Severity(SeverityLevel.CRITICAL)	
	@Description("Verifikasi login dengan email dan password yang salah")
	@Feature("Test Case ID : MC-001-05")
	@Story("User login dengan email dan password yang salah")
    @Test
    public void loginWithWrongEmailandPassword()
    {
		String actualResults = loginPage.getTitlePage();
		String expectedResults = DataUtils.titlePageLogin;
		Assert.assertEquals(actualResults, expectedResults);
		
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
	@Test
    public void checkPasswordShowed()
    {
		String actualResults = loginPage.getTitlePage();
		String expectedResults = DataUtils.titlePageLogin;
		Assert.assertEquals(actualResults, expectedResults);
		
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
	@Test
    public void checkPasswordHidden()
    {
		String actualResults = loginPage.getTitlePage();
		String expectedResults = DataUtils.titlePageLogin;
		Assert.assertEquals(actualResults, expectedResults);
		
		String password = "12345678";
    	loginPage.setPassword(password);
    	boolean isEncrypted = loginPage.hiddenPassword();
    	Assert.assertTrue(isEncrypted);
    }
	
}
