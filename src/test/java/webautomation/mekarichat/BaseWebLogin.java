package webautomation.mekarichat;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.google.common.collect.ImmutableMap;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseWebLogin implements DriverManagerLogin {
	
	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	protected ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();

	public void createChromeDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		driver.set(new ChromeDriver(options));
		driver.get().manage().window().maximize();
		explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(60)));
	}
	
	public synchronized static WebDriver getDriver() {
        return driver.get();
    }
	
	@BeforeMethod
	public void setupBase() {
	createChromeDriver();
	getDriver().get("https://messenger.mekari.com/dashboard");
	}
	
	@AfterMethod
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