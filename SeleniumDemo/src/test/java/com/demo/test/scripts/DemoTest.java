package com.demo.test.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.CommonUtils.Base;
import com.CommonUtils.Utils;
import com.demo.pages.LandingPage;

public class DemoTest extends Base {
	LandingPage lp;
	Utils ut;
	
	@Test
	public void logIn() throws InterruptedException, IOException {
		lp = new LandingPage();
		lp.validateTitle();
		lp.sendUserId();
		Thread.sleep(3000);
		lp.sendPassWord();
		Thread.sleep(2000);
		lp.clickLogin();
		Thread.sleep(5000);
	}

}
