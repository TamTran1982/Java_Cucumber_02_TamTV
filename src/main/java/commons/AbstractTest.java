package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class AbstractTest {
	protected WebDriver driver;
	public final Log log;

	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver openMultiBrowser(String browser, String version) {
		if (browser.equalsIgnoreCase("Firefox")) {
			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			ChromeDriverManager.getInstance().version(version).setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			InternetExplorerDriverManager.getInstance().version(version).setup();
			driver = new InternetExplorerDriver();
		}
		driver.get(Constants.BANK_URL);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public String rand_Data() {
		Random rand = new Random();
		int temp = rand.nextInt(999999) + 1;
		String numberString = Integer.toString(temp);
		return numberString;
	}

	protected boolean verifyPassed(boolean condition, boolean flag) {
		boolean pass = true;
		if (flag == false) {
			try {
				if (condition == true)
					log.info("===PASSED===");
				else
					log.info("===FAILED===");
				Assert.assertTrue(condition);
			} catch (Throwable e) {
				pass = false;
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		} else {
			Assert.assertTrue(condition);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return verifyPassed(condition, false);
	}

	protected boolean verifyFailed(boolean condition, boolean flag) {
		boolean pass = true;
		if (flag == false) {
			try {
				if (condition == false)
					log.info("===PASSED===");
				else
					log.info("===FAILED===");
				Assert.assertFalse(condition);
			} catch (Throwable e) {
				pass = false;
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		} else {
			Assert.assertFalse(condition);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return verifyFailed(condition, false);
	}

	protected boolean verifyEquals(Object actual, Object expected, boolean flag) {
		boolean pass = true;
		if (flag == false) {
			try {
				Assert.assertEquals(expected, actual);
			} catch (Throwable e) {
				pass = false;
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		} else {
			Assert.assertEquals(expected, actual);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return verifyEquals(actual, expected, false);
	}

	public void closeBrowser() {
		try {
			driver.quit();
			if (driver.toString().toLowerCase().contains("chrome")) {
				String cmd = "taskkill /IM chromedriver.exe /F";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			if (driver.toString().toLowerCase().contains("internetexplorer")) {
				String cmd = "taskkill /IM IEDriverServer.exe /F";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
