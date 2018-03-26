package commons;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.DeleteCustomerPage;
import pages.EditCustomerPage;
import pages.NewCustomerPage;

public class AbstractPage {

	// Web browser
	public void openAnyURL(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	// Web element
	public void clickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String text) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(text);
	}
	
	public void ClearToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String item) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(item);
	}

	public String getFirstItemSelected(WebDriver driver, String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}

	public String getAttributeElement(WebDriver driver, String locator, String attributeName) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlDisplayed(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlEnabled(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void acceptJsAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelJsAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextJsAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void switchToChildWindow(WebDriver driver, String parent) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parent)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(expectedTitle)) {
				break;
			}
		}
	}

	public boolean closeAllWithoutParentWindow(WebDriver driver, String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentWindow)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public Object highlightElement(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].style.border='6px groove red'", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object executeForWebBrowser(WebDriver driver, String javaSript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object executeForWebElementByClick(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object removeAttributeInDOM(WebDriver driver, WebElement element, String attribute) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		By by = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitForElementVisible(WebDriver driver, String locator, String value) {
		// locator: //a[text()='%s']
		// value: New Customer
		locator = String.format(locator, value);
		// locator: //a[text()='New Customer']
		By by = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitForElementNotVisible(WebDriver driver, String locator) {
		By by = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	/* ---- OPEN DYNAMIC MENU PAGE ---- */
	public NewCustomerPage openNewCustomerPage(WebDriver driver) {
		waitForElementVisible(driver, interfaces.AbstractPageUI.DYNAMIC_MENU_PAGE, "New Customer");
		clickToElement(driver, interfaces.AbstractPageUI.DYNAMIC_MENU_PAGE, "New Customer");
		return PageFactoryManager.getNewCustomerPage(driver);
	}
	
	public EditCustomerPage openEditCustomerPage(WebDriver driver) {
		waitForElementVisible(driver, interfaces.AbstractPageUI.DYNAMIC_MENU_PAGE, "Edit Customer");
		clickToElement(driver, interfaces.AbstractPageUI.DYNAMIC_MENU_PAGE, "Edit Customer");
		return PageFactoryManager.getEditCustomerPage(driver);
	}

	public DeleteCustomerPage openDeleteCustomerPage(WebDriver driver) {
		waitForElementVisible(driver, interfaces.AbstractPageUI.DYNAMIC_MENU_PAGE, "Delete Customer");
		clickToElement(driver, interfaces.AbstractPageUI.DYNAMIC_MENU_PAGE, "Delete Customer");
		return PageFactoryManager.getDeleteCustomerPage(driver);
	}
	
}
