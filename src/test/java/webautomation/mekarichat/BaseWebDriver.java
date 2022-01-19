package webautomation.mekarichat;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeSuite;

import com.google.common.collect.ImmutableMap;

import io.github.bonigarcia.wdm.WebDriverManager;
import webautomation.mekarichat.pages.LoginPage;
import webautomation.mekarichat.utils.DataUtils;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class BaseWebDriver implements DriverManager {
	
	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	protected ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
	LoginPage loginPage = new LoginPage(driver, explicitWait);
	

	public void login() {
		String email = DataUtils.emailMekari;
    	String password = DataUtils.passwordMekari;
    	loginPage.inputEmailPassword(email, password);
	}
	
	public void createChromeDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    options.setExperimentalOption("prefs", prefs);
		driver.set(new ChromeDriver(options));
		driver.get().manage().window().maximize();
		explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(60)));
	}
	
	

	public synchronized static WebDriver getDriver() {
        return driver.get();
    }
	
	@BeforeClass
	public void setupBase() {
	createChromeDriver();
	getDriver().get("https://messenger.mekari.com/dashboard");
	login();
	}
	
	@AfterClass
	public void quitBase() {
		driver.get().close();
	}
	
	@BeforeSuite
    public void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Chrome")
                        .put("Browser.Version", "96.0.4664.93")
                        .put("Stand", "Production")
                        .put("URL", "https://messenger.mekari.com/dashboard")
                        .build(), System.getProperty("user.dir")
                        + "/allure-results/");
    }	
}
