package com.beeboxes.face.base;


import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Description: 监听断言失败时的截图
 * @author dengbin
 * @date 2018年11月30日
 * @time 下午11:46:39
 */
public class TestngRetryListener implements ITestListener {
	public WebDriver driver;
	 
	public void onTestFailure(ITestResult result) {
		Screenshot.snapshot((TakesScreenshot)driver, "失败");
		}

	public void onTestStart(ITestResult result) {
	}
 
	public void onTestSuccess(ITestResult result) {
	}
 
	public void onTestSkipped(ITestResult result) {
	}
 
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
	@Override
	public void onStart(ITestContext context) {
	}


	@Override
	public void onFinish(ITestContext context) {

	}
}

