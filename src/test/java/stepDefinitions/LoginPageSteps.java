package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageSteps {
	private WebDriver driver;

	@Given("^I navigate to bank guru site$")
	public void i_navigate_to_bank_gu_ru_site() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4");
	}

	@When("^I input username and password$")
	public void i_input_username_and_password() {
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr123331");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("veqUdeg");

	}

	@When("^I click to Login button$")
	public void i_click_to_Login_button() {
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}

	@Then("^I verify Homepage displayed$")
	public void i_verify_Homepage_displayed() {
		WebElement welcome = driver
				.findElement(By.xpath("//marquee[contains(text(), \"Welcome To Manager's Page of Guru99 Bank\")]"));
		Assert.assertTrue(welcome.isDisplayed());
	}

	@And("^I quit browser$")
	public void i_quit_browser() {
		driver.quit();
	}

}
