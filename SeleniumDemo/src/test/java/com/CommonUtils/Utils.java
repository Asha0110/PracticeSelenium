package com.CommonUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utils  {
	public WebDriver driver;

	public Utils(WebDriver driver) { // constructor
		this.driver = driver;
	}

	public WebDriver startBrowser(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {
			String absoPath = System.getProperty("user.dir");
			System.out.println(absoPath);
			// String relativePath = "src/test/resources/Drivers.chromedriver.exe";//
			// relative path
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
			// WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
		} else {
			System.out.println("wrong browser enter");
		}

		return driver;

	}

	public void customWait(double inSecs) {
		try {
			Thread.sleep((long) (inSecs * 1000));
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void takeScreenShot(String testStatus) throws IOException {
		Date dt = new Date();
		System.out.println("date: " + dt);
		String dat = dt.toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// String abos = System.getProperty("user.dir");
		// String destinFile = "pictures/screenShot.jpg";
		FileHandler.copy(source, new File("./pictures/" + testStatus + "/" + dat + ".jpg"));

	}

}
