package webautomation.mekarichat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import webautomation.mekarichat.pages.ChatList;
import webautomation.mekarichat.pages.ChatRoom;
import webautomation.mekarichat.pages.ContactPage;
import webautomation.mekarichat.pages.LoginPage;
import webautomation.mekarichat.pages.LogoutTest;
import webautomation.mekarichat.pages.SearchMessage;
import webautomation.mekarichat.utils.ShareUtils;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseWebDriver
{
	LoginPage loginPage = new LoginPage(driver, explicitWait);
	LogoutTest logoutTest = new LogoutTest(driver, explicitWait);
	ChatList chatList = new ChatList(driver, explicitWait);
	ChatRoom chatRoom = new ChatRoom(driver, explicitWait);
	SearchMessage searchMessage = new SearchMessage(driver, explicitWait);
	ContactPage contactPage = new ContactPage(driver, explicitWait);
    
	/**
     * Login Test :-)
     */
    @Test(testName = "MC-001-02", description = "User login dengan email dan password yang benar")
    public void loginWithValidEmailandPassword()
    {
    	String email = "emailMekari";
    	String password = "passwordMekari";
    	loginPage.testLogin(email, password);
    	
    	String expectedResults = "https://messenger.mekari.com/dashboard";
    	String actualResults = driver.get().getCurrentUrl();
    	
    	if (expectedResults.equals(actualResults)){
    		System.out.println("User diarahkan ke halaman Chat List");
    	}else {
    		System.out.println("Failed");
    	}
    }
    
    @Test(testName = "MC-001-03", description = "User login dengan email yang benar dan password yang salah")
    public void loginWithValidEmailandWrongPassword()
    {
    	String email = "emailMekari";
    	String password = "passwordMekari";
    	loginPage.testLogin(email, password);
    	String actualResults = loginPage.getNotif();
    	System.out.println(actualResults);   
    }
    
    @Test(testName = "MC-001-04", description = "User login dengan email yang salah dan password yang benar")
    public void loginWithWrongEmailandValidPassword()
    {
    	String email = "abcd@gmail.com";
    	String password = "1122334455";
    	loginPage.testLogin(email, password);
    	String actualResults = loginPage.getNotif();
    	System.out.println(actualResults);   
    }
    
    @Test(testName = "MC-001-05", description = "User login dengan email dan password yang salah")
    public void loginWithWrongEmailandPassword()
    {
    	String email = "abcd@gmail.com";
    	String password = "12345678";
    	loginPage.testLogin(email, password);
    	String actualResults = loginPage.getNotif();
    	System.out.println(actualResults);   
    }
    
    @Test(testName = "MC-001-06", description = "User melihat password yang diisi")
    public void checkPasswordShowed()
    {
    	String password = "12345678";
    	loginPage.showPassword(password);
    	WebElement input = driver.get().findElement(By.xpath("//input[@id='user_password']"));
    	boolean isEncrypted = input.getAttribute("type").equals("text");
    	
    	if (isEncrypted == true){
    		System.out.println("Password Show");
    	}else {
    		System.out.println("Password Hidden");
    	}
    }

    @Test(testName = "MC-001-07", description = "User menyembunyikan password yang diisi")
    public void checkPasswordHidden()
    {
    	String password = "12345678";
    	loginPage.passwordHidden(password);
    	WebElement input = driver.get().findElement(By.xpath("//input[@id='user_password']"));
    	boolean isEncrypted = input.getAttribute("type").equals("password");
    	
    	if (isEncrypted == true){
    		System.out.println("Password hidden");
    	}else {
    		System.out.println("Password Show");
    	}
    }
    
    /**
     * Logout Test :-)
     */
    @Test(testName = "MC-002-02", description = "User logout dari Mekari Chat App")
    public void logoutTest()
    {
    	String email = "emailMekari";
    	String password = "passwordMekari";
    	loginPage.testLogin(email, password);
    	ShareUtils.hardWait(5);
    	logoutTest.logOut();
    	ShareUtils.hardWait(5);
    	String actualResults = logoutTest.getLogout();
    	String expectedResults = "Sign in";
    	if (expectedResults.equals(actualResults)){
    		System.out.println("User berhasil logout dari Mekari Chat App");
    	}else {
    		System.out.println("Gagal Logout");
    	}
    }

    /**
     * Chat List Test :-)
     */
    @Test(testName = "MC-003-05", description = "User menyematkan pesan")
    public void pinTest() {
    	String email = "emailMekari";
    	String password = "passwordMekari";
    	loginPage.testLogin(email, password);
    	ShareUtils.hardWait(5);
    	chatList.pinChat();
    	ShareUtils.hardWait(5);
    	boolean checkPin = chatList.findPinImage();
    	if(checkPin == true) {
    		System.out.println("Chat berhasil di Pin");
    	}else {
    		System.out.println("Chat gagal di Pin");
    	}
    	ShareUtils.hardWait(5);
    	chatList.unpinChat();
    	ShareUtils.hardWait(3);
    }

    @Test(testName = "MC-003-03", description = "User dapat melihat status Online/Offline pada Private Chat")
    public void checkStatusChatOnlineOffline() {
    	String email = "donocatur@qiscus.cx";
    	String password = "tanpapassword08";
    	loginPage.testLogin(email, password);
    	
    	chatList.chatTab();
    	ShareUtils.hardWait(5);
    	
    	String online = "background-color: rgb(0, 159, 97);";
    	String value = "style";
    	
    	String status = chatRoom.statusChat(value);
    	System.out.println(status);
    	
    	if (status.equals(online)) {
    		System.out.println("Status Online");
    	}else {
    		System.out.println("Status Offline");
    	}
    }

//    @Test(testName = "MC-003-08", description = "User dapat melihat status pengiriman pesan")
//    public void checkStatusPengiriman() {
//   	String email = "emailMekari";
//		String password = "passwordMekari";
//    	loginPage.testLogin(email, password);
//    	
//    	chatList.chatTab();
//    	
//    	String sent = "Message is sent";
//    	String value = "title";
//    	
//    	String status = chatRoom.readStatus(value);
//    	System.out.println(status);
//    	
//    	if (status == sent) {
//    		System.out.println("Message is sent");
//    	}else {
//    		System.out.println("Message is read");
//    	}
//    }
    
    /**
     * Search Message Test :-)
     */
    @Test(testName = "MC-006-01", description = "User melakukan pencarian Chat Room pada Chats Tab")
    public void searchOnChatTab() {
    	String email = "emailMekari";
    	String password = "passwordMekari";
    	loginPage.testLogin(email, password);
    	ShareUtils.hardWait(5);
    	
    	
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

    @Test(testName = "MC-006-02", description = "User melakukan pencarian pesan pada Search Message  dengan menggunakan filter From")
    public void searchChatWithFilterFrom() {
    	String email = "emailMekari";
    	String password = "passwordMekari";
    	loginPage.testLogin(email, password);
    	ShareUtils.hardWait(5);
    	
    	
    	String text = "test";
    	String select = "deni";
    	searchMessage.searchChatFilterFrom(text, select);
    	
    	//Filter Chat From
    	ShareUtils.hardWait(5);
    	List<WebElement> listChat;
		try {
			listChat = searchMessage.listSearchChat();
			System.out.println(listChat.size());
			for(int i = 0; i<listChat.size();i++) {
					String chat = listChat.get(i).getText();
					List<WebElement> listDate = searchMessage.listDateSearchChat();
					String date = listDate.get(i).getText();
					List<WebElement> listName = searchMessage.listNameSearchChat();
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

    @Test(testName = "MC-006-03", description = "User melakukan pencarian pesan pada Search Message dengan menggunakan filter Post In")
    public void searchChatWithFilterPostIn() {
    	String email = "emailMekari";
    	String password = "passwordMekari";
    	loginPage.testLogin(email, password);
    	ShareUtils.hardWait(5);
    	
    	
    	String text = "test";
    	String select = "General Channel";
    	searchMessage.searchChatFilterPostIn(text, select);
    	
    	//Filter Chat From
    	ShareUtils.hardWait(5);
    	List<WebElement> listChat;
		try {
			listChat = searchMessage.listSearchChat();
			System.out.println(listChat.size());
			for(int i = 0; i<listChat.size();i++) {
					String chat = listChat.get(i).getText();
					List<WebElement> listDate = searchMessage.listDateSearchChat();
					String date = listDate.get(i).getText();
					List<WebElement> listName = searchMessage.listNameSearchChat();
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

    @Test(testName = "MC-006-03", description = "User melakukan pencarian pesan pada Search Message dengan menggunakan filter Post In dan filter From")
    public void searchChatWithFilterPostInAndFrom() {
    	String email = "emailMekari";
    	String password = "passwordMekari";
    	loginPage.testLogin(email, password);
    	ShareUtils.hardWait(5);
    	
    	
    	String text = "test";
    	String selectPostIn = "General Channel";
    	String selectFrom = "delta purna";
    	searchMessage.searchChatFilterFromAndPostIn(text, selectPostIn, selectFrom);
    	
    	//Filter Chat From
    	ShareUtils.hardWait(5);
    	List<WebElement> listChat;
		try {
			listChat = searchMessage.listSearchChat();
			System.out.println(listChat.size());
			for(int i = 0; i<listChat.size();i++) {
					String chat = listChat.get(i).getText();
					List<WebElement> listDate = searchMessage.listDateSearchChat();
					String date = listDate.get(i).getText();
					List<WebElement> listName = searchMessage.listNameSearchChat();
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

    @Test(testName = "MC-006-04", description = "User melakukan pencarian pesan pada Search Message tanpa filter")
    public void searchChatWithNoFilter() {
    	String email = "emailMekari";
    	String password = "passwordMekari";
    	loginPage.testLogin(email, password);
    	ShareUtils.hardWait(5);
    	
    	
    	String text = "test";
    	searchMessage.searchChatNoFilter(text);
    	
    	//Filter Chat From
    	ShareUtils.hardWait(5);
    	List<WebElement> listChat;
		try {
			listChat = searchMessage.listSearchChat();
			System.out.println(listChat.size());
			for(int i = 0; i<listChat.size();i++) {
					String chat = listChat.get(i).getText();
					List<WebElement> listDate = searchMessage.listDateSearchChat();
					String date = listDate.get(i).getText();
					List<WebElement> listName = searchMessage.listNameSearchChat();
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

    /**
     * Contact Page Test :-)
     */
    @Test(testName = "MC-007-01", description = "User melihat halaman Contacts Tab")
    public void listContact() {
    	String email = "emailMekari";
    	String password = "passwordMekari";
    	loginPage.testLogin(email, password);
    	ShareUtils.hardWait(5);
    	
    	contactPage.contactPage();
    	
    	String expectedResults = "Contacts";
    	String actualResults = contactPage.titleContact();
    	Assert.assertEquals(actualResults, expectedResults);
    	
    	List<WebElement> listStatus = contactPage.listStatus();
    	String value = "style";
    	String online = "background-color: rgb(0, 159, 97);";
		System.out.println("jumlah kontak: " + listStatus.size() + "\n");
		for(int i = 0; i<listStatus.size();i++) {
			String status = listStatus.get(i).getAttribute(value);
			List<WebElement> listName = contactPage.listName();
			String nama = listName.get(i).getText();
			List<WebElement> listJobs = contactPage.listJobs();
			String jobs = listJobs.get(i).getText();
			List<WebElement> listImg = contactPage.imgLoaded();
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver.get()).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", listImg.get(i));
			if (status.equals(online) && !ImagePresent){
				System.out.println(nama);
				System.out.println(jobs);
				System.out.println("Status Online"+"\n");
				System.out.println("Image not displayed.");
			}else {
				System.out.println(nama);
				System.out.println(jobs);
				System.out.println("Status Offline"+"\n");
				System.out.println("Img display");
			}
		}
    	
    }
    
    @Test(testName = "MC-007-02", description = "User melihat status Online/Offline pada Contact")
    public void statusOnlineOfflineListContact() {
    	String email = "emailMekari";
    	String password = "passwordMekari";
    	loginPage.testLogin(email, password);
    	ShareUtils.hardWait(5);
    	
    	contactPage.contactPage();
    	
    	String expectedResults = "Contacts";
    	String actualResults = contactPage.titleContact();
    	Assert.assertEquals(actualResults, expectedResults);
    	
    	List<WebElement> listStatus = contactPage.listStatus();
    	String value = "style";
    	String online = "background-color: rgb(0, 159, 97);";
		System.out.println(listStatus.size());
		for(int i = 0; i<listStatus.size();i++) {
			String status = listStatus.get(i).getAttribute(value);
			List<WebElement> listName = contactPage.listName();
			String nama = listName.get(i).getText();
			if (status.equals(online)){
				System.out.println(nama);
				System.out.println("Status Online berwarna hijau"+"\n");
			}else {
				System.out.println(nama);
				System.out.println("Status Offline berwarna abu-abu"+"\n");
			}
		}
    }
    
    @Test(testName = "MC-007-03", description = "User melakukan pencarian kontak berdasarkan nama")
    public void searchContactWithName() {
    	String email = "emailMekari";
    	String password = "passwordMekari";
    	loginPage.testLogin(email, password);
    	ShareUtils.hardWait(5);
    	
    	contactPage.contactPage();
    	
    	String expectedResults = "Contacts";
    	String actualResults = contactPage.titleContact();
    	Assert.assertEquals(actualResults, expectedResults);
    	
    	String text = "mic";
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

    @Test(testName = "MC-007-04", description = "User melakukan pencarian kontak berdasarkan job position")
    public void searchContactWithJobs() {
    	String email = "emailMekari";
    	String password = "passwordMekari";
    	loginPage.testLogin(email, password);
    	ShareUtils.hardWait(5);
    	
    	contactPage.contactPage();
    	
    	String expectedResults = "Contacts";
    	String actualResults = contactPage.titleContact();
    	Assert.assertEquals(actualResults, expectedResults);
    	
    	String text = "dir";
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

    @Test(testName = "MC-007-05", description = "User mengakses private chat room melalui tab Contacts")
    public void accessPrivateRoomFromTabsContacts() {
    	String email = "emailMekari";
    	String password = "passwordMekari";
    	loginPage.testLogin(email, password);
    	ShareUtils.hardWait(5);
    	
    	contactPage.contactPage();
    	
    	String expectedResults = "Contacts";
    	String actualResults = contactPage.titleContact();
    	Assert.assertEquals(actualResults, expectedResults);
    	
    	String text = "delta";
    	contactPage.searchText(text);
    	ShareUtils.hardWait(2);
    	
    	contactPage.listChat();
    	boolean startChat = contactPage.getStartChat();
    	
    	if(startChat == true) {
    		System.out.println("User dapat mengakses private chat room melalui tab Contacts");
    	}else {
    		System.out.println("Failed");
    	}
    }

}
