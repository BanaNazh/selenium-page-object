package com.juaracoding.pageobject.step_definitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.juaracoding.pageobject.pages.BuzzPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestBuzz {
	WebDriver driver;
	private BuzzPage buzzPage = new BuzzPage();

	public TestBuzz() {
		driver = Hooks.driver;
	}

	@When("User click menu Buzz")
	public void User_click_menu_Buzz() {
		buzzPage.goToMenuBuzz();

	}

	@Then("User on menu Buzz")
	public void User_on_menu_Buzz() {
		assertEquals(buzzPage.getTxtMenuBuzz(), "Launching Soon");
	}
}
