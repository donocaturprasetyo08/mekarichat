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
import webautomation.mekarichat.pages.AccountTabs;
import webautomation.mekarichat.pages.LoginPage;
import webautomation.mekarichat.utils.DataUtils;
import webautomation.mekarichat.utils.ShareUtils;

@Listeners({TestAllureListener.class})
@Epic("Account")
public class Account extends BaseWebDriver {
	
	LoginPage loginPage = new LoginPage(driver, explicitWait);
	AccountTabs account = new AccountTabs(driver, explicitWait);

	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan dapat melihat Info Akun : \n"
			+ "1. Foto Profile \n"
			+ "2. Nama \n"
			+ "3. Job Position\n")
	@Feature("Test Case ID : MC-012-01")
	@Story("User melihat Info Akun")
	@Test
	public void infoAccount() {
		String actualResults = loginPage.getTitlePage();
		String expectedResults = DataUtils.titlePageLogin;
		Assert.assertEquals(actualResults, expectedResults);
		
		String email = DataUtils.emailMekari;
    	String password = DataUtils.passwordMekari;
    	loginPage.inputEmailPassword(email, password);
    	
    	String expectedResults1 = DataUtils.urlDashboard;
    	String actualResults1 = loginPage.getUrlPage();
    	Assert.assertEquals(actualResults1, expectedResults1);
    	ShareUtils.hardWait(3);
    	
    	account.accountTabs();
    	String expectedResults2 = DataUtils.titleAccountTabs;
    	String actualResults2 = account.titleAccountTabs();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	boolean img = account.findElementImg();
		Assert.assertTrue(img);
		
		boolean nama = account.findElementNama();
		Assert.assertTrue(nama);
		
		boolean jobs = account.findElementJobs();
		Assert.assertTrue(jobs);
	}
	
	//GAGAL
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan dapat mengganti foto profil")
	@Feature("Test Case ID : MC-012-02")
	@Story("User mengganti foto profil")
	@Test
	public void changeProfileAccount() {
		String actualResults = loginPage.getTitlePage();
		String expectedResults = DataUtils.titlePageLogin;
		Assert.assertEquals(actualResults, expectedResults);
		
		String email = DataUtils.emailMekari;
    	String password = DataUtils.passwordMekari;
    	loginPage.inputEmailPassword(email, password);
    	
    	String expectedResults1 = DataUtils.urlDashboard;
    	String actualResults1 = loginPage.getUrlPage();
    	Assert.assertEquals(actualResults1, expectedResults1);
    	ShareUtils.hardWait(3);
    	
    	account.accountTabs();
    	String expectedResults2 = DataUtils.titleAccountTabs;
    	String actualResults2 = account.titleAccountTabs();
    	Assert.assertEquals(actualResults2, expectedResults2);
		
		String location = DataUtils.fotoProfile;
		account.changePicture(location);
	}
}
