package com.beeboxes.face.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Description: js的操作
 * @author dengbin
 * @date 2018年11月18日
 * @time 下午6:09:58
 */
public class JSExecutor {
	
	/** 通过js来点击元素 */
	public  static void excuteClick (WebDriver driver,WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", element);
	}

}
