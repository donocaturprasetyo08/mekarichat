package webautomation.mekarichat;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseWebDriver implements DriverManager {
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
	
	@BeforeMethod
	public void createChromeDriver() {
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	driver.set(new ChromeDriver(options));
	driver.get().get("https://messenger.mekari.com/dashboard");
	driver.get().manage().window().maximize();
	explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(60)));
	}

	@AfterMethod
	public void quitChromeDriver() {
		driver.get().close();
	}
	
}
