package sotest.base;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import sotest.driver.ThreadWebDriver;

public abstract class BaseTest {

	@BeforeClass
	public static void setup() {
		if(ThreadWebDriver.get() == null) {
			//Incognito mode
			//ChromeOptions options = new ChromeOptions();  
			//options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");  
			//options.setExperimentalOption("useAutomationExtension", false);
			//WebDriver driver = new ChromeDriver(options);
			
			//Mentioned in pom.xml. Uncomment to run individually.
			//System.setProperty("webdriver.chrome.driver", "Chrome Driver Location Here or in POM.xml");
			ChromeOptions options = new ChromeOptions();
			//Cannot use user dir in parallel
			//options.addArguments("user-data-dir=C:/Chrome/User Data");
			WebDriver driver = new ChromeDriver(options);
			ThreadWebDriver.set(driver);
		}
	}

	@AfterClass
	public static void teardown() {
		ThreadWebDriver.get().quit();
		ThreadWebDriver.remove();
	}

}
