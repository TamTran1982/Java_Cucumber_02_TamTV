package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageFactoryManager;
import interfaces.RegisterPageUI;

public class RegisterPage extends AbstractPage {
	WebDriver driver;	
	
	public RegisterPage(WebDriver driver_) {
		this.driver = driver_;
	}

	public void inputEmail(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TXT);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TXT, email);
	}

	public void clickSubmitButton() {
		clickToElement(driver, RegisterPageUI.LOGIN_BTN);

	}

	public String getUsername() {
		waitForElementVisible(driver, RegisterPageUI.USERNAME_TXT);
		return getTextElement(driver, RegisterPageUI.USERNAME_TXT);
	}

	public String getPassword() {		
		return getTextElement(driver, RegisterPageUI.PASSWORD_TXT);
	}

	public LoginPage openLoginPage(String loginURL) {
		openAnyURL(driver, loginURL);
		return PageFactoryManager.getLoginPage(driver);
	}

}
