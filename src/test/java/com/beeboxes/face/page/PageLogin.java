package com.beeboxes.face.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.beeboxes.face.base.ReadXml;

/**
 * Description: SaaS-登录页-元素
 * 
 * @author dengbin
 * @date 2018年11月14日
 * @time 下午11:01:43
 */
public class PageLogin {
	public WebDriver driver;

	// 定义构造函数，函数参数赋值给类成员变量driver，初始化PageFactory
	public PageLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageSource() {
		return driver.getPageSource();
	}
	
	protected void load() {	
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	public void close() {
		this.driver.close();
	}

	By userName = By.name(ReadXml.getElementByName("登录页面", "登录账号"));
	
	public void inputUserName(String name) {
		driver.findElement(userName).sendKeys(name);
	}

}