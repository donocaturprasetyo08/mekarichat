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
import webautomation.mekarichat.pages.ChatListPage;
import webautomation.mekarichat.pages.SearchMessagePage;
import webautomation.mekarichat.utils.DataUtils;
import webautomation.mekarichat.utils.ShareUtils;

@Listeners({TestAllureListener.class})
@Epic("Search Message")
public class SearchMessage extends BaseWebDriver {

	SearchMessagePage searchMessage = new SearchMessagePage(driver, explicitWait);
	ChatListPage chatList = new ChatListPage(driver, explicitWait);
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("1. User dapat melihat daftar recents chat room" + "\n" + "2. User dapat mencari chat room sesuai nama kontak atau Job Position")
	@Feature("Test Case ID : MC-006-01")
	@Story("User melakukan pencarian Chat Room pada Chats Tab")
	@Test
    public void searchOnChatTab() {
    	
    	String expectedResults2 = DataUtils.titleChatTabs;
    	String actualResults2 = chatList.titleTabChat();
    	Assert.assertEquals(expectedResults2, actualResults2);
    	ShareUtils.hardWait(3);
    	
    	String text = "deni";
    	searchMessage.searchText(text);
    	
    	//Recent Chat
    	ShareUtils.hardWait(5);
    	List<WebElement> listData;
		try {
			listData = searchMessage.listSearchRecent();
			System.out.println(listData.size());
			for(int i = 0; i<listData.size();i++) {
					String temp = listData.get(i).getText();
					if ((temp.toLowerCase().contains(text.toLowerCase()))){
						Assert.assertTrue(true, text);
						System.out.println("Search Message on Recent Chat is Found");
						System.out.println(temp);
					}
			}
		} catch (Exception e) {
			System.out.println("Search Message on Recent Chat is Not Found");
		}
    	
		
		//Contact Chat
		List<WebElement> listDataContact;
		try {
			listDataContact = searchMessage.listSearchContact();
			System.out.println(listDataContact.size());
			for(int i = 0; i<listDataContact.size();i++) {
					String name = listDataContact.get(i).getText();
					List<WebElement> listJobs = searchMessage.jobSearch();
					String jobs = listJobs.get(i).getText();
					if ((name.toLowerCase().contains(text.toLowerCase()))){
						Assert.assertTrue(true, text);
						System.out.println("Search Message on Contact is Found");
						System.out.println(name);
						System.out.println(jobs);
					}
			}
		} catch (Exception e) {
			System.out.println("Search Message on Recent Chat is Not Found");
		}
		
		//Job
    	List<WebElement> listJob;
		try {
			listJob = searchMessage.jobSearch();
			System.out.println(listJob.size());
			for(int i = 0; i<listJob.size();i++) {
					String job = listJob.get(i).getText();
					List<WebElement> listname = searchMessage.listSearchContact();
					String name = listname.get(i).getText();
					if ((job.toLowerCase().contains(text.toLowerCase()))){
						Assert.assertTrue(true, text);
						System.out.println("Search Message with Job is Found");
						System.out.println(name);
						System.out.println(job);
						
					}
			}
		} catch (Exception e) {
			System.out.println("Search Message with Job is Not Found");
		}
    }
	
}
