package com.CommonUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Base {

	public static WebDriver driver;
	public static Utils ut;
	public static Properties pro;
	String websiteurl;

	@BeforeMethod
	public void setUp() {
		ut = new Utils(driver);
		driver = ut.startBrowser("Chrome");
		driver.get(websiteurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@BeforeClass
	public void beforeClass() throws IOException {
		try {

			// String path =
			// "C:\\Users\\asha_\\eclipse-workspace_PNT\\SeleniumDemo\\src\\test\\resources\\config.properties";
			String path = "src/test/resources/config.properties";
			FileInputStream input = new FileInputStream(path);
			pro = new Properties();
			pro.load(input);// getting data.....

			websiteurl = pro.getProperty("Url");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	@AfterMethod
	public void tearDown() {
		try {
			if (driver != null) {
				driver.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		try {
			if (driver != null) {
				driver.quit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
