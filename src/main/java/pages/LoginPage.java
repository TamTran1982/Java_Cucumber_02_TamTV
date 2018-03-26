package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageFactoryManager;
import interfaces.LoginPageUI;

public class LoginPage extends AbstractPage {
	WebDriver driver;	
	
	public LoginPage(WebDriver driver_) {
		this.driver = driver_;
	}

	public String getURL() {
		return getCurrentURL(driver);
	}

	public RegisterPage clickHereLink() {
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageFactoryManager.getRegisterPage(driver);
	}

	public void inputUsername(String username) {
		waitForElementVisible(driver, LoginPageUI.USERNAME_TXT);
		sendkeyToElement(driver, LoginPageUI.USERNAME_TXT, username);
	}

	public void inputPassword(String password) {
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TXT, password);
	}

	public HomePage clickLoginButton() {
		clickToElement(driver, LoginPageUI.LOGIN_BTN);
		return PageFactoryManager.getHomePage(driver);
	}

}
