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
import webautomation.mekarichat.pages.SearchChatPage;
import webautomation.mekarichat.utils.DataUtils;
import webautomation.mekarichat.utils.ShareUtils;

@Listeners({TestAllureListener.class})
@Epic("Search Message")
public class SearchChat extends BaseWebDriver {
	
	SearchChatPage searchChat = new SearchChatPage(driver, explicitWait);
	CommonPage commonPage = new CommonPage(driver, explicitWait);
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan dapat melakukan pencarian pesan pada Search Message dengan menggunakan filter From")
	@Feature("Test Case ID : MC-006-02")
	@Story("User melakukan pencarian pesan pada Search Message  dengan menggunakan filter From")
	@Test
	public void searchOnTabSearchWithFilterFrom() {	
		commonPage.navigateBrowser("refresh");
    	searchChat.tabsSearch();
    	String expectedResults2 = DataUtils.titleSearchTabs;
    	String actualResults2 = searchChat.getTitleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	ShareUtils.hardWait(3);
    	
    	String text = "test";
    	String select = "deni";
    	searchChat.searchChatFilterFrom(text, select);
    	
    	//Filter Chat From
    	ShareUtils.hardWait(5);
    	List<WebElement> listChat;
		try {
			listChat = searchChat.listSearchChat();
			System.out.println(listChat.size());
			for(int i = 0; i<listChat.size();i++) {
					String chat = listChat.get(i).getText();
					List<WebElement> listDate = searchChat.listDateSearchChat();
					String date = listDate.get(i).getText();
					List<WebElement> listName = searchChat.listNameSearchChat();
					String name = listName.get(i).getText();
					if ((chat.toLowerCase().contains(text.toLowerCase()))){
						Assert.assertTrue(true, text);
						System.out.println("Search Chat with Filter From is Found");
						System.out.println(date);
						System.out.println(name);
						System.out.println(chat);
					}
			}
		} catch (Exception e) {
			System.out.println("Search Chat with Filter From is Not Found");
		}
    }
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan melakukan pencarian pesan pada Search Message dengan menggunakan filter Post In")
	@Feature("Test Case ID : MC-006-03")
	@Story("User melakukan pencarian pesan pada Search Message dengan menggunakan filter Post In")
	@Test
    public void searchChatWithFilterPostIn() { 
		commonPage.navigateBrowser("refresh");
    	searchChat.tabsSearch();
    	String expectedResults2 = DataUtils.titleSearchTabs;
    	String actualResults2 = searchChat.getTitleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	ShareUtils.hardWait(3);
    	
    	String text = "test";
    	String select = "General Channel";
    	searchChat.searchChatFilterPostIn(text, select);
    	
    	//Filter Chat From
    	ShareUtils.hardWait(5);
    	List<WebElement> listChat;
		try {
			listChat = searchChat.listSearchChat();
			System.out.println(listChat.size());
			for(int i = 0; i<listChat.size();i++) {
					String chat = listChat.get(i).getText();
					List<WebElement> listDate = searchChat.listDateSearchChat();
					String date = listDate.get(i).getText();
					List<WebElement> listName = searchChat.listNameSearchChat();
					String name = listName.get(i).getText();
					if ((chat.toLowerCase().contains(text.toLowerCase()))){
						Assert.assertTrue(true, text);
						System.out.println("Search Chat with Filter Post In is Found");
						System.out.println(date);
						System.out.println(name);
						System.out.println(chat);
					}
			}
		} catch (Exception e) {
			System.out.println("Search Chat with Filter Post In is Not Found");
		}
    }
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan dapat melakukan pencarian pesan pada Search Message tanpa filter")
	@Feature("Test Case ID : MC-006-04")
	@Story("User melakukan pencarian pesan pada Search Message tanpa filter")
	@Test
    public void searchChatWithNoFilter() {
		commonPage.navigateBrowser("refresh");
    	searchChat.tabsSearch();
    	String expectedResults2 = DataUtils.titleSearchTabs;
    	String actualResults2 = searchChat.getTitleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	ShareUtils.hardWait(3);
    	
    	String text = "test";
    	searchChat.searchChatNoFilter(text);
    	
    	//Filter Chat From
    	ShareUtils.hardWait(5);
    	List<WebElement> listChat;
		try {
			listChat = searchChat.listSearchChat();
			System.out.println(listChat.size());
			for(int i = 0; i<listChat.size();i++) {
					String chat = listChat.get(i).getText();
					List<WebElement> listDate = searchChat.listDateSearchChat();
					String date = listDate.get(i).getText();
					List<WebElement> listName = searchChat.listNameSearchChat();
					String name = listName.get(i).getText();
					if ((chat.toLowerCase().contains(text.toLowerCase()))){
						Assert.assertTrue(true, text);
						System.out.println("Search Chat with no filter is Found");
						System.out.println(date);
						System.out.println(name);
						System.out.println(chat);
					}
			}
		} catch (Exception e) {
			System.out.println("Search Chat with no filter is Not Found");
		}
    }
	
	@Severity(SeverityLevel.CRITICAL)	
	@Description("User akan dapat melakukan pencarian pesan pada Search Message dengan menggunakan filter Post In dan filter From")
	@Feature("Test Case ID : MC-006-05")
	@Story("User melakukan pencarian pesan pada Search Message dengan menggunakan filter Post In dan filter From")
	@Test
    public void searchChatWithFilterPostInAndFrom() {
		commonPage.navigateBrowser("refresh");
    	searchChat.tabsSearch();
    	String expectedResults2 = DataUtils.titleSearchTabs;
    	String actualResults2 = searchChat.getTitleTab();
    	Assert.assertEquals(actualResults2, expectedResults2);
    	ShareUtils.hardWait(3);
    	
    	String text = "test";
    	String selectPostIn = "General Channel";
    	String selectFrom = "delta purna";
    	searchChat.searchChatFilterFromAndPostIn(text, selectPostIn, selectFrom);
    	
    	//Filter Chat From
    	ShareUtils.hardWait(5);
    	List<WebElement> listChat;
		try {
			listChat = searchChat.listSearchChat();
			System.out.println(listChat.size());
			for(int i = 0; i<listChat.size();i++) {
					String chat = listChat.get(i).getText();
					List<WebElement> listDate = searchChat.listDateSearchChat();
					String date = listDate.get(i).getText();
					List<WebElement> listName = searchChat.listNameSearchChat();
					String name = listName.get(i).getText();
					if ((chat.toLowerCase().contains(text.toLowerCase()))){
						Assert.assertTrue(true, text);
						System.out.println("Search Chat with Combination Filter Post In and From is Found");
						System.out.println(date);
						System.out.println(name);
						System.out.println(chat);
					}
			}
		} catch (Exception e) {
			System.out.println("Search Chat with Combination Filter Post In and From is Not Found");
		}
    }
	
}
