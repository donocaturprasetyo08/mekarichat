package webautomation.mekarichat.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import webautomation.mekarichat.navigation.BasePage;
import webautomation.mekarichat.utils.TestData;
import webautomation.mekarichat.utils.TimesUtils;

public class ChannelsInfoPage extends BasePage{
		
		By img = By.xpath("//img[@class='rounded-circle img-pic']");
		By name = By.xpath("//span[@class='font-weight-bold text-center']");
		By member = By.xpath("//div[@class='d-flex flex-row mt-1']//span[@class='text-slate']");
		By channelType = By.xpath("//span[normalize-space()='"+TestData.channelTypes+"']");
		By whoCanInviteorRemove = By.xpath("//span[normalize-space()='"+TestData.whoInvite+"']");
		By changeChannelType = By.xpath("//span[normalize-space()='"+TestData.changeChannelTypes+"']");
		By changeWhoCanInviteorRemove = By.xpath("//span[normalize-space()='"+TestData.changeWhoInvite+"']");
		By verifyName = By.xpath("//div[normalize-space()='"+TestData.nameChannel+"']");
		By verifyChangeName = By.xpath("//div[normalize-space()='"+TestData.changeNameChannel+"']");
		By purpose = By.xpath("//p[@class='text-slate text-center']");
		
		//Media
		By viewAll = By.xpath("//span[@class='text-link']");
		
		//joined
		By listJoined = By.xpath("//body/div[@id='app']/div[@class='min-vh-100 bg-cloud d-flex flex-column']/div[@class='ml-3 mr-3 bg-white row border-1-smoke']/div[@class='d-flex flex-fill']/div[@class='d-flex flex-fill']/div[@id='content']/div/div[@class='d-flex flex-column']/div[@class='d-flex flex-column margin-horizontal-small']/div/div");
		
		//scroll
		By leave = By.xpath("//button[@class='btn bg-cloud d-flex align-items-center justify-content-center mb-4 mt-4']");
		
		//edit channel
		By modalEdit = By.xpath("//div[@class='modal-dialog']");
		By buttonEdit = By.xpath("//span[@class='ic ic-edit']");
		By changeName = By.xpath("//input[@id='channelName']");
		By changeType = By.xpath("//select[@id='channelType']");
		By changeRole = By.xpath("//select[@id='inviteRole']");
		By changePurpose = By.xpath("//textarea[@id='purpose']");
		By buttonSave = By.xpath("//button[normalize-space()='Save']");
		By buttonCancel = By.xpath("//button[normalize-space()='Cancel']");
		By buttonClose = By.xpath("//span[@aria-hidden='true']");

	public ChannelsInfoPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	
	@Step("# verify profile picture displayed")
	public boolean verifyPictureDisplayed() {
		return displayElement(img);
	}
	
	@Step("# verify url profile picture")
	public boolean verifyPictureUrl(String value, String contains) {
		return getAttributeVerify(img, value, contains);
	}
	
	@Step("# verify name on channel info displayed")
	public boolean verifyName() {
		return displayElement(name);
	}
	
	public String verifyNameChannel() {
		return getText(name);
	}
	
	@Step("# verify total member on channel info displayed")
	public String verifyMemberDisplayed() {
		return getText(member);
	}
	
	@Step("# verify name channel on channel info same with name channel on header chat room")
	public String verifyNameHeader() {
		return getText(verifyName);
	}
	
	@Step("# verify name channel on channel info same with name channel on header chat room after change")
	public String verifyNameHeaderAfterChange() {
		return getText(verifyChangeName);
	}
	
	@Step("# verify channel type on channel info displayed")
	public boolean verifyChannelTypeDisplayed() {
		return displayElement(channelType);
	}
	
	@Step("# verify who can invite/remove on channel info displayed")
	public boolean verifyWhoDisplayed() {
		return displayElement(whoCanInviteorRemove);
	}
	
	public List<WebElement> getListJoined(){
		return getList(listJoined);
	}
	@Step("# verify button cancel on edit channel is working")
	public void editChannel() {
		clickAndWaitByXpath(buttonEdit);
	}
	@Step("# verify button cancel on edit channel is working")
	public void cancelEdit() {
		clickAndWaitByJavaScript(buttonCancel);
	}
	@Step("# verify button close on edit channel is working")
	public void closeEdit() {
		clickAndWaitByJavaScript(buttonClose);
	}
	public void saveEdit() {
		clickAndWaitByJavaScript(buttonSave);
	}
	@Step("# verify modal edit channel")
	public boolean verifyModalEdit() {
		return displayElement(modalEdit);
	}
	
	@Step("# change text channel name")
	public void changeTextChannelName(String text) {
		changeText(changeName, text);
	}
	@Step("# change channel type")
	public void changeChannelType(String select) {
		selectDropdown(changeType, select);
	}
	@Step("# change who can invite/remove to channel")
	public void changeWhoInvite(String select) {
		selectDropdown(changeRole, select);
	}
	@Step("# change text purpose")
	public void changeTextPurpose(String text) {
		setText(changePurpose, text);
	}
	@Step("# verfy change name is working")
	public String verifyChangeName() {
		return getText(name);
	}
	@Step("# verfy change channel type is working")
	public String verifyChangeType() {
		return getText(changeChannelType);
	}
	@Step("# verfy change who can invite/remove to channel is working")
	public String verifyChangWhoInvite() {
		return getText(changeWhoCanInviteorRemove);
	}
	@Step("# verify purpose edit channel")
	public boolean verifyPurpose() {
		return displayElement(purpose);
	}
	public void backToDefault(String text, String select1, String select2) {
		changeText(changeName, text);
		TimesUtils.hardWait(1);
		selectDropdown(changeType, select1);
		TimesUtils.hardWait(1);
		selectDropdown(changeRole, select2);
		TimesUtils.hardWait(1);
		clearText(changePurpose);
		TimesUtils.hardWait(2);
		clickAndWaitByJavaScript(buttonSave);
	}
}
