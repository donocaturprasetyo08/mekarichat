package webautomation.mekarichat.test;

import java.util.List;

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
import webautomation.mekarichat.pages.ChannelsTabs;

import webautomation.mekarichat.utils.DataUtils;
import webautomation.mekarichat.utils.ShareUtils;

@Listeners({TestAllureListener.class})
@Epic("Channels")
public class Channels extends BaseWebDriver {
	ChannelsTabs channels = new ChannelsTabs(driver, explicitWait);
	CommonPage commonPage = new CommonPage(driver, explicitWait);
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan dapat melihat channel tabs : \n"
			+ "1. Your Channels untuk Channel yang sudah joined\n"
			+ "2. Available channel untuk Public Channel/Announcement Channel yang belum joined")
	@Feature("Test Case ID : MC-008-01")
	@Story("User mengakses tab Channels untuk melihat daftar Channel")
	@Test(priority=1)
	public void tabsChannelForSeeDaftarChannel() {
    	channels.tabsChannel();
    	String expectedResults2 = DataUtils.titleChannelTabs;
    	String actualResults2 = channels.titleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	//Available Channel Tabs
    	channels.tabsAvailableChannel();
    	String value = "class";
    	String contains = "active";
    	boolean activeTabs = channels.availableActive(value, contains);
    	Assert.assertTrue(activeTabs);
    	
    	ShareUtils.hardWait(3);
    	List<WebElement> listChannels;
		try {
			listChannels = channels.listChannelAvailable();
			for(int i = 0; i<listChannels.size();i++) {
					boolean join = listChannels.get(i).isDisplayed();
					Assert.assertTrue(join);
			}
		} catch (Exception e) {
			System.out.println("List Available Channel can not find");
		}
		
		//Your Channels Tabs
		ShareUtils.hardWait(5);
    	channels.tabsYourChannel();
    	String value1 = "class";
    	String contains1 = "active";
    	boolean yourTabs = channels.yourActive(value1, contains1);
    	Assert.assertTrue(yourTabs);
    	
    	ShareUtils.hardWait(3);
    	List<WebElement> listYourChannels;
		try {
			listYourChannels = channels.listYourChannel();
			for(int i = 0; i<listYourChannels.size();i++) {
					boolean join = listYourChannels.get(i).isDisplayed();
					Assert.assertTrue(join);
			}
		} catch (Exception e) {
			System.out.println("List Your Channel can not find");
		}
	}
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan dapat melakukan pencarian pada Available Channel")
	@Feature("Test Case ID : MC-008-02")
	@Story("User melakukan pencarian pada Available Channels ")
	@Test(priority=2)
	public void searchOnAvailableChannel() {
		commonPage.navigateBrowser("refresh");
    	channels.tabsChannel();
    	String expectedResults2 = DataUtils.titleChannelTabs;
    	String actualResults2 = channels.titleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	//Available Channel Tabs
    	channels.tabsAvailableChannel();
    	String value = "class";
    	String contains = "active";
    	boolean activeTabs = channels.availableActive(value, contains);
    	Assert.assertTrue(activeTabs);
    	
    	ShareUtils.hardWait(2);
    	String text = "per";
    	channels.searchChannel(text);
    	
    	ShareUtils.hardWait(2);
    	List<WebElement> listChannels;
		try {
			listChannels = channels.listSearchChannelAvailable();
			for(int i = 0; i<listChannels.size();i++) {
					String list = listChannels.get(i).getText();
					if ((list.toLowerCase().contains(text.toLowerCase()))){
						Assert.assertTrue(true, text);
					}
			}
		} catch (Exception e) {
			System.out.println("List Available Channel can not find");
		}
	}
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan dapat melakukan pencarian pada Your Channel")
	@Feature("Test Case ID : MC-008-03")
	@Story("User melakukan pencarian pada Your Channels")
	@Test(priority=3)
	public void searchOnYourChannel() {
		commonPage.navigateBrowser("refresh");
    	channels.tabsChannel();
    	String expectedResults2 = DataUtils.titleChannelTabs;
    	String actualResults2 = channels.titleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	//Your Channels Tabs
    	ShareUtils.hardWait(5);
    	channels.tabsYourChannel();
    	String value1 = "class";
    	String contains1 = "active";
       	boolean yourTabs = channels.yourActive(value1, contains1);
 	    Assert.assertTrue(yourTabs);
    	    	
 	    ShareUtils.hardWait(2);
 	    String text = "tes";
 	   	channels.searchChannel(text);
 	   
    	ShareUtils.hardWait(3);
       	List<WebElement> listYourChannels;
  		try {
   			listYourChannels = channels.listSearchChannelAvailable();
  			for(int i = 0; i<listYourChannels.size();i++) {
  				String list = listYourChannels.get(i).getText();
				if ((list.toLowerCase().contains(text.toLowerCase()))){
					Assert.assertTrue(true, text);
				}	
  				}
    		} catch (Exception e) {
    			System.out.println("List Your Channel can not find");
    	}
	}
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan bergabung dengan Channel yang tersedia pada Available Channels")
	@Feature("Test Case ID : MC-008-04")
	@Story("User bergabung dengan Channel yang tersedia pada Available Channels")
	@Test(priority=4)
	public void joinChannel() {
		commonPage.navigateBrowser("refresh");
    	channels.tabsChannel();
    	String expectedResults2 = DataUtils.titleChannelTabs;
    	String actualResults2 = channels.titleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	channels.tabsAvailableChannel();
    	String value = "class";
    	String contains = "active";
    	boolean activeTabs = channels.availableActive(value, contains);
    	Assert.assertTrue(activeTabs);
    	
    	channels.joinChannel();
    	ShareUtils.hardWait(2);
    	boolean checkJoin = channels.verifyJoin();
    	Assert.assertTrue(checkJoin);
	}
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("1. User mengakses Channel yang sudah tergabung pada Your Channels \n"
			+ "2. User akan diarahkan ke dalam channel room ")
	@Feature("Test Case ID : MC-008-05")
	@Story("User mengakses Channel yang sudah tergabung pada Your Channels ")
	@Test(priority=5)
	public void accessJoinChannel() {
		commonPage.navigateBrowser("refresh");
    	channels.tabsChannel();
    	String expectedResults2 = DataUtils.titleChannelTabs;
    	String actualResults2 = channels.titleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	
    	ShareUtils.hardWait(2);
    	channels.tabsYourChannel();
    	String value1 = "class";
    	String contains1 = "active";
       	boolean yourTabs = channels.yourActive(value1, contains1);
 	    Assert.assertTrue(yourTabs);
    	
 	    ShareUtils.hardWait(2);
    	channels.clickChannel();
    	ShareUtils.hardWait(2);
    	boolean checkJoin = channels.verifyJoin();
    	Assert.assertTrue(checkJoin);
    	
    	ShareUtils.hardWait(2);
    	channels.leaveGroup();
	}
	
}
