package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class DeleteCustomerPage extends AbstractPage{
	WebDriver driver;

	public DeleteCustomerPage(WebDriver driver_) {
		this.driver = driver_;
	}
}
