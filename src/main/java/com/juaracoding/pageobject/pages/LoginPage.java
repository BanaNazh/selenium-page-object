package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class LoginPage {

	private WebDriver driver;

	public LoginPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	//input[contains(@attr, 'value')]
	private WebElement username;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnLogin;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement msgError;

	@FindBy(xpath = "//h1[normalize=space()='Dashboard']")
	private WebElement txtDashboard;
	
	@FindBy (xpath = "//span[@id='spanMessage']")
	private WebElement txtEmpty;

	// Scenario
	public void login(String username, String password) {
		this.username.sendKeys(username);// step
		this.password.sendKeys(password);
		btnLogin.click();
		
	}
	
	public void clickBtnLogin() {
		btnLogin.click();
	}

	// Actual
	public String msgInvalid() {
		return msgError.getText();
	}

	public String getTxtDashboard() {
		return txtDashboard.getText();
	}
	
	public String getTxtEmpty() {
		return txtEmpty.getText();
	}

}
