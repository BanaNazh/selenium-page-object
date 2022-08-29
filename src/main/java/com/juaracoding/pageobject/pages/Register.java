package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class Register {
	
	private WebDriver driver;
	
	public Register() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='reg_username']")
	private WebElement userRegist;
	
	@FindBy(xpath = "//input[@id='reg_email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='reg_password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@name='register']")
	private WebElement btnRegist;
	
	//scenario
	public void register(String userRegist, String email, String password) {
		this.userRegist.sendKeys(userRegist);
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		btnRegist.click();
	}

}
