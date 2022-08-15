package com.juaracoding.pageobject.main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.LoginPage;
import com.juaracoding.pageobject.pages.Register;

public class MainApp {

	public static void main(String[] args) {
		DriverSingleton.getInstance("Chrome");
		WebDriver driver = DriverSingleton.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String url = "https://shop.demoqa.com/my-account/";
		driver.get(url);
		
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		js.executeScript("arguments[0].scrollIntoView()", username);
		
		//login failed
		LoginPage loginPage = new LoginPage();
		loginPage.login("Admin","admin1234");
		System.out.println("Duh! Login kamu gagal! Coba Register dulu deh ..");
		
		WebElement userregist = driver.findElement(By.xpath("//input[@id='reg_username']"));
		js.executeScript("arguments[0].scrollIntoView()", userregist);
		
		//attempt to register
		Register register = new Register();
		register.register("Banazh","bana9988b@gmail.com","Abcde@123");
		System.out.println("Hore! Registrasi kamu Sukses!");

		delay(3);
		driver.quit();
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
