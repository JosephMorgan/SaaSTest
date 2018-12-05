package com.beeboxes.face.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Description: 基础页面
 * @author dengbin
 * @date 2018年12月1日
 * @time 下午6:49:53
 */
public class PageBase {
	public WebDriver driver;
	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String getPageSource() {
		return driver.getPageSource();
	}
	public void close() {
		this.driver.close();
	}

}
