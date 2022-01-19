package webautomation.mekarichat.test;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
import webautomation.mekarichat.navigation.CommonPage;
import webautomation.mekarichat.pages.ContactPage;
import webautomation.mekarichat.utils.DataUtils;
import webautomation.mekarichat.utils.ShareUtils;

@Listeners({TestAllureListener.class})
@Epic("Contacts")
public class Contacts extends BaseWebDriver {
	
	ContactPage contactPage = new ContactPage(driver, explicitWait);
	CommonPage commonPage = new CommonPage(driver, explicitWait);
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan dapat melihat halaman Contacts Tab: \n"
			+ "1. Terdapat informasi jumlah kontak \n"
			+ "2. Nama kontak diurutkan secara Alphabet\n"
			+ "3. Terdapat informasi Job Position\n"
			+ "4. User dapat melihat status online/offline pada contact\n"
			+ "5. Foto Profile Kontak")
	@Feature("Test Case ID : MC-007-01")
	@Story("User melihat halaman Contacts Tab")
	@Test
    public void listContact() {
		commonPage.navigateBrowser("refresh");
    	contactPage.tabsContact();
    	String expectedResults2 = DataUtils.titleContactTabs;
    	String actualResults2 = contactPage.titleContact();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	List<WebElement> listStatus = contactPage.listStatus();
    	String value = "style";
    	String offline = "background-color: rgb(180, 180, 180);";
		System.out.println("jumlah kontak: " + listStatus.size() + "\n");
		for(int i = 0; i<listStatus.size();i++) {
			List<WebElement> listName = contactPage.listName();
			boolean nama = listName.get(i).isDisplayed();
			Assert.assertTrue(nama);
			List<WebElement> listJobs = contactPage.listJobs();
			boolean jobs = listJobs.get(i).isDisplayed();
			Assert.assertTrue(jobs);
			List<WebElement> listImg = contactPage.imgLoaded();
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver.get()).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", listImg.get(i));
			Assert.assertTrue(ImagePresent);
			try {
				String status = listStatus.get(i).getAttribute(value);
				Assert.assertEquals(status, offline);
			}catch(Exception e) {
				System.out.println("status online");
			}

		}
    	
    }
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("1. User dapat melihat status Online/Offline pada Contact\n"
			+ "2. Jika user offline maka berwarna abu-abu\n"
			+ "3. Jika user online maka indicator berwarna hijau")
	@Feature("Test Case ID : MC-007-02")
	@Story("User melihat status Online/Offline pada Contact")
	@Test
    public void statusOnlineOfflineListContact() {  
		commonPage.navigateBrowser("refresh");
    	contactPage.tabsContact();
    	String expectedResults2 = DataUtils.titleContactTabs;
    	String actualResults2 = contactPage.titleContact();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	List<WebElement> listStatus = contactPage.listStatusInfo();
    	String value = "style";
    	String offline = "background-color: rgb(180, 180, 180);";
		System.out.println(listStatus.size());
		for(int i = 0; i<listStatus.size();i++) {
			try {
				String status = listStatus.get(i).getAttribute(value);
				Assert.assertEquals(status, offline);
				System.out.println("indikator berwarna abu-abu");
			}catch(Exception e) {
				System.out.println("indikator berwarna hijau");
			}
		}
    }
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User dapat melakukan pencarian kontak berdasarkan nama")
	@Feature("Test Case ID : MC-007-03")
	@Story("User melakukan pencarian kontak berdasarkan nama")
	@Test
    public void searchContactWithName() {
		commonPage.navigateBrowser("refresh");
    	contactPage.tabsContact();
    	String expectedResults2 = DataUtils.titleContactTabs;
    	String actualResults2 = contactPage.titleContact();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	String text = "den";
    	contactPage.searchText(text);
    	
    	ShareUtils.hardWait(5);
    	List<WebElement> listData;
		try {
			listData = contactPage.listName();
			System.out.println("Jumlah kontak yang ditemukan :" + listData.size() + "\n");
			for(int i = 0; i<listData.size();i++) {
					String name = listData.get(i).getText();
					if ((name.toLowerCase().contains(text.toLowerCase()))){
						Assert.assertTrue(true, text);
						System.out.println(name);
						System.out.println("Search Contact with Name is Found" + "\n");
					}
			}
		} catch (Exception e) {
			String message = contactPage.getMessage();
			System.out.println(message);
		}
    }
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("1. User dapat melakukan pencarian kontak berdasarkan job position\n"
			+ "2. Result\n"
			+ " type: pro\n"
			+ "muncul: \n"
			+ "Product Manager\n"
			+ "Project Manager\n")
	@Feature("Test Case ID : MC-007-04")
	@Story("User melakukan pencarian kontak berdasarkan job position")
	@Test
    public void searchContactWithJobs() {
		commonPage.navigateBrowser("refresh");
    	contactPage.tabsContact();
    	String expectedResults2 = DataUtils.titleContactTabs;
    	String actualResults2 = contactPage.titleContact();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	String text = "pro";
    	contactPage.searchText(text);
    	ShareUtils.hardWait(5);
    	List<WebElement> listData;
		try {
			listData = contactPage.listJobs();
			System.out.println("Jumlah kontak yang ditemukan :" + listData.size() + "\n");
			for(int i = 0; i<listData.size();i++) {
					String jobs = listData.get(i).getText();
					if ((jobs.toLowerCase().contains(text.toLowerCase()))){
						Assert.assertTrue(true, text);
						System.out.println(jobs);
						System.out.println("Search Contact with Jobs is Found" + "\n");
					}
			}
		} catch (Exception e) {
			String message = contactPage.getMessage();
			System.out.println(message);
		}
    }
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan dapat mengakses private chat room melalui tab Contacts")
	@Feature("Test Case ID : MC-007-05")
	@Story("User mengakses private chat room melalui tab Contacts")
	@Test
    public void accessPrivateRoomFromTabsContacts() {   
		commonPage.navigateBrowser("refresh");
    	contactPage.tabsContact();
    	String expectedResults2 = DataUtils.titleContactTabs;
    	String actualResults2 = contactPage.titleContact();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	String text = "delta";
    	contactPage.searchText(text);
    	ShareUtils.hardWait(2);
    	
    	contactPage.listChat();
    	boolean startChat = contactPage.getStartChat();
    	Assert.assertTrue(startChat);
    }
	
}
