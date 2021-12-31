package com.demo.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.CommonUtils.Base;

public class LandingPage extends Base{
	
	public LandingPage validateTitle() {
		String actual = driver.getTitle();
		String expected = "GTPL Bank Home Page";
		Assert.assertEquals(actual, expected);
		return this;
	}
	
	public LandingPage sendUserId() {
		WebElement user = driver.findElement(By.xpath("//*[@name='uid']"));
		//user.sendKeys("mngr376993");
		String userID= pro.getProperty("user");
		user.sendKeys(userID);
		return this;
	}
	public LandingPage sendPassWord() {
		WebElement passWord = driver.findElement(By.xpath("//*[@name='password']"));
		//passWord.sendKeys("azuhYpE");
		String passW = pro.getProperty("password");
		passWord.sendKeys(passW);
		return this;
	}
	public LandingPage clickLogin() {
		WebElement login= driver.findElement(By.xpath("//*[@name='btnLogin']"));
		login.click();
		boolean loginVerify=driver.findElement(By.xpath("//*[text()='Log out']")).isDisplayed();
		System.out.println(loginVerify);
		assertequals(loginVerify);
		return this;
	}

	private void assertequals(boolean loginVerify) {
		// TODO Auto-generated method stub
		
	}

}
