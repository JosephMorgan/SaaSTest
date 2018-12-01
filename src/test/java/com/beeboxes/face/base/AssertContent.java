package com.beeboxes.face.base;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * Description: 断言
 * @author dengbin
 * @date 2018年11月30日
 * @time 下午10:29:19
 */
public class AssertContent {
	/** 通过窗口标题来断言,断言失败就截图 */
	public  static void assertByTitle (WebDriver driver,String title,String failPicName) {
		
		try {
			Assert.assertEquals(driver.getTitle(), title); 
		} catch (AssertionError e) {
			Reporter.log("断言失败了！在snapshot文件夹看"+failPicName+"文件。");
			Screenshot.snapshot((TakesScreenshot)driver, failPicName);
		}
		
	}
}