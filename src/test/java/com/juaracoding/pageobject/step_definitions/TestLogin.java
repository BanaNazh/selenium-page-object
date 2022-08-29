package com.juaracoding.pageobject.step_definitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.LoginPage;
import com.juaracoding.pageobject.utils.Constants;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestLogin {

	public static WebDriver driver;
	private LoginPage loginPage = new LoginPage();

	public TestLogin() {
		driver = Hooks.driver;
	}

	@When("User go to Web HRM")
	public void user_go_to_Web_HRM() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
	}

	@And("User enter username and password")
	public void user_enter_username_and_password() {
		loginPage.login("Admin", "admin1234");
		assertEquals(loginPage.msgInvalid(), "Invalid credentials");

	}

	@And("User click button login")
	public void user_click_button_login() {

	}

	@Then("User invalid credentials")
	public void user_invalid_credentials() {
		assertEquals(loginPage.msgInvalid(), "Invalid credentials");
	}

//	@Test
//	public void emptyLogin() {
//		loginPage.login("", "");
//		assertEquals(loginPage.getTxtEmpty(), "Username cannot be empty");
//	}		

	@When("User enter username and password valid")
	public void user_enter_username_and_password_valid() {
		loginPage.login("Admin", "admin123");

	}

	@And("User click button login valid")
	public void user_click_button_login_valid() {

	}

	@Then("User valid credentials valid")
	public void user_valid_credentials_valid() {

	}

	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
