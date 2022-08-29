package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class BuzzPage {
	private WebDriver driver;

	public BuzzPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='oxd-main-menu-item active']")
	private WebElement menuBuzz;

	@FindBy(xpath = "//h4[@class='oxd-text oxd-text--h4 orangehrm-module-under-development-heading']")
	private WebElement txtBuzzPage;

	public void goToMenuBuzz() {
		menuBuzz.click();
	}

	public String getTxtMenuBuzz() {
		return txtBuzzPage.getText();
	}

}
