package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.HomePageUI;
import interfaces.RegisterPageUI;

public class HomePage extends AbstractPage {
	WebDriver driver;

	public HomePage(WebDriver driver_) {
		this.driver = driver_;
	}

	public String getWelcomeHomepageMessage() {
		waitForElementVisible(driver, HomePageUI.WELCOME_HOMEPAGE_MSG);
		return getTextElement(driver, HomePageUI.WELCOME_HOMEPAGE_MSG);
	}

}
