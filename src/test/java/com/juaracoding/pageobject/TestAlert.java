package com.juaracoding.pageobject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.SampleAlert;

public class TestAlert {

	public static WebDriver driver;
	private SampleAlert sampleAlert;

	@BeforeClass
	public void setUp() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://demoqa.com/alerts";
		driver.get(url);
	}

	@BeforeMethod
	public void pageObject() {
		sampleAlert = new SampleAlert();
	}

	@Test
	public void testAlertOne() {
		sampleAlert.clickMe();

		String txtAlert = driver.switchTo().alert().getText();
		delay(1);
		driver.switchTo().alert().accept();
//		driver.switchTo().alert().dismiss();
		System.out.println(sampleAlert.getTxtConfirmResult());
		System.out.println(txtAlert);
		String txt = sampleAlert.getTxtConfirmResult();
		assertTrue(txt.contains("Ok"));
		assertEquals(false, false);
	}

	@Test
	public void testAlertTwo() {
		scroll(700);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebElement promptbutton = driver.findElement(By.xpath("//button[@id='promtButton']"));
//		js.executeScript("arguments[0].scrollIntoView()", promptbutton);
		sampleAlert.clickMeTwo();
		delay(1);
		driver.switchTo().alert().sendKeys("Bana QA Engineer");
		delay(1);
		driver.switchTo().alert().accept();
		System.out.println(sampleAlert.getTxtPromptResult());
		String txt = sampleAlert.getTxtPromptResult();
		assertTrue(txt.contains("Bana"));
		
	}

	@AfterClass
	public void closeBrowser() {
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
	
	static void scroll(int vertical) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+vertical+")");
	}

}
