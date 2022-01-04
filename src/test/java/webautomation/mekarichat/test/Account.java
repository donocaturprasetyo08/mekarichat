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
import webautomation.mekarichat.utils.DataUtils;
import webautomation.mekarichat.utils.ShareUtils;

@Listeners({TestAllureListener.class})
@Epic("Account")
public class Account extends BaseWebDriver {
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
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan dapat mengganti foto profil")
	@Feature("Test Case ID : MC-012-02")
	@Story("User mengganti foto profil")
	@Test
	public void changeProfileAccount() {  	
    	account.accountTabs();
    	String expectedResults2 = DataUtils.titleAccountTabs;
    	String actualResults2 = account.titleAccountTabs();
    	Assert.assertEquals(actualResults2, expectedResults2);
		
		String location = DataUtils.fotoProfile;
		account.changePicture(location);
		
		ShareUtils.hardWait(3);
		String value = "src";
		String contains = "testUpload.png";
		boolean uploaded = account.verifyPictureUploaded(value, contains);
		Assert.assertTrue(uploaded);
		
		String location1 = DataUtils.fotoProfileOri;
		account.changePicture(location1);
		ShareUtils.hardWait(2);
		
		
	}
}
