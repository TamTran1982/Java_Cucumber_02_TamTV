package commons;

import org.openqa.selenium.WebDriver;

import pages.DeleteCustomerPage;
import pages.EditCustomerPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NewCustomerPage;
import pages.RegisterPage;

public class PageFactoryManager {
	private static HomePage homePage;
	private static LoginPage loginPage;
	private static RegisterPage registerPage;
	private static NewCustomerPage newCustomerPage;
	private static EditCustomerPage editCustomerPage;
	private static DeleteCustomerPage deleteCustomerPage;	

	public static HomePage getHomePage(WebDriver driver) {
		if (homePage == null) {
			return new HomePage(driver);
		}
		return homePage;
	}

	public static LoginPage getLoginPage(WebDriver driver) {
		if (loginPage == null) {
			return new LoginPage(driver);
		}
		return loginPage;
	}

	public static RegisterPage getRegisterPage(WebDriver driver) {
		if (registerPage == null) {
			return new RegisterPage(driver);
		}
		return registerPage;
	}

	public static NewCustomerPage getNewCustomerPage(WebDriver driver) {
		if (newCustomerPage == null) {
			return new NewCustomerPage(driver);
		}
		return newCustomerPage;
	}
	
	public static EditCustomerPage getEditCustomerPage(WebDriver driver) {
		if (editCustomerPage == null) {
			return new EditCustomerPage(driver);
		}
		return editCustomerPage;
	}
	
	public static DeleteCustomerPage getDeleteCustomerPage(WebDriver driver) {
		if (deleteCustomerPage == null) {
			return new DeleteCustomerPage(driver);
		}
		return deleteCustomerPage;
	}
	
}

