package com.beeboxes.face.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

/**
 * Description: 用testng的一个监听器来监听错误时截图
 * @author dengbin
 * @date 2018年12月1日
 * @time 下午2:59:01
 */
public class DotTestListener extends TestListenerAdapter {
	@Override
	public void onTestFailure(ITestResult tr) {
		try {
			TestBase tb = (TestBase) tr.getInstance();
			WebDriver driver = tb.getDriver();
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");  //转换时间格式
			 String time = dateFormat.format(Calendar.getInstance().getTime());  //获取当前时间
			Reporter.log("出错时间："+time);
			Screenshot.snapshot((TakesScreenshot)driver);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

}
