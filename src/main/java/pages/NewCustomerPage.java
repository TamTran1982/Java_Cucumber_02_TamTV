package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.NewCustomerPageUI;

public class NewCustomerPage extends AbstractPage {
	WebDriver driver;

	public NewCustomerPage(WebDriver driver_) {
		this.driver = driver_;
	}
	
	public void inputCustName(String name) {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTNAME_TXT);
		ClearToElement(driver, NewCustomerPageUI.CUSTNAME_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.CUSTNAME_TXT, name);
	}
	
	public void inputDOB(String dob) {		
		ClearToElement(driver, NewCustomerPageUI.DOB_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.DOB_TXT, dob);
	}
	
	public void inputAddress(String address) {		
		ClearToElement(driver, NewCustomerPageUI.ADDRESS_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.ADDRESS_TXT, address);
	}
	
	public void inputCity(String city) {		
		ClearToElement(driver, NewCustomerPageUI.CITY_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.CITY_TXT, city);
	}
	
	public void inputState(String state) {		
		ClearToElement(driver, NewCustomerPageUI.STATE_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.STATE_TXT, state);
	}
	
	public void inputPin(String pin) {		
		ClearToElement(driver, NewCustomerPageUI.PIN_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.PIN_TXT, pin);
	}
	
	public void inputPhone(String phone) {		
		ClearToElement(driver, NewCustomerPageUI.PHONE_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.PHONE_TXT, phone);
	}
	
	public void inputEmail(String email) {		
		ClearToElement(driver, NewCustomerPageUI.EMAIL_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.EMAIL_TXT, email);
	}
	
	public void inputPassword(String password) {		
		ClearToElement(driver, NewCustomerPageUI.PASSWORD_TXT);
		sendkeyToElement(driver, NewCustomerPageUI.PASSWORD_TXT, password);
	}
	
	public void clickSubmitButton() {		
		clickToElement(driver, NewCustomerPageUI.SUBMIT_BTN);
	}
}
