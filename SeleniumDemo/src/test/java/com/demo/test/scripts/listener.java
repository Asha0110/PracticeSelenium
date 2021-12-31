package com.demo.test.scripts;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.CommonUtils.Base;

public class listener extends Base implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		try {
			ut.takeScreenShot("passed");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ut.takeScreenShot("failed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
