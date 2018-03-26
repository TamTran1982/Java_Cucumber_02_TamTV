package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class EditCustomerPage extends AbstractPage{
	WebDriver driver;

	public EditCustomerPage(WebDriver driver_) {
		this.driver = driver_;
	}
}
