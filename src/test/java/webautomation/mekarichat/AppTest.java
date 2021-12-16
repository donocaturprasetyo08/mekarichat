package webautomation.mekarichat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import webautomation.mekarichat.pages.ChatListPage;
import webautomation.mekarichat.pages.ChatRoom;
import webautomation.mekarichat.pages.ContactPage;
import webautomation.mekarichat.pages.LoginPage;
import webautomation.mekarichat.pages.LogoutTest;
import webautomation.mekarichat.pages.SearchMessagePage;
import webautomation.mekarichat.utils.ShareUtils;

/**
 * Unit test for simple App.
 */
@Listeners({TestAllureListener.class})
public class AppTest extends BaseWebDriver
{
	LoginPage loginPage = new LoginPage(driver, explicitWait);
	LogoutTest logoutTest = new LogoutTest(driver, explicitWait);
	ChatListPage chatList = new ChatListPage(driver, explicitWait);
	ChatRoom chatRoom = new ChatRoom(driver, explicitWait);
	SearchMessagePage searchMessage = new SearchMessagePage(driver, explicitWait);
	ContactPage contactPage = new ContactPage(driver, explicitWait);
    
    public void listContactSortByAlphabet() {
    	String email = "donocatur@qiscus.cx";
    	String password = "tanpapassword08";
    	loginPage.inputEmailPassword(email, password);
    	ShareUtils.hardWait(5);
    	
    	contactPage.contactPage();
    	
    	String expectedResults = "Contacts";
    	String actualResults = contactPage.titleContact();
    	Assert.assertEquals(actualResults, expectedResults);
    	
    	List<WebElement> listName = contactPage.listName();
		System.out.println("jumlah kontak: " + listName.size() + "\n");
		List<String> beforeFilter = new ArrayList<String>();
		for(WebElement ele : listName) {
			beforeFilter.add(ele.getText());
		}
		List<String> originalList = new ArrayList<String>(beforeFilter);
		
		System.out.println(originalList);
		
		Collections.sort(beforeFilter);
		System.out.println(beforeFilter);
			if (beforeFilter.equals(originalList)){
				System.out.println("Urut secara Alphabet");
			}else {
				System.out.println("Tidak Urut secara Alphabet");
			}	
    }

}
