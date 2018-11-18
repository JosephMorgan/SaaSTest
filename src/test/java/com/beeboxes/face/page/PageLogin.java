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
	public void close() {
		this.driver.close();
	}
	protected void load() {	
	}	
	public WebDriver getDriver() {
		return driver;
	}
	By userName = By.name(ReadXml.getElementByName("登录页面", "登录账号"));
	By password1 = By.name(ReadXml.getElementByName("登录页面","账号密码"));
	By rememberAccount = By.xpath(ReadXml.getElementByXpath("登录页面", "记住账号和密码"));
	By loginBtn = By.xpath(ReadXml.getElementByXpath("登录页面", "登录平台"));
	
	/** 登录页-输入用户名 */
	public void inputUserName(String name) {
		driver.findElement(userName).sendKeys(name);
	}
	
	/** 登录页-输入密码 */
	public void inputPassword(String password){
		driver.findElement(password1).sendKeys(password);
	}
	
	/** 登录页-点记住账号和密码 */
	public void clickRememberAccount(){
		driver.findElement(rememberAccount).click();;
	}
	
	/** 登录页-点登录按钮 */
	public void clickLoginBtn() {
		driver.findElement(loginBtn).click();
	}

}