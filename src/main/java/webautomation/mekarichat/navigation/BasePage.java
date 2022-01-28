package webautomation.mekarichat.navigation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Attachment;
import webautomation.mekarichat.utils.TimesUtils;

public class BasePage {
	
	protected ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	protected ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
	
	public BasePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		this.driver = driver;
		this.explicitWait = explicitWait;
	}
	
	protected final void clickAndWaitByXpath(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		driver.get().findElement(locator).click();
	}
	
	protected final void clickAndWaitByJavaScript(By locator) {
		WebElement element = driver.get().findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver.get();  
		js.executeScript("arguments[0].click();", element);
	}
	
	protected final void setText(By locator, String text) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		driver.get().findElement(locator).sendKeys(text);
	}
	protected final void changeText(By locator, String text) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		driver.get().findElement(locator).clear();
		driver.get().findElement(locator).sendKeys(text);
	}
	protected final void clearText(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		driver.get().findElement(locator).clear();
	}

	protected final String getText(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		return driver.get().findElement(locator).getText();
	}
	protected final void scrollUntilElement(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = driver.get().findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver.get();  
		js.executeScript("return arguments[0].scrollIntoView();", element);
	}
	protected final void changePicture(By locator, String location) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		WebElement uploadElement = driver.get().findElement(locator);
		uploadElement.sendKeys(location);
	}
	protected final void uploadPicture(By locator, String location) {
		WebElement element = driver.get().findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver.get();  
		js.executeScript("arguments[0].style.display='block';", element);
		element.sendKeys(location);
	}
	protected final void playVideo(By locator) {
		WebElement video = driver.get().findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver.get();  
		js.executeScript("return arguments[0].play()", video);
	}
	protected final void pauseVideo(By locator) {
		WebElement video = driver.get().findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver.get();  
		js.executeScript("return arguments[0].pause()", video);
	}
	protected final boolean verifyStatusVideo(By locator) {
		WebElement video = driver.get().findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver.get();  
		boolean ImagePresent = (boolean) js.executeScript("return arguments[0].paused", video);
		return ImagePresent;
	}
	protected final void changePictureJavaexecutor(By locator, String location) {
		//explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = driver.get().findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		js.executeScript("arguments[0].style.display='block';", element);
		element.sendKeys(location);
		js.executeScript("arguments[0].style.display='none!important';", element);	
	}
	protected final void changeVisibility(By locator) {
		WebElement element = driver.get().findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		js.executeScript("arguments[0].style.visibility='visible';", element);
	}
	protected final void setStyle(By locator) {
		WebElement element = driver.get().findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		js.executeScript("arguments[0].setAttribute('style', 'visibility:visible')", element);
	}
	protected final void selectDropdown(By locator, String select) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		Select clickData = new Select(driver.get().findElement(locator));
		clickData.selectByVisibleText(select);
	}
	protected final void selectCheckbox(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = driver.get().findElement(locator);
		element.click();
	}
	protected final String getLink(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = driver.get().findElement(locator);
		return element.getAttribute("href");
	}
	
	protected final String getLinkSrc(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = driver.get().findElement(locator);
		return element.getAttribute("src");
	}
	protected final String getCssValue(By locator, String value) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = driver.get().findElement(locator);
		return element.getCssValue(value);
	}
	
	protected final void searchText(By locator, String text) {
		//explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(text);
		TimesUtils.hardWait(2);
		element.sendKeys(Keys.RETURN);
	}
	protected final List<WebElement> getList(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		List<WebElement> listData = driver.get().findElements(locator);
		return listData;
	}
	protected final boolean displayElement(By locator) {
		try {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		return driver.get().findElement(locator).isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	protected final boolean selectElement(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		return driver.get().findElement(locator).isSelected();
	}
	protected final boolean enableElement(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		return driver.get().findElement(locator).isEnabled();
	}
	protected final String getAttribute(By locator, String value) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		return driver.get().findElement(locator).getAttribute(value);
	}
	
	protected final boolean getAttributeVerify(By locator, String value, String contains) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		return driver.get().findElement(locator).getAttribute(value).contains(contains);
	}
	
	protected final boolean findImgLoaded(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		WebElement ImageFile = driver.get().findElement(locator);
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver.get()).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
		return ImagePresent;
	} 
	
	protected String getUrl() {
		return driver.get().getCurrentUrl();
	}
	
	protected String getTitle() {
		return driver.get().getTitle();
	}
	
	protected final boolean passwordHidden(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		WebElement input = driver.get().findElement(locator);
    	boolean isEncrypted = input.getAttribute("type").equals("password");
		return isEncrypted;
	}
	
	protected final boolean passwordShowed(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		WebElement input = driver.get().findElement(locator);
    	boolean isEncrypted = input.getAttribute("type").equals("text");
		return isEncrypted;
	}
	
	protected final void sendText(By locator) {
		explicitWait.get().until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(Keys.ENTER);
	}
	protected final void moveCursor(By locator) {
		Actions actions = new Actions(driver.get());
		WebElement element = driver.get().findElement(locator);
		actions.moveToElement(element).perform();
	}
	
	@Attachment(value = "Screenshot", type = "image/png")
	public byte[] screenshot() {
	    return ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.BYTES);
	}
	
}
